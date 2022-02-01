package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mt
  extends b
{
  public a drX;
  public b drY;
  
  public mt()
  {
    this((byte)0);
  }
  
  private mt(byte paramByte)
  {
    AppMethodBeat.i(127408);
    this.drX = new a();
    this.drY = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(127408);
  }
  
  public static final class a
  {
    public Context context;
    public int dkj = 0;
    public int dkk = 0;
    public String drN;
    public Bundle drS;
    public int drT = 0;
    public String drZ;
    public long dsa = 0L;
    public String jsonString;
    public int type = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.mt
 * JD-Core Version:    0.7.0.1
 */