package com.tencent.mm.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tf
  extends IEvent
{
  public a dZF;
  
  public tf()
  {
    this((byte)0);
  }
  
  private tf(byte paramByte)
  {
    AppMethodBeat.i(146075);
    this.dZF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146075);
  }
  
  public static final class a
  {
    public int action = 0;
    public String cardNum;
    public Bitmap dZG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.tf
 * JD-Core Version:    0.7.0.1
 */