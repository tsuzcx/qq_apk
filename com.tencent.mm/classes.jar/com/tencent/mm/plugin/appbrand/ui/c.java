package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.y.i;

public final class c
  extends AppBrandLauncherUI.a
{
  public static ViewGroup S(Context paramContext, String paramString)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject1 = new ImageView(paramContext);
    ((ImageView)localObject1).setImageResource(y.i.app_brand_launcher_blank_tip_icon);
    Object localObject2 = new LinearLayout.LayoutParams(a.fromDPToPix(paramContext, 50), a.fromDPToPix(paramContext, 50));
    ((LinearLayout.LayoutParams)localObject2).topMargin = a.fromDPToPix(paramContext, 91);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#B2B2B2"));
    ((TextView)localObject2).setGravity(17);
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.topMargin = a.fromDPToPix(paramContext, 16);
    paramString.gravity = 1;
    localLinearLayout.addView((View)localObject2, paramString);
    return localLinearLayout;
  }
  
  public static c ce(String paramString1, String paramString2)
  {
    c localc = new c();
    Bundle localBundle = new Bundle(2);
    localBundle.putString("extra_title", paramString1);
    localBundle.putString("extra_tip", paramString2);
    localc.setArguments(localBundle);
    return localc;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (getArguments() == null) {}
    for (Object localObject = null;; localObject = getArguments().getString("extra_tip"))
    {
      localObject = S(localFragmentActivity, (String)localObject);
      ((ViewGroup)this.QR).addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      com.tencent.mm.plugin.appbrand.report.c.a(this.fzn, "", "", 0, "", this.hda);
      return;
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    FragmentActivity localFragmentActivity;
    if (getActivity() != null)
    {
      localFragmentActivity = getActivity();
      if (getArguments() != null) {
        break label32;
      }
    }
    label32:
    for (String str = "";; str = getArguments().getString("extra_title"))
    {
      localFragmentActivity.setTitle(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */