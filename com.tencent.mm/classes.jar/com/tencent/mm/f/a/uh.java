package com.tencent.mm.f.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uh
  extends IEvent
{
  public a fTB;
  
  public uh()
  {
    this((byte)0);
  }
  
  private uh(byte paramByte)
  {
    AppMethodBeat.i(146076);
    this.fTB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146076);
  }
  
  public static final class a
  {
    public String cardId;
    public Bitmap fTC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.uh
 * JD-Core Version:    0.7.0.1
 */