package com.tencent.mm.g.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fu
  extends IEvent
{
  public a dJb;
  public b dJc;
  
  public fu()
  {
    this((byte)0);
  }
  
  private fu(byte paramByte)
  {
    AppMethodBeat.i(116016);
    this.dJb = new a();
    this.dJc = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116016);
  }
  
  public static final class a
  {
    public String dJd;
  }
  
  public static final class b
  {
    public Cursor dIU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fu
 * JD-Core Version:    0.7.0.1
 */