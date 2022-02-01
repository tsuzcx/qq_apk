package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class xd
  extends IEvent
{
  public a iaE;
  
  public xd()
  {
    this((byte)0);
  }
  
  private xd(byte paramByte)
  {
    AppMethodBeat.i(5532);
    this.iaE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(5532);
  }
  
  public static final class a
  {
    public String hYg;
    public LinkedList<dkv> iaF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.xd
 * JD-Core Version:    0.7.0.1
 */