package com.tencent.mm.ipcinvoker.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import junit.framework.Assert;

public class d
{
  public String event;
  public f hnu;
  private String process;
  
  public <T extends b> d(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(158789);
    Assert.assertNotNull(paramString);
    Assert.assertNotNull(paramClass);
    this.process = paramString;
    this.event = paramClass.getName();
    this.hnu = new f(paramString);
    AppMethodBeat.o(158789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.d
 * JD-Core Version:    0.7.0.1
 */