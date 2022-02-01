package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ev
  extends IEvent
{
  public a hEQ;
  public b hER;
  
  public ev()
  {
    this((byte)0);
  }
  
  private ev(byte paramByte)
  {
    AppMethodBeat.i(115987);
    this.hEQ = new a();
    this.hER = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115987);
  }
  
  public static final class a
  {
    public String hES;
    public String hET;
    public String hEU;
    public long msgId;
  }
  
  public static final class b
  {
    public List hEV;
    public List hEW;
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ev
 * JD-Core Version:    0.7.0.1
 */