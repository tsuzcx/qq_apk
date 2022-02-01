package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.a.d.a;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.dud;
import java.text.DecimalFormat;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.e rgt;
  final Activity activity;
  private DecimalFormat df;
  private final f rgp;
  m<? super dud, ? super Integer, x> rgq;
  m<? super dud, ? super Integer, x> rgr;
  m<? super dud, ? super Integer, x> rgs;
  
  static
  {
    AppMethodBeat.i(51338);
    rgt = new a.e((byte)0);
    AppMethodBeat.o(51338);
  }
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(51347);
    this.activity = paramActivity;
    this.rgp = g.ar((kotlin.g.a.a)a.r.rgO);
    this.rgq = ((m)a.k.rgH);
    this.rgr = ((m)a.q.rgN);
    this.rgs = ((m)a.p.rgM);
    this.df = new DecimalFormat("0.00");
    AppMethodBeat.o(51347);
  }
  
  public static AppBrandRecommendStatObj a(WxaAttributes paramWxaAttributes, dud paramdud, int paramInt)
  {
    AppMethodBeat.i(51345);
    p.k(paramdud, "itemData");
    AppBrandRecommendStatObj localAppBrandRecommendStatObj = new AppBrandRecommendStatObj();
    localAppBrandRecommendStatObj.username = paramdud.jEx;
    localAppBrandRecommendStatObj.qJp = paramdud.qJp;
    localAppBrandRecommendStatObj.qJq = paramdud.qJq;
    if (paramWxaAttributes != null) {
      localAppBrandRecommendStatObj.appid = paramWxaAttributes.field_appId;
    }
    localAppBrandRecommendStatObj.qJr = paramdud.qJr;
    localAppBrandRecommendStatObj.qJs = paramdud.qJs;
    localAppBrandRecommendStatObj.qJt = paramdud.qJt;
    localAppBrandRecommendStatObj.qJu = paramdud.qJu;
    localAppBrandRecommendStatObj.position = (paramInt + 1);
    localAppBrandRecommendStatObj.longitude = c.getLongitude();
    localAppBrandRecommendStatObj.latitude = c.getLongitude();
    localAppBrandRecommendStatObj.sessionId = d.nRt.bKa().sessionId;
    AppMethodBeat.o(51345);
    return localAppBrandRecommendStatObj;
  }
  
  private static void a(Context paramContext, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(51343);
    p.k(paramContext, "context");
    p.k(paramView, "view");
    Object localObject;
    if ((paramView instanceof TextView))
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
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
    for (((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(au.d.app_brand_recommend_item_app_type_app_name_margin_top);; ((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(au.d.app_brand_recommend_item_app_type_app_name_margin_center))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(51343);
      return;
    }
  }
  
  public final void a(Context paramContext, WxaAttributes paramWxaAttributes, dud paramdud, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51344);
    p.k(paramContext, "context");
    p.k(paramdud, "itemData");
    String str = paramdud.qJp;
    if (!TextUtils.isEmpty((CharSequence)paramdud.qJq)) {
      str = paramdud.qJp + ":" + paramdud.qJq.toString();
    }
    WxaExposedParams.a locala = new WxaExposedParams.a();
    if (paramWxaAttributes != null)
    {
      locala.afz(paramWxaAttributes.field_appId);
      locala.afB(paramWxaAttributes.field_nickname);
    }
    locala.afA(paramdud.jEx);
    locala.afC(paramdud.Uav);
    locala.zu(12);
    paramWxaAttributes = a(paramWxaAttributes, paramdud, paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_recommend_stat_obj", (Parcelable)paramWxaAttributes);
    AppBrandProfileUI.a(paramContext, paramdud.jEx, 7, str, locala.bLN(), localBundle, null);
    if (paramBoolean)
    {
      this.rgr.invoke(paramdud, Integer.valueOf(paramInt));
      AppMethodBeat.o(51344);
      return;
    }
    this.rgs.invoke(paramdud, Integer.valueOf(paramInt));
    AppMethodBeat.o(51344);
  }
  
  final LinkedList<dud> clz()
  {
    AppMethodBeat.i(51339);
    LinkedList localLinkedList = (LinkedList)this.rgp.getValue();
    AppMethodBeat.o(51339);
    return localLinkedList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51346);
    int i = clz().size();
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
    paramInt = ((dud)clz().get(paramInt)).qJt;
    AppMethodBeat.o(51341);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
  public final class a
    extends a.c
  {
    final TextView rgu;
    final TextView rgv;
    
    public a()
    {
      super(localObject);
      AppMethodBeat.i(51317);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_content_desc);
      p.j(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.rgu = ((TextView)a.this);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_footer_app_name);
      p.j(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.rgv = ((TextView)a.this);
      AppMethodBeat.o(51317);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class b
    extends a.i
  {
    final ImageView rgx;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(51318);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_play_icon);
      p.j(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.rgx = ((ImageView)a.this);
      AppMethodBeat.o(51318);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class c
    extends RecyclerView.v
  {
    final ViewGroup rgA;
    final ImageView rgy;
    final TextView rgz;
    
    public c()
    {
      super();
      AppMethodBeat.i(51319);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_content_icon);
      p.j(a.this, "itemView.findViewById(R.…d_recommend_content_icon)");
      this.rgy = ((ImageView)a.this);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_reason);
      p.j(a.this, "itemView.findViewById(R.…p_brand_recommend_reason)");
      this.rgz = ((TextView)a.this);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_content);
      p.j(a.this, "itemView.findViewById(R.…_brand_recommend_content)");
      this.rgA = ((ViewGroup)a.this);
      AppMethodBeat.o(51319);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
  public final class f
    extends a.j
  {
    final TextView rgB;
    final TextView rgC;
    final TextView rgD;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(51321);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_goods_name);
      p.j(a.this, "itemView.findViewById(R.…and_recommend_goods_name)");
      this.rgB = ((TextView)a.this);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_discount_price);
      p.j(a.this, "itemView.findViewById(R.…recommend_discount_price)");
      this.rgC = ((TextView)a.this);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_origin_price);
      p.j(a.this, "itemView.findViewById(R.…d_recommend_origin_price)");
      this.rgD = ((TextView)a.this);
      AppMethodBeat.o(51321);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public final class h
    extends a.i
  {
    final ImageView qPQ;
    
    public h()
    {
      super(localObject);
      AppMethodBeat.i(51323);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_play_icon);
      p.j(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.qPQ = ((ImageView)a.this);
      AppMethodBeat.o(51323);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class i
    extends a.j
  {
    final TextView rgu;
    
    public i()
    {
      super(localObject);
      AppMethodBeat.i(51324);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_content_desc);
      p.j(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.rgu = ((TextView)a.this);
      AppMethodBeat.o(51324);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class j
    extends a.c
  {
    final ImageView rgE;
    final TextView rgF;
    final ViewGroup rgG;
    
    public j()
    {
      super(localObject);
      AppMethodBeat.i(51325);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_footer_icon);
      p.j(a.this, "itemView.findViewById(R.…nd_recommend_footer_icon)");
      this.rgE = ((ImageView)a.this);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_footer_app_name);
      p.j(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.rgF = ((TextView)a.this);
      this$1 = localObject.findViewById(au.f.app_brand_recommend_footer);
      p.j(a.this, "itemView.findViewById(R.…p_brand_recommend_footer)");
      this.rgG = ((ViewGroup)a.this);
      AppMethodBeat.o(51325);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
  static final class l
    implements View.OnClickListener
  {
    l(a.c paramc, a parama, dud paramdud, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51328);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.rgw;
      localObject = this.rgI.amk;
      p.j(localObject, "baseViewHolder.itemView");
      localObject = ((View)localObject).getContext();
      p.j(localObject, "baseViewHolder.itemView.context");
      paramView.a((Context)localObject, this.rgK, this.rgJ, this.rgL, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(51328);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
  static final class n
    implements View.OnClickListener
  {
    n(a.c paramc, a parama, dud paramdud, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51330);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      if (this.rgJ.qJt == 4)
      {
        paramView = this.rgw;
        localObject1 = this.rgI.amk;
        p.j(localObject1, "baseViewHolder.itemView");
        localObject1 = ((View)localObject1).getContext();
        p.j(localObject1, "baseViewHolder.itemView.context");
        paramView.a((Context)localObject1, this.rgK, this.rgJ, this.rgL, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(51330);
        return;
      }
      localObject1 = this.rgJ.qJr;
      paramView = (View)localObject1;
      Object localObject2;
      if (this.rgJ.qJs != null)
      {
        localObject2 = this.rgJ.qJs;
        p.j(localObject2, "itemData.page_param");
        paramView = (View)localObject1;
        if (!n.ba((CharSequence)localObject2)) {
          paramView = (String)localObject1 + "?" + this.rgJ.qJs;
        }
      }
      localObject1 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject1).scene = 1118;
      ((AppBrandStatObject)localObject1).fXa = 14;
      if (!TextUtils.isEmpty((CharSequence)this.rgJ.qJq)) {
        ((AppBrandStatObject)localObject1).fvd = (this.rgJ.qJp + ":" + this.rgJ.qJq.toString());
      }
      for (((AppBrandStatObject)localObject1).fXb = (this.rgJ.qJp + ":" + this.rgJ.qJq.toString());; ((AppBrandStatObject)localObject1).fXb = this.rgJ.qJp)
      {
        ((AppBrandStatObject)localObject1).qJH = a.a(this.rgK, this.rgJ, this.rgL);
        if (this.rgK != null)
        {
          localObject2 = this.rgK;
          if (localObject2 != null)
          {
            localObject2 = ((WxaAttributes)localObject2).bLH();
            if (localObject2 != null)
            {
              int i = ((WxaAttributes.WxaVersionInfo)localObject2).appVersion;
              ((r)h.ae(r.class)).a(this.$context$inlined, this.rgJ.jEx, this.rgK.field_appId, 0, i, paramView, (AppBrandStatObject)localObject1);
            }
          }
        }
        this.rgw.rgs.invoke(this.rgJ, Integer.valueOf(this.rgL));
        break;
        ((AppBrandStatObject)localObject1).fvd = this.rgJ.qJp;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */