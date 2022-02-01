package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class pr
  extends IEvent
{
  public a fOq;
  
  public pr()
  {
    this((byte)0);
  }
  
  private pr(byte paramByte)
  {
    AppMethodBeat.i(130927);
    this.fOq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130927);
  }
  
  public static final class a
  {
    public WeakReference aFX;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.pr
 * JD-Core Version:    0.7.0.1
 */