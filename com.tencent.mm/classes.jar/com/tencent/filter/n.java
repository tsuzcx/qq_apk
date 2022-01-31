package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends BaseFilter
{
  public n()
  {
    super(GLSLRender.btl, "share_film.jpg");
    AppMethodBeat.i(86425);
    addParam(new m.b("randomCoord2", (float)Math.random(), (float)Math.random()));
    AppMethodBeat.o(86425);
  }
  
  public final void OnDrawFrameGLSL()
  {
    AppMethodBeat.i(86426);
    m.b localb = (m.b)getParam("randomCoord2");
    localb.x = ((float)Math.random());
    localb.y = ((float)Math.random());
    super.OnDrawFrameGLSL();
    AppMethodBeat.o(86426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.n
 * JD-Core Version:    0.7.0.1
 */