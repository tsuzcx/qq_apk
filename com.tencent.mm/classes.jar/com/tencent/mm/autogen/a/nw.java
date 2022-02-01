package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.cc;

public final class nw
  extends IEvent
{
  public a hQs;
  public b hQt;
  
  public nw()
  {
    this((byte)0);
  }
  
  private nw(byte paramByte)
  {
    AppMethodBeat.i(55664);
    this.hQs = new a();
    this.hQt = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55664);
  }
  
  public static final class a
  {
    public int hQm = 0;
    public boolean hQu = false;
    public cc hzO;
    public String language;
  }
  
  public static final class b
  {
    public String hLS;
    public String hQv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nw
 * JD-Core Version:    0.7.0.1
 */