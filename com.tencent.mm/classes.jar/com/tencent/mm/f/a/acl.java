package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.sdk.event.IEvent;

public final class acl
  extends IEvent
{
  public a gcJ;
  
  public acl()
  {
    this((byte)0);
  }
  
  private acl(byte paramByte)
  {
    AppMethodBeat.i(206434);
    this.gcJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(206434);
  }
  
  public static final class a
  {
    public int event = 0;
    public a gcK;
    public l gcL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.acl
 * JD-Core Version:    0.7.0.1
 */