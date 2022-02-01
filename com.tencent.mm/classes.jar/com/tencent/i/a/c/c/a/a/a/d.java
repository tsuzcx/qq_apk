package com.tencent.i.a.c.c.a.a.a;

import android.view.MotionEvent;
import android.view.Window.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends b
{
  private c Sti;
  private String activityName;
  
  public d(Window.Callback paramCallback, c paramc, String paramString)
  {
    super(paramCallback);
    this.Sti = paramc;
    this.activityName = paramString;
  }
  
  final void aC(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(214809);
    this.Sti.b(this.activityName, paramMotionEvent);
    AppMethodBeat.o(214809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.c.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */