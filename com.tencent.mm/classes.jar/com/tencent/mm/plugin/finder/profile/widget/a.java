package com.tencent.mm.plugin.finder.profile.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/HeaderActivityWidget;", "", "header", "Landroid/view/View;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroid/view/View;Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "campaignEndTimeTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCampaignEndTimeTv", "()Landroid/widget/TextView;", "campaignEndTimeTv$delegate", "Lkotlin/Lazy;", "campaignNameTv", "getCampaignNameTv", "campaignNameTv$delegate", "campaignParticipateTv", "getCampaignParticipateTv", "campaignParticipateTv$delegate", "finderCampaignContainer", "Landroid/widget/RelativeLayout;", "getFinderCampaignContainer", "()Landroid/widget/RelativeLayout;", "finderCampaignContainer$delegate", "finderLiveView", "getFinderLiveView", "finderLiveView$delegate", "finderNoticeActivityLayout", "Landroid/widget/LinearLayout;", "getFinderNoticeActivityLayout", "()Landroid/widget/LinearLayout;", "finderNoticeActivityLayout$delegate", "handleCampaign", "", "source", "", "username", "firstReceivedScene", "", "initActivity", "initLiveWidget", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final j FgL;
  private final j FgM;
  private final j FgN;
  private final j FgO;
  private final j FgP;
  private final j FgQ;
  private final AppCompatActivity activity;
  
  public a(View paramView, AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(349294);
    this.activity = paramAppCompatActivity;
    this.FgL = k.cm((kotlin.g.a.a)new d(paramView));
    this.FgM = k.cm((kotlin.g.a.a)new b(paramView));
    this.FgN = k.cm((kotlin.g.a.a)new c(paramView));
    this.FgO = k.cm((kotlin.g.a.a)new a(paramView));
    this.FgP = k.cm((kotlin.g.a.a)new e(paramView));
    this.FgQ = k.cm((kotlin.g.a.a)new f(paramView));
    AppMethodBeat.o(349294);
  }
  
  private static final void a(String paramString, a parama, View paramView)
  {
    AppMethodBeat.i(349345);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramString);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/HeaderActivityWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramString, "$username");
    s.u(parama, "this$0");
    paramView = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
    paramString = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.AtP)
    {
      if (paramString != null)
      {
        paramView = new Intent();
        paramView.putExtra("key_activity_id", paramString.ocD);
        paramView.putExtra("key_activity_name", paramString.eventName);
        Log.i("Finder.FinderProfileHeaderUIC", "eventTopicId :" + paramString.ocD + " eventName:" + paramString.eventName);
        paramString = as.GSQ;
        as.a.a((Context)parama.activity, paramView, 0L, null, 0, 0, false);
        paramView.putExtra("key_activity_profile_src_type", "2");
        paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.aq((Context)parama.activity, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/HeaderActivityWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349345);
      return;
    }
  }
  
  private final TextView eKA()
  {
    AppMethodBeat.i(349301);
    TextView localTextView = (TextView)this.FgM.getValue();
    AppMethodBeat.o(349301);
    return localTextView;
  }
  
  private final TextView eKB()
  {
    AppMethodBeat.i(349308);
    TextView localTextView = (TextView)this.FgN.getValue();
    AppMethodBeat.o(349308);
    return localTextView;
  }
  
  private final TextView eKC()
  {
    AppMethodBeat.i(349315);
    TextView localTextView = (TextView)this.FgO.getValue();
    AppMethodBeat.o(349315);
    return localTextView;
  }
  
  private final RelativeLayout eKD()
  {
    AppMethodBeat.i(349323);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.FgP.getValue();
    AppMethodBeat.o(349323);
    return localRelativeLayout;
  }
  
  private final LinearLayout eKE()
  {
    AppMethodBeat.i(349332);
    LinearLayout localLinearLayout = (LinearLayout)this.FgQ.getValue();
    AppMethodBeat.o(349332);
    return localLinearLayout;
  }
  
  public final void azx(String paramString)
  {
    AppMethodBeat.i(349368);
    s.u(paramString, "username");
    aw.a((Paint)eKA().getPaint(), 0.8F);
    eKz().setOnClickListener(new a..ExternalSyntheticLambda0(paramString, this));
    AppMethodBeat.o(349368);
  }
  
  public final RelativeLayout eKz()
  {
    AppMethodBeat.i(349356);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.FgL.getValue();
    AppMethodBeat.o(349356);
    return localRelativeLayout;
  }
  
  public final void y(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(349383);
    s.u(paramString1, "source");
    s.u(paramString2, "username");
    if (((s.p(paramString1, "onSceneEnd:[NetSceneFinderUserPage]")) && (!paramBoolean)) || (s.p(paramString1, "onSceneEnd:[NetSceneCreateLiveNotice]")) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()))
    {
      AppMethodBeat.o(349383);
      return;
    }
    Log.i("Finder.FinderProfileHeaderUIC", s.X("handleCampaign ", paramString1));
    paramString1 = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
    paramString1 = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString2);
    if (paramString1 == null) {}
    for (paramString1 = null; paramString1 == null; paramString1 = paramString1.AtP)
    {
      paramString1 = null;
      if (paramString1 == null)
      {
        eKz().setVisibility(8);
        if (eKD().getVisibility() != 0) {
          eKE().setVisibility(8);
        }
      }
      AppMethodBeat.o(349383);
      return;
    }
    if (paramString1.ocD != 0L)
    {
      paramString2 = r.o((Context)this.activity, paramString1.endTime * 1000L);
      if (Util.isNullOrNil(paramString2))
      {
        Log.i("Finder.FinderProfileHeaderUIC", "活动过期 ：" + paramString1.endTime + ' ' + paramString2);
        eKz().setVisibility(8);
        AppMethodBeat.o(349383);
        return;
      }
      eKC().setText((CharSequence)paramString2);
      eKA().setText((CharSequence)this.activity.getResources().getString(e.h.finder_activity_title_prefix, new Object[] { paramString1.eventName }));
      eKB().setText((CharSequence)this.activity.getResources().getString(e.h.finder_activity_item_desc, new Object[] { r.TQ(paramString1.feedCount) }));
      eKz().setVisibility(0);
      eKE().setVisibility(0);
      paramString2 = eKz();
      if (paramString2 != null) {
        paramString2.setTag(e.e.finder_accessibility_activity_name, eKA().getText());
      }
      paramString2 = eKz();
      if (paramString2 != null) {
        paramString2.setTag(e.e.finder_accessibility_activity_participate, eKB().getText());
      }
      paramString2 = eKz();
      if (paramString2 != null) {
        paramString2.setTag(e.e.finder_accessibility_activity_end_time, eKC().getText());
      }
    }
    for (;;)
    {
      break;
      eKz().setVisibility(8);
      if (eKD().getVisibility() != 0) {
        eKE().setVisibility(8);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<TextView>
  {
    b(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    d(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    e(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    f(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.a
 * JD-Core Version:    0.7.0.1
 */