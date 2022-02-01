package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ld
  extends IEvent
{
  public a dQo;
  
  public ld()
  {
    this((byte)0);
  }
  
  private ld(byte paramByte)
  {
    AppMethodBeat.i(63289);
    this.dQo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63289);
  }
  
  public static final class a
  {
    public Context context;
    public String dQp;
    public Long dQq;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ld
 * JD-Core Version:    0.7.0.1
 */