package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tj
  extends IEvent
{
  public a fSQ;
  public b fSR;
  
  public tj()
  {
    this((byte)0);
  }
  
  private tj(byte paramByte)
  {
    AppMethodBeat.i(149886);
    this.fSQ = new a();
    this.fSR = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149886);
  }
  
  public static final class a
  {
    public Context context;
  }
  
  public static final class b
  {
    public boolean fSG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.tj
 * JD-Core Version:    0.7.0.1
 */