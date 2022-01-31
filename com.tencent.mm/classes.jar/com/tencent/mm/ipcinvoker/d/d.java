package com.tencent.mm.ipcinvoker.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public class d
{
  public String cnC;
  public com.tencent.mm.ipcinvoker.d eEF;
  private String process;
  
  public <T extends b> d(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(114078);
    Assert.assertNotNull(paramString);
    Assert.assertNotNull(paramClass);
    this.process = paramString;
    this.cnC = paramClass.getName();
    this.eEF = new com.tencent.mm.ipcinvoker.d(paramString);
    AppMethodBeat.o(114078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.d
 * JD-Core Version:    0.7.0.1
 */