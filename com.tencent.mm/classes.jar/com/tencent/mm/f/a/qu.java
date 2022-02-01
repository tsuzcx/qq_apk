package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qu
  extends IEvent
{
  public a fPA;
  
  public qu()
  {
    this((byte)0);
  }
  
  private qu(byte paramByte)
  {
    AppMethodBeat.i(168630);
    this.fPA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168630);
  }
  
  public static final class a
  {
    public int fPB;
    public boolean fPC;
    public String fPD;
    public String mediaId;
    public int size;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.a.qu
 * JD-Core Version:    0.7.0.1
 */