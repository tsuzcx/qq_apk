package com.tencent.filter;

public final class n
  extends BaseFilter
{
  public n()
  {
    super(GLSLRender.bcJ, "share_film.jpg");
    addParam(new m.b("randomCoord2", (float)Math.random(), (float)Math.random()));
  }
  
  public final void OnDrawFrameGLSL()
  {
    m.b localb = (m.b)getParam("randomCoord2");
    localb.x = ((float)Math.random());
    localb.y = ((float)Math.random());
    super.OnDrawFrameGLSL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.n
 * JD-Core Version:    0.7.0.1
 */