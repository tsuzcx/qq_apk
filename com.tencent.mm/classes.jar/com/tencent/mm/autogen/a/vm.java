package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.cc;

public final class vm
  extends IEvent
{
  public a hZg;
  
  public vm()
  {
    this((byte)0);
  }
  
  private vm(byte paramByte)
  {
    AppMethodBeat.i(94799);
    this.hZg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94799);
  }
  
  public static final class a
  {
    public cc hTm;
    public String hZh;
    public cc hZi;
    public long hZj = 0L;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vm
 * JD-Core Version:    0.7.0.1
 */