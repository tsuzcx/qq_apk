package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.lang.ref.WeakReference;

public final class cy
  extends b
{
  public a dfb;
  public b dfc;
  
  public cy()
  {
    this((byte)0);
  }
  
  private cy(byte paramByte)
  {
    AppMethodBeat.i(130926);
    this.dfb = new a();
    this.dfc = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(130926);
  }
  
  public static final class a
  {
    public WeakReference aLG;
    public String appId;
    public String cMo;
    public Runnable callback;
    public String dfd;
    public String dfe;
    public String dff;
    public int dfg = 0;
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
 * Qualified Name:     com.tencent.mm.g.a.cy
 * JD-Core Version:    0.7.0.1
 */