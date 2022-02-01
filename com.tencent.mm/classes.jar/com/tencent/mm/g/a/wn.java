package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class wn
  extends b
{
  public a dLW;
  public b dLX;
  
  public wn()
  {
    this((byte)0);
  }
  
  private wn(byte paramByte)
  {
    AppMethodBeat.i(116051);
    this.dLW = new a();
    this.dLX = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116051);
  }
  
  public static final class a
  {
    public Context context;
    public String dLY;
    public int opType = 0;
  }
  
  public static final class b
  {
    public String dEo;
    public boolean doq = false;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.wn
 * JD-Core Version:    0.7.0.1
 */