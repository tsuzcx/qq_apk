package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONObject;

public final class rh
  extends IEvent
{
  public a hUs;
  
  public rh()
  {
    this((byte)0);
  }
  
  private rh(byte paramByte)
  {
    AppMethodBeat.i(89648);
    this.hUs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89648);
  }
  
  public static final class a
  {
    public Context context;
    public JSONObject hUt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rh
 * JD-Core Version:    0.7.0.1
 */