package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fk
  extends IEvent
{
  public a hFE;
  
  public fk()
  {
    this((byte)0);
  }
  
  private fk(byte paramByte)
  {
    AppMethodBeat.i(116002);
    this.hFE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116002);
  }
  
  public static final class a
  {
    public Context context;
    public int op = 0;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fk
 * JD-Core Version:    0.7.0.1
 */