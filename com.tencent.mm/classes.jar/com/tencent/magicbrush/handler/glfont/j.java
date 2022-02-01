package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

final class j
{
  static final j cra;
  float crb;
  float crd;
  float cre;
  float crf;
  float crg;
  float crh;
  boolean cri;
  int crj = 1;
  float height;
  float width;
  
  static
  {
    AppMethodBeat.i(140056);
    j localj = new j();
    cra = localj;
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
        FloatBuffer localFloatBuffer = paramFloatBuffer.put(localj.crb).put(localj.crd).put(localj.width).put(localj.height).put(localj.cre).put(localj.crf).put(localj.crg).put(localj.crh);
        if (localj.cri) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          localFloatBuffer.put(f).put(localj.crj);
          break;
        }
      }
    }
    AppMethodBeat.o(140054);
  }
  
  public final void i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.cre = paramFloat1;
    this.crf = paramFloat2;
    this.crg = paramFloat3;
    this.crh = paramFloat4;
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
    this.crd = 0.0F;
    this.crb = 0.0F;
    this.crh = 0.0F;
    this.crg = 0.0F;
    this.crf = 0.0F;
    this.cre = 0.0F;
    this.crj = 1;
    this.cri = false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140055);
    String str = "glyph(" + this.crb + ", " + this.crd + ", [" + this.width + ", " + this.height + "], [" + this.cre + ", " + this.crf + ", " + this.crg + ", " + this.crh + ", " + this.cri + "])";
    AppMethodBeat.o(140055);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */