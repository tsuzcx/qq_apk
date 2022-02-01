package com.tencent.mm.f.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ug
  extends IEvent
{
  public a fTz;
  
  public ug()
  {
    this((byte)0);
  }
  
  private ug(byte paramByte)
  {
    AppMethodBeat.i(146075);
    this.fTz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146075);
  }
  
  public static final class a
  {
    public int action = 0;
    public String cardNum;
    public Bitmap fTA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.ug
 * JD-Core Version:    0.7.0.1
 */