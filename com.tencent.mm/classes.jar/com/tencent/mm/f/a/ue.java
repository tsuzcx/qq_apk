package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class ue
  extends IEvent
{
  public a fTu;
  public b fTv;
  
  public ue()
  {
    this((byte)0);
  }
  
  private ue(byte paramByte)
  {
    AppMethodBeat.i(91218);
    this.fTu = new a();
    this.fTv = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91218);
  }
  
  public static final class a
  {
    public LinkedList fTw;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ue
 * JD-Core Version:    0.7.0.1
 */