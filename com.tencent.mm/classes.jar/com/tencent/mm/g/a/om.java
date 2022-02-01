package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class om
  extends b
{
  public a dtD;
  public b dtE;
  
  public om()
  {
    this((byte)0);
  }
  
  private om(byte paramByte)
  {
    AppMethodBeat.i(117551);
    this.dtD = new a();
    this.dtE = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(117551);
  }
  
  public static final class a
  {
    public Context context;
    public String dtF;
    public int opType = 0;
  }
  
  public static final class b
  {
    public boolean dew = false;
    public String dtG;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.om
 * JD-Core Version:    0.7.0.1
 */