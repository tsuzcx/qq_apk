package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONArray;

public final class ec
  extends IEvent
{
  public a dHl;
  public b dHm;
  
  public ec()
  {
    this((byte)0);
  }
  
  private ec(byte paramByte)
  {
    AppMethodBeat.i(115986);
    this.dHl = new a();
    this.dHm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115986);
  }
  
  public static final class a
  {
    public String brandName;
    public Context context;
  }
  
  public static final class b
  {
    public boolean dGX;
    public JSONArray dHk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ec
 * JD-Core Version:    0.7.0.1
 */