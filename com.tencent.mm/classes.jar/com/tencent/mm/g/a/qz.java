package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qz
  extends IEvent
{
  public a dXz;
  
  public qz()
  {
    this((byte)0);
  }
  
  private qz(byte paramByte)
  {
    AppMethodBeat.i(116042);
    this.dXz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116042);
  }
  
  public static final class a
  {
    public int dFL;
    public int dFM;
    public String dWl;
    public int dXA;
    public int dXB;
    public float dXC;
    public float dXD;
    public int dXx;
    public String filePath;
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.qz
 * JD-Core Version:    0.7.0.1
 */