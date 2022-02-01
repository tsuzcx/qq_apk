package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ou
  extends IEvent
{
  public a fNB;
  
  public ou()
  {
    this((byte)0);
  }
  
  private ou(byte paramByte)
  {
    AppMethodBeat.i(42654);
    this.fNB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42654);
  }
  
  public static final class a
  {
    public String nickName;
    public int type;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ou
 * JD-Core Version:    0.7.0.1
 */