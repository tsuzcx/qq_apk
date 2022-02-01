package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vf
  extends IEvent
{
  public a ebD;
  
  public vf()
  {
    this((byte)0);
  }
  
  private vf(byte paramByte)
  {
    AppMethodBeat.i(201823);
    this.ebD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201823);
  }
  
  public static final class a
  {
    public int EX;
    public Intent dQs;
    public int requestCode;
    public int resultCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.vf
 * JD-Core Version:    0.7.0.1
 */