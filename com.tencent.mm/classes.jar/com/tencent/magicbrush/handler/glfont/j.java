package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

final class j
{
  static final j bKr;
  float bKs;
  float bKt;
  float bKu;
  float bKv;
  float bKw;
  float bKx;
  boolean bKy;
  float height;
  float width;
  
  static
  {
    AppMethodBeat.i(115955);
    j localj = new j();
    bKr = localj;
    localj.height = 0.0F;
    localj.width = 0.0F;
    localj.bKt = 0.0F;
    localj.bKs = 0.0F;
    localj.bKx = 0.0F;
    localj.bKw = 0.0F;
    localj.bKv = 0.0F;
    localj.bKu = 0.0F;
    AppMethodBeat.o(115955);
  }
  
  static void a(FloatBuffer paramFloatBuffer, List<j> paramList)
  {
    AppMethodBeat.i(115953);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(115953);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      j localj = (j)paramList.next();
      if (localj != null)
      {
        FloatBuffer localFloatBuffer = paramFloatBuffer.put(localj.bKs).put(localj.bKt).put(localj.width).put(localj.height).put(localj.bKu).put(localj.bKv).put(localj.bKw).put(localj.bKx);
        if (localj.bKy) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          localFloatBuffer.put(f);
          break;
        }
      }
    }
    AppMethodBeat.o(115953);
  }
  
  public final void A(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public final void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.bKu = paramFloat1;
    this.bKv = paramFloat2;
    this.bKw = paramFloat3;
    this.bKx = paramFloat4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(115954);
    String str = "glyph(" + this.bKs + ", " + this.bKt + ", [" + this.width + ", " + this.height + "], [" + this.bKu + ", " + this.bKv + ", " + this.bKw + ", " + this.bKx + ", " + this.bKy + "])";
    AppMethodBeat.o(115954);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */