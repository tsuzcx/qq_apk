package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class nw
  extends b
{
  public a dsV;
  public b dsW;
  
  public nw()
  {
    this((byte)0);
  }
  
  private nw(byte paramByte)
  {
    AppMethodBeat.i(91210);
    this.dsV = new a();
    this.dsW = new b();
    this.ESR = false;
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
 * Qualified Name:     com.tencent.mm.g.a.nw
 * JD-Core Version:    0.7.0.1
 */