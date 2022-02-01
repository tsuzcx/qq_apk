package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ns
  extends b
{
  public a dsO;
  
  public ns()
  {
    this((byte)0);
  }
  
  private ns(byte paramByte)
  {
    AppMethodBeat.i(146134);
    this.dsO = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(146134);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public boolean dsP;
    public int duration;
    public int errCode;
    public String errMsg;
    public String filePath;
    public int fileSize;
    public byte[] frameBuffer;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ns
 * JD-Core Version:    0.7.0.1
 */