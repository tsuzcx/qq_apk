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
import com.tencent.mm.cb.a;

public class AppBrandTabBarItem
  extends RelativeLayout
{
  public AppBrandTabBarItem(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(219636);
    init();
    AppMethodBeat.o(219636);
  }
  
  public AppBrandTabBarItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(219637);
    init();
    AppMethodBeat.o(219637);
  }
  
  private void init()
  {
    AppMethodBeat.i(219638);
    Object localObject1 = getContext();
    Object localObject2 = new LinearLayout.LayoutParams(0, 0);
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    setId(2131296920);
    localObject2 = new LinearLayout((Context)localObject1);
    ((LinearLayout)localObject2).setId(2131296922);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setGravity(1);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView((Context)localObject1);
    ((ImageView)localObject3).setId(2131296921);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(a.aG((Context)localObject1, 2131165300), a.aG((Context)localObject1, 2131165300)));
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView((Context)localObject1);
    ((TextView)localObject3).setId(2131296925);
    ((TextView)localObject3).setTextSize(1, a.aG((Context)localObject1, 2131165594));
    ((TextView)localObject3).setPadding(a.aG((Context)localObject1, 2131165277), 0, a.aG((Context)localObject1, 2131165277), 0);
    ((TextView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    ((LinearLayout)localObject2).addView((View)localObject3);
    addView((View)localObject2);
    localObject2 = new TextView((Context)localObject1);
    ((TextView)localObject2).setId(2131296919);
    ((TextView)localObject2).setTextSize(1, a.aG((Context)localObject1, 2131165592));
    ((TextView)localObject2).setBackground(a.l((Context)localObject1, 2131231061));
    ((TextView)localObject2).setTextAppearance((Context)localObject1, 2131821535);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131296922);
    ((RelativeLayout.LayoutParams)localObject3).addRule(17, 2131296922);
    ((RelativeLayout.LayoutParams)localObject3).setMarginStart(a.aG((Context)localObject1, 2131165886));
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    addView((View)localObject2);
    localObject2 = new ImageView((Context)localObject1);
    ((ImageView)localObject2).setId(2131296924);
    ((ImageView)localObject2).setBackground(a.l((Context)localObject1, 2131235385));
    localObject3 = new RelativeLayout.LayoutParams(a.aG((Context)localObject1, 2131165289), a.aG((Context)localObject1, 2131165289));
    ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131296922);
    ((RelativeLayout.LayoutParams)localObject3).addRule(17, 2131296922);
    ((RelativeLayout.LayoutParams)localObject3).setMarginStart(a.aG((Context)localObject1, 2131165887));
    ((RelativeLayout.LayoutParams)localObject3).topMargin = a.fromDPToPix((Context)localObject1, 1);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    addView((View)localObject2);
    localObject2 = new View((Context)localObject1);
    ((View)localObject2).setId(2131296923);
    localObject1 = new RelativeLayout.LayoutParams(-1, a.aG((Context)localObject1, 2131165277));
    ((RelativeLayout.LayoutParams)localObject1).addRule(18, 2131296922);
    ((RelativeLayout.LayoutParams)localObject1).addRule(19, 2131296922);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    addView((View)localObject2);
    AppMethodBeat.o(219638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem
 * JD-Core Version:    0.7.0.1
 */