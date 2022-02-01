package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class sk
  extends b
{
  public a dxW;
  public b dxX;
  
  public sk()
  {
    this((byte)0);
  }
  
  private sk(byte paramByte)
  {
    AppMethodBeat.i(155375);
    this.dxW = new a();
    this.dxX = new b();
    this.ESR = false;
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
 * Qualified Name:     com.tencent.mm.g.a.sk
 * JD-Core Version:    0.7.0.1
 */