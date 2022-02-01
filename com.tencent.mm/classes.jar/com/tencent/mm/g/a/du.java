package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import org.json.JSONArray;

public final class du
  extends b
{
  public a dgc;
  public b dgd;
  
  public du()
  {
    this((byte)0);
  }
  
  private du(byte paramByte)
  {
    AppMethodBeat.i(115986);
    this.dgc = new a();
    this.dgd = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(115986);
  }
  
  public static final class a
  {
    public Context context;
    public String dfM;
  }
  
  public static final class b
  {
    public boolean dfO;
    public JSONArray dgb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.du
 * JD-Core Version:    0.7.0.1
 */