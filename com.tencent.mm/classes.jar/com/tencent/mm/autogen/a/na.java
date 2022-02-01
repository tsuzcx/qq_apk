package com.tencent.mm.autogen.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class na
  extends IEvent
{
  public a hPl;
  
  public na()
  {
    this((byte)0);
  }
  
  private na(byte paramByte)
  {
    AppMethodBeat.i(91208);
    this.hPl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91208);
  }
  
  public static final class a
  {
    public int hPm;
    public Intent hPn;
    public int resultCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.na
 * JD-Core Version:    0.7.0.1
 */