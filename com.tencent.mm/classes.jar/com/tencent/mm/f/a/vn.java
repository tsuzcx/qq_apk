package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class vn
  extends IEvent
{
  public a fUH;
  
  public vn()
  {
    this((byte)0);
  }
  
  private vn(byte paramByte)
  {
    AppMethodBeat.i(5532);
    this.fUH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(5532);
  }
  
  public static final class a
  {
    public String fSj;
    public LinkedList<ctt> fUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.vn
 * JD-Core Version:    0.7.0.1
 */