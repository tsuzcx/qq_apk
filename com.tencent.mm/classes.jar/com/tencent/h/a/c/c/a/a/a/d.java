package com.tencent.h.a.c.c.a.a.a;

import android.view.MotionEvent;
import android.view.Window.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends b
{
  private String AtM;
  private c ahZk;
  
  public d(Window.Callback paramCallback, c paramc, String paramString)
  {
    super(paramCallback);
    this.ahZk = paramc;
    this.AtM = paramString;
  }
  
  final void aO(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212244);
    this.ahZk.b(this.AtM, paramMotionEvent);
    AppMethodBeat.o(212244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */