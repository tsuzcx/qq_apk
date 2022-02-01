package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mr
  extends b
{
  public a dph;
  
  public mr()
  {
    this((byte)0);
  }
  
  private mr(byte paramByte)
  {
    AppMethodBeat.i(89647);
    this.dph = new a();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(89647);
  }
  
  public static final class a
  {
    public Context context;
    public String group;
    public Intent intent;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.mr
 * JD-Core Version:    0.7.0.1
 */