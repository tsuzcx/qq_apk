package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ep
  extends b
{
  public a dqN;
  
  public ep()
  {
    this((byte)0);
  }
  
  private ep(byte paramByte)
  {
    AppMethodBeat.i(116002);
    this.dqN = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116002);
  }
  
  public static final class a
  {
    public Context context;
    public int op = 0;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ep
 * JD-Core Version:    0.7.0.1
 */