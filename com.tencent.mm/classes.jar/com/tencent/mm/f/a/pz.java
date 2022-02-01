package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pz
  extends IEvent
{
  public a fOH;
  
  public pz()
  {
    this((byte)0);
  }
  
  private pz(byte paramByte)
  {
    AppMethodBeat.i(146134);
    this.fOH = new a();
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
    public boolean fOI;
    public String filePath;
    public int fileSize;
    public byte[] frameBuffer;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.pz
 * JD-Core Version:    0.7.0.1
 */