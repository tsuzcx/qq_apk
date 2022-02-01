package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class gl
  extends b
{
  public a dgY;
  public b dgZ;
  
  public gl()
  {
    this((byte)0);
  }
  
  private gl(byte paramByte)
  {
    AppMethodBeat.i(116028);
    this.dgY = new a();
    this.dgZ = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(116028);
  }
  
  public static final class a
  {
    public int state = -1;
  }
  
  public static final class b
  {
    public boolean dbS = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gl
 * JD-Core Version:    0.7.0.1
 */