package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class AppBrandLauncherUI$Fragment
  extends Fragment
{
  public View Qz;
  private final ak iMP = new ak(Looper.getMainLooper());
  public String iMQ;
  public int mScene;
  
  public void aMd() {}
  
  public final <T extends View> T aMe()
  {
    return this.Qz.findViewById(16908298);
  }
  
  public final View getContentView()
  {
    return this.Qz;
  }
  
  public abstract int getLayoutId();
  
  public abstract void initView();
  
  @SuppressLint({"ResourceType"})
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (getLayoutId() < 0) {}
    for (this.Qz = new FrameLayout(paramViewGroup.getContext());; this.Qz = paramLayoutInflater.inflate(getLayoutId(), null))
    {
      initView();
      return this.Qz;
    }
  }
  
  public final void postOnUiThread(Runnable paramRunnable)
  {
    this.iMP.post(paramRunnable);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isDestroyed())) {
      return;
    }
    localFragmentActivity.runOnUiThread(paramRunnable);
  }
  
  public void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
 * JD-Core Version:    0.7.0.1
 */