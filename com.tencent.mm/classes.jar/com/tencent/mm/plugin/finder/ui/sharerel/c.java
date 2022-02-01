package com.tencent.mm.plugin.finder.ui.sharerel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.dc;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.ui.j;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.bi;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "countDownOk", "", "getCountDownOk", "()Z", "setCountDownOk", "(Z)V", "countTimeSec", "", "getCountTimeSec", "()I", "setCountTimeSec", "(I)V", "feedbackWidget", "Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget;", "getFeedbackWidget", "()Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget;", "setFeedbackWidget", "(Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget;)V", "hasPlay", "getHasPlay", "setHasPlay", "lastOffset", "getLastOffset", "setLastOffset", "lastPlayVideo", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "getLastPlayVideo", "()Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "setLastPlayVideo", "(Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;)V", "miniAppAdInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "getMiniAppAdInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "setMiniAppAdInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;)V", "presenter", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;)V", "reporter", "Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "getReporter", "()Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "setReporter", "(Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "totalCountDown", "getTotalCountDown", "doCallback", "", "fixActionBarStatus", "root", "Landroid/view/View;", "getRemainSec", "isAdFlow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "refreshCountDownProgress", "reportAvatarClick", "reportCommentClick", "reportFollowClick", "reportForwardClick", "reportLikeClick", "reportNicknameClick", "showExitTips", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  int ESj;
  public j FUF;
  private bzg FXZ;
  public b FYa;
  private a FYn;
  private final int FYo;
  boolean FYp;
  public int FYq;
  boolean FYr;
  x FYs;
  public final String TAG;
  TextView titleTv;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(347814);
    this.TAG = "Finder.WxaAdUIC";
    paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.FYo = ((Number)com.tencent.mm.plugin.finder.storage.d.eQZ().bmg()).intValue();
    AppMethodBeat.o(347814);
  }
  
  private static final void a(c paramc, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(347841);
    kotlin.g.b.s.u(paramc, "this$0");
    paramc = paramc.FUF;
    if (paramc != null)
    {
      paramc = paramc.AJn;
      if (paramc != null)
      {
        paramc = paramc.fjp();
        if (paramc != null) {
          paramc.hx(MMApplicationContext.getContext());
        }
      }
    }
    AppMethodBeat.o(347841);
  }
  
  private static final void a(c paramc, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(347833);
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.getContext().finish();
    AppMethodBeat.o(347833);
  }
  
  private static final void ac(boolean paramBoolean, String paramString) {}
  
  private final void fdd()
  {
    AppMethodBeat.i(347823);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(347823);
  }
  
  public final void fcZ()
  {
    AppMethodBeat.i(347909);
    b localb = this.FYa;
    if (localb != null) {
      localb.fcZ();
    }
    AppMethodBeat.o(347909);
  }
  
  public final void fda()
  {
    AppMethodBeat.i(347912);
    b localb = this.FYa;
    if (localb != null) {
      localb.fda();
    }
    AppMethodBeat.o(347912);
  }
  
  public final boolean fdc()
  {
    return this.FXZ != null;
  }
  
  public final int fde()
  {
    AppMethodBeat.i(347902);
    int i = Math.max(this.FYo - this.FYq, 0);
    AppMethodBeat.o(347902);
    return i;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(347898);
    if ((!fdc()) || (this.FYp))
    {
      boolean bool = super.onBackPressed();
      AppMethodBeat.o(347898);
      return bool;
    }
    Object localObject = this.FUF;
    if (localObject != null)
    {
      localObject = ((b.a)localObject).AJn;
      if (localObject != null)
      {
        localObject = ((l)localObject).fjp();
        if (localObject != null) {
          ((bi)localObject).hw(MMApplicationContext.getContext());
        }
      }
    }
    new g.a((Context)getContext()).bDE(getResources().getString(e.h.finder_ad_back_tips)).bDI(getResources().getString(e.h.app_continue)).b(c..ExternalSyntheticLambda2.INSTANCE).bDJ(getResources().getString(e.h.finder_black_list_setting_not_save)).a(new c..ExternalSyntheticLambda1(this)).d(new c..ExternalSyntheticLambda0(this)).show();
    AppMethodBeat.o(347898);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347885);
    super.onCreate(paramBundle);
    paramBundle = findViewById(e.e.full_actionbar);
    View localView;
    bzg localbzg;
    if (fdc())
    {
      paramBundle = (WeImageView)paramBundle.findViewById(e.e.backBtnIv);
      if (paramBundle != null) {
        paramBundle.setImageResource(e.g.icons_filled_close);
      }
      if (paramBundle != null) {
        paramBundle.setIconColor(getResources().getColor(e.b.hot_tab_selected_color));
      }
      paramBundle.getLayoutParams().width = ((int)getResources().getDimension(e.c.Edge_3A));
      paramBundle.getLayoutParams().height = ((int)getResources().getDimension(e.c.Edge_3A));
      af.mU((Context)getContext()).inflate(e.f.finder_ad_count_down_layout, (ViewGroup)getActivity().getWindow().getDecorView(), true);
      localView = findViewById(e.e.ad_count_down_layout_root);
      this.titleTv = ((TextView)localView.findViewById(e.e.ad_desc_tv));
      kotlin.g.b.s.s(localView, "root");
      kotlin.g.b.s.u(localView, "root");
      localView.setPadding(0, bf.getStatusBarHeight((Context)getActivity()), 0, 0);
      fdd();
      localbzg = this.FXZ;
      if (localbzg != null)
      {
        this.FYa = new b(getContext(), localbzg);
        localb = this.FYa;
        if (localb != null) {
          localb.FYj = cn.bDw();
        }
      }
    }
    try
    {
      localObject = localb.FYg.mxQ;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      JSONObject localJSONObject = new JSONObject(paramBundle);
      localObject = localJSONObject.optJSONObject("weapp_extra_data");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = new JSONObject();
      }
      localJSONObject.put("report_type", 1);
      localJSONObject.put("report_link", localb.FYg.aaiu);
      localJSONObject.put("viewable", false);
      localJSONObject.put("exposure_type", 0);
      paramBundle.put("exp_time", localb.FYj);
      paramBundle.put("clk_time", 0);
      localJSONObject.put("weapp_extra_data", paramBundle.toString());
      paramBundle = localJSONObject.toString();
      kotlin.g.b.s.s(paramBundle, "json.toString()");
      paramBundle = new dc(paramBundle);
      h.aZW().a((p)paramBundle, 0);
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        Log.printErrStackTrace(localb.TAG, paramBundle, "reportExpose", new Object[0]);
      }
    }
    paramBundle = getContext();
    localObject = this.FYa;
    kotlin.g.b.s.checkNotNull(localObject);
    this.FYn = new a(paramBundle, localView, localbzg, (b)localObject);
    paramBundle = as.GSQ;
    paramBundle = as.a.hu((Context)getContext());
    if (paramBundle != null)
    {
      paramBundle = ((bn)paramBundle).Vm(-1);
      if (paramBundle != null) {
        paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)new a(this));
      }
    }
    AppMethodBeat.o(347885);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(347874);
    super.onCreateBefore(paramBundle);
    paramBundle = (com.tencent.mm.bx.a)new bzg();
    byte[] arrayOfByte = getIntent().getByteArrayExtra("KEY_MINI_APP_AD_FLOW_INFO");
    try
    {
      paramBundle.parseFrom(arrayOfByte);
      this.FXZ = ((bzg)paramBundle);
      AppMethodBeat.o(347874);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/sharerel/WxaAdUIC$onCreate$2", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    a(c paramc) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(347854);
      kotlin.g.b.s.u(paramb, "ev");
      Object localObject1;
      Object localObject3;
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 3))
      {
        localObject1 = c.a(this.FYt);
        localObject2 = new StringBuilder("PlayEvent ev.video:");
        localObject3 = ((com.tencent.mm.plugin.finder.event.c.a)paramb).ANK;
        if (localObject3 == null) {
          break label401;
        }
      }
      label401:
      for (int i = localObject3.hashCode();; i = 0)
      {
        Log.i((String)localObject1, i + ", offset:" + ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset);
        if ((kotlin.g.b.s.p(this.FYt.FYs, ((com.tencent.mm.plugin.finder.event.c.a)paramb).ANK)) && (Math.abs(((com.tencent.mm.plugin.finder.event.c.a)paramb).offset - this.FYt.ESj) <= 2000))
        {
          localObject1 = this.FYt;
          ((c)localObject1).FYq += 1;
        }
        this.FYt.FYs = ((com.tencent.mm.plugin.finder.event.c.a)paramb).ANK;
        this.FYt.ESj = ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset;
        if ((this.FYt.fde() > 0) && (!this.FYt.FYr))
        {
          localObject2 = this.FYt.FYa;
          if (localObject2 != null) {
            ((b)localObject2).fdb();
          }
        }
        try
        {
          localObject1 = ((b)localObject2).FYg.mxQ;
          paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
          if (localObject1 == null) {
            paramb = "";
          }
          localObject3 = new JSONObject(paramb);
          localObject1 = ((JSONObject)localObject3).optJSONObject("weapp_extra_data");
          paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
          if (localObject1 == null) {
            paramb = new JSONObject();
          }
          ((JSONObject)localObject3).put("report_type", 1);
          ((JSONObject)localObject3).put("report_link", ((b)localObject2).FYg.aaiu);
          ((JSONObject)localObject3).put("viewable", true);
          ((JSONObject)localObject3).put("exposure_type", 1);
          paramb.put("exp_time", ((b)localObject2).FYj);
          paramb.put("clk_time", 0);
          ((JSONObject)localObject3).put("weapp_extra_data", paramb.toString());
          paramb = ((JSONObject)localObject3).toString();
          kotlin.g.b.s.s(paramb, "json.toString()");
          paramb = new dc(paramb);
          h.aZW().a((p)paramb, 0);
        }
        finally
        {
          for (;;)
          {
            Log.printErrStackTrace(((b)localObject2).TAG, paramb, "reportFirstPlay", new Object[0]);
          }
        }
        this.FYt.FYr = true;
        c.b(this.FYt);
        AppMethodBeat.o(347854);
        return;
      }
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(347812);
      kotlin.g.b.s.u(paramc, "dispatcher");
      kotlin.g.b.s.u(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.c.a;
      AppMethodBeat.o(347812);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sharerel.c
 * JD-Core Version:    0.7.0.1
 */