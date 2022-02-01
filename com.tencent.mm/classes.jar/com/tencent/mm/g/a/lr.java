package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lr
  extends IEvent
{
  public a dRb;
  
  public lr()
  {
    this((byte)0);
  }
  
  private lr(byte paramByte)
  {
    AppMethodBeat.i(121050);
    this.dRb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121050);
  }
  
  public static final class a
  {
    public Intent dRc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.lr
 * JD-Core Version:    0.7.0.1
 */