package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ph
  extends b
{
  public a dEs;
  public b dEt;
  
  public ph()
  {
    this((byte)0);
  }
  
  private ph(byte paramByte)
  {
    AppMethodBeat.i(149879);
    this.dEs = new a();
    this.dEt = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(149879);
  }
  
  public static final class a
  {
    public int dEu = 0;
    public String dEv;
    public int dzG = 10;
    public String label;
    public double lat = -1.0D;
    public double lng = -1.0D;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ph
 * JD-Core Version:    0.7.0.1
 */