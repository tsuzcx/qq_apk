package com.tencent.mm.f.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sk
  extends IEvent
{
  public a fRT;
  
  public sk()
  {
    this((byte)0);
  }
  
  private sk(byte paramByte)
  {
    AppMethodBeat.i(177635);
    this.fRT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(177635);
  }
  
  public static final class a
  {
    public Activity activity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.sk
 * JD-Core Version:    0.7.0.1
 */