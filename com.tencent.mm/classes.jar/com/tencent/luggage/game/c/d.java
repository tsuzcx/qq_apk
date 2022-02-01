package com.tencent.luggage.game.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class d
  extends AppCompatTextView
{
  StringBuilder bvd;
  private final List<f> cbP;
  public e.c cbQ;
  public av cbR;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130513);
    this.cbP = new ArrayList(4);
    this.bvd = new StringBuilder(100);
    this.cbQ = null;
    this.cbR = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(130512);
        d.a(d.this).clear();
        if (d.b(d.this) != null) {
          d.b(d.this).K(d.a(d.this));
        }
        d locald = d.this;
        Object localObject = d.a(d.this);
        locald.bvd.setLength(0);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          locald.bvd.append(localf.key).append("[").append(localf.ccj).append("] ");
        }
        locald.setText(locald.bvd);
        AppMethodBeat.o(130512);
        return true;
      }
    }, true);
    setTextSize(12.0F);
    setTextColor(-65536);
    setFocusable(false);
    setClickable(false);
    setOnClickListener(null);
    this.cbR.av(2000L, 2000L);
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
    this.bvd.setLength(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.bvd.append(localf.key).append("[").append(localf.ccj).append("] ");
    }
    setText(this.bvd);
    AppMethodBeat.o(130514);
  }
  
  public final void setOnRequestUpdateShowItemsCallback(e.c paramc)
  {
    this.cbQ = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.d
 * JD-Core Version:    0.7.0.1
 */