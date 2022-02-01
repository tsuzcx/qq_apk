package com.tencent.beacon.upload;

import android.content.Context;
import com.tencent.beacon.a.b.c;
import com.tencent.beacon.a.b.e.a;
import com.tencent.beacon.c.a.b;

public abstract class a
{
  protected final int a;
  protected final int b;
  protected Context c;
  protected String d;
  
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public static b a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    int i = -1;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramContext = c.a(paramContext).b();
        if (paramContext != null)
        {
          j = paramContext.i();
          i = paramContext.j();
          paramContext = paramContext.k();
          paramContext = com.tencent.beacon.b.a.a(paramArrayOfByte, i, j, paramContext);
          k = i;
          m = j;
          paramArrayOfByte = paramContext;
          if (paramContext == null)
          {
            com.tencent.beacon.d.a.c("enzp error! :%d %d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            return null;
          }
          paramContext = com.tencent.beacon.b.a.a(paramInt, com.tencent.beacon.a.e.m(), paramArrayOfByte, k, m);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        com.tencent.beacon.d.a.c("imposiable comStrategy error:%s", new Object[] { paramContext.toString() });
        paramContext.printStackTrace();
        return null;
      }
      paramContext = null;
      int j = -1;
      continue;
      int m = -1;
      int k = i;
    }
  }
  
  public abstract b a();
  
  public void b()
  {
    com.tencent.beacon.d.a.c("encode failed, clear db data", new Object[0]);
  }
  
  public abstract void b(boolean paramBoolean);
  
  public final int c()
  {
    return this.a;
  }
  
  public final String d()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    try
    {
      if (this.b == 0) {
        return c.a(this.c).b().b();
      }
      String str = c.a(this.c).b().b(this.b).b();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.c("imposiable comStrategy error:%s", new Object[] { localThrowable.toString() });
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.a
 * JD-Core Version:    0.7.0.1
 */