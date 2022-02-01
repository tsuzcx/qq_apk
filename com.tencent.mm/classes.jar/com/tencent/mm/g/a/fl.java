package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fl
  extends b
{
  public a dhN;
  public b dhO;
  
  public fl()
  {
    this((byte)0);
  }
  
  private fl(byte paramByte)
  {
    AppMethodBeat.i(19805);
    this.dhN = new a();
    this.dhO = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(19805);
  }
  
  public static final class a
  {
    public String bssid;
    public int dhP;
    public String ssid;
    public int version = 1;
  }
  
  public static final class b
  {
    public int dhQ = 0;
    public int dhR = 0;
    public String dhS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fl
 * JD-Core Version:    0.7.0.1
 */