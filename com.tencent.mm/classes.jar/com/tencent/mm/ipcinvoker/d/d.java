package com.tencent.mm.ipcinvoker.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import junit.framework.Assert;

public class d
{
  public String event;
  private String mzg;
  public h mzh;
  
  public <T extends b> d(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(158789);
    Assert.assertNotNull(paramString);
    Assert.assertNotNull(paramClass);
    this.mzg = paramString;
    this.event = paramClass.getName();
    this.mzh = new h(paramString);
    AppMethodBeat.o(158789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.d
 * JD-Core Version:    0.7.0.1
 */