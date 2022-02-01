package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zg
  extends IEvent
{
  public a fYD;
  
  public zg()
  {
    this((byte)0);
  }
  
  private zg(byte paramByte)
  {
    AppMethodBeat.i(19842);
    this.fYD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19842);
  }
  
  public static final class a
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.zg
 * JD-Core Version:    0.7.0.1
 */