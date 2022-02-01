package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class qo
  extends b
{
  public a dwj;
  public b dwk;
  
  public qo()
  {
    this((byte)0);
  }
  
  private qo(byte paramByte)
  {
    AppMethodBeat.i(149884);
    this.dwj = new a();
    this.dwk = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(149884);
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
 * Qualified Name:     com.tencent.mm.g.a.qo
 * JD-Core Version:    0.7.0.1
 */