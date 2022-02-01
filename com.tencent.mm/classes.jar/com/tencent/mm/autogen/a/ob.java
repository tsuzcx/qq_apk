package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ob
  extends IEvent
{
  public a hQz;
  
  public ob()
  {
    this((byte)0);
  }
  
  private ob(byte paramByte)
  {
    AppMethodBeat.i(19818);
    this.hQz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19818);
  }
  
  public static final class a
  {
    public String hQA;
    public int opType;
    public int viewId = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ob
 * JD-Core Version:    0.7.0.1
 */