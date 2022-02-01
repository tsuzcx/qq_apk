package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.event.IEvent;

public final class abd
  extends IEvent
{
  public a eit;
  
  public abd()
  {
    this((byte)0);
  }
  
  private abd(byte paramByte)
  {
    AppMethodBeat.i(230551);
    this.eit = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(230551);
  }
  
  public static final class a
  {
    public a eiu;
    public m eiv;
    public int event = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.abd
 * JD-Core Version:    0.7.0.1
 */