package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONArray;

public final class et
  extends IEvent
{
  public a hEL;
  public b hEM;
  
  public et()
  {
    this((byte)0);
  }
  
  private et(byte paramByte)
  {
    AppMethodBeat.i(115985);
    this.hEL = new a();
    this.hEM = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115985);
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
 * Qualified Name:     com.tencent.mm.autogen.a.et
 * JD-Core Version:    0.7.0.1
 */