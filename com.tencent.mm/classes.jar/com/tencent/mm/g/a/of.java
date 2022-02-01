package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class of
  extends b
{
  public a dqF;
  public b dqG;
  
  public of()
  {
    this((byte)0);
  }
  
  private of(byte paramByte)
  {
    AppMethodBeat.i(91210);
    this.dqF = new a();
    this.dqG = new b();
    this.Gqe = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.of
 * JD-Core Version:    0.7.0.1
 */