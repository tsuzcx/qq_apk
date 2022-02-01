package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.res.downloader.model.l;
import com.tencent.mm.sdk.event.IEvent;

public final class aek
  extends IEvent
{
  public a iiZ;
  
  public aek()
  {
    this((byte)0);
  }
  
  private aek(byte paramByte)
  {
    AppMethodBeat.i(369458);
    this.iiZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369458);
  }
  
  public static final class a
  {
    public int event = 0;
    public a ija;
    public l ijb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aek
 * JD-Core Version:    0.7.0.1
 */