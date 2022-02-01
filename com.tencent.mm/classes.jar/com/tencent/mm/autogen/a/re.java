package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class re
  extends IEvent
{
  public a hUj;
  
  public re()
  {
    this((byte)0);
  }
  
  private re(byte paramByte)
  {
    AppMethodBeat.i(130927);
    this.hUj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130927);
  }
  
  public static final class a
  {
    public WeakReference contextRef;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.re
 * JD-Core Version:    0.7.0.1
 */