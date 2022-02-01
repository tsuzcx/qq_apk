package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.event.IEvent;

public final class zk
  extends IEvent
{
  public a efA;
  
  public zk()
  {
    this((byte)0);
  }
  
  private zk(byte paramByte)
  {
    AppMethodBeat.i(256164);
    this.efA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(256164);
  }
  
  public static final class a
  {
    public ckj efB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zk
 * JD-Core Version:    0.7.0.1
 */