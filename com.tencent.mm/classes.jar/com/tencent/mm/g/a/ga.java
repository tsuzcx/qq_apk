package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.sdk.b.b;

public final class ga
  extends b
{
  public a dsz;
  
  public ga()
  {
    this((byte)0);
  }
  
  private ga(byte paramByte)
  {
    AppMethodBeat.i(116022);
    this.dsz = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116022);
  }
  
  public static final class a
  {
    public boolean dsA;
    public boolean dsB;
    public int dsC;
    public bq.a dsD;
    public int type;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ga
 * JD-Core Version:    0.7.0.1
 */