package com.tencent.mm.plugin.finder.profile.uihandler;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.profile.uic.h;
import com.tencent.mm.plugin.finder.upload.action.i;
import com.tencent.mm.plugin.finder.view.CollapsibleTextView;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uihandler/ProfileHeaderStyleActionHandler;", "Lcom/tencent/mm/plugin/finder/profile/uihandler/UiStyleActionHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "profileIsCovered", "", "name", "", "viewIds", "", "", "(Landroidx/appcompat/app/AppCompatActivity;ZLjava/lang/String;Ljava/util/List;)V", "actionBarFollowBtn", "Landroid/view/View;", "btnBgDrawable", "Landroid/graphics/drawable/Drawable;", "btnCoveredBgDrawable", "color08White", "coverExtractColor", "coveredLinkColor", "descTextView", "Lcom/tencent/mm/plugin/finder/view/CollapsibleTextView;", "editIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "eduCheckBox", "Landroid/widget/CheckBox;", "fg1Color", "isCovered", "()Z", "setCovered", "(Z)V", "link100Color", "liveNoticeDescText", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "profileEditContainer", "Landroid/view/ViewGroup;", "profileFollowBtn", "profileMsgBtn", "profileMsgTextView", "Landroid/widget/TextView;", "profileName", "serviceMenuTitleHeader", "tabLayoutOuterContainer", "taskContainerBg", "taskContainerLayout", "taskCoveredContainerBg", "username", "getUsername", "()Ljava/lang/String;", "whiteAlpha05Color2", "whiteColor", "getColor", "colorId", "handleCoveredViews", "", "handleNormalViews", "handleViews", "registerViews", "views", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
{
  private boolean Awl;
  private final int Fbh;
  private final int Fbt;
  private WeImageView FfY;
  private TextView FfZ;
  private View Fga;
  private View Fgb;
  private View Fgc;
  private View Fgd;
  private NeatTextView Fge;
  private ViewGroup Fgf;
  private TextView Fgg;
  private CollapsibleTextView Fgh;
  private CheckBox Fgi;
  private View Fgj;
  private View Fgk;
  private final int Fgl;
  private final int Fgm;
  private final int Fgn;
  private final int Fgo;
  private Drawable Fgp;
  private Drawable Fgq;
  private Drawable Fgr;
  private Drawable Fgs;
  private final String username;
  
  private c(AppCompatActivity paramAppCompatActivity, boolean paramBoolean, String paramString)
  {
    super(paramAppCompatActivity, null, paramString, 10);
    AppMethodBeat.i(348445);
    this.Awl = paramBoolean;
    this.username = paramAppCompatActivity.getIntent().getStringExtra("finder_username");
    this.Fgl = getColor(e.b.White);
    this.Fgm = getColor(e.b.BW_0_Alpha_0_5_Night_Mode);
    this.Fbh = paramAppCompatActivity.getResources().getColor(e.b.BW_0_Alpha_0_9_Night_Mode);
    this.Fgn = getColor(e.b.FG_1);
    this.Fgo = Color.parseColor("#DEE9FF");
    this.Fbt = paramAppCompatActivity.getResources().getColor(e.b.Link_100);
    paramString = paramAppCompatActivity.getResources().getDrawable(e.d.finder_live_notice_bg_shape);
    s.s(paramString, "activity.resources.getDr…der_live_notice_bg_shape)");
    this.Fgp = paramString;
    paramString = paramAppCompatActivity.getResources().getDrawable(e.d.profile_covered_task_region_bg);
    s.s(paramString, "activity.resources.getDr…e_covered_task_region_bg)");
    this.Fgq = paramString;
    paramString = paramAppCompatActivity.getResources().getDrawable(e.d.finder_profile_followed_btn_bg);
    s.s(paramString, "activity.resources.getDr…_profile_followed_btn_bg)");
    this.Fgr = paramString;
    paramAppCompatActivity = paramAppCompatActivity.getResources().getDrawable(e.d.finder_profile_covered_followed_btn_bg);
    s.s(paramAppCompatActivity, "activity.resources.getDr…_covered_followed_btn_bg)");
    this.Fgs = paramAppCompatActivity;
    AppMethodBeat.o(348445);
  }
  
  private final int getColor(int paramInt)
  {
    AppMethodBeat.i(348456);
    paramInt = getActivity().getResources().getColor(paramInt);
    AppMethodBeat.o(348456);
    return paramInt;
  }
  
  public final void eKx()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(348475);
    if (this.Awl)
    {
      localObject3 = this.Fgb;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("profileFollowBtn");
        localObject1 = null;
      }
      ((View)localObject1).setBackground(this.Fgs);
      localObject3 = this.Fgc;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("actionBarFollowBtn");
        localObject1 = null;
      }
      ((View)localObject1).setBackground(this.Fgs);
      localObject3 = this.Fgd;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("profileMsgBtn");
        localObject1 = null;
      }
      ((View)localObject1).setBackground(getActivity().getResources().getDrawable(e.d.profile_covered_send_msg_bg));
      localObject3 = this.Fgf;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("profileEditContainer");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setBackground(this.Fgq);
      localObject3 = this.Fgi;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("eduCheckBox");
        localObject1 = null;
      }
      ((CheckBox)localObject1).setBackground(getActivity().getDrawable(e.d.finder_news_feed_checkbox_covered_selector));
      localObject3 = this.Fgj;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("tabLayoutOuterContainer");
        localObject1 = null;
      }
      ((View)localObject1).setBackgroundColor(getColor(e.b.BW_0_Alpha_0_4));
      localObject3 = this.Fgk;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("serviceMenuTitleHeader");
        localObject1 = null;
      }
      ((View)localObject1).setBackground(getActivity().getResources().getDrawable(e.d.finder_service_menu_title_bg_covered));
      localObject3 = this.Fge;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("liveNoticeDescText");
        localObject1 = null;
      }
      ((NeatTextView)localObject1).setTextColor(this.Fgm);
      localObject3 = this.Fgg;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("profileMsgTextView");
        localObject1 = null;
      }
      ((TextView)localObject1).setTextColor(this.Fgl);
      localObject1 = this.Fgh;
      if (localObject1 == null)
      {
        s.bIx("descTextView");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((CollapsibleTextView)localObject1).iD(this.Fbh, this.Fgo);
        localObject1 = k.aeZF;
        ((h)k.d(getActivity()).q(h.class)).S(true, this.Fgo);
        AppMethodBeat.o(348475);
        return;
      }
    }
    Object localObject1 = i.Gde;
    if (!i.a(i.fej(), this.username, true, false, 4))
    {
      localObject1 = getActivity().getDrawable(e.d.finder_profile_follow_btn_bg);
      View localView = this.Fgb;
      localObject2 = localView;
      if (localView == null)
      {
        s.bIx("profileFollowBtn");
        localObject2 = null;
      }
      ((View)localObject2).setBackground((Drawable)localObject1);
      localView = this.Fgc;
      localObject2 = localView;
      if (localView == null)
      {
        s.bIx("actionBarFollowBtn");
        localObject2 = null;
      }
      ((View)localObject2).setBackground((Drawable)localObject1);
      localObject2 = this.Fgd;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("profileMsgBtn");
        localObject1 = null;
      }
      ((View)localObject1).setBackground(this.Fgr);
      localObject2 = this.Fgi;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("eduCheckBox");
        localObject1 = null;
      }
      ((CheckBox)localObject1).setBackground(getActivity().getDrawable(e.d.finder_news_feed_checkbox_selector));
      localObject2 = this.Fgj;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("tabLayoutOuterContainer");
        localObject1 = null;
      }
      ((View)localObject1).setBackgroundColor(getColor(e.b.BG_2));
      localObject2 = this.Fgf;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("profileEditContainer");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setBackgroundColor(getColor(e.b.BG_3));
      localObject2 = this.Fgk;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("serviceMenuTitleHeader");
        localObject1 = null;
      }
      ((View)localObject1).setBackground(getActivity().getResources().getDrawable(e.d.finder_service_menu_title_bg));
      localObject2 = this.Fgh;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("descTextView");
        localObject1 = null;
      }
      ((CollapsibleTextView)localObject1).iD(this.Fgn, this.Fbt);
      localObject1 = k.aeZF;
      ((h)k.d(getActivity()).q(h.class)).S(false, this.Fbt);
      localObject2 = this.Fge;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("liveNoticeDescText");
        localObject1 = null;
      }
      ((NeatTextView)localObject1).setTextColor(this.Fgn);
      localObject1 = this.Fgg;
      if (localObject1 != null) {
        break label715;
      }
      s.bIx("profileMsgTextView");
      localObject1 = localObject3;
    }
    label715:
    for (;;)
    {
      ((TextView)localObject1).setTextColor(getColor(e.b.profile_btn_text));
      AppMethodBeat.o(348475);
      return;
      localObject1 = this.Fgr;
      break;
    }
  }
  
  public final void z(List<? extends View> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(348466);
    paramList = getActivity();
    paramList1 = paramList.findViewById(e.e.finder_profile_edit_btn);
    s.s(paramList1, "findViewById(R.id.finder_profile_edit_btn)");
    this.FfY = ((WeImageView)paramList1);
    paramList1 = paramList.findViewById(e.e.finder_profile_name_tv);
    s.s(paramList1, "findViewById(R.id.finder_profile_name_tv)");
    this.FfZ = ((TextView)paramList1);
    paramList1 = paramList.findViewById(e.e.notice_activity_layout);
    s.s(paramList1, "findViewById(R.id.notice_activity_layout)");
    this.Fga = paramList1;
    paramList1 = paramList.findViewById(e.e.finder_profile_follow_btn);
    s.s(paramList1, "findViewById(R.id.finder_profile_follow_btn)");
    this.Fgb = paramList1;
    paramList1 = paramList.findViewById(e.e.actionbar_follow_btn);
    s.s(paramList1, "findViewById(R.id.actionbar_follow_btn)");
    this.Fgc = paramList1;
    paramList1 = paramList.findViewById(e.e.sendMsgBtn);
    s.s(paramList1, "findViewById(R.id.sendMsgBtn)");
    this.Fgd = paramList1;
    paramList1 = paramList.findViewById(e.e.collapse_content_tv);
    s.s(paramList1, "findViewById(R.id.collapse_content_tv)");
    this.Fge = ((NeatTextView)paramList1);
    paramList1 = paramList.findViewById(e.e.finder_profile_edit_ll);
    s.s(paramList1, "findViewById(R.id.finder_profile_edit_ll)");
    this.Fgf = ((ViewGroup)paramList1);
    paramList1 = paramList.findViewById(e.e.finder_profile_send_msg_btn_tv);
    s.s(paramList1, "findViewById(R.id.finder_profile_send_msg_btn_tv)");
    this.Fgg = ((TextView)paramList1);
    paramList1 = paramList.findViewById(e.e.finder_profile_desc_tv);
    s.s(paramList1, "findViewById(R.id.finder_profile_desc_tv)");
    this.Fgh = ((CollapsibleTextView)paramList1);
    paramList1 = paramList.findViewById(e.e.edu_tips_layout_checkbox);
    s.s(paramList1, "findViewById(R.id.edu_tips_layout_checkbox)");
    this.Fgi = ((CheckBox)paramList1);
    paramList1 = paramList.findViewById(e.e.tabLayoutOuterContainer);
    s.s(paramList1, "findViewById(R.id.tabLayoutOuterContainer)");
    this.Fgj = paramList1;
    paramList = paramList.findViewById(e.e.service_menu_title_header);
    s.s(paramList, "findViewById(R.id.service_menu_title_header)");
    this.Fgk = paramList;
    AppMethodBeat.o(348466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uihandler.c
 * JD-Core Version:    0.7.0.1
 */