package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yd
  extends IEvent
{
  public a fXt;
  
  public yd()
  {
    this((byte)0);
  }
  
  private yd(byte paramByte)
  {
    AppMethodBeat.i(19838);
    this.fXt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19838);
  }
  
  public static final class a
  {
    public Context context;
    public String fXu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.yd
 * JD-Core Version:    0.7.0.1
 */