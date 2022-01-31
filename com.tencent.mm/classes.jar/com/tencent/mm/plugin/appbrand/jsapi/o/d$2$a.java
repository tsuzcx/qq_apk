package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Rect;
import android.support.v4.view.t;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2$a
  implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener
{
  View bdK;
  TouchDelegate hXM;
  View hXN;
  
  d$2$a(d.2 param2, View paramView)
  {
    AppMethodBeat.i(141764);
    paramView.addOnAttachStateChangeListener(this);
    paramView.setOnTouchListener(new d.2.a.1(this, param2));
    this.hXN = paramView;
    AppMethodBeat.o(141764);
  }
  
  private void aEx()
  {
    AppMethodBeat.i(141768);
    if ((this.bdK != null) && (t.aw(this.hXN)))
    {
      Object localObject = new Rect(0, 0, this.bdK.getWidth(), this.bdK.getHeight());
      View localView = this.bdK;
      localObject = new TouchDelegate((Rect)localObject, this.hXN);
      this.hXM = ((TouchDelegate)localObject);
      localView.setTouchDelegate((TouchDelegate)localObject);
    }
    AppMethodBeat.o(141768);
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(141767);
    aEx();
    AppMethodBeat.o(141767);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(141765);
    this.bdK = ((View)paramView.getParent());
    aEx();
    this.bdK.addOnLayoutChangeListener(this);
    AppMethodBeat.o(141765);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(141766);
    if ((this.bdK != null) && (this.bdK.getTouchDelegate() == this.hXM)) {
      this.bdK.setTouchDelegate(null);
    }
    if (this.bdK != null) {
      this.bdK.removeOnLayoutChangeListener(this);
    }
    AppMethodBeat.o(141766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.d.2.a
 * JD-Core Version:    0.7.0.1
 */