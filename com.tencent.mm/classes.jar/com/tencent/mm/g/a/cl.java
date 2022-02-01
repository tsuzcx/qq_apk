package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class cl
  extends b
{
  public a deA;
  
  public cl()
  {
    this((byte)0);
  }
  
  private cl(byte paramByte)
  {
    AppMethodBeat.i(115973);
    this.deA = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(115973);
  }
  
  public static final class a
  {
    public Activity activity;
    public String dcO;
    public int deB;
    public int deC;
    public String deE;
    public String deF;
    public Bundle deG;
    public int from = -1;
    public String imagePath;
    public int scene = -1;
    public String source;
    public int sourceType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.cl
 * JD-Core Version:    0.7.0.1
 */