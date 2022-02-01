package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rj
  extends IEvent
{
  public a fQw;
  public b fQx;
  
  public rj()
  {
    this((byte)0);
  }
  
  private rj(byte paramByte)
  {
    AppMethodBeat.i(91211);
    this.fQw = new a();
    this.fQx = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91211);
  }
  
  public static final class a
  {
    public String appId;
    public String url;
  }
  
  public static final class b
  {
    public int errCode = 0;
    public String fQA;
    public String fQB;
    public String fQC;
    public String fQD;
    public String fQE;
    public String fQF;
    public boolean fQy = false;
    public String fQz;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.rj
 * JD-Core Version:    0.7.0.1
 */