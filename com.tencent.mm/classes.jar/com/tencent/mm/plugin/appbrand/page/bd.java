package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.s.a.d;

public abstract interface bd
  extends i, bz
{
  public abstract void Ck();
  
  public abstract boolean Cl();
  
  public abstract void av(Context paramContext);
  
  public abstract void destroy();
  
  public abstract int getContentHeight();
  
  public abstract View getContentView();
  
  public abstract d getFullscreenImpl();
  
  public abstract int getHeight();
  
  public abstract String getUrl();
  
  public abstract String getUserAgentString();
  
  public abstract int getWebScrollX();
  
  public abstract int getWebScrollY();
  
  public abstract int getWidth();
  
  public abstract View getWrapperView();
  
  public abstract void j(Runnable paramRunnable);
  
  public abstract void onBackground();
  
  public abstract void onForeground();
  
  public abstract void r(int paramInt, long paramLong);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setFullscreenImpl(d paramd);
  
  public abstract void setOnScrollChangedListener(av paramav);
  
  public abstract void setOnTrimListener(at paramat);
  
  public abstract void setVerticalScrollBarEnabled(boolean paramBoolean);
  
  public abstract void setWebViewLayoutListener(as paramas);
  
  public abstract void setXWebKeyboardImpl(ax paramax);
  
  public abstract void u(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bd
 * JD-Core Version:    0.7.0.1
 */