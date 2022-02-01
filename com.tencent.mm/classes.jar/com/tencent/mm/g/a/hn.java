package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hn
  extends IEvent
{
  public a dLW;
  
  public hn()
  {
    this((byte)0);
  }
  
  private hn(byte paramByte)
  {
    AppMethodBeat.i(168880);
    this.dLW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168880);
  }
  
  public static final class a
  {
    public int dLK;
    public int dLX;
    public int dLY;
    public int dLZ;
    public int dMa;
    public int dMb;
    public String dMc;
    public long id;
    public int likeCount;
    public int liveStatus;
    public int type;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hn
 * JD-Core Version:    0.7.0.1
 */