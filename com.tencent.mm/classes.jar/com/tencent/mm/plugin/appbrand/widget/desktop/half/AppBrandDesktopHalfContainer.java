package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.c;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.ui.MMFragmentActivity;

public class AppBrandDesktopHalfContainer
  extends HeaderContainer
  implements View.OnTouchListener, c.a
{
  private GyroView jcR;
  private c jdo;
  private Rect jdr;
  private AppBrandDesktopHalfView jhE;
  private View xy;
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134115);
    this.jdr = new Rect();
    init(paramContext);
    AppMethodBeat.o(134115);
  }
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134116);
    this.jdr = new Rect();
    init(paramContext);
    AppMethodBeat.o(134116);
  }
  
  private void dt(Context paramContext)
  {
    AppMethodBeat.i(134119);
    this.jcR = new GyroView(paramContext);
    paramContext = new FrameLayout.LayoutParams((int)getResources().getDimension(2131428452), (int)getResources().getDimension(2131428451));
    paramContext.gravity = 81;
    this.jcR.setId(2131820627);
    this.jcR.setVisibility(8);
    addView(this.jcR, paramContext);
    AppMethodBeat.o(134119);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(134118);
    this.jhE = new AppBrandDesktopHalfView(paramContext);
    this.jhE.setId(2131820554);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    this.jhE.setLayoutParams(localLayoutParams);
    this.xy = this.jhE.findViewById(2131821191);
    addView(this.jhE);
    dt(paramContext);
    AppMethodBeat.o(134118);
  }
  
  public final boolean aOY()
  {
    return false;
  }
  
  public final void aPm() {}
  
  public final void aPx() {}
  
  public final void aPy() {}
  
  public final void e(View paramView1, View paramView2) {}
  
  public int getAnimationScrollOffset()
  {
    return 0;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.jdr;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    return null;
  }
  
  public View getBackgroundGradientView()
  {
    return null;
  }
  
  public View getEmptyView()
  {
    return this.xy;
  }
  
  public int getExtraBottomHeight()
  {
    return 0;
  }
  
  public GyroView getGyroView()
  {
    return this.jcR;
  }
  
  public a getHeaderView()
  {
    return this.jhE;
  }
  
  public View getMaskView()
  {
    return null;
  }
  
  public final boolean isFullScreen()
  {
    if (this.jhE != null) {}
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134117);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(134117);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(134124);
    super.onPause();
    if (this.jhE != null) {
      this.jhE.cvo = true;
    }
    AppMethodBeat.o(134124);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(134123);
    super.onResume();
    if (this.jhE != null)
    {
      AppBrandDesktopHalfView localAppBrandDesktopHalfView = this.jhE;
      localAppBrandDesktopHalfView.cvo = false;
      localAppBrandDesktopHalfView.setLayoutFrozen(false);
      localAppBrandDesktopHalfView.postDelayed(new AppBrandDesktopHalfView.14(localAppBrandDesktopHalfView), 10L);
    }
    AppMethodBeat.o(134123);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void qb(int paramInt)
  {
    AppMethodBeat.i(134121);
    if (this.jhE != null) {
      this.jhE.qb(paramInt);
    }
    AppMethodBeat.o(134121);
  }
  
  public final void qc(int paramInt)
  {
    AppMethodBeat.i(134122);
    qb(paramInt);
    AppMethodBeat.o(134122);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity) {}
  
  public void setAnimController(c paramc)
  {
    AppMethodBeat.i(134120);
    this.jdo = paramc;
    if (this.jdo != null) {
      this.jdo.a(this);
    }
    AppMethodBeat.o(134120);
  }
  
  public void setDynamicBackgroundView(View paramView) {}
  
  public void setExtraBottomHeight(int paramInt) {}
  
  public void setFixedHeight(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfContainer
 * JD-Core Version:    0.7.0.1
 */