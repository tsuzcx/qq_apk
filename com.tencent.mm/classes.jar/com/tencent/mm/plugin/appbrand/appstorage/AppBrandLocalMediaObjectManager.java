package com.tencent.mm.plugin.appbrand.appstorage;

import android.annotation.TargetApi;
import android.support.annotation.Keep;
import android.system.Os;
import com.tencent.mm.plugin.appbrand.v.m;
import com.tencent.mm.plugin.appbrand.v.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

@Deprecated
@Keep
public final class AppBrandLocalMediaObjectManager
{
  private static final Collection<a> MEDIA_OBJECT_INFO_HANDLERS;
  private static final AppBrandLocalMediaObject Nil = new AppBrandLocalMediaObjectManager.3();
  public static final String OBJECT_NAME_PREFIX = "wxfile://";
  static final String OBJECT_ROOT_DIR_PATH;
  static final String PREFIX_STORE_FILE = "store_";
  static final String PREFIX_TEMP_FILE = "tmp_";
  static final String SUFFIX_PERMANENT_FILE = ".dat";
  static final String SUFFIX_TEMP_FILE = ".tmp";
  private static final String TAG = "MicroMsg.AppBrand.LocalMediaObjectManager";
  
  static
  {
    String str = com.tencent.mm.compatible.util.e.bkH;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    OBJECT_ROOT_DIR_PATH = (String)localObject + "wxafiles/";
    localObject = new LinkedList();
    ((Collection)localObject).add(new c((byte)0));
    MEDIA_OBJECT_INFO_HANDLERS = Collections.unmodifiableCollection((Collection)localObject);
  }
  
  public static AppBrandLocalMediaObject attach(String paramString1, String paramString2)
  {
    return attach(paramString1, paramString2, null, false);
  }
  
  public static AppBrandLocalMediaObject attach(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return attachCast(paramString1, paramString2, AppBrandLocalMediaObject.class, paramString3, paramBoolean);
  }
  
  public static AppBrandLocalMediaObject attach(String paramString1, String paramString2, boolean paramBoolean)
  {
    return attach(paramString1, paramString2, null, paramBoolean);
  }
  
  private static <T extends AppBrandLocalMediaObject> T attachCast(String paramString1, String paramString2, Class<T> paramClass, String paramString3, boolean paramBoolean)
  {
    if (bk.bl(paramString1)) {}
    do
    {
      do
      {
        return null;
      } while (!com.tencent.mm.a.e.bK(paramString2));
      String str = nilAs(org.a.a.a.a.aho(paramString2), paramString3);
      Iterator localIterator = MEDIA_OBJECT_INFO_HANDLERS.iterator();
      paramString3 = null;
      while (localIterator.hasNext())
      {
        com.tencent.mm.vending.j.a locala = ((a)localIterator.next()).z(paramString1, paramString2, str);
        paramString3 = locala;
        if (locala != null) {
          paramString3 = locala;
        }
      }
      if ((paramString3 == null) || (paramString3.size() < 2))
      {
        if (paramString3 == null) {}
        for (int i = -1;; i = paramString3.size())
        {
          y.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
          return null;
        }
      }
      try
      {
        paramString1 = (AppBrandLocalMediaObject)paramClass.newInstance();
        paramString1.bMB = ((String)paramString3.get(0));
        paramString1.mimeType = m.wJ(str);
        paramString1.dXY = ((String)paramString3.get(1));
        if (bk.bl(paramString1.dXY))
        {
          y.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
          return null;
        }
      }
      catch (Exception paramString1)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager", paramString1, "", new Object[0]);
        return null;
      }
      paramString1.fGv = bk.aM((String)paramString3.get(3), bk.aM(str, "unknown"));
    } while (!createLocalFileLink(paramBoolean, paramString2, paramString1.dXY));
    paramString2 = new File(paramString1.dXY);
    paramString1.eUd = paramString2.length();
    paramString1.fGx = paramString2.lastModified();
    return paramString1;
  }
  
  public static AppBrandLocalVideoObject attachVideo(String paramString1, String paramString2)
  {
    return (AppBrandLocalVideoObject)attachCast(paramString1, paramString2, AppBrandLocalVideoObject.class, "mp4", false);
  }
  
  public static void clear(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    com.tencent.mm.a.e.bL(getParentDirWithoutCheckExistence(paramString));
  }
  
  private static boolean createLocalFileLink(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (g.bd(paramString1, paramString2))) {}
    while ((!paramBoolean) && (j.copyFile(paramString1, paramString2))) {
      return true;
    }
    return false;
  }
  
  private static String decrypt(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = bk.ZM(paramString1);
    paramString2 = new q().decrypt(arrayOfByte, paramString2.getBytes());
    if (bk.bl(paramString1)) {
      return null;
    }
    return new String(paramString2);
  }
  
  private static String encrypt(String paramString1, String paramString2)
  {
    return bk.bG(new q().encrypt(paramString1.getBytes(), paramString2.getBytes()));
  }
  
  @Keep
  public static String genMediaFilePath(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return null;
    }
    return getParentDir(paramString1) + paramString2;
  }
  
  private static long getCRC(String paramString)
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
  
  private static AppBrandLocalMediaObject getInfoByRealFileName(String paramString1, String paramString2)
  {
    AppBrandLocalMediaObject localAppBrandLocalMediaObject = null;
    Iterator localIterator = null;
    Object localObject = localIterator;
    if (!bk.bl(paramString1)) {
      if (!bk.bl(paramString2)) {
        break label27;
      }
    }
    label27:
    do
    {
      for (localObject = localIterator; !localIterator.hasNext(); localObject = localAppBrandLocalMediaObject)
      {
        return localObject;
        localIterator = MEDIA_OBJECT_INFO_HANDLERS.iterator();
      }
      localAppBrandLocalMediaObject = ((a)localIterator.next()).bc(paramString1, paramString2);
      localObject = localAppBrandLocalMediaObject;
    } while (localAppBrandLocalMediaObject == null);
    return localAppBrandLocalMediaObject;
  }
  
  @Deprecated
  public static AppBrandLocalMediaObject getItemByLocalId(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString2)) || (!paramString2.startsWith("wxfile://")) || (bk.bl(paramString1))) {
      y.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[] { paramString2, paramString1 });
    }
    label134:
    for (;;)
    {
      return null;
      String str = paramString2.substring(9);
      Iterator localIterator = MEDIA_OBJECT_INFO_HANDLERS.iterator();
      paramString2 = null;
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        paramString2 = locala.bb(paramString1, str);
        if (paramString2 != null) {
          y.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString2 });
        }
      }
      for (;;)
      {
        if (Nil == paramString2) {
          break label134;
        }
        return paramString2;
        break;
      }
    }
  }
  
  private static String getParentDir(String paramString)
  {
    paramString = getParentDirWithoutCheckExistence(paramString);
    h.Vu(paramString);
    try
    {
      new File(paramString, ".nomedia").createNewFile();
      return paramString;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  private static String getParentDirWithoutCheckExistence(String paramString)
  {
    return OBJECT_ROOT_DIR_PATH + paramString + "/";
  }
  
  public static long getStoredFilesOccupation(String paramString)
  {
    long l1 = 0L;
    paramString = listStoredRawFiles(paramString);
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.length <= 0) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      l1 += paramString[i].length();
      i += 1;
    }
  }
  
  public static long getTmpFilesOccupation(String paramString)
  {
    long l1 = 0L;
    paramString = listTmpRawFiles(paramString);
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.length <= 0) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      l1 += paramString[i].length();
      i += 1;
    }
  }
  
  public static List<AppBrandLocalMediaObject> listStoredFiles(String paramString)
  {
    File[] arrayOfFile = listStoredRawFiles(paramString);
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
      localObject = getInfoByRealFileName(paramString, arrayOfFile[i].getName());
      if (localObject != null) {
        localLinkedList.add(localObject);
      }
      i += 1;
    }
  }
  
  private static File[] listStoredRawFiles(String paramString)
  {
    paramString = new File(getParentDir(paramString));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      return null;
    }
    return paramString.listFiles(new AppBrandLocalMediaObjectManager.1());
  }
  
  public static List<AppBrandLocalMediaObject> listTmpFiles(String paramString)
  {
    File[] arrayOfFile = listTmpRawFiles(paramString);
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
      localObject = getInfoByRealFileName(paramString, arrayOfFile[i].getName());
      if (localObject != null) {
        localLinkedList.add(localObject);
      }
      i += 1;
    }
  }
  
  private static File[] listTmpRawFiles(String paramString)
  {
    paramString = new File(getParentDir(paramString));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      return null;
    }
    return paramString.listFiles(new AppBrandLocalMediaObjectManager.2());
  }
  
  public static AppBrandLocalMediaObject markPermanent(String paramString, AppBrandLocalMediaObject paramAppBrandLocalMediaObject)
  {
    paramString = null;
    Iterator localIterator = MEDIA_OBJECT_INFO_HANDLERS.iterator();
    while (localIterator.hasNext())
    {
      AppBrandLocalMediaObject localAppBrandLocalMediaObject = ((a)localIterator.next()).a(paramAppBrandLocalMediaObject);
      paramString = localAppBrandLocalMediaObject;
      if (localAppBrandLocalMediaObject != null) {
        paramString = localAppBrandLocalMediaObject;
      }
    }
    return paramString;
  }
  
  private static String nilAs(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  @TargetApi(21)
  private static void symlinkOs(String paramString1, String paramString2)
  {
    new b((byte)0);
    Os.symlink(paramString1, paramString2);
  }
  
  private static abstract interface a
  {
    public abstract AppBrandLocalMediaObject a(AppBrandLocalMediaObject paramAppBrandLocalMediaObject);
    
    public abstract AppBrandLocalMediaObject bb(String paramString1, String paramString2);
    
    public abstract AppBrandLocalMediaObject bc(String paramString1, String paramString2);
    
    public abstract com.tencent.mm.vending.j.a z(String paramString1, String paramString2, String paramString3);
  }
  
  private static final class b {}
  
  private static final class c
    implements AppBrandLocalMediaObjectManager.a
  {
    public final AppBrandLocalMediaObject a(AppBrandLocalMediaObject paramAppBrandLocalMediaObject)
    {
      if (paramAppBrandLocalMediaObject == null) {}
      String str;
      do
      {
        return null;
        str = paramAppBrandLocalMediaObject.dXY.replaceFirst("tmp_", "store_");
      } while (!g.bd(paramAppBrandLocalMediaObject.dXY, str));
      AppBrandLocalMediaObject localAppBrandLocalMediaObject = new AppBrandLocalMediaObject();
      localAppBrandLocalMediaObject.dXY = str;
      localAppBrandLocalMediaObject.bMB = paramAppBrandLocalMediaObject.bMB.replaceFirst("tmp_", "store_");
      localAppBrandLocalMediaObject.eUd = paramAppBrandLocalMediaObject.eUd;
      localAppBrandLocalMediaObject.fGv = paramAppBrandLocalMediaObject.fGv;
      localAppBrandLocalMediaObject.fGx = new File(localAppBrandLocalMediaObject.dXY).lastModified();
      localAppBrandLocalMediaObject.mimeType = paramAppBrandLocalMediaObject.mimeType;
      localAppBrandLocalMediaObject.fGw = true;
      return localAppBrandLocalMediaObject;
    }
    
    public final AppBrandLocalMediaObject bb(String paramString1, String paramString2)
    {
      Object localObject1 = null;
      if ((!paramString2.startsWith("store_")) && (!paramString2.startsWith("tmp_"))) {
        return null;
      }
      String str3 = org.a.a.a.a.aho(paramString2);
      String str2 = paramString2.replaceFirst("store_", "").replaceFirst("tmp_", "");
      String str1 = str2;
      if (!bk.bl(str3)) {
        str1 = str2.replaceFirst("." + str3, "");
      }
      if (bk.bl(str1)) {
        return AppBrandLocalMediaObjectManager.Nil;
      }
      try
      {
        str2 = AppBrandLocalMediaObjectManager.decrypt(str1, paramString1);
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObject, decrypt exp ", new Object[0]);
        }
        Object localObject2 = ((String)localObject1).split("\\|");
        if ((localObject2 != null) && (localObject2.length == 2)) {
          break label170;
        }
        return AppBrandLocalMediaObjectManager.Nil;
        label170:
        if (!paramString2.startsWith("store_")) {
          break label241;
        }
        long l1;
        label241:
        for (localObject1 = "store_";; localObject1 = "tmp_")
        {
          str1 = AppBrandLocalMediaObjectManager.getParentDir(paramString1) + (String)localObject1 + str1;
          l1 = bk.getLong(localObject2[0], 0L);
          localObject2 = localObject2[1];
          if (((String)localObject2).equalsIgnoreCase(str3)) {
            break;
          }
          return AppBrandLocalMediaObjectManager.Nil;
        }
        try
        {
          long l2 = AppBrandLocalMediaObjectManager.getCRC(str1);
          if (l1 != l2)
          {
            y.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString2, paramString1 });
            paramString1 = AppBrandLocalMediaObjectManager.Nil;
            return paramString1;
          }
        }
        catch (IOException paramString1)
        {
          y.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { bk.j(paramString1) });
          return AppBrandLocalMediaObjectManager.Nil;
        }
        paramString1 = new AppBrandLocalMediaObject();
        paramString1.bMB = ("wxfile://" + paramString2);
        paramString1.dXY = str1;
        paramString1.mimeType = m.wJ((String)localObject2);
        paramString1.fGw = ((String)localObject1).equalsIgnoreCase("store_");
        paramString2 = new File(paramString1.dXY);
        paramString1.fGx = paramString2.lastModified();
        paramString1.eUd = paramString2.length();
      }
      if (bk.bl((String)localObject1))
      {
        y.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        return AppBrandLocalMediaObjectManager.Nil;
      }
      return paramString1;
    }
    
    public final AppBrandLocalMediaObject bc(String paramString1, String paramString2)
    {
      String str2 = paramString2.replaceFirst("store_", "").replaceFirst("tmp_", "");
      Object localObject2;
      try
      {
        String str1 = AppBrandLocalMediaObjectManager.decrypt(str2, paramString1);
        if (bk.bl(str1)) {
          return null;
        }
      }
      catch (Exception localException)
      {
        do
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
            localObject1 = null;
          }
          localObject1 = ((String)localObject1).split("\\|");
        } while ((localObject1 == null) || (localObject1.length != 2));
        localObject1 = localObject1[1];
        localObject2 = new StringBuilder("wxfile://").append(paramString2);
        if (!bk.bl((String)localObject1)) {}
      }
      for (Object localObject1 = "";; localObject1 = "." + (String)localObject1)
      {
        localObject2 = (String)localObject1;
        localObject1 = new AppBrandLocalMediaObject();
        ((AppBrandLocalMediaObject)localObject1).bMB = ((String)localObject2);
        ((AppBrandLocalMediaObject)localObject1).dXY = (AppBrandLocalMediaObjectManager.getParentDir(paramString1) + paramString2);
        ((AppBrandLocalMediaObject)localObject1).fGv = str2;
        ((AppBrandLocalMediaObject)localObject1).fGw = paramString2.equalsIgnoreCase("store_");
        paramString1 = new File(((AppBrandLocalMediaObject)localObject1).dXY);
        ((AppBrandLocalMediaObject)localObject1).fGx = paramString1.lastModified();
        ((AppBrandLocalMediaObject)localObject1).eUd = paramString1.length();
        return localObject1;
      }
    }
    
    public final String toString()
    {
      return "V2MediaObjectInfoHandler";
    }
    
    /* Error */
    public final com.tencent.mm.vending.j.a z(String paramString1, String paramString2, String paramString3)
    {
      // Byte code:
      //   0: aload_3
      //   1: ldc 187
      //   3: invokestatic 190	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   6: astore_3
      //   7: aload_2
      //   8: invokestatic 150	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:access$500	(Ljava/lang/String;)J
      //   11: lstore 4
      //   13: getstatic 196	java/util/Locale:US	Ljava/util/Locale;
      //   16: ldc 198
      //   18: iconst_2
      //   19: anewarray 4	java/lang/Object
      //   22: dup
      //   23: iconst_0
      //   24: lload 4
      //   26: invokestatic 158	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   29: aastore
      //   30: dup
      //   31: iconst_1
      //   32: aload_3
      //   33: aastore
      //   34: invokestatic 202	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   37: astore_2
      //   38: aload_2
      //   39: aload_1
      //   40: invokestatic 205	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:access$600	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   43: astore_2
      //   44: aload_2
      //   45: invokestatic 93	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
      //   48: ifeq +44 -> 92
      //   51: aconst_null
      //   52: areturn
      //   53: astore_1
      //   54: ldc 115
      //   56: ldc 207
      //   58: iconst_1
      //   59: anewarray 4	java/lang/Object
      //   62: dup
      //   63: iconst_0
      //   64: aload_1
      //   65: invokestatic 168	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   68: aastore
      //   69: invokestatic 162	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   72: aconst_null
      //   73: areturn
      //   74: astore_2
      //   75: ldc 115
      //   77: aload_2
      //   78: ldc 209
      //   80: iconst_0
      //   81: anewarray 4	java/lang/Object
      //   84: invokestatic 129	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   87: aconst_null
      //   88: astore_2
      //   89: goto -45 -> 44
      //   92: new 95	java/lang/StringBuilder
      //   95: dup
      //   96: ldc 26
      //   98: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   101: aload_2
      //   102: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   108: astore 6
      //   110: new 95	java/lang/StringBuilder
      //   113: dup
      //   114: invokespecial 136	java/lang/StringBuilder:<init>	()V
      //   117: aload_1
      //   118: invokestatic 139	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:access$400	(Ljava/lang/String;)Ljava/lang/String;
      //   121: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   124: aload 6
      //   126: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   129: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   132: astore_2
      //   133: new 95	java/lang/StringBuilder
      //   136: dup
      //   137: ldc 170
      //   139: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   142: aload 6
      //   144: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   147: astore 6
      //   149: aload_3
      //   150: invokestatic 93	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
      //   153: ifeq +42 -> 195
      //   156: ldc 88
      //   158: astore_1
      //   159: aload 6
      //   161: aload_1
      //   162: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   165: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   168: astore_1
      //   169: ldc 115
      //   171: ldc 211
      //   173: iconst_2
      //   174: anewarray 4	java/lang/Object
      //   177: dup
      //   178: iconst_0
      //   179: aload_1
      //   180: aastore
      //   181: dup
      //   182: iconst_1
      //   183: aload_2
      //   184: aastore
      //   185: invokestatic 213	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   188: aload_1
      //   189: aload_2
      //   190: aload_3
      //   191: invokestatic 218	com/tencent/mm/vending/j/a:d	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   194: areturn
      //   195: new 95	java/lang/StringBuilder
      //   198: dup
      //   199: ldc 97
      //   201: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   204: aload_3
      //   205: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   208: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   211: astore_1
      //   212: goto -53 -> 159
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	215	0	this	c
      //   0	215	1	paramString1	String
      //   0	215	2	paramString2	String
      //   0	215	3	paramString3	String
      //   11	14	4	l	long
      //   108	52	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	13	53	java/lang/Exception
      //   38	44	74	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager
 * JD-Core Version:    0.7.0.1
 */