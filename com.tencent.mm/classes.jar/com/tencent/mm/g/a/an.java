package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class an
  extends b
{
  public a cZJ;
  public b cZK;
  
  public an()
  {
    this((byte)0);
  }
  
  private an(byte paramByte)
  {
    AppMethodBeat.i(131616);
    this.cZJ = new a();
    this.cZK = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(131616);
  }
  
  public static final class a
  {
    public int action = 0;
    public String cZL;
    public long cZM = 0L;
    public boolean cZN = false;
    public Runnable cZO;
    public Context context;
    public int fromScene = 0;
    public int offset = 0;
    public String title;
  }
  
  public static final class b
  {
    public boolean cZP = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.an
 * JD-Core Version:    0.7.0.1
 */