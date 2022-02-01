package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mi
  extends b
{
  public a drw;
  
  public mi()
  {
    this((byte)0);
  }
  
  private mi(byte paramByte)
  {
    AppMethodBeat.i(89647);
    this.drw = new a();
    this.ESR = false;
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
 * Qualified Name:     com.tencent.mm.g.a.mi
 * JD-Core Version:    0.7.0.1
 */