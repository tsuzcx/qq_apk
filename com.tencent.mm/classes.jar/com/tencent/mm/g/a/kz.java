package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kz
  extends IEvent
{
  public a dQb;
  
  public kz()
  {
    this((byte)0);
  }
  
  private kz(byte paramByte)
  {
    AppMethodBeat.i(140988);
    this.dQb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140988);
  }
  
  public static final class a
  {
    public Boolean dQc;
    public int dQd;
    public Boolean dQe;
    public String imagePath;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.kz
 * JD-Core Version:    0.7.0.1
 */