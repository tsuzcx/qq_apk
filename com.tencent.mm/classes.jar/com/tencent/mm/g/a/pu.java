package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.Map;

public final class pu
  extends IEvent
{
  public a dVN;
  
  public pu()
  {
    this((byte)0);
  }
  
  private pu(byte paramByte)
  {
    AppMethodBeat.i(117614);
    this.dVN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117614);
  }
  
  public static final class a
  {
    public String dDL;
    public String dVO;
    public String dVP;
    public String dVQ;
    public String dVR;
    public int dVS;
    public int dVT;
    public Map<String, String> dVU;
    public String query;
    public int scene;
    public String sessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.pu
 * JD-Core Version:    0.7.0.1
 */