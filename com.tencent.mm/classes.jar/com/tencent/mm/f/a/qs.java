package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.Map;

public final class qs
  extends IEvent
{
  public a fPr;
  
  public qs()
  {
    this((byte)0);
  }
  
  private qs(byte paramByte)
  {
    AppMethodBeat.i(117614);
    this.fPr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117614);
  }
  
  public static final class a
  {
    public String fPs;
    public String fPt;
    public String fPu;
    public String fPv;
    public int fPw;
    public int fPx;
    public Map<String, String> fPy;
    public String fwv;
    public String query;
    public int scene;
    public String sessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.qs
 * JD-Core Version:    0.7.0.1
 */