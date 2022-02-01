package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.sdk.b.b;

public final class ln
  extends b
{
  public a dql;
  
  public ln()
  {
    this((byte)0);
  }
  
  private ln(byte paramByte)
  {
    AppMethodBeat.i(136976);
    this.dql = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(136976);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public f dqf;
    public String dqm;
    public boolean dqn;
    public boolean dqo = false;
    public long duration;
    public int errCode;
    public String errMsg;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ln
 * JD-Core Version:    0.7.0.1
 */