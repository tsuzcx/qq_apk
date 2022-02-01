package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "activityDesc", "", "activityEventId", "", "activityName", "avatarUrl", "coverUrl", "descText", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getFinderTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setFinderTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$finderTopicInfoListener$1;", "fromObjectId", "headerAvatarView", "Landroid/widget/ImageView;", "headerCoverView", "headerDefaultCoverView", "headerDescTextView", "Landroid/widget/TextView;", "headerNameTextView", "headerParticipateTextView", "headerTitleTextView", "headerView", "Landroid/view/View;", "nickName", "participateBtn", "Landroid/widget/LinearLayout;", "participateCount", "", "getAvailableDescWidth", "initParam", "", "initView", "loadAvatar", "url", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refreshHeader", "topicInfo", "setCover", "setCoverStyle", "setNormalStyle", "setParticipateText", "count", "setSuffixedDesc", "maxLineNum", "textView", "setView", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderActivityHeaderUIC
  extends UIComponent
{
  public static final a trq;
  String activityName;
  String coverUrl;
  private View kgo;
  String kog;
  String nickName;
  private ImageView tqi;
  private ImageView tqk;
  private aqk tqo;
  private TextView trd;
  private TextView tre;
  private ImageView trf;
  private TextView trg;
  private TextView trh;
  private LinearLayout tri;
  private String trj;
  String trk;
  int trl;
  long trm;
  long trn;
  bds tro;
  private final b trp;
  
  static
  {
    AppMethodBeat.i(242085);
    trq = new a((byte)0);
    AppMethodBeat.o(242085);
  }
  
  public FinderActivityHeaderUIC(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(242084);
    this.trj = "";
    this.nickName = "";
    this.activityName = "";
    this.trk = "";
    this.kog = "";
    this.coverUrl = "";
    this.trp = new b(this);
    AppMethodBeat.o(242084);
  }
  
  private final void Ij(int paramInt)
  {
    AppMethodBeat.i(242079);
    String str = getActivity().getString(2131759503, new Object[] { k.gm(2, paramInt) });
    p.g(str, "activity.getString(R.str…ewScene.SCENE_WX, count))");
    TextView localTextView = this.trh;
    if (localTextView == null) {
      p.btv("headerParticipateTextView");
    }
    localTextView.setText((CharSequence)str);
    AppMethodBeat.o(242079);
  }
  
  private final void a(String paramString, TextView paramTextView)
  {
    AppMethodBeat.i(242081);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("SimpleUIComponent", "desc " + paramString + ", maxLineNum:2");
      AppMethodBeat.o(242081);
      return;
    }
    int i = cXw();
    Object localObject2 = paramTextView.getPaint();
    Object localObject1 = new StaticLayout((CharSequence)paramString, 0, paramString.length(), (TextPaint)localObject2, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
    if (((StaticLayout)localObject1).getLineCount() <= 2)
    {
      paramTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(242081);
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
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(242081);
        throw paramString;
      }
      paramString = paramString.substring(0, i);
      p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString + (String)localObject1;
      localObject2 = new SpannableString((CharSequence)paramString);
      ((SpannableString)localObject2).setSpan(new com.tencent.mm.plugin.finder.view.l((String)localObject1, getResources().getColor(2131099787), getResources().getColor(2131099660), false, false, (kotlin.g.a.b)new e(this)), i + 3, paramString.length(), 17);
      paramTextView.setText((CharSequence)localObject2);
    }
    AppMethodBeat.o(242081);
  }
  
  private final void asB(String paramString)
  {
    AppMethodBeat.i(242080);
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = m.uJa;
      localObject = m.dka();
      paramString = new com.tencent.mm.plugin.finder.loader.a(paramString);
      ImageView localImageView = this.trf;
      if (localImageView == null) {
        p.btv("headerAvatarView");
      }
      m localm = m.uJa;
      ((com.tencent.mm.loader.d)localObject).a(paramString, localImageView, m.a(m.a.uJe));
    }
    AppMethodBeat.o(242080);
  }
  
  private final int cXw()
  {
    AppMethodBeat.i(242082);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = getActivity().getWindowManager();
    p.g(localWindowManager, "activity.windowManager");
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = com.tencent.mm.cb.a.aH((Context)getActivity(), 2131165308);
    AppMethodBeat.o(242082);
    return i - j;
  }
  
  private final void cXx()
  {
    AppMethodBeat.i(242083);
    ImageView localImageView = this.tqk;
    if (localImageView == null) {
      p.btv("headerDefaultCoverView");
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(242083);
  }
  
  private final void setCover(final String paramString)
  {
    AppMethodBeat.i(242078);
    Object localObject = new g(paramString);
    m localm = m.uJa;
    localObject = m.djY().bQ(localObject);
    localm = m.uJa;
    paramString = ((com.tencent.mm.loader.a.b)localObject).a(m.a(m.a.uJl)).a((e)new d(this, paramString));
    localObject = this.tqi;
    if (localObject == null) {
      p.btv("headerCoverView");
    }
    paramString.c((ImageView)localObject);
    cXx();
    AppMethodBeat.o(242078);
  }
  
  final void cXv()
  {
    AppMethodBeat.i(242077);
    Object localObject2 = this.trd;
    if (localObject2 == null) {
      p.btv("headerTitleTextView");
    }
    Context localContext = (Context)getActivity();
    Object localObject1 = this.nickName;
    if (localObject1 != null) {}
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)localObject1));
      localObject1 = this.trg;
      if (localObject1 == null) {
        p.btv("headerNameTextView");
      }
      ((TextView)localObject1).setText((CharSequence)this.activityName);
      localObject2 = this.kog;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      asB((String)localObject1);
      localObject2 = this.trk;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = this.tre;
      if (localObject2 == null) {
        p.btv("headerDescTextView");
      }
      a((String)localObject1, (TextView)localObject2);
      Ij(this.trl);
      localObject2 = this.coverUrl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      setCover((String)localObject1);
      AppMethodBeat.o(242077);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242075);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.nickName = paramBundle.getStringExtra("key_nick_name");
    this.activityName = paramBundle.getStringExtra("key_activity_name");
    this.trk = paramBundle.getStringExtra("key_activity_desc");
    this.kog = paramBundle.getStringExtra("key_avatar_url");
    this.coverUrl = paramBundle.getStringExtra("key_cover_url");
    this.trl = paramBundle.getIntExtra("key_activity_participate_count", 0);
    this.trm = paramBundle.getLongExtra("key_activity_id", 0L);
    paramBundle = getActivity().findViewById(2131296471);
    p.g(paramBundle, "activity.findViewById(R.….activity_profile_header)");
    this.kgo = paramBundle;
    paramBundle = getActivity().findViewById(2131296468);
    p.g(paramBundle, "activity.findViewById(R.id.activity_profile_cover)");
    this.tqi = ((ImageView)paramBundle);
    paramBundle = getActivity().findViewById(2131296470);
    p.g(paramBundle, "activity.findViewById(R.…ivity_profile_default_bg)");
    this.tqk = ((ImageView)paramBundle);
    paramBundle = this.kgo;
    if (paramBundle == null) {
      p.btv("headerView");
    }
    paramBundle = (TextView)paramBundle.findViewById(2131296480);
    p.g(paramBundle, "headerView.activity_profile_header_title");
    this.trd = paramBundle;
    paramBundle = this.kgo;
    if (paramBundle == null) {
      p.btv("headerView");
    }
    paramBundle = (TextView)paramBundle.findViewById(2131296473);
    p.g(paramBundle, "headerView.activity_profile_header_desc");
    this.tre = paramBundle;
    paramBundle = this.kgo;
    if (paramBundle == null) {
      p.btv("headerView");
    }
    paramBundle = (ImageView)paramBundle.findViewById(2131296472);
    p.g(paramBundle, "headerView.activity_profile_header_avatar");
    this.trf = paramBundle;
    paramBundle = this.kgo;
    if (paramBundle == null) {
      p.btv("headerView");
    }
    paramBundle = (TextView)paramBundle.findViewById(2131296475);
    p.g(paramBundle, "headerView.activity_profile_header_name");
    this.trg = paramBundle;
    paramBundle = this.kgo;
    if (paramBundle == null) {
      p.btv("headerView");
    }
    paramBundle = (TextView)paramBundle.findViewById(2131296476);
    p.g(paramBundle, "headerView.activity_profile_header_participate");
    this.trh = paramBundle;
    paramBundle = this.kgo;
    if (paramBundle == null) {
      p.btv("headerView");
    }
    paramBundle = (LinearLayout)paramBundle.findViewById(2131296477);
    p.g(paramBundle, "headerView.activity_profile_header_participate_btn");
    this.tri = paramBundle;
    paramBundle = this.tri;
    if (paramBundle == null) {
      p.btv("participateBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)FinderActivityHeaderUIC.c.trs);
    cXv();
    paramBundle = this.tre;
    if (paramBundle == null) {
      p.btv("headerDescTextView");
    }
    paramBundle.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o(paramBundle.getContext()));
    this.trp.alive();
    AppMethodBeat.o(242075);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(242076);
    super.onDestroy();
    this.trp.dead();
    AppMethodBeat.o(242076);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$Companion;", "", "()V", "IS_MOCK_DATA", "", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<ih>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class d<T, R>
    implements e<com.tencent.mm.plugin.finder.loader.o, Bitmap>
  {
    d(FinderActivityHeaderUIC paramFinderActivityHeaderUIC, String paramString) {}
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$setCover$1$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderActivityHeaderUIC.d paramd)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "detailSuffix", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<String, x>
  {
    e(FinderActivityHeaderUIC paramFinderActivityHeaderUIC)
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
      AppMethodBeat.i(242074);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tru.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityHeaderUIC
 * JD-Core Version:    0.7.0.1
 */