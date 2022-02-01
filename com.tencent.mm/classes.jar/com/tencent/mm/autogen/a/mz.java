package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mz
  extends IEvent
{
  public a hPi;
  
  public mz()
  {
    this((byte)0);
  }
  
  private mz(byte paramByte)
  {
    AppMethodBeat.i(63289);
    this.hPi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63289);
  }
  
  public static final class a
  {
    public Context context;
    public String hPj;
    public Long hPk;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.mz
 * JD-Core Version:    0.7.0.1
 */