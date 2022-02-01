package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mj
  extends IEvent
{
  public a hOz;
  
  public mj()
  {
    this((byte)0);
  }
  
  private mj(byte paramByte)
  {
    AppMethodBeat.i(19813);
    this.hOz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19813);
  }
  
  public static final class a
  {
    public Context context;
    public String[] hyR;
    public String[] hyS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.mj
 * JD-Core Version:    0.7.0.1
 */