package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class nl
  extends b
{
  public a dCA;
  public b dCB;
  
  public nl()
  {
    this((byte)0);
  }
  
  private nl(byte paramByte)
  {
    AppMethodBeat.i(127408);
    this.dCA = new a();
    this.dCB = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(127408);
  }
  
  public static final class a
  {
    public Context context;
    public String dCC;
    public long dCD = 0L;
    public String dCq;
    public Bundle dCv;
    public int dCw = 0;
    public int dui = 0;
    public int duj = 0;
    public String jsonString;
    public int type = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.nl
 * JD-Core Version:    0.7.0.1
 */