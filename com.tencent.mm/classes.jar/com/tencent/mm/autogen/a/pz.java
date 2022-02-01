package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pz
  extends IEvent
{
  public a hTe;
  public b hTf;
  
  public pz()
  {
    this((byte)0);
  }
  
  private pz(byte paramByte)
  {
    AppMethodBeat.i(110275);
    this.hTe = new a();
    this.hTf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(110275);
  }
  
  public static final class a
  {
    public boolean hTg = false;
    public String key;
    public int type = 0;
    public String username;
  }
  
  public static final class b
  {
    public long hTh;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pz
 * JD-Core Version:    0.7.0.1
 */