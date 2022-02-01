package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class qm
  extends b
{
  public a dwd;
  
  public qm()
  {
    this((byte)0);
  }
  
  private qm(byte paramByte)
  {
    AppMethodBeat.i(91217);
    this.dwd = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(91217);
  }
  
  public static final class a
  {
    public Context context;
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qm
 * JD-Core Version:    0.7.0.1
 */