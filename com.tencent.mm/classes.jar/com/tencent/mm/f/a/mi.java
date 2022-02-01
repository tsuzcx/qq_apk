package com.tencent.mm.f.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mi
  extends IEvent
{
  public a fKr;
  
  public mi()
  {
    this((byte)0);
  }
  
  private mi(byte paramByte)
  {
    AppMethodBeat.i(121050);
    this.fKr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121050);
  }
  
  public static final class a
  {
    public Intent fKs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.mi
 * JD-Core Version:    0.7.0.1
 */