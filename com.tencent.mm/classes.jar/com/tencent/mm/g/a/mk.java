package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mk
  extends IEvent
{
  public a dRK;
  
  public mk()
  {
    this((byte)0);
  }
  
  private mk(byte paramByte)
  {
    AppMethodBeat.i(126679);
    this.dRK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(126679);
  }
  
  public static final class a
  {
    public String dRL;
    public String dRM;
    public int dRN;
    public String[] dRO;
    public String dRP;
    public int dRQ;
    public int dRR;
    public String dRS;
    public long endTime;
    public String fileId;
    public int netType;
    public String path;
    public long startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mk
 * JD-Core Version:    0.7.0.1
 */