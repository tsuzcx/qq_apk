package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.mapsdk.core.utils.cache.DiskCache;
import com.tencent.mapsdk.core.utils.cache.DiskCache.c;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.core.utils.cache.MemoryCache.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class pz
  extends oo
  implements TileOverlayCallback
{
  static final String a;
  static final String m = "/tile/";
  private static final long r = 1024L;
  int n;
  public qe o;
  public TileOverlayOptions p;
  public jg<qb> q;
  private Map<String, Integer> s;
  private le t;
  private BlockingQueue<Runnable> u;
  private final lj v;
  
  static
  {
    AppMethodBeat.i(225722);
    a = "%s" + File.separatorChar + "%d-%d-%d";
    AppMethodBeat.o(225722);
  }
  
  public pz(qe paramqe, TileOverlayOptions paramTileOverlayOptions)
  {
    super((az)paramqe.h.b);
    AppMethodBeat.i(225641);
    this.s = new Hashtable();
    this.v = new lj()
    {
      public final void b(String paramAnonymousString)
      {
        AppMethodBeat.i(225909);
        le localle = pz.a(pz.this);
        if (localle != null)
        {
          paramAnonymousString = (le.a)localle.a.get(paramAnonymousString);
          if (paramAnonymousString == null) {
            break label64;
          }
        }
        label64:
        for (paramAnonymousString = paramAnonymousString.a;; paramAnonymousString = null)
        {
          if (paramAnonymousString != null) {
            pz.b(pz.this).remove(paramAnonymousString);
          }
          AppMethodBeat.o(225909);
          return;
        }
      }
    };
    this.o = paramqe;
    this.p = paramTileOverlayOptions;
    if (this.p == null)
    {
      this.n = -1;
      AppMethodBeat.o(225641);
      return;
    }
    this.q = g();
    paramqe = this.o;
    boolean bool = this.p.isBetterQuality();
    if (paramqe.f == null) {}
    for (int i = -1;; i = paramqe.f.a(this, bool))
    {
      this.n = i;
      a(this.p.getZIndex());
      AppMethodBeat.o(225641);
      return;
      kl.c("TTO");
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(225692);
    if ((this.p == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(225692);
      return;
    }
    this.p.diskCacheDir(paramString);
    this.q = g();
    AppMethodBeat.o(225692);
  }
  
  private byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(225705);
    if ((this.p == null) || (this.p.getTileProvider() == null) || (paramInt3 < 0))
    {
      kh.d("TTO", "无效坐标，返回空瓦块");
      localObject1 = gv.a();
      AppMethodBeat.o(225705);
      return localObject1;
    }
    Object localObject1 = ka.b(this.p.getVersionInfo());
    localObject1 = String.format(a, new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject2 = this.p.getTileProvider().getTile(paramInt1, paramInt2, paramInt3);
    if (localObject2 == null)
    {
      kh.d("TTO", "Provider没有瓦片数据，返回空瓦块");
      localObject1 = gv.a();
      AppMethodBeat.o(225705);
      return localObject1;
    }
    localObject2 = ((Tile)localObject2).mData;
    qb localqb;
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      kl.b("TTO", "cacheId", localObject1);
      localqb = new qb((byte[])localObject2);
      if (this.q != null)
      {
        jn localjn = jk.a(this.q);
        if (localjn == null) {
          break label217;
        }
        localjn.b((String)localObject1, localqb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(225705);
      return localObject2;
      label217:
      this.q.a((String)localObject1, localqb);
    }
  }
  
  private int i()
  {
    return this.n;
  }
  
  private qe t()
  {
    return this.o;
  }
  
  private TileProvider u()
  {
    AppMethodBeat.i(225666);
    TileProvider localTileProvider = this.p.getTileProvider();
    AppMethodBeat.o(225666);
    return localTileProvider;
  }
  
  private qd v()
  {
    AppMethodBeat.i(225672);
    qd localqd = new qd(this.o);
    AppMethodBeat.o(225672);
    return localqd;
  }
  
  private void w()
  {
    AppMethodBeat.i(225684);
    if (this.q == null)
    {
      AppMethodBeat.o(225684);
      return;
    }
    if ((this.q instanceof jj))
    {
      jg localjg = ((jj)this.q).a(0);
      if ((localjg instanceof MemoryCache)) {
        localjg.b();
      }
      localjg = ((jj)this.q).a(1);
      if ((localjg instanceof DiskCache)) {
        ((DiskCache)localjg).f();
      }
    }
    for (;;)
    {
      this.s.clear();
      AppMethodBeat.o(225684);
      return;
      if ((this.q instanceof MemoryCache)) {
        this.q.b();
      }
    }
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(225754);
    if ((this.o == null) || (this.n < 0))
    {
      AppMethodBeat.o(225754);
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = b(i);
    this.o.a(this.n, paramInt);
    AppMethodBeat.o(225754);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225772);
    if ((this.o == null) || (this.n < 0))
    {
      AppMethodBeat.o(225772);
      return;
    }
    this.o.a(this.n, paramInt1, paramInt2);
    AppMethodBeat.o(225772);
  }
  
  protected int b(int paramInt)
  {
    return paramInt + 100;
  }
  
  public final le d()
  {
    try
    {
      AppMethodBeat.i(225730);
      if (this.t == null)
      {
        this.t = new le();
        this.t.a(this.v);
        localObject1 = hb.c();
        this.u = ((ThreadPoolExecutor)localObject1).getQueue();
        this.t.b = ((ExecutorService)localObject1);
      }
      Object localObject1 = this.t;
      AppMethodBeat.o(225730);
      return localObject1;
    }
    finally {}
  }
  
  public final void e()
  {
    AppMethodBeat.i(225748);
    if ((this.o == null) || (this.n < 0))
    {
      AppMethodBeat.o(225748);
      return;
    }
    w();
    this.o.b(this.n);
    if (this.u != null) {
      this.u.clear();
    }
    AppMethodBeat.o(225748);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((!(paramObject instanceof pz)) || (this.n != ((pz)paramObject).n)) {
      return false;
    }
    return true;
  }
  
  public final void f()
  {
    AppMethodBeat.i(225783);
    if (this.q == null)
    {
      AppMethodBeat.o(225783);
      return;
    }
    this.q.b();
    this.s.clear();
    AppMethodBeat.o(225783);
  }
  
  public final ao f_()
  {
    return null;
  }
  
  public final jg<qb> g()
  {
    AppMethodBeat.i(225797);
    if (this.o == null)
    {
      AppMethodBeat.o(225797);
      return null;
    }
    Object localObject = new MemoryCache.a();
    ((MemoryCache.a)localObject).b = this.p.getMaxMemoryCacheSize(this.o.h);
    ((MemoryCache.a)localObject).c = new pz.a((byte)0);
    if ((!TextUtils.isEmpty(this.o.i)) && (this.p != null) && (!TextUtils.isEmpty(this.p.getDiskCacheDir())))
    {
      DiskCache.c localc = new DiskCache.c();
      if (!TextUtils.isEmpty(h())) {
        localc.b();
      }
      String str = h() + this.p.getDiskCacheDir();
      localc.c = new File(this.o.i);
      localc.d = str;
      localc.j = -1;
      localc.k = new qa();
      localc.e = new qc(this.o.i + File.separator + str);
      localObject = jk.a(qb.class, new jg.a[] { localObject, localc });
      AppMethodBeat.o(225797);
      return localObject;
    }
    localObject = jk.a(qb.class, new jg.a[] { localObject });
    AppMethodBeat.o(225797);
    return localObject;
  }
  
  protected String h()
  {
    return "/tile/";
  }
  
  public final void h_()
  {
    AppMethodBeat.i(225739);
    if ((this.o == null) || (this.n < 0))
    {
      AppMethodBeat.o(225739);
      return;
    }
    w();
    try
    {
      if (this.t != null)
      {
        this.t.a();
        this.t = null;
      }
      qe localqe = this.o;
      int i = this.n;
      if (localqe.f != null)
      {
        localqe.g.remove(Integer.valueOf(i));
        localqe.f.d(i);
        kl.d("TTO");
      }
      AppMethodBeat.o(225739);
      return;
    }
    finally
    {
      AppMethodBeat.o(225739);
    }
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(225818);
    int i = this.b_.hashCode();
    AppMethodBeat.o(225818);
    return i;
  }
  
  public Bitmap onLoadTile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225841);
    if ((this.p == null) || (this.p.getTileProvider() == null))
    {
      AppMethodBeat.o(225841);
      return null;
    }
    Object localObject1 = ka.b(this.p.getVersionInfo());
    localObject1 = String.format(a, new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    int i2 = kl.e("TTO", "load-count");
    int j = kl.d("TTO", "cache-count");
    int i3 = kl.d("TTO", "data-count");
    int i4 = kl.d("TTO", "req-count");
    int i5 = kl.d("TTO", "cancel-count");
    int i = 0;
    Object localObject2 = (qb)jk.a(this.q).b((String)localObject1, qb.class);
    if (localObject2 != null)
    {
      int k = kl.e("TTO", "cache-count");
      int i1 = ((jp)localObject2).e;
      i = i1;
      j = k;
      if (i2 == i4 + i3 + k + i5)
      {
        kl.e("TTO");
        j = k;
        i = i1;
      }
    }
    kl.a(new Object[] { "get from cache of cacheId:".concat(String.valueOf(localObject1)), "dataLength:".concat(String.valueOf(i)), "loadCount:".concat(String.valueOf(i2)), "reqCount:".concat(String.valueOf(i4)), "dataCount:".concat(String.valueOf(i3)), "cacheCount:".concat(String.valueOf(j)), "cancelCount:".concat(String.valueOf(i5)) });
    if (localObject2 != null)
    {
      this.s.remove(localObject1);
      ((qb)localObject2).e();
      paramArrayOfByte = ((qb)localObject2).c();
      AppMethodBeat.o(225841);
      return paramArrayOfByte;
    }
    localObject2 = (Integer)this.s.get(localObject1);
    if ((localObject2 != null) && (((Integer)localObject2).intValue() > 10))
    {
      paramArrayOfByte = this.s.entrySet().iterator();
      paramInt1 = 0;
      if (paramArrayOfByte.hasNext())
      {
        if (((Integer)((Map.Entry)paramArrayOfByte.next()).getValue()).intValue() <= 10) {
          break label598;
        }
        paramInt1 += 1;
      }
    }
    label598:
    for (;;)
    {
      if (paramInt1 > 50)
      {
        kh.c("超过50个瓦片请求大于10次，重新加载TileOverlay");
        e();
        AppMethodBeat.o(225841);
        return null;
      }
      break;
      Map localMap = this.s;
      if (localObject2 == null) {}
      for (i = 0;; i = ((Integer)localObject2).intValue() + 1)
      {
        localMap.put(localObject1, Integer.valueOf(i));
        localObject1 = (128 + "tileOverlay://getTile/" + this.n + "?x=" + paramInt1 + "&y=" + paramInt2 + "&z=" + paramInt3).getBytes();
        System.arraycopy(localObject1, 0, paramArrayOfByte, 0, localObject1.length);
        AppMethodBeat.o(225841);
        return null;
      }
    }
  }
  
  public void onLoadTileFinish(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(225826);
    Object localObject = ka.b(this.p.getVersionInfo());
    localObject = String.format(a, new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    localObject = (qb)jk.a(this.q).b((String)localObject, qb.class);
    if (localObject != null) {
      ((qb)localObject).d();
    }
    AppMethodBeat.o(225826);
  }
  
  public boolean onTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onWriteTile(int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pz
 * JD-Core Version:    0.7.0.1
 */