package com.tencent.mm.plugin.appbrand.appstorage;

import android.annotation.TargetApi;
import android.support.annotation.Keep;
import android.system.Os;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.v.m;
import com.tencent.mm.plugin.appbrand.v.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

@Keep
public final class LuggageLocalFileObjectManager
{
  private static final o Nil = new LuggageLocalFileObjectManager.3();
  static final String PREFIX_STORE_FILE = "store_";
  static final String PREFIX_TEMP_FILE = "tmp_";
  static final String SUFFIX_PERMANENT_FILE = ".dat";
  static final String SUFFIX_TEMP_FILE = ".tmp";
  private static final String TAG = "MicroMsg.AppBrand.LuggageLocalFileObjectManager";
  private final Collection<LuggageLocalFileObjectManager.a> mMediaObjectInfoHandlers;
  private final String mObfuscationKey;
  private final String mObjectIdPrefix;
  private final String mRootPath;
  
  LuggageLocalFileObjectManager(String paramString1, String paramString2, String paramString3)
  {
    this.mRootPath = (new File(paramString1).getAbsolutePath() + "/");
    this.mObfuscationKey = paramString2;
    this.mObjectIdPrefix = paramString3;
    paramString1 = new LinkedList();
    paramString1.add(new LuggageLocalFileObjectManager.c(this, (byte)0));
    this.mMediaObjectInfoHandlers = Collections.unmodifiableCollection(paramString1);
  }
  
  private <T extends o> T attachCast(String paramString1, Class<T> paramClass, String paramString2, boolean paramBoolean)
  {
    if (!e.bK(paramString1)) {}
    do
    {
      return null;
      String str = nilAs(org.a.a.a.a.aho(paramString1), paramString2);
      Iterator localIterator = this.mMediaObjectInfoHandlers.iterator();
      paramString2 = null;
      while (localIterator.hasNext())
      {
        com.tencent.mm.vending.j.a locala = ((LuggageLocalFileObjectManager.a)localIterator.next()).be(paramString1, str);
        paramString2 = locala;
        if (locala != null) {
          paramString2 = locala;
        }
      }
      if ((paramString2 == null) || (paramString2.size() < 2))
      {
        if (paramString2 == null) {}
        for (int i = -1;; i = paramString2.size())
        {
          y.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
          return null;
        }
      }
      try
      {
        paramClass = (o)paramClass.newInstance();
        paramClass.bMB = ((String)paramString2.get(0));
        paramClass.mimeType = m.wJ(str);
        paramClass.dXY = ((String)paramString2.get(1));
        if (bk.bl(paramClass.dXY))
        {
          y.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
          return null;
        }
      }
      catch (Exception paramString1)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.LuggageLocalFileObjectManager", paramString1, "", new Object[0]);
        return null;
      }
      paramClass.fGv = bk.aM((String)paramString2.get(3), bk.aM(str, "unknown"));
    } while (!createLocalFileLink(paramBoolean, paramString1, paramClass.dXY));
    paramString1 = new File(paramClass.dXY);
    paramClass.eUd = paramString1.length();
    paramClass.fGx = paramString1.lastModified();
    return paramClass;
  }
  
  private boolean createLocalFileLink(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (g.bd(paramString1, paramString2))) {}
    while ((!paramBoolean) && (j.copyFile(paramString1, paramString2))) {
      return true;
    }
    return false;
  }
  
  private String decrypt(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = bk.ZM(paramString1);
    paramString2 = new q().decrypt(arrayOfByte, paramString2.getBytes());
    if (bk.bl(paramString1)) {
      return null;
    }
    return new String(paramString2);
  }
  
  private String encrypt(String paramString1, String paramString2)
  {
    return bk.bG(new q().encrypt(paramString1.getBytes(), paramString2.getBytes()));
  }
  
  private long getCRC(String paramString)
  {
    paramString = new FileInputStream(paramString);
    CheckedInputStream localCheckedInputStream = new CheckedInputStream(paramString, new Adler32());
    byte[] arrayOfByte = new byte[2048];
    while (localCheckedInputStream.read(arrayOfByte) >= 0) {}
    long l = localCheckedInputStream.getChecksum().getValue();
    bk.b(localCheckedInputStream);
    bk.b(paramString);
    return l;
  }
  
  private String getParentDir()
  {
    h.Vu(getParentDirWithoutCheckExistence());
    try
    {
      new File(this.mRootPath, ".nomedia").createNewFile();
      label26:
      return this.mRootPath;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  private String getParentDirWithoutCheckExistence()
  {
    return this.mRootPath;
  }
  
  private File[] listTmpRawFiles()
  {
    File localFile = new File(getParentDir());
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    return localFile.listFiles(new LuggageLocalFileObjectManager.2(this));
  }
  
  private String nilAs(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  @TargetApi(21)
  private void symlinkOs(String paramString1, String paramString2)
  {
    new LuggageLocalFileObjectManager.b((byte)0);
    Os.symlink(paramString1, paramString2);
  }
  
  public final o attach(String paramString)
  {
    return attach(paramString, null, false);
  }
  
  public final o attach(String paramString1, String paramString2, boolean paramBoolean)
  {
    return attachCast(paramString1, o.class, paramString2, paramBoolean);
  }
  
  public final o attach(String paramString, boolean paramBoolean)
  {
    return attach(paramString, null, paramBoolean);
  }
  
  public final p attachVideo(String paramString)
  {
    return (p)attachCast(paramString, p.class, "mp4", false);
  }
  
  public final void clear(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    e.bL(getParentDirWithoutCheckExistence());
  }
  
  @Keep
  public final String genMediaFilePath(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return getParentDir() + paramString;
  }
  
  final o getInfoByRealFileName(String paramString)
  {
    Object localObject = null;
    o localo = null;
    if (bk.bl(paramString)) {}
    do
    {
      localObject = localo;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return localObject;
        localIterator = this.mMediaObjectInfoHandlers.iterator();
      }
      localo = ((LuggageLocalFileObjectManager.a)localIterator.next()).rD(paramString);
      localObject = localo;
    } while (localo == null);
    return localo;
  }
  
  @Deprecated
  public final o getItemByLocalId(String paramString)
  {
    if ((bk.bl(paramString)) || (!paramString.startsWith(this.mObjectIdPrefix))) {
      y.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", new Object[] { paramString });
    }
    label130:
    for (;;)
    {
      return null;
      String str = paramString.substring(this.mObjectIdPrefix.length());
      Iterator localIterator = this.mMediaObjectInfoHandlers.iterator();
      paramString = null;
      if (localIterator.hasNext())
      {
        LuggageLocalFileObjectManager.a locala = (LuggageLocalFileObjectManager.a)localIterator.next();
        paramString = locala.rC(str);
        if (paramString != null) {
          y.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString });
        }
      }
      for (;;)
      {
        if (Nil == paramString) {
          break label130;
        }
        return paramString;
        break;
      }
    }
  }
  
  public final long getStoredFilesOccupation()
  {
    long l1 = 0L;
    File[] arrayOfFile = listStoredRawFiles();
    long l2 = l1;
    if (arrayOfFile != null)
    {
      if (arrayOfFile.length <= 0) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      l1 += arrayOfFile[i].length();
      i += 1;
    }
  }
  
  public final long getTmpFilesOccupation()
  {
    long l1 = 0L;
    File[] arrayOfFile = listTmpRawFiles();
    long l2 = l1;
    if (arrayOfFile != null)
    {
      if (arrayOfFile.length <= 0) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      l1 += arrayOfFile[i].length();
      i += 1;
    }
  }
  
  public final List<o> listStoredFiles()
  {
    File[] arrayOfFile = listStoredRawFiles();
    Object localObject;
    if ((arrayOfFile == null) || (arrayOfFile.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      localObject = localLinkedList;
      if (i >= j) {
        break;
      }
      localObject = getInfoByRealFileName(arrayOfFile[i].getName());
      if (localObject != null) {
        localLinkedList.add(localObject);
      }
      i += 1;
    }
  }
  
  final File[] listStoredRawFiles()
  {
    File localFile = new File(getParentDir());
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    return localFile.listFiles(new LuggageLocalFileObjectManager.1(this));
  }
  
  public final List<o> listTmpFiles()
  {
    File[] arrayOfFile = listTmpRawFiles();
    Object localObject;
    if ((arrayOfFile == null) || (arrayOfFile.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      localObject = localLinkedList;
      if (i >= j) {
        break;
      }
      localObject = getInfoByRealFileName(arrayOfFile[i].getName());
      if (localObject != null) {
        localLinkedList.add(localObject);
      }
      i += 1;
    }
  }
  
  public final o markPermanent(o paramo)
  {
    Object localObject = null;
    Iterator localIterator = this.mMediaObjectInfoHandlers.iterator();
    while (localIterator.hasNext())
    {
      o localo = ((LuggageLocalFileObjectManager.a)localIterator.next()).markPermanent(paramo);
      localObject = localo;
      if (localo != null) {
        localObject = localo;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager
 * JD-Core Version:    0.7.0.1
 */