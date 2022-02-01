package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class fq
  extends IEvent
{
  public a hFP;
  public b hFQ;
  
  public fq()
  {
    this((byte)0);
  }
  
  private fq(byte paramByte)
  {
    AppMethodBeat.i(116008);
    this.hFP = new a();
    this.hFQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116008);
  }
  
  public static final class a
  {
    public String data;
    public String hES;
    public String hEl;
    public boolean hEm;
    public String hEr;
    public String hFR;
    public boolean hFS;
    public int hFT;
    public LinkedList hFU;
    public long msgId;
  }
  
  public static final class b
  {
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fq
 * JD-Core Version:    0.7.0.1
 */