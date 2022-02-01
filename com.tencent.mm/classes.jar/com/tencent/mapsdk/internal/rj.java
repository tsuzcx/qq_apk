package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.io.File;

public final class rj
{
  private static final int f = 7;
  public sj a;
  public ri b;
  public OverSeaTileProvider c;
  public volatile boolean d;
  public boolean e;
  private TileOverlay g;
  private TileOverlayOptions h;
  
  public rj(sj paramsj)
  {
    AppMethodBeat.i(223107);
    this.a = null;
    this.g = null;
    this.d = false;
    this.a = paramsj;
    if (js.a("4.4.7", "4.0.9"))
    {
      kb.c(mf.a(this.a.G(), null).a() + "/tencentmapsdk/rastermap/unmainland");
      kb.c(mf.a(this.a.G(), null).b().getPath() + "/rastermap/taiwan");
    }
    AppMethodBeat.o(223107);
  }
  
  private void a(Context paramContext, OverSeaSource paramOverSeaSource)
  {
    AppMethodBeat.i(223113);
    this.b = new ri();
    ri localri = this.b;
    if (paramContext != null)
    {
      localri.i = paramOverSeaSource;
      jw.a(new ri.2(localri, paramContext, paramOverSeaSource)).a(Boolean.FALSE, null);
    }
    AppMethodBeat.o(223113);
  }
  
  private void a(Language paramLanguage)
  {
    AppMethodBeat.i(223144);
    if (paramLanguage == null)
    {
      AppMethodBeat.o(223144);
      return;
    }
    if (this.b.j != paramLanguage)
    {
      this.b.j = paramLanguage;
      if (this.c != null) {
        this.c.onLanguageChange(paramLanguage);
      }
      a();
    }
    AppMethodBeat.o(223144);
  }
  
  private void a(OverSeaTileProvider paramOverSeaTileProvider)
  {
    AppMethodBeat.i(223202);
    if (this.c != paramOverSeaTileProvider)
    {
      kh.c("TO", "设置自定义海外图源，old[" + this.c + "] to new[" + paramOverSeaTileProvider + "]");
      this.c = paramOverSeaTileProvider;
      this.e = true;
      this.b.k = this.c;
      paramOverSeaTileProvider = this.b.c();
      if (this.a != null) {
        this.a.a(false, paramOverSeaTileProvider);
      }
      a();
    }
    AppMethodBeat.o(223202);
  }
  
  private boolean a(ft[] paramArrayOfft)
  {
    AppMethodBeat.i(223191);
    if (this.a == null)
    {
      AppMethodBeat.o(223191);
      return true;
    }
    ft[] arrayOfft = this.a.W();
    if ((arrayOfft == null) || (paramArrayOfft == null))
    {
      AppMethodBeat.o(223191);
      return true;
    }
    boolean bool = rg.a(arrayOfft, paramArrayOfft);
    AppMethodBeat.o(223191);
    return bool;
  }
  
  private boolean c()
  {
    return this.d;
  }
  
  private void d()
  {
    this.d = true;
  }
  
  private void e()
  {
    AppMethodBeat.i(223128);
    if (this.g == null)
    {
      AppMethodBeat.o(223128);
      return;
    }
    this.g.clearTileCache();
    AppMethodBeat.o(223128);
  }
  
  private void f()
  {
    AppMethodBeat.i(223135);
    if (js.a("4.4.7", "4.0.9"))
    {
      kb.c(mf.a(this.a.G(), null).a() + "/tencentmapsdk/rastermap/unmainland");
      kb.c(mf.a(this.a.G(), null).b().getPath() + "/rastermap/taiwan");
    }
    AppMethodBeat.o(223135);
  }
  
  private void g()
  {
    AppMethodBeat.i(223155);
    Object localObject = this.a;
    TileOverlay localTileOverlay = this.g;
    if ((localObject == null) || (((bn)localObject).e_ == null) || (((sr)localObject).aB == null) || (localTileOverlay == null))
    {
      AppMethodBeat.o(223155);
      return;
    }
    VectorMap localVectorMap = (VectorMap)((bn)localObject).e_;
    localObject = ((sr)localObject).aB;
    ((mk)localObject).g(localVectorMap.p);
    ((mk)localObject).h(true);
    localTileOverlay.remove();
    this.g = null;
    this.h = null;
    AppMethodBeat.o(223155);
  }
  
  private void h()
  {
    AppMethodBeat.i(223164);
    if ((this.g != null) || (this.a == null) || (this.a.e_ == null) || (this.a.aB == null))
    {
      AppMethodBeat.o(223164);
      return;
    }
    Object localObject = this.b.b();
    if (localObject == null)
    {
      AppMethodBeat.o(223164);
      return;
    }
    kh.c("TO", "获取海外图图源：".concat(String.valueOf(localObject)));
    mk localmk = this.a.aB;
    localmk.g(false);
    localmk.h(false);
    this.c = new rk((rr)localObject, this.b.i, localmk.d);
    localObject = this.b.d();
    String str = this.b.a();
    kh.c("TO", "海外瓦片缓存目录：".concat(String.valueOf(str)));
    this.h = new TileOverlayOptions().tileProvider(this.c).betterQuality(false).versionInfo((String)localObject).zIndex(1).diskCacheDir(str);
    this.g = localmk.H.b(this.h);
    kh.c("TO", "开启海外图");
    AppMethodBeat.o(223164);
  }
  
  private ri i()
  {
    return this.b;
  }
  
  private boolean j()
  {
    return this.b.e;
  }
  
  public final void a()
  {
    AppMethodBeat.i(223225);
    b();
    if (this.h != null) {
      this.h.versionInfo(this.b.d()).diskCacheDir(this.b.a());
    }
    if (this.g != null) {
      this.g.reload();
    }
    AppMethodBeat.o(223225);
  }
  
  public final void b()
  {
    AppMethodBeat.i(223237);
    kh.c("TO", "检查海外图状态");
    if ((this.a == null) || (this.a.e_ == null) || (this.a.d_ == null))
    {
      AppMethodBeat.o(223237);
      return;
    }
    Object localObject = this.a.d_;
    if (((VectorMap)this.a.e_).r() < 7)
    {
      g();
      kh.c("TO", "级别无效");
      AppMethodBeat.o(223237);
      return;
    }
    kh.c("TO", "级别有效");
    if ((!this.b.e) || (!((bm)localObject).f))
    {
      if (this.g != null) {
        g();
      }
      kh.c("TO", "权限无效");
      AppMethodBeat.o(223237);
      return;
    }
    kh.c("TO", "权限有效");
    if (!((bm)localObject).e)
    {
      if (this.g != null) {
        g();
      }
      kh.c("TO", "边界线无效");
      AppMethodBeat.o(223237);
      return;
    }
    kh.c("TO", "边界线有效");
    boolean bool1 = this.b.h;
    StringBuilder localStringBuilder = new StringBuilder("数据配置模式：");
    boolean bool2;
    if (bool1)
    {
      localObject = "暗色";
      kh.c("TO", (String)localObject);
      bool2 = ((mk)this.a.d_).l();
      localStringBuilder = new StringBuilder("当前地图模式：");
      if (!bool2) {
        break label372;
      }
    }
    label372:
    for (localObject = "暗色";; localObject = "亮色")
    {
      kh.c("TO", (String)localObject);
      if (bool2 != bool1)
      {
        kh.c("TO", "更新暗色模式：".concat(String.valueOf(bool2)));
        this.b.a(bool2);
        g();
        if (this.c != null) {
          this.c.onDayNightChange(bool1);
        }
      }
      if (this.e)
      {
        this.e = false;
        g();
      }
      if (this.g == null) {
        h();
      }
      AppMethodBeat.o(223237);
      return;
      localObject = "亮色";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rj
 * JD-Core Version:    0.7.0.1
 */