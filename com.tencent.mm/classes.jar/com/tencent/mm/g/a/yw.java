package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class yw
  extends b
{
  public a dOR;
  
  public yw()
  {
    this((byte)0);
  }
  
  private yw(byte paramByte)
  {
    AppMethodBeat.i(91228);
    this.dOR = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(91228);
  }
  
  public static final class a
  {
    public int dOQ = 0;
    public String dmw;
    public Intent intent;
    public int requestCode = 0;
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.yw
 * JD-Core Version:    0.7.0.1
 */