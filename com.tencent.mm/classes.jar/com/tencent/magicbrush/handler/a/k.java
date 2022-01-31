package com.tencent.magicbrush.handler.a;

import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

final class k
{
  static final k blt;
  boolean blA;
  float blu;
  float blv;
  float blw;
  float blx;
  float bly;
  float blz;
  float height;
  float width;
  
  static
  {
    k localk = new k();
    blt = localk;
    localk.height = 0.0F;
    localk.width = 0.0F;
    localk.blv = 0.0F;
    localk.blu = 0.0F;
    localk.blz = 0.0F;
    localk.bly = 0.0F;
    localk.blx = 0.0F;
    localk.blw = 0.0F;
  }
  
  static void a(FloatBuffer paramFloatBuffer, List<k> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    label21:
    FloatBuffer localFloatBuffer;
    while (paramList.hasNext())
    {
      k localk = (k)paramList.next();
      if (localk != null)
      {
        localFloatBuffer = paramFloatBuffer.put(localk.blu).put(localk.blv).put(localk.width).put(localk.height).put(localk.blw).put(localk.blx).put(localk.bly).put(localk.blz);
        if (!localk.blA) {
          break label122;
        }
      }
    }
    label122:
    for (float f = 1.0F;; f = 0.0F)
    {
      localFloatBuffer.put(f);
      break label21;
      break;
    }
  }
  
  public final void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.blw = paramFloat1;
    this.blx = paramFloat2;
    this.bly = paramFloat3;
    this.blz = paramFloat4;
  }
  
  public final String toString()
  {
    return "glyph(" + this.blu + ", " + this.blv + ", [" + this.width + ", " + this.height + "], [" + this.blw + ", " + this.blx + ", " + this.bly + ", " + this.blz + ", " + this.blA + "])";
  }
  
  public final void z(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.k
 * JD-Core Version:    0.7.0.1
 */