package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zh
  extends IEvent
{
  public a fYE;
  
  public zh()
  {
    this((byte)0);
  }
  
  private zh(byte paramByte)
  {
    AppMethodBeat.i(116052);
    this.fYE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116052);
  }
  
  public static final class a
  {
    public String fYF;
    public boolean fYG;
    public byte[] fYH;
    public String id;
    public String source;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zh
 * JD-Core Version:    0.7.0.1
 */