package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class j
  extends e
{
  public final LuggageLocalFileObjectManager fHk;
  public volatile long fHl = -1L;
  private final String mObfuscationKey;
  private final String mObjectIdPrefix;
  private final String mRootPath;
  
  public j(String paramString1, String paramString2, String paramString3)
  {
    this.mRootPath = new File(paramString1).getAbsolutePath();
    this.mObfuscationKey = paramString2;
    this.mObjectIdPrefix = paramString3;
    this.fHk = new LuggageLocalFileObjectManager(this.mRootPath, this.mObfuscationKey, this.mObjectIdPrefix);
  }
  
  public final h a(k<String> paramk)
  {
    paramk.value = this.mRootPath;
    return h.fGU;
  }
  
  public final h a(File paramFile, String paramString, k<String> paramk)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return h.fGV;
    }
    if ((!TextUtils.isEmpty(paramString)) || (paramk == null)) {
      return h.fHi;
    }
    if ((this.fHl > 0L) && (this.fHk.getStoredFilesOccupation() + paramFile.length() > this.fHl)) {
      return h.fHh;
    }
    if (this.fHk.getInfoByRealFileName(paramFile.getName()) != null)
    {
      paramFile = this.fHk.getInfoByRealFileName(paramFile.getName());
      if (paramFile.fGw)
      {
        paramk.value = paramFile.bMB;
        return h.fGU;
      }
      paramk.value = this.fHk.markPermanent(paramFile).bMB;
      return h.fGU;
    }
    paramFile = this.fHk.attach(paramFile.getAbsolutePath());
    paramk.value = this.fHk.markPermanent(paramFile).bMB;
    return h.fGU;
  }
  
  public final h a(File paramFile, String paramString, boolean paramBoolean, k<String> paramk)
  {
    paramFile = this.fHk.attach(paramFile.getAbsolutePath(), paramString, paramBoolean);
    if (paramFile == null) {
      return h.fGV;
    }
    paramk.value = paramFile.bMB;
    return h.fGU;
  }
  
  public final h a(String paramString, FileStructStat paramFileStructStat)
  {
    paramString = this.fHk.getItemByLocalId(paramString);
    if ((paramString == null) || (!com.tencent.mm.a.e.bK(paramString.dXY))) {
      return h.fHa;
    }
    if (paramFileStructStat == null) {
      return h.fGV;
    }
    if (FileStat.stat(paramString.dXY, paramFileStructStat) == 0) {
      return h.fGU;
    }
    return h.fGV;
  }
  
  public final h a(String paramString, k<List<f>> paramk)
  {
    Object localObject = new LinkedList();
    com.tencent.luggage.j.b.c((List)localObject, this.fHk.listStoredFiles());
    com.tencent.luggage.j.b.c((List)localObject, this.fHk.listTmpFiles());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      o localo = (o)((Iterator)localObject).next();
      f localf = new f();
      localf.fileName = localo.bMB;
      paramString.add(localf);
    }
    paramk.value = paramString;
    return h.fGU;
  }
  
  public final List<o> acI()
  {
    return this.fHk.listStoredFiles();
  }
  
  public final h b(String paramString, k<ByteBuffer> paramk)
  {
    paramString = this.fHk.getItemByLocalId(paramString);
    if ((paramString == null) || (!com.tencent.mm.a.e.bK(paramString.dXY))) {
      return h.fHa;
    }
    paramk.value = i.u(new File(paramString.dXY));
    return h.fGU;
  }
  
  public final boolean bs(String paramString)
  {
    return bk.pm(paramString).startsWith(this.mObjectIdPrefix);
  }
  
  public final void initialize()
  {
    if (!com.tencent.mm.vfs.e.nb(this.mRootPath)) {
      c.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
  }
  
  public final h ru(String paramString)
  {
    paramString = this.fHk.getItemByLocalId(paramString);
    if ((paramString == null) || (!com.tencent.mm.a.e.bK(paramString.dXY))) {
      return h.fHa;
    }
    return h.fGU;
  }
  
  public final h rw(String paramString)
  {
    o localo = this.fHk.getItemByLocalId(paramString);
    if (localo != null)
    {
      com.tencent.mm.vfs.e.deleteFile(localo.dXY);
      if (com.tencent.mm.vfs.e.bK(localo.dXY))
      {
        c.e("MicroMsg.Luggage.FlattenFileSystem", "delete file failed, id %s, path %s", new Object[] { paramString, localo.dXY });
        return h.fGV;
      }
    }
    return h.fGU;
  }
  
  public final File rx(String paramString)
  {
    paramString = this.fHk.getItemByLocalId(paramString);
    if (paramString == null) {
      return null;
    }
    return new File(paramString.dXY);
  }
  
  public final com.tencent.mm.vfs.b ry(String paramString)
  {
    com.tencent.mm.vfs.e.nb(this.mRootPath);
    return new com.tencent.mm.vfs.b(this.mRootPath + "/" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.j
 * JD-Core Version:    0.7.0.1
 */