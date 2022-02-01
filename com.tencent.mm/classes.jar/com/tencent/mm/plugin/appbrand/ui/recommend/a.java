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
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.a.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.cmp;
import d.f;
import d.g.a.m;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.v;
import d.y;
import java.text.DecimalFormat;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.e mlZ;
  final Activity activity;
  private DecimalFormat df;
  private final f mlV;
  m<? super cmp, ? super Integer, y> mlW;
  m<? super cmp, ? super Integer, y> mlX;
  m<? super cmp, ? super Integer, y> mlY;
  
  static
  {
    AppMethodBeat.i(51338);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "wxaList", "getWxaList()Ljava/util/LinkedList;")) };
    mlZ = new a.e((byte)0);
    AppMethodBeat.o(51338);
  }
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(51347);
    this.activity = paramActivity;
    this.mlV = d.g.K((d.g.a.a)a.r.mmu);
    this.mlW = ((m)a.k.mmn);
    this.mlX = ((m)a.q.mmt);
    this.mlY = ((m)a.p.mms);
    this.df = new DecimalFormat("0.00");
    AppMethodBeat.o(51347);
  }
  
  public static AppBrandRecommendStatObj a(WxaAttributes paramWxaAttributes, cmp paramcmp, int paramInt)
  {
    AppMethodBeat.i(51345);
    d.g.b.k.h(paramcmp, "itemData");
    AppBrandRecommendStatObj localAppBrandRecommendStatObj = new AppBrandRecommendStatObj();
    localAppBrandRecommendStatObj.username = paramcmp.Fdk;
    localAppBrandRecommendStatObj.lRr = paramcmp.lRr;
    localAppBrandRecommendStatObj.lRs = paramcmp.lRs;
    if (paramWxaAttributes != null) {
      localAppBrandRecommendStatObj.djj = paramWxaAttributes.field_appId;
    }
    localAppBrandRecommendStatObj.lRt = paramcmp.lRt;
    localAppBrandRecommendStatObj.lRu = paramcmp.lRu;
    localAppBrandRecommendStatObj.lRv = paramcmp.lRv;
    localAppBrandRecommendStatObj.lRw = paramcmp.lRw;
    localAppBrandRecommendStatObj.position = (paramInt + 1);
    localAppBrandRecommendStatObj.doB = c.aZj();
    localAppBrandRecommendStatObj.dmL = c.aZj();
    localAppBrandRecommendStatObj.sessionId = d.jwX.aZr().sessionId;
    AppMethodBeat.o(51345);
    return localAppBrandRecommendStatObj;
  }
  
  private static void a(Context paramContext, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(51343);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramView, "view");
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
  
  public final void a(Context paramContext, WxaAttributes paramWxaAttributes, cmp paramcmp, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51344);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramcmp, "itemData");
    String str = paramcmp.lRr;
    if (!TextUtils.isEmpty((CharSequence)paramcmp.lRs)) {
      str = paramcmp.lRr + ":" + paramcmp.lRs.toString();
    }
    WxaExposedParams.a locala = new WxaExposedParams.a();
    if (paramWxaAttributes != null)
    {
      locala.KC(paramWxaAttributes.field_appId);
      locala.KE(paramWxaAttributes.field_nickname);
    }
    locala.KD(paramcmp.Fdk);
    locala.KF(paramcmp.FzW);
    locala.rG(12);
    paramWxaAttributes = a(paramWxaAttributes, paramcmp, paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_recommend_stat_obj", (Parcelable)paramWxaAttributes);
    AppBrandProfileUI.a(paramContext, paramcmp.Fdk, 7, str, locala.baT(), localBundle, null);
    if (paramBoolean)
    {
      this.mlX.n(paramcmp, Integer.valueOf(paramInt));
      AppMethodBeat.o(51344);
      return;
    }
    this.mlY.n(paramcmp, Integer.valueOf(paramInt));
    AppMethodBeat.o(51344);
  }
  
  final LinkedList<cmp> bwP()
  {
    AppMethodBeat.i(51339);
    LinkedList localLinkedList = (LinkedList)this.mlV.getValue();
    AppMethodBeat.o(51339);
    return localLinkedList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51346);
    int i = bwP().size();
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
    paramInt = ((cmp)bwP().get(paramInt)).lRv;
    AppMethodBeat.o(51341);
    return paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
  public final class a
    extends a.c
  {
    final TextView mma;
    final TextView mmb;
    
    public a()
    {
      super(localObject);
      AppMethodBeat.i(51317);
      this$1 = localObject.findViewById(2131296807);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.mma = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296811);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.mmb = ((TextView)a.this);
      AppMethodBeat.o(51317);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class b
    extends a.i
  {
    final ImageView mmd;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(51318);
      this$1 = localObject.findViewById(2131296816);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.mmd = ((ImageView)a.this);
      AppMethodBeat.o(51318);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class c
    extends RecyclerView.w
  {
    final ImageView mme;
    final TextView mmf;
    final ViewGroup mmg;
    
    public c()
    {
      super();
      AppMethodBeat.i(51319);
      this$1 = localObject.findViewById(2131296808);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…d_recommend_content_icon)");
      this.mme = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296818);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…p_brand_recommend_reason)");
      this.mmf = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296806);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…_brand_recommend_content)");
      this.mmg = ((ViewGroup)a.this);
      AppMethodBeat.o(51319);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
  public final class f
    extends a.j
  {
    final TextView mmh;
    final TextView mmi;
    final TextView mmj;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(51321);
      this$1 = localObject.findViewById(2131296814);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…and_recommend_goods_name)");
      this.mmh = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296809);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…recommend_discount_price)");
      this.mmi = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296815);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…d_recommend_origin_price)");
      this.mmj = ((TextView)a.this);
      AppMethodBeat.o(51321);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public final class h
    extends a.i
  {
    final ImageView lXd;
    
    public h()
    {
      super(localObject);
      AppMethodBeat.i(51323);
      this$1 = localObject.findViewById(2131296816);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.lXd = ((ImageView)a.this);
      AppMethodBeat.o(51323);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class i
    extends a.j
  {
    final TextView mma;
    
    public i()
    {
      super(localObject);
      AppMethodBeat.i(51324);
      this$1 = localObject.findViewById(2131296807);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.mma = ((TextView)a.this);
      AppMethodBeat.o(51324);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class j
    extends a.c
  {
    final ImageView mmk;
    final TextView mml;
    final ViewGroup mmm;
    
    public j()
    {
      super(localObject);
      AppMethodBeat.i(51325);
      this$1 = localObject.findViewById(2131296813);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…nd_recommend_footer_icon)");
      this.mmk = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296811);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.mml = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296810);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…p_brand_recommend_footer)");
      this.mmm = ((ViewGroup)a.this);
      AppMethodBeat.o(51325);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
  static final class l
    implements View.OnClickListener
  {
    l(a.c paramc, a parama, cmp paramcmp, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51328);
      paramView = this.mmc;
      Object localObject = this.mmo.asD;
      d.g.b.k.g(localObject, "baseViewHolder.itemView");
      localObject = ((View)localObject).getContext();
      d.g.b.k.g(localObject, "baseViewHolder.itemView.context");
      paramView.a((Context)localObject, this.mmq, this.mmp, this.mmr, true);
      AppMethodBeat.o(51328);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$4"})
  static final class m
    implements View.OnClickListener
  {
    m(a parama, cmp paramcmp, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51329);
      Object localObject = new Intent((Context)this.mmc.activity, AppBrandRecommendVideoUI.class);
      ((Intent)localObject).putExtra("1", this.mmp.FzQ);
      paramView = this.mmc.activity;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mmc.mlY.n(this.mmp, Integer.valueOf(this.mmr));
      AppMethodBeat.o(51329);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
  static final class n
    implements View.OnClickListener
  {
    n(a.c paramc, a parama, cmp paramcmp, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51330);
      if (this.mmp.lRv == 4)
      {
        paramView = this.mmc;
        localObject1 = this.mmo.asD;
        d.g.b.k.g(localObject1, "baseViewHolder.itemView");
        localObject1 = ((View)localObject1).getContext();
        d.g.b.k.g(localObject1, "baseViewHolder.itemView.context");
        paramView.a((Context)localObject1, this.mmq, this.mmp, this.mmr, false);
        AppMethodBeat.o(51330);
        return;
      }
      Object localObject1 = this.mmp.lRt;
      paramView = (View)localObject1;
      Object localObject2;
      if (this.mmp.lRu != null)
      {
        localObject2 = this.mmp.lRu;
        d.g.b.k.g(localObject2, "itemData.page_param");
        paramView = (View)localObject1;
        if (!d.n.n.aD((CharSequence)localObject2)) {
          paramView = (String)localObject1 + "?" + this.mmp.lRu;
        }
      }
      localObject1 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject1).scene = 1118;
      ((AppBrandStatObject)localObject1).dxE = 14;
      if (!TextUtils.isEmpty((CharSequence)this.mmp.lRs)) {
        ((AppBrandStatObject)localObject1).cYP = (this.mmp.lRr + ":" + this.mmp.lRs.toString());
      }
      for (((AppBrandStatObject)localObject1).dxF = (this.mmp.lRr + ":" + this.mmp.lRs.toString());; ((AppBrandStatObject)localObject1).dxF = this.mmp.lRr)
      {
        ((AppBrandStatObject)localObject1).lRJ = a.a(this.mmq, this.mmp, this.mmr);
        if (this.mmq != null)
        {
          localObject2 = this.mmq;
          if (localObject2 != null)
          {
            localObject2 = ((WxaAttributes)localObject2).baN();
            if (localObject2 != null)
            {
              int i = ((WxaAttributes.WxaVersionInfo)localObject2).aBM;
              ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(this.gYi, this.mmp.Fdk, this.mmq.field_appId, 0, i, paramView, (AppBrandStatObject)localObject1);
            }
          }
        }
        this.mmc.mlY.n(this.mmp, Integer.valueOf(this.mmr));
        AppMethodBeat.o(51330);
        return;
        ((AppBrandStatObject)localObject1).cYP = this.mmp.lRr;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
  static final class o
    implements View.OnLongClickListener
  {
    o(a parama, cmp paramcmp, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(51331);
      com.tencent.mm.pluginsdk.g.a.b((CharSequence)"", (CharSequence)(this.mmp.lRr.toString() + "," + this.mmp.FzV + "," + this.mmp.Fdk));
      AppMethodBeat.o(51331);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */