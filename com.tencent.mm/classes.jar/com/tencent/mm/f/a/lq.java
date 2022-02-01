package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lq
  extends IEvent
{
  public a fJs;
  
  public lq()
  {
    this((byte)0);
  }
  
  private lq(byte paramByte)
  {
    AppMethodBeat.i(140988);
    this.fJs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140988);
  }
  
  public static final class a
  {
    public Boolean fJt;
    public int fJu;
    public Boolean fJv;
    public String imagePath;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.lq
 * JD-Core Version:    0.7.0.1
 */