package com.tencent.mm.f.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ay
  extends IEvent
{
  public a fwH;
  
  public ay()
  {
    this((byte)0);
  }
  
  private ay(byte paramByte)
  {
    AppMethodBeat.i(115969);
    this.fwH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115969);
  }
  
  public static final class a
  {
    public Activity activity;
    public String fwI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ay
 * JD-Core Version:    0.7.0.1
 */