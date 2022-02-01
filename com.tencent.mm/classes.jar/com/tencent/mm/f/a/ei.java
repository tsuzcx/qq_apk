package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONArray;

public final class ei
  extends IEvent
{
  public b fAa;
  public a fzZ;
  
  public ei()
  {
    this((byte)0);
  }
  
  private ei(byte paramByte)
  {
    AppMethodBeat.i(115985);
    this.fzZ = new a();
    this.fAa = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115985);
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
 * Qualified Name:     com.tencent.mm.f.a.ei
 * JD-Core Version:    0.7.0.1
 */