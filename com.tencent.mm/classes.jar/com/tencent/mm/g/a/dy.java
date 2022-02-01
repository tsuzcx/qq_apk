package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import org.json.JSONArray;

public final class dy
  extends b
{
  public a dpV;
  public b dpW;
  
  public dy()
  {
    this((byte)0);
  }
  
  private dy(byte paramByte)
  {
    AppMethodBeat.i(115985);
    this.dpV = new a();
    this.dpW = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(115985);
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
 * Qualified Name:     com.tencent.mm.g.a.dy
 * JD-Core Version:    0.7.0.1
 */