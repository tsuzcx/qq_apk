package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.b.b;

public final class qy
  extends b
{
  public a dGB;
  
  public qy()
  {
    this((byte)0);
  }
  
  private qy(byte paramByte)
  {
    AppMethodBeat.i(125627);
    this.dGB = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(125627);
  }
  
  public static final class a
  {
    public SnsAdClick dGA;
    public int dGC;
    public String dGD;
    public int errorCode;
    public long timestamp;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qy
 * JD-Core Version:    0.7.0.1
 */