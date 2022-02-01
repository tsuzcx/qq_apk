package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.IEvent;

public final class vk
  extends IEvent
{
  public a hZe;
  
  public vk()
  {
    this((byte)0);
  }
  
  private vk(byte paramByte)
  {
    AppMethodBeat.i(125630);
    this.hZe = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125630);
  }
  
  public static final class a
  {
    public SnsObject hNN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vk
 * JD-Core Version:    0.7.0.1
 */