package com.tencent.mm.plugin.finder.ui.sharerel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
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
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.ui.i;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.au;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "countDownOk", "", "getCountDownOk", "()Z", "setCountDownOk", "(Z)V", "countTimeSec", "", "getCountTimeSec", "()I", "setCountTimeSec", "(I)V", "feedbackWidget", "Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget;", "getFeedbackWidget", "()Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget;", "setFeedbackWidget", "(Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget;)V", "hasPlay", "getHasPlay", "setHasPlay", "lastOffset", "getLastOffset", "setLastOffset", "lastPlayVideo", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "getLastPlayVideo", "()Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "setLastPlayVideo", "(Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;)V", "miniAppAdInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "getMiniAppAdInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "setMiniAppAdInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;)V", "presenter", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;)V", "reporter", "Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "getReporter", "()Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "setReporter", "(Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "totalCountDown", "getTotalCountDown", "doCallback", "", "fixActionBarStatus", "root", "Landroid/view/View;", "getRemainSec", "isAdFlow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "refreshCountDownProgress", "reportAvatarClick", "reportCommentClick", "reportFollowClick", "reportForwardClick", "reportLikeClick", "reportNicknameClick", "showExitTips", "plugin-finder_release"})
public final class c
  extends UIComponent
{
  public i AvA;
  private blp AyM;
  public b AyN;
  private a AyY;
  private final int AyZ;
  boolean Aza;
  public int Azb;
  boolean Azc;
  ac Azd;
  int Aze;
  public final String TAG;
  TextView titleTv;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(240265);
    this.TAG = "Finder.WxaAdUIC";
    paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AyZ = ((Number)com.tencent.mm.plugin.finder.storage.d.dSO().aSr()).intValue();
    AppMethodBeat.o(240265);
  }
  
  private final void ebV()
  {
    AppMethodBeat.i(240253);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(240253);
  }
  
  public final void ebR()
  {
    AppMethodBeat.i(240261);
    b localb = this.AyN;
    if (localb != null)
    {
      localb.ebR();
      AppMethodBeat.o(240261);
      return;
    }
    AppMethodBeat.o(240261);
  }
  
  public final void ebS()
  {
    AppMethodBeat.i(240264);
    b localb = this.AyN;
    if (localb != null)
    {
      localb.ebS();
      AppMethodBeat.o(240264);
      return;
    }
    AppMethodBeat.o(240264);
  }
  
  public final boolean ebU()
  {
    return this.AyM != null;
  }
  
  public final int ebW()
  {
    AppMethodBeat.i(240258);
    int i = Math.max(this.AyZ - this.Azb, 0);
    AppMethodBeat.o(240258);
    return i;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(240256);
    if ((!ebU()) || (this.Aza))
    {
      boolean bool = super.onBackPressed();
      AppMethodBeat.o(240256);
      return bool;
    }
    Object localObject = this.AvA;
    if (localObject != null)
    {
      localObject = ((b.a)localObject).xkW;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.video.l)localObject).ehl();
        if (localObject != null) {
          ((au)localObject).gb(MMApplicationContext.getContext());
        }
      }
    }
    new f.a((Context)getContext()).bBl(getResources().getString(b.j.finder_ad_back_tips)).bBp(getResources().getString(b.j.app_continue)).b((f.c)c.Azg).bBq(getResources().getString(b.j.finder_black_list_setting_not_save)).a((f.c)new d(this)).b((DialogInterface.OnDismissListener)new e(this)).show();
    AppMethodBeat.o(240256);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(240248);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.f.full_actionbar);
    b localb;
    if (ebU())
    {
      paramBundle = (WeImageView)paramBundle.findViewById(b.f.backBtnIv);
      if (paramBundle != null) {
        paramBundle.setImageResource(b.i.icons_filled_close);
      }
      if (paramBundle != null) {
        paramBundle.setIconColor(getResources().getColor(b.c.hot_tab_selected_color));
      }
      p.j(paramBundle, "backIv");
      paramBundle.getLayoutParams().width = ((int)getResources().getDimension(b.d.Edge_3A));
      paramBundle.getLayoutParams().height = ((int)getResources().getDimension(b.d.Edge_3A));
      paramBundle = ad.kS((Context)getContext());
      int i = b.g.finder_ad_count_down_layout;
      Object localObject = getActivity().getWindow();
      p.j(localObject, "activity.window");
      localObject = ((Window)localObject).getDecorView();
      if (localObject == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(240248);
        throw paramBundle;
      }
      paramBundle.inflate(i, (ViewGroup)localObject, true);
      View localView = findViewById(b.f.ad_count_down_layout_root);
      this.titleTv = ((TextView)localView.findViewById(b.f.ad_desc_tv));
      p.j(localView, "root");
      p.k(localView, "root");
      localView.setPadding(0, ax.getStatusBarHeight((Context)getActivity()), 0, 0);
      ebV();
      blp localblp = this.AyM;
      if (localblp != null)
      {
        this.AyN = new b(getContext(), localblp);
        localb = this.AyN;
        if (localb != null) {
          localb.AyT = cm.bfE();
        }
      }
      try
      {
        localObject = localb.AyX.jXW;
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
        localJSONObject.put("report_link", localb.AyX.SWE);
        localJSONObject.put("viewable", false);
        localJSONObject.put("exposure_type", 0);
        paramBundle.put("exp_time", localb.AyT);
        paramBundle.put("clk_time", 0);
        localJSONObject.put("weapp_extra_data", paramBundle.toString());
        paramBundle = localJSONObject.toString();
        p.j(paramBundle, "json.toString()");
        paramBundle = new cd(paramBundle);
        h.aGY().b((com.tencent.mm.an.q)paramBundle);
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace(localb.TAG, paramBundle, "reportExpose", new Object[0]);
        }
      }
      paramBundle = getContext();
      localObject = this.AyN;
      if (localObject == null) {
        p.iCn();
      }
      this.AyY = new a(paramBundle, localView, localblp, (b)localObject);
      paramBundle = aj.Bnu;
      paramBundle = aj.a.fZ((Context)getContext());
      if (paramBundle != null)
      {
        paramBundle = aj.a(paramBundle);
        if (paramBundle != null)
        {
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)new a(this));
          AppMethodBeat.o(240248);
          return;
        }
      }
    }
    AppMethodBeat.o(240248);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(240243);
    super.onCreateBefore(paramBundle);
    paramBundle = (com.tencent.mm.cd.a)new blp();
    byte[] arrayOfByte = getIntent().getByteArrayExtra("KEY_MINI_APP_AD_FLOW_INFO");
    try
    {
      paramBundle.parseFrom(arrayOfByte);
      this.AyM = ((blp)paramBundle);
      AppMethodBeat.o(240243);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/sharerel/WxaAdUIC$onCreate$2", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(270784);
      p.k(paramb, "ev");
      Object localObject1;
      Object localObject3;
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 3))
      {
        localObject1 = c.a(this.Azf);
        localObject2 = new StringBuilder("PlayEvent ev.video:");
        localObject3 = ((com.tencent.mm.plugin.finder.event.c.a)paramb).xqx;
        if (localObject3 == null) {
          break label402;
        }
      }
      label402:
      for (int i = localObject3.hashCode();; i = 0)
      {
        Log.i((String)localObject1, i + ", offset:" + ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset);
        if ((!(p.h(this.Azf.Azd, ((com.tencent.mm.plugin.finder.event.c.a)paramb).xqx) ^ true)) && (Math.abs(((com.tencent.mm.plugin.finder.event.c.a)paramb).offset - this.Azf.Aze) <= 2000))
        {
          localObject1 = this.Azf;
          ((c)localObject1).Azb += 1;
        }
        this.Azf.Azd = ((com.tencent.mm.plugin.finder.event.c.a)paramb).xqx;
        this.Azf.Aze = ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset;
        if ((this.Azf.ebW() > 0) && (!this.Azf.Azc))
        {
          localObject2 = this.Azf.AyN;
          if (localObject2 != null) {
            ((b)localObject2).ebT();
          }
        }
        try
        {
          localObject1 = ((b)localObject2).AyX.jXW;
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
          ((JSONObject)localObject3).put("report_link", ((b)localObject2).AyX.SWE);
          ((JSONObject)localObject3).put("viewable", true);
          ((JSONObject)localObject3).put("exposure_type", 1);
          paramb.put("exp_time", ((b)localObject2).AyT);
          paramb.put("clk_time", 0);
          ((JSONObject)localObject3).put("weapp_extra_data", paramb.toString());
          paramb = ((JSONObject)localObject3).toString();
          p.j(paramb, "json.toString()");
          paramb = new cd(paramb);
          h.aGY().b((com.tencent.mm.an.q)paramb);
        }
        catch (Throwable paramb)
        {
          for (;;)
          {
            Log.printErrStackTrace(((b)localObject2).TAG, paramb, "reportFirstPlay", new Object[0]);
          }
        }
        this.Azf.Azc = true;
        c.b(this.Azf);
        AppMethodBeat.o(270784);
        return;
      }
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(270783);
      p.k(paramc, "dispatcher");
      p.k(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.c.a;
      AppMethodBeat.o(270783);
      return bool;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements f.c
  {
    public static final c Azg;
    
    static
    {
      AppMethodBeat.i(269972);
      Azg = new c();
      AppMethodBeat.o(269972);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class d
    implements f.c
  {
    d(c paramc) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(290381);
      this.Azf.getContext().finish();
      AppMethodBeat.o(290381);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class e
    implements DialogInterface.OnDismissListener
  {
    e(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(280509);
      paramDialogInterface = this.Azf.AvA;
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.xkW;
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.ehl();
          if (paramDialogInterface != null)
          {
            paramDialogInterface.gc(MMApplicationContext.getContext());
            AppMethodBeat.o(280509);
            return;
          }
        }
      }
      AppMethodBeat.o(280509);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sharerel.c
 * JD-Core Version:    0.7.0.1
 */