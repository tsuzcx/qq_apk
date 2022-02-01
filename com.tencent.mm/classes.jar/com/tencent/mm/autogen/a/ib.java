package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ib
  extends IEvent
{
  public a hJu;
  
  public ib()
  {
    this((byte)0);
  }
  
  private ib(byte paramByte)
  {
    AppMethodBeat.i(369427);
    this.hJu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369427);
  }
  
  public static final class a
  {
    public long feedId;
    public boolean hJi;
    public boolean hJv;
    public boolean hJw;
    public int hJx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ib
 * JD-Core Version:    0.7.0.1
 */