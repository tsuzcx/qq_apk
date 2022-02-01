package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class ou
  extends IEvent
{
  public a dUO;
  
  public ou()
  {
    this((byte)0);
  }
  
  private ou(byte paramByte)
  {
    AppMethodBeat.i(130927);
    this.dUO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130927);
  }
  
  public static final class a
  {
    public WeakReference aWF;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ou
 * JD-Core Version:    0.7.0.1
 */