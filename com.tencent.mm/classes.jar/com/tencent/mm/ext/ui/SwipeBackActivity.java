package com.tencent.mm.ext.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.liteapp.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwipeBackActivity
  extends AppCompatActivity
  implements SwipeBackLayout.a, d.a
{
  private View mContentViewForSwipeBack = null;
  private boolean mSwiping;
  private SwipeBackLayout mqn;
  
  public final SwipeBackLayout aXf()
  {
    return this.mqn;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(235388);
    SwipeBackLayout localSwipeBackLayout = this.mqn;
    if ((paramKeyEvent.getKeyCode() == 4) && (localSwipeBackLayout != null))
    {
      localSwipeBackLayout.aXg();
      if (localSwipeBackLayout.mqz)
      {
        com.tencent.liteapp.b.b.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event", new Object[0]);
        AppMethodBeat.o(235388);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(235388);
    return bool;
  }
  
  public final boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  protected final void initSwipeBack()
  {
    AppMethodBeat.i(235398);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    this.mqn = ((SwipeBackLayout)LayoutInflater.from(this).inflate(a.e.wxa_swipeback_layout, localViewGroup, false));
    this.mqn.init();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    View localView = localViewGroup.getChildAt(0);
    localView.setBackgroundResource(17170445);
    localViewGroup.removeView(localView);
    this.mqn.addView(localView);
    this.mqn.setContentView(localView);
    localViewGroup.addView(this.mqn);
    this.mqn.setSwipeGestureDelegate(this);
    AppMethodBeat.o(235398);
  }
  
  public final void onCancel()
  {
    this.mSwiping = false;
  }
  
  public void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(235357);
    super.onCreate(paramBundle, paramPersistableBundle);
    AppMethodBeat.o(235357);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(235383);
    super.onDestroy();
    AppMethodBeat.o(235383);
  }
  
  public final void onDrag()
  {
    this.mSwiping = true;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(235371);
    super.onPause();
    if (this.mqn != null) {
      this.mqn.setEnableGesture(false);
    }
    if (!isFinishing()) {
      d.a(this);
    }
    AppMethodBeat.o(235371);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(235375);
    super.onResume();
    d.b(this);
    onSwipe(1.0F);
    if (this.mqn != null)
    {
      this.mqn.setEnableGesture(true);
      this.mqn.mqz = false;
    }
    AppMethodBeat.o(235375);
  }
  
  public final void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(235419);
    if (this.mContentViewForSwipeBack == null) {
      this.mContentViewForSwipeBack = e.a(getWindow(), getSupportActionBar().getCustomView());
    }
    View localView = this.mContentViewForSwipeBack;
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        b.a(localView, l, 0.0F, null);
        AppMethodBeat.o(235419);
        return;
        l = 260L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      b.a(localView, l, localView.getWidth() * -1 / 3.5F, null);
      AppMethodBeat.o(235419);
      return;
      l = 260L;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(235363);
    super.onStart();
    AppMethodBeat.o(235363);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(235380);
    super.onStop();
    AppMethodBeat.o(235380);
  }
  
  public final void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(235413);
    Window localWindow;
    if (this.mContentViewForSwipeBack == null)
    {
      localWindow = getWindow();
      if (getSupportActionBar() == null) {
        break label65;
      }
    }
    label65:
    for (View localView = getSupportActionBar().getCustomView();; localView = null)
    {
      this.mContentViewForSwipeBack = e.a(localWindow, localView);
      localView = this.mContentViewForSwipeBack;
      if (Float.compare(1.0F, paramFloat) > 0) {
        break;
      }
      b.r(localView, 0.0F);
      AppMethodBeat.o(235413);
      return;
    }
    b.r(localView, localView.getWidth() / 3.5F * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(235413);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(235430);
    if (!isFinishing()) {
      finish();
    }
    getWindow().getDecorView().setVisibility(8);
    overridePendingTransition(0, 0);
    this.mSwiping = false;
    AppMethodBeat.o(235430);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ext.ui.SwipeBackActivity
 * JD-Core Version:    0.7.0.1
 */