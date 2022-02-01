package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class vg
  extends b
{
  public a dAI;
  public b dAJ;
  
  public vg()
  {
    this((byte)0);
  }
  
  private vg(byte paramByte)
  {
    AppMethodBeat.i(116051);
    this.dAI = new a();
    this.dAJ = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(116051);
  }
  
  public static final class a
  {
    public Context context;
    public String dAK;
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
 * Qualified Name:     com.tencent.mm.g.a.vg
 * JD-Core Version:    0.7.0.1
 */