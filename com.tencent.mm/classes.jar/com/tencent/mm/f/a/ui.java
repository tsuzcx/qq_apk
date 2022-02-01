package com.tencent.mm.f.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ui
  extends IEvent
{
  public a fTD;
  
  public ui()
  {
    this((byte)0);
  }
  
  private ui(byte paramByte)
  {
    AppMethodBeat.i(146077);
    this.fTD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146077);
  }
  
  public static final class a
  {
    public String cardType;
    public int fTE = 0;
    public String fTF;
    public Bitmap fTG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.ui
 * JD-Core Version:    0.7.0.1
 */