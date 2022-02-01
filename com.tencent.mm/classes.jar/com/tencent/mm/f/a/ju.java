package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ju
  extends IEvent
{
  public a fHe;
  public b fHf;
  
  public ju()
  {
    this((byte)0);
  }
  
  private ju(byte paramByte)
  {
    AppMethodBeat.i(117546);
    this.fHe = new a();
    this.fHf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117546);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public Bundle fHg;
    public String result;
    public String username;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ju
 * JD-Core Version:    0.7.0.1
 */