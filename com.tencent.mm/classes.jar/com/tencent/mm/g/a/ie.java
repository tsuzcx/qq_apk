package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ie
  extends b
{
  public a dvL;
  public b dvM;
  
  public ie()
  {
    this((byte)0);
  }
  
  private ie(byte paramByte)
  {
    AppMethodBeat.i(89640);
    this.dvL = new a();
    this.dvM = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(89640);
  }
  
  public static final class a
  {
    public int EN = 0;
    public Context context;
    public String param;
  }
  
  public static final class b
  {
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ie
 * JD-Core Version:    0.7.0.1
 */