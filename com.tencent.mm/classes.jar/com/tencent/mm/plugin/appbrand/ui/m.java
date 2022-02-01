package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.protocal.protobuf.epg;
import com.tencent.mm.protocal.protobuf.eph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ag;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Landroid/view/View$OnClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "_layoutContainer", "Landroid/widget/FrameLayout;", "fullInfoIconDescTextView", "Landroid/widget/TextView;", "getFullInfoIconDescTextView", "()Landroid/widget/TextView;", "fullInfoIconDescTextView$delegate", "Lkotlin/Lazy;", "fullInfoIconImageView", "Landroid/widget/ImageView;", "getFullInfoIconImageView", "()Landroid/widget/ImageView;", "fullInfoIconImageView$delegate", "fullInfoTextView", "getFullInfoTextView", "fullInfoTextView$delegate", "fullLayout", "Landroid/view/View;", "halfScreenComponent", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent;", "layoutContainer", "getLayoutContainer", "()Landroid/widget/FrameLayout;", "liteInfoTextView", "getLiteInfoTextView", "liteInfoTextView$delegate", "liteLayout", "onRelievedBuyEntryClickListener", "Lcom/tencent/mm/plugin/appbrand/ui/IOnRelievedBuyEntryClickListener;", "canExposeRelievedBuy", "", "concatContent", "", "prefix", "suffixFormat", "splitter", "wordings", "", "indexLimit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;I)Ljava/lang/String;", "configureFullLayout", "", "relievedBuyInfo", "Lcom/tencent/mm/protocal/protobuf/RelievedBuyInfo;", "subTypeTitles", "(Lcom/tencent/mm/protocal/protobuf/RelievedBuyInfo;[Ljava/lang/String;)V", "configureLiteLayout", "([Ljava/lang/String;)V", "getFullLayout", "getLiteLayout", "isNeedExposeRelievedBuy", "relievedBuyInfoHolder", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyUIC$RelievedBuyInfoHolder;", "logConfigureCall", "configureName", "(Ljava/lang/String;[Ljava/lang/String;)V", "onClick", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onRelievedBuyInfoFetched", "requireFullLayout", "requireHalfScreenComponent", "requireLiteLayout", "setOnRelievedBuyEntryClickListener", "showHalfScreen", "sniffShowContent", "textView", "needPrefix", "(Landroid/widget/TextView;[Ljava/lang/String;Z)Ljava/lang/String;", "sniffShowContent2", "testGuess", "paint", "Landroid/text/TextPaint;", "lineWidth", "guess", "contentHolder", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyUIC$StringHolder;", "(Landroid/text/TextPaint;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyUIC$StringHolder;)Z", "Companion", "RelievedBuyInfoHolder", "StringHolder", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends UIComponent
  implements View.OnClickListener
{
  public static final m.a uct;
  private final j ucA;
  private final j ucB;
  private l ucC;
  an ucu;
  private FrameLayout ucv;
  private View ucw;
  private final j ucx;
  private View ucy;
  private final j ucz;
  
  static
  {
    AppMethodBeat.i(322290);
    uct = new m.a((byte)0);
    AppMethodBeat.o(322290);
  }
  
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(322238);
    this.ucx = k.a(kotlin.o.aiuH, (kotlin.g.a.a)new g(this));
    this.ucz = k.a(kotlin.o.aiuH, (kotlin.g.a.a)new e(this));
    this.ucA = k.a(kotlin.o.aiuH, (kotlin.g.a.a)new d(this));
    this.ucB = k.a(kotlin.o.aiuH, (kotlin.g.a.a)new f(this));
    AppMethodBeat.o(322238);
  }
  
  public static final int a(cqc paramcqc)
  {
    int i = 0;
    AppMethodBeat.i(322278);
    s.u(paramcqc, "profileInfo");
    if (paramcqc.aawH == null)
    {
      AppMethodBeat.o(322278);
      return 0;
    }
    if (paramcqc.aawH.abtt == null)
    {
      AppMethodBeat.o(322278);
      return 0;
    }
    paramcqc = paramcqc.aawH.abtt;
    s.s(paramcqc, "profileInfo.relieved_buy_info.sub_info");
    paramcqc = ((Iterable)paramcqc).iterator();
    while (paramcqc.hasNext())
    {
      eph localeph = (eph)paramcqc.next();
      if (localeph != null) {
        i = 1 << localeph.YZM | i;
      }
    }
    AppMethodBeat.o(322278);
    return i;
  }
  
  private static final void a(TextView paramTextView, m paramm, String[] paramArrayOfString)
  {
    AppMethodBeat.i(322272);
    s.u(paramTextView, "$fullInfoTextView");
    s.u(paramm, "this$0");
    s.u(paramArrayOfString, "$subTypeTitles");
    s.s("", "if (needPrefix) context.…efix)\n            else \"\"");
    paramm = paramm.getContext().getString(ba.i.app_brand_profile_relieved_buy_lite_splitter);
    s.s(paramm, "context.getString(R.stri…lieved_buy_lite_splitter)");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    int k = paramArrayOfString.length - 1;
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localStringBuilder.append(paramArrayOfString[i]);
      localStringBuilder.append(paramm);
      if (j >= k)
      {
        localStringBuilder.append(paramArrayOfString[k]);
        paramm = localStringBuilder.toString();
        s.s(paramm, "StringBuilder().apply(builderAction).toString()");
        paramTextView.setText((CharSequence)paramm);
        AppMethodBeat.o(322272);
        return;
      }
      i = j;
    }
  }
  
  private static final void a(TextView paramTextView, m paramm, String[] paramArrayOfString, LinearLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(322270);
    s.u(paramTextView, "$liteInfoTextView");
    s.u(paramm, "this$0");
    s.u(paramArrayOfString, "$subTypeTitles");
    s.u(paramLayoutParams, "$liteInfoLayoutParams");
    TextPaint localTextPaint = paramTextView.getPaint();
    int i1 = paramTextView.getWidth();
    int i2 = paramTextView.getPaddingLeft();
    int i3 = paramTextView.getPaddingRight();
    String str1 = paramm.getContext().getString(ba.i.app_brand_profile_relieved_buy_lite_prefix);
    s.s(str1, "if (needPrefix) context.…efix)\n            else \"\"");
    String str2 = paramm.getContext().getString(ba.i.app_brand_profile_relieved_buy_lite_suffix_format);
    s.s(str2, "context.getString(R.stri…d_buy_lite_suffix_format)");
    paramm = paramm.getContext().getString(ba.i.app_brand_profile_relieved_buy_lite_splitter);
    s.s(paramm, "context.getString(R.stri…lieved_buy_lite_splitter)");
    m.c localc = new m.c((byte)0);
    int i = paramArrayOfString.length - 1;
    int m;
    Object localObject;
    int i4;
    int j;
    int k;
    if (i >= 0)
    {
      m = i - 1;
      s.s(localTextPaint, "paint");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      i4 = paramArrayOfString.length;
      if (i4 - 1 != i)
      {
        j = 1;
        k = 0;
        if (i <= 0) {}
      }
    }
    for (;;)
    {
      int n = k + 1;
      ((StringBuilder)localObject).append(paramArrayOfString[k]);
      ((StringBuilder)localObject).append(paramm);
      if (n >= i)
      {
        ((StringBuilder)localObject).append(paramArrayOfString[i]);
        if (j != 0)
        {
          String str3 = String.format(str2, Arrays.copyOf(new Object[] { Integer.valueOf(i4) }, 1));
          s.s(str3, "java.lang.String.format(this, *args)");
          ((StringBuilder)localObject).append(str3);
        }
        localObject = ((StringBuilder)localObject).toString();
        s.s(localObject, "StringBuilder().apply(builderAction).toString()");
        localc.value = ((String)localObject);
        if (new StaticLayout((CharSequence)localObject, localTextPaint, i1 - i2 - i3, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
        {
          i = 1;
          label335:
          if (i == 0) {
            break label396;
          }
          paramm = localc.value;
          s.checkNotNull(paramm);
        }
        for (;;)
        {
          paramTextView.setText((CharSequence)paramm);
          paramLayoutParams.width = -2;
          paramLayoutParams.weight = 0.0F;
          paramTextView.setLayoutParams((ViewGroup.LayoutParams)paramLayoutParams);
          AppMethodBeat.o(322270);
          return;
          j = 0;
          break;
          i = 0;
          break label335;
          label396:
          if (m >= 0) {
            break label406;
          }
          paramm = null;
        }
        label406:
        i = m;
        break;
      }
      k = n;
    }
  }
  
  private final void c(epg paramepg)
  {
    AppMethodBeat.i(322249);
    l locall = cLj();
    locall.a(paramepg);
    locall.show();
    AppMethodBeat.o(322249);
  }
  
  private final FrameLayout cLg()
  {
    AppMethodBeat.i(322246);
    FrameLayout localFrameLayout;
    if (this.ucv != null)
    {
      localFrameLayout = this.ucv;
      AppMethodBeat.o(322246);
      return localFrameLayout;
    }
    try
    {
      localFrameLayout = (FrameLayout)getRootView().findViewById(ba.f.profile_relieved_buy_layout_container);
      this.ucv = localFrameLayout;
      localFrameLayout = this.ucv;
      AppMethodBeat.o(322246);
      return localFrameLayout;
    }
    catch (ag localag)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private final View cLh()
  {
    AppMethodBeat.i(322252);
    Object localObject2 = this.ucw;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = LayoutInflater.from((Context)getContext()).inflate(ba.g.app_brand_profile_relieved_buy_lite_layout, (ViewGroup)cLg(), false);
      localObject2 = cLg();
      if (localObject2 != null) {
        ((FrameLayout)localObject2).addView((View)localObject1);
      }
      this.ucw = ((View)localObject1);
    }
    s.checkNotNull(localObject1);
    AppMethodBeat.o(322252);
    return localObject1;
  }
  
  private final View cLi()
  {
    AppMethodBeat.i(322257);
    Object localObject2 = this.ucy;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = LayoutInflater.from((Context)getContext()).inflate(ba.g.app_brand_profile_relieved_buy_full_layout, (ViewGroup)cLg(), false);
      localObject2 = cLg();
      if (localObject2 != null) {
        ((FrameLayout)localObject2).addView((View)localObject1);
      }
      this.ucy = ((View)localObject1);
    }
    s.checkNotNull(localObject1);
    AppMethodBeat.o(322257);
    return localObject1;
  }
  
  private final l cLj()
  {
    AppMethodBeat.i(322260);
    l locall2 = this.ucC;
    l locall1 = locall2;
    if (locall2 == null)
    {
      locall1 = new l((Context)getContext());
      this.ucC = locall1;
    }
    AppMethodBeat.o(322260);
    return locall1;
  }
  
  public final void b(epg paramepg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(322314);
    Object localObject3 = new b((byte)0);
    Object localObject1 = n.ucG;
    localObject1 = n.cLl();
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", s.X("canExposeRelievedBuy, forceExposeRelievedBuy: ", localObject1));
      bool = ((Boolean)localObject1).booleanValue();
      if (bool) {
        break label154;
      }
      Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "isNeedExposeRelievedBuy, can not expose relievedBuy");
      i = 0;
    }
    label149:
    label154:
    label225:
    Object localObject5;
    label300:
    Object localObject6;
    for (;;)
    {
      if (i != 0) {
        break label462;
      }
      paramepg = cLg();
      if (paramepg != null) {
        paramepg.setVisibility(8);
      }
      AppMethodBeat.o(322314);
      return;
      localObject1 = (c)h.ax(c.class);
      if (localObject1 == null) {}
      for (i = 0;; i = ((c)localObject1).a(c.a.znj, 0))
      {
        if (1 != i)
        {
          localObject1 = n.ucG;
          if (!n.cLk()) {
            break label149;
          }
        }
        bool = true;
        break;
      }
      bool = false;
      break;
      if (paramepg == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "isNeedExposeRelievedBuy, relievedBuyInfo is null");
        i = 0;
      }
      else
      {
        localObject1 = paramepg.abtt;
        localObject4 = (Collection)localObject1;
        if ((localObject4 == null) || (((Collection)localObject4).isEmpty())) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label225;
          }
          Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "isNeedExposeRelievedBuy, subInfoList is empty, why?");
          i = 0;
          break;
        }
        s.s(localObject1, "subInfoList");
        localObject1 = (Iterable)localObject1;
        localObject4 = (Collection)new ArrayList();
        localObject5 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = (eph)((Iterator)localObject5).next();
          if (localObject1 == null)
          {
            Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "isNeedExposeRelievedBuy, subInfo is null");
            localObject1 = null;
          }
          label368:
          label371:
          for (;;)
          {
            if (localObject1 != null)
            {
              ((Collection)localObject4).add(localObject1);
              break;
              localObject1 = ((eph)localObject1).title;
              localObject6 = (CharSequence)localObject1;
              if ((localObject6 != null) && (((CharSequence)localObject6).length() != 0)) {
                break label368;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label371;
              }
              Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "isNeedExposeRelievedBuy, title is null");
              localObject1 = null;
              break label300;
              break;
            }
          }
        }
        localObject1 = (List)localObject4;
        if (((List)localObject1).isEmpty())
        {
          Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "isNeedExposeRelievedBuy, subTypeTitles is empty, why?");
          i = 0;
        }
        else
        {
          ((b)localObject3).ucD = paramepg;
          paramepg = ((Collection)localObject1).toArray(new String[0]);
          if (paramepg == null)
          {
            paramepg = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(322314);
            throw paramepg;
          }
          ((b)localObject3).ucE = ((String[])paramepg);
          i = 1;
        }
      }
    }
    label462:
    Object localObject4 = ((b)localObject3).ucD;
    s.checkNotNull(localObject4);
    localObject1 = ((b)localObject3).ucE;
    s.checkNotNull(localObject1);
    paramepg = cLg();
    if (paramepg != null) {
      paramepg.setVisibility(0);
    }
    paramepg = cLg();
    if (paramepg != null) {
      paramepg.setTag(ba.f.app_brand_tag_relieved_buy, localObject4);
    }
    if (1 == ((epg)localObject4).abts)
    {
      Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "configureFullLayout");
      localObject3 = cLi();
      ((View)localObject3).setVisibility(0);
      paramepg = this.ucw;
      if (paramepg != null) {
        paramepg.setVisibility(8);
      }
      ((View)localObject3).setOnClickListener((View.OnClickListener)this);
      com.tencent.mm.ui.tools.o.F((View)localObject3, 0.7F);
      localObject5 = (ImageView)this.ucz.getValue();
      if (localObject5 != null)
      {
        if ((((epg)localObject4).icon_width > 0) && (((epg)localObject4).icon_height > 0))
        {
          paramepg = ((ImageView)localObject5).getLayoutParams();
          paramepg.width = ((int)(((epg)localObject4).icon_width / ((epg)localObject4).icon_height * paramepg.height));
          localObject6 = ah.aiuX;
          ((ImageView)localObject5).setLayoutParams(paramepg);
          localObject6 = new StringBuilder("configureFullLayout, width: ");
          paramepg = ((ImageView)localObject5).getLayoutParams();
          if (paramepg == null)
          {
            paramepg = null;
            localObject6 = ((StringBuilder)localObject6).append(paramepg).append(", height: ");
            paramepg = ((ImageView)localObject5).getLayoutParams();
            if (paramepg != null) {
              break label842;
            }
            paramepg = (epg)localObject2;
            label707:
            Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", paramepg);
          }
        }
        else
        {
          x.c((ImageView)localObject5, ((epg)localObject4).icon_url);
        }
      }
      else
      {
        paramepg = (TextView)this.ucA.getValue();
        if (paramepg != null)
        {
          localObject2 = ((epg)localObject4).abtw;
          localObject4 = (CharSequence)localObject2;
          if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
            break label853;
          }
          i = 1;
          label780:
          if (i != 0) {
            break label858;
          }
          paramepg.setVisibility(0);
          paramepg.setText((CharSequence)localObject2);
        }
      }
      for (;;)
      {
        paramepg = (TextView)this.ucB.getValue();
        if (paramepg != null) {
          break label867;
        }
        Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "configureFullLayout, fullInfoTextView is null");
        AppMethodBeat.o(322314);
        return;
        paramepg = Integer.valueOf(paramepg.width);
        break;
        label842:
        paramepg = Integer.valueOf(paramepg.height);
        break label707;
        label853:
        i = 0;
        break label780;
        label858:
        paramepg.setVisibility(8);
      }
      label867:
      ((View)localObject3).post(new m..ExternalSyntheticLambda0(paramepg, this, (String[])localObject1));
      AppMethodBeat.o(322314);
      return;
    }
    Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "configureLiteLayout");
    localObject2 = cLh();
    ((View)localObject2).setVisibility(0);
    paramepg = this.ucy;
    if (paramepg != null) {
      paramepg.setVisibility(8);
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)this);
    com.tencent.mm.ui.tools.o.F((View)localObject2, 0.7F);
    localObject3 = (TextView)this.ucx.getValue();
    if (localObject3 == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "configureLiteLayout, liteInfoTextView is null");
      AppMethodBeat.o(322314);
      return;
    }
    paramepg = ((TextView)localObject3).getLayoutParams();
    if ((paramepg instanceof LinearLayout.LayoutParams)) {}
    for (paramepg = (LinearLayout.LayoutParams)paramepg; paramepg == null; paramepg = null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "configureLiteLayout, liteInfoLayoutParams is null");
      AppMethodBeat.o(322314);
      return;
    }
    paramepg.width = 0;
    paramepg.weight = 1.0F;
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)paramepg);
    ((View)localObject2).post(new m..ExternalSyntheticLambda1((TextView)localObject3, this, (String[])localObject1, paramepg));
    AppMethodBeat.o(322314);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(322327);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "onClick");
    paramView = this.ucu;
    if (paramView != null) {
      paramView.onClick();
    }
    paramView = cLg();
    if (paramView == null)
    {
      paramView = null;
      if (!(paramView instanceof epg)) {
        break label133;
      }
    }
    label133:
    for (paramView = (epg)paramView;; paramView = null)
    {
      if (paramView != null) {
        break label138;
      }
      Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "onClick, relievedBuyInfo is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(322327);
      return;
      paramView = paramView.getTag(ba.f.app_brand_tag_relieved_buy);
      break;
    }
    label138:
    c(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322327);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(322321);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "onConfigurationChanged");
    paramConfiguration = cLg();
    if (paramConfiguration == null)
    {
      paramConfiguration = null;
      if (!(paramConfiguration instanceof epg)) {
        break label72;
      }
    }
    label72:
    for (paramConfiguration = (epg)paramConfiguration;; paramConfiguration = null)
    {
      if (paramConfiguration != null) {
        break label77;
      }
      AppMethodBeat.o(322321);
      return;
      paramConfiguration = paramConfiguration.getTag(ba.f.app_brand_tag_relieved_buy);
      break;
    }
    label77:
    b(paramConfiguration);
    l locall = this.ucC;
    this.ucC = null;
    if ((locall != null) && (true == locall.ucf.isShowing())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locall.hide();
        c(paramConfiguration);
      }
      AppMethodBeat.o(322321);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(322324);
    super.onDestroy();
    Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyUIC", "onDestroy");
    l locall = this.ucC;
    if (locall != null) {
      locall.hide();
    }
    AppMethodBeat.o(322324);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyUIC$RelievedBuyInfoHolder;", "", "relievedBuyInfo", "Lcom/tencent/mm/protocal/protobuf/RelievedBuyInfo;", "subTypeTitles", "", "", "(Lcom/tencent/mm/protocal/protobuf/RelievedBuyInfo;[Ljava/lang/String;)V", "getRelievedBuyInfo", "()Lcom/tencent/mm/protocal/protobuf/RelievedBuyInfo;", "setRelievedBuyInfo", "(Lcom/tencent/mm/protocal/protobuf/RelievedBuyInfo;)V", "getSubTypeTitles", "()[Ljava/lang/String;", "setSubTypeTitles", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    epg ucD = null;
    String[] ucE = null;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<TextView>
  {
    d(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<TextView>
  {
    g(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */