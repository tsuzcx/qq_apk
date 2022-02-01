package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yk
  extends IEvent
{
  public a ibL;
  
  public yk()
  {
    this((byte)0);
  }
  
  private yk(byte paramByte)
  {
    AppMethodBeat.i(125636);
    this.ibL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125636);
  }
  
  public static final class a
  {
    public Context context;
    public String hHB;
    public int hId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.yk
 * JD-Core Version:    0.7.0.1
 */