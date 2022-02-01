package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aav
  extends IEvent
{
  public a fZU;
  public b fZV;
  
  public aav()
  {
    this((byte)0);
  }
  
  private aav(byte paramByte)
  {
    AppMethodBeat.i(130930);
    this.fZU = new a();
    this.fZV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130930);
  }
  
  public static final class a
  {
    public String action;
    public String appId;
    public String fJB;
    public String fZW;
    public int fZX;
    public String fZY;
    public String fdH;
    public String nonceStr;
    public String signType;
    public String url;
  }
  
  public static final class b
  {
    public String fZY;
    public Runnable fZZ;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.aav
 * JD-Core Version:    0.7.0.1
 */