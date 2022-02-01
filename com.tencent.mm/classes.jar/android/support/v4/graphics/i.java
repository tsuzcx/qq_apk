package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.c.b.b;
import android.support.v4.content.a.c.b;
import android.support.v4.content.a.c.c;
import java.io.File;
import java.io.InputStream;

class i
{
  protected static Typeface a(Context paramContext, InputStream paramInputStream)
  {
    paramContext = j.X(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = j.a(paramContext, paramInputStream);
      if (!bool) {
        return null;
      }
      paramInputStream = Typeface.createFromFile(paramContext.getPath());
      return paramInputStream;
    }
    catch (RuntimeException paramInputStream)
    {
      return null;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, a<T> parama)
  {
    int i;
    int i1;
    label19:
    Object localObject;
    int j;
    label32:
    T ?;
    int m;
    if ((paramInt & 0x1) == 0)
    {
      i = 400;
      if ((paramInt & 0x2) == 0) {
        break label125;
      }
      i1 = 1;
      localObject = null;
      j = 2147483647;
      int n = paramArrayOfT.length;
      paramInt = 0;
      if (paramInt >= n) {
        break label137;
      }
      ? = paramArrayOfT[paramInt];
      m = Math.abs(parama.u(?) - i);
      if (parama.t(?) != i1) {
        break label131;
      }
    }
    label131:
    for (int k = 0;; k = 1)
    {
      m = k + m * 2;
      if (localObject != null)
      {
        k = j;
        if (j <= m) {}
      }
      else
      {
        k = m;
        localObject = ?;
      }
      paramInt += 1;
      j = k;
      break label32;
      i = 700;
      break;
      label125:
      i1 = 0;
      break label19;
    }
    label137:
    return localObject;
  }
  
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = j.X(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = j.a(paramContext, paramResources, paramInt1);
      if (!bool) {
        return null;
      }
      paramResources = Typeface.createFromFile(paramContext.getPath());
      return paramResources;
    }
    catch (RuntimeException paramResources)
    {
      return null;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  public Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    paramb = (c.c)a(paramb.JE, paramInt, new a() {});
    if (paramb == null) {
      return null;
    }
    return d.a(paramContext, paramResources, paramb.JJ, paramb.mFileName, paramInt);
  }
  
  /* Error */
  public Typeface a(Context paramContext, b.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: ifgt +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: aload_0
    //   8: aload_2
    //   9: iload_3
    //   10: invokevirtual 98	android/support/v4/graphics/i:a	([Landroid/support/v4/c/b$b;I)Landroid/support/v4/c/b$b;
    //   13: astore_2
    //   14: aload_1
    //   15: invokevirtual 104	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: aload_2
    //   19: getfield 110	android/support/v4/c/b$b:mUri	Landroid/net/Uri;
    //   22: invokevirtual 116	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   25: astore_2
    //   26: aload_1
    //   27: aload_2
    //   28: invokestatic 118	android/support/v4/graphics/i:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   31: astore_1
    //   32: aload_2
    //   33: invokestatic 122	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   36: aload_1
    //   37: areturn
    //   38: astore_1
    //   39: aconst_null
    //   40: astore_2
    //   41: aload_2
    //   42: invokestatic 122	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_1
    //   48: aconst_null
    //   49: astore_2
    //   50: aload_2
    //   51: invokestatic 122	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   54: aload_1
    //   55: athrow
    //   56: astore_1
    //   57: goto -7 -> 50
    //   60: astore_1
    //   61: goto -20 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	i
    //   0	64	1	paramContext	Context
    //   0	64	2	paramArrayOfb	b.b[]
    //   0	64	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   14	26	38	java/io/IOException
    //   14	26	47	finally
    //   26	32	56	finally
    //   26	32	60	java/io/IOException
  }
  
  protected final b.b a(b.b[] paramArrayOfb, int paramInt)
  {
    (b.b)a(paramArrayOfb, paramInt, new a() {});
  }
  
  static abstract interface a<T>
  {
    public abstract boolean t(T paramT);
    
    public abstract int u(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.i
 * JD-Core Version:    0.7.0.1
 */