package com.tencent.luggage.game.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class d
  extends AppCompatTextView
{
  StringBuilder bDv;
  private final List<f> cvc;
  public e.c cvd;
  public MTimerHandler cve;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130513);
    this.cvc = new ArrayList(4);
    this.bDv = new StringBuilder(100);
    this.cvd = null;
    this.cve = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(130512);
        d.a(d.this).clear();
        if (d.b(d.this) != null) {
          d.b(d.this).F(d.a(d.this));
        }
        d locald = d.this;
        Object localObject = d.a(d.this);
        locald.bDv.setLength(0);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          locald.bDv.append(localf.key).append("[").append(localf.cvw).append("] ");
        }
        locald.setText(locald.bDv);
        AppMethodBeat.o(130512);
        return true;
      }
    }, true);
    setTextSize(12.0F);
    setTextColor(-65536);
    setFocusable(false);
    setClickable(false);
    setOnClickListener(null);
    this.cve.startTimer(2000L);
    AppMethodBeat.o(130513);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void setInfo(List<f> paramList)
  {
    AppMethodBeat.i(130514);
    this.bDv.setLength(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.bDv.append(localf.key).append("[").append(localf.cvw).append("] ");
    }
    setText(this.bDv);
    AppMethodBeat.o(130514);
  }
  
  public final void setOnRequestUpdateShowItemsCallback(e.c paramc)
  {
    this.cvd = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.c.d
 * JD-Core Version:    0.7.0.1
 */