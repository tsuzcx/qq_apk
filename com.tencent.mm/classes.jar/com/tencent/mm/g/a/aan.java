package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class aan
  extends IEvent
{
  public a ehq;
  public b ehr;
  
  public aan()
  {
    this((byte)0);
  }
  
  private aan(byte paramByte)
  {
    AppMethodBeat.i(91234);
    this.ehq = new a();
    this.ehr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91234);
  }
  
  public static final class a
  {
    public int action;
    public String content;
    public long dFm;
    public int ehs;
  }
  
  public static final class b
  {
    public long dFm;
    public int ehs;
    public long eht;
    public String ehu;
    public List ehv;
    public byte[] ehw;
    public byte[] ehx;
    public String ehy;
    public String ehz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.aan
 * JD-Core Version:    0.7.0.1
 */