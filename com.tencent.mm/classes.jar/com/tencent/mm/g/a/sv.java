package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.b;

public final class sv
  extends b
{
  public a dIs;
  
  public sv()
  {
    this((byte)0);
  }
  
  private sv(byte paramByte)
  {
    AppMethodBeat.i(116047);
    this.dIs = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116047);
  }
  
  public static final class a
  {
    public String appId;
    public String appName;
    public String dIA;
    public String dIt;
    public String dIu;
    public String dIv;
    public String dIw;
    public String dIx;
    public String dIy;
    public String dIz;
    public WXMediaMessage dve;
    public int dvf;
    public String sessionId;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.sv
 * JD-Core Version:    0.7.0.1
 */