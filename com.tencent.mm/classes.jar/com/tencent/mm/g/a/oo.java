package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class oo
  extends b
{
  public a dCw;
  public b dCx;
  
  public oo()
  {
    this((byte)0);
  }
  
  private oo(byte paramByte)
  {
    AppMethodBeat.i(91210);
    this.dCw = new a();
    this.dCx = new b();
    this.IbR = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.oo
 * JD-Core Version:    0.7.0.1
 */