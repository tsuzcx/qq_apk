package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.sdk.event.IEvent;

public final class jp
  extends IEvent
{
  public a hLg;
  public b hLh;
  
  public jp()
  {
    this((byte)0);
  }
  
  private jp(byte paramByte)
  {
    AppMethodBeat.i(369439);
    this.hLg = new a();
    this.hLh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369439);
  }
  
  public static final class a
  {
    public auw hLi;
    public int scene;
  }
  
  public static final class b
  {
    public boolean hLj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jp
 * JD-Core Version:    0.7.0.1
 */