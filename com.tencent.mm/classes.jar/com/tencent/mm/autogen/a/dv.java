package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class dv
  extends IEvent
{
  public a hDG;
  public b hDH;
  
  public dv()
  {
    this((byte)0);
  }
  
  private dv(byte paramByte)
  {
    AppMethodBeat.i(130926);
    this.hDG = new a();
    this.hDH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130926);
  }
  
  public static final class a
  {
    public String appId;
    public Runnable callback;
    public WeakReference contextRef;
    public String hDI;
    public String hDJ;
    public String hDK;
    public String hhx;
    public String nonceStr;
    public String packageExt;
    public int payChannel = 0;
    public String signType;
    public String signature;
    public String token;
  }
  
  public static final class b
  {
    public int retCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dv
 * JD-Core Version:    0.7.0.1
 */