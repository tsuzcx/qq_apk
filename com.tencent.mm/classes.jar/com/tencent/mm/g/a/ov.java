package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ov
  extends b
{
  public a dro;
  public b drp;
  
  public ov()
  {
    this((byte)0);
  }
  
  private ov(byte paramByte)
  {
    AppMethodBeat.i(117551);
    this.dro = new a();
    this.drp = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(117551);
  }
  
  public static final class a
  {
    public Context context;
    public String drq;
    public int opType = 0;
  }
  
  public static final class b
  {
    public boolean dbS = false;
    public String drr;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ov
 * JD-Core Version:    0.7.0.1
 */