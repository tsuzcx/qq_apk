package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class rl
  extends b
{
  public a dHk;
  public b dHl;
  
  public rl()
  {
    this((byte)0);
  }
  
  private rl(byte paramByte)
  {
    AppMethodBeat.i(149885);
    this.dHk = new a();
    this.dHl = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(149885);
  }
  
  public static final class a
  {
    public Context context;
    public int dHe;
    public Bundle extras;
  }
  
  public static final class b
  {
    public boolean dHb;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.rl
 * JD-Core Version:    0.7.0.1
 */