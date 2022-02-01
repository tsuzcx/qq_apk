package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class sm
  extends IEvent
{
  public a dZa;
  
  public sm()
  {
    this((byte)0);
  }
  
  private sm(byte paramByte)
  {
    AppMethodBeat.i(125629);
    this.dZa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125629);
  }
  
  public static final class a
  {
    public ArrayList dZb;
    public String dZc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.sm
 * JD-Core Version:    0.7.0.1
 */