package com.tencent.mm.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwipeBackActivity
  extends AppCompatActivity
  implements SwipeBackLayout.a, d.a
{
  protected SwipeBackLayout hfl;
  private View mContentViewForSwipeBack = null;
  private boolean mSwiping;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(197832);
    SwipeBackLayout localSwipeBackLayout = this.hfl;
    if ((paramKeyEvent.getKeyCode() == 4) && (localSwipeBackLayout != null))
    {
      localSwipeBackLayout.awK();
      if (localSwipeBackLayout.hfx)
      {
        com.tencent.liteapp.b.b.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event", new Object[0]);
        AppMethodBeat.o(197832);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(197832);
    return bool;
  }
  
  public final void onCancel()
  {
    this.mSwiping = false;
  }
  
  public void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(197826);
    super.onCreate(paramBundle, paramPersistableBundle);
    AppMethodBeat.o(197826);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(197831);
    super.onDestroy();
    AppMethodBeat.o(197831);
  }
  
  public final void onDrag()
  {
    this.mSwiping = true;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(197828);
    super.onPause();
    if (this.hfl != null) {
      this.hfl.setEnableGesture(false);
    }
    if (!isFinishing()) {
      d.a(this);
    }
    AppMethodBeat.o(197828);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(197829);
    super.onResume();
    d.b(this);
    onSwipe(1.0F);
    if (this.hfl != null)
    {
      this.hfl.setEnableGesture(true);
      this.hfl.hfx = false;
    }
    AppMethodBeat.o(197829);
  }
  
  public final void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(197834);
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
        AppMethodBeat.o(197834);
        return;
        l = 260L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      b.a(localView, l, localView.getWidth() * -1 / 3.5F, null);
      AppMethodBeat.o(197834);
      return;
      l = 260L;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(197827);
    super.onStart();
    AppMethodBeat.o(197827);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(197830);
    super.onStop();
    AppMethodBeat.o(197830);
  }
  
  public final void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(197833);
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
      AppMethodBeat.o(197833);
      return;
    }
    b.q(localView, localView.getWidth() / 3.5F * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(197833);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(197835);
    if (!isFinishing()) {
      finish();
    }
    getWindow().getDecorView().setVisibility(8);
    overridePendingTransition(0, 0);
    this.mSwiping = false;
    AppMethodBeat.o(197835);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ext.ui.SwipeBackActivity
 * JD-Core Version:    0.7.0.1
 */