package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class uw
  extends IEvent
{
  public a fUc;
  
  public uw()
  {
    this((byte)0);
  }
  
  private uw(byte paramByte)
  {
    AppMethodBeat.i(116047);
    this.fUc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116047);
  }
  
  public static final class a
  {
    public String appId;
    public String appName;
    public int fFO;
    public String fUd;
    public String fUe;
    public String fUf;
    public String fUg;
    public String fUh;
    public String fUi;
    public String fUj;
    public String fUk;
    public WXMediaMessage fvl;
    public String sessionId;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.uw
 * JD-Core Version:    0.7.0.1
 */