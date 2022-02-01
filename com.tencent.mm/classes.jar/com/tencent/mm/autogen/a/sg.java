package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.Map;

public final class sg
  extends IEvent
{
  public a hVm;
  
  public sg()
  {
    this((byte)0);
  }
  
  private sg(byte paramByte)
  {
    AppMethodBeat.i(117614);
    this.hVm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117614);
  }
  
  public static final class a
  {
    public String hAT;
    public String hVn;
    public String hVo;
    public String hVp;
    public String hVq;
    public int hVr;
    public int hVs;
    public Map<String, String> hVt;
    public String query;
    public int scene;
    public String sessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sg
 * JD-Core Version:    0.7.0.1
 */