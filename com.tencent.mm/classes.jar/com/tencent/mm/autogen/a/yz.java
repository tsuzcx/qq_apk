package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.event.IEvent;

public final class yz
  extends IEvent
{
  public a icj;
  public b ick;
  
  public yz()
  {
    this((byte)0);
  }
  
  private yz(byte paramByte)
  {
    AppMethodBeat.i(148772);
    this.icj = new a();
    this.ick = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(148772);
  }
  
  public static final class a
  {
    public String ibR;
    public dmb icl;
    public Runnable icm;
    public e icn;
    public int scene;
  }
  
  public static final class b
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.yz
 * JD-Core Version:    0.7.0.1
 */