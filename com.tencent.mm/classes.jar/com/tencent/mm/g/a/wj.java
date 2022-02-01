package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class wj
  extends b
{
  public a dKH;
  public b dKI;
  
  public wj()
  {
    this((byte)0);
  }
  
  private wj(byte paramByte)
  {
    AppMethodBeat.i(116051);
    this.dKH = new a();
    this.dKI = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(116051);
  }
  
  public static final class a
  {
    public Context context;
    public String dKJ;
    public int opType = 0;
  }
  
  public static final class b
  {
    public String dDj;
    public boolean dno = false;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.wj
 * JD-Core Version:    0.7.0.1
 */