package com.tencent.mm.autogen.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adf
  extends IEvent
{
  public a ihn;
  
  public adf()
  {
    this((byte)0);
  }
  
  private adf(byte paramByte)
  {
    AppMethodBeat.i(91228);
    this.ihn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91228);
  }
  
  public static final class a
  {
    public String hAT;
    public int hPm = 0;
    public int ihm = 0;
    public Intent intent;
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adf
 * JD-Core Version:    0.7.0.1
 */