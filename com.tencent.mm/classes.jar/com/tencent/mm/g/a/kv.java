package com.tencent.mm.g.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class kv
  extends b
{
  public a dyW;
  public b dyX;
  
  public kv()
  {
    this((byte)0);
  }
  
  private kv(byte paramByte)
  {
    AppMethodBeat.i(208247);
    this.dyW = new a();
    this.dyX = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(208247);
  }
  
  public static final class a
  {
    public Runnable cEv;
    public Bundle dyY;
    public String dyZ;
    public int type = 0;
  }
  
  public static final class b
  {
    public Bundle dza;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.kv
 * JD-Core Version:    0.7.0.1
 */