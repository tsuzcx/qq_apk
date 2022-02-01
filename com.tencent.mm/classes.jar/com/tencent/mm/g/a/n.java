package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONObject;

public final class n
  extends IEvent
{
  public a dCn;
  
  public n()
  {
    this((byte)0);
  }
  
  private n(byte paramByte)
  {
    AppMethodBeat.i(144177);
    this.dCn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(144177);
  }
  
  public static final class a
  {
    public String dCo;
    public String dCp;
    public JSONObject dCq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.n
 * JD-Core Version:    0.7.0.1
 */