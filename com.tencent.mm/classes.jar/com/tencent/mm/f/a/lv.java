package com.tencent.mm.f.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lv
  extends IEvent
{
  public a fJI;
  
  public lv()
  {
    this((byte)0);
  }
  
  private lv(byte paramByte)
  {
    AppMethodBeat.i(91208);
    this.fJI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91208);
  }
  
  public static final class a
  {
    public Intent fJJ;
    public int requestCode;
    public int resultCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.lv
 * JD-Core Version:    0.7.0.1
 */