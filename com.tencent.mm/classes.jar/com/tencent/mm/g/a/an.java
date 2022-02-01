package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class an
  extends b
{
  public a dlb;
  public b dlc;
  
  public an()
  {
    this((byte)0);
  }
  
  private an(byte paramByte)
  {
    AppMethodBeat.i(131616);
    this.dlb = new a();
    this.dlc = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(131616);
  }
  
  public static final class a
  {
    public int action = 0;
    public Context context;
    public String dld;
    public long dle = 0L;
    public boolean dlf = false;
    public Runnable dlg;
    public int fromScene = 0;
    public int offset = 0;
    public String title;
  }
  
  public static final class b
  {
    public boolean dlh = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.an
 * JD-Core Version:    0.7.0.1
 */