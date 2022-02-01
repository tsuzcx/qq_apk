package com.tencent.mm.autogen.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rk
  extends IEvent
{
  public a hUw;
  
  public rk()
  {
    this((byte)0);
  }
  
  private rk(byte paramByte)
  {
    AppMethodBeat.i(127409);
    this.hUw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127409);
  }
  
  public static final class a
  {
    public Context context;
    public Bundle hTF;
    public boolean hTH = true;
    public String hUx;
    public long msgId = -1L;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rk
 * JD-Core Version:    0.7.0.1
 */