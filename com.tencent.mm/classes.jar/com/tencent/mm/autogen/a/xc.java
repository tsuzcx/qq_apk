package com.tencent.mm.autogen.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xc
  extends IEvent
{
  public a iaC;
  public b iaD;
  
  public xc()
  {
    this((byte)0);
  }
  
  private xc(byte paramByte)
  {
    AppMethodBeat.i(155375);
    this.iaC = new a();
    this.iaD = new b();
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
 * Qualified Name:     com.tencent.mm.autogen.a.xc
 * JD-Core Version:    0.7.0.1
 */