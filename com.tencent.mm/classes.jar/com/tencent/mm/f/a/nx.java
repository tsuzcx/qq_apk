package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nx
  extends IEvent
{
  public a fMB;
  
  public nx()
  {
    this((byte)0);
  }
  
  private nx(byte paramByte)
  {
    AppMethodBeat.i(116461);
    this.fMB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116461);
  }
  
  public static final class a
  {
    public String chatroomName;
    public int fMC;
    public boolean fMo = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.nx
 * JD-Core Version:    0.7.0.1
 */