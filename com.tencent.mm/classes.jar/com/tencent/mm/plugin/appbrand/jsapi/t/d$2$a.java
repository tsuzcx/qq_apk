package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2$a
  implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener
{
  View bJW;
  TouchDelegate moo;
  View mop;
  
  d$2$a(final d.2 param2, View paramView)
  {
    AppMethodBeat.i(138266);
    paramView.addOnAttachStateChangeListener(this);
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.mop = paramView;
    AppMethodBeat.o(138266);
  }
  
  private void bIv()
  {
    AppMethodBeat.i(138270);
    if ((this.bJW != null) && (u.aD(this.mop)))
    {
      Object localObject = new Rect(0, 0, this.bJW.getWidth(), this.bJW.getHeight());
      View localView = this.bJW;
      localObject = new TouchDelegate((Rect)localObject, this.mop);
      this.moo = ((TouchDelegate)localObject);
      localView.setTouchDelegate((TouchDelegate)localObject);
    }
    AppMethodBeat.o(138270);
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(138269);
    bIv();
    AppMethodBeat.o(138269);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(138267);
    this.bJW = ((View)paramView.getParent());
    bIv();
    this.bJW.addOnLayoutChangeListener(this);
    AppMethodBeat.o(138267);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(138268);
    if ((this.bJW != null) && (this.bJW.getTouchDelegate() == this.moo)) {
      this.bJW.setTouchDelegate(null);
    }
    if (this.bJW != null) {
      this.bJW.removeOnLayoutChangeListener(this);
    }
    AppMethodBeat.o(138268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.d.2.a
 * JD-Core Version:    0.7.0.1
 */