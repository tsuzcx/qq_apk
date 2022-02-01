package com.tencent.mm.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tg
  extends IEvent
{
  public a dZH;
  
  public tg()
  {
    this((byte)0);
  }
  
  private tg(byte paramByte)
  {
    AppMethodBeat.i(146076);
    this.dZH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146076);
  }
  
  public static final class a
  {
    public String cardId;
    public Bitmap dZI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.tg
 * JD-Core Version:    0.7.0.1
 */