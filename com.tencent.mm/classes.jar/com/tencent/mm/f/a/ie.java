package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ie
  extends IEvent
{
  public a fFk;
  
  public ie()
  {
    this((byte)0);
  }
  
  private ie(byte paramByte)
  {
    AppMethodBeat.i(289611);
    this.fFk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(289611);
  }
  
  public static final class a
  {
    public int fCN;
    public long localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ie
 * JD-Core Version:    0.7.0.1
 */