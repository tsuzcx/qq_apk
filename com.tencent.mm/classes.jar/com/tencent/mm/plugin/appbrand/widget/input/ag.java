package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.e;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;

final class ag<Input extends EditText,  extends ab>
{
  final String TAG;
  final Input ngl;
  final float ngm;
  e.f ngn;
  MotionEvent ngo;
  boolean ngp;
  final Runnable ngq;
  final Runnable ngr;
  
  ag(Input paramInput)
  {
    AppMethodBeat.i(136577);
    this.ngp = false;
    this.ngq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136575);
        ag.this.ngp = true;
        ad.v(ag.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        ag.this.ngl.postDelayed(ag.this.ngr, ViewConfiguration.getLongPressTimeout());
        AppMethodBeat.o(136575);
      }
    };
    this.ngr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136576);
        if (!ag.this.ngp)
        {
          AppMethodBeat.o(136576);
          return;
        }
        e.f localf = e.cE(ag.this.ngl);
        if ((ag.this.ngn == null) || (Math.abs(ag.this.ngn.x - localf.x) > 1.0F) || (Math.abs(ag.this.ngn.y - localf.y) > 1.0F))
        {
          ad.v(ag.this.TAG, "check long press timeout, but view has moved.");
          AppMethodBeat.o(136576);
          return;
        }
        if (ag.this.ngo == null)
        {
          AppMethodBeat.o(136576);
          return;
        }
        ag.this.ngp = false;
        ag.this.ngl.removeCallbacks(ag.this.ngq);
        AppMethodBeat.o(136576);
      }
    };
    this.ngl = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.ngm = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
    AppMethodBeat.o(136577);
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(136579);
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    ad.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.ngm), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.I(paramMotionEvent1), a.I(paramMotionEvent2) });
    if ((Math.abs(f4 - f2) <= this.ngm) && (Math.abs(f3 - f1) <= this.ngm))
    {
      AppMethodBeat.o(136579);
      return true;
    }
    AppMethodBeat.o(136579);
    return false;
  }
  
  final void bEP()
  {
    AppMethodBeat.i(136578);
    this.ngp = false;
    this.ngl.removeCallbacks(this.ngq);
    this.ngl.removeCallbacks(this.ngr);
    this.ngn = null;
    if (this.ngo != null)
    {
      this.ngo.recycle();
      this.ngo = null;
    }
    AppMethodBeat.o(136578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag
 * JD-Core Version:    0.7.0.1
 */