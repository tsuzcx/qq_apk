package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abw
  extends IEvent
{
  public a gbS;
  
  public abw()
  {
    this((byte)0);
  }
  
  private abw(byte paramByte)
  {
    AppMethodBeat.i(19849);
    this.gbS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19849);
  }
  
  public static final class a
  {
    public byte[] data;
    public int fvK;
    public String fzB;
    public String fzF;
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.abw
 * JD-Core Version:    0.7.0.1
 */