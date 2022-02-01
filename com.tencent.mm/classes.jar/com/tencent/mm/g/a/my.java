package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class my
  extends b
{
  public a dBW;
  
  public my()
  {
    this((byte)0);
  }
  
  private my(byte paramByte)
  {
    AppMethodBeat.i(116036);
    this.dBW = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116036);
  }
  
  public static final class a
  {
    public Activity activity;
    public int dBU = 0;
    public Bundle dBX;
    public String dmI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.my
 * JD-Core Version:    0.7.0.1
 */