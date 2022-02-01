package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.w.e;
import com.tencent.mm.plugin.appbrand.jsapi.w.e.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Locale;

final class ag<Input extends EditText,  extends ab>
{
  final String TAG;
  final Input mFN;
  final float mFO;
  e.f mFP;
  MotionEvent mFQ;
  boolean mFR;
  final Runnable mFS;
  final Runnable mFT;
  
  ag(Input paramInput)
  {
    AppMethodBeat.i(136577);
    this.mFR = false;
    this.mFS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136575);
        ag.this.mFR = true;
        ac.v(ag.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        ag.this.mFN.postDelayed(ag.this.mFT, ViewConfiguration.getLongPressTimeout());
        AppMethodBeat.o(136575);
      }
    };
    this.mFT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136576);
        if (!ag.this.mFR)
        {
          AppMethodBeat.o(136576);
          return;
        }
        e.f localf = e.cD(ag.this.mFN);
        if ((ag.this.mFP == null) || (Math.abs(ag.this.mFP.x - localf.x) > 1.0F) || (Math.abs(ag.this.mFP.y - localf.y) > 1.0F))
        {
          ac.v(ag.this.TAG, "check long press timeout, but view has moved.");
          AppMethodBeat.o(136576);
          return;
        }
        if (ag.this.mFQ == null)
        {
          AppMethodBeat.o(136576);
          return;
        }
        ag.this.mFR = false;
        ag.this.mFN.removeCallbacks(ag.this.mFS);
        AppMethodBeat.o(136576);
      }
    };
    this.mFN = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.mFO = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
    AppMethodBeat.o(136577);
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(136579);
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    ac.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.mFO), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.K(paramMotionEvent1), a.K(paramMotionEvent2) });
    if ((Math.abs(f4 - f2) <= this.mFO) && (Math.abs(f3 - f1) <= this.mFO))
    {
      AppMethodBeat.o(136579);
      return true;
    }
    AppMethodBeat.o(136579);
    return false;
  }
  
  final void bAN()
  {
    AppMethodBeat.i(136578);
    this.mFR = false;
    this.mFN.removeCallbacks(this.mFS);
    this.mFN.removeCallbacks(this.mFT);
    this.mFP = null;
    if (this.mFQ != null)
    {
      this.mFQ.recycle();
      this.mFQ = null;
    }
    AppMethodBeat.o(136578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag
 * JD-Core Version:    0.7.0.1
 */