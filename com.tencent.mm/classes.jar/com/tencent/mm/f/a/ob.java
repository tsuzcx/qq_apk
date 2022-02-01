package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ob
  extends IEvent
{
  public a fMQ;
  public b fMR;
  
  public ob()
  {
    this((byte)0);
  }
  
  private ob(byte paramByte)
  {
    AppMethodBeat.i(116462);
    this.fMQ = new a();
    this.fMR = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116462);
  }
  
  public static final class a
  {
    public String chatroomName;
    public String fMS;
    public boolean fMo = false;
  }
  
  public static final class b
  {
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ob
 * JD-Core Version:    0.7.0.1
 */