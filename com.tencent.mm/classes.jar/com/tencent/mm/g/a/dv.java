package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import org.json.JSONArray;

public final class dv
  extends b
{
  public a ddx;
  public b ddy;
  
  public dv()
  {
    this((byte)0);
  }
  
  private dv(byte paramByte)
  {
    AppMethodBeat.i(115986);
    this.ddx = new a();
    this.ddy = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(115986);
  }
  
  public static final class a
  {
    public Context context;
    public String ddh;
  }
  
  public static final class b
  {
    public boolean ddj;
    public JSONArray ddw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.dv
 * JD-Core Version:    0.7.0.1
 */