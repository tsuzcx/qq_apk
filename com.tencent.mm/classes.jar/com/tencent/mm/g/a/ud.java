package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ud
  extends b
{
  public a dIC;
  
  public ud()
  {
    this((byte)0);
  }
  
  private ud(byte paramByte)
  {
    AppMethodBeat.i(197543);
    this.dIC = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(197543);
  }
  
  public static final class a
  {
    public int EN;
    public int bZU;
    public Intent dxy;
    public int requestCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ud
 * JD-Core Version:    0.7.0.1
 */