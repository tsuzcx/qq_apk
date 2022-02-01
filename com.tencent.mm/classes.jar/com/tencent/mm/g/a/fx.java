package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fx
  extends b
{
  public a diO;
  public b diP;
  
  public fx()
  {
    this((byte)0);
  }
  
  private fx(byte paramByte)
  {
    AppMethodBeat.i(116023);
    this.diO = new a();
    this.diP = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(116023);
  }
  
  public static final class a
  {
    public String diQ;
    public int diR = 0;
    public Runnable diS;
    public String fileName;
    public int from = 0;
    public int scene;
  }
  
  public static final class b
  {
    public boolean bhb;
    public String content;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.fx
 * JD-Core Version:    0.7.0.1
 */