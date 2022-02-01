package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mm.sdk.platformtools.MMHandler;

public abstract class AppBrandLauncherUI$Fragment
  extends Fragment
{
  private View mContentView;
  public int mScene;
  private final MMHandler ntw = new MMHandler(Looper.getMainLooper());
  public String qVt;
  
  protected void a(Intent paramIntent, int paramInt) {}
  
  public void cjF() {}
  
  public final <T extends View> T cjG()
  {
    return this.mContentView.findViewById(16908298);
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  public abstract int getLayoutId();
  
  public abstract void initView();
  
  @SuppressLint({"ResourceType"})
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (getLayoutId() < 0) {}
    for (this.mContentView = new FrameLayout(paramViewGroup.getContext());; this.mContentView = paramLayoutInflater.inflate(getLayoutId(), null))
    {
      initView();
      return this.mContentView;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.ntw.removeCallbacksAndMessages(null);
  }
  
  public final void postOnUiThread(Runnable paramRunnable)
  {
    this.ntw.post(paramRunnable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
 * JD-Core Version:    0.7.0.1
 */