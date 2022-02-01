package com.tencent.mm.autogen.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vw
  extends IEvent
{
  public a hZx;
  
  public vw()
  {
    this((byte)0);
  }
  
  private vw(byte paramByte)
  {
    AppMethodBeat.i(146075);
    this.hZx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146075);
  }
  
  public static final class a
  {
    public int action = 0;
    public String cardNum;
    public Bitmap hZy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vw
 * JD-Core Version:    0.7.0.1
 */