package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ie
  extends IEvent
{
  public a dMM;
  
  public ie()
  {
    this((byte)0);
  }
  
  private ie(byte paramByte)
  {
    AppMethodBeat.i(241575);
    this.dMM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(241575);
  }
  
  public static final class a
  {
    public String dMN;
    public int dMO;
    public String dMP;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ie
 * JD-Core Version:    0.7.0.1
 */