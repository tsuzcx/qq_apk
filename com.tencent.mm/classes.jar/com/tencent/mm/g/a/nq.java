package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class nq
  extends b
{
  public a dsK;
  
  public nq()
  {
    this((byte)0);
  }
  
  private nq(byte paramByte)
  {
    AppMethodBeat.i(127409);
    this.dsK = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(127409);
  }
  
  public static final class a
  {
    public Context context;
    public boolean drV = true;
    public String dsL;
    public long msgId = -1L;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.nq
 * JD-Core Version:    0.7.0.1
 */