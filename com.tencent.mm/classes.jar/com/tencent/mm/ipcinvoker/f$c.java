package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

abstract class f$c
  implements e
{
  String token;
  
  f$c(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.c
 * JD-Core Version:    0.7.0.1
 */