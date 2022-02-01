package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONObject;

public final class o
  extends IEvent
{
  public a fuU;
  
  public o()
  {
    this((byte)0);
  }
  
  private o(byte paramByte)
  {
    AppMethodBeat.i(144177);
    this.fuU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(144177);
  }
  
  public static final class a
  {
    public String fuV;
    public String fuW;
    public JSONObject fuX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.o
 * JD-Core Version:    0.7.0.1
 */