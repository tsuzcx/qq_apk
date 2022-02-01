package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ww
  extends b
{
  public a dCp;
  public b dCq;
  
  public ww()
  {
    this((byte)0);
  }
  
  private ww(byte paramByte)
  {
    AppMethodBeat.i(149895);
    this.dCp = new a();
    this.dCq = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(149895);
  }
  
  public static final class a
  {
    public String content;
    public Context context;
    public byte[] dCi;
    public int dCj = 0;
    public int djq = 0;
    public String talker;
  }
  
  public static final class b
  {
    public boolean dCr = false;
    public boolean dCs = false;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ww
 * JD-Core Version:    0.7.0.1
 */