package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uj
  extends IEvent
{
  public a eaI;
  public b eaJ;
  
  public uj()
  {
    this((byte)0);
  }
  
  private uj(byte paramByte)
  {
    AppMethodBeat.i(155375);
    this.eaI = new a();
    this.eaJ = new b();
    this.order = false;
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
 * Qualified Name:     com.tencent.mm.g.a.uj
 * JD-Core Version:    0.7.0.1
 */