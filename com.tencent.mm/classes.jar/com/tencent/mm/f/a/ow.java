package com.tencent.mm.f.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ow
  extends IEvent
{
  public a fNE;
  
  public ow()
  {
    this((byte)0);
  }
  
  private ow(byte paramByte)
  {
    AppMethodBeat.i(77797);
    this.fNE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(77797);
  }
  
  public static final class a
  {
    public String fNF;
    public Bundle params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ow
 * JD-Core Version:    0.7.0.1
 */