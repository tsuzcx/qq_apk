package com.tencent.mm.f.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vt
  extends IEvent
{
  public a fUQ;
  
  public vt()
  {
    this((byte)0);
  }
  
  private vt(byte paramByte)
  {
    AppMethodBeat.i(221973);
    this.fUQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(221973);
  }
  
  public static final class a
  {
    public String action;
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.a.vt
 * JD-Core Version:    0.7.0.1
 */