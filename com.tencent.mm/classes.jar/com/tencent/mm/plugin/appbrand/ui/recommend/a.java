package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
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
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.enb;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import java.text.DecimalFormat;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<c>
{
  public static final a.e uop;
  final Activity activity;
  private DecimalFormat df;
  private final j uoq;
  m<? super enb, ? super Integer, ah> uor;
  m<? super enb, ? super Integer, ah> uos;
  m<? super enb, ? super Integer, ah> uot;
  
  static
  {
    AppMethodBeat.i(51338);
    uop = new a.e((byte)0);
    AppMethodBeat.o(51338);
  }
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(51347);
    this.activity = paramActivity;
    this.uoq = k.cm((kotlin.g.a.a)a.n.uoK);
    this.uor = ((m)a.k.uoH);
    this.uos = ((m)a.m.uoJ);
    this.uot = ((m)a.l.uoI);
    this.df = new DecimalFormat("0.00");
    AppMethodBeat.o(51347);
  }
  
  private static AppBrandRecommendStatObj a(WxaAttributes paramWxaAttributes, enb paramenb, int paramInt)
  {
    AppMethodBeat.i(51345);
    s.u(paramenb, "itemData");
    AppBrandRecommendStatObj localAppBrandRecommendStatObj = new AppBrandRecommendStatObj();
    localAppBrandRecommendStatObj.username = paramenb.met;
    localAppBrandRecommendStatObj.tNS = paramenb.tNS;
    localAppBrandRecommendStatObj.tNT = paramenb.tNT;
    if (paramWxaAttributes != null) {
      localAppBrandRecommendStatObj.appid = paramWxaAttributes.field_appId;
    }
    localAppBrandRecommendStatObj.tNU = paramenb.tNU;
    localAppBrandRecommendStatObj.tNV = paramenb.tNV;
    localAppBrandRecommendStatObj.tNW = paramenb.tNW;
    localAppBrandRecommendStatObj.tNX = paramenb.tNX;
    localAppBrandRecommendStatObj.position = (paramInt + 1);
    localAppBrandRecommendStatObj.longitude = c.getLongitude();
    localAppBrandRecommendStatObj.latitude = c.getLongitude();
    localAppBrandRecommendStatObj.sessionId = d.qQT.cjB().sessionId;
    AppMethodBeat.o(51345);
    return localAppBrandRecommendStatObj;
  }
  
  private static void a(Context paramContext, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(51343);
    s.u(paramContext, "context");
    s.u(paramView, "view");
    Object localObject;
    if ((paramView instanceof TextView))
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(51343);
        throw paramContext;
      }
      localObject = (ConstraintLayout.LayoutParams)localObject;
      if (!paramBoolean) {
        break label93;
      }
    }
    label93:
    for (((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(ba.d.app_brand_recommend_item_app_type_app_name_margin_top);; ((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(ba.d.app_brand_recommend_item_app_type_app_name_margin_center))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(51343);
      return;
    }
  }
  
  private void a(Context paramContext, WxaAttributes paramWxaAttributes, enb paramenb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51344);
    s.u(paramContext, "context");
    s.u(paramenb, "itemData");
    String str = paramenb.tNS;
    if (!TextUtils.isEmpty((CharSequence)paramenb.tNT)) {
      str = paramenb.tNS + ':' + paramenb.tNT;
    }
    WxaExposedParams.a locala = new WxaExposedParams.a();
    if (paramWxaAttributes != null)
    {
      locala.appId = paramWxaAttributes.field_appId;
      locala.nickname = paramWxaAttributes.field_nickname;
    }
    locala.username = paramenb.met;
    locala.iconUrl = paramenb.abrx;
    locala.from = 12;
    paramWxaAttributes = a(paramWxaAttributes, paramenb, paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_recommend_stat_obj", (Parcelable)paramWxaAttributes);
    AppBrandProfileUI.a(paramContext, paramenb.met, 7, str, true, locala.cll(), localBundle, null);
    if (paramBoolean)
    {
      this.uos.invoke(paramenb, Integer.valueOf(paramInt));
      AppMethodBeat.o(51344);
      return;
    }
    this.uot.invoke(paramenb, Integer.valueOf(paramInt));
    AppMethodBeat.o(51344);
  }
  
  private static final void a(a parama, c paramc, WxaAttributes paramWxaAttributes, enb paramenb, int paramInt, View paramView)
  {
    AppMethodBeat.i(322585);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramc);
    localb.cH(paramWxaAttributes);
    localb.cH(paramenb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(paramc, "$baseViewHolder");
    s.u(paramenb, "$itemData");
    paramc = paramc.caK.getContext();
    s.s(paramc, "baseViewHolder.itemView.context");
    parama.a(paramc, paramWxaAttributes, paramenb, paramInt, true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322585);
  }
  
  private static final void a(a parama, enb paramenb, int paramInt, View paramView)
  {
    AppMethodBeat.i(322593);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramenb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(paramenb, "$itemData");
    localObject = new Intent((Context)parama.activity, AppBrandRecommendVideoUI.class);
    ((Intent)localObject).putExtra("1", paramenb.abrq);
    paramView = parama.activity;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "onBindViewHolder$lambda-7$lambda-3", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Lcom/tencent/mm/protocal/protobuf/RecommendCard;ILandroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "onBindViewHolder$lambda-7$lambda-3", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Lcom/tencent/mm/protocal/protobuf/RecommendCard;ILandroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.uot.invoke(paramenb, Integer.valueOf(paramInt));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322593);
  }
  
  private static final void a(enb paramenb, a parama, c paramc, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext, View paramView)
  {
    AppMethodBeat.i(322601);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramenb);
    localb.cH(parama);
    localb.cH(paramc);
    localb.cH(paramWxaAttributes);
    localb.sc(paramInt);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramenb, "$itemData");
    s.u(parama, "this$0");
    s.u(paramc, "$baseViewHolder");
    if (paramenb.tNW == 4)
    {
      paramc = paramc.caK.getContext();
      s.s(paramc, "baseViewHolder.itemView.context");
      parama.a(paramc, paramWxaAttributes, paramenb, paramInt, false);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(322601);
      return;
    }
    paramView = paramenb.tNU;
    paramc = paramView;
    if (paramenb.tNV != null)
    {
      localObject = paramenb.tNV;
      s.s(localObject, "itemData.page_param");
      paramc = paramView;
      if (!n.bp((CharSequence)localObject)) {
        paramc = paramView + '?' + paramenb.tNV;
      }
    }
    paramView = new AppBrandStatObject();
    paramView.scene = 1118;
    paramView.icZ = 14;
    if (!TextUtils.isEmpty((CharSequence)paramenb.tNT)) {
      paramView.hzx = (paramenb.tNS + ':' + paramenb.tNT);
    }
    for (paramView.ida = (paramenb.tNS + ':' + paramenb.tNT);; paramView.ida = paramenb.tNS)
    {
      paramView.tOl = a(paramWxaAttributes, paramenb, paramInt);
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.clf();
        if (localObject != null)
        {
          int i = ((WxaAttributes.WxaVersionInfo)localObject).appVersion;
          ((t)h.ax(t.class)).a(paramContext, paramenb.met, paramWxaAttributes.field_appId, 0, i, paramc, paramView);
        }
      }
      parama.uot.invoke(paramenb, Integer.valueOf(paramInt));
      break;
      paramView.hzx = paramenb.tNS;
    }
  }
  
  private static final boolean a(a parama, enb paramenb, View paramView)
  {
    AppMethodBeat.i(322610);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramenb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(paramenb, "$itemData");
    ClipboardHelper.setText((Context)parama.activity, (CharSequence)"", (CharSequence)(paramenb.tNS + ',' + paramenb.abrw + ',' + paramenb.met));
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(322610);
    return false;
  }
  
  final LinkedList<enb> cMW()
  {
    AppMethodBeat.i(51339);
    LinkedList localLinkedList = (LinkedList)this.uoq.getValue();
    AppMethodBeat.o(51339);
    return localLinkedList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51346);
    int i = cMW().size();
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
    paramInt = ((enb)cMW().get(paramInt)).tNW;
    AppMethodBeat.o(51341);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends a.c
  {
    final TextView uou;
    final TextView uov;
    
    public a()
    {
      super(localObject);
      AppMethodBeat.i(51317);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_content_desc);
      s.s(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.uou = ((TextView)a.this);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_footer_app_name);
      s.s(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.uov = ((TextView)a.this);
      AppMethodBeat.o(51317);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class b
    extends a.i
  {
    final ImageView uox;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(51318);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_play_icon);
      s.s(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.uox = ((ImageView)a.this);
      AppMethodBeat.o(51318);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class c
    extends RecyclerView.v
  {
    final ViewGroup uoA;
    final ImageView uoy;
    final TextView uoz;
    
    public c()
    {
      super();
      AppMethodBeat.i(51319);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_content_icon);
      s.s(a.this, "itemView.findViewById(R.…d_recommend_content_icon)");
      this.uoy = ((ImageView)a.this);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_reason);
      s.s(a.this, "itemView.findViewById(R.…p_brand_recommend_reason)");
      this.uoz = ((TextView)a.this);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_content);
      s.s(a.this, "itemView.findViewById(R.…_brand_recommend_content)");
      this.uoA = ((ViewGroup)a.this);
      AppMethodBeat.o(51319);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class f
    extends a.j
  {
    final TextView uoB;
    final TextView uoC;
    final TextView uoD;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(51321);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_goods_name);
      s.s(a.this, "itemView.findViewById(R.…and_recommend_goods_name)");
      this.uoB = ((TextView)a.this);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_discount_price);
      s.s(a.this, "itemView.findViewById(R.…recommend_discount_price)");
      this.uoC = ((TextView)a.this);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_origin_price);
      s.s(a.this, "itemView.findViewById(R.…d_recommend_origin_price)");
      this.uoD = ((TextView)a.this);
      AppMethodBeat.o(51321);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class h
    extends a.i
  {
    final ImageView tUG;
    
    public h()
    {
      super(localObject);
      AppMethodBeat.i(51323);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_play_icon);
      s.s(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.tUG = ((ImageView)a.this);
      AppMethodBeat.o(51323);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class i
    extends a.j
  {
    final TextView uou;
    
    public i()
    {
      super(localObject);
      AppMethodBeat.i(51324);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_content_desc);
      s.s(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.uou = ((TextView)a.this);
      AppMethodBeat.o(51324);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class j
    extends a.c
  {
    final ImageView uoE;
    final TextView uoF;
    final ViewGroup uoG;
    
    public j()
    {
      super(localObject);
      AppMethodBeat.i(51325);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_footer_icon);
      s.s(a.this, "itemView.findViewById(R.…nd_recommend_footer_icon)");
      this.uoE = ((ImageView)a.this);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_footer_app_name);
      s.s(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.uoF = ((TextView)a.this);
      this$1 = localObject.findViewById(ba.f.app_brand_recommend_footer);
      s.s(a.this, "itemView.findViewById(R.…p_brand_recommend_footer)");
      this.uoG = ((ViewGroup)a.this);
      AppMethodBeat.o(51325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */