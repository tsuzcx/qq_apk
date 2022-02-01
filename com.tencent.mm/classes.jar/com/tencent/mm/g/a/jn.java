package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class jn
  extends b
{
  public a dlb;
  public b dlc;
  
  public jn()
  {
    this((byte)0);
  }
  
  private jn(byte paramByte)
  {
    AppMethodBeat.i(93325);
    this.dlb = new a();
    this.dlc = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(93325);
  }
  
  public static final class a
  {
    public Context context;
    public int enterScene = 0;
    public int scene = 0;
  }
  
  public static final class b
  {
    public String targetActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.jn
 * JD-Core Version:    0.7.0.1
 */