package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class xw
  extends b
{
  public a dBo;
  
  public xw()
  {
    this((byte)0);
  }
  
  private xw(byte paramByte)
  {
    AppMethodBeat.i(91228);
    this.dBo = new a();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(91228);
  }
  
  public static final class a
  {
    public int dBn = 0;
    public String dac;
    public Intent intent;
    public int requestCode = 0;
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.xw
 * JD-Core Version:    0.7.0.1
 */