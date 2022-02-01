package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.IEvent;

public final class ww
  extends IEvent
{
  public a fVS;
  
  public ww()
  {
    this((byte)0);
  }
  
  private ww(byte paramByte)
  {
    AppMethodBeat.i(125640);
    this.fVS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125640);
  }
  
  public static final class a
  {
    public cvt fVT;
    public int fvK;
    public String mediaId;
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ww
 * JD-Core Version:    0.7.0.1
 */