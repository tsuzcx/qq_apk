package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fp
  extends b
{
  public a dqE;
  public b dqF;
  
  public fp()
  {
    this((byte)0);
  }
  
  private fp(byte paramByte)
  {
    AppMethodBeat.i(19805);
    this.dqE = new a();
    this.dqF = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(19805);
  }
  
  public static final class a
  {
    public String bssid;
    public int dqG;
    public String ssid;
    public int version = 1;
  }
  
  public static final class b
  {
    public int dqH = 0;
    public int dqI = 0;
    public String dqJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.fp
 * JD-Core Version:    0.7.0.1
 */