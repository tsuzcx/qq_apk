package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.s.c.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;

final class af<Input extends EditText,  extends aa>
{
  final String TAG;
  final Input hvM;
  final float hvN;
  c.f hvO;
  MotionEvent hvP;
  boolean hvQ = false;
  final Runnable hvR = new Runnable()
  {
    public final void run()
    {
      af.this.hvQ = true;
      y.v(af.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
      af.this.hvM.postDelayed(af.this.hvS, ViewConfiguration.getLongPressTimeout());
    }
  };
  final Runnable hvS = new af.2(this);
  
  af(Input paramInput)
  {
    this.hvM = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.hvN = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    y.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.hvN), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.y(paramMotionEvent1), a.y(paramMotionEvent2) });
    return (Math.abs(f4 - f2) <= this.hvN) && (Math.abs(f3 - f1) <= this.hvN);
  }
  
  final void ast()
  {
    this.hvQ = false;
    this.hvM.removeCallbacks(this.hvR);
    this.hvM.removeCallbacks(this.hvS);
    this.hvO = null;
    if (this.hvP != null)
    {
      this.hvP.recycle();
      this.hvP = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.af
 * JD-Core Version:    0.7.0.1
 */