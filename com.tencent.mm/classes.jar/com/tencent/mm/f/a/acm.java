package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acm
  extends IEvent
{
  public a gcM;
  
  public acm()
  {
    this((byte)0);
  }
  
  private acm(byte paramByte)
  {
    AppMethodBeat.i(191243);
    this.gcM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(191243);
  }
  
  public static final class a
  {
    public String appId;
    public int cBI;
    public String filePath;
    public String md5;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.acm
 * JD-Core Version:    0.7.0.1
 */