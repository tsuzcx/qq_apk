package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mj
  extends b
{
  public a dzR;
  public b dzS;
  
  public mj()
  {
    this((byte)0);
  }
  
  private mj(byte paramByte)
  {
    AppMethodBeat.i(155373);
    this.dzR = new a();
    this.dzS = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(155373);
  }
  
  public static final class a
  {
    public Activity dsa;
    public Runnable dzT;
  }
  
  public static final class b
  {
    public boolean dno = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.mj
 * JD-Core Version:    0.7.0.1
 */