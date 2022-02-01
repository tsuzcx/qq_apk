package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class xl
  extends b
{
  public a dDC;
  
  public xl()
  {
    this((byte)0);
  }
  
  private xl(byte paramByte)
  {
    AppMethodBeat.i(91228);
    this.dDC = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(91228);
  }
  
  public static final class a
  {
    public int dDB = 0;
    public String dcE;
    public Intent intent;
    public int requestCode = 0;
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.xl
 * JD-Core Version:    0.7.0.1
 */