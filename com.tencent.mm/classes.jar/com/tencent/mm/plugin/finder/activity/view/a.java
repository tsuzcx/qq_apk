package com.tencent.mm.plugin.finder.activity.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.f;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "activityDesc", "", "activityEventId", "", "activityName", "activityParticipateCount", "", "avatarUrl", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "coverUrl", "descText", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getFinderTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setFinderTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1;", "fromObjectId", "headerAvatarView", "Landroid/widget/ImageView;", "headerDescTextView", "Landroid/widget/TextView;", "headerNameTextView", "headerParticipateTextView", "headerTitleTextView", "headerView", "Landroid/view/View;", "nickName", "participateBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "participateBtn", "Landroid/widget/LinearLayout;", "participateIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "participateText", "removeEvent", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1;", "destroy", "", "getAvailableDescWidth", "getHeaderView", "topicInfo", "handleAccountStatus", "", "initHeaderView", "initParam", "loadAvatar", "url", "participate", "refreshHeader", "setCoverStyle", "setHeaderView", "setNormalStyle", "setParticipateText", "count", "setSuffixedDesc", "maxLineNum", "textView", "setTextColor", "textColor", "setView", "showAccountBottomSheet", "showBottomSheet", "showParticipateBottomSheet", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a tsi;
  private String activityName;
  private String coverUrl;
  public final MMActivity gte;
  private View kgo;
  private String kog;
  private String nickName;
  public aqk tqo;
  private TextView trd;
  private TextView tre;
  private ImageView trf;
  private TextView trg;
  private TextView trh;
  private LinearLayout tri;
  private String trj;
  private String trk;
  private long trm;
  private long trn;
  private bds tro;
  private WeImageView tsc;
  private TextView tsd;
  private int tse;
  public e tsf;
  private final b tsg;
  private final d tsh;
  
  static
  {
    AppMethodBeat.i(242179);
    tsi = new a((byte)0);
    AppMethodBeat.o(242179);
  }
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(242178);
    this.gte = paramMMActivity;
    this.trj = "";
    this.nickName = "";
    this.activityName = "";
    this.trk = "";
    this.kog = "";
    this.coverUrl = "";
    paramMMActivity = com.tencent.mm.plugin.finder.activity.a.tqf;
    h.hkS();
    com.tencent.mm.plugin.finder.activity.a.ak(null);
    this.tsg = new b(this);
    this.tsh = new d(this);
    AppMethodBeat.o(242178);
  }
  
  private final void Ij(int paramInt)
  {
    AppMethodBeat.i(242171);
    Object localObject = this.tro;
    int i;
    if (localObject != null)
    {
      i = ((bds)localObject).LzC;
      if ((paramInt != 0) || (i <= 1)) {
        break label89;
      }
      localObject = this.gte.getString(2131759503, new Object[] { k.gm(2, i - 1) });
      p.g(localObject, "context.getString(R.stri…SCENE_WX, feedCount - 1))");
    }
    for (;;)
    {
      TextView localTextView = this.trh;
      if (localTextView == null) {
        break label120;
      }
      localTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(242171);
      return;
      i = 0;
      break;
      label89:
      localObject = this.gte.getString(2131759503, new Object[] { k.gm(2, paramInt) });
      p.g(localObject, "context.getString(R.stri…ewScene.SCENE_WX, count))");
    }
    label120:
    AppMethodBeat.o(242171);
  }
  
  private final void a(String paramString, TextView paramTextView)
  {
    AppMethodBeat.i(242173);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("SimpleUIComponent", "desc " + paramString + ", maxLineNum:2");
      AppMethodBeat.o(242173);
      return;
    }
    int i = cXw();
    Object localObject2 = paramTextView.getPaint();
    Object localObject1 = new StaticLayout((CharSequence)paramString, 0, paramString.length(), (TextPaint)localObject2, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
    if (((StaticLayout)localObject1).getLineCount() <= 2)
    {
      paramTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(242173);
      return;
    }
    int j = ((StaticLayout)localObject1).getLineEnd(1);
    int k = ((StaticLayout)localObject1).getLineEnd(0);
    localObject1 = paramTextView.getContext().getString(2131759496);
    p.g(localObject1, "textView.context.getStri…ctivity_desc_suffix_text)");
    float f1 = paramTextView.getPaint().measureText((String)localObject1);
    float f2 = i;
    localObject2 = new StaticLayout((CharSequence)paramString, k, j, (TextPaint)localObject2, (int)(f2 - f1), Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
    if (((StaticLayout)localObject2).getLineCount() > 0)
    {
      i = ((StaticLayout)localObject2).getLineEnd(0);
      localObject2 = new StringBuilder();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(242173);
        throw paramString;
      }
      paramString = paramString.substring(0, i);
      p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString + (String)localObject1;
      localObject2 = new SpannableString((CharSequence)paramString);
      ((SpannableString)localObject2).setSpan(new com.tencent.mm.plugin.finder.view.l((String)localObject1, this.gte.getResources().getColor(2131099787), this.gte.getResources().getColor(2131099660), false, false, (kotlin.g.a.b)new e(this)), i + 3, paramString.length(), 17);
      paramTextView.setText((CharSequence)localObject2);
    }
    AppMethodBeat.o(242173);
  }
  
  private final void asB(String paramString)
  {
    AppMethodBeat.i(242172);
    ImageView localImageView = this.trf;
    if (localImageView != null)
    {
      if (!Util.isNullOrNil(paramString))
      {
        Object localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject = com.tencent.mm.plugin.finder.loader.m.dka();
        paramString = new com.tencent.mm.plugin.finder.loader.a(paramString);
        com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((com.tencent.mm.loader.d)localObject).a(paramString, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      }
      AppMethodBeat.o(242172);
      return;
    }
    AppMethodBeat.o(242172);
  }
  
  private final void cXD()
  {
    AppMethodBeat.i(242168);
    Intent localIntent = this.gte.getIntent();
    this.nickName = localIntent.getStringExtra("key_nick_name");
    this.activityName = localIntent.getStringExtra("key_activity_name");
    this.trk = localIntent.getStringExtra("key_activity_desc");
    this.kog = localIntent.getStringExtra("key_avatar_url");
    this.coverUrl = localIntent.getStringExtra("key_cover_url");
    this.tse = localIntent.getIntExtra("key_activity_participate_count", 0);
    this.trm = localIntent.getLongExtra("key_activity_id", 0L);
    AppMethodBeat.o(242168);
  }
  
  private final void cXo()
  {
    AppMethodBeat.i(242176);
    setTextColor(this.gte.getResources().getColor(2131099746));
    Object localObject = this.tri;
    if (localObject != null) {
      ((LinearLayout)localObject).setBackgroundResource(2131232702);
    }
    int i = this.gte.getResources().getColor(2131101424);
    localObject = this.tsc;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.tsd;
    if (localObject != null)
    {
      ((TextView)localObject).setTextColor(i);
      AppMethodBeat.o(242176);
      return;
    }
    AppMethodBeat.o(242176);
  }
  
  private final void cXv()
  {
    AppMethodBeat.i(242170);
    Object localObject2 = this.trd;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (Context)this.gte;
      localObject1 = this.nickName;
      if (localObject1 == null) {
        break label176;
      }
    }
    label176:
    for (Object localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
      localObject1 = this.trg;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)this.activityName);
      }
      localObject2 = this.kog;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      asB((String)localObject1);
      localObject3 = this.tre;
      if (localObject3 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(((TextView)localObject3).getResources().getString(2131759512));
        localObject2 = this.trk;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        a((String)localObject1, (TextView)localObject3);
      }
      Ij(this.tse);
      if (Util.isNullOrNil(this.coverUrl)) {
        break;
      }
      cXx();
      AppMethodBeat.o(242170);
      return;
    }
    cXo();
    AppMethodBeat.o(242170);
  }
  
  private final int cXw()
  {
    AppMethodBeat.i(242174);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = this.gte.getWindowManager();
    p.g(localWindowManager, "context.windowManager");
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = com.tencent.mm.cb.a.aH((Context)this.gte, 2131165308);
    AppMethodBeat.o(242174);
    return i - j;
  }
  
  private final void cXx()
  {
    AppMethodBeat.i(242175);
    setTextColor(this.gte.getResources().getColor(2131099679));
    Object localObject = this.tri;
    if (localObject != null) {
      ((LinearLayout)localObject).setBackgroundResource(2131232464);
    }
    int i = this.gte.getResources().getColor(2131099672);
    localObject = this.tsc;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.tsd;
    if (localObject != null)
    {
      ((TextView)localObject).setTextColor(i);
      AppMethodBeat.o(242175);
      return;
    }
    AppMethodBeat.o(242175);
  }
  
  private final void dS(View paramView)
  {
    AppMethodBeat.i(242169);
    this.trd = ((TextView)paramView.findViewById(2131296480));
    this.tre = ((TextView)paramView.findViewById(2131296473));
    this.trf = ((ImageView)paramView.findViewById(2131296472));
    this.trg = ((TextView)paramView.findViewById(2131296475));
    this.trh = ((TextView)paramView.findViewById(2131296476));
    this.tri = ((LinearLayout)paramView.findViewById(2131296477));
    Object localObject = this.tri;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)c.tsk);
    }
    localObject = this.tre;
    if (localObject != null) {
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new o(((TextView)localObject).getContext()));
    }
    this.tsc = ((WeImageView)paramView.findViewById(2131296478));
    this.tsd = ((TextView)paramView.findViewById(2131296479));
    AppMethodBeat.o(242169);
  }
  
  private final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(242177);
    TextView localTextView = this.trg;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
    localTextView = this.trh;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
    localTextView = this.trd;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
    localTextView = this.tre;
    if (localTextView != null)
    {
      localTextView.setTextColor(paramInt);
      AppMethodBeat.o(242177);
      return;
    }
    AppMethodBeat.o(242177);
  }
  
  public final void a(bds parambds)
  {
    Object localObject1 = null;
    AppMethodBeat.i(242167);
    this.tro = parambds;
    if (parambds != null)
    {
      Object localObject2 = parambds.LNz;
      if (localObject2 != null)
      {
        this.activityName = ((aqk)localObject2).eventName;
        this.trk = ((aqk)localObject2).description;
        this.tse = parambds.LzC;
        this.trm = ((aqk)localObject2).twd;
        this.coverUrl = ((aqk)localObject2).coverImgUrl;
        this.trn = ((aqk)localObject2).LCz;
        parambds = ((aqk)localObject2).contact;
        if (parambds != null) {}
        for (parambds = parambds.nickname;; parambds = null)
        {
          this.nickName = parambds;
          localObject2 = ((aqk)localObject2).contact;
          parambds = localObject1;
          if (localObject2 != null) {
            parambds = ((FinderContact)localObject2).headUrl;
          }
          this.kog = parambds;
          Log.i("Finder.ActivityHeader", "avatarUrl: " + this.kog + " activityParticipateCount:" + this.tse + " coverUrl:" + this.coverUrl + " nickName:" + this.nickName);
          cXv();
          AppMethodBeat.o(242167);
          return;
        }
      }
    }
    AppMethodBeat.o(242167);
  }
  
  public final void dR(View paramView)
  {
    AppMethodBeat.i(242165);
    if (paramView != null)
    {
      dS(paramView);
      cXD();
      cXv();
      Object localObject = x.SXb;
      localObject = new cd(13);
      g.azz().b((com.tencent.mm.ak.q)localObject);
      this.tsg.alive();
      this.tsh.alive();
    }
    this.kgo = paramView;
    AppMethodBeat.o(242165);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(242166);
    this.tsg.dead();
    this.tsh.dead();
    com.tencent.mm.plugin.finder.activity.a.a locala = com.tencent.mm.plugin.finder.activity.a.tqf;
    h.hkS();
    com.tencent.mm.plugin.finder.activity.a.ak(null);
    AppMethodBeat.o(242166);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$Companion;", "", "()V", "CREATE_ACCOUNT_REQUEST_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<ih>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c tsk;
    
    static
    {
      AppMethodBeat.i(242156);
      tsk = new c();
      AppMethodBeat.o(242156);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242155);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242155);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<f>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1$callback$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(a.d paramd)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "detailSuffix", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(com.tencent.mm.plugin.finder.view.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242160);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tru.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242160);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showParticipateBottomSheet$1$3"})
  public static final class g
    implements o.g
  {
    public g(a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      com.tencent.mm.plugin.finder.activity.a.a locala = null;
      AppMethodBeat.i(242161);
      Intent localIntent = new Intent();
      p.g(paramMenuItem, "menuItem");
      Object localObject;
      if (paramMenuItem.getItemId() == 1001)
      {
        localIntent.putExtra("key_finder_post_router", 2);
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = new StringBuilder();
        p.g(g.aAf(), "MMKernel.account()");
        localIntent.putExtra("key_finder_post_id", com.tencent.mm.kernel.a.ayV() + '_' + Util.nowMilliSecond());
        localIntent.putExtra("key_finder_post_from", 9);
        localIntent.putExtra("saveActivity", true);
        localIntent.putExtra("key_activity_type", 102);
        paramMenuItem = a.a(this.tsj);
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
        paramMenuItem = a.a(this.tsj);
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
        paramMenuItem = a.a(this.tsj);
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
        paramMenuItem = a.a(this.tsj);
        if (paramMenuItem == null) {
          break label453;
        }
        paramMenuItem = Long.valueOf(paramMenuItem.twd);
        label287:
        localIntent.putExtra("key_topic_id", (Serializable)paramMenuItem);
        paramMenuItem = a.a(this.tsj);
        if (paramMenuItem == null) {
          break label458;
        }
      }
      label453:
      label458:
      for (paramMenuItem = paramMenuItem.eventName;; paramMenuItem = null)
      {
        localIntent.putExtra("key_activity_name", paramMenuItem);
        localObject = a.a(this.tsj);
        paramMenuItem = locala;
        if (localObject != null) {
          paramMenuItem = ((aqk)localObject).description;
        }
        localIntent.putExtra("key_activity_desc", paramMenuItem);
        paramMenuItem = com.tencent.mm.plugin.finder.activity.a.tqf;
        p.h(localIntent, "intent");
        h.hkS();
        if (com.tencent.mm.plugin.finder.activity.a.cXn() == null) {
          com.tencent.mm.plugin.finder.activity.a.ak(new Intent());
        }
        paramMenuItem = com.tencent.mm.plugin.finder.activity.a.cXn();
        if (paramMenuItem != null)
        {
          locala = com.tencent.mm.plugin.finder.activity.a.tqf;
          com.tencent.mm.plugin.finder.activity.a.a.a(localIntent, paramMenuItem);
        }
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.tsj.gte, localIntent);
        AppMethodBeat.o(242161);
        return;
        if (paramMenuItem.getItemId() != 1002) {
          break;
        }
        localIntent.putExtra("key_finder_post_router", 3);
        break;
        paramMenuItem = null;
        break label287;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showParticipateBottomSheet$1$4"})
  public static final class h
    implements e.b
  {
    public h(a parama) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(242162);
      a.b(this.tsj);
      AppMethodBeat.o(242162);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class i
    implements o.f
  {
    public static final i tsm;
    
    static
    {
      AppMethodBeat.i(242164);
      tsm = new i();
      AppMethodBeat.o(242164);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(242163);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(1001, 2131755822);
        paramm.kV(1002, 2131755831);
      }
      AppMethodBeat.o(242163);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.view.a
 * JD-Core Version:    0.7.0.1
 */