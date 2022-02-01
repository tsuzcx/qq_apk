package com.tencent.mm.g.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.b.b;

public final class kn
  extends b
{
  public a doX;
  public b doY;
  
  public kn()
  {
    this((byte)0);
  }
  
  private kn(byte paramByte)
  {
    AppMethodBeat.i(127406);
    this.doX = new a();
    this.doY = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(127406);
  }
  
  public static final class a
  {
    public n dfA;
    public int doZ = 0;
    public String dpa;
    public float dpb = 0.0F;
    public float dpc = 0.0F;
    public int dpd = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.kn
 * JD-Core Version:    0.7.0.1
 */