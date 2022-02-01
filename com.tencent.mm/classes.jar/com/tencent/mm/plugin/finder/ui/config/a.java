package com.tencent.mm.plugin.finder.ui.config;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/config/TmpConfigItem;", "", "()V", "CHANGE_TO_NO_FINDER_ENTRANCE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "getCHANGE_TO_NO_FINDER_ENTRANCE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "setCHANGE_TO_NO_FINDER_ENTRANCE", "(Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;)V", "CHECK_FINDER_CACHE", "getCHECK_FINDER_CACHE", "CHECK_TAB_TIP_TEST", "getCHECK_TAB_TIP_TEST", "CLEAR_MSG_LAST_BUFF", "getCLEAR_MSG_LAST_BUFF", "CLEAR_PNG_VIDEO_CACHE", "getCLEAR_PNG_VIDEO_CACHE", "setCLEAR_PNG_VIDEO_CACHE", "DEBUG_CLEAR_FULL_SCREEN_TAB_RED_DOT_FLAG", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getDEBUG_CLEAR_FULL_SCREEN_TAB_RED_DOT_FLAG", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "DEBUG_INSERT_RED_DOT", "", "getDEBUG_INSERT_RED_DOT", "DOUBLE_CLICK_RESET_FAV_RED_DOT", "getDOUBLE_CLICK_RESET_FAV_RED_DOT", "setDOUBLE_CLICK_RESET_FAV_RED_DOT", "FEED_ONLY_ME_VISIBLE", "getFEED_ONLY_ME_VISIBLE", "setFEED_ONLY_ME_VISIBLE", "FINDER_ALBUM_TEST", "getFINDER_ALBUM_TEST", "FINDER_CLEAR_CACHE", "getFINDER_CLEAR_CACHE", "FINDER_CLEAR_POST_TASK", "getFINDER_CLEAR_POST_TASK", "FINDER_INSERT_10W_FAKE_SESSIONINFO", "getFINDER_INSERT_10W_FAKE_SESSIONINFO", "setFINDER_INSERT_10W_FAKE_SESSIONINFO", "FINDER_NEARBY_LIVE_SQUARE_SCROLL_GUIDE", "getFINDER_NEARBY_LIVE_SQUARE_SCROLL_GUIDE", "RESET_CAMERA_RED_DOT", "getRESET_CAMERA_RED_DOT", "setRESET_CAMERA_RED_DOT", "SHARE_SDK_TEST", "getSHARE_SDK_TEST", "SHARE_SDK_TEST2", "getSHARE_SDK_TEST2", "SHOW_VIDEO_PARAMS", "getSHOW_VIDEO_PARAMS", "longVideoAlbumPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getLongVideoAlbumPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-finder_release"})
public final class a
{
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c AxA;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c AxB;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c AxC;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AxD;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c AxE;
  public static final a AxF;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Axn;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Axo;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Axp;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Axq;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Axr;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Axs;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Axt;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Axu;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Axv;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Axw;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Axx;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Axy;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Axz;
  
  static
  {
    AppMethodBeat.i(269037);
    AxF = new a();
    Axn = new com.tencent.mm.plugin.findersdk.d.a.a.c("发表相机红点重置", (kotlin.g.a.b)o.AxW);
    Axo = new com.tencent.mm.plugin.findersdk.d.a.a.c("生效一次，收到红点会去掉（朋友/关注）发现页红点", (kotlin.g.a.b)c.AxK);
    Axp = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除全屏tab红点标记", (kotlin.g.a.b)f.AxN).aGU("T5");
    Axq = new com.tencent.mm.plugin.findersdk.d.a.a.c("清理首页文件缓存", (kotlin.g.a.b)k.AxS);
    Axr = new com.tencent.mm.plugin.findersdk.d.a.a.c("清理发表队列", (kotlin.g.a.b)l.AxT);
    Axs = new com.tencent.mm.plugin.findersdk.d.a.a.c("查看Finder缓存大小", (kotlin.g.a.b)b.AxH);
    Axt = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除图片视频所有缓存", (kotlin.g.a.b)e.AxM);
    Axu = new com.tencent.mm.plugin.findersdk.d.a.a.c("把自己改成非白名单用户", (kotlin.g.a.b)a.AxG);
    Axv = new com.tencent.mm.plugin.findersdk.d.a.a.c("插入10W条假session", (kotlin.g.a.b)m.AxU);
    Axw = new com.tencent.mm.plugin.findersdk.d.a.a.c("显示视频编码配置", (kotlin.g.a.b)r.AxZ);
    Axx = new com.tencent.mm.plugin.findersdk.d.a.a.c("双击与展开教育/收藏红点重置", (kotlin.g.a.b)h.AxP);
    Axy = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除直播广场的滑动引导", (kotlin.g.a.b)n.AxV).aGU("T5");
    Axz = new com.tencent.mm.plugin.findersdk.d.a.a.c("跳通用选择器页面", (kotlin.g.a.b)j.AxR).aGU("T6");
    AxA = new com.tencent.mm.plugin.findersdk.d.a.a.c("游戏sdk分享测试", (kotlin.g.a.b)p.AxX);
    AxB = new com.tencent.mm.plugin.findersdk.d.a.a.c("秒剪sdk分享测试", (kotlin.g.a.b)q.AxY);
    AxC = new com.tencent.mm.plugin.findersdk.d.a.a.c("把所有feed改为仅自己可见", (kotlin.g.a.b)i.AxQ);
    AxD = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "红点数据库插入数据count", (m)g.AxO).b("DEBUG_FINDER_INSERT_RED_DOT_DB", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(30), Integer.valueOf(100), Integer.valueOf(500), Integer.valueOf(1000), Integer.valueOf(5000) })), j.listOf(new String[] { "30", "100", "500", "1000", "5000" }));
    AxE = new com.tencent.mm.plugin.findersdk.d.a.a.c("清空通知lastBuffer", (kotlin.g.a.b)d.AxL);
    AppMethodBeat.o(269037);
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebA()
  {
    return AxA;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebB()
  {
    return AxB;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebC()
  {
    return AxC;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ebD()
  {
    return AxD;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebE()
  {
    return AxE;
  }
  
  public static VideoTransPara ebF()
  {
    AppMethodBeat.i(269036);
    VideoTransPara localVideoTransPara = e.bkp().vT(new al().eeE());
    p.j(localVideoTransPara, "SubCoreVideoControl.getC…i().longVideoMaxDuration)");
    AppMethodBeat.o(269036);
    return localVideoTransPara;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebn()
  {
    return Axn;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebo()
  {
    return Axo;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> ebp()
  {
    return Axp;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebq()
  {
    return Axq;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebr()
  {
    return Axr;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebs()
  {
    return Axs;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebt()
  {
    return Axt;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebu()
  {
    return Axu;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebv()
  {
    return Axv;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebw()
  {
    return Axw;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c ebx()
  {
    return Axx;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> eby()
  {
    return Axy;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> ebz()
  {
    return Axz;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final a AxG;
    
    static
    {
      AppMethodBeat.i(292235);
      AxG = new a();
      AppMethodBeat.o(292235);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final b AxH;
    
    static
    {
      AppMethodBeat.i(277684);
      AxH = new b();
      AppMethodBeat.o(277684);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final c AxK;
    
    static
    {
      AppMethodBeat.i(271204);
      AxK = new c();
      AppMethodBeat.o(271204);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final d AxL;
    
    static
    {
      AppMethodBeat.i(273361);
      AxL = new d();
      AppMethodBeat.o(273361);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final e AxM;
    
    static
    {
      AppMethodBeat.i(285103);
      AxM = new e();
      AppMethodBeat.o(285103);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final f AxN;
    
    static
    {
      AppMethodBeat.i(281615);
      AxN = new f();
      AppMethodBeat.o(281615);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "<anonymous parameter 1>", "Landroid/content/Context;", "invoke"})
  static final class g
    extends q
    implements m<Integer, Context, x>
  {
    public static final g AxO;
    
    static
    {
      AppMethodBeat.i(265578);
      AxO = new g();
      AppMethodBeat.o(265578);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final h AxP;
    
    static
    {
      AppMethodBeat.i(282220);
      AxP = new h();
      AppMethodBeat.o(282220);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final i AxQ;
    
    static
    {
      AppMethodBeat.i(291069);
      AxQ = new i();
      AppMethodBeat.o(291069);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final j AxR;
    
    static
    {
      AppMethodBeat.i(277577);
      AxR = new j();
      AppMethodBeat.o(277577);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final k AxS;
    
    static
    {
      AppMethodBeat.i(223314);
      AxS = new k();
      AppMethodBeat.o(223314);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final l AxT;
    
    static
    {
      AppMethodBeat.i(291282);
      AxT = new l();
      AppMethodBeat.o(291282);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final m AxU;
    
    static
    {
      AppMethodBeat.i(278306);
      AxU = new m();
      AppMethodBeat.o(278306);
    }
    
    m()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final n AxV;
    
    static
    {
      AppMethodBeat.i(284449);
      AxV = new n();
      AppMethodBeat.o(284449);
    }
    
    n()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final o AxW;
    
    static
    {
      AppMethodBeat.i(289491);
      AxW = new o();
      AppMethodBeat.o(289491);
    }
    
    o()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final p AxX;
    
    static
    {
      AppMethodBeat.i(283911);
      AxX = new p();
      AppMethodBeat.o(283911);
    }
    
    p()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final q AxY;
    
    static
    {
      AppMethodBeat.i(278205);
      AxY = new q();
      AppMethodBeat.o(278205);
    }
    
    q()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final r AxZ;
    
    static
    {
      AppMethodBeat.i(287595);
      AxZ = new r();
      AppMethodBeat.o(287595);
    }
    
    r()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.config.a
 * JD-Core Version:    0.7.0.1
 */