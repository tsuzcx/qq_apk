package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aat
  extends IEvent
{
  public a fZS;
  
  public aat()
  {
    this((byte)0);
  }
  
  private aat(byte paramByte)
  {
    AppMethodBeat.i(130929);
    this.fZS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130929);
  }
  
  public static final class a
  {
    public Context context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.aat
 * JD-Core Version:    0.7.0.1
 */