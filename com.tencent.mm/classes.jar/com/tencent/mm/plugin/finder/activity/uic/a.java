package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.cx;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "activityCreatorName", "", "activityName", "backBtn", "Landroid/widget/LinearLayout;", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "closeActivitySheet", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "coordinatorLayout", "Landroid/view/View;", "emptyView", "Landroid/widget/FrameLayout;", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "feedId", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1;", "forceVisibleRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "headerBgLayout", "headerContainer", "headerCoverView", "Landroid/widget/ImageView;", "headerDefaultCoverView", "headerMaskContainer", "Landroid/view/ViewGroup;", "headerMaskCoverView", "isAdjustCoverHeight", "", "isReceivedTopic", "moreBtn", "moreIcon", "progressBar", "Landroid/widget/ProgressBar;", "progressRunnable", "screenHeight", "", "screenWidth", "srcType", "startTime", "", "titleContainer", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "udfKv", "Lorg/json/JSONObject;", "getUdfKv", "()Lorg/json/JSONObject;", "setUdfKv", "(Lorg/json/JSONObject;)V", "vstId", "getVstId", "()Ljava/lang/String;", "adjustCoverImageView", "", "adjustView", "ignoreCover", "closeActivity", "createShareHeader", "dismissProgress", "fixActionBar", "forceCampaignVisible", "getIconUrl", "getShareDesc", "initScreenWidth", "initView", "isEnableDeleteActivity", "notShare", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "onTopicInfo", "optActivityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "report", "reportLeave", "setCover", "coverUrl", "setCoverMaskMargin", "height", "setCoverStyle", "setEmptyView", "setInvalidView", "setLoadingStatus", "setNormalStyle", "showBottomSheet", "showCloseSheet", "showProgress", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final a AtE;
  private static final int Aue;
  private static final int Auf;
  private static final int Aug;
  private static final int Auh;
  private static final int Aui;
  private static final int Auj;
  private static final float Auk;
  private static final float Aul;
  private ImageView AtF;
  private ImageView AtG;
  private ViewGroup AtH;
  private ImageView AtI;
  private View AtJ;
  private View AtK;
  private FrameLayout AtL;
  private String AtM;
  private LinearLayout AtN;
  private LinearLayout AtO;
  private awt AtP;
  private com.tencent.threadpool.i.d<?> AtQ;
  private View AtR;
  FrameLayout AtS;
  private WeImageView AtT;
  private com.tencent.mm.ui.widget.a.f AtU;
  private boolean AtV;
  private com.tencent.threadpool.i.d<?> AtW;
  private String AtX;
  private boolean AtY;
  public final String AtZ;
  private String Aua;
  private JSONObject Aub;
  private bui Auc;
  private final FinderActivityActionBarUIC.finderTopicInfoListener.1 Aud;
  private String feedId;
  private bxv hLt;
  private com.tencent.mm.ui.widget.a.f ngn;
  private WeImageView nhI;
  ProgressBar progressBar;
  private int pvg;
  private int sJv;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(348496);
    AtE = new a((byte)0);
    Aue = 10001;
    Auf = 10002;
    Aug = 10003;
    Auh = 10004;
    Aui = 10005;
    Auj = 10006;
    Auk = 1.333333F;
    Aul = 0.45F;
    AppMethodBeat.o(348496);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348173);
    this.AtM = "";
    this.AtX = "";
    this.startTime = cn.bDw();
    this.AtZ = (com.tencent.mm.model.z.bAW() + '-' + this.startTime);
    this.Aua = "";
    this.feedId = "";
    this.Aub = new JSONObject();
    this.Aud = new FinderActivityActionBarUIC.finderTopicInfoListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(348173);
  }
  
  private final void MR(int paramInt)
  {
    AppMethodBeat.i(348197);
    Object localObject = this.AtG;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((ImageView)localObject).getLayoutParams())
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(348197);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = paramInt;
    ImageView localImageView = this.AtG;
    if (localImageView != null) {
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(348197);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(348394);
    kotlin.g.b.s.u(parama, "this$0");
    parama.ngn = null;
    AppMethodBeat.o(348394);
  }
  
  private static final void a(a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(348366);
    kotlin.g.b.s.u(parama, "this$0");
    paramInt = paramMenuItem.getItemId();
    MMActivity localMMActivity;
    awt localawt;
    if (paramInt == Auf)
    {
      if (parama.dTs())
      {
        aa.makeText((Context)parama.getActivity(), e.h.finder_self_see_tips_forward, 0).show();
        AppMethodBeat.o(348366);
        return;
      }
      paramMenuItem = an.GhR;
      localMMActivity = (MMActivity)parama.getActivity();
      paramMenuItem = parama.AtP;
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        localawt = parama.AtP;
        if (localawt != null) {
          break label137;
        }
      }
      label137:
      for (l = 0L;; l = localawt.EOg)
      {
        an.a.a(localMMActivity, paramMenuItem, 7, l, parama.getIconUrl(), parama.dTu(), null, 9, "", parama.dTt());
        AppMethodBeat.o(348366);
        return;
        paramMenuItem = paramMenuItem.eventName;
        break;
      }
    }
    if (paramInt == Aug)
    {
      if (parama.dTs())
      {
        aa.makeText((Context)parama.getActivity(), e.h.finder_self_see_tips_sns, 0).show();
        AppMethodBeat.o(348366);
        return;
      }
      paramMenuItem = an.GhR;
      localMMActivity = (MMActivity)parama.getActivity();
      paramMenuItem = parama.AtP;
      if (paramMenuItem != null) {
        break label256;
      }
      paramMenuItem = null;
      localawt = parama.AtP;
      if (localawt != null) {
        break label264;
      }
    }
    label256:
    label264:
    for (long l = 0L;; l = localawt.EOg)
    {
      an.a.b(localMMActivity, paramMenuItem, 7, l, parama.getIconUrl(), parama.dTu(), null, 9, "", parama.dTt());
      AppMethodBeat.o(348366);
      return;
      paramMenuItem = paramMenuItem.eventName;
      break;
    }
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(348296);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    if (!parama.getActivity().isFinishing()) {
      parama.getActivity().finish();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348296);
  }
  
  private static final void a(a parama, bxv parambxv, boolean paramBoolean)
  {
    AppMethodBeat.i(348418);
    kotlin.g.b.s.u(parama, "this$0");
    View localView = parama.AtK;
    if (localView != null) {
      parama.MR(localView.getWidth());
    }
    parama.b(parambxv, paramBoolean);
    AppMethodBeat.o(348418);
  }
  
  private static final void a(a parama, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(348354);
    kotlin.g.b.s.u(parama, "this$0");
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if (params.jmw())
    {
      localObject1 = parama.getActivity().getString(e.h.app_share_to_weixin);
      kotlin.g.b.s.s(localObject1, "activity.getString(R.string.app_share_to_weixin)");
      localObject2 = parama.getActivity().getString(e.h.finder_share_timeline);
      kotlin.g.b.s.s(localObject2, "activity.getString(R.string.finder_share_timeline)");
      if (!parama.dTs()) {
        break label155;
      }
      localObject1 = av.GiL;
      localObject1 = av.eX("", e.h.finder_self_see_tips_forward);
      localObject2 = av.GiL;
      localObject2 = av.eX("", e.h.finder_self_see_tips_sns);
      bool2 = true;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      params.a(Auf, (CharSequence)localObject1, e.g.finder_icons_filled_share, parama.getResources().getColor(e.b.Brand), bool1);
      params.a(Aug, (CharSequence)localObject2, e.g.bottomsheet_icon_moment, 0, bool2);
      AppMethodBeat.o(348354);
      return;
      label155:
      bool2 = false;
    }
  }
  
  private final void a(bxv parambxv, boolean paramBoolean)
  {
    AppMethodBeat.i(348264);
    if (!this.AtY)
    {
      View localView = this.AtK;
      if (localView != null)
      {
        localView.post(new a..ExternalSyntheticLambda14(this, parambxv, paramBoolean));
        AppMethodBeat.o(348264);
      }
    }
    else
    {
      b(parambxv, paramBoolean);
    }
    AppMethodBeat.o(348264);
  }
  
  private static final void a(String paramString, a parama, final ImageView paramImageView, com.tencent.mm.loader.g.a.a parama1, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(348335);
    kotlin.g.b.s.u(paramString, "$coverUrl");
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramImageView, "$this_apply");
    if (paramBitmap != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(parama, paramImageView));
      Log.i("Finder.ActivityActionBarUIC", "[handleActivityProfileCover] [" + paramBitmap.getWidth() + ':' + paramBitmap.getHeight() + "] allocationByteCount=" + Util.getSizeKB(paramBitmap.getAllocationByteCount()) + " coverUrl=" + paramString);
    }
    AppMethodBeat.o(348335);
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(348412);
    kotlin.g.b.s.u(parama, "this$0");
    parama.AtU = null;
    AppMethodBeat.o(348412);
  }
  
  private static final void b(a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(348387);
    kotlin.g.b.s.u(parama, "this$0");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == Auh)
    {
      if (parama.AtU == null)
      {
        paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)parama.getActivity(), 1, true);
        paramMenuItem.h((CharSequence)parama.getResources().getString(e.h.finder_activity_close_hint), 17, parama.getResources().getDimensionPixelSize(e.c.SmallestTextSize));
        paramMenuItem.Vtg = new a..ExternalSyntheticLambda3(parama);
        paramMenuItem.GAC = new a..ExternalSyntheticLambda7(parama);
        paramMenuItem.aeLi = new a..ExternalSyntheticLambda9(parama);
        ah localah = ah.aiuX;
        parama.AtU = paramMenuItem;
      }
      parama = parama.AtU;
      if ((parama != null) && (!parama.isShowing())) {
        parama.dDn();
      }
      AppMethodBeat.o(348387);
      return;
    }
    if (paramInt == Auj)
    {
      paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
      paramMenuItem = (Context)parama.getActivity();
      parama = parama.AtP;
      if (parama != null) {
        break label195;
      }
    }
    label195:
    for (long l = 0L;; l = parama.ocD)
    {
      com.tencent.mm.plugin.finder.feed.logic.a.i(paramMenuItem, l);
      AppMethodBeat.o(348387);
      return;
    }
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(348322);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parama, "this$0");
    if (parama.ngn == null)
    {
      paramView = new com.tencent.mm.ui.widget.a.f((Context)parama.getActivity(), 0, true);
      localObject1 = af.mU((Context)parama.getContext()).inflate(e.f.finder_activity_share_header, null);
      localObject2 = (TextView)((View)localObject1).findViewById(e.e.activity_header_text);
      String str = parama.getContext().getResources().getString(e.h.finder_activity_announce_name);
      kotlin.g.b.s.s(str, "context.resources.getStr…r_activity_announce_name)");
      str = parama.getResources().getString(e.h.finder_share_campaign_announce, new Object[] { str });
      kotlin.g.b.s.s(str, "resources.getString(R.st…n_announce, announceName)");
      SpannableString localSpannableString = new SpannableString((CharSequence)kotlin.g.b.s.X(str, " "));
      Drawable localDrawable = bb.m((Context)parama.getContext(), e.g.icons_outlined_arrow, parama.getResources().getColor(e.b.FG_1));
      localDrawable.setBounds(0, 0, (int)parama.getContext().getResources().getDimension(e.c.finder_0_75_A), (int)parama.getContext().getResources().getDimension(e.c.Edge_1_5_A));
      localSpannableString.setSpan(new com.tencent.mm.ui.widget.a(localDrawable, 1), localSpannableString.length() - 1, localSpannableString.length(), 17);
      localSpannableString.setSpan(new q(str, parama.getContext().getResources().getColor(e.b.hot_tab_stream_link_color), parama.getContext().getResources().getColor(e.b.transparent), false, (kotlin.g.a.b)new b(parama)), str.length() - 6, str.length(), 17);
      ((TextView)localObject2).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s((Context)parama.getContext()));
      ((TextView)localObject2).setText((CharSequence)localSpannableString);
      kotlin.g.b.s.s(localObject1, "headerView");
      localObject2 = parama.AtP;
      if (localObject2 == null) {
        break label538;
      }
      localObject2 = ((awt)localObject2).ZHN;
      if ((localObject2 == null) || (((awx)localObject2).ZIh)) {
        break label538;
      }
    }
    label538:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramView.af((View)localObject1, true);
      }
      paramView.Vtg = new a..ExternalSyntheticLambda5(parama);
      paramView.GAC = new a..ExternalSyntheticLambda8(parama);
      paramView.GAz = new a..ExternalSyntheticLambda4(parama);
      paramView.agem = new a..ExternalSyntheticLambda6(parama);
      paramView.aeLi = new a..ExternalSyntheticLambda10(parama);
      localObject1 = ah.aiuX;
      parama.ngn = paramView;
      parama = parama.ngn;
      if (parama != null) {
        parama.dDn();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348322);
      return;
    }
  }
  
  private static final void b(a parama, com.tencent.mm.ui.base.s params)
  {
    long l = 0L;
    int k = 0;
    Object localObject2 = null;
    AppMethodBeat.i(348379);
    kotlin.g.b.s.u(parama, "this$0");
    boolean bool;
    Object localObject1;
    if (params.jmw())
    {
      bool = parama.dTs();
      localObject1 = parama.AtP;
      int j;
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        j = k;
        if (kotlin.g.b.s.p(localObject1, com.tencent.mm.model.z.bAW()))
        {
          localObject1 = av.GiL;
          localObject1 = parama.hLt;
          if (localObject1 != null) {
            break label171;
          }
          i = 0;
          label81:
          localObject1 = parama.hLt;
          if (localObject1 != null) {
            break label197;
          }
        }
      }
      for (;;)
      {
        j = k;
        if (!av.aw(i, l)) {
          j = 1;
        }
        if (j == 0) {
          break label219;
        }
        params.a(Auh, (CharSequence)parama.getResources().getString(e.h.finder_activity_close_text), e.g.finder_outlined_turnoff, bool);
        AppMethodBeat.o(348379);
        return;
        localObject1 = ((awt)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderContact)localObject1).username;
        break;
        label171:
        localObject1 = ((bxv)localObject1).aagK;
        if (localObject1 == null)
        {
          i = 0;
          break label81;
        }
        i = ((awt)localObject1).ZHK;
        break label81;
        label197:
        localObject1 = ((bxv)localObject1).aagK;
        if (localObject1 != null) {
          l = ((awt)localObject1).endTime;
        }
      }
      label219:
      localObject1 = parama.AtP;
      if (localObject1 != null) {
        break label278;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!kotlin.g.b.s.p(localObject1, com.tencent.mm.model.z.bAW())) {
        params.a(Auj, (CharSequence)parama.getResources().getString(e.h.finder_live_more_action_report), e.g.icons_outlined_report_problem, bool);
      }
      AppMethodBeat.o(348379);
      return;
      label278:
      FinderContact localFinderContact = ((awt)localObject1).contact;
      localObject1 = localObject2;
      if (localFinderContact != null) {
        localObject1 = localFinderContact.username;
      }
    }
  }
  
  private final void b(bxv parambxv, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(348288);
    Log.i("Finder.ActivityActionBarUIC", kotlin.g.b.s.X("onTopicInfo : ignoreCover ", Boolean.valueOf(paramBoolean)));
    Object localObject = this.AtS;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.progressBar;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(8);
    }
    if (parambxv == null)
    {
      parambxv = null;
      this.AtP = parambxv;
      parambxv = this.AtP;
      if (parambxv != null) {
        break label212;
      }
      parambxv = null;
      label82:
      this.AtM = parambxv;
      parambxv = this.AtP;
      if (parambxv != null) {
        break label220;
      }
      parambxv = null;
      label98:
      this.AtX = String.valueOf(parambxv);
      parambxv = this.AtR;
      if (parambxv != null) {
        parambxv.setVisibility(0);
      }
      parambxv = this.AtJ;
      if (parambxv != null) {
        parambxv.setVisibility(0);
      }
      parambxv = this.AtH;
      if (parambxv != null) {
        parambxv.setVisibility(0);
      }
      parambxv = this.AtP;
      if (parambxv != null) {
        break label242;
      }
      parambxv = str;
      label159:
      if (Util.isNullOrNil(parambxv)) {
        break label268;
      }
      if (!paramBoolean)
      {
        parambxv = this.AtP;
        if (parambxv != null) {
          break label250;
        }
        parambxv = "";
        label183:
        setCover(parambxv);
      }
      dTq();
    }
    for (;;)
    {
      this.AtY = true;
      AppMethodBeat.o(348288);
      return;
      parambxv = parambxv.aagK;
      break;
      label212:
      parambxv = parambxv.eventName;
      break label82;
      label220:
      parambxv = parambxv.contact;
      if (parambxv == null)
      {
        parambxv = null;
        break label98;
      }
      parambxv = parambxv.username;
      break label98;
      label242:
      parambxv = parambxv.coverImgUrl;
      break label159;
      label250:
      str = parambxv.coverImgUrl;
      parambxv = str;
      if (str != null) {
        break label183;
      }
      parambxv = "";
      break label183;
      label268:
      dTr();
    }
  }
  
  private static final void c(a parama)
  {
    AppMethodBeat.i(348423);
    kotlin.g.b.s.u(parama, "this$0");
    Log.i("Finder.ActivityActionBarUIC", "forceCampaignVisible execute!");
    parama.a(parama.hLt, true);
    AppMethodBeat.o(348423);
  }
  
  private static final void c(a parama, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(348406);
    kotlin.g.b.s.u(parama, "this$0");
    awt localawt;
    if (paramMenuItem.getItemId() == Aui)
    {
      localawt = parama.AtP;
      if (localawt != null) {
        break label60;
      }
      parama = (a)localObject;
      if (parama == null) {
        Log.i("Finder.ActivityActionBarUIC", "closeActivity invalid eventInfo null");
      }
    }
    AppMethodBeat.o(348406);
    return;
    label60:
    paramMenuItem = parama.AtP;
    if (paramMenuItem == null) {
      paramMenuItem = "";
    }
    for (;;)
    {
      localObject = k.aeZF;
      localObject = ((as)k.d(parama.getActivity()).q(as.class)).fou();
      new cx(1, Long.valueOf(localawt.ocD), paramMenuItem, null, (bui)localObject).f((Context)parama.getActivity(), parama.getResources().getString(e.h.finder_waiting), 500L);
      parama = Boolean.valueOf(com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new cx(1, Long.valueOf(localawt.ocD), paramMenuItem, null, (bui)localObject), 0));
      break;
      paramMenuItem = paramMenuItem.contact;
      if (paramMenuItem == null)
      {
        paramMenuItem = "";
      }
      else
      {
        localObject = paramMenuItem.username;
        paramMenuItem = (MenuItem)localObject;
        if (localObject == null) {
          paramMenuItem = "";
        }
      }
    }
  }
  
  private static final void c(a parama, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(348401);
    kotlin.g.b.s.u(parama, "this$0");
    if (params.jmw()) {
      params.a(Aui, parama.getResources().getColor(e.b.Red), (CharSequence)parama.getResources().getString(e.h.finder_activity_close_text));
    }
    AppMethodBeat.o(348401);
  }
  
  private static final void d(a parama)
  {
    AppMethodBeat.i(348432);
    kotlin.g.b.s.u(parama, "this$0");
    parama = parama.progressBar;
    if (parama != null)
    {
      Log.i("Finder.ActivityActionBarUIC", "showProgress visible change");
      if (parama.getVisibility() != 0) {
        parama.setVisibility(0);
      }
    }
    AppMethodBeat.o(348432);
  }
  
  private final void dTq()
  {
    AppMethodBeat.i(348208);
    ((MMActivity)getActivity()).getController().updataStatusBarIcon(true);
    int i = getResources().getColor(e.b.finder_activity_covered_white);
    Object localObject = this.nhI;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.AtT;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.AtI;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.AtG;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.AtF;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(348208);
  }
  
  private final void dTr()
  {
    AppMethodBeat.i(348216);
    ((MMActivity)getActivity()).getController().updataStatusBarIcon(aw.isDarkMode());
    int i = getResources().getColor(e.b.black_color);
    Object localObject = this.nhI;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.AtT;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.AtI;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.AtG;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.AtF;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(4);
    }
    localObject = this.AtH;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
    AppMethodBeat.o(348216);
  }
  
  private final boolean dTs()
  {
    AppMethodBeat.i(348224);
    boolean bool = Util.isNullOrNil(this.AtM);
    StringBuilder localStringBuilder = new StringBuilder("notShare ").append(bool).append(", ");
    Object localObject = this.AtP;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((awt)localObject).eventName)
    {
      Log.i("Finder.ActivityActionBarUIC", Util.isNullOrNil((String)localObject));
      AppMethodBeat.o(348224);
      return bool;
    }
  }
  
  private final atg dTt()
  {
    long l2 = 0L;
    AppMethodBeat.i(348246);
    atg localatg = new atg();
    Object localObject = this.AtP;
    long l1;
    if (localObject == null)
    {
      l1 = 0L;
      localatg.ZDJ = com.tencent.mm.ae.d.hF(l1);
      localObject = this.AtP;
      if (localObject != null) {
        break label180;
      }
      localObject = "";
      label55:
      localatg.ZDK = ((String)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label204;
      }
      localObject = "";
      label78:
      localatg.ZDL = ((String)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label248;
      }
      l1 = l2;
      label98:
      localatg.FOi = l1;
      localObject = this.AtP;
      if (localObject != null) {
        break label257;
      }
      localObject = null;
      label118:
      if (localObject != null) {
        break label285;
      }
    }
    label257:
    label285:
    for (localObject = MMApplicationContext.getContext().getText(e.h.finder_campaign_share_tail_text);; localObject = (CharSequence)localObject)
    {
      String str = (String)localObject;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localatg.svG = ((String)localObject);
      AppMethodBeat.o(348246);
      return localatg;
      l1 = ((awt)localObject).ocD;
      break;
      label180:
      str = ((awt)localObject).eventName;
      localObject = str;
      if (str != null) {
        break label55;
      }
      localObject = "";
      break label55;
      label204:
      localObject = ((awt)localObject).contact;
      if (localObject == null)
      {
        localObject = "";
        break label78;
      }
      str = ((FinderContact)localObject).nickname;
      localObject = str;
      if (str != null) {
        break label78;
      }
      localObject = "";
      break label78;
      label248:
      l1 = ((awt)localObject).FOi;
      break label98;
      localObject = ((awt)localObject).ZHN;
      if (localObject == null)
      {
        localObject = null;
        break label118;
      }
      localObject = ((awx)localObject).ZIj;
      break label118;
    }
  }
  
  private final String dTu()
  {
    AppMethodBeat.i(348255);
    Object localObject = k.aeZF;
    localObject = ((c)k.d(getActivity()).q(c.class)).AuO;
    int i;
    String str;
    if (localObject == null)
    {
      i = 0;
      str = r.ip(2, i);
      localObject = this.AtP;
      if (localObject != null) {
        break label99;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label136;
      }
      localObject = getContext().getString(e.h.finder_activity_item_desc, new Object[] { str });
      kotlin.g.b.s.s(localObject, "context.getString(R.stri…ity_item_desc, countText)");
      AppMethodBeat.o(348255);
      return localObject;
      i = ((com.tencent.mm.plugin.finder.activity.view.a)localObject).AwK;
      break;
      label99:
      localObject = ((awt)localObject).ZHN;
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = ((awx)localObject).ZId;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = kotlin.g.b.s.X(str, localObject);
        }
      }
    }
    label136:
    AppMethodBeat.o(348255);
    return localObject;
  }
  
  private final String getIconUrl()
  {
    Object localObject = this.AtP;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((awt)localObject).coverImgUrl;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  private static final void j(ImageView paramImageView)
  {
    AppMethodBeat.i(348341);
    kotlin.g.b.s.u(paramImageView, "$this_apply");
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.height = ((int)(paramImageView.getWidth() * Auk));
    paramImageView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(348341);
  }
  
  private final void setCover(String paramString)
  {
    AppMethodBeat.i(348186);
    ImageView localImageView = this.AtF;
    if (localImageView != null)
    {
      Object localObject = new com.tencent.mm.plugin.finder.loader.i(paramString);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject = com.tencent.mm.plugin.finder.loader.p.eCl().dk(localObject);
      localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.a.b)localObject).a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExU)).a(new a..ExternalSyntheticLambda2(paramString, this, localImageView)).d(localImageView);
    }
    Log.i("Finder.ActivityActionBarUIC", "forceCampaignVisible: ");
    paramString = this.AtW;
    if (paramString != null) {
      paramString.cancel(false);
    }
    this.AtW = com.tencent.threadpool.h.ahAA.o(new a..ExternalSyntheticLambda13(this), 2000L);
    AppMethodBeat.o(348186);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348592);
    super.onCreate(paramBundle);
    this.Aud.alive();
    this.AtJ = getActivity().findViewById(e.e.activity_profile_title_container);
    this.AtK = getActivity().findViewById(e.e.activity_profile_header);
    this.AtL = ((FrameLayout)getActivity().findViewById(e.e.finder_profile_activity_header_bg_layout));
    this.AtR = getActivity().findViewById(e.e.coordinatorLayout);
    paramBundle = this.AtL;
    Object localObject;
    int i;
    if (paramBundle != null)
    {
      localObject = paramBundle.getLayoutParams();
      i = bf.getStatusBarHeight((Context)getActivity());
      float f = getActivity().getResources().getDimension(e.c.DefaultActionbarHeightPort);
      ((ViewGroup.LayoutParams)localObject).height = kotlin.h.a.eH(i + f);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramBundle = this.AtK;
      if (paramBundle != null) {
        paramBundle.setMinimumHeight(kotlin.h.a.eH(i + f));
      }
    }
    com.tencent.mm.kernel.h.aZW().a(5909, (com.tencent.mm.am.h)this);
    paramBundle = (LinearLayout)getActivity().findViewById(e.e.finder_activity_profile_cancel_btn);
    if (paramBundle == null)
    {
      paramBundle = null;
      this.AtN = paramBundle;
      this.nhI = ((WeImageView)getActivity().findViewById(e.e.finder_activity_profile_cancel_icon));
      this.AtT = ((WeImageView)getActivity().findViewById(e.e.finder_activity_profile_more_icon));
      paramBundle = (LinearLayout)getActivity().findViewById(e.e.finder_activity_profile_more_btn);
      if (paramBundle != null) {
        break label749;
      }
      paramBundle = null;
      label247:
      this.AtO = paramBundle;
      this.AtF = ((ImageView)getActivity().findViewById(e.e.activity_profile_cover));
      this.AtG = ((ImageView)getActivity().findViewById(e.e.activity_profile_cover_mask));
      this.AtH = ((ViewGroup)getActivity().findViewById(e.e.activity_profile_cover_container));
      this.progressBar = ((ProgressBar)getActivity().findViewById(e.e.activity_progress));
      this.AtS = ((FrameLayout)getActivity().findViewById(e.e.empty_view));
      if (!Util.isNullOrNil(getIntent().getStringExtra("key_cover_url")))
      {
        paramBundle = this.AtS;
        if (paramBundle != null) {
          paramBundle.setBackground(getResources().getDrawable(e.d.recycler_view_dark_gradient_bg));
        }
      }
      paramBundle = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      this.sJv = paramBundle.widthPixels;
      this.pvg = paramBundle.heightPixels;
      dTr();
      paramBundle = this.AtF;
      if (paramBundle != null) {
        paramBundle.post(new a..ExternalSyntheticLambda11(paramBundle));
      }
      MR(this.sJv * (int)Auk);
      paramBundle = this.progressBar;
      if (paramBundle != null) {
        break label769;
      }
    }
    label769:
    for (paramBundle = null;; paramBundle = Integer.valueOf(paramBundle.getVisibility()))
    {
      Log.i("Finder.ActivityActionBarUIC", kotlin.g.b.s.X("showProgress: ", paramBundle));
      paramBundle = this.AtQ;
      if (paramBundle != null) {
        paramBundle.cancel(false);
      }
      this.AtQ = com.tencent.threadpool.h.ahAA.o(new a..ExternalSyntheticLambda12(this), 500L);
      long l1 = getIntent().getLongExtra("key_activity_id", 0L);
      localObject = getIntent().getStringExtra("key_from_user");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      i = getIntent().getIntExtra("key_report_scene", 0);
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
        long l2 = getIntent().getLongExtra("key_ref_object_id", 0L);
        localObject = com.tencent.mm.ae.d.hF(l1);
        k localk = k.aeZF;
        com.tencent.mm.plugin.finder.report.z.a(l2, i, 6L, paramBundle, 0, 2, (String)localObject, ((as)k.nq((Context)getContext()).q(as.class)).zIO);
      }
      paramBundle = this.AtF;
      if (paramBundle != null) {
        paramBundle.setVisibility(4);
      }
      paramBundle = this.AtH;
      if (paramBundle != null) {
        paramBundle.setVisibility(4);
      }
      paramBundle = this.AtR;
      if (paramBundle != null) {
        paramBundle.setVisibility(4);
      }
      paramBundle = this.AtI;
      if (paramBundle != null) {
        paramBundle.setVisibility(4);
      }
      paramBundle = this.AtS;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.progressBar;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      AppMethodBeat.o(348592);
      return;
      paramBundle.setOnClickListener(new a..ExternalSyntheticLambda1(this));
      localObject = ah.aiuX;
      break;
      label749:
      paramBundle.setOnClickListener(new a..ExternalSyntheticLambda0(this));
      localObject = ah.aiuX;
      break label247;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348606);
    super.onDestroy();
    this.Aud.dead();
    com.tencent.mm.kernel.h.aZW().b(5909, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(348606);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(348613);
    if (((paramp instanceof cx)) && (((cx)paramp).scene == 1))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
        com.tencent.mm.b.h localh = com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp();
        paramString = this.AtP;
        if (paramString == null) {
          paramString = "";
        }
        for (;;)
        {
          localh.remove(paramString);
          if (getActivity().isFinishing()) {
            break;
          }
          getActivity().finish();
          AppMethodBeat.o(348613);
          return;
          paramString = paramString.contact;
          if (paramString == null)
          {
            paramString = "";
          }
          else
          {
            paramp = paramString.username;
            paramString = paramp;
            if (paramp == null) {
              paramString = "";
            }
          }
        }
      }
      if (paramInt2 == -4059)
      {
        paramString = k.aeZF;
        paramString = ((c)k.d(getActivity()).q(c.class)).AuO;
        if (paramString != null)
        {
          paramp = paramString.AwG;
          if (paramp != null) {
            paramp.setVisibility(8);
          }
          paramp = paramString.AwH;
          if (paramp != null) {
            paramp.setText((CharSequence)paramString.dTT());
          }
          if (!Util.isNullOrNil(paramString.coverUrl))
          {
            paramp = paramString.AuW;
            if (paramp != null) {
              paramp.setBackgroundResource(e.d.finder_activity_covered_finished_btn_bg);
            }
            paramp = paramString.AwH;
            if (paramp != null)
            {
              paramp.setTextColor(paramString.lzt.getResources().getColor(e.b.BW_100_Alpha_0_3));
              AppMethodBeat.o(348613);
            }
          }
          else
          {
            paramp = paramString.AuW;
            if (paramp != null) {
              paramp.setBackgroundResource(e.d.finder_activity_normal_finished_btn_bg);
            }
            paramp = paramString.AwH;
            if (paramp != null) {
              paramp.setTextColor(paramString.lzt.getResources().getColor(e.b.FG_2));
            }
          }
        }
      }
    }
    AppMethodBeat.o(348613);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(348601);
    super.onStop();
    Object localObject1 = k.aeZF;
    this.Auc = ((as)k.nq((Context)getContext()).q(as.class)).fou();
    this.feedId = com.tencent.mm.ae.d.hF(getIntent().getLongExtra("key_feed_report_id", -1L));
    Object localObject2 = getIntent().getStringExtra("key_activity_profile_src_type");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.Aua = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("key_extra_report_info");
    int i;
    if (localObject1 == null)
    {
      localObject1 = "";
      i = getIntent().getIntExtra("key_enter_scene", 0);
      if (!kotlin.g.b.s.p(this.Aua, "1")) {
        break label288;
      }
      this.Aub.put("src_type", this.Aua).put("vst_id", this.AtZ).put("src_ext_info", new JSONObject().put("feedid", this.feedId));
      label178:
      if (i == 15) {
        this.Aub = new JSONObject((String)localObject1);
      }
      localObject2 = k.aeZF;
      localObject2 = ((c)k.d(getActivity()).q(c.class)).AuO;
      if (localObject2 != null) {
        break label380;
      }
    }
    label288:
    label380:
    for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.finder.activity.view.a)localObject2).AwO)
    {
      if (localObject2 == null) {
        break label388;
      }
      Iterator localIterator = ((JSONObject)localObject2).keys();
      kotlin.g.b.s.s(localIterator, "it.keys()");
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.Aub.put(str, ((JSONObject)localObject2).opt(str));
      }
      break;
      if (kotlin.g.b.s.p(this.Aua, "2"))
      {
        this.Aub.put("src_type", this.Aua).put("vst_id", this.AtZ).put("src_ext_info", new JSONObject().put("finderusername", this.AtX));
        break label178;
      }
      this.Aub.put("src_type", this.Aua).put("vst_id", this.AtZ);
      break label178;
    }
    label388:
    localObject2 = x.FrX;
    x.a((Context)getContext(), this.Aub, true, 0L, this.startTime, this.Auc);
    this.Aub = new JSONObject();
    if (kotlin.g.b.s.p(this.Aua, "1")) {
      this.Aub.put("src_type", this.Aua).put("vst_id", this.AtZ).put("src_ext_info", new JSONObject().put("feedid", this.feedId));
    }
    for (;;)
    {
      if (i == 15) {
        this.Aub = new JSONObject((String)localObject1);
      }
      localObject1 = x.FrX;
      x.a((Context)getContext(), this.Aub, cn.bDw() - this.startTime, this.Auc);
      AppMethodBeat.o(348601);
      return;
      if (kotlin.g.b.s.p(this.Aua, "2")) {
        this.Aub.put("src_type", this.Aua).put("vst_id", this.AtZ).put("src_ext_info", new JSONObject().put("finderusername", this.AtX));
      } else {
        this.Aub.put("src_type", this.Aua).put("vst_id", this.AtZ);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$Companion;", "", "()V", "FIX_RATIO", "", "MASK_TOP_MARGIN_RATIO", "MENU_ID_CLOSE_ACTIVITY", "", "MENU_ID_COMPLAIN_ACTIVITY", "MENU_ID_CONFIRM_CLOSE_ACTIVITY", "MENU_ID_MORE", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(a parama, ImageView paramImageView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.a
 * JD-Core Version:    0.7.0.1
 */