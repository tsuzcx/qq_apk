package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aap
  extends IEvent
{
  public a fZK;
  
  public aap()
  {
    this((byte)0);
  }
  
  private aap(byte paramByte)
  {
    AppMethodBeat.i(149894);
    this.fZK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149894);
  }
  
  public static final class a
  {
    public boolean fZL = false;
    public boolean fvo = false;
    public boolean fvp = false;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.aap
 * JD-Core Version:    0.7.0.1
 */