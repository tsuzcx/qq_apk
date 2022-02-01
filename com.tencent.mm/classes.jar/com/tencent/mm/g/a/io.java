package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class io
  extends b
{
  public a dvh;
  public b dvi;
  
  public io()
  {
    this((byte)0);
  }
  
  private io(byte paramByte)
  {
    AppMethodBeat.i(117546);
    this.dvh = new a();
    this.dvi = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(117546);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public Bundle dvj;
    public String result;
    public String username;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.io
 * JD-Core Version:    0.7.0.1
 */