package com.tencent.mm.g.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class vw
  extends b
{
  public a dLv;
  public b dLw;
  
  public vw()
  {
    this((byte)0);
  }
  
  private vw(byte paramByte)
  {
    AppMethodBeat.i(153018);
    this.dLv = new a();
    this.dLw = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(153018);
  }
  
  public static final class a
  {
    public Intent dLx;
    public Activity dtg;
    public int requestCode;
  }
  
  public static final class b
  {
    public boolean drc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.vw
 * JD-Core Version:    0.7.0.1
 */