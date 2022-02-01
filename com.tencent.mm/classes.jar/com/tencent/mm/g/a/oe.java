package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class oe
  extends b
{
  public a dCd;
  
  public oe()
  {
    this((byte)0);
  }
  
  private oe(byte paramByte)
  {
    AppMethodBeat.i(89648);
    this.dCd = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(89648);
  }
  
  public static final class a
  {
    public Context context;
    public int dCe;
    public String extraInfo;
    public int jumpType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.oe
 * JD-Core Version:    0.7.0.1
 */