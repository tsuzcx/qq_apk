package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

final class ak<Input extends EditText,  extends af>
{
  final String TAG;
  final Input rxC;
  final float rxD;
  e.f rxE;
  MotionEvent rxF;
  boolean rxG;
  final Runnable rxH;
  final Runnable rxI;
  
  ak(Input paramInput)
  {
    AppMethodBeat.i(136577);
    this.rxG = false;
    this.rxH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136575);
        ak.this.rxG = true;
        Log.v(ak.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        ak.this.rxC.postDelayed(ak.this.rxI, ViewConfiguration.getLongPressTimeout());
        AppMethodBeat.o(136575);
      }
    };
    this.rxI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136576);
        if (!ak.this.rxG)
        {
          AppMethodBeat.o(136576);
          return;
        }
        e.f localf = e.cO(ak.this.rxC);
        if ((ak.this.rxE == null) || (Math.abs(ak.this.rxE.x - localf.x) > 1.0F) || (Math.abs(ak.this.rxE.y - localf.y) > 1.0F))
        {
          Log.v(ak.this.TAG, "check long press timeout, but view has moved.");
          AppMethodBeat.o(136576);
          return;
        }
        if (ak.this.rxF == null)
        {
          AppMethodBeat.o(136576);
          return;
        }
        ak.this.rxG = false;
        ak.this.rxC.removeCallbacks(ak.this.rxH);
        AppMethodBeat.o(136576);
      }
    };
    this.rxC = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.rxD = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
    AppMethodBeat.o(136577);
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(136579);
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    Log.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.rxD), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.L(paramMotionEvent1), a.L(paramMotionEvent2) });
    if ((Math.abs(f4 - f2) <= this.rxD) && (Math.abs(f3 - f1) <= this.rxD))
    {
      AppMethodBeat.o(136579);
      return true;
    }
    AppMethodBeat.o(136579);
    return false;
  }
  
  final void cpi()
  {
    AppMethodBeat.i(136578);
    this.rxG = false;
    this.rxC.removeCallbacks(this.rxH);
    this.rxC.removeCallbacks(this.rxI);
    this.rxE = null;
    if (this.rxF != null)
    {
      this.rxF.recycle();
      this.rxF = null;
    }
    AppMethodBeat.o(136578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak
 * JD-Core Version:    0.7.0.1
 */