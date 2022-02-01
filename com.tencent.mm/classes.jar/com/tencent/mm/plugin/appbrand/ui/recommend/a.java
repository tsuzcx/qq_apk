package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.dko;
import java.text.DecimalFormat;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.e oeH;
  final Activity activity;
  private DecimalFormat df;
  private final f oeD;
  m<? super dko, ? super Integer, x> oeE;
  m<? super dko, ? super Integer, x> oeF;
  m<? super dko, ? super Integer, x> oeG;
  
  static
  {
    AppMethodBeat.i(51338);
    oeH = new a.e((byte)0);
    AppMethodBeat.o(51338);
  }
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(51347);
    this.activity = paramActivity;
    this.oeD = kotlin.g.ah((kotlin.g.a.a)a.r.ofc);
    this.oeE = ((m)a.k.oeV);
    this.oeF = ((m)a.q.ofb);
    this.oeG = ((m)a.p.ofa);
    this.df = new DecimalFormat("0.00");
    AppMethodBeat.o(51347);
  }
  
  public static AppBrandRecommendStatObj a(WxaAttributes paramWxaAttributes, dko paramdko, int paramInt)
  {
    AppMethodBeat.i(51345);
    p.h(paramdko, "itemData");
    AppBrandRecommendStatObj localAppBrandRecommendStatObj = new AppBrandRecommendStatObj();
    localAppBrandRecommendStatObj.username = paramdko.gTT;
    localAppBrandRecommendStatObj.nHd = paramdko.nHd;
    localAppBrandRecommendStatObj.nHe = paramdko.nHe;
    if (paramWxaAttributes != null) {
      localAppBrandRecommendStatObj.dNI = paramWxaAttributes.field_appId;
    }
    localAppBrandRecommendStatObj.nHf = paramdko.nHf;
    localAppBrandRecommendStatObj.nHg = paramdko.nHg;
    localAppBrandRecommendStatObj.nHh = paramdko.nHh;
    localAppBrandRecommendStatObj.nHi = paramdko.nHi;
    localAppBrandRecommendStatObj.position = (paramInt + 1);
    localAppBrandRecommendStatObj.dTj = c.getLongitude();
    localAppBrandRecommendStatObj.latitude = c.getLongitude();
    localAppBrandRecommendStatObj.sessionId = d.kXh.byM().sessionId;
    AppMethodBeat.o(51345);
    return localAppBrandRecommendStatObj;
  }
  
  private static void a(Context paramContext, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(51343);
    p.h(paramContext, "context");
    p.h(paramView, "view");
    Object localObject;
    if ((paramView instanceof TextView))
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
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
    for (((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(2131165863);; ((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(2131165862))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(51343);
      return;
    }
  }
  
  public final void a(Context paramContext, WxaAttributes paramWxaAttributes, dko paramdko, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51344);
    p.h(paramContext, "context");
    p.h(paramdko, "itemData");
    String str = paramdko.nHd;
    if (!TextUtils.isEmpty((CharSequence)paramdko.nHe)) {
      str = paramdko.nHd + ":" + paramdko.nHe.toString();
    }
    WxaExposedParams.a locala = new WxaExposedParams.a();
    if (paramWxaAttributes != null)
    {
      locala.XN(paramWxaAttributes.field_appId);
      locala.XP(paramWxaAttributes.field_nickname);
    }
    locala.XO(paramdko.gTT);
    locala.XQ(paramdko.MOB);
    locala.wh(12);
    paramWxaAttributes = a(paramWxaAttributes, paramdko, paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_recommend_stat_obj", (Parcelable)paramWxaAttributes);
    AppBrandProfileUI.a(paramContext, paramdko.gTT, 7, str, locala.bAv(), localBundle, null);
    if (paramBoolean)
    {
      this.oeF.invoke(paramdko, Integer.valueOf(paramInt));
      AppMethodBeat.o(51344);
      return;
    }
    this.oeG.invoke(paramdko, Integer.valueOf(paramInt));
    AppMethodBeat.o(51344);
  }
  
  final LinkedList<dko> bYP()
  {
    AppMethodBeat.i(51339);
    LinkedList localLinkedList = (LinkedList)this.oeD.getValue();
    AppMethodBeat.o(51339);
    return localLinkedList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51346);
    int i = bYP().size();
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
    paramInt = ((dko)bYP().get(paramInt)).nHh;
    AppMethodBeat.o(51341);
    return paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
  public final class a
    extends a.c
  {
    final TextView oeI;
    final TextView oeJ;
    
    public a()
    {
      super(localObject);
      AppMethodBeat.i(51317);
      this$1 = localObject.findViewById(2131296891);
      p.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.oeI = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296895);
      p.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.oeJ = ((TextView)a.this);
      AppMethodBeat.o(51317);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class b
    extends a.i
  {
    final ImageView oeL;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(51318);
      this$1 = localObject.findViewById(2131296900);
      p.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.oeL = ((ImageView)a.this);
      AppMethodBeat.o(51318);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class c
    extends RecyclerView.v
  {
    final ImageView oeM;
    final TextView oeN;
    final ViewGroup oeO;
    
    public c()
    {
      super();
      AppMethodBeat.i(51319);
      this$1 = localObject.findViewById(2131296892);
      p.g(a.this, "itemView.findViewById(R.…d_recommend_content_icon)");
      this.oeM = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296902);
      p.g(a.this, "itemView.findViewById(R.…p_brand_recommend_reason)");
      this.oeN = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296890);
      p.g(a.this, "itemView.findViewById(R.…_brand_recommend_content)");
      this.oeO = ((ViewGroup)a.this);
      AppMethodBeat.o(51319);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
  public final class f
    extends a.j
  {
    final TextView oeP;
    final TextView oeQ;
    final TextView oeR;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(51321);
      this$1 = localObject.findViewById(2131296898);
      p.g(a.this, "itemView.findViewById(R.…and_recommend_goods_name)");
      this.oeP = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296893);
      p.g(a.this, "itemView.findViewById(R.…recommend_discount_price)");
      this.oeQ = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296899);
      p.g(a.this, "itemView.findViewById(R.…d_recommend_origin_price)");
      this.oeR = ((TextView)a.this);
      AppMethodBeat.o(51321);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public final class h
    extends a.i
  {
    final ImageView nNv;
    
    public h()
    {
      super(localObject);
      AppMethodBeat.i(51323);
      this$1 = localObject.findViewById(2131296900);
      p.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.nNv = ((ImageView)a.this);
      AppMethodBeat.o(51323);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class i
    extends a.j
  {
    final TextView oeI;
    
    public i()
    {
      super(localObject);
      AppMethodBeat.i(51324);
      this$1 = localObject.findViewById(2131296891);
      p.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.oeI = ((TextView)a.this);
      AppMethodBeat.o(51324);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class j
    extends a.c
  {
    final ImageView oeS;
    final TextView oeT;
    final ViewGroup oeU;
    
    public j()
    {
      super(localObject);
      AppMethodBeat.i(51325);
      this$1 = localObject.findViewById(2131296897);
      p.g(a.this, "itemView.findViewById(R.…nd_recommend_footer_icon)");
      this.oeS = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296895);
      p.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.oeT = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296894);
      p.g(a.this, "itemView.findViewById(R.…p_brand_recommend_footer)");
      this.oeU = ((ViewGroup)a.this);
      AppMethodBeat.o(51325);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
  static final class l
    implements View.OnClickListener
  {
    l(a.c paramc, a parama, dko paramdko, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51328);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.oeK;
      localObject = this.oeW.aus;
      p.g(localObject, "baseViewHolder.itemView");
      localObject = ((View)localObject).getContext();
      p.g(localObject, "baseViewHolder.itemView.context");
      paramView.a((Context)localObject, this.oeY, this.oeX, this.oeZ, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(51328);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
  static final class n
    implements View.OnClickListener
  {
    n(a.c paramc, a parama, dko paramdko, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51330);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      if (this.oeX.nHh == 4)
      {
        paramView = this.oeK;
        localObject1 = this.oeW.aus;
        p.g(localObject1, "baseViewHolder.itemView");
        localObject1 = ((View)localObject1).getContext();
        p.g(localObject1, "baseViewHolder.itemView.context");
        paramView.a((Context)localObject1, this.oeY, this.oeX, this.oeZ, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(51330);
        return;
      }
      localObject1 = this.oeX.nHf;
      paramView = (View)localObject1;
      Object localObject2;
      if (this.oeX.nHg != null)
      {
        localObject2 = this.oeX.nHg;
        p.g(localObject2, "itemData.page_param");
        paramView = (View)localObject1;
        if (!n.aL((CharSequence)localObject2)) {
          paramView = (String)localObject1 + "?" + this.oeX.nHg;
        }
      }
      localObject1 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject1).scene = 1118;
      ((AppBrandStatObject)localObject1).ecU = 14;
      if (!TextUtils.isEmpty((CharSequence)this.oeX.nHe)) {
        ((AppBrandStatObject)localObject1).dCw = (this.oeX.nHd + ":" + this.oeX.nHe.toString());
      }
      for (((AppBrandStatObject)localObject1).ecV = (this.oeX.nHd + ":" + this.oeX.nHe.toString());; ((AppBrandStatObject)localObject1).ecV = this.oeX.nHd)
      {
        ((AppBrandStatObject)localObject1).nHv = a.a(this.oeY, this.oeX, this.oeZ);
        if (this.oeY != null)
        {
          localObject2 = this.oeY;
          if (localObject2 != null)
          {
            localObject2 = ((WxaAttributes)localObject2).bAp();
            if (localObject2 != null)
            {
              int i = ((WxaAttributes.WxaVersionInfo)localObject2).appVersion;
              ((r)com.tencent.mm.kernel.g.af(r.class)).a(this.$context$inlined, this.oeX.gTT, this.oeY.field_appId, 0, i, paramView, (AppBrandStatObject)localObject1);
            }
          }
        }
        this.oeK.oeG.invoke(this.oeX, Integer.valueOf(this.oeZ));
        break;
        ((AppBrandStatObject)localObject1).dCw = this.oeX.nHd;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */