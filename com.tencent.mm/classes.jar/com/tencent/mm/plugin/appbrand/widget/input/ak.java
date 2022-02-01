package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

final class ak<Input extends EditText,  extends af>
{
  final String TAG;
  final Input uIG;
  final float uIH;
  e.f uII;
  MotionEvent uIJ;
  boolean uIK;
  final Runnable uIL;
  final Runnable uIM;
  
  ak(Input paramInput)
  {
    AppMethodBeat.i(136577);
    this.uIK = false;
    this.uIL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136575);
        ak.this.uIK = true;
        Log.v(ak.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        ak.this.uIG.postDelayed(ak.this.uIM, ViewConfiguration.getLongPressTimeout());
        AppMethodBeat.o(136575);
      }
    };
    this.uIM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136576);
        if (!ak.this.uIK)
        {
          AppMethodBeat.o(136576);
          return;
        }
        e.f localf = e.dw(ak.this.uIG);
        if ((ak.this.uII == null) || (Math.abs(ak.this.uII.x - localf.x) > 1.0F) || (Math.abs(ak.this.uII.y - localf.y) > 1.0F))
        {
          Log.v(ak.this.TAG, "check long press timeout, but view has moved.");
          AppMethodBeat.o(136576);
          return;
        }
        if (ak.this.uIJ == null)
        {
          AppMethodBeat.o(136576);
          return;
        }
        ak.this.uIK = false;
        ak.this.uIG.removeCallbacks(ak.this.uIL);
        AppMethodBeat.o(136576);
      }
    };
    this.uIG = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.uIH = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
    AppMethodBeat.o(136577);
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(136579);
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    Log.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.uIH), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.N(paramMotionEvent1), a.N(paramMotionEvent2) });
    if ((Math.abs(f4 - f2) <= this.uIH) && (Math.abs(f3 - f1) <= this.uIH))
    {
      AppMethodBeat.o(136579);
      return true;
    }
    AppMethodBeat.o(136579);
    return false;
  }
  
  final void cRL()
  {
    AppMethodBeat.i(136578);
    this.uIK = false;
    this.uIG.removeCallbacks(this.uIL);
    this.uIG.removeCallbacks(this.uIM);
    this.uII = null;
    if (this.uIJ != null)
    {
      this.uIJ.recycle();
      this.uIJ = null;
    }
    AppMethodBeat.o(136578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak
 * JD-Core Version:    0.7.0.1
 */