package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.a.b;
import com.tencent.luggage.wxa.a.c;
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

public class AppBrandTabBarItem
  extends RelativeLayout
{
  public AppBrandTabBarItem(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(324122);
    init();
    AppMethodBeat.o(324122);
  }
  
  public AppBrandTabBarItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(324128);
    init();
    AppMethodBeat.o(324128);
  }
  
  private void init()
  {
    AppMethodBeat.i(324135);
    Object localObject1 = getContext();
    Object localObject2 = new LinearLayout.LayoutParams(0, 0);
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    setLayoutParams((ViewGroup.LayoutParams)localObject2);
    setId(a.d.app_brand_tab_bar_item_container);
    boolean bool = a.mq(getContext());
    Log.d("MicroMsg.AppBrandPageTabBar", "init, useLargerText: ".concat(String.valueOf(bool)));
    localObject2 = new LinearLayout((Context)localObject1);
    ((LinearLayout)localObject2).setId(a.d.app_brand_tab_bar_item_icon_text);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setGravity(1);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView((Context)localObject1);
    ((ImageView)localObject3).setId(a.d.app_brand_tab_bar_item_icon);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (bool)
    {
      i = a.fromDPToPix(getContext(), 34);
      ((ImageView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(i, i));
      ((LinearLayout)localObject2).addView((View)localObject3);
      localObject3 = new TextView((Context)localObject1);
      ((TextView)localObject3).setId(a.d.app_brand_tab_bar_item_text);
      ((TextView)localObject3).setTextSize(0, a.bs((Context)localObject1, a.b.SmallestTextSize) * a.jO(getContext()));
      ((TextView)localObject3).setPadding(a.bs((Context)localObject1, a.b.Edge_0_5_A), 0, a.bs((Context)localObject1, a.b.Edge_0_5_A), 0);
      ((TextView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((LinearLayout)localObject2).addView((View)localObject3);
      addView((View)localObject2);
      localObject2 = new TextView((Context)localObject1);
      ((TextView)localObject2).setId(a.d.app_brand_tab_bar_item_badge);
      ((TextView)localObject2).setTextSize(0, a.bs((Context)localObject1, a.b.SmallerTextSize) * a.jO(getContext()));
      ((TextView)localObject2).setBackground(a.m((Context)localObject1, a.c.app_brand_tab_bar_badge));
      ((TextView)localObject2).setTextAppearance((Context)localObject1, a.h.UnreadCountTipsStyle);
      ((TextView)localObject2).setGravity(17);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, a.d.app_brand_tab_bar_item_icon_text);
      ((RelativeLayout.LayoutParams)localObject3).addRule(17, a.d.app_brand_tab_bar_item_icon_text);
      if (!bool) {
        break label617;
      }
      i = a.fromDPToPix(getContext(), -12);
      label393:
      ((RelativeLayout.LayoutParams)localObject3).setMarginStart(i);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      addView((View)localObject2);
      localObject2 = new ImageView((Context)localObject1);
      ((ImageView)localObject2).setId(a.d.app_brand_tab_bar_item_red_dot);
      ((ImageView)localObject2).setBackground(a.m((Context)localObject1, a.c.unread_dot_shape));
      localObject3 = new RelativeLayout.LayoutParams(a.bs((Context)localObject1, a.b.Edge_1_5_A), a.bs((Context)localObject1, a.b.Edge_1_5_A));
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, a.d.app_brand_tab_bar_item_icon_text);
      ((RelativeLayout.LayoutParams)localObject3).addRule(19, a.d.app_brand_tab_bar_item_icon_text);
      if (!bool) {
        break label630;
      }
    }
    label617:
    label630:
    for (int i = a.fromDPToPix(getContext(), -1);; i = a.fromDPToPix(getContext(), -3))
    {
      ((RelativeLayout.LayoutParams)localObject3).setMarginEnd(i);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = a.fromDPToPix((Context)localObject1, 1);
      ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      addView((View)localObject2);
      localObject2 = new View((Context)localObject1);
      ((View)localObject2).setId(a.d.app_brand_tab_bar_item_indicator);
      localObject1 = new RelativeLayout.LayoutParams(-1, a.bs((Context)localObject1, a.b.Edge_0_5_A));
      ((RelativeLayout.LayoutParams)localObject1).addRule(18, a.d.app_brand_tab_bar_item_icon_text);
      ((RelativeLayout.LayoutParams)localObject1).addRule(19, a.d.app_brand_tab_bar_item_icon_text);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      addView((View)localObject2);
      AppMethodBeat.o(324135);
      return;
      i = a.fromDPToPix(getContext(), 28);
      break;
      i = a.fromDPToPix(getContext(), -8);
      break label393;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem
 * JD-Core Version:    0.7.0.1
 */