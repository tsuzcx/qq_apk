package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a
  extends AppBrandLauncherUI.a
{
  c hkb;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    this.hkb.initView();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.AppBrandLauncherRecommendsList", "onCreate");
    if (this.hkb == null) {
      this.hkb = new a.1(this, getActivity());
    }
    y.i("MicroMsg.AppBrandRecommendUILogic", "onCreate");
    paramBundle = com.tencent.mm.plugin.appbrand.appusage.a.a.adA();
    paramBundle.fKk = 0L;
    paramBundle.fKl = 0L;
    paramBundle.fKn.clear();
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.AppBrandRecommendUILogic", "onDestroy");
    y.i("MicroMsg.AppBrandLauncherRecommendsList", "onDestroy");
  }
  
  public final void onDestroyView()
  {
    super.onDestroyView();
    this.hkb.onDestroyView();
    y.i("MicroMsg.AppBrandLauncherRecommendsList", "onDestroyView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */