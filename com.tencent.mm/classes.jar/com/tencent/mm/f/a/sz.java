package com.tencent.mm.f.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sz
  extends IEvent
{
  public a fSr;
  
  public sz()
  {
    this((byte)0);
  }
  
  private sz(byte paramByte)
  {
    AppMethodBeat.i(257586);
    this.fSr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(257586);
  }
  
  public static final class a
  {
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.sz
 * JD-Core Version:    0.7.0.1
 */