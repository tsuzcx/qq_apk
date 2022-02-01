package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ce
  extends b
{
  public a dbP;
  public b dbQ;
  
  public ce()
  {
    this((byte)0);
  }
  
  private ce(byte paramByte)
  {
    AppMethodBeat.i(149859);
    this.dbP = new a();
    this.dbQ = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(149859);
  }
  
  public static final class a
  {
    public Context context;
    public String dbR;
    public String username;
  }
  
  public static final class b
  {
    public boolean dbS = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ce
 * JD-Core Version:    0.7.0.1
 */