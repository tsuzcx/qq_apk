package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.HashMap;

public final class xe
  extends IEvent
{
  public a fWf;
  
  public xe()
  {
    this((byte)0);
  }
  
  private xe(byte paramByte)
  {
    AppMethodBeat.i(94815);
    this.fWf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94815);
  }
  
  public static final class a
  {
    public long fWg;
    public int fWh;
    public HashMap fWi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xe
 * JD-Core Version:    0.7.0.1
 */