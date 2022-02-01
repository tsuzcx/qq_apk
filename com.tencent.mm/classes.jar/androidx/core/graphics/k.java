package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.c;
import androidx.core.d.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class k
{
  private ConcurrentHashMap<Long, c.b> bqO;
  
  k()
  {
    AppMethodBeat.i(196060);
    this.bqO = new ConcurrentHashMap();
    AppMethodBeat.o(196060);
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, a<T> parama)
  {
    AppMethodBeat.i(196074);
    int i;
    int i1;
    label24:
    Object localObject;
    int j;
    label37:
    T ?;
    int m;
    if ((paramInt & 0x1) == 0)
    {
      i = 400;
      if ((paramInt & 0x2) == 0) {
        break label130;
      }
      i1 = 1;
      localObject = null;
      j = 2147483647;
      int n = paramArrayOfT.length;
      paramInt = 0;
      if (paramInt >= n) {
        break label142;
      }
      ? = paramArrayOfT[paramInt];
      m = Math.abs(parama.aA(?) - i);
      if (parama.az(?) != i1) {
        break label136;
      }
    }
    label130:
    label136:
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
      break label37;
      i = 700;
      break;
      i1 = 0;
      break label24;
    }
    label142:
    AppMethodBeat.o(196074);
    return localObject;
  }
  
  private static long e(Typeface paramTypeface)
  {
    AppMethodBeat.i(196085);
    if (paramTypeface == null)
    {
      AppMethodBeat.o(196085);
      return 0L;
    }
    try
    {
      Field localField = Typeface.class.getDeclaredField("native_instance");
      localField.setAccessible(true);
      long l = ((Number)localField.get(paramTypeface)).longValue();
      AppMethodBeat.o(196085);
      return l;
    }
    catch (NoSuchFieldException paramTypeface)
    {
      AppMethodBeat.o(196085);
      return 0L;
    }
    catch (IllegalAccessException paramTypeface)
    {
      AppMethodBeat.o(196085);
    }
    return 0L;
  }
  
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(196145);
    paramContext = l.ai(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(196145);
      return null;
    }
    try
    {
      boolean bool = l.a(paramContext, paramResources, paramInt1);
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
      AppMethodBeat.o(196145);
    }
  }
  
  public Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(196136);
    c.c localc = (c.c)a(paramb.bqf, paramInt, new a() {});
    if (localc == null)
    {
      AppMethodBeat.o(196136);
      return null;
    }
    paramContext = e.a(paramContext, paramResources, localc.bqk, localc.mFileName, paramInt);
    long l = e(paramContext);
    if (l != 0L) {
      this.bqO.put(Long.valueOf(l), paramb);
    }
    AppMethodBeat.o(196136);
    return paramContext;
  }
  
  protected Typeface a(Context paramContext, InputStream paramInputStream)
  {
    AppMethodBeat.i(196110);
    paramContext = l.ai(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(196110);
      return null;
    }
    try
    {
      boolean bool = l.a(paramContext, paramInputStream);
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
      AppMethodBeat.o(196110);
    }
  }
  
  /* Error */
  public Typeface a(Context paramContext, e.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: arraylength
    //   7: ifgt +10 -> 17
    //   10: ldc 161
    //   12: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: aload_2
    //   19: iload_3
    //   20: invokevirtual 164	androidx/core/graphics/k:a	([Landroidx/core/d/e$b;I)Landroidx/core/d/e$b;
    //   23: astore_2
    //   24: aload_1
    //   25: invokevirtual 170	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: aload_2
    //   29: getfield 176	androidx/core/d/e$b:mUri	Landroid/net/Uri;
    //   32: invokevirtual 182	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   35: astore_2
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 184	androidx/core/graphics/k:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   42: astore_1
    //   43: aload_2
    //   44: invokestatic 188	androidx/core/graphics/l:closeQuietly	(Ljava/io/Closeable;)V
    //   47: ldc 161
    //   49: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_1
    //   53: areturn
    //   54: astore_1
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_2
    //   58: invokestatic 188	androidx/core/graphics/l:closeQuietly	(Ljava/io/Closeable;)V
    //   61: ldc 161
    //   63: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_2
    //   71: aload_2
    //   72: invokestatic 188	androidx/core/graphics/l:closeQuietly	(Ljava/io/Closeable;)V
    //   75: ldc 161
    //   77: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: goto -12 -> 71
    //   86: astore_1
    //   87: goto -30 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	k
    //   0	90	1	paramContext	Context
    //   0	90	2	paramArrayOfb	e.b[]
    //   0	90	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   24	36	54	java/io/IOException
    //   24	36	68	finally
    //   36	43	82	finally
    //   36	43	86	java/io/IOException
  }
  
  protected e.b a(e.b[] paramArrayOfb, int paramInt)
  {
    AppMethodBeat.i(196095);
    paramArrayOfb = (e.b)a(paramArrayOfb, paramInt, new a() {});
    AppMethodBeat.o(196095);
    return paramArrayOfb;
  }
  
  static abstract interface a<T>
  {
    public abstract int aA(T paramT);
    
    public abstract boolean az(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.graphics.k
 * JD-Core Version:    0.7.0.1
 */