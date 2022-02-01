package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class rm
  extends b
{
  public a dHm;
  public b dHn;
  
  public rm()
  {
    this((byte)0);
  }
  
  private rm(byte paramByte)
  {
    AppMethodBeat.i(149886);
    this.dHm = new a();
    this.dHn = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(149886);
  }
  
  public static final class a
  {
    public Context context;
  }
  
  public static final class b
  {
    public boolean dHb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.rm
 * JD-Core Version:    0.7.0.1
 */