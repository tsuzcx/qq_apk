package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class je
  extends IEvent
{
  public a dNT;
  public b dNU;
  
  public je()
  {
    this((byte)0);
  }
  
  private je(byte paramByte)
  {
    AppMethodBeat.i(117546);
    this.dNT = new a();
    this.dNU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117546);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public Bundle dNV;
    public String result;
    public String username;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.je
 * JD-Core Version:    0.7.0.1
 */