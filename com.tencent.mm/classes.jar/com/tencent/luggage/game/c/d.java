package com.tencent.luggage.game.c;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends AppCompatTextView
{
  StringBuilder dgR;
  public final List<f> ell;
  public e.c elm;
  public MTimerHandler eln;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130513);
    this.ell = new ArrayList(4);
    this.dgR = new StringBuilder(100);
    this.elm = null;
    this.eln = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(130512);
        d.a(d.this).clear();
        if (d.b(d.this) != null) {
          d.b(d.this).ba(d.a(d.this));
        }
        d locald = d.this;
        Object localObject = d.a(d.this);
        locald.dgR.setLength(0);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          locald.dgR.append(localf.key).append(": ").append(localf.elF).append("\n");
        }
        locald.setText(locald.dgR);
        AppMethodBeat.o(130512);
        return true;
      }
    }, true);
    setTextSize(12.0F);
    setTextColor(-65536);
    setFocusable(false);
    setClickable(false);
    setOnClickListener(null);
    this.eln.startTimer(1000L);
    AppMethodBeat.o(130513);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.c.d
 * JD-Core Version:    0.7.0.1
 */