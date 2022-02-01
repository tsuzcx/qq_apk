package com.tencent.mm.autogen.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kw
  extends IEvent
{
  public a hMB;
  public b hMC;
  
  public kw()
  {
    this((byte)0);
  }
  
  private kw(byte paramByte)
  {
    AppMethodBeat.i(117546);
    this.hMB = new a();
    this.hMC = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117546);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public Bundle hMD;
    public String result;
    public String username;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kw
 * JD-Core Version:    0.7.0.1
 */