package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class wm
  extends IEvent
{
  public a hZZ;
  
  public wm()
  {
    this((byte)0);
  }
  
  private wm(byte paramByte)
  {
    AppMethodBeat.i(116047);
    this.hZZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116047);
  }
  
  public static final class a
  {
    public String appId;
    public String appName;
    public int hKZ;
    public WXMediaMessage hzF;
    public String iaa;
    public String iab;
    public String iac;
    public String iad;
    public String iae;
    public String iaf;
    public String iag;
    public String iah;
    public String sessionId;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.wm
 * JD-Core Version:    0.7.0.1
 */