package com.tencent.luggage.game.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.view.MotionEvent;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.f;

@SuppressLint({"ViewConstructor"})
public final class d
  extends AppCompatTextView
{
  StringBuilder aXa;
  private double bAx;
  public boolean bAy;
  ap bAz;
  private MBRuntime mbRuntime;
  
  public d(Context paramContext, MBRuntime paramMBRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(140393);
    this.bAx = 60.0D;
    this.aXa = new StringBuilder(100);
    this.bAy = false;
    this.bAz = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(140392);
        if (d.a(d.this) == null)
        {
          AppMethodBeat.o(140392);
          return true;
        }
        Object localObject1 = d.a(d.this).getCurrentFps();
        d.a(d.this, Math.min(d.b(d.this), ((a.a)localObject1).bJg));
        Object localObject2 = d.a(d.this).getParams();
        d locald = d.this;
        double d1 = ((a.a)localObject1).bJg;
        double d2 = d.b(d.this);
        double d3 = ((a.a)localObject1).bJh;
        boolean bool = ((MBRuntime.MBParams)localObject2).use_command_buffer;
        locald.aXa.setLength(0);
        locald.aXa.append("MinFPS[").append(Math.round(d2)).append("] RT-FPS[").append(Math.round(d1)).append("] EX-FPS[").append(Math.round(d3)).append("]");
        if ((f.DEBUG) && (locald.bAy))
        {
          localObject1 = locald.aXa.append(" MEMORY[");
          localObject2 = g.bAQ;
          ((StringBuilder)localObject1).append(g.uL().bAS).append("]");
        }
        localObject2 = locald.aXa.append("").append(" ");
        if (bool) {}
        for (localObject1 = "CB";; localObject1 = "")
        {
          ((StringBuilder)localObject2).append((String)localObject1);
          locald.setText(locald.aXa);
          AppMethodBeat.o(140392);
          return true;
        }
      }
    }, true);
    setTextSize(12.0F);
    setTextColor(-65536);
    setFocusable(false);
    setClickable(false);
    setOnClickListener(null);
    this.mbRuntime = paramMBRuntime;
    this.bAz.ag(2000L, 2000L);
    AppMethodBeat.o(140393);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.d
 * JD-Core Version:    0.7.0.1
 */