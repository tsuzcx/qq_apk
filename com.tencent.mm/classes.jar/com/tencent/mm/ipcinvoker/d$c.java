package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

abstract class d$c
  implements e
{
  String token;
  
  d$c(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.c
 * JD-Core Version:    0.7.0.1
 */