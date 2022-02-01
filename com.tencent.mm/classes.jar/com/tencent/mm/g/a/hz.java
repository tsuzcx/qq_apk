package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class hz
  extends b
{
  public a dlM;
  public b dlN;
  
  public hz()
  {
    this((byte)0);
  }
  
  private hz(byte paramByte)
  {
    AppMethodBeat.i(117546);
    this.dlM = new a();
    this.dlN = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(117546);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public Bundle dlO;
    public String result;
    public String username;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hz
 * JD-Core Version:    0.7.0.1
 */