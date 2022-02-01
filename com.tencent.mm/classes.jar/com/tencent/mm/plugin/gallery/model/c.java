package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  public d rAg;
  int rAh;
  public h<String> rAi;
  public HashMap<String, c> rAj;
  int rAk;
  private h<b> rAl;
  h<b> rAm;
  
  public c()
  {
    AppMethodBeat.i(111240);
    this.rAg = new d();
    this.rAh = g.DEFAULT_CORE_POOL_SIZE;
    this.rAi = new h();
    this.rAj = new HashMap();
    this.rAk = (g.DEFAULT_CORE_POOL_SIZE / 2);
    this.rAl = new h();
    this.rAm = new h();
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
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.CacheService", "file path is invalid.");
      AppMethodBeat.o(179445);
      return null;
    }
    String str = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramInt2);
    Object localObject = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramLong2);
    localObject = this.rAg.getBitmap((String)localObject);
    if (localObject != null)
    {
      ad.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(179445);
      return localObject;
    }
    ad.d("MicroMsg.CacheService", "waitingDecodeTask size is : [%d].", new Object[] { Integer.valueOf(this.rAj.size()) });
    if (this.rAj.containsKey(str))
    {
      ad.w("MicroMsg.CacheService", "%s has already getting bitmap from file, %s.", new Object[] { str, paramString1 });
      AppMethodBeat.o(179445);
      return null;
    }
    this.rAi.add(str);
    paramString1 = new c(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2);
    this.rAj.put(str, paramString1);
    ad.d("MicroMsg.CacheService", "add task: %s.", new Object[] { str });
    ad.d("MicroMsg.CacheService", "filePathInService size: %s, waitingDecodeTask size: %s.", new Object[] { Integer.valueOf(this.rAi.size()), Integer.valueOf(this.rAj.size()) });
    cyV();
    AppMethodBeat.o(179445);
    return null;
  }
  
  public final Bitmap a(String paramString1, String paramString2, s.e parame, long paramLong)
  {
    AppMethodBeat.i(179446);
    if (bt.isNullOrNil(paramString1)) {}
    while (bt.isNullOrNil(paramString2))
    {
      ad.w("MicroMsg.CacheService", "file path is null or nil.");
      AppMethodBeat.o(179446);
      return null;
      paramString2 = paramString1;
    }
    paramString1 = this.rAg.getBitmap(com.tencent.mm.plugin.gallery.a.d.a(paramString2, parame, paramLong));
    if (paramString1 != null)
    {
      ad.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString2 });
      AppMethodBeat.o(179446);
      return paramString1;
    }
    AppMethodBeat.o(179446);
    return null;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(111245);
    d locald = this.rAg;
    ad.d("MicroMsg.GalleryCache", "try add listener[%s].", new Object[] { paramb });
    if (locald.rAw.size() > 256)
    {
      ad.d("MicroMsg.GalleryCache", "start clear logic: %s.", new Object[] { Integer.valueOf(locald.rAw.size()) });
      int i = 0;
      while (i < 128)
      {
        String str = (String)locald.rAw.get(i);
        if (!bt.isNullOrNil(str)) {
          locald.rAx.remove(str);
        }
        i += 1;
      }
      locald.rAw.subList(0, 128).clear();
      ad.d("MicroMsg.GalleryCache", "finish clear logic: %s.", new Object[] { Integer.valueOf(locald.rAw.size()) });
    }
    if (bt.isNullOrNil(paramb.czd()))
    {
      ad.e("MicroMsg.GalleryCache", "error! fileKey is invalid!!!");
      AppMethodBeat.o(111245);
      return;
    }
    if (locald.rAx.containsKey(paramb.czd()))
    {
      ad.d("MicroMsg.GalleryCache", "listener already exist!!! %s, update!!!.", new Object[] { paramb });
      locald.rAw.remove(paramb.czd());
      locald.rAw.add(paramb.czd());
      locald.rAx.put(paramb.czd(), paramb);
      AppMethodBeat.o(111245);
      return;
    }
    ad.d("MicroMsg.GalleryCache", "add listener[%s] ok.", new Object[] { paramb });
    locald.rAw.add(paramb.czd());
    locald.rAx.put(paramb.czd(), paramb);
    AppMethodBeat.o(111245);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(111246);
    d locald = this.rAg;
    if (paramb == null)
    {
      locald.czc();
      locald.gTG.removeAll();
      AppMethodBeat.o(111246);
      return;
    }
    String str = paramb.czd();
    if (locald.rAx.containsKey(paramb.czd()))
    {
      locald.rAx.remove(str);
      locald.rAw.remove(str);
    }
    AppMethodBeat.o(111246);
  }
  
  public final void b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(179447);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.CacheService", "trySubmitPreDecodeTask, file path is invalid.");
      AppMethodBeat.o(179447);
      return;
    }
    String str = com.tencent.mm.plugin.gallery.a.d.a(paramString1, null, -1);
    Object localObject = com.tencent.mm.plugin.gallery.a.d.a(paramString1, null, paramLong2);
    localObject = this.rAg.getBitmap((String)localObject);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ad.v("MicroMsg.CacheService", "trySubmitPreDecodeTask, no need decode.");
      AppMethodBeat.o(179447);
      return;
    }
    ad.d("MicroMsg.CacheService", "pre decode info: %s %s stack %s.", new Object[] { str, paramString1, bt.eGN() });
    if (this.rAl.size() > 82) {
      ad.d("MicroMsg.CacheService", "remove task: %s.", new Object[] { ((b)this.rAl.czJ()).mFilePath });
    }
    paramString1 = new b(paramString1, paramInt, paramString2, paramLong1, paramLong2);
    this.rAl.add(paramString1);
    cza();
    AppMethodBeat.o(179447);
  }
  
  final void cyV()
  {
    AppMethodBeat.i(111244);
    e.czi().a(this.rAi, this.rAj);
    AppMethodBeat.o(111244);
  }
  
  final boolean cyW()
  {
    return this.rAh > 0;
  }
  
  final void cyX()
  {
    this.rAh -= 1;
  }
  
  final boolean cyY()
  {
    return this.rAk > 0;
  }
  
  final void cyZ()
  {
    this.rAk -= 1;
  }
  
  public final void cza()
  {
    AppMethodBeat.i(111249);
    ad.d("MicroMsg.CacheService", "tryStartPreDecode: %s %s.", new Object[] { Integer.valueOf(this.rAl.size()), Integer.valueOf(this.rAm.size()) });
    e.czi().a(this.rAl, this.rAm);
    AppMethodBeat.o(111249);
  }
  
  public final void czb()
  {
    AppMethodBeat.i(111250);
    Iterator localIterator = this.rAm.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.mCancel = true;
      }
    }
    this.rAm.clear();
    this.rAl.clear();
    AppMethodBeat.o(111250);
  }
  
  public final void dJ(List<String> paramList)
  {
    AppMethodBeat.i(111247);
    if ((this.rAj != null) && (!this.rAj.isEmpty()))
    {
      Object localObject = new ArrayList();
      Iterator localIterator = this.rAj.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!paramList.contains(localEntry.getKey()))
        {
          c localc = (c)localEntry.getValue();
          if (localc != null) {
            localc.mCancel = true;
          }
          ad.d("MicroMsg.CacheService", "cancelTask, success : %s.", new Object[] { localEntry.getKey() });
          ((ArrayList)localObject).add(localEntry.getKey());
        }
      }
      ad.d("MicroMsg.CacheService", "cancelTask, counter: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      paramList = ((ArrayList)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        this.rAi.de(localObject);
        this.rAj.remove(localObject);
      }
    }
    AppMethodBeat.o(111247);
  }
  
  public abstract class a
    implements be.a
  {
    public a() {}
    
    public final boolean aut()
    {
      return false;
    }
  }
  
  public final class b
    extends c.a
  {
    Bitmap bitmap;
    volatile boolean mCancel;
    String mFilePath;
    private int mediaType;
    private String rAo;
    private long rAp;
    int rAq;
    long rAr;
    
    public b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
    {
      super();
      this.mFilePath = paramString1;
      this.mediaType = paramInt;
      this.rAo = paramString2;
      this.rAp = paramLong1;
      this.rAq = 12288;
      this.rAr = paramLong2;
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(111235);
      ad.d("MicroMsg.PreDecodeFile", "start doInBackground.");
      if (this.mCancel)
      {
        AppMethodBeat.o(111235);
        return false;
      }
      this.bitmap = c.this.rAg.b(this.mFilePath, this.rAo, null, this.rAr);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ad.d("MicroMsg.PreDecodeFile", "get bmp from disk cache ok, filePath[%s].", new Object[] { this.mFilePath });
        AppMethodBeat.o(111235);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111235);
        return false;
      }
      this.bitmap = n.a(this.rAp, this.mediaType, this.mFilePath, this.rAo);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ad.d("MicroMsg.PreDecodeFile", "get bmp from file ok, filePath[%s].", new Object[] { this.mFilePath });
        c.this.rAg.a(this.mFilePath, this.rAo, this.bitmap, null, this.rAr);
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
    private String rAo;
    private long rAp;
    int rAq;
    long rAr;
    s.e rAs;
    String rAt;
    
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
      this.rAo = paramString2;
      this.rAp = paramLong1;
      this.rAq = 12288;
      this.rAs = parame;
      this.mPosition = paramInt2;
      this.rAr = paramLong2;
      this.rAt = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramInt2);
      AppMethodBeat.o(179443);
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(111237);
      ad.d("MicroMsg.CacheService", "task execute, mDecodeTaskKey: %s, filePath: %s, isCancel: %s.", new Object[] { this.rAt, this.mFilePath, Boolean.valueOf(this.mCancel) });
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = c.this.rAg.b(this.mFilePath, this.rAo, this.rAs, this.rAr);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ad.d("MicroMsg.CacheService", "get bmp from disk cache ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.rAt, this.mFilePath });
        AppMethodBeat.o(111237);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      if (this.rAs != null)
      {
        this.bitmap = n.a(this.mFilePath, this.rAs);
        if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
        {
          ad.d("MicroMsg.CacheService", "getPortraitBitmap ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.rAt, this.mFilePath });
          AppMethodBeat.o(111237);
          return true;
        }
        ad.d("MicroMsg.CacheService", "getPortraitBitmap err, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.rAt, this.mFilePath });
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = n.a(this.rAp, this.mediaType, this.mFilePath, this.rAo);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        c.this.rAg.a(this.mFilePath, this.rAo, this.bitmap, this.rAs, this.rAr);
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
        boolean bool = bt.by(this.mFilePath, "").equals(paramObject.mFilePath);
        AppMethodBeat.o(111238);
        return bool;
      }
      AppMethodBeat.o(111238);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111239);
      int i = bt.by(this.mFilePath, "").hashCode();
      AppMethodBeat.o(111239);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c
 * JD-Core Version:    0.7.0.1
 */