package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class qq
  extends b
{
  public a dwr;
  public b dws;
  
  public qq()
  {
    this((byte)0);
  }
  
  private qq(byte paramByte)
  {
    AppMethodBeat.i(149885);
    this.dwr = new a();
    this.dws = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(149885);
  }
  
  public static final class a
  {
    public Context context;
    public int dwl;
    public Bundle extras;
  }
  
  public static final class b
  {
    public boolean dwi;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qq
 * JD-Core Version:    0.7.0.1
 */