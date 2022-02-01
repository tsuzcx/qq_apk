package com.tencent.mm.g.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.b.b;

public final class kw
  extends b
{
  public a dmH;
  public b dmI;
  
  public kw()
  {
    this((byte)0);
  }
  
  private kw(byte paramByte)
  {
    AppMethodBeat.i(127406);
    this.dmH = new a();
    this.dmI = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(127406);
  }
  
  public static final class a
  {
    public n dcV;
    public int dmJ = 0;
    public String dmK;
    public float dmL = 0.0F;
    public float dmM = 0.0F;
    public int dmN = 0;
    public String filename;
    public int height = 0;
    public View view;
    public int width = 0;
  }
  
  public static final class b
  {
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.kw
 * JD-Core Version:    0.7.0.1
 */