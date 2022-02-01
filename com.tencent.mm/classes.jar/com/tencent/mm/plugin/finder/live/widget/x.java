package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mm.f.a.ja;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.ax;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "anchorActionGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "authInfoIv", "Landroid/widget/ImageView;", "avatarIcon", "banCommentIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "blankArea", "closeBtn", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "contentIsShow", "", "curLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getCurLiveContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "setCurLiveContact", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "finderPrivacyMsgBtn", "Landroid/widget/Button;", "finderPrivacyMsgLayout", "finderUserArrowIv", "followBtn", "followListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FollowUserEvent;", "followsDescTv", "Landroid/widget/TextView;", "followsGroup", "gotoProfileCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "username", "", "getGotoProfileCallback", "()Lkotlin/jvm/functions/Function1;", "setGotoProfileCallback", "(Lkotlin/jvm/functions/Function1;)V", "hideContentCallback", "Lkotlin/Function0;", "getHideContentCallback", "()Lkotlin/jvm/functions/Function0;", "setHideContentCallback", "(Lkotlin/jvm/functions/Function0;)V", "isPrivacyUser", "()Z", "setPrivacyUser", "(Z)V", "loadingBar", "Landroid/widget/ProgressBar;", "moreAction", "Landroid/widget/FrameLayout;", "moreActionCallback", "getMoreActionCallback", "setMoreActionCallback", "profileInfoGroup", "Landroid/widget/RelativeLayout;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setReportObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getRoot", "()Landroid/view/ViewGroup;", "showContentCallback", "getShowContentCallback", "setShowContentCallback", "sourceType", "", "getSourceType", "()I", "setSourceType", "(I)V", "titleTv", "userInfoTv", "userSigatureTv", "wechatPrivacyMsgBtn", "activate", "deActivate", "followFinderUser", "followType", "getFinderLiveContactInfo", "contact", "handleFollowBtn", "finderUsername", "hideProfile", "isLandscape", "onClick", "v", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setAnchorActionState", "setAuthInfo", "setFinderUserArrow", "setFollows", "setMoreActionState", "setTitleContent", "titleSpan", "Landroid/text/SpannableString;", "setUserInfo", "setUserSignature", "showCenterCustomizeToast", "msg", "res", "showProfile", "liveContact", "updateProfile", "updateProfileInfo", "plugin-finder_release"})
public final class x
  implements View.OnClickListener, com.tencent.mm.an.i
{
  public final String TAG;
  private final View kFA;
  private final View kFU;
  public final LiveBottomSheetPanel kFV;
  private final ProgressBar kGl;
  private final ImageView kLZ;
  public final ViewGroup kiF;
  private bid reportObj;
  private int sourceType;
  private final TextView titleTv;
  public kotlin.g.a.a<kotlin.x> zoU;
  public kotlin.g.a.a<kotlin.x> zoV;
  public kotlin.g.a.b<? super String, kotlin.x> zoW;
  public kotlin.g.a.a<kotlin.x> zoX;
  aza zoY;
  private boolean zoZ;
  private final RelativeLayout zpa;
  private final ImageView zpb;
  private final WeImageView zpc;
  private final TextView zpd;
  private final TextView zpe;
  private final FrameLayout zpf;
  private final WeImageView zpg;
  private final View zph;
  private final TextView zpi;
  private final View zpj;
  private final Button zpk;
  private final Button zpl;
  private final Button zpm;
  private final View zpn;
  private IListener<ja> zpo;
  private boolean zpp;
  
  public x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(221470);
    this.kiF = paramViewGroup;
    this.TAG = "FinderLiveMemebrProfileWidget";
    this.zpa = ((RelativeLayout)this.kiF.findViewById(b.f.finder_live_members_profile_info_group));
    this.titleTv = ((TextView)this.kiF.findViewById(b.f.members_profile_info_desc_name));
    this.zpb = ((ImageView)this.kiF.findViewById(b.f.auth_info_tag_iv));
    this.zpc = ((WeImageView)this.kiF.findViewById(b.f.finder_user_arrow_icon));
    this.zpd = ((TextView)this.kiF.findViewById(b.f.user_ext_info_tv));
    this.zpe = ((TextView)this.kiF.findViewById(b.f.user_signature_tv));
    this.kLZ = ((ImageView)this.kiF.findViewById(b.f.finder_live_members_profile_info_icon));
    this.kFA = this.kiF.findViewById(b.f.finder_live_members_profile_close_btn);
    this.kFU = this.kiF.findViewById(b.f.finder_live_members_profile_blank_area);
    this.kFV = ((LiveBottomSheetPanel)this.kiF.findViewById(b.f.finder_live_members_profile_content_area));
    this.zpf = ((FrameLayout)this.kiF.findViewById(b.f.finder_live_members_profile_more_action_container));
    this.zpg = ((WeImageView)this.kiF.findViewById(b.f.ban_comment));
    this.zph = this.kiF.findViewById(b.f.follows_group);
    this.zpi = ((TextView)this.kiF.findViewById(b.f.follows_desc_tv));
    this.zpj = this.kiF.findViewById(b.f.anchor_action_group);
    this.zpk = ((Button)this.kiF.findViewById(b.f.wechat_privacy_msg_btn));
    this.zpl = ((Button)this.kiF.findViewById(b.f.finder_privacy_msg_btn));
    this.zpm = ((Button)this.kiF.findViewById(b.f.follow_btn));
    this.zpn = this.kiF.findViewById(b.f.finder_privacy_msg_layout);
    paramViewGroup = this.kiF.findViewById(b.f.loading_progress);
    p.j(paramViewGroup, "root.findViewById(R.id.loading_progress)");
    this.kGl = ((ProgressBar)paramViewGroup);
    paramViewGroup = this.kFV;
    paramViewGroup.setTranslationY(ax.au(this.kiF.getContext()).y);
    paramViewGroup.setOnVisibilityListener((kotlin.g.a.b)new a(this));
    int i;
    if ((paramViewGroup.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      Object localObject = this.kiF.getContext();
      p.j(localObject, "root.context");
      localObject = ((Context)localObject).getResources();
      p.j(localObject, "root.context.resources");
      if (((Resources)localObject).getConfiguration().orientation != 2) {
        break label579;
      }
      i = 1;
      if (i != 0) {
        break label584;
      }
      paramViewGroup = this.kFV;
      localObject = this.kFV;
      p.j(localObject, "contentGroup");
      i = ((LiveBottomSheetPanel)localObject).getPaddingLeft();
      localObject = this.kFV;
      p.j(localObject, "contentGroup");
      int j = ((LiveBottomSheetPanel)localObject).getPaddingTop();
      localObject = this.kFV;
      p.j(localObject, "contentGroup");
      paramViewGroup.setPadding(i, j, ((LiveBottomSheetPanel)localObject).getPaddingRight(), ax.aB(this.kiF.getContext()));
    }
    for (;;)
    {
      i = ax.aB(this.kiF.getContext());
      paramViewGroup = this.zpj.getLayoutParams();
      if (paramViewGroup != null) {
        break label642;
      }
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(221470);
      throw paramViewGroup;
      label579:
      i = 0;
      break;
      label584:
      paramViewGroup.getLayoutParams().width = ax.au(this.kiF.getContext()).y;
      paramViewGroup = paramViewGroup.getLayoutParams();
      if (paramViewGroup == null)
      {
        paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(221470);
        throw paramViewGroup;
      }
      ((LinearLayout.LayoutParams)paramViewGroup).gravity = 1;
    }
    label642:
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin = (i + paramViewGroup.bottomMargin);
    this.zpo = ((IListener)new IListener()
    {
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<kotlin.x>
      {
        a(x.1 param1, ja paramja, String paramString)
        {
          super();
        }
      }
    });
    this.zpa.setOnClickListener((View.OnClickListener)this);
    this.kFA.setOnClickListener((View.OnClickListener)this);
    this.kFU.setOnClickListener((View.OnClickListener)this);
    this.zpf.setOnClickListener((View.OnClickListener)this);
    this.zpk.setOnClickListener((View.OnClickListener)this);
    this.zpm.setOnClickListener((View.OnClickListener)this);
    this.zpl.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(221470);
  }
  
  private final void Oa(int paramInt)
  {
    AppMethodBeat.i(221407);
    Object localObject1 = this.zoY;
    if (localObject1 != null)
    {
      localObject1 = ((aza)localObject1).contact;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((FinderContact)localObject1).username; localObject1 != null; localObject1 = null)
    {
      Object localObject3 = this.reportObj;
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = g.Xox;
        localObject2 = this.kiF.getContext();
        p.j(localObject2, "root.context");
        localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.lm((Context)localObject2).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
      }
      localObject3 = ai.zAJ;
      ai.a((bid)localObject2, (String)localObject1, paramInt, 0L, 8);
      AppMethodBeat.o(221407);
      return;
    }
    AppMethodBeat.o(221407);
  }
  
  private final void a(aza paramaza)
  {
    AppMethodBeat.i(221347);
    if (paramaza.SDv == 2)
    {
      paramaza = this.zpb;
      p.j(paramaza, "authInfoIv");
      paramaza.setVisibility(8);
      AppMethodBeat.o(221347);
      return;
    }
    Object localObject = paramaza.contact;
    int i;
    if (localObject != null)
    {
      localObject = ((FinderContact)localObject).authInfo;
      if (localObject != null)
      {
        i = ((FinderAuthInfo)localObject).authIconType;
        if (i <= 0) {
          break label136;
        }
        localObject = this.zpb;
        p.j(localObject, "authInfoIv");
        ((ImageView)localObject).setVisibility(0);
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject = this.zpb;
        p.j(localObject, "authInfoIv");
        paramaza = paramaza.contact;
        if (paramaza == null) {
          break label131;
        }
      }
    }
    label131:
    for (paramaza = paramaza.authInfo;; paramaza = null)
    {
      com.tencent.mm.plugin.finder.utils.aj.a((ImageView)localObject, paramaza, 0);
      AppMethodBeat.o(221347);
      return;
      i = 0;
      break;
    }
    label136:
    paramaza = this.zpb;
    p.j(paramaza, "authInfoIv");
    paramaza.setVisibility(8);
    AppMethodBeat.o(221347);
  }
  
  private final void a(aza paramaza, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(221339);
    Object localObject1 = paramaza.contact;
    if (localObject1 != null)
    {
      localObject1 = ((FinderContact)localObject1).headUrl;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject3 = this.kLZ;
        p.j(localObject3, "avatarIcon");
        p.j(localObject1, "it");
        com.tencent.mm.plugin.finder.live.utils.a.c((ImageView)localObject3, (String)localObject1, paramaza.SDv);
      }
    }
    Object localObject3 = this.kiF.getContext();
    localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localObject1 = paramaza.contact;
    if (localObject1 != null) {}
    for (localObject1 = ((FinderContact)localObject1).username;; localObject1 = null)
    {
      FinderContact localFinderContact = paramaza.contact;
      if (localFinderContact != null) {
        localObject2 = localFinderContact.nickname;
      }
      localObject1 = (CharSequence)com.tencent.mm.plugin.finder.utils.aj.ht((String)localObject1, (String)localObject2);
      localObject2 = this.titleTv;
      p.j(localObject2, "titleTv");
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject1, ((TextView)localObject2).getTextSize());
      p.j(localObject1, "MMSpanManager.spanForSmi…kname), titleTv.textSize)");
      a(paramaza, (SpannableString)localObject1);
      a(paramaza);
      b(paramaza);
      c(paramaza);
      d(paramaza);
      e(paramaza);
      f(paramaza);
      dIw();
      Log.i(this.TAG, "updateProfileInfo," + g(paramaza) + ",sourceType:" + paramInt);
      AppMethodBeat.o(221339);
      return;
    }
  }
  
  private final void a(aza paramaza, SpannableString paramSpannableString)
  {
    int i = 1;
    AppMethodBeat.i(221343);
    TextView localTextView = this.titleTv;
    p.j(localTextView, "titleTv");
    localTextView.setText((CharSequence)paramSpannableString);
    paramSpannableString = this.titleTv;
    p.j(paramSpannableString, "titleTv");
    paramSpannableString = paramSpannableString.getLayoutParams();
    if (paramaza.SDv == 2)
    {
      paramaza = this.zpg;
      p.j(paramaza, "banCommentIv");
      paramaza.setVisibility(8);
      paramaza = this.kLZ;
      p.j(paramaza, "avatarIcon");
      paramaza = paramaza.getLayoutParams();
      if (paramaza != null) {}
      for (i = paramaza.height;; i = paramaza.getResources().getDimensionPixelOffset(b.d.Edge_7A))
      {
        paramSpannableString.height = i;
        AppMethodBeat.o(221343);
        return;
        paramaza = MMApplicationContext.getContext();
        p.j(paramaza, "MMApplicationContext.getContext()");
      }
    }
    paramSpannableString.height = -2;
    if (paramaza.SKR == 1) {}
    while (i != 0)
    {
      paramaza = this.zpg;
      p.j(paramaza, "banCommentIv");
      paramaza.setVisibility(0);
      AppMethodBeat.o(221343);
      return;
      i = 0;
    }
    paramaza = this.zpg;
    p.j(paramaza, "banCommentIv");
    paramaza.setVisibility(8);
    AppMethodBeat.o(221343);
  }
  
  private final void aDg(String paramString)
  {
    AppMethodBeat.i(221405);
    Object localObject = com.tencent.mm.plugin.finder.upload.action.i.ACa;
    if (com.tencent.mm.plugin.finder.upload.action.i.ecE().aAN(paramString))
    {
      Log.i(this.TAG, "handleFollowBtn have follow user:".concat(String.valueOf(paramString)));
      paramString = this.zpm;
      p.j(paramString, "followBtn");
      paramString.setEnabled(true);
      paramString = this.zpm;
      p.j(paramString, "followBtn");
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      paramString.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_profile_unfollow));
      this.zpm.setBackgroundResource(b.e.finder_live_btn_grey_bg);
      AppMethodBeat.o(221405);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.upload.action.i.ACa;
    if (com.tencent.mm.plugin.finder.upload.action.i.ecE().aAO(paramString))
    {
      Log.i(this.TAG, "handleFollowBtn waiting user:" + paramString + " to allow");
      paramString = this.zpm;
      p.j(paramString, "followBtn");
      paramString.setEnabled(false);
      paramString = this.zpm;
      p.j(paramString, "followBtn");
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      paramString.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_profile_unapply_follow));
      this.zpm.setBackgroundResource(b.e.finder_live_btn_grey_bg);
      AppMethodBeat.o(221405);
      return;
    }
    paramString = this.zpm;
    p.j(paramString, "followBtn");
    paramString.setEnabled(true);
    paramString = MMApplicationContext.getContext();
    p.j(paramString, "MMApplicationContext.getContext()");
    paramString = paramString.getResources().getString(b.j.finder_live_profile_follow);
    p.j(paramString, "MMApplicationContext.get…nder_live_profile_follow)");
    if (this.zoZ)
    {
      paramString = MMApplicationContext.getContext();
      p.j(paramString, "MMApplicationContext.getContext()");
      paramString = paramString.getResources().getString(b.j.finder_live_profile_req_follow_privacy);
      p.j(paramString, "MMApplicationContext.get…ofile_req_follow_privacy)");
    }
    localObject = this.zpm;
    p.j(localObject, "followBtn");
    ((Button)localObject).setText((CharSequence)paramString);
    this.zpm.setBackgroundResource(b.e.finder_live_btn_bg);
    AppMethodBeat.o(221405);
  }
  
  private final void b(aza paramaza)
  {
    AppMethodBeat.i(221352);
    if (paramaza.SDv == 3)
    {
      paramaza = this.zpc;
      p.j(paramaza, "finderUserArrowIv");
      paramaza.setVisibility(0);
      paramaza = this.zpa;
      p.j(paramaza, "profileInfoGroup");
      paramaza.setClickable(true);
      AppMethodBeat.o(221352);
      return;
    }
    paramaza = this.zpc;
    p.j(paramaza, "finderUserArrowIv");
    paramaza.setVisibility(8);
    paramaza = this.zpa;
    p.j(paramaza, "profileInfoGroup");
    paramaza.setClickable(false);
    AppMethodBeat.o(221352);
  }
  
  private final void c(aza paramaza)
  {
    Object localObject3 = null;
    AppMethodBeat.i(221374);
    if (paramaza.SDv == 2)
    {
      paramaza = this.zpd;
      p.j(paramaza, "userInfoTv");
      paramaza.setVisibility(8);
      AppMethodBeat.o(221374);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = paramaza.contact;
    label146:
    label169:
    String str;
    if (localObject1 != null)
    {
      localObject1 = ((FinderContact)localObject1).extInfo;
      if ((localObject1 != null) && (((ard)localObject1).sex == 1))
      {
        localObject1 = this.kiF.getContext();
        p.j(localObject1, "root.context");
        p.j(localStringBuffer.append(((Context)localObject1).getResources().getString(b.j.sex_male)).append("  "), "tip.append(root.context.…g.sex_male)).append(\"  \")");
        RegionCodeDecoder.hAC();
        localObject1 = paramaza.contact;
        if (localObject1 == null) {
          break label409;
        }
        localObject1 = ((FinderContact)localObject1).extInfo;
        if (localObject1 == null) {
          break label409;
        }
        localObject1 = ((ard)localObject1).country;
        localObject2 = paramaza.contact;
        if (localObject2 == null) {
          break label414;
        }
        localObject2 = ((FinderContact)localObject2).extInfo;
        if (localObject2 == null) {
          break label414;
        }
        localObject2 = ((ard)localObject2).province;
        str = RegionCodeDecoder.nN((String)localObject1, (String)localObject2);
        RegionCodeDecoder.hAC();
        localObject1 = paramaza.contact;
        if (localObject1 == null) {
          break label419;
        }
        localObject1 = ((FinderContact)localObject1).extInfo;
        if (localObject1 == null) {
          break label419;
        }
        localObject1 = ((ard)localObject1).country;
        label203:
        localObject2 = paramaza.contact;
        if (localObject2 == null) {
          break label424;
        }
        localObject2 = ((FinderContact)localObject2).extInfo;
        if (localObject2 == null) {
          break label424;
        }
      }
    }
    label409:
    label414:
    label419:
    label424:
    for (Object localObject2 = ((ard)localObject2).province;; localObject2 = null)
    {
      Object localObject4 = paramaza.contact;
      paramaza = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((FinderContact)localObject4).extInfo;
        paramaza = localObject3;
        if (localObject4 != null) {
          paramaza = ((ard)localObject4).city;
        }
      }
      paramaza = RegionCodeDecoder.bm((String)localObject1, (String)localObject2, paramaza);
      if (!Util.isNullOrNil(str)) {
        localStringBuffer.append(str).append(" ");
      }
      if (!Util.isNullOrNil(paramaza)) {
        localStringBuffer.append(paramaza);
      }
      if (!Util.isNullOrNil(n.bb((CharSequence)localStringBuffer))) {
        break label429;
      }
      paramaza = this.zpd;
      p.j(paramaza, "userInfoTv");
      paramaza.setVisibility(8);
      AppMethodBeat.o(221374);
      return;
      localObject1 = paramaza.contact;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((FinderContact)localObject1).extInfo;
      if ((localObject1 == null) || (((ard)localObject1).sex != 2)) {
        break;
      }
      localObject1 = this.kiF.getContext();
      p.j(localObject1, "root.context");
      localStringBuffer.append(((Context)localObject1).getResources().getString(b.j.sex_female)).append("  ");
      break;
      localObject1 = null;
      break label146;
      localObject2 = null;
      break label169;
      localObject1 = null;
      break label203;
    }
    label429:
    paramaza = this.zpd;
    p.j(paramaza, "userInfoTv");
    paramaza.setVisibility(0);
    paramaza = this.zpd;
    p.j(paramaza, "userInfoTv");
    paramaza.setText((CharSequence)localStringBuffer);
    AppMethodBeat.o(221374);
  }
  
  private final void cQY()
  {
    AppMethodBeat.i(221335);
    Log.i(this.TAG, "updateProfile contentIsShow:" + this.zpp);
    aza localaza = this.zoY;
    if (localaza != null)
    {
      Object localObject1 = localaza.contact;
      if (localObject1 != null) {}
      for (localObject1 = ((FinderContact)localObject1).username;; localObject1 = null)
      {
        Object localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
        if (d.a.aAK((String)localObject1) == null)
        {
          localObject2 = localaza.contact;
          if (localObject2 != null)
          {
            d.a locala = com.tencent.mm.plugin.finder.api.d.wZQ;
            p.j(localObject2, "finderContact");
            d.a.a((FinderContact)localObject2);
          }
          Log.i(this.TAG, "updateProfile :" + (String)localObject1 + " localContact is empty,replace it!");
        }
        this.kGl.setVisibility(4);
        localObject1 = this.kFA;
        p.j(localObject1, "closeBtn");
        ((View)localObject1).setVisibility(0);
        localObject1 = this.zpa;
        p.j(localObject1, "profileInfoGroup");
        ((RelativeLayout)localObject1).setVisibility(0);
        localObject1 = this.zpj;
        p.j(localObject1, "anchorActionGroup");
        ((View)localObject1).setVisibility(0);
        a(localaza, this.sourceType);
        if (!this.zpp) {
          this.kFV.show();
        }
        AppMethodBeat.o(221335);
        return;
      }
    }
    AppMethodBeat.o(221335);
  }
  
  private final void d(aza paramaza)
  {
    AppMethodBeat.i(221382);
    int i = paramaza.SDv;
    if (i == 2)
    {
      paramaza = this.zpe;
      p.j(paramaza, "userSigatureTv");
      paramaza.setVisibility(8);
      AppMethodBeat.o(221382);
      return;
    }
    paramaza = paramaza.contact;
    if (paramaza != null) {}
    for (paramaza = paramaza.signature; Util.isNullOrNil(paramaza); paramaza = null)
    {
      paramaza = this.zpe;
      p.j(paramaza, "userSigatureTv");
      paramaza.setVisibility(8);
      AppMethodBeat.o(221382);
      return;
    }
    Object localObject = paramaza;
    if (i == 3)
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(b.j.finder_live_profile_desc_prefix_tips, new Object[] { paramaza });
    }
    paramaza = this.zpe;
    p.j(paramaza, "userSigatureTv");
    paramaza.setVisibility(0);
    paramaza = this.zpe;
    p.j(paramaza, "userSigatureTv");
    paramaza.setText((CharSequence)localObject);
    AppMethodBeat.o(221382);
  }
  
  private final void dIw()
  {
    AppMethodBeat.i(221391);
    if (this.sourceType == 1)
    {
      localFrameLayout = this.zpf;
      p.j(localFrameLayout, "moreAction");
      localFrameLayout.setVisibility(0);
      AppMethodBeat.o(221391);
      return;
    }
    FrameLayout localFrameLayout = this.zpf;
    p.j(localFrameLayout, "moreAction");
    localFrameLayout.setVisibility(4);
    AppMethodBeat.o(221391);
  }
  
  private final void e(aza paramaza)
  {
    AppMethodBeat.i(221387);
    if (paramaza.SDv == 2)
    {
      paramaza = this.zph;
      p.j(paramaza, "followsGroup");
      paramaza.setVisibility(8);
      AppMethodBeat.o(221387);
      return;
    }
    paramaza = paramaza.contact;
    if (paramaza != null) {}
    for (int i = paramaza.friend_follow_count; i > 0; i = 0)
    {
      paramaza = this.zph;
      p.j(paramaza, "followsGroup");
      paramaza.setVisibility(0);
      paramaza = MMApplicationContext.getContext();
      p.j(paramaza, "MMApplicationContext.getContext()");
      paramaza = paramaza.getResources().getString(b.j.finder_live_profile_followed_fans_desc, new Object[] { Integer.valueOf(i) });
      p.j(paramaza, "MMApplicationContext.get…wed_fans_desc, followCnt)");
      TextView localTextView = this.zpi;
      p.j(localTextView, "followsDescTv");
      localTextView.setText((CharSequence)paramaza);
      AppMethodBeat.o(221387);
      return;
    }
    paramaza = this.zph;
    p.j(paramaza, "followsGroup");
    paramaza.setVisibility(8);
    AppMethodBeat.o(221387);
  }
  
  private final void f(aza paramaza)
  {
    AppMethodBeat.i(221401);
    int j = paramaza.SDv;
    Object localObject = paramaza.contact;
    if (localObject != null)
    {
      localObject = ((FinderContact)localObject).username;
      label29:
      paramaza = paramaza.contact;
      if (paramaza == null) {
        break label129;
      }
    }
    label129:
    for (int i = paramaza.extFlag;; i = 0)
    {
      this.zoZ = com.tencent.mm.ae.d.dr(i, 1024);
      switch (j)
      {
      default: 
        paramaza = this.zpk;
        p.j(paramaza, "wechatPrivacyMsgBtn");
        paramaza.setVisibility(8);
        paramaza = this.zpn;
        p.j(paramaza, "finderPrivacyMsgLayout");
        paramaza.setVisibility(8);
        AppMethodBeat.o(221401);
        return;
        localObject = null;
        break label29;
      }
    }
    paramaza = this.zpk;
    p.j(paramaza, "wechatPrivacyMsgBtn");
    paramaza.setVisibility(8);
    paramaza = this.zpn;
    p.j(paramaza, "finderPrivacyMsgLayout");
    paramaza.setVisibility(0);
    paramaza = (CharSequence)localObject;
    if ((paramaza == null) || (paramaza.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      paramaza = this.zpm;
      p.j(paramaza, "followBtn");
      paramaza.setVisibility(8);
      AppMethodBeat.o(221401);
      return;
    }
    paramaza = this.zpm;
    p.j(paramaza, "followBtn");
    paramaza.setVisibility(0);
    aDg((String)localObject);
    AppMethodBeat.o(221401);
    return;
    paramaza = this.zpk;
    p.j(paramaza, "wechatPrivacyMsgBtn");
    paramaza.setVisibility(0);
    paramaza = this.zpn;
    p.j(paramaza, "finderPrivacyMsgLayout");
    paramaza.setVisibility(8);
    AppMethodBeat.o(221401);
    return;
    paramaza = this.zpk;
    p.j(paramaza, "wechatPrivacyMsgBtn");
    paramaza.setVisibility(0);
    paramaza = this.zpn;
    p.j(paramaza, "finderPrivacyMsgLayout");
    paramaza.setVisibility(8);
    AppMethodBeat.o(221401);
  }
  
  private static String g(aza paramaza)
  {
    boolean bool2 = true;
    Object localObject2 = null;
    AppMethodBeat.i(221450);
    StringBuilder localStringBuilder = new StringBuilder("headUrl is empty:");
    Object localObject1 = paramaza.contact;
    if (localObject1 != null)
    {
      localObject1 = ((FinderContact)localObject1).headUrl;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label266;
      }
      bool1 = true;
      label57:
      localStringBuilder = localStringBuilder.append(bool1).append(", nickName:");
      localObject1 = paramaza.contact;
      if (localObject1 == null) {
        break label271;
      }
      localObject1 = ((FinderContact)localObject1).nickname;
      label85:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(",authIconType:");
      localObject1 = paramaza.contact;
      if (localObject1 == null) {
        break label276;
      }
      localObject1 = ((FinderContact)localObject1).authInfo;
      if (localObject1 == null) {
        break label276;
      }
      localObject1 = Integer.valueOf(((FinderAuthInfo)localObject1).authIconType);
      label125:
      localStringBuilder = localStringBuilder.append(localObject1).append(',').append("roleType:").append(paramaza.SDv).append(",disableComment:").append(paramaza.SKR).append(", extInfo is empty:");
      localObject1 = paramaza.contact;
      if (localObject1 == null) {
        break label281;
      }
      localObject1 = ((FinderContact)localObject1).extInfo;
      label184:
      if (localObject1 != null) {
        break label286;
      }
      bool1 = true;
      label190:
      localStringBuilder = localStringBuilder.append(bool1).append(",signature is empty:");
      FinderContact localFinderContact = paramaza.contact;
      localObject1 = localObject2;
      if (localFinderContact != null) {
        localObject1 = localFinderContact.signature;
      }
      if (localObject1 != null) {
        break label291;
      }
    }
    label266:
    label271:
    label276:
    label281:
    label286:
    label291:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramaza = bool1 + ",reward:" + paramaza.SKS;
      AppMethodBeat.o(221450);
      return paramaza;
      localObject1 = null;
      break;
      bool1 = false;
      break label57;
      localObject1 = null;
      break label85;
      localObject1 = null;
      break label125;
      localObject1 = null;
      break label184;
      bool1 = false;
      break label190;
    }
  }
  
  public final void a(aza paramaza, int paramInt, bid parambid)
  {
    AppMethodBeat.i(221328);
    p.k(paramaza, "liveContact");
    int i = paramaza.SDv;
    Log.i(this.TAG, "showProfile contentIsShow:" + this.zpp + ",roleType:" + i + ",sourceType:" + paramInt);
    this.zoY = paramaza;
    this.sourceType = paramInt;
    this.reportObj = parambid;
    if (i != 3)
    {
      cQY();
      AppMethodBeat.o(221328);
      return;
    }
    this.kGl.setVisibility(0);
    paramaza = this.kFA;
    p.j(paramaza, "closeBtn");
    paramaza.setVisibility(4);
    paramaza = this.zpf;
    p.j(paramaza, "moreAction");
    paramaza.setVisibility(4);
    paramaza = this.zpa;
    p.j(paramaza, "profileInfoGroup");
    paramaza.setVisibility(4);
    paramaza = this.zpj;
    p.j(paramaza, "anchorActionGroup");
    paramaza.setVisibility(4);
    if (!this.zpp) {
      this.kFV.show();
    }
    paramaza = this.zoY;
    if (paramaza != null)
    {
      paramaza = paramaza.contact;
      if (paramaza != null)
      {
        parambid = paramaza.username;
        paramaza = parambid;
        if (parambid != null) {
          break label222;
        }
      }
    }
    paramaza = "";
    label222:
    paramaza = new cr(paramaza, 0L, null, 0, null, 0, 0L, 104);
    paramaza.xer = true;
    h.aGY().b((com.tencent.mm.an.q)paramaza);
    paramaza = h.aHF();
    p.j(paramaza, "MMKernel.network()");
    paramaza.aGY().a(3736, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(221328);
  }
  
  public final void dIu()
  {
    AppMethodBeat.i(221315);
    Log.i(this.TAG, "activate");
    IListener localIListener = this.zpo;
    if (localIListener != null)
    {
      localIListener.alive();
      AppMethodBeat.o(221315);
      return;
    }
    AppMethodBeat.o(221315);
  }
  
  public final void dIv()
  {
    AppMethodBeat.i(221318);
    Log.i(this.TAG, "deActivate");
    Object localObject = this.zpo;
    if (localObject != null) {
      ((IListener)localObject).dead();
    }
    localObject = h.aHF();
    p.j(localObject, "MMKernel.network()");
    ((c)localObject).aGY().b(3736, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(221318);
  }
  
  public final void onClick(View paramView)
  {
    String str = null;
    AppMethodBeat.i(221432);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    int i;
    if (paramView != null)
    {
      localObject1 = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_members_profile_info_group;
      if (localObject1 != null) {
        break label138;
      }
      label62:
      i = b.f.finder_live_members_profile_close_btn;
      if (localObject1 != null) {
        break label221;
      }
      label70:
      i = b.f.finder_live_members_profile_blank_area;
      if (localObject1 != null) {
        break label268;
      }
      label78:
      i = b.f.finder_live_members_profile_more_action_container;
      if (localObject1 != null) {
        break label315;
      }
      label86:
      i = b.f.wechat_privacy_msg_btn;
      if (localObject1 != null) {
        break label349;
      }
      label94:
      i = b.f.finder_privacy_msg_btn;
      if (localObject1 != null) {
        break label417;
      }
      i = b.f.follow_btn;
      if (localObject1 != null) {
        break label499;
      }
    }
    for (;;)
    {
      label110:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(221432);
      return;
      localObject1 = null;
      break;
      label138:
      if (((Integer)localObject1).intValue() != i) {
        break label62;
      }
      paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        paramView = k.yBj;
        k.a(s.ax.yKw);
      }
      localObject1 = this.zoW;
      if (localObject1 != null)
      {
        Object localObject2 = this.zoY;
        paramView = str;
        if (localObject2 != null)
        {
          localObject2 = ((aza)localObject2).contact;
          paramView = str;
          if (localObject2 != null) {
            paramView = ((FinderContact)localObject2).username;
          }
        }
        ((kotlin.g.a.b)localObject1).invoke(paramView);
        continue;
        label221:
        if (((Integer)localObject1).intValue() != i) {
          break label70;
        }
        this.kFV.hide();
        paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
        {
          paramView = k.yBj;
          k.a(s.c.yEB, String.valueOf(s.ax.yKo.action));
          continue;
          label268:
          if (((Integer)localObject1).intValue() != i) {
            break label78;
          }
          this.kFV.hide();
          paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
          {
            paramView = k.yBj;
            k.a(s.c.yEB, String.valueOf(s.ax.yKo.action));
            continue;
            label315:
            if (((Integer)localObject1).intValue() != i) {
              break label86;
            }
            this.kFV.hide();
            paramView = this.zoX;
            if (paramView != null)
            {
              paramView.invoke();
              continue;
              label349:
              if (((Integer)localObject1).intValue() != i) {
                break label94;
              }
              for (;;)
              {
                localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
                if (((Number)com.tencent.mm.plugin.finder.storage.d.dUP().aSr()).intValue() > 0) {
                  break label428;
                }
                localObject1 = paramView.getContext();
                paramView = paramView.getContext();
                p.j(paramView, "v.context");
                w.makeText((Context)localObject1, (CharSequence)paramView.getResources().getString(b.j.finder_cannot_send_msg_title), 0).show();
                break label110;
                label417:
                if (((Integer)localObject1).intValue() != i) {
                  break;
                }
              }
              label428:
              paramView = this.zoY;
              if (paramView != null)
              {
                localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
                if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
                {
                  localObject1 = k.yBj;
                  k.a(s.ax.yKr);
                }
                localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
                localObject1 = this.kiF.getContext();
                p.j(localObject1, "root.context");
                str = z.bdh();
                p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
                com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, str, paramView);
                continue;
                label499:
                if (((Integer)localObject1).intValue() == i)
                {
                  if (paramView == null)
                  {
                    paramView = new kotlin.t("null cannot be cast to non-null type android.widget.Button");
                    AppMethodBeat.o(221432);
                    throw paramView;
                  }
                  paramView = ((Button)paramView).getText();
                  localObject1 = MMApplicationContext.getContext();
                  p.j(localObject1, "MMApplicationContext.getContext()");
                  if (p.h(paramView, ((Context)localObject1).getResources().getString(b.j.finder_live_profile_follow)))
                  {
                    paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
                    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
                    {
                      paramView = k.yBj;
                      k.a(s.ax.yKs);
                    }
                    paramView = an.xci;
                    Oa(an.dnL());
                  }
                  else
                  {
                    localObject1 = MMApplicationContext.getContext();
                    p.j(localObject1, "MMApplicationContext.getContext()");
                    if (p.h(paramView, ((Context)localObject1).getResources().getString(b.j.finder_live_profile_unfollow)))
                    {
                      paramView = an.xci;
                      Oa(an.dnM());
                    }
                    else
                    {
                      localObject1 = MMApplicationContext.getContext();
                      p.j(localObject1, "MMApplicationContext.getContext()");
                      if (p.h(paramView, ((Context)localObject1).getResources().getString(b.j.finder_live_profile_unapply_follow)))
                      {
                        paramView = an.xci;
                        Oa(an.dnN());
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int i = 0;
    Object localObject1 = null;
    AppMethodBeat.i(221442);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramq);
    if ((paramq instanceof cr))
    {
      FinderContact localFinderContact = ((cr)paramq).dpc();
      paramInt2 = this.kiF.getVisibility();
      Object localObject2 = this.kiF.getContext();
      paramString = (String)localObject2;
      if (!(localObject2 instanceof Activity)) {
        paramString = null;
      }
      paramString = (Activity)paramString;
      boolean bool;
      if ((paramString != null) && (paramString.isFinishing() == true))
      {
        bool = true;
        paramString = this.zoY;
        if (paramString == null) {
          break label375;
        }
        paramString = paramString.contact;
        if (paramString == null) {
          break label375;
        }
      }
      label375:
      for (paramString = paramString.username;; paramString = null)
      {
        localObject2 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("onSceneEnd,isOnlyFetchUserInfo:").append(((cr)paramq).xer).append(", cur liveContact username:").append(paramString).append(", req username:").append(((cr)paramq).xcq).append("，contact username:");
        if (localFinderContact != null) {
          localObject1 = localFinderContact.username;
        }
        Log.i((String)localObject2, (String)localObject1 + ",visibility:" + paramInt2 + ",isFinish:" + bool);
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
        if ((paramInt1 != 0) || (!((cr)paramq).xer) || (!p.h(((cr)paramq).xcq, paramString))) {
          break label399;
        }
        paramString = h.aHF();
        p.j(paramString, "MMKernel.network()");
        paramString.aGY().b(3736, (com.tencent.mm.an.i)this);
        if ((!bool) && (paramInt2 == 0) && (this.zoY != null)) {
          break label380;
        }
        this.kFV.hide();
        AppMethodBeat.o(221442);
        return;
        bool = false;
        break;
      }
      label380:
      paramString = this.zoY;
      if (paramString != null) {
        paramString.contact = localFinderContact;
      }
      cQY();
    }
    label399:
    AppMethodBeat.o(221442);
  }
  
  public final void showCenterCustomizeToast(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(221311);
    p.k(paramString, "msg");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramString, paramInt));
    AppMethodBeat.o(221311);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget$1$1"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    a(x paramx)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    b(x paramx, String paramString, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.x
 * JD-Core Version:    0.7.0.1
 */