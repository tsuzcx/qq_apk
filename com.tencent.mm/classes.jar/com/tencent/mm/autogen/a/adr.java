package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class adr
  extends IEvent
{
  public a ihS;
  public b ihT;
  
  public adr()
  {
    this((byte)0);
  }
  
  private adr(byte paramByte)
  {
    AppMethodBeat.i(91234);
    this.ihS = new a();
    this.ihT = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91234);
  }
  
  public static final class a
  {
    public int action;
    public String content;
    public long hCz;
    public int ihU;
  }
  
  public static final class b
  {
    public long hCz;
    public int ihU;
    public long ihV;
    public String ihW;
    public List ihX;
    public byte[] ihY;
    public byte[] ihZ;
    public String iia;
    public String iib;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adr
 * JD-Core Version:    0.7.0.1
 */