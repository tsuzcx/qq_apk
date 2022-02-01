package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.HashMap;

public final class lm
  extends IEvent
{
  public a dQO;
  
  public lm()
  {
    this((byte)0);
  }
  
  private lm(byte paramByte)
  {
    AppMethodBeat.i(128846);
    this.dQO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(128846);
  }
  
  public static final class a
  {
    public HashMap dQP;
    public String key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.lm
 * JD-Core Version:    0.7.0.1
 */