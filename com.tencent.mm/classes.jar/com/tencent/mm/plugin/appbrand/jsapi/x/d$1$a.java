package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1$a
  implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener
{
  View dnj;
  TouchDelegate srn;
  View sro;
  
  d$1$a(final d.1 param1, View paramView)
  {
    AppMethodBeat.i(325922);
    paramView.addOnAttachStateChangeListener(this);
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.sro = paramView;
    AppMethodBeat.o(325922);
  }
  
  private void cup()
  {
    AppMethodBeat.i(325925);
    if ((this.dnj != null) && (z.ay(this.sro)))
    {
      Object localObject = new Rect(0, 0, this.dnj.getWidth(), this.dnj.getHeight());
      View localView = this.dnj;
      localObject = new TouchDelegate((Rect)localObject, this.sro);
      this.srn = ((TouchDelegate)localObject);
      localView.setTouchDelegate((TouchDelegate)localObject);
    }
    AppMethodBeat.o(325925);
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(325929);
    cup();
    AppMethodBeat.o(325929);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(325927);
    this.dnj = ((View)paramView.getParent());
    cup();
    this.dnj.addOnLayoutChangeListener(this);
    AppMethodBeat.o(325927);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(325928);
    if ((this.dnj != null) && (this.dnj.getTouchDelegate() == this.srn)) {
      this.dnj.setTouchDelegate(null);
    }
    if (this.dnj != null) {
      this.dnj.removeOnLayoutChangeListener(this);
    }
    AppMethodBeat.o(325928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.d.1.a
 * JD-Core Version:    0.7.0.1
 */