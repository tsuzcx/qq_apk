package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONArray;

public final class ej
  extends IEvent
{
  public a fAc;
  public b fAd;
  
  public ej()
  {
    this((byte)0);
  }
  
  private ej(byte paramByte)
  {
    AppMethodBeat.i(115986);
    this.fAc = new a();
    this.fAd = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115986);
  }
  
  public static final class a
  {
    public Context context;
    public String fzM;
  }
  
  public static final class b
  {
    public JSONArray fAb;
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ej
 * JD-Core Version:    0.7.0.1
 */