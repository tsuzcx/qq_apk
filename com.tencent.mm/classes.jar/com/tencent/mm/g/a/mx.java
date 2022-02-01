package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mx
  extends b
{
  public a dAR;
  
  public mx()
  {
    this((byte)0);
  }
  
  private mx(byte paramByte)
  {
    AppMethodBeat.i(116036);
    this.dAR = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(116036);
  }
  
  public static final class a
  {
    public Activity activity;
    public int dAP = 0;
    public Bundle dAS;
    public String dlG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mx
 * JD-Core Version:    0.7.0.1
 */