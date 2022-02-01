package com.tencent.mm.autogen.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vy
  extends IEvent
{
  public a hZB;
  
  public vy()
  {
    this((byte)0);
  }
  
  private vy(byte paramByte)
  {
    AppMethodBeat.i(146077);
    this.hZB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146077);
  }
  
  public static final class a
  {
    public String cardType;
    public int hZC = 0;
    public String hZD;
    public Bitmap hZE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vy
 * JD-Core Version:    0.7.0.1
 */