package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ek
  extends b
{
  public a dgR;
  
  public ek()
  {
    this((byte)0);
  }
  
  private ek(byte paramByte)
  {
    AppMethodBeat.i(116002);
    this.dgR = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(116002);
  }
  
  public static final class a
  {
    public Context context;
    public int op = 0;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ek
 * JD-Core Version:    0.7.0.1
 */