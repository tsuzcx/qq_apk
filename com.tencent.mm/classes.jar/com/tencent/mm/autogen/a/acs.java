package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acs
  extends IEvent
{
  public a igc;
  public b igd;
  
  public acs()
  {
    this((byte)0);
  }
  
  private acs(byte paramByte)
  {
    AppMethodBeat.i(130930);
    this.igc = new a();
    this.igd = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130930);
  }
  
  public static final class a
  {
    public String action;
    public String appId;
    public String hPe;
    public String hhx;
    public String ige;
    public int igf;
    public String igg;
    public String nonceStr;
    public String signType;
    public String url;
  }
  
  public static final class b
  {
    public String igg;
    public Runnable igh;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acs
 * JD-Core Version:    0.7.0.1
 */