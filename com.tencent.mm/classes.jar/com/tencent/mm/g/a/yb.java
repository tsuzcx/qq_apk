package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class yb
  extends b
{
  public a dMo;
  public b dMp;
  
  public yb()
  {
    this((byte)0);
  }
  
  private yb(byte paramByte)
  {
    AppMethodBeat.i(149895);
    this.dMo = new a();
    this.dMp = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(149895);
  }
  
  public static final class a
  {
    public String content;
    public Context context;
    public byte[] dMj;
    public int dMk = 0;
    public int dsi = 0;
    public String talker;
  }
  
  public static final class b
  {
    public boolean dMq = false;
    public boolean dMr = false;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.yb
 * JD-Core Version:    0.7.0.1
 */