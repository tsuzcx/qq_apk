package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.d;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;

final class ag<Input extends EditText,  extends ab>
{
  final String TAG;
  final Input mdO;
  final float mdP;
  d.f mdQ;
  MotionEvent mdR;
  boolean mdS;
  final Runnable mdT;
  final Runnable mdU;
  
  ag(Input paramInput)
  {
    AppMethodBeat.i(136577);
    this.mdS = false;
    this.mdT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136575);
        ag.this.mdS = true;
        ad.v(ag.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        ag.this.mdO.postDelayed(ag.this.mdU, ViewConfiguration.getLongPressTimeout());
        AppMethodBeat.o(136575);
      }
    };
    this.mdU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136576);
        if (!ag.this.mdS)
        {
          AppMethodBeat.o(136576);
          return;
        }
        d.f localf = d.cB(ag.this.mdO);
        if ((ag.this.mdQ == null) || (Math.abs(ag.this.mdQ.x - localf.x) > 1.0F) || (Math.abs(ag.this.mdQ.y - localf.y) > 1.0F))
        {
          ad.v(ag.this.TAG, "check long press timeout, but view has moved.");
          AppMethodBeat.o(136576);
          return;
        }
        if (ag.this.mdR == null)
        {
          AppMethodBeat.o(136576);
          return;
        }
        ag.this.mdS = false;
        ag.this.mdO.removeCallbacks(ag.this.mdT);
        AppMethodBeat.o(136576);
      }
    };
    this.mdO = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.mdP = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
    AppMethodBeat.o(136577);
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(136579);
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    ad.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.mdP), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.M(paramMotionEvent1), a.M(paramMotionEvent2) });
    if ((Math.abs(f4 - f2) <= this.mdP) && (Math.abs(f3 - f1) <= this.mdP))
    {
      AppMethodBeat.o(136579);
      return true;
    }
    AppMethodBeat.o(136579);
    return false;
  }
  
  final void btO()
  {
    AppMethodBeat.i(136578);
    this.mdS = false;
    this.mdO.removeCallbacks(this.mdT);
    this.mdO.removeCallbacks(this.mdU);
    this.mdQ = null;
    if (this.mdR != null)
    {
      this.mdR.recycle();
      this.mdR = null;
    }
    AppMethodBeat.o(136578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag
 * JD-Core Version:    0.7.0.1
 */