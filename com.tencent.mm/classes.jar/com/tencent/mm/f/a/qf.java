package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qf
  extends IEvent
{
  public a fOS;
  public b fOT;
  
  public qf()
  {
    this((byte)0);
  }
  
  private qf(byte paramByte)
  {
    AppMethodBeat.i(91210);
    this.fOS = new a();
    this.fOT = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91210);
  }
  
  public static final class a
  {
    public int channel;
    public Context context;
    public int scene;
    public String source;
    public int sourceType = 0;
    public String url;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.qf
 * JD-Core Version:    0.7.0.1
 */