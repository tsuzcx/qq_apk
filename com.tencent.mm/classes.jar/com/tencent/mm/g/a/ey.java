package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ey
  extends IEvent
{
  public a dIl;
  public b dIm;
  
  public ey()
  {
    this((byte)0);
  }
  
  private ey(byte paramByte)
  {
    AppMethodBeat.i(116008);
    this.dIl = new a();
    this.dIm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116008);
  }
  
  public static final class a
  {
    public String dGL;
    public String dGP;
    public String dHp;
    public String dIn;
    public boolean dIo;
    public String data;
    public long msgId;
  }
  
  public static final class b
  {
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.ey
 * JD-Core Version:    0.7.0.1
 */