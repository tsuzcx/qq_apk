package com.tencent.mm.f.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class te
  extends IEvent
{
  public a fSz;
  
  public te()
  {
    this((byte)0);
  }
  
  private te(byte paramByte)
  {
    AppMethodBeat.i(91217);
    this.fSz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91217);
  }
  
  public static final class a
  {
    public Context context;
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.te
 * JD-Core Version:    0.7.0.1
 */