package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONObject;

public final class q
  extends IEvent
{
  public a hzo;
  
  public q()
  {
    this((byte)0);
  }
  
  private q(byte paramByte)
  {
    AppMethodBeat.i(144177);
    this.hzo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(144177);
  }
  
  public static final class a
  {
    public String hzp;
    public String hzq;
    public JSONObject hzr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.a.q
 * JD-Core Version:    0.7.0.1
 */