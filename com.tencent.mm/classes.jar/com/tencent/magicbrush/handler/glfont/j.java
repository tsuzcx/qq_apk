package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

final class j
{
  static final j coh;
  float coi;
  float coj;
  float cok;
  float col;
  float com;
  float con;
  boolean coo;
  int cop = 1;
  float height;
  float width;
  
  static
  {
    AppMethodBeat.i(140056);
    j localj = new j();
    coh = localj;
    localj.setEmpty();
    AppMethodBeat.o(140056);
  }
  
  static void a(FloatBuffer paramFloatBuffer, List<j> paramList)
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
      j localj = (j)paramList.next();
      if (localj != null)
      {
        FloatBuffer localFloatBuffer = paramFloatBuffer.put(localj.coi).put(localj.coj).put(localj.width).put(localj.height).put(localj.cok).put(localj.col).put(localj.com).put(localj.con);
        if (localj.coo) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          localFloatBuffer.put(f).put(localj.cop);
          break;
        }
      }
    }
    AppMethodBeat.o(140054);
  }
  
  public final void i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.cok = paramFloat1;
    this.col = paramFloat2;
    this.com = paramFloat3;
    this.con = paramFloat4;
  }
  
  public final void r(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public final void setEmpty()
  {
    this.height = 0.0F;
    this.width = 0.0F;
    this.coj = 0.0F;
    this.coi = 0.0F;
    this.con = 0.0F;
    this.com = 0.0F;
    this.col = 0.0F;
    this.cok = 0.0F;
    this.cop = 1;
    this.coo = false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140055);
    String str = "glyph(" + this.coi + ", " + this.coj + ", [" + this.width + ", " + this.height + "], [" + this.cok + ", " + this.col + ", " + this.com + ", " + this.con + ", " + this.coo + "])";
    AppMethodBeat.o(140055);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */