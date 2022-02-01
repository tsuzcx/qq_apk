package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class am
  extends b
{
  public a dck;
  public b dcl;
  
  public am()
  {
    this((byte)0);
  }
  
  private am(byte paramByte)
  {
    AppMethodBeat.i(131616);
    this.dck = new a();
    this.dcl = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(131616);
  }
  
  public static final class a
  {
    public int action = 0;
    public Context context;
    public String dcm;
    public long dcn = 0L;
    public boolean dco = false;
    public Runnable dcp;
    public int fromScene = 0;
    public int offset = 0;
    public String title;
  }
  
  public static final class b
  {
    public boolean dcq = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.am
 * JD-Core Version:    0.7.0.1
 */