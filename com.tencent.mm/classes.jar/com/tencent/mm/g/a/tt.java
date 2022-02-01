package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class tt
  extends IEvent
{
  public a eaf;
  
  public tt()
  {
    this((byte)0);
  }
  
  private tt(byte paramByte)
  {
    AppMethodBeat.i(116047);
    this.eaf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116047);
  }
  
  public static final class a
  {
    public String appId;
    public String appName;
    public WXMediaMessage dCE;
    public int dMG;
    public String eag;
    public String eah;
    public String eai;
    public String eaj;
    public String eak;
    public String eal;
    public String eam;
    public String ean;
    public String sessionId;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.tt
 * JD-Core Version:    0.7.0.1
 */