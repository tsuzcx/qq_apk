package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class km
  extends IEvent
{
  public a hMf;
  
  public km()
  {
    this((byte)0);
  }
  
  private km(byte paramByte)
  {
    AppMethodBeat.i(89642);
    this.hMf = new a();
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
 * Qualified Name:     com.tencent.mm.autogen.a.km
 * JD-Core Version:    0.7.0.1
 */