package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.IEvent;

public final class vr
  extends IEvent
{
  public a ebQ;
  
  public vr()
  {
    this((byte)0);
  }
  
  private vr(byte paramByte)
  {
    AppMethodBeat.i(125640);
    this.ebQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125640);
  }
  
  public static final class a
  {
    public int dDe;
    public cnb ebR;
    public String mediaId;
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.vr
 * JD-Core Version:    0.7.0.1
 */