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
  StringBuilder bDt;
  private final List<f> cje;
  public e.c cjf;
  public av cjg;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130513);
    this.cje = new ArrayList(4);
    this.bDt = new StringBuilder(100);
    this.cjf = null;
    this.cjg = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(130512);
        d.a(d.this).clear();
        if (d.b(d.this) != null) {
          d.b(d.this).B(d.a(d.this));
        }
        d locald = d.this;
        Object localObject = d.a(d.this);
        locald.bDt.setLength(0);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          locald.bDt.append(localf.key).append("[").append(localf.cjy).append("] ");
        }
        locald.setText(locald.bDt);
        AppMethodBeat.o(130512);
        return true;
      }
    }, true);
    setTextSize(12.0F);
    setTextColor(-65536);
    setFocusable(false);
    setClickable(false);
    setOnClickListener(null);
    this.cjg.az(2000L, 2000L);
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
    this.bDt.setLength(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.bDt.append(localf.key).append("[").append(localf.cjy).append("] ");
    }
    setText(this.bDt);
    AppMethodBeat.o(130514);
  }
  
  public final void setOnRequestUpdateShowItemsCallback(e.c paramc)
  {
    this.cjf = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.d
 * JD-Core Version:    0.7.0.1
 */