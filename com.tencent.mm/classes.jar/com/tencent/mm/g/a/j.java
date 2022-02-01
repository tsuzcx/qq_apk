package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class j
  extends b
{
  public a djO;
  public b djP;
  
  public j()
  {
    this((byte)0);
  }
  
  private j(byte paramByte)
  {
    AppMethodBeat.i(149847);
    this.djO = new a();
    this.djP = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(149847);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public String djQ;
    public boolean djR;
    public boolean djS;
  }
  
  public static final class b
  {
    public Bundle djT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.j
 * JD-Core Version:    0.7.0.1
 */