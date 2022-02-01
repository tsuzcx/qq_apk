package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class xh
  extends b
{
  public a dAb;
  public b dAc;
  
  public xh()
  {
    this((byte)0);
  }
  
  private xh(byte paramByte)
  {
    AppMethodBeat.i(149895);
    this.dAb = new a();
    this.dAc = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(149895);
  }
  
  public static final class a
  {
    public String content;
    public Context context;
    public int dgL = 0;
    public byte[] dzW;
    public int dzX = 0;
    public String talker;
  }
  
  public static final class b
  {
    public boolean dAd = false;
    public boolean dAe = false;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.xh
 * JD-Core Version:    0.7.0.1
 */