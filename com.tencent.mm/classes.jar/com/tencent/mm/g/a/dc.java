package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.lang.ref.WeakReference;

public final class dc
  extends b
{
  public a dnS;
  public b dnT;
  
  public dc()
  {
    this((byte)0);
  }
  
  private dc(byte paramByte)
  {
    AppMethodBeat.i(130926);
    this.dnS = new a();
    this.dnT = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(130926);
  }
  
  public static final class a
  {
    public WeakReference aWN;
    public String appId;
    public String cUM;
    public Runnable callback;
    public String dnU;
    public String dnV;
    public String dnW;
    public int dnX = 0;
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
 * Qualified Name:     com.tencent.mm.g.a.dc
 * JD-Core Version:    0.7.0.1
 */