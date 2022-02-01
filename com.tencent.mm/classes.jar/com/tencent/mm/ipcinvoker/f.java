package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

public final class f
{
  public String gAi;
  
  public f(String paramString)
  {
    this.gAi = paramString;
  }
  
  public static String bf(Object paramObject)
  {
    AppMethodBeat.i(158730);
    paramObject = "Token#IPCObserver#" + paramObject.hashCode();
    AppMethodBeat.o(158730);
    return paramObject;
  }
  
  public static class a
    implements b<Bundle, Bundle>
  {}
  
  public static class b
    implements b<Bundle, Bundle>
  {}
  
  static abstract class c
    implements e
  {
    String token;
    
    c(String paramString)
    {
      this.token = paramString;
      Assert.assertNotNull(paramString);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof c))) {
        return false;
      }
      return this.token.equals(((c)paramObject).token);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f
 * JD-Core Version:    0.7.0.1
 */