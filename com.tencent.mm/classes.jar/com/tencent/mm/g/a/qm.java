package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.b.b;

public final class qm
  extends b
{
  public a dtv;
  
  public qm()
  {
    this((byte)0);
  }
  
  private qm(byte paramByte)
  {
    AppMethodBeat.i(125627);
    this.dtv = new a();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(125627);
  }
  
  public static final class a
  {
    public SnsAdClick dtu;
    public int dtw;
    public String dtx;
    public int errorCode;
    public long timestamp;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qm
 * JD-Core Version:    0.7.0.1
 */