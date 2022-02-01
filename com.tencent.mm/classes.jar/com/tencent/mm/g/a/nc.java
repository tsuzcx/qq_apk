package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class nc
  extends b
{
  public a dpI;
  public nc.b dpJ;
  
  public nc()
  {
    this((byte)0);
  }
  
  private nc(byte paramByte)
  {
    AppMethodBeat.i(127408);
    this.dpI = new a();
    this.dpJ = new nc.b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(127408);
  }
  
  public static final class a
  {
    public Context context;
    public int dhE = 0;
    public int dhF = 0;
    public Bundle dpD;
    public int dpE = 0;
    public String dpK;
    public long dpL = 0L;
    public String dpy;
    public String jsonString;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.nc
 * JD-Core Version:    0.7.0.1
 */