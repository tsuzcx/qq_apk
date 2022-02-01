package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class yh
  extends b
{
  public a dNE;
  public b dNF;
  
  public yh()
  {
    this((byte)0);
  }
  
  private yh(byte paramByte)
  {
    AppMethodBeat.i(149895);
    this.dNE = new a();
    this.dNF = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(149895);
  }
  
  public static final class a
  {
    public String content;
    public Context context;
    public int dNA = 0;
    public byte[] dNz;
    public int dto = 0;
    public String talker;
  }
  
  public static final class b
  {
    public boolean dNG = false;
    public boolean dNH = false;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.yh
 * JD-Core Version:    0.7.0.1
 */