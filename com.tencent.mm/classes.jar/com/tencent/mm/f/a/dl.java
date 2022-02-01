package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class dl
  extends IEvent
{
  public a fyX;
  public b fyY;
  
  public dl()
  {
    this((byte)0);
  }
  
  private dl(byte paramByte)
  {
    AppMethodBeat.i(130926);
    this.fyX = new a();
    this.fyY = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130926);
  }
  
  public static final class a
  {
    public WeakReference aFX;
    public String appId;
    public Runnable callback;
    public String fdH;
    public String fyZ;
    public String fza;
    public String fzb;
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
 * Qualified Name:     com.tencent.mm.f.a.dl
 * JD-Core Version:    0.7.0.1
 */