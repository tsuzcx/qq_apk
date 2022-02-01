package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class jv
  extends b
{
  public a dwO;
  public b dwP;
  
  public jv()
  {
    this((byte)0);
  }
  
  private jv(byte paramByte)
  {
    AppMethodBeat.i(93325);
    this.dwO = new a();
    this.dwP = new b();
    this.IbR = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.jv
 * JD-Core Version:    0.7.0.1
 */