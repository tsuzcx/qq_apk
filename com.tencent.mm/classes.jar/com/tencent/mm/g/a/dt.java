package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import org.json.JSONArray;

public final class dt
  extends b
{
  public a dfZ;
  public b dga;
  
  public dt()
  {
    this((byte)0);
  }
  
  private dt(byte paramByte)
  {
    AppMethodBeat.i(115985);
    this.dfZ = new a();
    this.dga = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(115985);
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
 * Qualified Name:     com.tencent.mm.g.a.dt
 * JD-Core Version:    0.7.0.1
 */