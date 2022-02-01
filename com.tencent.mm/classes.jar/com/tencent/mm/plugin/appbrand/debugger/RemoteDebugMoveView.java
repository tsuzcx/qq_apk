package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class RemoteDebugMoveView
  extends FrameLayout
{
  int aMZ;
  int dqH;
  float fif;
  float fig;
  float rec;
  float ree;
  
  public RemoteDebugMoveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RemoteDebugMoveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(147042);
    super.onConfigurationChanged(paramConfiguration);
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      private int evg = 0;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(147040);
        int i = this.evg + 1;
        this.evg = i;
        if (i < 2)
        {
          AppMethodBeat.o(147040);
          return;
        }
        RemoteDebugMoveView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        RemoteDebugMoveView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147039);
            if ((RemoteDebugMoveView.this.getParent() instanceof View))
            {
              View localView = (View)RemoteDebugMoveView.this.getParent();
              RemoteDebugMoveView.a(RemoteDebugMoveView.this, localView.getMeasuredWidth());
              RemoteDebugMoveView.b(RemoteDebugMoveView.this, localView.getMeasuredHeight());
              float f1 = Math.max(0.0F, Math.min(RemoteDebugMoveView.a(RemoteDebugMoveView.this) - RemoteDebugMoveView.this.getWidth(), RemoteDebugMoveView.this.getX()));
              float f2 = Math.max(0.0F, Math.min(RemoteDebugMoveView.c(RemoteDebugMoveView.this) - RemoteDebugMoveView.this.getHeight(), RemoteDebugMoveView.this.getY()));
              RemoteDebugMoveView.this.setX(f1);
              RemoteDebugMoveView.this.setY(f2);
              RemoteDebugMoveView.this.requestLayout();
            }
            AppMethodBeat.o(147039);
          }
        });
        AppMethodBeat.o(147040);
      }
    });
    AppMethodBeat.o(147042);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(147043);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(147043);
      return true;
      this.fif = paramMotionEvent.getRawX();
      this.fig = paramMotionEvent.getRawY();
      continue;
      this.rec = paramMotionEvent.getRawX();
      this.ree = paramMotionEvent.getRawY();
      float f1 = getX() + (this.rec - this.fif);
      if ((0.0F < f1) && (f1 < this.aMZ - getWidth())) {
        setX(f1);
      }
      f1 = this.ree - this.fig;
      float f2 = this.dqH - getHeight();
      float f3 = getY() + f1;
      if (((0.0F < f3) && (f3 < f2)) || ((f3 <= 0.0F) && (f1 > 0.0F)) || ((f3 >= f2) && (f1 < 0.0F))) {
        setY(f3);
      }
      this.fif = this.rec;
      this.fig = this.ree;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView
 * JD-Core Version:    0.7.0.1
 */