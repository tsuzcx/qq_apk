package com.tencent.mm.plugin.finder.activity.uic;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cg;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.upload.k;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.b.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "activityDesc", "", "activityName", "activityType", "", "announceTv", "Landroid/widget/TextView;", "avatarImage", "Landroid/widget/ImageView;", "cancelBtn", "cndCoverUrl", "descEdit", "Lcom/tencent/mm/ui/widget/MMEditText;", "descMaxPaddingBottom", "descMinPaddingBottom", "descWordHintText", "endTime", "", "endTimeContent", "errorTipsLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getErrorTipsLayout", "()Landroid/view/View;", "errorTipsLayout$delegate", "Lkotlin/Lazy;", "errorTipsTextView", "getErrorTipsTextView", "()Landroid/widget/TextView;", "errorTipsTextView$delegate", "isCoverSet", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "localCoverUrl", "nameEdit", "nameWordHintText", "nickName", "nickNameText", "postBtn", "Landroid/widget/Button;", "postBtnMinMarginTop", "getPostBtnMinMarginTop", "()I", "postBtnMinMarginTop$delegate", "postBtnOriginMarginTop", "getPostBtnOriginMarginTop", "postBtnOriginMarginTop$delegate", "scrollView", "Landroid/widget/ScrollView;", "selectTimeText", "selectedDateIndex", "selectedHourIndex", "titleText", "userName", "animateDesc", "", "isBig", "cancelActivity", "checkPost", "doPost", "doScene", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getActivityName", "initEdit", "initSelectTime", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetTopicIdSuccess", "eventTopicId", "onKeyboardHeightChanged", "height", "isResized", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setAnnounceView", "isCovered", "setCoverStyle", "setNormalStyle", "setTextColor", "color", "showErrorTips", "isShow", "showTimePicker", "Companion", "plugin-finder_release"})
public final class d
  extends UIComponent
  implements com.tencent.mm.an.i, com.tencent.mm.ui.tools.h
{
  private static final kotlin.f wYo;
  public static final a wYp;
  private String activityName;
  private long endTime;
  private ScrollView jbL;
  private com.tencent.mm.ui.tools.i jij;
  private TextView mRJ;
  private String nickName;
  private String userName;
  private ImageView wXD;
  private TextView wXG;
  private TextView wXS;
  private MMEditText wXT;
  private MMEditText wXU;
  private Button wXV;
  private TextView wXW;
  private TextView wXX;
  private TextView wXY;
  private TextView wXZ;
  private String wYa;
  private int wYb;
  private int wYc;
  private String wYd;
  private int wYe;
  private int wYf;
  private boolean wYg;
  private String wYh;
  private String wYi;
  private int wYj;
  private final kotlin.f wYk;
  private final kotlin.f wYl;
  private final kotlin.f wYm;
  private final kotlin.f wYn;
  
  static
  {
    AppMethodBeat.i(284643);
    wYp = new a((byte)0);
    wYo = kotlin.g.ar((kotlin.g.a.a)d.b.wYq);
    AppMethodBeat.o(284643);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(284642);
    this.wYa = "";
    this.nickName = "";
    this.userName = "";
    this.activityName = "";
    this.wYd = "";
    this.wYh = "";
    this.wYi = "";
    this.wYj = 101;
    this.wYk = kotlin.g.ar((kotlin.g.a.a)new n(this));
    this.wYl = kotlin.g.ar((kotlin.g.a.a)new o(this));
    this.wYm = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.wYn = kotlin.g.ar((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(284642);
  }
  
  private final void L(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(284640);
    if (paramBoolean)
    {
      localView = dmG();
      p.j(localView, "errorTipsLayout");
      localView.setVisibility(0);
      if (paramInt == -4055)
      {
        dmH().setText(b.j.finder_activity_create_failed_has_existed);
        AppMethodBeat.o(284640);
        return;
      }
      if (paramInt == -4066)
      {
        dmH().setText(b.j.finder_activity_create_failed_character_error);
        AppMethodBeat.o(284640);
        return;
      }
      dmH().setText(b.j.finder_activity_create_unknown_failed);
      AppMethodBeat.o(284640);
      return;
    }
    View localView = dmG();
    p.j(localView, "errorTipsLayout");
    localView.setVisibility(8);
    AppMethodBeat.o(284640);
  }
  
  private final void d(c paramc)
  {
    AppMethodBeat.i(284635);
    String str = getActivityName();
    Object localObject = this.wXU;
    if (localObject == null) {
      p.bGy("descEdit");
    }
    localObject = ((MMEditText)localObject).getText().toString();
    if ((paramc instanceof k)) {}
    for (paramc = ((k)paramc).coverUrl;; paramc = "")
    {
      this.wYh = paramc;
      com.tencent.mm.kernel.h.aGY().a(4050, (com.tencent.mm.an.i)this);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new cg(this.userName, str, (String)localObject, this.wYh, this.endTime, 0, 32));
      AppMethodBeat.o(284635);
      return;
    }
  }
  
  private final int dmF()
  {
    AppMethodBeat.i(284623);
    int i = ((Number)this.wYk.getValue()).intValue();
    AppMethodBeat.o(284623);
    return i;
  }
  
  private final View dmG()
  {
    AppMethodBeat.i(284624);
    View localView = (View)this.wYm.getValue();
    AppMethodBeat.o(284624);
    return localView;
  }
  
  private final TextView dmH()
  {
    AppMethodBeat.i(284625);
    TextView localTextView = (TextView)this.wYn.getValue();
    AppMethodBeat.o(284625);
    return localTextView;
  }
  
  private final String getActivityName()
  {
    AppMethodBeat.i(284634);
    Object localObject = this.wXT;
    if (localObject == null) {
      p.bGy("nameEdit");
    }
    localObject = ((MMEditText)localObject).getText().toString();
    AppMethodBeat.o(284634);
    return localObject;
  }
  
  private final void ob(boolean paramBoolean)
  {
    AppMethodBeat.i(284632);
    Object localObject = getContext().getResources().getString(b.j.finder_activity_announce_name);
    p.j(localObject, "context.resources.getStr…r_activity_announce_name)");
    String str = getResources().getString(b.j.finder_activity_post_announce, new Object[] { localObject });
    p.j(str, "resources.getString(R.st…t_announce, announceName)");
    SpannableString localSpannableString = new SpannableString((CharSequence)str);
    TextView localTextView;
    if (paramBoolean)
    {
      localTextView = this.wXX;
      if (localTextView != null) {
        localTextView.setTextColor(getResources().getColor(b.c.BW_100_Alpha_0_5));
      }
    }
    for (;;)
    {
      localSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.o(str, getResources().getColor(b.c.hot_tab_stream_link_color), getContext().getResources().getColor(b.c.transparent), false, false, (kotlin.g.a.b)new p(this)), str.length() - ((String)localObject).length(), str.length(), 17);
      localObject = this.wXX;
      if (localObject != null) {
        ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o((Context)getContext()));
      }
      localObject = this.wXX;
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setText((CharSequence)localSpannableString);
      AppMethodBeat.o(284632);
      return;
      localTextView = this.wXX;
      if (localTextView != null) {
        localTextView.setTextColor(getResources().getColor(b.c.FG_1));
      }
    }
    AppMethodBeat.o(284632);
  }
  
  private final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(284638);
    Object localObject = this.wXT;
    if (localObject == null) {
      p.bGy("nameEdit");
    }
    ((MMEditText)localObject).setTextColor(paramInt);
    localObject = this.wXU;
    if (localObject == null) {
      p.bGy("descEdit");
    }
    ((MMEditText)localObject).setTextColor(paramInt);
    localObject = this.wXS;
    if (localObject == null) {
      p.bGy("titleText");
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = this.mRJ;
    if (localObject == null) {
      p.bGy("cancelBtn");
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = this.wXW;
    if (localObject == null) {
      p.bGy("selectTimeText");
    }
    ((TextView)localObject).setTextColor(paramInt);
    AppMethodBeat.o(284638);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(284639);
    Object localObject = this.wXV;
    if (localObject == null) {
      p.bGy("postBtn");
    }
    localObject = ((Button)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(284639);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    int i = ((Number)this.wYl.getValue()).intValue() - paramInt;
    paramInt = i;
    if (i < dmF()) {
      paramInt = dmF();
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt;
    Button localButton = this.wXV;
    if (localButton == null) {
      p.bGy("postBtn");
    }
    localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(284639);
  }
  
  public final void dmI()
  {
    AppMethodBeat.i(284636);
    this.wYg = true;
    int i = getResources().getColor(b.c.finder_activity_covered_white);
    Object localObject = this.wXG;
    if (localObject == null) {
      p.bGy("nickNameText");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(b.c.BW_100_Alpha_0_8));
    setTextColor(i);
    localObject = this.wXT;
    if (localObject == null) {
      p.bGy("nameEdit");
    }
    ((MMEditText)localObject).setBackgroundResource(b.e.finder_post_activity_edit_covered_bg);
    localObject = this.wXU;
    if (localObject == null) {
      p.bGy("descEdit");
    }
    ((MMEditText)localObject).setBackgroundResource(b.e.finder_post_activity_edit_covered_bg);
    localObject = this.wXW;
    if (localObject == null) {
      p.bGy("selectTimeText");
    }
    ((TextView)localObject).setBackgroundResource(b.e.finder_post_activity_edit_covered_bg);
    localObject = this.wXT;
    if (localObject == null) {
      p.bGy("nameEdit");
    }
    ((MMEditText)localObject).setHintTextColor(getResources().getColor(b.c.finder_activity_text_covered_hint));
    localObject = this.wXU;
    if (localObject == null) {
      p.bGy("descEdit");
    }
    ((MMEditText)localObject).setHintTextColor(getResources().getColor(b.c.finder_activity_text_covered_hint));
    localObject = this.wXW;
    if (localObject == null) {
      p.bGy("selectTimeText");
    }
    ((TextView)localObject).setHintTextColor(getResources().getColor(b.c.finder_activity_text_covered_hint));
    ob(true);
    AppMethodBeat.o(284636);
  }
  
  public final void dmy()
  {
    AppMethodBeat.i(284637);
    this.wYg = false;
    setTextColor(getResources().getColor(b.c.black_color));
    Object localObject = this.wXG;
    if (localObject == null) {
      p.bGy("nickNameText");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(b.c.FG_0));
    localObject = this.wXT;
    if (localObject == null) {
      p.bGy("nameEdit");
    }
    ((MMEditText)localObject).setBackgroundResource(b.e.finder_post_activity_edit_bg);
    localObject = this.wXT;
    if (localObject == null) {
      p.bGy("nameEdit");
    }
    ((MMEditText)localObject).setHintTextColor(getResources().getColor(b.c.BW_0_Alpha_0_3));
    localObject = this.wXU;
    if (localObject == null) {
      p.bGy("descEdit");
    }
    ((MMEditText)localObject).setBackgroundResource(b.e.finder_post_activity_edit_bg);
    localObject = this.wXU;
    if (localObject == null) {
      p.bGy("descEdit");
    }
    ((MMEditText)localObject).setHintTextColor(getResources().getColor(b.c.BW_0_Alpha_0_3));
    localObject = this.wXW;
    if (localObject == null) {
      p.bGy("selectTimeText");
    }
    ((TextView)localObject).setHintTextColor(getResources().getColor(b.c.BW_0_Alpha_0_3));
    localObject = this.wXW;
    if (localObject == null) {
      p.bGy("selectTimeText");
    }
    ((TextView)localObject).setBackgroundResource(b.e.finder_post_activity_edit_bg);
    ob(false);
    AppMethodBeat.o(284637);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(284626);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_activity_post_scroll);
    p.j(paramBundle, "activity.findViewById(R.…der_activity_post_scroll)");
    this.jbL = ((ScrollView)paramBundle);
    Object localObject1 = getIntent().getStringExtra("key_nick_name");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.nickName = paramBundle;
    localObject1 = getIntent().getStringExtra("key_user_name");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.userName = paramBundle;
    localObject1 = getIntent().getStringExtra("key_activity_name");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.activityName = paramBundle;
    localObject1 = getIntent().getStringExtra("key_activity_desc");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.wYd = paramBundle;
    localObject1 = getIntent().getStringExtra("key_activity_local_cover_url");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.wYi = paramBundle;
    this.wYj = getIntent().getIntExtra("key_activity_type", 101);
    this.wYg = Util.isNullOrNil(this.wYi);
    this.wYe = ((int)getResources().getDimension(b.d.Edge_2A));
    this.wYf = ((int)getResources().getDimension(b.d.Edge_5_5_A));
    paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)this.nickName).toString();
    p.j(paramBundle, "MMSpanManager.spanForSmi…this.nickName).toString()");
    localObject1 = getActivity().findViewById(b.f.finder_activity_post_cancel_btn);
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new h(this));
    p.j(localObject1, "activity.findViewById<Te…)\n            }\n        }");
    this.mRJ = ((TextView)localObject1);
    localObject1 = getActivity().findViewById(b.f.finder_activity_post_title);
    p.j(localObject1, "activity.findViewById(R.…nder_activity_post_title)");
    this.wXS = ((TextView)localObject1);
    localObject1 = this.wXS;
    if (localObject1 == null) {
      p.bGy("titleText");
    }
    ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = getActivity();
    Object localObject2 = ((AppCompatActivity)localObject1).findViewById(b.f.finder_activity_post_name_edit);
    p.j(localObject2, "findViewById(R.id.finder_activity_post_name_edit)");
    this.wXT = ((MMEditText)localObject2);
    if (!TextUtils.isEmpty((CharSequence)this.activityName))
    {
      localObject2 = this.wXT;
      if (localObject2 == null) {
        p.bGy("nameEdit");
      }
      ((MMEditText)localObject2).setText((CharSequence)this.activityName);
    }
    localObject2 = ((AppCompatActivity)localObject1).findViewById(b.f.finder_activity_post_desc_edit);
    p.j(localObject2, "findViewById(R.id.finder_activity_post_desc_edit)");
    this.wXU = ((MMEditText)localObject2);
    if (!TextUtils.isEmpty((CharSequence)this.wYd))
    {
      localObject2 = this.wXU;
      if (localObject2 == null) {
        p.bGy("descEdit");
      }
      ((MMEditText)localObject2).setText((CharSequence)this.wYd);
    }
    localObject2 = ((AppCompatActivity)localObject1).findViewById(b.f.activity_profile_header_name);
    p.j(localObject2, "findViewById(R.id.activity_profile_header_name)");
    this.wXG = ((TextView)localObject2);
    localObject1 = ((AppCompatActivity)localObject1).findViewById(b.f.activity_profile_header_avatar);
    p.j(localObject1, "findViewById(R.id.activity_profile_header_avatar)");
    this.wXD = ((ImageView)localObject1);
    localObject1 = this.wXG;
    if (localObject1 == null) {
      p.bGy("nickNameText");
    }
    ((TextView)localObject1).setText((CharSequence)paramBundle);
    localObject1 = getIntent().getStringExtra("key_avatar_url");
    paramBundle = com.tencent.mm.plugin.finder.loader.t.ztT;
    paramBundle = com.tencent.mm.plugin.finder.loader.t.dJh();
    localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
    localObject2 = this.wXD;
    if (localObject2 == null) {
      p.bGy("avatarImage");
    }
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    paramBundle.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
    paramBundle = new StringBuilder("nameEdit size ");
    localObject1 = this.wXT;
    if (localObject1 == null) {
      p.bGy("nameEdit");
    }
    paramBundle = paramBundle.append(((MMEditText)localObject1).getTextSize()).append("  descEdit size ");
    localObject1 = this.wXU;
    if (localObject1 == null) {
      p.bGy("descEdit");
    }
    Log.i("SimpleUIComponent", ((MMEditText)localObject1).getTextSize());
    paramBundle = (View.OnTouchListener)new g(this);
    localObject1 = this.wXT;
    if (localObject1 == null) {
      p.bGy("nameEdit");
    }
    ((MMEditText)localObject1).setOnTouchListener(paramBundle);
    localObject1 = this.wXU;
    if (localObject1 == null) {
      p.bGy("descEdit");
    }
    ((MMEditText)localObject1).setOnTouchListener(paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_activity_post_btn);
    p.j(paramBundle, "activity.findViewById(R.…finder_activity_post_btn)");
    this.wXV = ((Button)paramBundle);
    paramBundle = this.wXV;
    if (paramBundle == null) {
      p.bGy("postBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new i(this));
    this.wXX = ((TextView)getActivity().findViewById(b.f.activity_post_announce_text));
    ob(false);
    paramBundle = this.wXT;
    if (paramBundle == null) {
      p.bGy("nameEdit");
    }
    paramBundle.addTextChangedListener((TextWatcher)new j(this));
    paramBundle = this.wXT;
    if (paramBundle == null) {
      p.bGy("nameEdit");
    }
    ar.a((Paint)paramBundle.getPaint(), 0.8F);
    this.wXY = ((TextView)getActivity().findViewById(b.f.finder_activity_post_name_word));
    this.wXZ = ((TextView)getActivity().findViewById(b.f.finder_activity_post_desc_word));
    paramBundle = this.wXU;
    if (paramBundle == null) {
      p.bGy("descEdit");
    }
    paramBundle.addTextChangedListener((TextWatcher)new k(this));
    paramBundle = getActivity().findViewById(b.f.finder_activity_time_text);
    p.j(paramBundle, "activity.findViewById(R.…inder_activity_time_text)");
    this.wXW = ((TextView)paramBundle);
    paramBundle = this.wXW;
    if (paramBundle == null) {
      p.bGy("selectTimeText");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new l(this));
    localObject1 = Calendar.getInstance();
    p.j(localObject1, "currentDate");
    paramBundle = aj.AGc;
    ((Calendar)localObject1).setTimeInMillis(aj.eel());
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    paramBundle = Calendar.getInstance();
    p.j(paramBundle, "newDate");
    localObject2 = aj.AGc;
    paramBundle.setTimeInMillis(aj.eel());
    paramBundle.add(2, 1);
    paramBundle.add(11, 1);
    paramBundle.set(12, 0);
    paramBundle.set(13, 0);
    this.wYb = (paramBundle.get(6) - ((Calendar)localObject1).get(6));
    this.wYc = paramBundle.get(11);
    if (this.wYc > 23) {
      this.wYc = 23;
    }
    Log.i("SimpleUIComponent", "initSelectTime time:" + paramBundle.getTime() + ",timeInMills:" + paramBundle.getTimeInMillis());
    this.endTime = (paramBundle.getTimeInMillis() / 1000L);
    int i = paramBundle.get(7);
    if (i - 2 < 0) {
      i = 7;
    }
    for (;;)
    {
      int j = paramBundle.get(5);
      int k = paramBundle.get(2);
      localObject1 = getContext().getResources().getString(b.j.finder_live_notice_date_format, new Object[] { Integer.valueOf(k + 1), Integer.valueOf(j) }) + ' ' + m.d((Context)getContext(), i, "campaign");
      localObject2 = aj.AGc;
      paramBundle = aj.Rl(paramBundle.get(11));
      paramBundle = getContext().getResources().getString(b.j.finder_campaign_time_picker_hour, new Object[] { paramBundle });
      p.j(paramBundle, "context.resources.getStr…ime_picker_hour, hourStr)");
      this.wYa = ((String)localObject1 + ' ' + paramBundle);
      paramBundle = this.wXW;
      if (paramBundle == null) {
        p.bGy("selectTimeText");
      }
      paramBundle.setText((CharSequence)this.wYa);
      this.jij = new com.tencent.mm.ui.tools.i((Activity)getActivity());
      paramBundle = this.jij;
      if (paramBundle == null) {
        p.bGy("keyboardHeightProvider");
      }
      paramBundle.setKeyboardHeightObserver((com.tencent.mm.ui.tools.h)this);
      AppMethodBeat.o(284626);
      return;
      i -= 1;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(284630);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(4050, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(284630);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(284628);
    super.onPause();
    com.tencent.mm.ui.tools.i locali = this.jij;
    if (locali == null) {
      p.bGy("keyboardHeightProvider");
    }
    locali.close();
    AppMethodBeat.o(284628);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(284627);
    super.onResume();
    Button localButton = this.wXV;
    if (localButton == null) {
      p.bGy("postBtn");
    }
    localButton.post((Runnable)new m(this));
    AppMethodBeat.o(284627);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(284633);
    Log.i("SimpleUIComponent", "onSceneEnd: errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
    if ((paramq instanceof cg))
    {
      paramString = com.tencent.mm.ui.component.g.Xox;
      ((e)com.tencent.mm.ui.component.g.b(getActivity()).i(e.class)).dmL();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        long l = ((cg)paramq).xdR;
        paramString = getActivityName();
        paramq = this.wXU;
        if (paramq == null) {
          p.bGy("descEdit");
        }
        String str = paramq.getText().toString();
        paramq = new Intent();
        paramq.putExtra("key_topic_id", l);
        paramq.putExtra("key_activity_name", paramString);
        paramq.putExtra("key_activity_desc", str);
        paramq.putExtra("key_nick_name", this.nickName);
        paramq.putExtra("key_activity_local_cover_url", this.wYi);
        paramq.putExtra("key_cover_url", this.wYh);
        paramq.putExtra("key_activity_type", 101);
        Log.i("FinderActivityPostUI", "eventTopicId:" + l + "  name:" + paramString + "  desc:" + str);
        paramString = getActivity();
        paramString.setResult(-1, paramq);
        if (!paramString.isFinishing()) {
          paramString.finish();
        }
        AppMethodBeat.o(284633);
        return;
      }
      L(true, paramInt2);
    }
    AppMethodBeat.o(284633);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$Companion;", "", "()V", "DESC_ANIM_DURATION", "", "DESC_CHAR_LIMIT", "", "getDESC_CHAR_LIMIT", "()I", "DESC_CHAR_LIMIT$delegate", "Lkotlin/Lazy;", "DESC_SHOW_HINT_LEAST_LIMIT", "NAME_CHAR_LIMIT", "NAME_SHOW_HINT_LEAST_LIMIT", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$animateDesc$descAnimator$1$1"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(d paramd, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(282008);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(282008);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      d.i(this.wYr).setPadding(this.wYs, this.wYt, this.wYu, i);
      AppMethodBeat.o(282008);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<c>
  {
    public final void a(c paramc, com.tencent.mm.loader.g.j paramj)
    {
      AppMethodBeat.i(270868);
      p.k(paramc, "task");
      p.k(paramj, "status");
      if (paramj == com.tencent.mm.loader.g.j.kQe)
      {
        paramc = com.tencent.mm.ui.component.g.Xox;
        ((e)com.tencent.mm.ui.component.g.b(this.wYr.getActivity()).i(e.class)).dmL();
        AppMethodBeat.o(270868);
        return;
      }
      paramj = com.tencent.mm.ui.component.g.Xox;
      ((e)com.tencent.mm.ui.component.g.b(this.wYr.getActivity()).i(e.class)).setCover(d.p(this.wYr));
      d.a(this.wYr, paramc);
      AppMethodBeat.o(270868);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class g
    implements View.OnTouchListener
  {
    g(d paramd) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(269926);
      if ((p.h(paramView, d.n(this.wYr))) || (p.h(paramView, d.i(this.wYr))))
      {
        if (paramMotionEvent == null) {
          break label64;
        }
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        if (paramView != null) {
          break label69;
        }
        label49:
        if (paramView != null) {
          break label90;
        }
      }
      label64:
      label69:
      label90:
      while (paramView.intValue() != 3)
      {
        if (paramView != null) {
          break label112;
        }
        for (;;)
        {
          AppMethodBeat.o(269926);
          return false;
          paramView = null;
          break;
          if (paramView.intValue() != 0) {
            break label49;
          }
          d.o(this.wYr).requestDisallowInterceptTouchEvent(true);
        }
      }
      for (;;)
      {
        d.o(this.wYr).requestDisallowInterceptTouchEvent(false);
        break;
        label112:
        if (paramView.intValue() != 1) {
          break;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$1$1"})
  static final class h
    implements View.OnClickListener
  {
    h(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286509);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      d.c(this.wYr);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286509);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$2$1"})
  static final class i
    implements View.OnClickListener
  {
    i(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278706);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      d.a(this.wYr);
      d.d(this.wYr);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278706);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class j
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(257181);
      int i;
      if (paramEditable != null)
      {
        i = paramEditable.toString().length();
        if (8 <= i) {
          break label103;
        }
        if (i != 10) {
          break label178;
        }
        paramEditable = d.e(this.wYr);
        if (paramEditable != null) {
          paramEditable.setTextColor(this.wYr.getResources().getColor(b.c.FG_1));
        }
        paramEditable = d.e(this.wYr);
        if (paramEditable != null) {
          paramEditable.setText((CharSequence)"");
        }
        d.f(this.wYr).setEnabled(true);
      }
      for (;;)
      {
        d.a(this.wYr);
        AppMethodBeat.o(257181);
        return;
        label103:
        if (10 <= i) {
          break;
        }
        paramEditable = d.e(this.wYr);
        if (paramEditable != null) {
          paramEditable.setTextColor(this.wYr.getResources().getColor(b.c.FG_1));
        }
        paramEditable = d.e(this.wYr);
        if (paramEditable != null) {
          paramEditable.setText((CharSequence)String.valueOf(10 - i));
        }
        d.f(this.wYr).setEnabled(true);
        continue;
        label178:
        if (i > 10)
        {
          paramEditable = d.e(this.wYr);
          if (paramEditable != null) {
            paramEditable.setTextColor(this.wYr.getResources().getColor(b.c.Red));
          }
          paramEditable = d.e(this.wYr);
          if (paramEditable != null) {
            paramEditable.setText((CharSequence)String.valueOf(10 - i));
          }
          d.f(this.wYr).setEnabled(false);
        }
        else
        {
          paramEditable = d.e(this.wYr);
          if (paramEditable != null) {
            paramEditable.setText((CharSequence)"");
          }
          d.f(this.wYr).setEnabled(true);
        }
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class k
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(289322);
      int i;
      int k;
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (paramEditable != null)
        {
          i = paramEditable.length();
          paramEditable = d.wYp;
          int j = d.a.dmK();
          paramEditable = d.wYp;
          k = d.a.dmK();
          if (j - 10 <= i) {
            break label146;
          }
          label48:
          paramEditable = d.wYp;
          if (i != d.a.dmK()) {
            break label235;
          }
          paramEditable = d.g(this.wYr);
          if (paramEditable != null) {
            paramEditable.setTextColor(this.wYr.getResources().getColor(b.c.FG_1));
          }
          paramEditable = d.g(this.wYr);
          if (paramEditable != null) {
            paramEditable.setText((CharSequence)"");
          }
          d.a(this.wYr, false);
          d.f(this.wYr).setEnabled(true);
        }
      }
      for (;;)
      {
        d.a(this.wYr);
        AppMethodBeat.o(289322);
        return;
        i = 0;
        break;
        label146:
        if (k <= i) {
          break label48;
        }
        paramEditable = d.g(this.wYr);
        if (paramEditable != null) {
          paramEditable.setTextColor(this.wYr.getResources().getColor(b.c.FG_1));
        }
        paramEditable = d.g(this.wYr);
        d.a locala;
        if (paramEditable != null)
        {
          locala = d.wYp;
          paramEditable.setText((CharSequence)String.valueOf(d.a.dmK() - i));
        }
        d.a(this.wYr, true);
        d.f(this.wYr).setEnabled(true);
        continue;
        label235:
        paramEditable = d.wYp;
        if (i > d.a.dmK())
        {
          paramEditable = d.g(this.wYr);
          if (paramEditable != null) {
            paramEditable.setTextColor(this.wYr.getResources().getColor(b.c.Red));
          }
          paramEditable = d.g(this.wYr);
          if (paramEditable != null)
          {
            locala = d.wYp;
            paramEditable.setText((CharSequence)String.valueOf(d.a.dmK() - i));
          }
          d.a(this.wYr, true);
          d.f(this.wYr).setEnabled(false);
        }
        else
        {
          paramEditable = d.g(this.wYr);
          if (paramEditable != null) {
            paramEditable.setText((CharSequence)"");
          }
          d.a(this.wYr, false);
          d.f(this.wYr).setEnabled(true);
        }
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(273770);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      d.h(this.wYr);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273770);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(288240);
      d.b(this.wYr).start();
      AppMethodBeat.o(288240);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    n(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    o(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    p(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "hasSetResult", "", "result", "", "kotlin.jvm.PlatformType", "secondResult", "<anonymous parameter 3>", "onResult"})
  static final class q<T>
    implements b.a<Object>
  {
    q(d paramd, com.tencent.mm.ui.widget.picker.b paramb, kotlin.o paramo) {}
    
    public final void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      AppMethodBeat.i(292185);
      this.wYv.hide();
      if (paramBoolean)
      {
        paramObject3 = this.wYr;
        Object localObject = (List)this.wYw.Mx;
        if (paramObject1 == null)
        {
          paramObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(292185);
          throw paramObject1;
        }
        d.a(paramObject3, kotlin.a.j.a((List)localObject, (CharSequence)paramObject1));
        paramObject3 = this.wYr;
        localObject = ((ArrayList)this.wYw.My).get(d.j(this.wYr));
        p.j(localObject, "timePair.second[selectedDateIndex]");
        localObject = (List)localObject;
        if (paramObject2 == null)
        {
          paramObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(292185);
          throw paramObject1;
        }
        d.b(paramObject3, kotlin.a.j.a((List)localObject, (CharSequence)paramObject2));
        paramObject3 = aj.AGc;
        paramObject3 = new Date(aj.eel());
        localObject = Calendar.getInstance();
        p.j(localObject, "date");
        ((Calendar)localObject).setTime(paramObject3);
        ((Calendar)localObject).set(5, ((Calendar)localObject).get(5) + d.j(this.wYr));
        ((Calendar)localObject).set(11, 24 - ((List)((ArrayList)this.wYw.My).get(d.j(this.wYr))).size() + d.k(this.wYr));
        ((Calendar)localObject).set(12, 0);
        ((Calendar)localObject).set(13, 0);
        Log.i("SimpleUIComponent", "chosen time:" + ((Calendar)localObject).getTime() + ",timeInMills:" + ((Calendar)localObject).getTimeInMillis());
        d.a(this.wYr, ((Calendar)localObject).getTimeInMillis() / 1000L);
        d.a(this.wYr, paramObject1 + ' ' + paramObject2);
        d.m(this.wYr).setText((CharSequence)d.l(this.wYr));
      }
      AppMethodBeat.o(292185);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.d
 * JD-Core Version:    0.7.0.1
 */