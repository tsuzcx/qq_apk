package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vr
  extends IEvent
{
  public a fUO;
  
  public vr()
  {
    this((byte)0);
  }
  
  private vr(byte paramByte)
  {
    AppMethodBeat.i(19835);
    this.fUO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19835);
  }
  
  public static final class a
  {
    public String event;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.vr
 * JD-Core Version:    0.7.0.1
 */