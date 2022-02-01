package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class an
  extends b
{
  public a dmd;
  public b dme;
  
  public an()
  {
    this((byte)0);
  }
  
  private an(byte paramByte)
  {
    AppMethodBeat.i(131616);
    this.dmd = new a();
    this.dme = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(131616);
  }
  
  public static final class a
  {
    public int action = 0;
    public Context context;
    public String dmf;
    public long dmg = 0L;
    public boolean dmh = false;
    public Runnable dmi;
    public int fromScene = 0;
    public int offset = 0;
    public String title;
  }
  
  public static final class b
  {
    public boolean dmj = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.an
 * JD-Core Version:    0.7.0.1
 */