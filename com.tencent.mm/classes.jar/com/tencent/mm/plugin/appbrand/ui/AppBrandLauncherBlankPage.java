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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.report.h;

public final class AppBrandLauncherBlankPage
  extends AppBrandLauncherUI.Fragment
{
  public static ViewGroup W(Context paramContext, String paramString)
  {
    AppMethodBeat.i(48622);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject1 = new ImageView(paramContext);
    ((ImageView)localObject1).setImageResource(2131689622);
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
    AppMethodBeat.o(48622);
    return localLinearLayout;
  }
  
  public static AppBrandLauncherBlankPage eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48619);
    AppBrandLauncherBlankPage localAppBrandLauncherBlankPage = new AppBrandLauncherBlankPage();
    Bundle localBundle = new Bundle(2);
    localBundle.putString("extra_title", paramString1);
    localBundle.putString("extra_tip", paramString2);
    localAppBrandLauncherBlankPage.setArguments(localBundle);
    AppMethodBeat.o(48619);
    return localAppBrandLauncherBlankPage;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(48621);
    FragmentActivity localFragmentActivity = getActivity();
    if (getArguments() == null) {}
    for (Object localObject = null;; localObject = getArguments().getString("extra_tip"))
    {
      localObject = W(localFragmentActivity, (String)localObject);
      ((ViewGroup)this.mContentView).addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      h.a(this.mScene, "", "", 0, "", this.mBR);
      AppMethodBeat.o(48621);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48620);
    super.onResume();
    FragmentActivity localFragmentActivity;
    if (getActivity() != null)
    {
      localFragmentActivity = getActivity();
      if (getArguments() != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = getArguments().getString("extra_title"))
    {
      localFragmentActivity.setTitle(str);
      AppMethodBeat.o(48620);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage
 * JD-Core Version:    0.7.0.1
 */