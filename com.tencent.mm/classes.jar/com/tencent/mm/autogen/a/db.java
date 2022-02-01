package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.e.a.a;

public final class db
  extends IEvent
{
  public a hCV;
  public b hCW;
  
  public db()
  {
    this((byte)0);
  }
  
  private db(byte paramByte)
  {
    AppMethodBeat.i(369400);
    this.hCV = new a();
    this.hCW = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369400);
  }
  
  public static final class a
  {
    public a.a hCX;
    public String hCY;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.db
 * JD-Core Version:    0.7.0.1
 */