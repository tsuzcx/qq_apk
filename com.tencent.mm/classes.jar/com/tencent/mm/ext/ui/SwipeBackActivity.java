package com.tencent.mm.ext.ui;

import android.app.Activity;
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
  private SwipeBackLayout jRd;
  private View mContentViewForSwipeBack = null;
  private boolean mSwiping;
  
  public final SwipeBackLayout aEb()
  {
    return this.jRd;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(258925);
    SwipeBackLayout localSwipeBackLayout = this.jRd;
    if ((paramKeyEvent.getKeyCode() == 4) && (localSwipeBackLayout != null))
    {
      localSwipeBackLayout.aEc();
      if (localSwipeBackLayout.jRp)
      {
        com.tencent.liteapp.b.b.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event", new Object[0]);
        AppMethodBeat.o(258925);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(258925);
    return bool;
  }
  
  protected final void initSwipeBack()
  {
    AppMethodBeat.i(258926);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    this.jRd = ((SwipeBackLayout)LayoutInflater.from(this).inflate(a.e.wxa_swipeback_layout, localViewGroup, false));
    this.jRd.init();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    View localView = localViewGroup.getChildAt(0);
    localView.setBackgroundResource(17170445);
    localViewGroup.removeView(localView);
    this.jRd.addView(localView);
    this.jRd.setContentView(localView);
    localViewGroup.addView(this.jRd);
    this.jRd.setSwipeGestureDelegate(this);
    AppMethodBeat.o(258926);
  }
  
  public final void onCancel()
  {
    this.mSwiping = false;
  }
  
  public void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(258915);
    super.onCreate(paramBundle, paramPersistableBundle);
    AppMethodBeat.o(258915);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(258924);
    super.onDestroy();
    AppMethodBeat.o(258924);
  }
  
  public final void onDrag()
  {
    this.mSwiping = true;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(258919);
    super.onPause();
    if (this.jRd != null) {
      this.jRd.setEnableGesture(false);
    }
    if (!isFinishing()) {
      d.a(this);
    }
    AppMethodBeat.o(258919);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(258921);
    super.onResume();
    d.b(this);
    onSwipe(1.0F);
    if (this.jRd != null)
    {
      this.jRd.setEnableGesture(true);
      this.jRd.jRp = false;
    }
    AppMethodBeat.o(258921);
  }
  
  public final void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(258928);
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
        AppMethodBeat.o(258928);
        return;
        l = 260L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      b.a(localView, l, localView.getWidth() * -1 / 3.5F, null);
      AppMethodBeat.o(258928);
      return;
      l = 260L;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(258917);
    super.onStart();
    AppMethodBeat.o(258917);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(258923);
    super.onStop();
    AppMethodBeat.o(258923);
  }
  
  public final void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(258927);
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
      b.q(localView, 0.0F);
      AppMethodBeat.o(258927);
      return;
    }
    b.q(localView, localView.getWidth() / 3.5F * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(258927);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(258930);
    if (!isFinishing()) {
      finish();
    }
    getWindow().getDecorView().setVisibility(8);
    overridePendingTransition(0, 0);
    this.mSwiping = false;
    AppMethodBeat.o(258930);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ext.ui.SwipeBackActivity
 * JD-Core Version:    0.7.0.1
 */