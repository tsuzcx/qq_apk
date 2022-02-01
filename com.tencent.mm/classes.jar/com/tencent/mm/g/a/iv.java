package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iv
  extends IEvent
{
  public a dNx;
  
  public iv()
  {
    this((byte)0);
  }
  
  private iv(byte paramByte)
  {
    AppMethodBeat.i(89642);
    this.dNx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89642);
  }
  
  public static final class a
  {
    public String appId;
    public String extInfo;
    public String md5;
    public int scene;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.iv
 * JD-Core Version:    0.7.0.1
 */