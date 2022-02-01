package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONArray;

public final class eu
  extends IEvent
{
  public a hEO;
  public b hEP;
  
  public eu()
  {
    this((byte)0);
  }
  
  private eu(byte paramByte)
  {
    AppMethodBeat.i(115986);
    this.hEO = new a();
    this.hEP = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115986);
  }
  
  public static final class a
  {
    public Context context;
    public String hEy;
  }
  
  public static final class b
  {
    public JSONArray hEN;
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.eu
 * JD-Core Version:    0.7.0.1
 */