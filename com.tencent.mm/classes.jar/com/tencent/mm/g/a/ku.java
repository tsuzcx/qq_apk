package com.tencent.mm.g.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ku
  extends b
{
  public a dxR;
  public b dxS;
  
  public ku()
  {
    this((byte)0);
  }
  
  private ku(byte paramByte)
  {
    AppMethodBeat.i(217043);
    this.dxR = new a();
    this.dxS = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(217043);
  }
  
  public static final class a
  {
    public Runnable cDO;
    public Bundle dxT;
    public String dxU;
    public int type = 0;
  }
  
  public static final class b
  {
    public Bundle dxV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ku
 * JD-Core Version:    0.7.0.1
 */