package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

public final class h
{
  public String myC;
  
  public h(String paramString)
  {
    this.myC = paramString;
  }
  
  public static String cI(Object paramObject)
  {
    AppMethodBeat.i(158730);
    paramObject = "Token#IPCObserver#" + paramObject.hashCode();
    AppMethodBeat.o(158730);
    return paramObject;
  }
  
  public static class a
    implements d<Bundle, Bundle>
  {}
  
  public static class b
    implements d<Bundle, Bundle>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h
 * JD-Core Version:    0.7.0.1
 */