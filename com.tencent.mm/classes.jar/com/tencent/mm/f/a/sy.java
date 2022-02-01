package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sy
  extends IEvent
{
  public a fSn;
  
  public sy()
  {
    this((byte)0);
  }
  
  private sy(byte paramByte)
  {
    AppMethodBeat.i(116044);
    this.fSn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116044);
  }
  
  public static final class a
  {
    public String appid;
    public Context context;
    public String fLi;
    public long fNu;
    public int fSo;
    public String fSp;
    public int fSq;
    public String fvd;
    public String mediaTagName;
    public int msgType;
    public String packageName;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.sy
 * JD-Core Version:    0.7.0.1
 */