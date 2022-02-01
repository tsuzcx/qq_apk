package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class nb
  extends b
{
  public a dCa;
  public b dCb;
  
  public nb()
  {
    this((byte)0);
  }
  
  private nb(byte paramByte)
  {
    AppMethodBeat.i(110275);
    this.dCa = new a();
    this.dCb = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(110275);
  }
  
  public static final class a
  {
    public boolean dCc = false;
    public String key;
    public int type = 0;
    public String username;
  }
  
  public static final class b
  {
    public long dCd;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.nb
 * JD-Core Version:    0.7.0.1
 */