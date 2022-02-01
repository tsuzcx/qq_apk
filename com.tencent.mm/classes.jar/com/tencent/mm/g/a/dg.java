package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class dg
  extends IEvent
{
  public a dGm;
  public b dGn;
  
  public dg()
  {
    this((byte)0);
  }
  
  private dg(byte paramByte)
  {
    AppMethodBeat.i(130926);
    this.dGm = new a();
    this.dGn = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130926);
  }
  
  public static final class a
  {
    public WeakReference aWF;
    public String appId;
    public Runnable callback;
    public String dGo;
    public String dGp;
    public String dGq;
    public String dmc;
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
 * Qualified Name:     com.tencent.mm.g.a.dg
 * JD-Core Version:    0.7.0.1
 */