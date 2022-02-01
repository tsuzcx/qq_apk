package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vm
  extends IEvent
{
  public a ebJ;
  
  public vm()
  {
    this((byte)0);
  }
  
  private vm(byte paramByte)
  {
    AppMethodBeat.i(125636);
    this.ebJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125636);
  }
  
  public static final class a
  {
    public Context context;
    public String dJX;
    public int dKy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vm
 * JD-Core Version:    0.7.0.1
 */