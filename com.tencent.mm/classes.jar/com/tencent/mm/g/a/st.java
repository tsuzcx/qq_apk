package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class st
  extends b
{
  public a dvI;
  public b dvJ;
  
  public st()
  {
    this((byte)0);
  }
  
  private st(byte paramByte)
  {
    AppMethodBeat.i(155375);
    this.dvI = new a();
    this.dvJ = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(155375);
  }
  
  public static final class a
  {
    public Intent intent;
    public String username;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.st
 * JD-Core Version:    0.7.0.1
 */