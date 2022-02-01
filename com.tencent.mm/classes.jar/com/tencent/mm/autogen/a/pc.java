package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class pc
  extends IEvent
{
  public a hRW;
  
  public pc()
  {
    this((byte)0);
  }
  
  private pc(byte paramByte)
  {
    AppMethodBeat.i(101728);
    this.hRW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(101728);
  }
  
  public static final class a
  {
    public LinkedList<cxv> hRX;
    public boolean hRY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pc
 * JD-Core Version:    0.7.0.1
 */