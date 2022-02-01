package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

final class k
{
  static final k czy;
  float czA;
  float czB;
  float czC;
  float czD;
  float czE;
  boolean czF;
  int czG = 1;
  float czz;
  float height;
  float width;
  
  static
  {
    AppMethodBeat.i(140056);
    k localk = new k();
    czy = localk;
    localk.setEmpty();
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
        FloatBuffer localFloatBuffer = paramFloatBuffer.put(localk.czz).put(localk.czA).put(localk.width).put(localk.height).put(localk.czB).put(localk.czC).put(localk.czD).put(localk.czE);
        if (localk.czF) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          localFloatBuffer.put(f).put(localk.czG);
          break;
        }
      }
    }
    AppMethodBeat.o(140054);
  }
  
  public final void k(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.czB = paramFloat1;
    this.czC = paramFloat2;
    this.czD = paramFloat3;
    this.czE = paramFloat4;
  }
  
  public final void setEmpty()
  {
    this.height = 0.0F;
    this.width = 0.0F;
    this.czA = 0.0F;
    this.czz = 0.0F;
    this.czE = 0.0F;
    this.czD = 0.0F;
    this.czC = 0.0F;
    this.czB = 0.0F;
    this.czG = 1;
    this.czF = false;
  }
  
  public final void t(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140055);
    String str = "glyph(" + this.czz + ", " + this.czA + ", [" + this.width + ", " + this.height + "], [" + this.czB + ", " + this.czC + ", " + this.czD + ", " + this.czE + ", " + this.czF + "])";
    AppMethodBeat.o(140055);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.k
 * JD-Core Version:    0.7.0.1
 */