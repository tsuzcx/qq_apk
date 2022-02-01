package com.tencent.h.a.c.c.a.a.a;

import android.view.MotionEvent;
import android.view.Window.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends b
{
  private c ZUL;
  private String activityName;
  
  public d(Window.Callback paramCallback, c paramc, String paramString)
  {
    super(paramCallback);
    this.ZUL = paramc;
    this.activityName = paramString;
  }
  
  final void aK(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(208464);
    this.ZUL.b(this.activityName, paramMotionEvent);
    AppMethodBeat.o(208464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */