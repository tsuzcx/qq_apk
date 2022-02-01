package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.sdk.event.IEvent;

public final class np
  extends IEvent
{
  public a fMc;
  
  public np()
  {
    this((byte)0);
  }
  
  private np(byte paramByte)
  {
    AppMethodBeat.i(136976);
    this.fMc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136976);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public long duration;
    public int errCode;
    public String errMsg;
    public f fLV;
    public String fMd;
    public boolean fMe;
    public boolean fMf = false;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.np
 * JD-Core Version:    0.7.0.1
 */