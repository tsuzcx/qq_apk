package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kb;
import com.tencent.mm.kernel.c;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.ah;
import com.tencent.mm.plugin.finder.live.report.q.ak;
import com.tencent.mm.plugin.finder.live.report.q.bm;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "actionGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "authInfoIv", "Landroid/widget/ImageView;", "authInfoTv", "Landroid/widget/TextView;", "avatarIcon", "banCommentIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "blankArea", "closeBtn", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "contentIsShow", "", "curLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getCurLiveContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "setCurLiveContact", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "finderUserArrowIv", "followBtnIcon", "followBtnLayout", "followBtnTv", "followInfoGroup", "followInfoTv", "followListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FollowUserEvent;", "globalLevelTv", "gotoLiveRoomeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "username", "", "getGotoLiveRoomeCallback", "()Lkotlin/jvm/functions/Function1;", "setGotoLiveRoomeCallback", "(Lkotlin/jvm/functions/Function1;)V", "gotoProfileCallback", "getGotoProfileCallback", "setGotoProfileCallback", "hideContentCallback", "Lkotlin/Function0;", "getHideContentCallback", "()Lkotlin/jvm/functions/Function0;", "setHideContentCallback", "(Lkotlin/jvm/functions/Function0;)V", "isOtherRoomUser", "()Z", "setOtherRoomUser", "(Z)V", "isPrivacyUser", "setPrivacyUser", "leftBtn", "Landroid/widget/Button;", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "loadingBar", "Landroid/widget/ProgressBar;", "moreAction", "Landroid/widget/FrameLayout;", "moreActionCallback", "getMoreActionCallback", "setMoreActionCallback", "profileInfoGroup", "Landroid/widget/RelativeLayout;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setReportObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "rightBtn", "getRoot", "()Landroid/view/ViewGroup;", "showContentCallback", "getShowContentCallback", "setShowContentCallback", "singleBtn", "sourceType", "", "getSourceType", "()I", "setSourceType", "(I)V", "titleTv", "userInfoTv", "userSigatureTv", "activate", "buildBottomSheet", "deActivate", "followFinderUser", "followType", "getFinderLiveContactInfo", "contact", "gotoLiveRoom", "gotoProfile", "handleFollowBtn", "hideProfile", "isAssistant", "isLandscape", "onClick", "v", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshBanCommentIcon", "disableComment", "sendGift", "sendPrivacyMsg", "setActionState", "setAuthInfo", "setFinderUserIcon", "setFollows", "setGlobalLevel", "setMoreActionState", "setTitleContent", "titleSpan", "Landroid/text/SpannableString;", "setUserInfo", "setUserSignature", "showCenterCustomizeToast", "msg", "res", "showProfile", "liveContact", "updateButtonByTag", "button", "needUpdateBg", "updateProfile", "updateProfileInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  implements View.OnClickListener, com.tencent.mm.am.h
{
  public static final am.b Erz;
  private com.tencent.mm.ui.widget.a.f CVD;
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  public kotlin.g.a.a<ah> ErA;
  public kotlin.g.a.a<ah> ErB;
  public kotlin.g.a.b<? super String, ah> ErC;
  public kotlin.g.a.a<ah> ErD;
  public kotlin.g.a.b<? super String, ah> ErE;
  bgh ErF;
  boolean ErG;
  private boolean ErH;
  private final RelativeLayout ErI;
  private final ImageView ErJ;
  private final TextView ErK;
  private final WeImageView ErL;
  private final TextView ErM;
  private final TextView ErN;
  private final FrameLayout ErO;
  public final WeImageView ErP;
  private final TextView ErQ;
  private final View ErR;
  private final TextView ErS;
  private final Button ErT;
  private final Button ErU;
  private final View ErV;
  private final ImageView ErW;
  private final TextView ErX;
  private IListener<kb> ErY;
  private boolean ErZ;
  public final String TAG;
  public final ViewGroup mJe;
  private final View niB;
  private final View niW;
  public final LiveBottomSheetPanel niX;
  private final ProgressBar njj;
  private final View nmp;
  private final ImageView nnV;
  private bui reportObj;
  private int sourceType;
  private final TextView titleTv;
  private final Button zWj;
  
  static
  {
    AppMethodBeat.i(361923);
    Erz = new am.b((byte)0);
    AppMethodBeat.o(361923);
  }
  
  public am(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.b paramb)
  {
    AppMethodBeat.i(361656);
    this.mJe = paramViewGroup;
    this.CwG = paramb;
    this.TAG = "FinderLiveMemebrProfileWidget";
    this.ErI = ((RelativeLayout)this.mJe.findViewById(p.e.BOj));
    this.titleTv = ((TextView)this.mJe.findViewById(p.e.BXV));
    this.ErJ = ((ImageView)this.mJe.findViewById(p.e.BBJ));
    this.ErK = ((TextView)this.mJe.findViewById(p.e.BNZ));
    this.ErL = ((WeImageView)this.mJe.findViewById(p.e.BUI));
    this.ErM = ((TextView)this.mJe.findViewById(p.e.CbK));
    this.ErN = ((TextView)this.mJe.findViewById(p.e.CbM));
    this.nnV = ((ImageView)this.mJe.findViewById(p.e.BOk));
    this.niB = this.mJe.findViewById(p.e.BOb);
    this.niW = this.mJe.findViewById(p.e.BOa);
    this.niX = ((LiveBottomSheetPanel)this.mJe.findViewById(p.e.BOc));
    this.ErO = ((FrameLayout)this.mJe.findViewById(p.e.BOm));
    this.ErP = ((WeImageView)this.mJe.findViewById(p.e.BBM));
    this.ErQ = ((TextView)this.mJe.findViewById(p.e.BOi));
    this.ErR = this.mJe.findViewById(p.e.BOg);
    this.ErS = ((TextView)this.mJe.findViewById(p.e.BOh));
    this.nmp = this.mJe.findViewById(p.e.BNY);
    this.ErT = ((Button)this.mJe.findViewById(p.e.BOl));
    this.zWj = ((Button)this.mJe.findViewById(p.e.BOn));
    this.ErU = ((Button)this.mJe.findViewById(p.e.BOo));
    paramViewGroup = this.mJe.findViewById(p.e.loading_progress);
    kotlin.g.b.s.s(paramViewGroup, "root.findViewById(R.id.loading_progress)");
    this.njj = ((ProgressBar)paramViewGroup);
    this.ErV = this.mJe.findViewById(p.e.BOe);
    this.ErW = ((ImageView)this.mJe.findViewById(p.e.BOd));
    this.ErX = ((TextView)this.mJe.findViewById(p.e.BOf));
    paramViewGroup = this.niX;
    paramViewGroup.setTranslationY(bf.bf(this.mJe.getContext()).y);
    paramViewGroup.setOnVisibilityListener((kotlin.g.a.b)new a(this));
    int i;
    if ((paramViewGroup.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      if (this.mJe.getContext().getResources().getConfiguration().orientation != 2) {
        break label593;
      }
      i = 1;
      if (i != 0) {
        break label599;
      }
      this.niX.setPadding(this.niX.getPaddingLeft(), this.niX.getPaddingTop(), this.niX.getPaddingRight(), bf.bk(this.mJe.getContext()));
    }
    for (;;)
    {
      i = bf.bk(this.mJe.getContext());
      paramViewGroup = this.nmp.getLayoutParams();
      if (paramViewGroup != null) {
        break label658;
      }
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(361656);
      throw paramViewGroup;
      label593:
      i = 0;
      break;
      label599:
      paramViewGroup.getLayoutParams().width = bf.bf(this.mJe.getContext()).y;
      paramViewGroup = paramViewGroup.getLayoutParams();
      if (paramViewGroup == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(361656);
        throw paramViewGroup;
      }
      ((LinearLayout.LayoutParams)paramViewGroup).gravity = 1;
    }
    label658:
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin = (i + paramViewGroup.bottomMargin);
    this.ErY = ((IListener)new FinderLiveMemebrProfileWidget.3(this, com.tencent.mm.app.f.hfK));
    this.niB.setOnClickListener((View.OnClickListener)this);
    this.niW.setOnClickListener((View.OnClickListener)this);
    this.ErO.setOnClickListener((View.OnClickListener)this);
    this.ErV.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramViewGroup = this.mJe.getContext();
    kotlin.g.b.s.s(paramViewGroup, "root.context");
    float f = com.tencent.mm.plugin.finder.accessibility.a.g(paramViewGroup, 17.0F);
    this.ErT.setTextSize(1, f);
    this.zWj.setTextSize(1, f);
    this.ErU.setTextSize(1, f);
    AppMethodBeat.o(361656);
  }
  
  private final void Qk(int paramInt)
  {
    AppMethodBeat.i(361836);
    Object localObject1 = this.ErF;
    Object localObject2;
    Object localObject3;
    com.tencent.mm.plugin.h localh;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.reportObj;
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = com.tencent.mm.ui.component.k.aeZF;
          localObject2 = this.mJe.getContext();
          kotlin.g.b.s.s(localObject2, "root.context");
          localObject3 = ((bn)com.tencent.mm.ui.component.k.nq((Context)localObject2).cq(bn.class)).fou();
        }
        localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(localObject2, "service(IFinderCommonService::class.java)");
        localh = (com.tencent.mm.plugin.h)localObject2;
        if (this.CwG != null) {
          break label145;
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      h.a.a(localh, (bui)localObject3, (String)localObject1, paramInt, 0L, false, null, (bma)localObject2, 40);
      AppMethodBeat.o(361836);
      return;
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break;
      label145:
      localObject2 = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((ap)localObject2).ekj();
      }
    }
  }
  
  private static final void a(am paramam)
  {
    AppMethodBeat.i(361901);
    kotlin.g.b.s.u(paramam, "this$0");
    paramam.CVD = null;
    AppMethodBeat.o(361901);
  }
  
  private static final void a(am paramam, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(361895);
    kotlin.g.b.s.u(paramam, "this$0");
    if (paramMenuItem.getItemId() == 0)
    {
      paramMenuItem = paramam.CVD;
      if (paramMenuItem != null) {
        paramMenuItem.cyW();
      }
      paramMenuItem = bh.ABm;
      paramam.Qk(bh.dVs());
    }
    AppMethodBeat.o(361895);
  }
  
  private static final void a(am paramam, View paramView)
  {
    int i = 0;
    AppMethodBeat.i(361855);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramam);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramam, "this$0");
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int j;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      j = q.ah.Dyg.value;
      int k = paramam.sourceType;
      localObject = paramam.ErF;
      if (localObject == null)
      {
        i = 0;
        paramView.az(j, k, i);
        paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.bm.DBF);
        }
        paramam.niX.hide();
        paramView = paramam.ErC;
        if (paramView != null)
        {
          paramam = paramam.ErF;
          if (paramam != null) {
            break label247;
          }
          paramam = null;
        }
      }
    }
    for (;;)
    {
      paramView.invoke(paramam);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361855);
      return;
      i = ((bgh)localObject).ZEt;
      break;
      paramView = com.tencent.mm.plugin.finder.live.report.k.Doi;
      j = q.ak.Dyt.value;
      localObject = paramam.ErF;
      if (localObject == null) {}
      for (;;)
      {
        paramView.hK(j, i);
        break;
        i = ((bgh)localObject).ZEt;
      }
      label247:
      paramam = paramam.contact;
      if (paramam == null) {
        paramam = null;
      } else {
        paramam = paramam.username;
      }
    }
  }
  
  private static final void a(am paramam, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(361890);
    kotlin.g.b.s.u(paramam, "this$0");
    com.tencent.mm.ui.widget.a.f localf = paramam.CVD;
    if (localf != null) {
      localf.setFooterView(null);
    }
    params.clear();
    params.a(0, paramam.mJe.getContext().getResources().getColor(p.b.live_title_host_close_btn_color), (CharSequence)paramam.mJe.getContext().getResources().getString(p.h.finder_unfollow));
    AppMethodBeat.o(361890);
  }
  
  private final void a(bgh parambgh, int paramInt)
  {
    String str = null;
    AppMethodBeat.i(361681);
    Object localObject1 = parambgh.contact;
    if (localObject1 != null)
    {
      localObject1 = ((FinderContact)localObject1).headUrl;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject2 = this.nnV;
        kotlin.g.b.s.s(localObject2, "avatarIcon");
        com.tencent.mm.plugin.finder.live.utils.a.c((ImageView)localObject2, (String)localObject1, parambgh.ZEt);
      }
    }
    Object localObject2 = this.mJe.getContext();
    localObject1 = aw.Gjk;
    localObject1 = parambgh.contact;
    FinderContact localFinderContact;
    if (localObject1 == null)
    {
      localObject1 = null;
      localFinderContact = parambgh.contact;
      if (localFinderContact != null) {
        break label231;
      }
      label91:
      localObject1 = com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)aw.is((String)localObject1, str), this.titleTv.getTextSize());
      kotlin.g.b.s.s(localObject1, "spanForSmiley(root.conte…kname), titleTv.textSize)");
      a(parambgh, (SpannableString)localObject1);
      b(parambgh);
      c(parambgh);
      d(parambgh);
      e(parambgh);
      f(parambgh);
      g(parambgh);
      h(parambgh);
      if (paramInt != 3) {
        break label241;
      }
      this.ErO.setVisibility(4);
    }
    for (;;)
    {
      i(parambgh);
      Log.i(this.TAG, "updateProfileInfo," + j(parambgh) + ",sourceType:" + paramInt);
      AppMethodBeat.o(361681);
      return;
      localObject1 = ((FinderContact)localObject1).username;
      break;
      label231:
      str = localFinderContact.nickname;
      break label91;
      label241:
      eBe();
    }
  }
  
  private final void a(bgh parambgh, SpannableString paramSpannableString)
  {
    int i = 1;
    AppMethodBeat.i(361686);
    this.titleTv.setText((CharSequence)paramSpannableString);
    if (parambgh.ZPQ == 1) {}
    while (i != 0)
    {
      this.ErP.setVisibility(0);
      AppMethodBeat.o(361686);
      return;
      i = 0;
    }
    this.ErP.setVisibility(8);
    AppMethodBeat.o(361686);
  }
  
  private final void b(Button paramButton, boolean paramBoolean)
  {
    AppMethodBeat.i(361812);
    paramButton.setVisibility(0);
    Object localObject = paramButton.getTag();
    if (kotlin.g.b.s.p(localObject, Integer.valueOf(1)))
    {
      paramButton.setText((CharSequence)this.mJe.getContext().getString(p.h.ClL));
      if (paramBoolean)
      {
        paramButton.setBackground(this.mJe.getContext().getDrawable(p.d.BAi));
        paramButton.setTextColor(this.mJe.getContext().getResources().getColor(p.b.BW_100_Alpha_0_9));
      }
      paramButton.setOnClickListener(new am..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(361812);
      return;
    }
    if (kotlin.g.b.s.p(localObject, Integer.valueOf(2)))
    {
      paramButton.setText((CharSequence)this.mJe.getContext().getString(p.h.finder_conversation_message_title));
      if (paramBoolean)
      {
        paramButton.setBackground(this.mJe.getContext().getDrawable(p.d.BzN));
        paramButton.setTextColor(this.mJe.getContext().getResources().getColor(p.b.White));
      }
      paramButton.setOnClickListener(new am..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(361812);
      return;
    }
    if (kotlin.g.b.s.p(localObject, Integer.valueOf(3)))
    {
      paramButton.setText((CharSequence)this.mJe.getContext().getString(p.h.ClM));
      if (paramBoolean)
      {
        paramButton.setBackground(this.mJe.getContext().getDrawable(p.d.BzN));
        paramButton.setTextColor(this.mJe.getContext().getResources().getColor(p.b.White));
      }
      paramButton.setOnClickListener(new am..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(361812);
      return;
    }
    if (kotlin.g.b.s.p(localObject, Integer.valueOf(4)))
    {
      paramButton.setText((CharSequence)this.mJe.getContext().getString(p.h.ClO));
      if (paramBoolean)
      {
        paramButton.setBackground(this.mJe.getContext().getDrawable(p.d.BzN));
        paramButton.setTextColor(this.mJe.getContext().getResources().getColor(p.b.White));
      }
      paramButton.setOnClickListener(new am..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(361812);
      return;
    }
    kotlin.g.b.s.p(localObject, Integer.valueOf(0));
    paramButton.setVisibility(8);
    AppMethodBeat.o(361812);
  }
  
  private static final void b(am paramam, View paramView)
  {
    AppMethodBeat.i(361867);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramam);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramam, "this$0");
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int i;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      int j = q.ah.Dyh.value;
      int k = paramam.sourceType;
      localObject1 = paramam.ErF;
      if (localObject1 == null)
      {
        i = 0;
        paramView.az(j, k, i);
      }
    }
    else
    {
      paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTo().bmg()).intValue() > 0) {
        break label203;
      }
      aa.makeText(paramam.mJe.getContext(), (CharSequence)paramam.mJe.getContext().getResources().getString(p.h.Cgw), 0).show();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361867);
      return;
      i = ((bgh)localObject1).ZEt;
      break;
      label203:
      paramView = paramam.ErF;
      if (paramView != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.bm.DBA);
        }
        paramam.niX.hide();
        localObject1 = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        paramam = paramam.mJe.getContext();
        kotlin.g.b.s.s(paramam, "root.context");
        localObject2 = z.bAW();
        kotlin.g.b.s.s(localObject2, "getMyFinderUsername()");
        ((com.tencent.mm.plugin.f)localObject1).a(paramam, (String)localObject2, paramView);
      }
    }
  }
  
  private final void b(bgh parambgh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(361698);
    if (parambgh.ZEt == 2)
    {
      this.ErJ.setVisibility(8);
      this.ErK.setVisibility(8);
      AppMethodBeat.o(361698);
      return;
    }
    Object localObject1 = parambgh.contact;
    label53:
    int i;
    label59:
    Object localObject3;
    ImageView localImageView;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label192;
      }
      i = 0;
      if (i <= 0) {
        break label331;
      }
      this.ErJ.setVisibility(0);
      localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject3, "service(IFinderCommonService::class.java)");
      localObject3 = (com.tencent.mm.plugin.h)localObject3;
      localImageView = this.ErJ;
      kotlin.g.b.s.s(localImageView, "authInfoIv");
      parambgh = parambgh.contact;
      if (parambgh != null) {
        break label200;
      }
    }
    label192:
    label200:
    for (parambgh = null;; parambgh = parambgh.authInfo)
    {
      h.a.a((com.tencent.mm.plugin.h)localObject3, localImageView, parambgh, 0, null, 8);
      switch (i)
      {
      default: 
        this.ErK.setVisibility(8);
        AppMethodBeat.o(361698);
        return;
        localObject1 = ((FinderContact)localObject1).authInfo;
        break label53;
        i = ((FinderAuthInfo)localObject1).authIconType;
        break label59;
      }
    }
    if (localObject1 == null) {
      parambgh = localObject2;
    }
    while (parambgh == null)
    {
      ((am)this).ErK.setVisibility(8);
      AppMethodBeat.o(361698);
      return;
      localObject1 = ((FinderAuthInfo)localObject1).authProfession;
      parambgh = localObject2;
      if (localObject1 != null)
      {
        this.ErK.setVisibility(0);
        this.ErK.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.finder_contact_auth, new Object[] { localObject1 }));
        parambgh = ah.aiuX;
      }
    }
    AppMethodBeat.o(361698);
    return;
    this.ErK.setVisibility(0);
    this.ErK.setText(p.h.finder_has_real_name);
    AppMethodBeat.o(361698);
    return;
    label331:
    this.ErJ.setVisibility(8);
    this.ErK.setVisibility(8);
    AppMethodBeat.o(361698);
  }
  
  private static final void c(am paramam, View paramView)
  {
    AppMethodBeat.i(361874);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramam);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramam, "this$0");
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int i;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramView = com.tencent.mm.plugin.finder.live.report.k.Doi;
      int j = q.ak.Dyu.value;
      localObject1 = paramam.ErF;
      if (localObject1 == null)
      {
        i = 0;
        paramView.hK(j, i);
      }
    }
    else
    {
      paramam.niX.hide();
      localObject2 = new Bundle();
      paramView = paramam.ErF;
      if (paramView != null) {
        break label252;
      }
      paramView = "";
      label134:
      ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_USERNAME", paramView);
      paramView = paramam.ErF;
      if (paramView != null) {
        break label289;
      }
      paramView = "";
      label156:
      ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_NICKNAME", paramView);
      paramView = paramam.ErF;
      if (paramView != null) {
        break label326;
      }
      paramView = null;
    }
    for (;;)
    {
      ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_AVATAR", paramView);
      paramam = paramam.CwG;
      if (paramam != null)
      {
        paramam = paramam.CTj;
        if (paramam != null) {
          paramam.statusChange(b.c.ndq, (Bundle)localObject2);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361874);
      return;
      i = ((bgh)localObject1).ZEt;
      break;
      label252:
      paramView = paramView.contact;
      if (paramView == null)
      {
        paramView = "";
        break label134;
      }
      localObject1 = paramView.username;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break label134;
      }
      paramView = "";
      break label134;
      label289:
      paramView = paramView.contact;
      if (paramView == null)
      {
        paramView = "";
        break label156;
      }
      localObject1 = paramView.nickname;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break label156;
      }
      paramView = "";
      break label156;
      label326:
      paramView = paramView.contact;
      if (paramView == null) {
        paramView = null;
      } else {
        paramView = paramView.headUrl;
      }
    }
  }
  
  private final void c(bgh parambgh)
  {
    AppMethodBeat.i(361705);
    if (parambgh.ZEt == 3)
    {
      this.ErL.setVisibility(0);
      AppMethodBeat.o(361705);
      return;
    }
    this.ErL.setVisibility(8);
    AppMethodBeat.o(361705);
  }
  
  private static final void d(am paramam, View paramView)
  {
    AppMethodBeat.i(361882);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramam);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramam, "this$0");
    paramam.niX.hide();
    paramView = paramam.ErE;
    if (paramView != null)
    {
      paramam = paramam.ErF;
      if (paramam != null) {
        break label123;
      }
      paramam = null;
    }
    for (;;)
    {
      paramView.invoke(paramam);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361882);
      return;
      label123:
      paramam = paramam.contact;
      if (paramam == null) {
        paramam = null;
      } else {
        paramam = paramam.username;
      }
    }
  }
  
  private final void d(bgh parambgh)
  {
    AppMethodBeat.i(361717);
    Object localObject = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
    parambgh = com.tencent.mm.plugin.finder.live.view.span.h.gR((List)parambgh.ZKa);
    if (parambgh == null) {}
    for (parambgh = null;; parambgh = ah.aiuX)
    {
      if (parambgh == null) {
        ((am)this).ErQ.setVisibility(8);
      }
      AppMethodBeat.o(361717);
      return;
      localObject = new q("  ");
      ((q)localObject).setSpan(parambgh, 0, 1, 33);
      this.ErQ.setText((CharSequence)localObject);
      this.ErQ.setVisibility(0);
    }
  }
  
  private final void dvr()
  {
    AppMethodBeat.i(361669);
    Log.i(this.TAG, kotlin.g.b.s.X("updateProfile contentIsShow:", Boolean.valueOf(this.ErZ)));
    bgh localbgh = this.ErF;
    if (localbgh != null)
    {
      localObject1 = localbgh.contact;
      if (localObject1 != null) {
        break label168;
      }
    }
    label168:
    for (Object localObject1 = null;; localObject1 = ((FinderContact)localObject1).username)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
      if (d.a.auT((String)localObject1) == null)
      {
        localObject2 = localbgh.contact;
        if (localObject2 != null)
        {
          d.a locala = com.tencent.mm.plugin.finder.api.d.AwY;
          d.a.d((FinderContact)localObject2);
        }
        Log.i(this.TAG, "updateProfile :" + localObject1 + " localContact is empty,replace it!");
      }
      this.njj.setVisibility(4);
      this.niB.setVisibility(0);
      this.ErI.setVisibility(0);
      this.nmp.setVisibility(0);
      a(localbgh, this.sourceType);
      if (!this.ErZ) {
        this.niX.show();
      }
      AppMethodBeat.o(361669);
      return;
    }
  }
  
  private final void e(bgh parambgh)
  {
    int j = 1;
    Object localObject3 = null;
    AppMethodBeat.i(361734);
    int i = parambgh.ZEt;
    Object localObject1;
    if (i != 3)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!erp()))
      {
        this.ErM.setVisibility(8);
        AppMethodBeat.o(361734);
        return;
      }
    }
    StringBuffer localStringBuffer = new StringBuffer();
    label135:
    label153:
    Object localObject2;
    label167:
    String str;
    if (i != 2)
    {
      localObject1 = parambgh.contact;
      if (localObject1 == null) {
        break label295;
      }
      localObject1 = ((FinderContact)localObject1).extInfo;
      if ((localObject1 == null) || (((avl)localObject1).sex != 1)) {
        break label295;
      }
      i = 1;
      if (i == 0) {
        break label300;
      }
      localStringBuffer.append(this.mJe.getContext().getResources().getString(p.h.sex_male)).append("  ");
      RegionCodeDecoder.jcF();
      localObject1 = parambgh.contact;
      if (localObject1 != null) {
        break label374;
      }
      localObject1 = null;
      localObject2 = parambgh.contact;
      if (localObject2 != null) {
        break label402;
      }
      localObject2 = null;
      str = RegionCodeDecoder.pL((String)localObject1, (String)localObject2);
      RegionCodeDecoder.jcF();
      localObject1 = parambgh.contact;
      if (localObject1 != null) {
        break label430;
      }
      localObject1 = null;
      label194:
      localObject2 = parambgh.contact;
      if (localObject2 != null) {
        break label458;
      }
      localObject2 = null;
      label208:
      parambgh = parambgh.contact;
      if (parambgh != null) {
        break label486;
      }
      parambgh = localObject3;
    }
    for (;;)
    {
      parambgh = RegionCodeDecoder.bJ((String)localObject1, (String)localObject2, parambgh);
      if (!Util.isNullOrNil(str)) {
        localStringBuffer.append(str).append(" ");
      }
      if (!Util.isNullOrNil(parambgh)) {
        localStringBuffer.append(parambgh);
      }
      if (!Util.isNullOrNil(n.bq((CharSequence)localStringBuffer))) {
        break label509;
      }
      this.ErM.setVisibility(8);
      AppMethodBeat.o(361734);
      return;
      label295:
      i = 0;
      break;
      label300:
      localObject1 = parambgh.contact;
      if (localObject1 != null)
      {
        localObject1 = ((FinderContact)localObject1).extInfo;
        if ((localObject1 == null) || (((avl)localObject1).sex != 2)) {}
      }
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label372;
        }
        localStringBuffer.append(this.mJe.getContext().getResources().getString(p.h.sex_female)).append("  ");
        break;
      }
      label372:
      break label135;
      label374:
      localObject1 = ((FinderContact)localObject1).extInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label153;
      }
      localObject1 = ((avl)localObject1).country;
      break label153;
      label402:
      localObject2 = ((FinderContact)localObject2).extInfo;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label167;
      }
      localObject2 = ((avl)localObject2).province;
      break label167;
      label430:
      localObject1 = ((FinderContact)localObject1).extInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label194;
      }
      localObject1 = ((avl)localObject1).country;
      break label194;
      label458:
      localObject2 = ((FinderContact)localObject2).extInfo;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label208;
      }
      localObject2 = ((avl)localObject2).province;
      break label208;
      label486:
      avl localavl = parambgh.extInfo;
      parambgh = localObject3;
      if (localavl != null) {
        parambgh = localavl.city;
      }
    }
    label509:
    this.ErM.setVisibility(0);
    this.ErM.setText((CharSequence)localStringBuffer);
    AppMethodBeat.o(361734);
  }
  
  private final boolean erp()
  {
    AppMethodBeat.i(361763);
    Object localObject = this.CwG;
    if (localObject == null)
    {
      AppMethodBeat.o(361763);
      return false;
    }
    localObject = (e)((com.tencent.mm.plugin.finder.live.plugin.b)localObject).business(e.class);
    if (localObject == null)
    {
      AppMethodBeat.o(361763);
      return false;
    }
    boolean bool = ((e)localObject).DUe;
    AppMethodBeat.o(361763);
    return bool;
  }
  
  private final void f(bgh parambgh)
  {
    AppMethodBeat.i(361747);
    int i = parambgh.ZEt;
    if (i != 3)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!erp()))
      {
        this.ErN.setVisibility(8);
        AppMethodBeat.o(361747);
        return;
      }
    }
    if (i == 2)
    {
      this.ErN.setVisibility(8);
      AppMethodBeat.o(361747);
      return;
    }
    parambgh = parambgh.contact;
    if (parambgh == null) {}
    for (parambgh = null; Util.isNullOrNil(parambgh); parambgh = parambgh.signature)
    {
      this.ErN.setVisibility(8);
      AppMethodBeat.o(361747);
      return;
    }
    Object localObject = parambgh;
    if (i == 3) {
      localObject = MMApplicationContext.getContext().getResources().getString(p.h.CqZ, new Object[] { parambgh });
    }
    this.ErN.setVisibility(0);
    this.ErN.setText((CharSequence)localObject);
    AppMethodBeat.o(361747);
  }
  
  private final void g(bgh parambgh)
  {
    AppMethodBeat.i(361757);
    switch (parambgh.ZEt)
    {
    default: 
      parambgh = parambgh.contact;
      if (parambgh != null) {
        break;
      }
    }
    for (int i = 0; i > 0; i = parambgh.friend_follow_count)
    {
      this.ErR.setVisibility(0);
      parambgh = MMApplicationContext.getContext().getResources().getString(p.h.Crb, new Object[] { Integer.valueOf(i) });
      kotlin.g.b.s.s(parambgh, "getContext().resources.g…wed_fans_desc, followCnt)");
      this.ErS.setText((CharSequence)parambgh);
      AppMethodBeat.o(361757);
      return;
      this.ErR.setVisibility(8);
      AppMethodBeat.o(361757);
      return;
    }
    this.ErR.setVisibility(4);
    AppMethodBeat.o(361757);
  }
  
  private final void h(bgh parambgh)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(361797);
    int k = parambgh.ZEt;
    ??? = parambgh.contact;
    int i;
    label79:
    label104:
    int j;
    if (??? == null)
    {
      i = 0;
      this.ErG = com.tencent.mm.ae.d.ee(i, 1024);
      ??? = this.CwG;
      if (??? == null) {
        break label299;
      }
      ??? = (e)((com.tencent.mm.plugin.finder.live.plugin.b)???).business(e.class);
      if ((??? == null) || (((e)???).eyr() != true)) {
        break label299;
      }
      i = 1;
      if ((i == 0) || (com.tencent.mm.ae.d.ee(parambgh.ZPS, 16)) || (this.ErH)) {
        break label304;
      }
      i = 1;
      ??? = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        break label502;
      }
      ??? = this.CwG;
      if (??? != null) {
        break label309;
      }
      ??? = null;
      label129:
      parambgh = parambgh.contact;
      if (parambgh != null) {
        break label361;
      }
      parambgh = null;
      label140:
      if (!Util.isEqual((String)???, parambgh)) {
        break label502;
      }
      parambgh = this.CwG;
      if (parambgh != null) {
        break label369;
      }
      parambgh = localIterator;
      label161:
      if (parambgh != null) {
        break label502;
      }
      j = 1;
      switch (k)
      {
      default: 
        label167:
        this.ErT.setTag(Integer.valueOf(0));
        this.zWj.setTag(Integer.valueOf(0));
        this.ErU.setTag(Integer.valueOf(0));
      }
    }
    for (;;)
    {
      for (;;)
      {
        parambgh = this.ErT;
        kotlin.g.b.s.s(parambgh, "leftBtn");
        b(parambgh, false);
        parambgh = this.zWj;
        kotlin.g.b.s.s(parambgh, "rightBtn");
        b(parambgh, false);
        parambgh = this.ErU;
        kotlin.g.b.s.s(parambgh, "singleBtn");
        b(parambgh, true);
        AppMethodBeat.o(361797);
        return;
        i = ((FinderContact)???).extFlag;
        break;
        label299:
        i = 0;
        break label79;
        label304:
        i = 0;
        break label104;
        label309:
        ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.plugin.b)???).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (??? == null)
        {
          ??? = null;
          break label129;
        }
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)???).Efv;
        if (??? == null)
        {
          ??? = null;
          break label129;
        }
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).username;
        break label129;
        label361:
        parambgh = parambgh.username;
        break label140;
        label369:
        ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambgh.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        parambgh = localIterator;
        if (??? == null) {
          break label161;
        }
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)???).Efw;
        parambgh = localIterator;
        if (??? == null) {
          break label161;
        }
        synchronized ((Iterable)???)
        {
          localIterator = ((Iterable)???).iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              parambgh = localIterator.next();
              boolean bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)parambgh).mXL, ((e)this.CwG.business(e.class)).eyF());
              if (bool)
              {
                parambgh = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)parambgh;
                break;
              }
            }
          }
          parambgh = null;
        }
      }
      label502:
      j = 0;
      break label167;
      parambgh = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!erp()) && (i != 0))
      {
        this.ErT.setTag(Integer.valueOf(1));
        this.zWj.setTag(Integer.valueOf(3));
        this.ErU.setTag(Integer.valueOf(0));
      }
      else
      {
        parambgh = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (j != 0))
        {
          this.ErT.setTag(Integer.valueOf(1));
          this.zWj.setTag(Integer.valueOf(4));
          this.ErU.setTag(Integer.valueOf(0));
        }
        else
        {
          this.ErT.setTag(Integer.valueOf(0));
          this.zWj.setTag(Integer.valueOf(0));
          this.ErU.setTag(Integer.valueOf(1));
          continue;
          this.ErT.setTag(Integer.valueOf(0));
          this.zWj.setTag(Integer.valueOf(0));
          if (erp())
          {
            this.ErU.setTag(Integer.valueOf(0));
          }
          else
          {
            parambgh = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
            {
              this.ErU.setTag(Integer.valueOf(2));
            }
            else if (i != 0)
            {
              this.ErU.setTag(Integer.valueOf(3));
            }
            else if (j != 0)
            {
              this.ErT.setTag(Integer.valueOf(1));
              this.zWj.setTag(Integer.valueOf(4));
              this.ErU.setTag(Integer.valueOf(0));
            }
            else
            {
              this.ErU.setTag(Integer.valueOf(0));
            }
          }
        }
      }
    }
  }
  
  private final void i(bgh parambgh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(361825);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!erp()))
    {
      Log.i(this.TAG, "handleFollowBtn: not anchor");
      this.ErV.setVisibility(8);
      AppMethodBeat.o(361825);
      return;
    }
    if (parambgh == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label103;
      }
    }
    label103:
    while (((Integer)localObject1).intValue() != 3)
    {
      Log.i(this.TAG, kotlin.g.b.s.X("handleFollowBtn: roleType not finder:", localObject1));
      this.ErV.setVisibility(8);
      AppMethodBeat.o(361825);
      return;
      localObject1 = Integer.valueOf(parambgh.ZEt);
      break;
    }
    parambgh = parambgh.contact;
    if (parambgh == null)
    {
      parambgh = localObject2;
      localObject1 = (CharSequence)parambgh;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label186;
      }
      Log.i(this.TAG, "handleFollowBtn: finderUsername is null or empty");
      this.ErV.setVisibility(8);
      AppMethodBeat.o(361825);
      return;
      parambgh = parambgh.username;
      break;
    }
    label186:
    this.ErV.setVisibility(0);
    if (((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Ss(parambgh))
    {
      Log.i(this.TAG, kotlin.g.b.s.X("handleFollowBtn have follow user:", parambgh));
      this.ErW.setVisibility(8);
      this.ErX.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Crc));
      AppMethodBeat.o(361825);
      return;
    }
    if (((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).St(parambgh))
    {
      Log.i(this.TAG, "handleFollowBtn waiting user:" + parambgh + " to allow");
      this.ErW.setVisibility(8);
      this.ErX.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Crd));
      AppMethodBeat.o(361825);
      return;
    }
    this.ErW.setVisibility(0);
    parambgh = MMApplicationContext.getContext().getResources().getString(p.h.Cra);
    kotlin.g.b.s.s(parambgh, "getContext().resources.g…nder_live_profile_follow)");
    if (this.ErG)
    {
      parambgh = MMApplicationContext.getContext().getResources().getString(p.h.Crl);
      kotlin.g.b.s.s(parambgh, "getContext().resources.g…ofile_req_follow_privacy)");
      this.ErW.setVisibility(8);
    }
    this.ErX.setText((CharSequence)parambgh);
    AppMethodBeat.o(361825);
  }
  
  private static String j(bgh parambgh)
  {
    boolean bool2 = true;
    Object localObject2 = null;
    AppMethodBeat.i(361842);
    StringBuilder localStringBuilder = new StringBuilder("headUrl is empty:");
    Object localObject1 = parambgh.contact;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label232;
      }
      bool1 = true;
      label54:
      localStringBuilder = localStringBuilder.append(bool1).append(", nickName:");
      localObject1 = parambgh.contact;
      if (localObject1 != null) {
        break label237;
      }
      localObject1 = null;
      label79:
      localStringBuilder = localStringBuilder.append(localObject1).append(",authIconType:");
      localObject1 = parambgh.contact;
      if (localObject1 != null) {
        break label245;
      }
      localObject1 = null;
      label104:
      localStringBuilder = localStringBuilder.append(localObject1).append(",roleType:").append(parambgh.ZEt).append(",disableComment:").append(parambgh.ZPQ).append(", extInfo is empty:");
      localObject1 = parambgh.contact;
      if (localObject1 != null) {
        break label270;
      }
      localObject1 = null;
      label155:
      if (localObject1 != null) {
        break label278;
      }
      bool1 = true;
      label161:
      localStringBuilder = localStringBuilder.append(bool1).append(",signature is empty:");
      localObject1 = parambgh.contact;
      if (localObject1 != null) {
        break label283;
      }
      localObject1 = localObject2;
      label187:
      if (localObject1 != null) {
        break label291;
      }
    }
    label270:
    label278:
    label283:
    label291:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      parambgh = bool1 + ",reward:" + parambgh.ZPR;
      AppMethodBeat.o(361842);
      return parambgh;
      localObject1 = ((FinderContact)localObject1).headUrl;
      break;
      label232:
      bool1 = false;
      break label54;
      label237:
      localObject1 = ((FinderContact)localObject1).nickname;
      break label79;
      label245:
      localObject1 = ((FinderContact)localObject1).authInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label104;
      }
      localObject1 = Integer.valueOf(((FinderAuthInfo)localObject1).authIconType);
      break label104;
      localObject1 = ((FinderContact)localObject1).extInfo;
      break label155;
      bool1 = false;
      break label161;
      localObject1 = ((FinderContact)localObject1).signature;
      break label187;
    }
  }
  
  public final void a(bgh parambgh, int paramInt, bui parambui, boolean paramBoolean)
  {
    AppMethodBeat.i(362001);
    kotlin.g.b.s.u(parambgh, "liveContact");
    int i = parambgh.ZEt;
    Log.i(this.TAG, "showProfile contentIsShow:" + this.ErZ + ",roleType:" + i + ",sourceType:" + paramInt);
    this.ErF = parambgh;
    this.sourceType = paramInt;
    this.reportObj = parambui;
    this.ErH = paramBoolean;
    dvr();
    com.tencent.mm.plugin.h localh;
    if (i == 3)
    {
      com.tencent.mm.kernel.h.baD().mCm.a(3736, (com.tencent.mm.am.h)this);
      parambgh = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(parambgh, "service(IFinderCommonService::class.java)");
      localh = (com.tencent.mm.plugin.h)parambgh;
      parambgh = this.ErF;
      if (parambgh != null) {
        break label167;
      }
      parambgh = "";
    }
    for (;;)
    {
      h.a.a(localh, parambgh, true, null, null, 872);
      AppMethodBeat.o(362001);
      return;
      label167:
      parambgh = parambgh.contact;
      if (parambgh == null)
      {
        parambgh = "";
      }
      else
      {
        parambui = parambgh.username;
        parambgh = parambui;
        if (parambui == null) {
          parambgh = "";
        }
      }
    }
  }
  
  public final void eBc()
  {
    AppMethodBeat.i(361988);
    Log.i(this.TAG, "activate");
    IListener localIListener = this.ErY;
    if (localIListener != null) {
      localIListener.alive();
    }
    AppMethodBeat.o(361988);
  }
  
  public final void eBd()
  {
    AppMethodBeat.i(361994);
    Log.i(this.TAG, "deActivate");
    IListener localIListener = this.ErY;
    if (localIListener != null) {
      localIListener.dead();
    }
    com.tencent.mm.kernel.h.baD().mCm.b(3736, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(361994);
  }
  
  public final void eBe()
  {
    Object localObject2 = null;
    AppMethodBeat.i(362012);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (this.ErH)) && (!erp()))
    {
      this.ErO.setVisibility(4);
      AppMethodBeat.o(362012);
      return;
    }
    localObject1 = this.ErF;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!kotlin.g.b.s.p(localObject1, z.bAW()))
      {
        localObject1 = this.ErF;
        if (localObject1 != null) {
          break label126;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (!kotlin.g.b.s.p(localObject1, z.bAM())) {
        break label145;
      }
      this.ErO.setVisibility(4);
      AppMethodBeat.o(362012);
      return;
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break;
      label126:
      FinderContact localFinderContact = ((bgh)localObject1).contact;
      localObject1 = localObject2;
      if (localFinderContact != null) {
        localObject1 = localFinderContact.username;
      }
    }
    label145:
    if (erp())
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.a(this.ErF))
      {
        this.ErO.setVisibility(4);
        AppMethodBeat.o(362012);
        return;
      }
    }
    if ((this.sourceType == 1) || (this.sourceType == 2) || (this.sourceType == 3))
    {
      this.ErO.setVisibility(0);
      AppMethodBeat.o(362012);
      return;
    }
    this.ErO.setVisibility(4);
    AppMethodBeat.o(362012);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(362022);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BOb;
      if (paramView != null) {
        break label114;
      }
      label56:
      i = p.e.BOa;
      if (paramView != null) {
        break label160;
      }
      label64:
      i = p.e.BOm;
      if (paramView != null) {
        break label206;
      }
      label72:
      i = p.e.BOe;
      if (paramView != null) {
        break label240;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362022);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label114:
      if (paramView.intValue() != i) {
        break label56;
      }
      this.niX.hide();
      paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drz, String.valueOf(q.bm.DBx.action));
        continue;
        label160:
        if (paramView.intValue() != i) {
          break label64;
        }
        this.niX.hide();
        paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
        {
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drz, String.valueOf(q.bm.DBx.action));
          continue;
          label206:
          if (paramView.intValue() != i) {
            break label72;
          }
          this.niX.hide();
          paramView = this.ErD;
          label365:
          if (paramView != null)
          {
            paramView.invoke();
            continue;
            label240:
            if (paramView.intValue() == i)
            {
              paramView = this.ErX.getText();
              if ((kotlin.g.b.s.p(paramView, MMApplicationContext.getContext().getResources().getString(p.h.Cra))) || (kotlin.g.b.s.p(paramView, MMApplicationContext.getContext().getResources().getString(p.h.Crl))))
              {
                paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                int j;
                int k;
                if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
                {
                  com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.bm.DBB);
                  paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
                  j = q.ah.Dyi.value;
                  k = this.sourceType;
                  localObject = this.ErF;
                  if (localObject != null) {
                    break label365;
                  }
                }
                for (i = 0;; i = ((bgh)localObject).ZEt)
                {
                  paramView.az(j, k, i);
                  paramView = bh.ABm;
                  Qk(bh.dVr());
                  break;
                }
              }
              if (kotlin.g.b.s.p(paramView, MMApplicationContext.getContext().getResources().getString(p.h.Crc)))
              {
                if (this.CVD == null)
                {
                  this.CVD = new com.tencent.mm.ui.widget.a.f(this.mJe.getContext(), 1, true);
                  paramView = this.CVD;
                  if (paramView != null) {
                    paramView.NyV = true;
                  }
                }
                paramView = this.CVD;
                if (paramView != null) {
                  paramView.NE(true);
                }
                paramView = this.CVD;
                if (paramView != null) {
                  paramView.agfb = false;
                }
                paramView = this.CVD;
                if (paramView != null) {
                  paramView.Vtg = new am..ExternalSyntheticLambda4(this);
                }
                paramView = this.CVD;
                if (paramView != null) {
                  paramView.GAC = new am..ExternalSyntheticLambda5(this);
                }
                paramView = this.CVD;
                if (paramView != null) {
                  paramView.aeLi = new am..ExternalSyntheticLambda6(this);
                }
                paramView = this.CVD;
                if (paramView != null) {
                  paramView.dDn();
                }
              }
              else if (kotlin.g.b.s.p(paramView, MMApplicationContext.getContext().getResources().getString(p.h.Crd)))
              {
                paramView = bh.ABm;
                Qk(bh.dVt());
              }
            }
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(362037);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramp);
    if ((paramp instanceof com.tencent.mm.plugin.api.a))
    {
      FinderContact localFinderContact = ((com.tencent.mm.plugin.api.a)paramp).caK();
      paramInt2 = this.mJe.getVisibility();
      paramString = this.mJe.getContext();
      boolean bool;
      label120:
      String str;
      label131:
      StringBuilder localStringBuilder;
      if ((paramString instanceof Activity))
      {
        paramString = (Activity)paramString;
        if ((paramString == null) || (paramString.isFinishing() != true)) {
          break label352;
        }
        bool = true;
        paramString = this.ErF;
        if (paramString != null) {
          break label358;
        }
        paramString = null;
        str = this.TAG;
        localStringBuilder = new StringBuilder("onSceneEnd,isOnlyFetchUserInfo:").append(((com.tencent.mm.plugin.api.a)paramp).caL()).append(", cur liveContact username:").append(paramString).append(", req username:").append(((com.tencent.mm.plugin.api.a)paramp).caM()).append("，contact username:");
        if (localFinderContact != null) {
          break label380;
        }
      }
      label352:
      label358:
      label380:
      for (Object localObject1 = null;; localObject1 = localFinderContact.username)
      {
        Log.i(str, localObject1 + ",visibility:" + paramInt2 + ",isFinish:" + bool);
        localObject1 = (CharSequence)paramString;
        if (localObject1 != null)
        {
          paramInt1 = i;
          if (((CharSequence)localObject1).length() != 0) {}
        }
        else
        {
          paramInt1 = 1;
        }
        if ((paramInt1 != 0) || (!((com.tencent.mm.plugin.api.a)paramp).caL()) || (!kotlin.g.b.s.p(((com.tencent.mm.plugin.api.a)paramp).caM(), paramString))) {
          break label459;
        }
        com.tencent.mm.kernel.h.baD().mCm.b(3736, (com.tencent.mm.am.h)this);
        if ((!bool) && (paramInt2 == 0) && (this.ErF != null)) {
          break label390;
        }
        this.niX.hide();
        AppMethodBeat.o(362037);
        return;
        paramString = null;
        break;
        bool = false;
        break label120;
        paramString = paramString.contact;
        if (paramString == null)
        {
          paramString = null;
          break label131;
        }
        paramString = paramString.username;
        break label131;
      }
      label390:
      paramString = this.ErF;
      if (paramString != null) {
        paramString.contact = localFinderContact;
      }
      paramString = this.ErF;
      if (paramString != null) {
        break label466;
      }
    }
    label459:
    label466:
    for (paramString = localObject2;; paramString = paramString.contact)
    {
      if (paramString != null) {
        paramString.friend_follow_count = ((com.tencent.mm.plugin.api.a)paramp).caN();
      }
      paramString = this.ErF;
      if (paramString != null)
      {
        g(paramString);
        b(paramString);
        f(paramString);
      }
      AppMethodBeat.o(362037);
      return;
    }
  }
  
  public final void showCenterCustomizeToast(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(361980);
    kotlin.g.b.s.u(paramString, "msg");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramString, paramInt));
    AppMethodBeat.o(361980);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isShow", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    a(am paramam)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(am paramam, String paramString, int paramInt)
    {
      super();
    }
    
    private static final void j(int paramInt, View paramView)
    {
      AppMethodBeat.i(361544);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
        if (paramView != null) {
          paramView.setImageResource(paramInt);
        }
      }
      AppMethodBeat.o(361544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.am
 * JD-Core Version:    0.7.0.1
 */