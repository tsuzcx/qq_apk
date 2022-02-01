package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class nk
  extends b
{
  public a dBv;
  public nk.b dBw;
  
  public nk()
  {
    this((byte)0);
  }
  
  private nk(byte paramByte)
  {
    AppMethodBeat.i(127408);
    this.dBv = new a();
    this.dBw = new nk.b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(127408);
  }
  
  public static final class a
  {
    public Context context;
    public String dBl;
    public Bundle dBq;
    public int dBr = 0;
    public String dBx;
    public long dBy = 0L;
    public int dtc = 0;
    public int dtd = 0;
    public String jsonString;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.nk
 * JD-Core Version:    0.7.0.1
 */