package com.tencent.mm.autogen.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yc
  extends IEvent
{
  public a ibC;
  
  public yc()
  {
    this((byte)0);
  }
  
  private yc(byte paramByte)
  {
    AppMethodBeat.i(369322);
    this.ibC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369322);
  }
  
  public static final class a
  {
    public int bUl;
    public int hPm;
    public Intent hPn;
    public int resultCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.yc
 * JD-Core Version:    0.7.0.1
 */