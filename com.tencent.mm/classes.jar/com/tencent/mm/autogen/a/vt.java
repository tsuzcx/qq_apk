package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vt
  extends IEvent
{
  public a hZq;
  
  public vt()
  {
    this((byte)0);
  }
  
  private vt(byte paramByte)
  {
    AppMethodBeat.i(19832);
    this.hZq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19832);
  }
  
  public static final class a
  {
    public Context context;
    public boolean hZr = false;
    public String[] hyR;
    public String[] hyS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vt
 * JD-Core Version:    0.7.0.1
 */