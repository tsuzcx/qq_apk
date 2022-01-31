package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

public final class d
{
  public String dGD;
  
  public d(String paramString)
  {
    this.dGD = paramString;
  }
  
  public static String V(Object paramObject)
  {
    return "Token#IPCObserver#" + paramObject.hashCode();
  }
  
  private static abstract class c
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d
 * JD-Core Version:    0.7.0.1
 */