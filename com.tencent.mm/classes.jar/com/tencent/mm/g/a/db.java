package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class db
  extends IEvent
{
  public a dGl;
  
  public db()
  {
    this((byte)0);
  }
  
  private db(byte paramByte)
  {
    AppMethodBeat.i(225907);
    this.dGl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(225907);
  }
  
  public static final class a
  {
    public int action;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.db
 * JD-Core Version:    0.7.0.1
 */