package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

final class k
{
  static final k cOt;
  boolean cOA;
  int cOB = 1;
  float cOu;
  float cOv;
  float cOw;
  float cOx;
  float cOy;
  float cOz;
  float height;
  float width;
  
  static
  {
    AppMethodBeat.i(140056);
    k localk = new k();
    cOt = localk;
    localk.Vn();
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
        FloatBuffer localFloatBuffer = paramFloatBuffer.put(localk.cOu).put(localk.cOv).put(localk.width).put(localk.height).put(localk.cOw).put(localk.cOx).put(localk.cOy).put(localk.cOz);
        if (localk.cOA) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          localFloatBuffer.put(f).put(localk.cOB);
          break;
        }
      }
    }
    AppMethodBeat.o(140054);
  }
  
  public final void Vn()
  {
    this.height = 0.0F;
    this.width = 0.0F;
    this.cOv = 0.0F;
    this.cOu = 0.0F;
    this.cOz = 0.0F;
    this.cOy = 0.0F;
    this.cOx = 0.0F;
    this.cOw = 0.0F;
    this.cOB = 1;
    this.cOA = false;
  }
  
  public final void l(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.cOw = paramFloat1;
    this.cOx = paramFloat2;
    this.cOy = paramFloat3;
    this.cOz = paramFloat4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140055);
    String str = "glyph(" + this.cOu + ", " + this.cOv + ", [" + this.width + ", " + this.height + "], [" + this.cOw + ", " + this.cOx + ", " + this.cOy + ", " + this.cOz + ", " + this.cOA + "])";
    AppMethodBeat.o(140055);
    return str;
  }
  
  public final void w(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.k
 * JD-Core Version:    0.7.0.1
 */