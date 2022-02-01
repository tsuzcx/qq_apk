package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
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
  public d tQA;
  int tQB;
  public h<String> tQC;
  public HashMap<String, c> tQD;
  int tQE;
  private h<b> tQF;
  h<b> tQG;
  
  public c()
  {
    AppMethodBeat.i(111240);
    this.tQA = new d();
    this.tQB = g.DEFAULT_CORE_POOL_SIZE;
    this.tQC = new h();
    this.tQD = new HashMap();
    this.tQE = (g.DEFAULT_CORE_POOL_SIZE / 2);
    this.tQF = new h();
    this.tQG = new h();
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
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.CacheService", "file path is invalid.");
      AppMethodBeat.o(179445);
      return null;
    }
    String str = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramInt2);
    Object localObject = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramLong2);
    localObject = this.tQA.getBitmap((String)localObject);
    if (localObject != null)
    {
      ae.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(179445);
      return localObject;
    }
    ae.d("MicroMsg.CacheService", "waitingDecodeTask size is : [%d].", new Object[] { Integer.valueOf(this.tQD.size()) });
    if (this.tQD.containsKey(str))
    {
      ae.w("MicroMsg.CacheService", "%s has already getting bitmap from file, %s.", new Object[] { str, paramString1 });
      AppMethodBeat.o(179445);
      return null;
    }
    this.tQC.add(str);
    paramString1 = new c(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2);
    this.tQD.put(str, paramString1);
    ae.d("MicroMsg.CacheService", "add task: %s.", new Object[] { str });
    ae.d("MicroMsg.CacheService", "filePathInService size: %s, waitingDecodeTask size: %s.", new Object[] { Integer.valueOf(this.tQC.size()), Integer.valueOf(this.tQD.size()) });
    cXf();
    AppMethodBeat.o(179445);
    return null;
  }
  
  public final Bitmap a(String paramString1, String paramString2, s.e parame, long paramLong)
  {
    AppMethodBeat.i(179446);
    if (bu.isNullOrNil(paramString1)) {}
    while (bu.isNullOrNil(paramString2))
    {
      ae.w("MicroMsg.CacheService", "file path is null or nil.");
      AppMethodBeat.o(179446);
      return null;
      paramString2 = paramString1;
    }
    paramString1 = this.tQA.getBitmap(com.tencent.mm.plugin.gallery.a.d.a(paramString2, parame, paramLong));
    if (paramString1 != null)
    {
      ae.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString2 });
      AppMethodBeat.o(179446);
      return paramString1;
    }
    AppMethodBeat.o(179446);
    return null;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(111245);
    d locald = this.tQA;
    ae.d("MicroMsg.GalleryCache", "try add listener[%s].", new Object[] { paramb });
    if (locald.tQQ.size() > 256)
    {
      ae.d("MicroMsg.GalleryCache", "start clear logic: %s.", new Object[] { Integer.valueOf(locald.tQQ.size()) });
      int i = 0;
      while (i < 128)
      {
        String str = (String)locald.tQQ.get(i);
        if (!bu.isNullOrNil(str)) {
          locald.tQR.remove(str);
        }
        i += 1;
      }
      locald.tQQ.subList(0, 128).clear();
      ae.d("MicroMsg.GalleryCache", "finish clear logic: %s.", new Object[] { Integer.valueOf(locald.tQQ.size()) });
    }
    if (bu.isNullOrNil(paramb.cXn()))
    {
      ae.e("MicroMsg.GalleryCache", "error! fileKey is invalid!!!");
      AppMethodBeat.o(111245);
      return;
    }
    if (locald.tQR.containsKey(paramb.cXn()))
    {
      ae.d("MicroMsg.GalleryCache", "listener already exist!!! %s, update!!!.", new Object[] { paramb });
      locald.tQQ.remove(paramb.cXn());
      locald.tQQ.add(paramb.cXn());
      locald.tQR.put(paramb.cXn(), paramb);
      AppMethodBeat.o(111245);
      return;
    }
    ae.d("MicroMsg.GalleryCache", "add listener[%s] ok.", new Object[] { paramb });
    locald.tQQ.add(paramb.cXn());
    locald.tQR.put(paramb.cXn(), paramb);
    AppMethodBeat.o(111245);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(111246);
    d locald = this.tQA;
    if (paramb == null)
    {
      locald.cXm();
      locald.hPq.removeAll();
      AppMethodBeat.o(111246);
      return;
    }
    String str = paramb.cXn();
    if (locald.tQR.containsKey(paramb.cXn()))
    {
      locald.tQR.remove(str);
      locald.tQQ.remove(str);
    }
    AppMethodBeat.o(111246);
  }
  
  public final void b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(179447);
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.CacheService", "trySubmitPreDecodeTask, file path is invalid.");
      AppMethodBeat.o(179447);
      return;
    }
    String str = com.tencent.mm.plugin.gallery.a.d.a(paramString1, null, -1);
    Object localObject = com.tencent.mm.plugin.gallery.a.d.a(paramString1, null, paramLong2);
    localObject = this.tQA.getBitmap((String)localObject);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ae.v("MicroMsg.CacheService", "trySubmitPreDecodeTask, no need decode.");
      AppMethodBeat.o(179447);
      return;
    }
    ae.d("MicroMsg.CacheService", "pre decode info: %s %s stack %s.", new Object[] { str, paramString1, bu.fpN() });
    if (this.tQF.size() > 82) {
      ae.d("MicroMsg.CacheService", "remove task: %s.", new Object[] { ((b)this.tQF.cXS()).mFilePath });
    }
    paramString1 = new b(paramString1, paramInt, paramString2, paramLong1, paramLong2);
    this.tQF.add(paramString1);
    cXk();
    AppMethodBeat.o(179447);
  }
  
  final void cXf()
  {
    AppMethodBeat.i(111244);
    e.cXs().a(this.tQC, this.tQD);
    AppMethodBeat.o(111244);
  }
  
  final boolean cXg()
  {
    return this.tQB > 0;
  }
  
  final void cXh()
  {
    this.tQB -= 1;
  }
  
  final boolean cXi()
  {
    return this.tQE > 0;
  }
  
  final void cXj()
  {
    this.tQE -= 1;
  }
  
  public final void cXk()
  {
    AppMethodBeat.i(111249);
    ae.d("MicroMsg.CacheService", "tryStartPreDecode: %s %s.", new Object[] { Integer.valueOf(this.tQF.size()), Integer.valueOf(this.tQG.size()) });
    e.cXs().a(this.tQF, this.tQG);
    AppMethodBeat.o(111249);
  }
  
  public final void cXl()
  {
    AppMethodBeat.i(111250);
    Iterator localIterator = this.tQG.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.mCancel = true;
      }
    }
    this.tQG.clear();
    this.tQF.clear();
    AppMethodBeat.o(111250);
  }
  
  public final void eb(List<String> paramList)
  {
    AppMethodBeat.i(111247);
    if ((this.tQD != null) && (!this.tQD.isEmpty()))
    {
      Object localObject = new ArrayList();
      Iterator localIterator = this.tQD.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!paramList.contains(localEntry.getKey()))
        {
          c localc = (c)localEntry.getValue();
          if (localc != null) {
            localc.mCancel = true;
          }
          ae.d("MicroMsg.CacheService", "cancelTask, success : %s.", new Object[] { localEntry.getKey() });
          ((ArrayList)localObject).add(localEntry.getKey());
        }
      }
      ae.d("MicroMsg.CacheService", "cancelTask, counter: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      paramList = ((ArrayList)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        this.tQC.dk(localObject);
        this.tQD.remove(localObject);
      }
    }
    AppMethodBeat.o(111247);
  }
  
  public abstract class a
    implements bf.a
  {
    public a() {}
    
    public final boolean aED()
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
    private String tQI;
    private long tQJ;
    int tQK;
    long tQL;
    
    public b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
    {
      super();
      this.mFilePath = paramString1;
      this.mediaType = paramInt;
      this.tQI = paramString2;
      this.tQJ = paramLong1;
      this.tQK = 12288;
      this.tQL = paramLong2;
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(111235);
      ae.d("MicroMsg.PreDecodeFile", "start doInBackground.");
      if (this.mCancel)
      {
        AppMethodBeat.o(111235);
        return false;
      }
      this.bitmap = c.this.tQA.b(this.mFilePath, this.tQI, null, this.tQL);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ae.d("MicroMsg.PreDecodeFile", "get bmp from disk cache ok, filePath[%s].", new Object[] { this.mFilePath });
        AppMethodBeat.o(111235);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111235);
        return false;
      }
      this.bitmap = n.a(this.tQJ, this.mediaType, this.mFilePath, this.tQI);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ae.d("MicroMsg.PreDecodeFile", "get bmp from file ok, filePath[%s].", new Object[] { this.mFilePath });
        c.this.tQA.a(this.mFilePath, this.tQI, this.bitmap, null, this.tQL);
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
    private String tQI;
    private long tQJ;
    int tQK;
    long tQL;
    s.e tQM;
    String tQN;
    
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
      this.tQI = paramString2;
      this.tQJ = paramLong1;
      this.tQK = 12288;
      this.tQM = parame;
      this.mPosition = paramInt2;
      this.tQL = paramLong2;
      this.tQN = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramInt2);
      AppMethodBeat.o(179443);
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(111237);
      ae.d("MicroMsg.CacheService", "task execute, mDecodeTaskKey: %s, filePath: %s, isCancel: %s.", new Object[] { this.tQN, this.mFilePath, Boolean.valueOf(this.mCancel) });
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = c.this.tQA.b(this.mFilePath, this.tQI, this.tQM, this.tQL);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ae.d("MicroMsg.CacheService", "get bmp from disk cache ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.tQN, this.mFilePath });
        AppMethodBeat.o(111237);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      if (this.tQM != null)
      {
        this.bitmap = n.a(this.mFilePath, this.tQM);
        if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
        {
          ae.d("MicroMsg.CacheService", "getPortraitBitmap ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.tQN, this.mFilePath });
          AppMethodBeat.o(111237);
          return true;
        }
        ae.d("MicroMsg.CacheService", "getPortraitBitmap err, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.tQN, this.mFilePath });
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = n.a(this.tQJ, this.mediaType, this.mFilePath, this.tQI);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        c.this.tQA.a(this.mFilePath, this.tQI, this.bitmap, this.tQM, this.tQL);
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
        boolean bool = bu.bI(this.mFilePath, "").equals(paramObject.mFilePath);
        AppMethodBeat.o(111238);
        return bool;
      }
      AppMethodBeat.o(111238);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111239);
      int i = bu.bI(this.mFilePath, "").hashCode();
      AppMethodBeat.o(111239);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c
 * JD-Core Version:    0.7.0.1
 */