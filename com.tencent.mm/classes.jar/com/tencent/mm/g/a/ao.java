package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ao
  extends b
{
  public a dcv;
  public b dcw;
  
  public ao()
  {
    this((byte)0);
  }
  
  private ao(byte paramByte)
  {
    AppMethodBeat.i(155543);
    this.dcv = new a();
    this.dcw = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(155543);
  }
  
  public static final class a
  {
    public String dcx;
    public int position = 0;
    public int type;
  }
  
  public static final class b
  {
    public String Title;
    public int dcA = 0;
    public int dcB = 0;
    public String dcC;
    public int dcy = 0;
    public int dcz = 0;
    public String desc;
    public int position = 0;
    public String url;
    public boolean visible = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ao
 * JD-Core Version:    0.7.0.1
 */