package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vr
  extends IEvent
{
  public a hZo;
  
  public vr()
  {
    this((byte)0);
  }
  
  private vr(byte paramByte)
  {
    AppMethodBeat.i(19830);
    this.hZo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19830);
  }
  
  public static final class a
  {
    public Context context;
    public String[] hyR;
    public String[] hyS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vr
 * JD-Core Version:    0.7.0.1
 */