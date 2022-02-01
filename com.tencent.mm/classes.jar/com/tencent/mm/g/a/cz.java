package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.lang.ref.WeakReference;

public final class cz
  extends b
{
  public a dcw;
  public b dcx;
  
  public cz()
  {
    this((byte)0);
  }
  
  private cz(byte paramByte)
  {
    AppMethodBeat.i(130926);
    this.dcw = new a();
    this.dcx = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(130926);
  }
  
  public static final class a
  {
    public WeakReference aMw;
    public String appId;
    public String cJz;
    public Runnable callback;
    public String dcA;
    public int dcB = 0;
    public String dcy;
    public String dcz;
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
 * Qualified Name:     com.tencent.mm.g.a.cz
 * JD-Core Version:    0.7.0.1
 */