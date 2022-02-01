package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class om
  extends IEvent
{
  public a dUz;
  
  public om()
  {
    this((byte)0);
  }
  
  private om(byte paramByte)
  {
    AppMethodBeat.i(117613);
    this.dUz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117613);
  }
  
  public static final class a
  {
    public String appId;
    public String dUA;
    public String dUB;
    public int scene;
    public int type;
    public String url;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.om
 * JD-Core Version:    0.7.0.1
 */