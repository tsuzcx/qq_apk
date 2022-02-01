package com.tencent.mm.plugin.finder.ui.config;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.utils.ax;
import com.tencent.mm.plugin.finder.utils.bm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/config/TmpConfigItem;", "", "()V", "CHECK_FINDER_CACHE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "getCHECK_FINDER_CACHE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "CHECK_TAB_TIP_TEST", "getCHECK_TAB_TIP_TEST", "CLEAR_MSG_LAST_BUFF", "getCLEAR_MSG_LAST_BUFF", "CLEAR_PNG_VIDEO_CACHE", "getCLEAR_PNG_VIDEO_CACHE", "setCLEAR_PNG_VIDEO_CACHE", "(Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;)V", "DEBUG_CLEAR_FULL_SCREEN_TAB_RED_DOT_FLAG", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getDEBUG_CLEAR_FULL_SCREEN_TAB_RED_DOT_FLAG", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "DEBUG_INSERT_RED_DOT", "", "getDEBUG_INSERT_RED_DOT", "DOUBLE_CLICK_RESET_FAV_RED_DOT", "getDOUBLE_CLICK_RESET_FAV_RED_DOT", "setDOUBLE_CLICK_RESET_FAV_RED_DOT", "FEED_ONLY_ME_VISIBLE", "getFEED_ONLY_ME_VISIBLE", "setFEED_ONLY_ME_VISIBLE", "FINDER_ALBUM_TEST", "getFINDER_ALBUM_TEST", "FINDER_CLEAR_CACHE", "getFINDER_CLEAR_CACHE", "FINDER_CLEAR_POST_TASK", "getFINDER_CLEAR_POST_TASK", "FINDER_INSERT_10W_FAKE_SESSIONINFO", "getFINDER_INSERT_10W_FAKE_SESSIONINFO", "setFINDER_INSERT_10W_FAKE_SESSIONINFO", "FINDER_NEARBY_LIVE_CLEAR_CACHE", "getFINDER_NEARBY_LIVE_CLEAR_CACHE", "FINDER_NEARBY_LIVE_SQUARE_SCROLL_GUIDE", "getFINDER_NEARBY_LIVE_SQUARE_SCROLL_GUIDE", "RESET_CAMERA_RED_DOT", "getRESET_CAMERA_RED_DOT", "setRESET_CAMERA_RED_DOT", "SHARE_SDK_TEST", "getSHARE_SDK_TEST", "SHARE_SDK_TEST2", "getSHARE_SDK_TEST2", "SHARE_SDK_TEST4", "getSHARE_SDK_TEST4", "SHOW_VIDEO_PARAMS", "getSHOW_VIDEO_PARAMS", "longVideoAlbumPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getLongVideoAlbumPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a FWH;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c FWI;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWJ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<String> FWK;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWL;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWM;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWN;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWO;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c FWP;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c FWQ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWR;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c FWS;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<String> FWT;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<String> FWU;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWV;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWW;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FWX;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c FWY;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> FWZ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c FXa;
  
  static
  {
    AppMethodBeat.i(347625);
    FWH = new a();
    FWI = new com.tencent.mm.plugin.findersdk.storage.config.base.c("发表相机红点重置", (kotlin.g.a.b)o.FXr);
    FWJ = new com.tencent.mm.plugin.findersdk.storage.config.base.c("生效一次，收到红点会去掉（朋友/关注）发现页红点", (kotlin.g.a.b)b.FXe);
    FWK = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清除全屏tab红点标记", (kotlin.g.a.b)e.FXh).aDm("T5");
    FWL = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清理首页文件缓存", (kotlin.g.a.b)j.FXm);
    FWM = new com.tencent.mm.plugin.findersdk.storage.config.base.c("附近直播清理首页文件缓存", (kotlin.g.a.b)m.FXp);
    FWN = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清理发表队列", (kotlin.g.a.b)k.FXn);
    FWO = new com.tencent.mm.plugin.findersdk.storage.config.base.c("查看Finder缓存大小", (kotlin.g.a.b)a.FXb);
    FWP = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清除图片视频所有缓存", (kotlin.g.a.b)d.FXg);
    FWQ = new com.tencent.mm.plugin.findersdk.storage.config.base.c("插入10W条假session", (kotlin.g.a.b)a.l.FXo);
    FWR = new com.tencent.mm.plugin.findersdk.storage.config.base.c("显示视频编码配置", (kotlin.g.a.b)a.s.FXv);
    FWS = new com.tencent.mm.plugin.findersdk.storage.config.base.c("双击与展开教育/收藏红点重置", (kotlin.g.a.b)g.FXj);
    FWT = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清除直播广场的滑动引导", (kotlin.g.a.b)n.FXq).aDm("T5");
    FWU = new com.tencent.mm.plugin.findersdk.storage.config.base.c("跳通用选择器页面", (kotlin.g.a.b)i.FXl).aDm("T6");
    FWV = new com.tencent.mm.plugin.findersdk.storage.config.base.c("游戏sdk分享测试", (kotlin.g.a.b)p.FXs);
    FWW = new com.tencent.mm.plugin.findersdk.storage.config.base.c("秒剪sdk分享测试", (kotlin.g.a.b)q.FXt);
    FWX = new com.tencent.mm.plugin.findersdk.storage.config.base.c("OPENSDK DEEPLINK分享测试", (kotlin.g.a.b)r.FXu);
    FWY = new com.tencent.mm.plugin.findersdk.storage.config.base.c("把所有feed改为仅自己可见", (kotlin.g.a.b)h.FXk);
    FWZ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "红点数据库插入数据count", (m)f.FXi).c("DEBUG_FINDER_INSERT_RED_DOT_DB", (List)new ArrayList((Collection)kotlin.a.p.listOf(new Integer[] { Integer.valueOf(30), Integer.valueOf(100), Integer.valueOf(500), Integer.valueOf(1000), Integer.valueOf(5000) })), kotlin.a.p.listOf(new String[] { "30", "100", "500", "1000", "5000" }));
    FXa = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清空通知lastBuffer", (kotlin.g.a.b)c.FXf);
    AppMethodBeat.o(347625);
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcA()
  {
    return FWP;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcB()
  {
    return FWQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcC()
  {
    return FWR;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcD()
  {
    return FWS;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> fcE()
  {
    return FWT;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> fcF()
  {
    return FWU;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcG()
  {
    return FWV;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcH()
  {
    return FWW;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcI()
  {
    return FWX;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcJ()
  {
    return FWY;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> fcK()
  {
    return FWZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcL()
  {
    return FXa;
  }
  
  public static VideoTransPara fcM()
  {
    AppMethodBeat.i(347618);
    VideoTransPara localVideoTransPara = e.bIg().vY(new ax().fgA());
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbh, 0);
    if (i > 0) {
      localVideoTransPara.videoBitrate = i;
    }
    s.s(localVideoTransPara, "params");
    AppMethodBeat.o(347618);
    return localVideoTransPara;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fct()
  {
    return FWI;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcu()
  {
    return FWJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> fcv()
  {
    return FWK;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcw()
  {
    return FWL;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcx()
  {
    return FWM;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcy()
  {
    return FWN;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c fcz()
  {
    return FWO;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final a FXb;
    
    static
    {
      AppMethodBeat.i(347547);
      FXb = new a();
      AppMethodBeat.o(347547);
    }
    
    a()
    {
      super();
    }
    
    private static final void aJ(Activity paramActivity)
    {
      AppMethodBeat.i(347542);
      Object localObject = bm.GlZ;
      com.tencent.mm.ae.c localc = new com.tencent.mm.ae.c("dumpCacheDir");
      localObject = "";
      com.tencent.mm.plugin.finder.utils.p[] arrayOfp = bm.Gmn;
      int j = arrayOfp.length;
      int i = 0;
      while (i < j)
      {
        r localr = arrayOfp[i].feP();
        localObject = (String)localObject + (String)localr.bsC + '\n';
        i += 1;
      }
      localObject = new StringBuilder().append(bm.fih()).append(": \n ").append((String)localObject).append("  ");
      localc.bbW();
      d.uiThread((kotlin.g.a.a)new a(paramActivity, ah.aiuX));
      AppMethodBeat.o(347542);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(Activity paramActivity, String paramString)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final b FXe;
    
    static
    {
      AppMethodBeat.i(347533);
      FXe = new b();
      AppMethodBeat.o(347533);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final c FXf;
    
    static
    {
      AppMethodBeat.i(347534);
      FXf = new c();
      AppMethodBeat.o(347534);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final d FXg;
    
    static
    {
      AppMethodBeat.i(347525);
      FXg = new d();
      AppMethodBeat.o(347525);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final e FXh;
    
    static
    {
      AppMethodBeat.i(347524);
      FXh = new e();
      AppMethodBeat.o(347524);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", "<anonymous parameter 1>", "Landroid/content/Context;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<Integer, Context, ah>
  {
    public static final f FXi;
    
    static
    {
      AppMethodBeat.i(347538);
      FXi = new f();
      AppMethodBeat.o(347538);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final g FXj;
    
    static
    {
      AppMethodBeat.i(347528);
      FXj = new g();
      AppMethodBeat.o(347528);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final h FXk;
    
    static
    {
      AppMethodBeat.i(347527);
      FXk = new h();
      AppMethodBeat.o(347527);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final i FXl;
    
    static
    {
      AppMethodBeat.i(347567);
      FXl = new i();
      AppMethodBeat.o(347567);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final j FXm;
    
    static
    {
      AppMethodBeat.i(347563);
      FXm = new j();
      AppMethodBeat.o(347563);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final k FXn;
    
    static
    {
      AppMethodBeat.i(347574);
      FXn = new k();
      AppMethodBeat.o(347574);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final m FXp;
    
    static
    {
      AppMethodBeat.i(347552);
      FXp = new m();
      AppMethodBeat.o(347552);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final n FXq;
    
    static
    {
      AppMethodBeat.i(347553);
      FXq = new n();
      AppMethodBeat.o(347553);
    }
    
    n()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final o FXr;
    
    static
    {
      AppMethodBeat.i(347570);
      FXr = new o();
      AppMethodBeat.o(347570);
    }
    
    o()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final p FXs;
    
    static
    {
      AppMethodBeat.i(347556);
      FXs = new p();
      AppMethodBeat.o(347556);
    }
    
    p()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final q FXt;
    
    static
    {
      AppMethodBeat.i(347546);
      FXt = new q();
      AppMethodBeat.o(347546);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final r FXu;
    
    static
    {
      AppMethodBeat.i(347536);
      FXu = new r();
      AppMethodBeat.o(347536);
    }
    
    r()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.config.a
 * JD-Core Version:    0.7.0.1
 */