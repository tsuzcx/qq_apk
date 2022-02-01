package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class s
  extends IEvent
{
  public a hzu;
  
  public s()
  {
    this((byte)0);
  }
  
  private s(byte paramByte)
  {
    AppMethodBeat.i(121048);
    this.hzu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121048);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public int appServiceType;
    public int appVersion;
    public long hzA;
    public int hzB;
    public int hzC;
    public String hzD;
    public String hzv;
    public int hzw;
    public String hzx;
    public String hzy;
    public String hzz;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.s
 * JD-Core Version:    0.7.0.1
 */