package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.lang.ref.WeakReference;

public final class dd
  extends b
{
  public a doX;
  public b doY;
  
  public dd()
  {
    this((byte)0);
  }
  
  private dd(byte paramByte)
  {
    AppMethodBeat.i(130926);
    this.doX = new a();
    this.doY = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(130926);
  }
  
  public static final class a
  {
    public WeakReference aWN;
    public String appId;
    public String cVJ;
    public Runnable callback;
    public String doZ;
    public String dpa;
    public String dpb;
    public int dpc = 0;
    public String nonceStr;
    public String packageExt;
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
 * Qualified Name:     com.tencent.mm.g.a.dd
 * JD-Core Version:    0.7.0.1
 */