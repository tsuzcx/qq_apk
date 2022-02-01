package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jo
  extends IEvent
{
  public a hLe;
  
  public jo()
  {
    this((byte)0);
  }
  
  private jo(byte paramByte)
  {
    AppMethodBeat.i(369440);
    this.hLe = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369440);
  }
  
  public static final class a
  {
    public boolean hLf = false;
    public int scene = -1;
    public int selector = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jo
 * JD-Core Version:    0.7.0.1
 */