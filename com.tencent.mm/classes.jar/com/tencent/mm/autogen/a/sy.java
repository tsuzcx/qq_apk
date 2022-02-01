package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class sy
  extends IEvent
{
  public a hWr;
  public b hWs;
  
  public sy()
  {
    this((byte)0);
  }
  
  private sy(byte paramByte)
  {
    AppMethodBeat.i(91211);
    this.hWr = new a();
    this.hWs = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91211);
  }
  
  public static final class a
  {
    public String appId;
    public String url;
  }
  
  public static final class b
  {
    public int errCode = 0;
    public String hWA;
    public String hWB;
    public List hWC;
    public boolean hWt = false;
    public String hWu;
    public String hWv;
    public String hWw;
    public String hWx;
    public String hWy;
    public String hWz;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sy
 * JD-Core Version:    0.7.0.1
 */