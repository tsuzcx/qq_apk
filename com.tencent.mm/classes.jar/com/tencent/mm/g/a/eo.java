package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class eo
  extends b
{
  public a dpI;
  
  public eo()
  {
    this((byte)0);
  }
  
  private eo(byte paramByte)
  {
    AppMethodBeat.i(116002);
    this.dpI = new a();
    this.IbR = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.eo
 * JD-Core Version:    0.7.0.1
 */