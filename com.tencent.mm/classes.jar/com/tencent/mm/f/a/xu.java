package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xu
  extends IEvent
{
  public a fWG;
  public b fWH;
  
  public xu()
  {
    this((byte)0);
  }
  
  private xu(byte paramByte)
  {
    AppMethodBeat.i(127410);
    this.fWG = new a();
    this.fWH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127410);
  }
  
  public static final class a
  {
    public boolean fWI;
    public String fWJ;
    public dd fWK;
    public String url;
  }
  
  public static final class b
  {
    public boolean fyl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.xu
 * JD-Core Version:    0.7.0.1
 */