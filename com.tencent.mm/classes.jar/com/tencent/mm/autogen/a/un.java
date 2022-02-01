package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class un
  extends IEvent
{
  public a hYk;
  
  public un()
  {
    this((byte)0);
  }
  
  private un(byte paramByte)
  {
    AppMethodBeat.i(116044);
    this.hYk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116044);
  }
  
  public static final class a
  {
    public String appid;
    public Context context;
    public String hQQ;
    public long hTh;
    public int hYl;
    public String hYm;
    public int hYn;
    public String hzx;
    public String mediaTagName;
    public int msgType;
    public String packageName;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.un
 * JD-Core Version:    0.7.0.1
 */