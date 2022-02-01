package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class ph
  extends IEvent
{
  public a hSw;
  public b hSx;
  
  public ph()
  {
    this((byte)0);
  }
  
  private ph(byte paramByte)
  {
    AppMethodBeat.i(138164);
    this.hSw = new a();
    this.hSx = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(138164);
  }
  
  public static final class a
  {
    public String hQf;
    public boolean hRY = false;
  }
  
  public static final class b
  {
    public int hQS = 0;
    public LinkedList<dhe> hSk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ph
 * JD-Core Version:    0.7.0.1
 */