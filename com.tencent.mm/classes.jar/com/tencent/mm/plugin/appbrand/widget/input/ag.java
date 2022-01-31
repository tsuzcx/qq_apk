package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import java.util.Locale;

final class ag<Input extends EditText,  extends ab>
{
  final String TAG;
  final Input jnZ;
  final float joa;
  d.f job;
  MotionEvent joc;
  boolean jod;
  final Runnable joe;
  final Runnable jof;
  
  ag(Input paramInput)
  {
    AppMethodBeat.i(123837);
    this.jod = false;
    this.joe = new ag.1(this);
    this.jof = new ag.2(this);
    this.jnZ = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.joa = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
    AppMethodBeat.o(123837);
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(123839);
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    com.tencent.mm.sdk.platformtools.ab.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.joa), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.H(paramMotionEvent1), a.H(paramMotionEvent2) });
    if ((Math.abs(f4 - f2) <= this.joa) && (Math.abs(f3 - f1) <= this.joa))
    {
      AppMethodBeat.o(123839);
      return true;
    }
    AppMethodBeat.o(123839);
    return false;
  }
  
  final void aRx()
  {
    AppMethodBeat.i(123838);
    this.jod = false;
    this.jnZ.removeCallbacks(this.joe);
    this.jnZ.removeCallbacks(this.jof);
    this.job = null;
    if (this.joc != null)
    {
      this.joc.recycle();
      this.joc = null;
    }
    AppMethodBeat.o(123838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag
 * JD-Core Version:    0.7.0.1
 */