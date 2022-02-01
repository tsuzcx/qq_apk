package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pt
  extends IEvent
{
  public a fOs;
  public b fOt;
  
  public pt()
  {
    this((byte)0);
  }
  
  private pt(byte paramByte)
  {
    AppMethodBeat.i(140935);
    this.fOs = new a();
    this.fOt = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140935);
  }
  
  public static final class a
  {
    public String fHb;
    public int fOu = 0;
    public int fOv = 0;
    public Runnable fOw;
  }
  
  public static final class b
  {
    public int errCode = -1;
    public String errMsg;
    public int fHa = 0;
    public String fHc;
    public String fHd;
    public String fOx;
    public int fOy = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.pt
 * JD-Core Version:    0.7.0.1
 */