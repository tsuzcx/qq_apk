package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aap
  extends IEvent
{
  public a ehC;
  
  public aap()
  {
    this((byte)0);
  }
  
  private aap(byte paramByte)
  {
    AppMethodBeat.i(19849);
    this.ehC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19849);
  }
  
  public static final class a
  {
    public int dDe;
    public String dGL;
    public String dGP;
    public byte[] data;
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.aap
 * JD-Core Version:    0.7.0.1
 */