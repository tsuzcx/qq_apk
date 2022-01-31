package com.github.henryye.nativeiv.b;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import junit.framework.Assert;

public final class d
{
  public static InputStream e(InputStream paramInputStream)
  {
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported())
    {
      if ((paramInputStream instanceof FileInputStream)) {
        localObject = new b((FileInputStream)paramInputStream);
      }
    }
    else {
      return localObject;
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  public static void f(InputStream paramInputStream)
  {
    Assert.assertTrue(paramInputStream.markSupported());
    paramInputStream.mark(8388608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.d
 * JD-Core Version:    0.7.0.1
 */