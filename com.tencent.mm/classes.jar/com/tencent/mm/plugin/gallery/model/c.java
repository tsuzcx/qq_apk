package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c
{
  public d sIY;
  int sIZ;
  public h<String> sJa;
  public HashMap<String, c> sJb;
  int sJc;
  private h<b> sJd;
  h<b> sJe;
  
  public c()
  {
    AppMethodBeat.i(111240);
    this.sIY = new d();
    this.sIZ = g.DEFAULT_CORE_POOL_SIZE;
    this.sJa = new h();
    this.sJb = new HashMap();
    this.sJc = (g.DEFAULT_CORE_POOL_SIZE / 2);
    this.sJd = new h();
    this.sJe = new h();
    AppMethodBeat.o(111240);
  }
  
  public final Bitmap a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(179444);
    paramString1 = a(paramString1, paramInt, paramString2, paramLong1, null, -1, paramLong2);
    AppMethodBeat.o(179444);
    return paramString1;
  }
  
  public final Bitmap a(String paramString1, int paramInt1, String paramString2, long paramLong1, s.e parame, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(179445);
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.CacheService", "file path is invalid.");
      AppMethodBeat.o(179445);
      return null;
    }
    String str = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramInt2);
    Object localObject = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramLong2);
    localObject = this.sIY.getBitmap((String)localObject);
    if (localObject != null)
    {
      ac.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(179445);
      return localObject;
    }
    ac.d("MicroMsg.CacheService", "waitingDecodeTask size is : [%d].", new Object[] { Integer.valueOf(this.sJb.size()) });
    if (this.sJb.containsKey(str))
    {
      ac.w("MicroMsg.CacheService", "%s has already getting bitmap from file, %s.", new Object[] { str, paramString1 });
      AppMethodBeat.o(179445);
      return null;
    }
    this.sJa.add(str);
    paramString1 = new c(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2);
    this.sJb.put(str, paramString1);
    ac.d("MicroMsg.CacheService", "add task: %s.", new Object[] { str });
    ac.d("MicroMsg.CacheService", "filePathInService size: %s, waitingDecodeTask size: %s.", new Object[] { Integer.valueOf(this.sJa.size()), Integer.valueOf(this.sJb.size()) });
    cMh();
    AppMethodBeat.o(179445);
    return null;
  }
  
  public final Bitmap a(String paramString1, String paramString2, s.e parame, long paramLong)
  {
    AppMethodBeat.i(179446);
    if (bs.isNullOrNil(paramString1)) {}
    while (bs.isNullOrNil(paramString2))
    {
      ac.w("MicroMsg.CacheService", "file path is null or nil.");
      AppMethodBeat.o(179446);
      return null;
      paramString2 = paramString1;
    }
    paramString1 = this.sIY.getBitmap(com.tencent.mm.plugin.gallery.a.d.a(paramString2, parame, paramLong));
    if (paramString1 != null)
    {
      ac.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString2 });
      AppMethodBeat.o(179446);
      return paramString1;
    }
    AppMethodBeat.o(179446);
    return null;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(111245);
    d locald = this.sIY;
    ac.d("MicroMsg.GalleryCache", "try add listener[%s].", new Object[] { paramb });
    if (locald.sJo.size() > 256)
    {
      ac.d("MicroMsg.GalleryCache", "start clear logic: %s.", new Object[] { Integer.valueOf(locald.sJo.size()) });
      int i = 0;
      while (i < 128)
      {
        String str = (String)locald.sJo.get(i);
        if (!bs.isNullOrNil(str)) {
          locald.sJp.remove(str);
        }
        i += 1;
      }
      locald.sJo.subList(0, 128).clear();
      ac.d("MicroMsg.GalleryCache", "finish clear logic: %s.", new Object[] { Integer.valueOf(locald.sJo.size()) });
    }
    if (bs.isNullOrNil(paramb.cMp()))
    {
      ac.e("MicroMsg.GalleryCache", "error! fileKey is invalid!!!");
      AppMethodBeat.o(111245);
      return;
    }
    if (locald.sJp.containsKey(paramb.cMp()))
    {
      ac.d("MicroMsg.GalleryCache", "listener already exist!!! %s, update!!!.", new Object[] { paramb });
      locald.sJo.remove(paramb.cMp());
      locald.sJo.add(paramb.cMp());
      locald.sJp.put(paramb.cMp(), paramb);
      AppMethodBeat.o(111245);
      return;
    }
    ac.d("MicroMsg.GalleryCache", "add listener[%s] ok.", new Object[] { paramb });
    locald.sJo.add(paramb.cMp());
    locald.sJp.put(paramb.cMp(), paramb);
    AppMethodBeat.o(111245);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(111246);
    d locald = this.sIY;
    if (paramb == null)
    {
      locald.cMo();
      locald.huf.removeAll();
      AppMethodBeat.o(111246);
      return;
    }
    String str = paramb.cMp();
    if (locald.sJp.containsKey(paramb.cMp()))
    {
      locald.sJp.remove(str);
      locald.sJo.remove(str);
    }
    AppMethodBeat.o(111246);
  }
  
  public final void b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(179447);
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.CacheService", "trySubmitPreDecodeTask, file path is invalid.");
      AppMethodBeat.o(179447);
      return;
    }
    String str = com.tencent.mm.plugin.gallery.a.d.a(paramString1, null, -1);
    Object localObject = com.tencent.mm.plugin.gallery.a.d.a(paramString1, null, paramLong2);
    localObject = this.sIY.getBitmap((String)localObject);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ac.v("MicroMsg.CacheService", "trySubmitPreDecodeTask, no need decode.");
      AppMethodBeat.o(179447);
      return;
    }
    ac.d("MicroMsg.CacheService", "pre decode info: %s %s stack %s.", new Object[] { str, paramString1, bs.eWi() });
    if (this.sJd.size() > 82) {
      ac.d("MicroMsg.CacheService", "remove task: %s.", new Object[] { ((b)this.sJd.cMV()).mFilePath });
    }
    paramString1 = new b(paramString1, paramInt, paramString2, paramLong1, paramLong2);
    this.sJd.add(paramString1);
    cMm();
    AppMethodBeat.o(179447);
  }
  
  final void cMh()
  {
    AppMethodBeat.i(111244);
    e.cMu().a(this.sJa, this.sJb);
    AppMethodBeat.o(111244);
  }
  
  final boolean cMi()
  {
    return this.sIZ > 0;
  }
  
  final void cMj()
  {
    this.sIZ -= 1;
  }
  
  final boolean cMk()
  {
    return this.sJc > 0;
  }
  
  final void cMl()
  {
    this.sJc -= 1;
  }
  
  public final void cMm()
  {
    AppMethodBeat.i(111249);
    ac.d("MicroMsg.CacheService", "tryStartPreDecode: %s %s.", new Object[] { Integer.valueOf(this.sJd.size()), Integer.valueOf(this.sJe.size()) });
    e.cMu().a(this.sJd, this.sJe);
    AppMethodBeat.o(111249);
  }
  
  public final void cMn()
  {
    AppMethodBeat.i(111250);
    Iterator localIterator = this.sJe.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.mCancel = true;
      }
    }
    this.sJe.clear();
    this.sJd.clear();
    AppMethodBeat.o(111250);
  }
  
  public final void dN(List<String> paramList)
  {
    AppMethodBeat.i(111247);
    if ((this.sJb != null) && (!this.sJb.isEmpty()))
    {
      Object localObject = new ArrayList();
      Iterator localIterator = this.sJb.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!paramList.contains(localEntry.getKey()))
        {
          c localc = (c)localEntry.getValue();
          if (localc != null) {
            localc.mCancel = true;
          }
          ac.d("MicroMsg.CacheService", "cancelTask, success : %s.", new Object[] { localEntry.getKey() });
          ((ArrayList)localObject).add(localEntry.getKey());
        }
      }
      ac.d("MicroMsg.CacheService", "cancelTask, counter: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      paramList = ((ArrayList)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        this.sJa.dg(localObject);
        this.sJb.remove(localObject);
      }
    }
    AppMethodBeat.o(111247);
  }
  
  public final class b
    extends c.a
  {
    Bitmap bitmap;
    volatile boolean mCancel;
    String mFilePath;
    private int mediaType;
    private String sJg;
    private long sJh;
    int sJi;
    long sJj;
    
    public b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
    {
      super();
      this.mFilePath = paramString1;
      this.mediaType = paramInt;
      this.sJg = paramString2;
      this.sJh = paramLong1;
      this.sJi = 12288;
      this.sJj = paramLong2;
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(111235);
      ac.d("MicroMsg.PreDecodeFile", "start doInBackground.");
      if (this.mCancel)
      {
        AppMethodBeat.o(111235);
        return false;
      }
      this.bitmap = c.this.sIY.b(this.mFilePath, this.sJg, null, this.sJj);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ac.d("MicroMsg.PreDecodeFile", "get bmp from disk cache ok, filePath[%s].", new Object[] { this.mFilePath });
        AppMethodBeat.o(111235);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111235);
        return false;
      }
      this.bitmap = n.a(this.sJh, this.mediaType, this.mFilePath, this.sJg);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ac.d("MicroMsg.PreDecodeFile", "get bmp from file ok, filePath[%s].", new Object[] { this.mFilePath });
        c.this.sIY.a(this.mFilePath, this.sJg, this.bitmap, null, this.sJj);
        AppMethodBeat.o(111235);
        return true;
      }
      AppMethodBeat.o(111235);
      return false;
    }
  }
  
  public final class c
    extends c.a
  {
    Bitmap bitmap;
    public volatile boolean mCancel;
    String mFilePath;
    int mPosition;
    private int mediaType;
    private String sJg;
    private long sJh;
    int sJi;
    long sJj;
    s.e sJk;
    String sJl;
    
    c(String paramString1, int paramInt1, String paramString2, long paramLong1, s.e parame, int paramInt2, long paramLong2)
    {
      this(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2, (byte)0);
    }
    
    private c(String paramString1, int paramInt1, String paramString2, long paramLong1, s.e parame, int paramInt2, long paramLong2, byte paramByte)
    {
      super();
      AppMethodBeat.i(179443);
      this.mFilePath = paramString1;
      this.mediaType = paramInt1;
      this.sJg = paramString2;
      this.sJh = paramLong1;
      this.sJi = 12288;
      this.sJk = parame;
      this.mPosition = paramInt2;
      this.sJj = paramLong2;
      this.sJl = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramInt2);
      AppMethodBeat.o(179443);
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(111237);
      ac.d("MicroMsg.CacheService", "task execute, mDecodeTaskKey: %s, filePath: %s, isCancel: %s.", new Object[] { this.sJl, this.mFilePath, Boolean.valueOf(this.mCancel) });
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = c.this.sIY.b(this.mFilePath, this.sJg, this.sJk, this.sJj);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ac.d("MicroMsg.CacheService", "get bmp from disk cache ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.sJl, this.mFilePath });
        AppMethodBeat.o(111237);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      if (this.sJk != null)
      {
        this.bitmap = n.a(this.mFilePath, this.sJk);
        if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
        {
          ac.d("MicroMsg.CacheService", "getPortraitBitmap ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.sJl, this.mFilePath });
          AppMethodBeat.o(111237);
          return true;
        }
        ac.d("MicroMsg.CacheService", "getPortraitBitmap err, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.sJl, this.mFilePath });
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = n.a(this.sJh, this.mediaType, this.mFilePath, this.sJg);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        c.this.sIY.a(this.mFilePath, this.sJg, this.bitmap, this.sJk, this.sJj);
        AppMethodBeat.o(111237);
        return true;
      }
      AppMethodBeat.o(111237);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111238);
      if (paramObject == null)
      {
        AppMethodBeat.o(111238);
        return false;
      }
      if (this == paramObject)
      {
        AppMethodBeat.o(111238);
        return true;
      }
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        boolean bool = bs.bG(this.mFilePath, "").equals(paramObject.mFilePath);
        AppMethodBeat.o(111238);
        return bool;
      }
      AppMethodBeat.o(111238);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111239);
      int i = bs.bG(this.mFilePath, "").hashCode();
      AppMethodBeat.o(111239);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c
 * JD-Core Version:    0.7.0.1
 */