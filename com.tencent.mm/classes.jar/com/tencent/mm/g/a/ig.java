package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ig
  extends b
{
  public a dju;
  public b djv;
  
  public ig()
  {
    this((byte)0);
  }
  
  private ig(byte paramByte)
  {
    AppMethodBeat.i(117546);
    this.dju = new a();
    this.djv = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(117546);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public Bundle djw;
    public String result;
    public String username;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ig
 * JD-Core Version:    0.7.0.1
 */