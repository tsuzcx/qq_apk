package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class abu
  extends IEvent
{
  public a gbG;
  public b gbH;
  
  public abu()
  {
    this((byte)0);
  }
  
  private abu(byte paramByte)
  {
    AppMethodBeat.i(91234);
    this.gbG = new a();
    this.gbH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91234);
  }
  
  public static final class a
  {
    public int action;
    public String content;
    public long fxU;
    public int gbI;
  }
  
  public static final class b
  {
    public long fxU;
    public int gbI;
    public long gbJ;
    public String gbK;
    public List gbL;
    public byte[] gbM;
    public byte[] gbN;
    public String gbO;
    public String gbP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.abu
 * JD-Core Version:    0.7.0.1
 */