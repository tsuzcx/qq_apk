package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.co;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.surface.b.d;
import com.tencent.mm.plugin.surface.c.f;
import com.tencent.mm.plugin.surface.core.g;
import com.tencent.mm.plugin.surface.view.SurfaceAppContainer;
import com.tencent.mm.plugin.surface.view.SurfaceAppContainer.a;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "container", "Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer;", "getContainer", "()Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer;", "container$delegate", "Lkotlin/Lazy;", "root", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizTestCanvasUI
  extends MMActivity
{
  public static final BizTestCanvasUI.a vFl;
  private final j vFm;
  private f vFn;
  
  static
  {
    AppMethodBeat.i(302433);
    vFl = new BizTestCanvasUI.a((byte)0);
    g localg = new g((Collection)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new d(), (com.tencent.mm.plugin.appbrand.jsapi.p)new co(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.b() }), (com.tencent.mm.plugin.surface.d.a)new b());
    com.tencent.mm.plugin.surface.b localb = com.tencent.mm.plugin.surface.b.SJM;
    com.tencent.mm.plugin.surface.b.a("wx9e221f7828fa7482", localg);
    AppMethodBeat.o(302433);
  }
  
  public BizTestCanvasUI()
  {
    AppMethodBeat.i(302422);
    this.vFm = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(302422);
  }
  
  private static final boolean a(BizTestCanvasUI paramBizTestCanvasUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(302428);
    s.u(paramBizTestCanvasUI, "this$0");
    paramBizTestCanvasUI.finish();
    AppMethodBeat.o(302428);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return d.f.biz_test_canvas_activity;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(302448);
    super.onCreate(paramBundle);
    setMMTitle("调试Canvas");
    paramBundle = SurfaceAppContainer.SLJ;
    paramBundle = getContext();
    s.s(paramBundle, "this.context");
    this.vFn = SurfaceAppContainer.a.b(this, (Context)paramBundle, "wx9e221f7828fa7482", "frames", "?finderUsername=" + "v2_060000231003b20faec8c6ea811bc0d1c70de93db077cc1af4d949a173f9478ffdcc145fae59@finder" + "&objectId=" + "13626044674222262616");
    paramBundle = this.vFm.getValue();
    s.s(paramBundle, "<get-container>(...)");
    SurfaceAppContainer localSurfaceAppContainer = (SurfaceAppContainer)paramBundle;
    f localf = this.vFn;
    paramBundle = localf;
    if (localf == null)
    {
      s.bIx("root");
      paramBundle = null;
    }
    SurfaceAppContainer.a(localSurfaceAppContainer, paramBundle);
    paramBundle = this.vFn;
    if (paramBundle == null)
    {
      s.bIx("root");
      paramBundle = localObject;
    }
    for (;;)
    {
      paramBundle.bdb("{\"game_level\":{\"rank_url\":\"https://mmgame.qpic.cn/image/28c452dd5a1237853cb6a4ef2f37de37ebcb7f51a2ba79fc82e0dfe6edfd38e4/0\",\"level_text\":\"最强王者31星 | 金牌刺客\",\"anchor_uin\":1260027064,\"channel_id\":\"13680321672447395950\",\"jump_url\":\"pages/gift/index?channelid=13680321672447395950&anchoruin=1260027064\",\"smoba_equip_infos\":[],\"background_color\":\"#223D5B\",\"font_color\":\"#B0D3FD\",\"landscape_first_text\":\"第二行等产品给规则\"},\"is_battle\":1,\"anchor_game_panel\":{\"head_url\":\"https://wx.qlogo.cn/mmhead/Q3auHgzwzM5pDHGC4iaiaLBp8yLDzISjd4hHSeiaroAZXiassEribhfZ2tA/132\",\"nick_name\":\"猴三棍ヽ\",\"partition_name\":\"安卓-微信43区\",\"game_level\":{\"rank_url\":\"https://mmgame.qpic.cn/image/28c452dd5a1237853cb6a4ef2f37de37ebcb7f51a2ba79fc82e0dfe6edfd38e4/0\",\"level_text\":\"最强王者31星\",\"smoba_equip_infos\":[]},\"smoba_data\":{\"game_tags\":[{\"label_name\":\"金牌刺客\",\"label_desc\":\"\"},{\"label_name\":\"MVP狂魔\",\"label_desc\":\"\"},{\"label_name\":\"市级第98孙悟空\",\"label_desc\":\"\"}],\"using_hero\":{\"head_url\":\"https://mmocgame.qpic.cn/wechatgame/duc2TvpEgSTgCUiaUQGK1jZnFxjYaIkmia8Pu0ibw3GwutoibfrJf1esvtTphI0Aibibzk/0\",\"name\":\"艾琳\",\"win_rate\":42,\"game_num\":28,\"combat_power\":1629,\"equipments\":[],\"inscriptions\":[],\"heroid\":155}},\"panel_title\":\"\"},\"game_id\":\"wx95a3a4d7c627e07d\",\"ai_status\":1}");
      setBackBtn(new BizTestCanvasUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(302448);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(302461);
    super.onDestroy();
    f localf2 = this.vFn;
    f localf1 = localf2;
    if (localf2 == null)
    {
      s.bIx("root");
      localf1 = null;
    }
    localf1.destroy();
    AppMethodBeat.o(302461);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(302452);
    super.onPause();
    f localf2 = this.vFn;
    f localf1 = localf2;
    if (localf2 == null)
    {
      s.bIx("root");
      localf1 = null;
    }
    localf1.pause();
    AppMethodBeat.o(302452);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(302457);
    super.onResume();
    f localf2 = this.vFn;
    f localf1 = localf2;
    if (localf2 == null)
    {
      s.bIx("root");
      localf1 = null;
    }
    localf1.resume();
    AppMethodBeat.o(302457);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$Companion$config$1", "Lcom/tencent/mm/plugin/surface/reporter/SurfaceReporter;", "reportFirstFrameRender", "", "reportJsException", "appId", "", "source", "message", "stackTrace", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.surface.d.a
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<SurfaceAppContainer>
  {
    c(BizTestCanvasUI paramBizTestCanvasUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestCanvasUI
 * JD-Core Version:    0.7.0.1
 */