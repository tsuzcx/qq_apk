package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.r.a.d;

public abstract interface ay
  extends i, bt
{
  public abstract void Dn();
  
  public abstract boolean Do();
  
  public abstract boolean Dp();
  
  public abstract void aw(Context paramContext);
  
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
  
  public abstract void q(int paramInt, long paramLong);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setFullscreenImpl(d paramd);
  
  public abstract void setOnScrollChangedListener(aq paramaq);
  
  public abstract void setOnTrimListener(ao paramao);
  
  public abstract void setVerticalScrollBarEnabled(boolean paramBoolean);
  
  public abstract void setWebViewLayoutListener(an paraman);
  
  public abstract void setXWebKeyboardImpl(as paramas);
  
  public abstract void x(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ay
 * JD-Core Version:    0.7.0.1
 */