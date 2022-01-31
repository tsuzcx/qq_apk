package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mz
  extends b
{
  public a cDc;
  public b cDd;
  
  public mz()
  {
    this((byte)0);
  }
  
  private mz(byte paramByte)
  {
    AppMethodBeat.i(135761);
    this.cDc = new a();
    this.cDd = new b();
    this.ymq = false;
    this.callback = null;
    AppMethodBeat.o(135761);
  }
  
  public static final class a
  {
    public String cDe;
    public Context context;
    public int opType = 0;
  }
  
  public static final class b
  {
    public String cDf;
    public boolean cpz = false;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.mz
 * JD-Core Version:    0.7.0.1
 */