package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hv
  extends IEvent
{
  public a fER;
  
  public hv()
  {
    this((byte)0);
  }
  
  private hv(byte paramByte)
  {
    AppMethodBeat.i(136974);
    this.fER = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136974);
  }
  
  public static final class a
  {
    public String appId;
    public String appUserName;
    public int fES;
    public String fET;
    public String fzM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.hv
 * JD-Core Version:    0.7.0.1
 */