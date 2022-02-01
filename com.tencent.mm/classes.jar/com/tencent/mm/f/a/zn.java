package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zn
  extends IEvent
{
  public a fYQ;
  
  public zn()
  {
    this((byte)0);
  }
  
  private zn(byte paramByte)
  {
    AppMethodBeat.i(140991);
    this.fYQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140991);
  }
  
  public static final class a
  {
    public String desc;
    public int fwo = 0;
    public int fwp = 0;
    public int fwq = 0;
    public String fwr;
    public int fws = 0;
    public String fwt;
    public int position = 0;
    public String url;
    public boolean visible = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.zn
 * JD-Core Version:    0.7.0.1
 */