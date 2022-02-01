package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class pe
  extends b
{
  public a dDg;
  public b dDh;
  
  public pe()
  {
    this((byte)0);
  }
  
  private pe(byte paramByte)
  {
    AppMethodBeat.i(117551);
    this.dDg = new a();
    this.dDh = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(117551);
  }
  
  public static final class a
  {
    public Context context;
    public String dDi;
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
 * Qualified Name:     com.tencent.mm.g.a.pe
 * JD-Core Version:    0.7.0.1
 */