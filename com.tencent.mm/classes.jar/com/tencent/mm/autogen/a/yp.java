package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IEvent;

public final class yp
  extends IEvent
{
  public a ibS;
  
  public yp()
  {
    this((byte)0);
  }
  
  private yp(byte paramByte)
  {
    AppMethodBeat.i(125640);
    this.ibS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125640);
  }
  
  public static final class a
  {
    public int hAf;
    public dmz ibT;
    public String mediaId;
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.yp
 * JD-Core Version:    0.7.0.1
 */