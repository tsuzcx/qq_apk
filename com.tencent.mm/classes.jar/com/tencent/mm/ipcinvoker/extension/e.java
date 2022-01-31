package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.g.b;
import junit.framework.Assert;

public final class e<T>
{
  private volatile T dHf;
  private Class<T> targetClass;
  
  public e(Class<T> paramClass)
  {
    Assert.assertNotNull(paramClass);
    this.targetClass = paramClass;
  }
  
  public final T get()
  {
    if (this.dHf == null) {}
    try
    {
      if (this.dHf == null) {
        this.dHf = b.o(this.targetClass);
      }
      return this.dHf;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.e
 * JD-Core Version:    0.7.0.1
 */