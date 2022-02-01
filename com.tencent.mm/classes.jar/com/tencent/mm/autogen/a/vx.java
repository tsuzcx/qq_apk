package com.tencent.mm.autogen.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vx
  extends IEvent
{
  public a hZz;
  
  public vx()
  {
    this((byte)0);
  }
  
  private vx(byte paramByte)
  {
    AppMethodBeat.i(146076);
    this.hZz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146076);
  }
  
  public static final class a
  {
    public String cardId;
    public Bitmap hZA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vx
 * JD-Core Version:    0.7.0.1
 */