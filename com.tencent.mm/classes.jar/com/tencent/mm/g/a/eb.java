package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONArray;

public final class eb
  extends IEvent
{
  public a dHi;
  public b dHj;
  
  public eb()
  {
    this((byte)0);
  }
  
  private eb(byte paramByte)
  {
    AppMethodBeat.i(115985);
    this.dHi = new a();
    this.dHj = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115985);
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
 * Qualified Name:     com.tencent.mm.g.a.eb
 * JD-Core Version:    0.7.0.1
 */