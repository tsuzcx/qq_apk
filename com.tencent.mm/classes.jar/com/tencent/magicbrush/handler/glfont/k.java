package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

final class k
{
  static final k cyR;
  float cyS;
  float cyT;
  float cyU;
  float cyV;
  float cyW;
  float cyX;
  boolean cyY;
  int cyZ = 1;
  float height;
  float width;
  
  static
  {
    AppMethodBeat.i(140056);
    k localk = new k();
    cyR = localk;
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
        FloatBuffer localFloatBuffer = paramFloatBuffer.put(localk.cyS).put(localk.cyT).put(localk.width).put(localk.height).put(localk.cyU).put(localk.cyV).put(localk.cyW).put(localk.cyX);
        if (localk.cyY) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          localFloatBuffer.put(f).put(localk.cyZ);
          break;
        }
      }
    }
    AppMethodBeat.o(140054);
  }
  
  public final void k(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.cyU = paramFloat1;
    this.cyV = paramFloat2;
    this.cyW = paramFloat3;
    this.cyX = paramFloat4;
  }
  
  public final void setEmpty()
  {
    this.height = 0.0F;
    this.width = 0.0F;
    this.cyT = 0.0F;
    this.cyS = 0.0F;
    this.cyX = 0.0F;
    this.cyW = 0.0F;
    this.cyV = 0.0F;
    this.cyU = 0.0F;
    this.cyZ = 1;
    this.cyY = false;
  }
  
  public final void t(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140055);
    String str = "glyph(" + this.cyS + ", " + this.cyT + ", [" + this.width + ", " + this.height + "], [" + this.cyU + ", " + this.cyV + ", " + this.cyW + ", " + this.cyX + ", " + this.cyY + "])";
    AppMethodBeat.o(140055);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.k
 * JD-Core Version:    0.7.0.1
 */