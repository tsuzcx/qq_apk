package com.tencent.mm.g.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nz
  extends IEvent
{
  public a dUc;
  
  public nz()
  {
    this((byte)0);
  }
  
  private nz(byte paramByte)
  {
    AppMethodBeat.i(77797);
    this.dUc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(77797);
  }
  
  public static final class a
  {
    public String dUd;
    public Bundle params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.nz
 * JD-Core Version:    0.7.0.1
 */