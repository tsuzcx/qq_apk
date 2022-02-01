package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import org.json.JSONArray;

public final class dz
  extends b
{
  public a dpY;
  public b dpZ;
  
  public dz()
  {
    this((byte)0);
  }
  
  private dz(byte paramByte)
  {
    AppMethodBeat.i(115986);
    this.dpY = new a();
    this.dpZ = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(115986);
  }
  
  public static final class a
  {
    public Context context;
    public String dpI;
  }
  
  public static final class b
  {
    public boolean dpK;
    public JSONArray dpX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.dz
 * JD-Core Version:    0.7.0.1
 */