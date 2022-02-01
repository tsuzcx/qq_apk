package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class os
  extends b
{
  public a dDJ;
  public b dDK;
  
  public os()
  {
    this((byte)0);
  }
  
  private os(byte paramByte)
  {
    AppMethodBeat.i(130031);
    this.dDJ = new a();
    this.dDK = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(130031);
  }
  
  public static final class a
  {
    public boolean dDL = false;
    public boolean dDM = false;
    public int type;
  }
  
  public static final class b
  {
    public boolean dDN = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.os
 * JD-Core Version:    0.7.0.1
 */