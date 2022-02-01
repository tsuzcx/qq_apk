package com.tencent.mm.g.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.b.b;

public final class lg
  extends b
{
  public a dzA;
  public b dzB;
  
  public lg()
  {
    this((byte)0);
  }
  
  private lg(byte paramByte)
  {
    AppMethodBeat.i(127406);
    this.dzA = new a();
    this.dzB = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(127406);
  }
  
  public static final class a
  {
    public n dpw;
    public int dzC = 0;
    public String dzD;
    public float dzE = 0.0F;
    public float dzF = 0.0F;
    public int dzG = 0;
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
 * Qualified Name:     com.tencent.mm.g.a.lg
 * JD-Core Version:    0.7.0.1
 */