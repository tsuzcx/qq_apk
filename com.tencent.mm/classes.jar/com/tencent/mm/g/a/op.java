package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class op
  extends b
{
  public a dDB;
  public b dDC;
  
  public op()
  {
    this((byte)0);
  }
  
  private op(byte paramByte)
  {
    AppMethodBeat.i(91210);
    this.dDB = new a();
    this.dDC = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(91210);
  }
  
  public static final class a
  {
    public int channel;
    public Context context;
    public int scene;
    public String source;
    public int sourceType = 0;
    public String url;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.op
 * JD-Core Version:    0.7.0.1
 */