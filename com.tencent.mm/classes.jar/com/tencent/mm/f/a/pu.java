package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONObject;

public final class pu
  extends IEvent
{
  public a fOz;
  
  public pu()
  {
    this((byte)0);
  }
  
  private pu(byte paramByte)
  {
    AppMethodBeat.i(89648);
    this.fOz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89648);
  }
  
  public static final class a
  {
    public Context context;
    public JSONObject fOA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.pu
 * JD-Core Version:    0.7.0.1
 */