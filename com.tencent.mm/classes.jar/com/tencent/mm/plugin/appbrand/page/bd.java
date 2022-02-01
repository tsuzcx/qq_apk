package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.util.Map;

public abstract interface bd
  extends i, cc
{
  public abstract void B(String paramString1, String paramString2);
  
  public abstract void PE();
  
  public abstract boolean PF();
  
  public abstract boolean PG();
  
  public abstract void aD(Context paramContext);
  
  public abstract void cl(int paramInt1, int paramInt2);
  
  public abstract void destroy();
  
  public abstract int getContentHeight();
  
  public abstract View getContentView();
  
  public abstract d getFullscreenImpl();
  
  public abstract int getHeight();
  
  public abstract String getUserAgentString();
  
  public abstract int getWebScrollX();
  
  public abstract int getWebScrollY();
  
  public abstract int getWidth();
  
  public abstract View getWrapperView();
  
  public abstract void i(Runnable paramRunnable);
  
  public abstract void onBackground();
  
  public abstract void onForeground();
  
  public abstract void s(int paramInt, long paramLong);
  
  public abstract void setAppBrandInfo(Map<String, String> paramMap);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setFullscreenImpl(d paramd);
  
  public abstract void setOnScrollChangedListener(au paramau);
  
  public abstract void setOnTrimListener(ar paramar);
  
  public abstract void setVerticalScrollBarEnabled(boolean paramBoolean);
  
  public abstract void setWebViewLayoutListener(aq paramaq);
  
  public abstract void setXWebKeyboardImpl(aw paramaw);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bd
 * JD-Core Version:    0.7.0.1
 */