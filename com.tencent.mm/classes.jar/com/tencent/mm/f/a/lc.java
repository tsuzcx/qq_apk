package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lc
  extends IEvent
{
  public a fIO;
  public b fIP;
  
  public lc()
  {
    this((byte)0);
  }
  
  private lc(byte paramByte)
  {
    AppMethodBeat.i(93325);
    this.fIO = new a();
    this.fIP = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93325);
  }
  
  public static final class a
  {
    public Context context;
    public int enterScene = 0;
    public int scene = 0;
  }
  
  public static final class b
  {
    public String fIQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.lc
 * JD-Core Version:    0.7.0.1
 */