package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class nd
  extends IEvent
{
  public a dSR;
  public b dSS;
  
  public nd()
  {
    this((byte)0);
  }
  
  private nd(byte paramByte)
  {
    AppMethodBeat.i(116459);
    this.dSR = new a();
    this.dSS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116459);
  }
  
  public static final class a
  {
    public boolean dSQ = false;
    public String dST;
    public List<String> dSU;
  }
  
  public static final class b
  {
    public int dSV;
    public String dSW;
    public List<String> dSX;
    public List<String> dSY;
    public List<String> dSZ;
    public List<String> dTa;
    public List<String> dTb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.nd
 * JD-Core Version:    0.7.0.1
 */