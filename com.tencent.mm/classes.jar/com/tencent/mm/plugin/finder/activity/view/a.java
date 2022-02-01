package com.tencent.mm.plugin.finder.activity.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.f;
import com.tencent.mm.f.a.iw;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "activityDesc", "", "activityEventId", "", "activityName", "activityParticipateCount", "", "adContainer", "Landroid/widget/LinearLayout;", "adTextView", "Landroid/widget/TextView;", "avatarUrl", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "coverUrl", "descText", "endTimeTextView", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getFinderTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setFinderTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1;", "fromObjectId", "headerAvatarView", "Landroid/widget/ImageView;", "headerDescTextView", "headerNameTextView", "headerParticipateTextView", "headerTitleTextView", "headerView", "Landroid/view/View;", "isReceivedTopic", "", "nickName", "participateBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "participateBtn", "participateIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "participateText", "preCheckHelper", "Lcom/tencent/mm/plugin/finder/live/ui/post/PostPreCheckUIC;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "removeEvent", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1;", "changeParticipateButton", "", "changeParticipateView", "isFinished", "destroy", "getAvailableDescWidth", "getHeaderView", "topicInfo", "getIconWidth", "handleAccountStatus", "initHeaderView", "initParam", "loadAvatar", "url", "onResume", "isFirstResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "participate", "refreshHeader", "reportMiniProgram", "setCoverStyle", "setDetailTextMaxHeight", "setHeaderView", "setNormalStyle", "setParticipateText", "count", "setSuffixedDesc", "maxLineNum", "textView", "isCovered", "setTextColor", "textColor", "setView", "showAccountBottomSheet", "showBottomSheet", "showMiniProgram", "showParticipateBottomSheet", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.an.i
{
  public static final a wZD;
  String activityName;
  public String coverUrl;
  public final MMActivity iXq;
  private View mXN;
  String nfY;
  String nickName;
  asg wWV;
  private boolean wXb;
  String wYd;
  public com.tencent.mm.plugin.finder.live.ui.post.d wZA;
  private final b wZB;
  private final f wZC;
  private TextView wZi;
  private TextView wZj;
  private TextView wZk;
  private ImageView wZl;
  LinearLayout wZm;
  TextView wZn;
  private TextView wZo;
  private TextView wZp;
  public LinearLayout wZq;
  public WeImageView wZr;
  public TextView wZs;
  private String wZt;
  int wZu;
  long wZv;
  long wZw;
  bkr wZx;
  private com.tencent.mm.ui.widget.a.e wZy;
  public ble wZz;
  
  static
  {
    AppMethodBeat.i(232918);
    wZD = new a((byte)0);
    AppMethodBeat.o(232918);
  }
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(232916);
    this.iXq = paramMMActivity;
    this.wZt = "";
    this.nickName = "";
    this.activityName = "";
    this.wYd = "";
    this.nfY = "";
    this.coverUrl = "";
    paramMMActivity = com.tencent.mm.plugin.finder.activity.a.wWJ;
    com.tencent.d.f.h.ioq();
    com.tencent.mm.plugin.finder.activity.a.ah(null);
    paramMMActivity = this.iXq;
    if (paramMMActivity == null)
    {
      paramMMActivity = new kotlin.t("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
      AppMethodBeat.o(232916);
      throw paramMMActivity;
    }
    this.wZA = new com.tencent.mm.plugin.finder.live.ui.post.d((AppCompatActivity)paramMMActivity);
    this.wZB = new b(this);
    this.wZC = new f(this);
    AppMethodBeat.o(232916);
  }
  
  private final void a(String paramString, TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(232907);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("SimpleUIComponent", "desc " + paramString + ", maxLineNum:2");
      AppMethodBeat.o(232907);
      return;
    }
    int j = dnc();
    Object localObject2 = paramTextView.getPaint();
    if (paramBoolean) {}
    for (int i = this.iXq.getResources().getColor(b.c.BW_100_Alpha_0_8);; i = this.iXq.getResources().getColor(b.c.FG_0))
    {
      localObject1 = new StaticLayout((CharSequence)paramString, 0, paramString.length(), (TextPaint)localObject2, j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
      if (((StaticLayout)localObject1).getLineCount() > 2) {
        break;
      }
      paramTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(232907);
      return;
    }
    int k = ((StaticLayout)localObject1).getLineEnd(1);
    int m = ((StaticLayout)localObject1).getLineEnd(0);
    int n = (int)this.iXq.getResources().getDimension(b.d.Edge_1_5_A);
    Object localObject1 = au.o((Context)this.iXq, b.i.icons_outlined_arrow, i);
    ((Drawable)localObject1).setBounds(0, 0, n, (int)this.iXq.getResources().getDimension(b.d.Edge_2A));
    localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1, 1);
    String str = paramTextView.getContext().getString(b.j.finder_desc_suffix_text);
    p.j(str, "textView.context.getStri….finder_desc_suffix_text)");
    float f1 = paramTextView.getPaint().measureText(str);
    float f2 = j;
    float f3 = n;
    localObject2 = new StaticLayout((CharSequence)paramString, m, k, (TextPaint)localObject2, (int)(f2 - f1 - f3), Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
    if (((StaticLayout)localObject2).getLineCount() > 0)
    {
      j = ((StaticLayout)localObject2).getLineEnd(0);
      if (paramString.charAt(j - 1) != '\n') {
        break label504;
      }
      localObject2 = new StringBuilder();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(232907);
        throw paramString;
      }
      paramString = paramString.substring(0, j - 1);
      p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (paramString = paramString + str + ' ';; paramString = paramString + str + ' ')
    {
      localObject2 = new SpannableString((CharSequence)paramString);
      ((SpannableString)localObject2).setSpan(localObject1, paramString.length() - 1, paramString.length(), 17);
      ((SpannableString)localObject2).setSpan(new com.tencent.mm.plugin.finder.view.o(str, i, this.iXq.getResources().getColor(b.c.transparent), false, false, (kotlin.g.a.b)new g(this)), 0, paramString.length(), 17);
      paramTextView.setText((CharSequence)localObject2);
      AppMethodBeat.o(232907);
      return;
      label504:
      localObject2 = new StringBuilder();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(232907);
        throw paramString;
      }
      paramString = paramString.substring(0, j);
      p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  private final void aAH(String paramString)
  {
    AppMethodBeat.i(232905);
    ImageView localImageView = this.wZl;
    if (localImageView != null)
    {
      if (!Util.isNullOrNil(paramString))
      {
        Object localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject = com.tencent.mm.plugin.finder.loader.t.dJh();
        paramString = new com.tencent.mm.plugin.finder.loader.e(paramString);
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject).a(paramString, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      }
      AppMethodBeat.o(232905);
      return;
    }
    AppMethodBeat.o(232905);
  }
  
  private final void dmW()
  {
    AppMethodBeat.i(232890);
    Intent localIntent = this.iXq.getIntent();
    this.nickName = localIntent.getStringExtra("key_nick_name");
    this.activityName = localIntent.getStringExtra("key_activity_name");
    this.wYd = localIntent.getStringExtra("key_activity_desc");
    this.nfY = localIntent.getStringExtra("key_avatar_url");
    this.coverUrl = localIntent.getStringExtra("key_cover_url");
    this.wZu = localIntent.getIntExtra("key_activity_participate_count", 0);
    this.wZv = localIntent.getLongExtra("key_activity_id", 0L);
    AppMethodBeat.o(232890);
  }
  
  private void dmY()
  {
    AppMethodBeat.i(232897);
    Object localObject = this.wZx;
    if (localObject != null)
    {
      localObject = ((bkr)localObject).SVJ;
      if (localObject != null)
      {
        com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.aq(((asg)localObject).SFK, ((asg)localObject).endTime))
        {
          localObject = this.wZr;
          if (localObject != null) {
            ((WeImageView)localObject).setVisibility(8);
          }
          localObject = this.wZs;
          if (localObject != null)
          {
            ((TextView)localObject).setText((CharSequence)this.iXq.getResources().getString(b.j.finder_activity_finished));
            AppMethodBeat.o(232897);
            return;
          }
          AppMethodBeat.o(232897);
          return;
        }
        localObject = this.wZr;
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = this.wZs;
        if (localObject != null)
        {
          ((TextView)localObject).setText((CharSequence)this.iXq.getResources().getString(b.j.finder_activity_participate_text));
          AppMethodBeat.o(232897);
          return;
        }
        AppMethodBeat.o(232897);
        return;
      }
    }
    AppMethodBeat.o(232897);
  }
  
  private final void dmZ()
  {
    AppMethodBeat.i(232901);
    if (this.wZy == null)
    {
      localObject1 = new com.tencent.mm.ui.widget.a.e((Context)this.iXq, 1, true);
      View localView = ad.kS((Context)this.iXq).inflate(b.g.finder_sheet_header, null);
      Object localObject3 = (TextView)localView.findViewById(b.f.nickname);
      ImageView localImageView = (ImageView)localView.findViewById(b.f.avatar);
      Object localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject2 = d.a.aAK(z.bdh());
      if (localObject2 != null)
      {
        p.j(localObject3, "nicknameTv");
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this.iXq, (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject2).getNickname()));
        localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject3 = com.tencent.mm.plugin.finder.loader.t.dJh();
        localObject2 = new com.tencent.mm.plugin.finder.loader.e(((com.tencent.mm.plugin.finder.api.i)localObject2).field_avatarUrl);
        p.j(localImageView, "avatarIv");
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject3).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      }
      ((com.tencent.mm.ui.widget.a.e)localObject1).Z(localView, true);
      ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.f)n.wZI);
      ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.g)new l(this));
      ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new m(this));
      this.wZy = ((com.tencent.mm.ui.widget.a.e)localObject1);
    }
    Object localObject1 = this.wZA;
    if ((localObject1 != null) && (!((com.tencent.mm.plugin.finder.live.ui.post.d)localObject1).a((kotlin.g.a.a)new o(this), (kotlin.g.a.a)new p(this))))
    {
      AppMethodBeat.o(232901);
      return;
    }
    localObject1 = this.wZy;
    if (localObject1 != null)
    {
      if (!((com.tencent.mm.ui.widget.a.e)localObject1).isShowing()) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).eik();
      }
      AppMethodBeat.o(232901);
      return;
    }
    AppMethodBeat.o(232901);
  }
  
  private final void dnb()
  {
    AppMethodBeat.i(232904);
    Object localObject = this.wZx;
    if (localObject != null) {}
    for (int i = ((bkr)localObject).feedCount;; i = 0)
    {
      localObject = this.iXq.getString(b.j.finder_activity_item_desc, new Object[] { m.gY(2, i) });
      p.j(localObject, "context.getString(R.stri…ene.SCENE_WX, feedCount))");
      TextView localTextView = this.wZp;
      if (localTextView == null) {
        break;
      }
      localTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(232904);
      return;
    }
    AppMethodBeat.o(232904);
  }
  
  private final int dnc()
  {
    AppMethodBeat.i(232909);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = this.iXq.getWindowManager();
    p.j(localWindowManager, "context.windowManager");
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = com.tencent.mm.ci.a.aZ((Context)this.iXq, b.d.Edge_6A);
    AppMethodBeat.o(232909);
    return i - j;
  }
  
  private final void eq(View paramView)
  {
    AppMethodBeat.i(232893);
    this.wZi = ((TextView)paramView.findViewById(b.f.activity_profile_header_title));
    this.wZj = ((TextView)paramView.findViewById(b.f.activity_profile_header_desc));
    this.wZk = ((TextView)paramView.findViewById(b.f.activity_profile_end_time_text));
    this.wZl = ((ImageView)paramView.findViewById(b.f.activity_profile_header_avatar));
    Object localObject = (TextView)paramView.findViewById(b.f.activity_profile_header_name);
    if (localObject != null) {
      ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    }
    for (;;)
    {
      this.wZo = ((TextView)localObject);
      this.wZp = ((TextView)paramView.findViewById(b.f.activity_profile_header_participate));
      this.wZq = ((LinearLayout)paramView.findViewById(b.f.activity_profile_header_participate_btn));
      localObject = this.wZq;
      if (localObject != null) {
        ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      localObject = this.wZj;
      if (localObject != null) {
        ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o(((TextView)localObject).getContext()));
      }
      this.wZr = ((WeImageView)paramView.findViewById(b.f.activity_profile_header_participate_icon));
      this.wZs = ((TextView)paramView.findViewById(b.f.activity_profile_header_participate_text));
      this.wZm = ((LinearLayout)this.iXq.findViewById(b.f.activity_profile_ad_container));
      this.wZn = ((TextView)this.iXq.findViewById(b.f.activity_profile_ad_text));
      paramView = this.wZm;
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)new d(this));
      }
      paramView = this.wZl;
      if (paramView == null) {
        break;
      }
      paramView.setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(232893);
      return;
      localObject = null;
    }
    AppMethodBeat.o(232893);
  }
  
  private final void of(boolean paramBoolean)
  {
    AppMethodBeat.i(232911);
    setTextColor(this.iXq.getResources().getColor(b.c.FG_0));
    Object localObject = this.wZp;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.iXq.getResources().getColor(b.c.FG_1));
    }
    if (paramBoolean)
    {
      localObject = this.wZq;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundResource(b.e.finder_activity_normal_finished_btn_bg);
      }
      localObject = this.wZs;
      if (localObject != null)
      {
        ((TextView)localObject).setTextColor(this.iXq.getResources().getColor(b.c.FG_2));
        AppMethodBeat.o(232911);
        return;
      }
      AppMethodBeat.o(232911);
      return;
    }
    localObject = this.wZq;
    if (localObject != null) {
      ((LinearLayout)localObject).setBackgroundResource(b.e.finder_profile_follow_btn_bg);
    }
    int i = this.iXq.getResources().getColor(b.c.White);
    localObject = this.wZr;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.wZs;
    if (localObject != null)
    {
      ((TextView)localObject).setTextColor(i);
      AppMethodBeat.o(232911);
      return;
    }
    AppMethodBeat.o(232911);
  }
  
  private final void og(boolean paramBoolean)
  {
    AppMethodBeat.i(232910);
    setTextColor(this.iXq.getResources().getColor(b.c.BW_100_Alpha_0_8));
    Object localObject = this.wZp;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.iXq.getResources().getColor(b.c.BW_100_Alpha_0_5));
    }
    if (paramBoolean)
    {
      localObject = this.wZq;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundResource(b.e.finder_activity_covered_finished_btn_bg);
      }
      localObject = this.wZs;
      if (localObject != null)
      {
        ((TextView)localObject).setTextColor(this.iXq.getResources().getColor(b.c.BW_100_Alpha_0_3));
        AppMethodBeat.o(232910);
        return;
      }
      AppMethodBeat.o(232910);
      return;
    }
    localObject = this.wZq;
    if (localObject != null) {
      ((LinearLayout)localObject).setBackgroundResource(b.e.finder_activity_covered_btn_bg);
    }
    int i = this.iXq.getResources().getColor(b.c.White);
    localObject = this.wZr;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.wZs;
    if (localObject != null)
    {
      ((TextView)localObject).setTextColor(i);
      AppMethodBeat.o(232910);
      return;
    }
    AppMethodBeat.o(232910);
  }
  
  private final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(232913);
    TextView localTextView = this.wZo;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
    localTextView = this.wZi;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
    localTextView = this.wZj;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
    localTextView = this.wZk;
    if (localTextView != null)
    {
      localTextView.setTextColor(paramInt);
      AppMethodBeat.o(232913);
      return;
    }
    AppMethodBeat.o(232913);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(232887);
    this.wZB.dead();
    this.wZC.dead();
    com.tencent.mm.plugin.finder.activity.a.a locala = com.tencent.mm.plugin.finder.activity.a.wWJ;
    com.tencent.d.f.h.ioq();
    com.tencent.mm.plugin.finder.activity.a.ah(null);
    com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(232887);
  }
  
  public final void dmV()
  {
    bid localbid = null;
    AppMethodBeat.i(232885);
    Object localObject1 = this.wWV;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((asg)localObject1).PND;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
        if (localObject1 != null) {
          break label89;
        }
        localObject1 = "";
      }
    }
    label89:
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject2 = aj.a.fZ((Context)this.iXq);
      if (localObject2 != null) {
        localbid = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();
      }
      com.tencent.mm.plugin.finder.report.n.a((String)localObject1, 1, localbid, com.tencent.mm.ae.d.Fw(this.wZv));
      AppMethodBeat.o(232885);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void dmX()
  {
    Object localObject2 = null;
    AppMethodBeat.i(232895);
    Object localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
    localObject1 = this.wWV;
    long l;
    if (localObject1 != null)
    {
      l = ((asg)localObject1).xdR;
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = aj.a.fZ((Context)this.iXq);
      if (localObject1 == null) {
        break label185;
      }
    }
    label185:
    for (localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();; localObject1 = null)
    {
      com.tencent.mm.plugin.finder.report.n.a(2L, l, (bid)localObject1);
      localObject1 = new StringBuilder();
      p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
      String str = com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond();
      localObject1 = com.tencent.mm.plugin.finder.activity.b.wWK;
      asg localasg = this.wWV;
      localObject1 = localObject2;
      if (localasg != null) {
        localObject1 = Long.valueOf(localasg.xdR);
      }
      if (com.tencent.mm.plugin.finder.activity.b.b((Long)localObject1, 9))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.fE((Context)this.iXq);
      }
      localObject1 = k.zWs;
      k.av(9, false);
      localObject1 = k.zWs;
      k.aEb(str);
      dmZ();
      AppMethodBeat.o(232895);
      return;
      l = 0L;
      break;
    }
  }
  
  final void dna()
  {
    long l2 = 0L;
    int j = 0;
    AppMethodBeat.i(232903);
    Object localObject2 = this.wZo;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (Context)this.iXq;
      localObject1 = this.nickName;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
      }
    }
    else
    {
      localObject1 = this.wZi;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)this.activityName);
      }
      if (Util.isNullOrNil(this.coverUrl)) {
        break label273;
      }
    }
    int i;
    label273:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = this.wZi;
      if (localObject1 != null) {
        ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      }
      localObject2 = this.nfY;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      aAH((String)localObject1);
      localObject3 = this.wZj;
      if (localObject3 == null) {
        break label308;
      }
      Resources localResources = ((TextView)localObject3).getResources();
      i = b.j.finder_activity_post_desc_prefix;
      localObject2 = this.wYd;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = localResources.getString(i, new Object[] { localObject1 });
      p.j(localObject2, "resources.getString(R.st…efix, activityDesc ?: \"\")");
      localObject1 = localObject2;
      if (!kotlin.n.n.pu((String)localObject2, "\n")) {
        break label298;
      }
      i = ((String)localObject2).length();
      if (localObject2 != null) {
        break label279;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(232903);
      throw ((Throwable)localObject1);
      localObject1 = (CharSequence)"";
      break;
    }
    label279:
    Object localObject1 = ((String)localObject2).substring(0, i - 1);
    p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    label298:
    a((String)localObject1, (TextView)localObject3, bool1);
    label308:
    localObject1 = this.wZs;
    if (localObject1 != null) {
      ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    }
    dmY();
    localObject1 = this.wZx;
    long l1;
    if (localObject1 != null)
    {
      localObject1 = ((bkr)localObject1).SVJ;
      if (localObject1 != null)
      {
        l1 = ((asg)localObject1).endTime;
        if (l1 != 0L) {
          break label533;
        }
        Log.i("Finder.ActivityHeader", "no endTime");
        localObject1 = this.wZk;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    boolean bool2;
    for (;;)
    {
      dnb();
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject1 = this.wZx;
      i = j;
      if (localObject1 != null)
      {
        localObject1 = ((bkr)localObject1).SVJ;
        i = j;
        if (localObject1 != null) {
          i = ((asg)localObject1).SFK;
        }
      }
      localObject1 = this.wZx;
      l1 = l2;
      if (localObject1 != null)
      {
        localObject1 = ((bkr)localObject1).SVJ;
        l1 = l2;
        if (localObject1 != null) {
          l1 = ((asg)localObject1).endTime;
        }
      }
      bool2 = com.tencent.mm.plugin.finder.utils.aj.aq(i, l1);
      if (!bool1) {
        break label592;
      }
      og(bool2);
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.finder.activity.uic.g)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.activity.uic.g.class)).dmT();
      AppMethodBeat.o(232903);
      return;
      l1 = 0L;
      break;
      label533:
      localObject1 = this.wZk;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.wZk;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.finder.utils.aj.b(l1 * 1000L, (Context)this.iXq));
      }
    }
    label592:
    of(bool2);
    localObject1 = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.finder.activity.uic.g)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.activity.uic.g.class)).dmy();
    AppMethodBeat.o(232903);
  }
  
  public final void ep(View paramView)
  {
    AppMethodBeat.i(232880);
    if (paramView != null)
    {
      eq(paramView);
      dmW();
      dna();
      x localx = x.aazN;
      this.wZB.alive();
      this.wZC.alive();
    }
    this.mXN = paramView;
    com.tencent.mm.kernel.h.aGY().a(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(232880);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(232881);
    com.tencent.mm.plugin.finder.live.ui.post.d locald = this.wZA;
    if (locald != null) {
      locald.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof ch))) {
      this.wZz = ((ch)paramq).dnR();
    }
    AppMethodBeat.o(232881);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$Companion;", "", "()V", "CREATE_ACCOUNT_REQUEST_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<iw>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(238822);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (a.a(this.wZE))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238822);
        return;
      }
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      paramView = this.wZE.wZx;
      int i;
      if (paramView != null)
      {
        paramView = paramView.SVJ;
        if (paramView != null)
        {
          i = paramView.SFK;
          paramView = this.wZE.wZx;
          if (paramView == null) {
            break label178;
          }
          paramView = paramView.SVJ;
          if (paramView == null) {
            break label178;
          }
        }
      }
      label178:
      for (long l = paramView.endTime;; l = 0L)
      {
        boolean bool = com.tencent.mm.plugin.finder.utils.aj.aq(i, l);
        Log.i("Finder.ActivityHeader", "participateBtn onClick isFinished : ".concat(String.valueOf(bool)));
        if (!bool) {
          this.wZE.dmX();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238822);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287276);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      Object localObject2 = a.b(this.wZE);
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = new StringBuilder();
        paramView = ((asg)localObject2).contact;
        if (paramView != null)
        {
          localObject1 = paramView.username;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        localObject3 = paramView + ':' + Util.getUuidRandom();
        paramView = com.tencent.mm.plugin.finder.report.n.zWF;
        paramView = ((asg)localObject2).PND;
        if (paramView != null) {
          break label238;
        }
        paramView = "";
      }
      label238:
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject1 = aj.a.fZ((Context)this.wZE.iXq);
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();; localObject1 = null)
        {
          com.tencent.mm.plugin.finder.report.n.a(paramView, 2, (bid)localObject1, com.tencent.mm.ae.d.Fw(a.c(this.wZE)));
          paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
          Context localContext = (Context)this.wZE.iXq;
          localObject1 = ((asg)localObject2).PND;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          localObject2 = ((asg)localObject2).SFI;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          com.tencent.mm.plugin.finder.utils.a.a(localContext, paramView, (String)localObject1, 1191, (String)localObject3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(287276);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(284166);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = new Intent();
      paramView = a.b(this.wZE);
      if (paramView != null)
      {
        paramView = paramView.contact;
        if (paramView == null) {}
      }
      for (paramView = paramView.username;; paramView = null)
      {
        ((Intent)localObject).putExtra("finder_username", paramView);
        paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a((Context)this.wZE.iXq, (Intent)localObject, 0L, 1, false, 64);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.wZE.iXq, (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284166);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends IListener<f>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1$callback$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(a.f paramf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "detailSuffix", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$1$1"})
  static final class h
    implements View.OnClickListener
  {
    h(a parama, com.tencent.mm.plugin.finder.view.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289287);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.wZG.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289287);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$1$2"})
  static final class i
    implements View.OnClickListener
  {
    i(a parama, com.tencent.mm.plugin.finder.view.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251836);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (AndroidContextUtil.castActivityOrNull((Context)this.wZE.iXq) != null)
      {
        paramView = new Intent();
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a((Context)this.wZE.iXq, paramView, 0L, 0, false);
        paramView.putExtra("key_create_scene", 11);
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.b((Activity)this.wZE.iXq, paramView, 20000);
      }
      this.wZG.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251836);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showBottomSheet$1$4$1", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$$special$$inlined$let$lambda$1"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    j(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(com.tencent.mm.plugin.finder.view.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269592);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.wZH.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269592);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showParticipateBottomSheet$1$3"})
  static final class l
    implements q.g
  {
    l(a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      com.tencent.mm.plugin.finder.activity.a.a locala = null;
      AppMethodBeat.i(280170);
      Intent localIntent = new Intent();
      p.j(paramMenuItem, "menuItem");
      Object localObject;
      if (paramMenuItem.getItemId() == 1001)
      {
        localIntent.putExtra("key_finder_post_router", 2);
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = new StringBuilder();
        p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
        localIntent.putExtra("key_finder_post_id", com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond());
        localIntent.putExtra("key_finder_post_from", 9);
        localIntent.putExtra("saveActivity", true);
        localIntent.putExtra("key_activity_type", 102);
        paramMenuItem = a.b(this.wZE);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.contact;
          if (paramMenuItem != null)
          {
            localObject = paramMenuItem.username;
            paramMenuItem = (MenuItem)localObject;
            if (localObject != null) {
              break label164;
            }
          }
        }
        paramMenuItem = "";
        label164:
        localIntent.putExtra("key_user_name", paramMenuItem);
        paramMenuItem = a.b(this.wZE);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.contact;
          if (paramMenuItem != null)
          {
            localObject = paramMenuItem.nickname;
            paramMenuItem = (MenuItem)localObject;
            if (localObject != null) {
              break label211;
            }
          }
        }
        paramMenuItem = "";
        label211:
        localIntent.putExtra("key_nick_name", paramMenuItem);
        paramMenuItem = a.b(this.wZE);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.contact;
          if (paramMenuItem != null)
          {
            localObject = paramMenuItem.headUrl;
            paramMenuItem = (MenuItem)localObject;
            if (localObject != null) {
              break label258;
            }
          }
        }
        paramMenuItem = "";
        label258:
        localIntent.putExtra("key_avatar_url", paramMenuItem);
        localObject = a.d(this.wZE);
        paramMenuItem = (MenuItem)localObject;
        if (localObject == null) {
          paramMenuItem = "";
        }
        localIntent.putExtra("key_cover_url", paramMenuItem);
        paramMenuItem = a.b(this.wZE);
        if (paramMenuItem == null) {
          break label482;
        }
        paramMenuItem = Long.valueOf(paramMenuItem.xdR);
        label316:
        localIntent.putExtra("key_topic_id", (Serializable)paramMenuItem);
        paramMenuItem = a.b(this.wZE);
        if (paramMenuItem == null) {
          break label487;
        }
      }
      label482:
      label487:
      for (paramMenuItem = paramMenuItem.eventName;; paramMenuItem = null)
      {
        localIntent.putExtra("key_activity_name", paramMenuItem);
        localObject = a.b(this.wZE);
        paramMenuItem = locala;
        if (localObject != null) {
          paramMenuItem = ((asg)localObject).description;
        }
        localIntent.putExtra("key_activity_desc", paramMenuItem);
        paramMenuItem = com.tencent.mm.plugin.finder.activity.a.wWJ;
        p.k(localIntent, "intent");
        com.tencent.d.f.h.ioq();
        if (com.tencent.mm.plugin.finder.activity.a.dmx() == null) {
          com.tencent.mm.plugin.finder.activity.a.ah(new Intent());
        }
        paramMenuItem = com.tencent.mm.plugin.finder.activity.a.dmx();
        if (paramMenuItem != null)
        {
          locala = com.tencent.mm.plugin.finder.activity.a.wWJ;
          com.tencent.mm.plugin.finder.activity.a.a.a(localIntent, paramMenuItem);
        }
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.wZE.iXq, localIntent);
        AppMethodBeat.o(280170);
        return;
        if (paramMenuItem.getItemId() != 1002) {
          break;
        }
        localIntent.putExtra("key_finder_post_router", 3);
        break;
        paramMenuItem = null;
        break label316;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showParticipateBottomSheet$1$4"})
  static final class m
    implements e.b
  {
    m(a parama) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(285751);
      a.e(this.wZE);
      AppMethodBeat.o(285751);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class n
    implements q.f
  {
    public static final n wZI;
    
    static
    {
      AppMethodBeat.i(288179);
      wZI = new n();
      AppMethodBeat.o(288179);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(288178);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(1001, b.j.app_field_mmsight);
        paramo.mn(1002, b.j.app_field_select_new_pic);
      }
      AppMethodBeat.o(288178);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    o(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    p(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.view.a
 * JD-Core Version:    0.7.0.1
 */