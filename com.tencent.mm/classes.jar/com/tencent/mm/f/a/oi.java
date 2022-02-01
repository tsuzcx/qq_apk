package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class oi
  extends IEvent
{
  public a fNf;
  
  public oi()
  {
    this((byte)0);
  }
  
  private oi(byte paramByte)
  {
    AppMethodBeat.i(116034);
    this.fNf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116034);
  }
  
  public static final class a
  {
    public boolean fNg;
    public boolean fNh;
    public int fuP;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.oi
 * JD-Core Version:    0.7.0.1
 */