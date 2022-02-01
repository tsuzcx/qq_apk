package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aba
  extends IEvent
{
  public a gac;
  public b gad;
  
  public aba()
  {
    this((byte)0);
  }
  
  private aba(byte paramByte)
  {
    AppMethodBeat.i(91223);
    this.gac = new a();
    this.gad = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91223);
  }
  
  public static final class a
  {
    public String scene;
  }
  
  public static final class b
  {
    public String content;
    public String gae;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.aba
 * JD-Core Version:    0.7.0.1
 */