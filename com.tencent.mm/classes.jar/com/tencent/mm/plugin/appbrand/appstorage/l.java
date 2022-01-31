package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Environment;
import com.tencent.luggage.j.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class l
  implements k
{
  public final LinkedList<k> fHm = new LinkedList();
  private final k fHn = new e();
  
  public l(String paramString)
  {
    Object localObject1 = new File(Environment.getExternalStorageDirectory(), "luggage/" + paramString);
    paramString = this.fHm;
    Object localObject2 = ((File)localObject1).getAbsolutePath();
    localObject1 = new j(new File((String)localObject2, "objects/").getAbsolutePath(), "default_obfuscation_key", "wxfile://");
    localObject2 = new q(new File((String)localObject2, "files/").getAbsolutePath());
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localObject1);
    localLinkedList.add(localObject2);
    paramString.addAll(localLinkedList);
  }
  
  private k rB(String paramString)
  {
    if (bk.bl(paramString)) {
      return this.fHn;
    }
    Iterator localIterator = this.fHm.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.bs(paramString)) {
        return localk;
      }
    }
    return this.fHn;
  }
  
  public final <T extends k> T H(Class<T> paramClass)
  {
    Iterator localIterator = this.fHm.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (paramClass.isInstance(localk)) {
        return localk;
      }
    }
    return null;
  }
  
  public final h U(String paramString, boolean paramBoolean)
  {
    return rB(paramString).U(paramString, paramBoolean);
  }
  
  public final h V(String paramString, boolean paramBoolean)
  {
    return rB(paramString).V(paramString, paramBoolean);
  }
  
  public final h a(com.tencent.mm.plugin.appbrand.u.k<String> paramk)
  {
    Iterator localIterator = this.fHm.iterator();
    while (localIterator.hasNext())
    {
      h localh = ((k)localIterator.next()).a(paramk);
      if (localh != h.fHi) {
        return localh;
      }
    }
    return h.fHi;
  }
  
  public final h a(File paramFile, String paramString, com.tencent.mm.plugin.appbrand.u.k<String> paramk)
  {
    Iterator localIterator = this.fHm.iterator();
    while (localIterator.hasNext())
    {
      h localh = ((k)localIterator.next()).a(paramFile, paramString, paramk);
      if (localh != h.fHi) {
        return localh;
      }
    }
    return h.fHi;
  }
  
  public h a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.u.k<String> paramk)
  {
    Iterator localIterator = this.fHm.iterator();
    while (localIterator.hasNext())
    {
      h localh = ((k)localIterator.next()).a(paramFile, paramString, paramBoolean, paramk);
      if (localh != h.fHi) {
        return localh;
      }
    }
    return h.fHi;
  }
  
  public final h a(String paramString, FileStructStat paramFileStructStat)
  {
    return rB(paramString).a(paramString, paramFileStructStat);
  }
  
  public h a(String paramString, com.tencent.mm.plugin.appbrand.u.k<List<f>> paramk)
  {
    return rB(paramString).a(paramString, paramk);
  }
  
  public final h a(String paramString, File paramFile, boolean paramBoolean)
  {
    return rB(paramString).a(paramString, paramFile, paramBoolean);
  }
  
  public final h a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return rB(paramString).a(paramString, paramInputStream, paramBoolean);
  }
  
  public List<? extends k.a> acI()
  {
    return ((j)H(j.class)).fHk.listStoredFiles();
  }
  
  public final h b(String paramString, com.tencent.mm.plugin.appbrand.u.k<ByteBuffer> paramk)
  {
    return rB(paramString).b(paramString, paramk);
  }
  
  public final h b(String paramString, File paramFile)
  {
    return rB(paramString).b(paramString, paramFile);
  }
  
  public final boolean bs(String paramString)
  {
    int i = 0;
    while (i < 3)
    {
      if (g.n(paramString, new String[] { "file://", "http://", "https://" }[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final h g(String paramString, List<n> paramList)
  {
    return rB(paramString).g(paramString, paramList);
  }
  
  public final void initialize()
  {
    Iterator localIterator = this.fHm.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).initialize();
    }
    this.fHn.initialize();
  }
  
  public final void release()
  {
    Iterator localIterator = this.fHm.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).release();
    }
    this.fHn.release();
  }
  
  public final h ru(String paramString)
  {
    return rB(paramString).ru(paramString);
  }
  
  public final h rv(String paramString)
  {
    return rB(paramString).rv(paramString);
  }
  
  public final h rw(String paramString)
  {
    return rB(paramString).rw(paramString);
  }
  
  public final File rx(String paramString)
  {
    return rB(paramString).rx(paramString);
  }
  
  public b ry(String paramString)
  {
    return ((j)H(j.class)).ry(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l
 * JD-Core Version:    0.7.0.1
 */