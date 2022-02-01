package com.tencent.mm.g.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class vs
  extends b
{
  public a dKg;
  public b dKh;
  
  public vs()
  {
    this((byte)0);
  }
  
  private vs(byte paramByte)
  {
    AppMethodBeat.i(153018);
    this.dKg = new a();
    this.dKh = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(153018);
  }
  
  public static final class a
  {
    public Intent dKi;
    public Activity dsa;
    public int requestCode;
  }
  
  public static final class b
  {
    public boolean dpX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.vs
 * JD-Core Version:    0.7.0.1
 */