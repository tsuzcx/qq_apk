package com.tencent.mm.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class th
  extends IEvent
{
  public a dZJ;
  
  public th()
  {
    this((byte)0);
  }
  
  private th(byte paramByte)
  {
    AppMethodBeat.i(146077);
    this.dZJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146077);
  }
  
  public static final class a
  {
    public String cardType;
    public int dZK = 0;
    public String dZL;
    public Bitmap dZM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.th
 * JD-Core Version:    0.7.0.1
 */