package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class le
  extends IEvent
{
  public a dQr;
  
  public le()
  {
    this((byte)0);
  }
  
  private le(byte paramByte)
  {
    AppMethodBeat.i(91208);
    this.dQr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91208);
  }
  
  public static final class a
  {
    public Intent dQs;
    public int requestCode;
    public int resultCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.le
 * JD-Core Version:    0.7.0.1
 */