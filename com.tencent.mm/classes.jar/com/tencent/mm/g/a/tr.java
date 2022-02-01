package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class tr
  extends b
{
  public a dIc;
  
  public tr()
  {
    this((byte)0);
  }
  
  private tr(byte paramByte)
  {
    AppMethodBeat.i(195189);
    this.dIc = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(195189);
  }
  
  public static final class a
  {
    public String action;
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.tr
 * JD-Core Version:    0.7.0.1
 */