package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class tk
  extends b
{
  public a dHR;
  public b dHS;
  
  public tk()
  {
    this((byte)0);
  }
  
  private tk(byte paramByte)
  {
    AppMethodBeat.i(155375);
    this.dHR = new a();
    this.dHS = new b();
    this.IbR = false;
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
 * Qualified Name:     com.tencent.mm.g.a.tk
 * JD-Core Version:    0.7.0.1
 */