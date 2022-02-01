package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.b.b;

public final class qx
  extends b
{
  public a dFw;
  
  public qx()
  {
    this((byte)0);
  }
  
  private qx(byte paramByte)
  {
    AppMethodBeat.i(125627);
    this.dFw = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(125627);
  }
  
  public static final class a
  {
    public SnsAdClick dFv;
    public int dFx;
    public String dFy;
    public int errorCode;
    public long timestamp;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qx
 * JD-Core Version:    0.7.0.1
 */