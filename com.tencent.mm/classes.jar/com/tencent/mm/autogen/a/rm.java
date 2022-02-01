package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rm
  extends IEvent
{
  public a hUA;
  
  public rm()
  {
    this((byte)0);
  }
  
  private rm(byte paramByte)
  {
    AppMethodBeat.i(146134);
    this.hUA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(146134);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public int duration;
    public int errCode;
    public String errMsg;
    public String filePath;
    public int fileSize;
    public byte[] frameBuffer;
    public boolean hUB;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rm
 * JD-Core Version:    0.7.0.1
 */