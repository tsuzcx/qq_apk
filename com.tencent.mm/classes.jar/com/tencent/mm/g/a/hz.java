package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class hz
  extends b
{
  public a dvA;
  public b dvB;
  
  public hz()
  {
    this((byte)0);
  }
  
  private hz(byte paramByte)
  {
    AppMethodBeat.i(19811);
    this.dvA = new a();
    this.dvB = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(19811);
  }
  
  public static final class a
  {
    public Intent intent;
  }
  
  public static final class b
  {
    public int drN = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.hz
 * JD-Core Version:    0.7.0.1
 */