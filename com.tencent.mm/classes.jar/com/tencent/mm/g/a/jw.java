package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class jw
  extends b
{
  public a dxT;
  public b dxU;
  
  public jw()
  {
    this((byte)0);
  }
  
  private jw(byte paramByte)
  {
    AppMethodBeat.i(93325);
    this.dxT = new a();
    this.dxU = new b();
    this.IvZ = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.jw
 * JD-Core Version:    0.7.0.1
 */