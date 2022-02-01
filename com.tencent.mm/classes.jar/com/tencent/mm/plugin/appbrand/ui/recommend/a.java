package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.a.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.csl;
import d.f;
import d.g.a.m;
import d.l;
import d.n.n;
import d.v;
import d.z;
import java.text.DecimalFormat;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.e mRE;
  final Activity activity;
  private DecimalFormat df;
  private final f mRA;
  m<? super csl, ? super Integer, z> mRB;
  m<? super csl, ? super Integer, z> mRC;
  m<? super csl, ? super Integer, z> mRD;
  
  static
  {
    AppMethodBeat.i(51338);
    mRE = new a.e((byte)0);
    AppMethodBeat.o(51338);
  }
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(51347);
    this.activity = paramActivity;
    this.mRA = d.g.O((d.g.a.a)a.r.mRZ);
    this.mRB = ((m)a.k.mRS);
    this.mRC = ((m)a.q.mRY);
    this.mRD = ((m)a.p.mRX);
    this.df = new DecimalFormat("0.00");
    AppMethodBeat.o(51347);
  }
  
  public static AppBrandRecommendStatObj a(WxaAttributes paramWxaAttributes, csl paramcsl, int paramInt)
  {
    AppMethodBeat.i(51345);
    d.g.b.p.h(paramcsl, "itemData");
    AppBrandRecommendStatObj localAppBrandRecommendStatObj = new AppBrandRecommendStatObj();
    localAppBrandRecommendStatObj.username = paramcsl.Hgn;
    localAppBrandRecommendStatObj.mwf = paramcsl.mwf;
    localAppBrandRecommendStatObj.mwg = paramcsl.mwg;
    if (paramWxaAttributes != null) {
      localAppBrandRecommendStatObj.dwb = paramWxaAttributes.field_appId;
    }
    localAppBrandRecommendStatObj.mwh = paramcsl.mwh;
    localAppBrandRecommendStatObj.mwi = paramcsl.mwi;
    localAppBrandRecommendStatObj.mwj = paramcsl.mwj;
    localAppBrandRecommendStatObj.mwk = paramcsl.mwk;
    localAppBrandRecommendStatObj.position = (paramInt + 1);
    localAppBrandRecommendStatObj.dBu = c.bdm();
    localAppBrandRecommendStatObj.dzE = c.bdm();
    localAppBrandRecommendStatObj.sessionId = d.jUl.bdu().sessionId;
    AppMethodBeat.o(51345);
    return localAppBrandRecommendStatObj;
  }
  
  private static void a(Context paramContext, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(51343);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramView, "view");
    Object localObject;
    if ((paramView instanceof TextView))
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(51343);
        throw paramContext;
      }
      localObject = (ConstraintLayout.LayoutParams)localObject;
      if (localObject != null) {
        if (!paramBoolean) {
          break label97;
        }
      }
    }
    label97:
    for (((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(2131165837);; ((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(2131165836))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(51343);
      return;
    }
  }
  
  public final void a(Context paramContext, WxaAttributes paramWxaAttributes, csl paramcsl, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51344);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramcsl, "itemData");
    String str = paramcsl.mwf;
    if (!TextUtils.isEmpty((CharSequence)paramcsl.mwg)) {
      str = paramcsl.mwf + ":" + paramcsl.mwg.toString();
    }
    WxaExposedParams.a locala = new WxaExposedParams.a();
    if (paramWxaAttributes != null)
    {
      locala.OC(paramWxaAttributes.field_appId);
      locala.OE(paramWxaAttributes.field_nickname);
    }
    locala.OD(paramcsl.Hgn);
    locala.OF(paramcsl.HDH);
    locala.sl(12);
    paramWxaAttributes = a(paramWxaAttributes, paramcsl, paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_recommend_stat_obj", (Parcelable)paramWxaAttributes);
    AppBrandProfileUI.a(paramContext, paramcsl.Hgn, 7, str, locala.bfb(), localBundle, null);
    if (paramBoolean)
    {
      this.mRC.p(paramcsl, Integer.valueOf(paramInt));
      AppMethodBeat.o(51344);
      return;
    }
    this.mRD.p(paramcsl, Integer.valueOf(paramInt));
    AppMethodBeat.o(51344);
  }
  
  final LinkedList<csl> bBP()
  {
    AppMethodBeat.i(51339);
    LinkedList localLinkedList = (LinkedList)this.mRA.getValue();
    AppMethodBeat.o(51339);
    return localLinkedList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51346);
    int i = bBP().size();
    AppMethodBeat.o(51346);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(51341);
    paramInt = ((csl)bBP().get(paramInt)).mwj;
    AppMethodBeat.o(51341);
    return paramInt;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
  public final class a
    extends a.c
  {
    final TextView mRF;
    final TextView mRG;
    
    public a()
    {
      super(localObject);
      AppMethodBeat.i(51317);
      this$1 = localObject.findViewById(2131296807);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.mRF = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296811);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.mRG = ((TextView)a.this);
      AppMethodBeat.o(51317);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class b
    extends a.i
  {
    final ImageView mRI;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(51318);
      this$1 = localObject.findViewById(2131296816);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.mRI = ((ImageView)a.this);
      AppMethodBeat.o(51318);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class c
    extends RecyclerView.w
  {
    final ImageView mRJ;
    final TextView mRK;
    final ViewGroup mRL;
    
    public c()
    {
      super();
      AppMethodBeat.i(51319);
      this$1 = localObject.findViewById(2131296808);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…d_recommend_content_icon)");
      this.mRJ = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296818);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…p_brand_recommend_reason)");
      this.mRK = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296806);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…_brand_recommend_content)");
      this.mRL = ((ViewGroup)a.this);
      AppMethodBeat.o(51319);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
  public final class d
    extends a.b
  {
    public d()
    {
      super(localObject);
      AppMethodBeat.i(51320);
      AppMethodBeat.o(51320);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
  public final class f
    extends a.j
  {
    final TextView mRM;
    final TextView mRN;
    final TextView mRO;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(51321);
      this$1 = localObject.findViewById(2131296814);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…and_recommend_goods_name)");
      this.mRM = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296809);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…recommend_discount_price)");
      this.mRN = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296815);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…d_recommend_origin_price)");
      this.mRO = ((TextView)a.this);
      AppMethodBeat.o(51321);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
  public final class g
    extends a.i
  {
    public g()
    {
      super(localObject);
      AppMethodBeat.i(51322);
      AppMethodBeat.o(51322);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public final class h
    extends a.i
  {
    final ImageView mBP;
    
    public h()
    {
      super(localObject);
      AppMethodBeat.i(51323);
      this$1 = localObject.findViewById(2131296816);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.mBP = ((ImageView)a.this);
      AppMethodBeat.o(51323);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class i
    extends a.j
  {
    final TextView mRF;
    
    public i()
    {
      super(localObject);
      AppMethodBeat.i(51324);
      this$1 = localObject.findViewById(2131296807);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.mRF = ((TextView)a.this);
      AppMethodBeat.o(51324);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class j
    extends a.c
  {
    final ImageView mRP;
    final TextView mRQ;
    final ViewGroup mRR;
    
    public j()
    {
      super(localObject);
      AppMethodBeat.i(51325);
      this$1 = localObject.findViewById(2131296813);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…nd_recommend_footer_icon)");
      this.mRP = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296811);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.mRQ = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296810);
      d.g.b.p.g(a.this, "itemView.findViewById(R.…p_brand_recommend_footer)");
      this.mRR = ((ViewGroup)a.this);
      AppMethodBeat.o(51325);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
  static final class l
    implements View.OnClickListener
  {
    l(a.c paramc, a parama, csl paramcsl, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51328);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      paramView = this.mRH;
      localObject = this.mRT.auu;
      d.g.b.p.g(localObject, "baseViewHolder.itemView");
      localObject = ((View)localObject).getContext();
      d.g.b.p.g(localObject, "baseViewHolder.itemView.context");
      paramView.a((Context)localObject, this.mRV, this.mRU, this.mRW, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(51328);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$4"})
  static final class m
    implements View.OnClickListener
  {
    m(a parama, csl paramcsl, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51329);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = new Intent((Context)this.mRH.activity, AppBrandRecommendVideoUI.class);
      ((Intent)localObject).putExtra("1", this.mRU.HDB);
      paramView = this.mRH.activity;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mRH.mRD.p(this.mRU, Integer.valueOf(this.mRW));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(51329);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
  static final class n
    implements View.OnClickListener
  {
    n(a.c paramc, a parama, csl paramcsl, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51330);
      Object localObject1 = new b();
      ((b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahF());
      if (this.mRU.mwj == 4)
      {
        paramView = this.mRH;
        localObject1 = this.mRT.auu;
        d.g.b.p.g(localObject1, "baseViewHolder.itemView");
        localObject1 = ((View)localObject1).getContext();
        d.g.b.p.g(localObject1, "baseViewHolder.itemView.context");
        paramView.a((Context)localObject1, this.mRV, this.mRU, this.mRW, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(51330);
        return;
      }
      localObject1 = this.mRU.mwh;
      paramView = (View)localObject1;
      Object localObject2;
      if (this.mRU.mwi != null)
      {
        localObject2 = this.mRU.mwi;
        d.g.b.p.g(localObject2, "itemData.page_param");
        paramView = (View)localObject1;
        if (!n.aD((CharSequence)localObject2)) {
          paramView = (String)localObject1 + "?" + this.mRU.mwi;
        }
      }
      localObject1 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject1).scene = 1118;
      ((AppBrandStatObject)localObject1).dLf = 14;
      if (!TextUtils.isEmpty((CharSequence)this.mRU.mwg)) {
        ((AppBrandStatObject)localObject1).dlj = (this.mRU.mwf + ":" + this.mRU.mwg.toString());
      }
      for (((AppBrandStatObject)localObject1).dLg = (this.mRU.mwf + ":" + this.mRU.mwg.toString());; ((AppBrandStatObject)localObject1).dLg = this.mRU.mwf)
      {
        ((AppBrandStatObject)localObject1).mwx = a.a(this.mRV, this.mRU, this.mRW);
        if (this.mRV != null)
        {
          localObject2 = this.mRV;
          if (localObject2 != null)
          {
            localObject2 = ((WxaAttributes)localObject2).beV();
            if (localObject2 != null)
            {
              int i = ((WxaAttributes.WxaVersionInfo)localObject2).aDD;
              ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(this.htc, this.mRU.Hgn, this.mRV.field_appId, 0, i, paramView, (AppBrandStatObject)localObject1);
            }
          }
        }
        this.mRH.mRD.p(this.mRU, Integer.valueOf(this.mRW));
        break;
        ((AppBrandStatObject)localObject1).dlj = this.mRU.mwf;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
  static final class o
    implements View.OnLongClickListener
  {
    o(a parama, csl paramcsl, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(51331);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      com.tencent.mm.pluginsdk.i.a.b((CharSequence)"", (CharSequence)(this.mRU.mwf.toString() + "," + this.mRU.HDG + "," + this.mRU.Hgn));
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(51331);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */