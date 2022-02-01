package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.b.b;

public final class qd
  extends b
{
  public a dvI;
  
  public qd()
  {
    this((byte)0);
  }
  
  private qd(byte paramByte)
  {
    AppMethodBeat.i(125627);
    this.dvI = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(125627);
  }
  
  public static final class a
  {
    public SnsAdClick dvH;
    public int dvJ;
    public String dvK;
    public int errorCode;
    public long timestamp;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qd
 * JD-Core Version:    0.7.0.1
 */