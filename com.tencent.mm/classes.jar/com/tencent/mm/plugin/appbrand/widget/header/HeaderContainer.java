package com.tencent.mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.ui.MMFragmentActivity;

public abstract class HeaderContainer
  extends RelativeLayout
{
  public HeaderContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void bDF();
  
  public abstract boolean bDs();
  
  public void e(Configuration paramConfiguration) {}
  
  public void es(int paramInt1, int paramInt2) {}
  
  public void et(int paramInt1, int paramInt2) {}
  
  public abstract void g(View paramView1, View paramView2);
  
  public abstract int getAnimationScrollOffset();
  
  public abstract Rect getBackUpFooterRect();
  
  public abstract View getBackgroundGLSurfaceView();
  
  public abstract View getBackgroundGradientView();
  
  public abstract View getEmptyView();
  
  public abstract int getExtraBottomHeight();
  
  public abstract GyroView getGyroView();
  
  public abstract a getHeaderView();
  
  public abstract View getMaskView();
  
  public int getViewHeight()
  {
    return 0;
  }
  
  public void ia(boolean paramBoolean) {}
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public void l(long paramLong, int paramInt) {}
  
  public void m(long paramLong, int paramInt) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setActionBar(View paramView) {}
  
  public abstract void setActivity(MMFragmentActivity paramMMFragmentActivity);
  
  public abstract void setAnimController(c paramc);
  
  public abstract void setDynamicBackgroundView(View paramView);
  
  public abstract void setExtraBottomHeight(int paramInt);
  
  public abstract void setFixedHeight(boolean paramBoolean);
  
  public void wf(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer
 * JD-Core Version:    0.7.0.1
 */