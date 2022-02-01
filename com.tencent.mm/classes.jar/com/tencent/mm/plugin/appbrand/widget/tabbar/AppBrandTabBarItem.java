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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public class AppBrandTabBarItem
  extends RelativeLayout
{
  public AppBrandTabBarItem(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194549);
    init();
    AppMethodBeat.o(194549);
  }
  
  public AppBrandTabBarItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194550);
    init();
    AppMethodBeat.o(194550);
  }
  
  private void init()
  {
    AppMethodBeat.i(194551);
    Object localObject1 = getContext();
    Object localObject2 = new LinearLayout.LayoutParams(0, 0);
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    setId(2131307143);
    localObject2 = new LinearLayout((Context)localObject1);
    ((LinearLayout)localObject2).setId(2131307145);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setGravity(1);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView((Context)localObject1);
    ((ImageView)localObject3).setId(2131307144);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(a.fromDPToPix((Context)localObject1, 28), a.fromDPToPix((Context)localObject1, 28)));
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView((Context)localObject1);
    ((TextView)localObject3).setId(2131307148);
    ((TextView)localObject3).setTextSize(a.fromDPToPix((Context)localObject1, 12));
    ((TextView)localObject3).setPadding(a.fromDPToPix((Context)localObject1, 4), 0, a.fromDPToPix((Context)localObject1, 4), 0);
    ((TextView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    ((LinearLayout)localObject2).addView((View)localObject3);
    addView((View)localObject2);
    localObject2 = new TextView((Context)localObject1);
    ((TextView)localObject2).setId(2131307142);
    ((TextView)localObject2).setTextSize(a.fromDPToPix((Context)localObject1, 13));
    ((TextView)localObject2).setBackground(a.l((Context)localObject1, 2131231029));
    ((TextView)localObject2).setTextAppearance((Context)localObject1, 2131821489);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131307145);
    ((RelativeLayout.LayoutParams)localObject3).addRule(17, 2131307145);
    ((RelativeLayout.LayoutParams)localObject3).setMarginStart(a.ao((Context)localObject1, 2131165860));
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    addView((View)localObject2);
    localObject2 = new ImageView((Context)localObject1);
    ((ImageView)localObject2).setId(2131307147);
    ((ImageView)localObject2).setBackground(a.l((Context)localObject1, 2131234447));
    localObject3 = new RelativeLayout.LayoutParams(a.fromDPToPix((Context)localObject1, 10), a.fromDPToPix((Context)localObject1, 10));
    ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131307145);
    ((RelativeLayout.LayoutParams)localObject3).addRule(17, 2131307145);
    ((RelativeLayout.LayoutParams)localObject3).setMarginStart(a.ao((Context)localObject1, 2131165861));
    ((RelativeLayout.LayoutParams)localObject3).topMargin = a.fromDPToPix((Context)localObject1, 1);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    addView((View)localObject2);
    localObject2 = new View((Context)localObject1);
    ((View)localObject2).setId(2131307146);
    localObject1 = new RelativeLayout.LayoutParams(-1, a.fromDPToPix((Context)localObject1, 3));
    ((RelativeLayout.LayoutParams)localObject1).addRule(18, 2131307145);
    ((RelativeLayout.LayoutParams)localObject1).addRule(19, 2131307145);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    addView((View)localObject2);
    AppMethodBeat.o(194551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem
 * JD-Core Version:    0.7.0.1
 */