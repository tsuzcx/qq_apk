package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

final class k
{
  static final k eJO;
  float eJP;
  float eJQ;
  float eJR;
  float eJS;
  float eJT;
  float eJU;
  boolean eJV;
  int eJW = 1;
  float height;
  float width;
  
  static
  {
    AppMethodBeat.i(140056);
    k localk = new k();
    eJO = localk;
    localk.avQ();
    AppMethodBeat.o(140056);
  }
  
  static void a(FloatBuffer paramFloatBuffer, List<k> paramList)
  {
    AppMethodBeat.i(140054);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(140054);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      k localk = (k)paramList.next();
      if (localk != null)
      {
        FloatBuffer localFloatBuffer = paramFloatBuffer.put(localk.eJP).put(localk.eJQ).put(localk.width).put(localk.height).put(localk.eJR).put(localk.eJS).put(localk.eJT).put(localk.eJU);
        if (localk.eJV) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          localFloatBuffer.put(f).put(localk.eJW);
          break;
        }
      }
    }
    AppMethodBeat.o(140054);
  }
  
  public final void ac(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public final void avQ()
  {
    this.height = 0.0F;
    this.width = 0.0F;
    this.eJQ = 0.0F;
    this.eJP = 0.0F;
    this.eJU = 0.0F;
    this.eJT = 0.0F;
    this.eJS = 0.0F;
    this.eJR = 0.0F;
    this.eJW = 1;
    this.eJV = false;
  }
  
  public final void n(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.eJR = paramFloat1;
    this.eJS = paramFloat2;
    this.eJT = paramFloat3;
    this.eJU = paramFloat4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140055);
    String str = "glyph(" + this.eJP + ", " + this.eJQ + ", [" + this.width + ", " + this.height + "], [" + this.eJR + ", " + this.eJS + ", " + this.eJT + ", " + this.eJU + ", " + this.eJV + "])";
    AppMethodBeat.o(140055);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.k
 * JD-Core Version:    0.7.0.1
 */