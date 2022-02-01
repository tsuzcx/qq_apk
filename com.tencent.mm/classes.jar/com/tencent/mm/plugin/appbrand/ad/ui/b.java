package com.tencent.mm.plugin.appbrand.ad.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class b
  extends IEvent
{
  public a nBj;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    AppMethodBeat.i(160567);
    this.nBj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(160567);
  }
  
  public static final class a
  {
    public String appId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.b
 * JD-Core Version:    0.7.0.1
 */