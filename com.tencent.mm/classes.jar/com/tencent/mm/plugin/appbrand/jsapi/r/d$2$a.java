package com.tencent.mm.plugin.appbrand.jsapi.r;

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
  View bJG;
  TouchDelegate leW;
  View leX;
  
  d$2$a(d.2 param2, View paramView)
  {
    AppMethodBeat.i(138266);
    paramView.addOnAttachStateChangeListener(this);
    paramView.setOnTouchListener(new d.2.a.1(this, param2));
    this.leX = paramView;
    AppMethodBeat.o(138266);
  }
  
  private void bmn()
  {
    AppMethodBeat.i(138270);
    if ((this.bJG != null) && (t.aC(this.leX)))
    {
      Object localObject = new Rect(0, 0, this.bJG.getWidth(), this.bJG.getHeight());
      View localView = this.bJG;
      localObject = new TouchDelegate((Rect)localObject, this.leX);
      this.leW = ((TouchDelegate)localObject);
      localView.setTouchDelegate((TouchDelegate)localObject);
    }
    AppMethodBeat.o(138270);
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(138269);
    bmn();
    AppMethodBeat.o(138269);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(138267);
    this.bJG = ((View)paramView.getParent());
    bmn();
    this.bJG.addOnLayoutChangeListener(this);
    AppMethodBeat.o(138267);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(138268);
    if ((this.bJG != null) && (this.bJG.getTouchDelegate() == this.leW)) {
      this.bJG.setTouchDelegate(null);
    }
    if (this.bJG != null) {
      this.bJG.removeOnLayoutChangeListener(this);
    }
    AppMethodBeat.o(138268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.d.2.a
 * JD-Core Version:    0.7.0.1
 */