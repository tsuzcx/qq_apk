package com.tencent.mm.ai;

import android.graphics.Bitmap;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class m
{
  static String an(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (!g.DN().Dc())) {
      paramString2 = null;
    }
    do
    {
      return paramString2;
      paramString1 = z.My().kQ(paramString1);
    } while (paramString1.field_brandIconURL == null);
    return paramString1.field_brandIconURL;
  }
  
  public static Bitmap f(String paramString1, String paramString2, int paramInt)
  {
    Object localObject;
    if (!g.DP().isSDCardAvailable()) {
      localObject = ip(paramInt);
    }
    String str;
    label152:
    do
    {
      return localObject;
      if ((paramString1 == null) || (!g.DN().Dc())) {
        return null;
      }
      str = paramString2;
      if (paramString2 == null)
      {
        paramString2 = an(paramString1, null);
        str = paramString2;
        if (paramString2 == null) {
          return null;
        }
      }
      paramString2 = z.MI();
      if (!paramString2.egG.containsKey(paramString1)) {
        break label209;
      }
      localObject = (Bitmap)((WeakReference)paramString2.egG.get(paramString1)).get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        break label180;
      }
      localObject = an(paramString1, str);
      localObject = c.YW(m.a.ll(paramString1 + (String)localObject));
      if (localObject != null) {
        break;
      }
      y.i("MicroMsg.BrandLogic", "not found brand icon local");
      paramString2 = null;
      localObject = paramString2;
    } while (paramString2 != null);
    ai.d(new m.1(paramString1, str));
    return null;
    paramString2.f(paramString1, (Bitmap)localObject);
    for (;;)
    {
      label180:
      paramString2 = (WeakReference)paramString2.egG.get(paramString1);
      if (paramString2 == null) {
        break;
      }
      paramString2 = (Bitmap)paramString2.get();
      break label152;
      label209:
      localObject = an(paramString1, str);
      localObject = c.YW(m.a.ll(paramString1 + (String)localObject));
      if (localObject == null)
      {
        y.i("MicroMsg.BrandLogic", "not found brand icon local");
        break;
      }
      paramString2.f(paramString1, (Bitmap)localObject);
    }
  }
  
  /* Error */
  public static Bitmap ip(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: iload_0
    //   3: ifgt +5 -> 8
    //   6: aload_1
    //   7: areturn
    //   8: new 140	android/graphics/BitmapFactory$Options
    //   11: dup
    //   12: invokespecial 141	android/graphics/BitmapFactory$Options:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: invokestatic 145	com/tencent/mm/sdk/platformtools/c:c	(Landroid/graphics/BitmapFactory$Options;)V
    //   20: invokestatic 151	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   23: invokevirtual 157	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   26: iload_0
    //   27: invokevirtual 163	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   30: astore_1
    //   31: aload_1
    //   32: aconst_null
    //   33: aload_2
    //   34: invokestatic 169	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   37: astore_2
    //   38: aload_1
    //   39: ifnull +7 -> 46
    //   42: aload_1
    //   43: invokevirtual 174	java/io/InputStream:close	()V
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: ifnull -43 -> 6
    //   52: aload_2
    //   53: iconst_0
    //   54: aload_2
    //   55: invokevirtual 178	android/graphics/Bitmap:getWidth	()I
    //   58: iconst_1
    //   59: ishr
    //   60: i2f
    //   61: invokestatic 181	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   64: areturn
    //   65: astore_1
    //   66: ldc 115
    //   68: aload_1
    //   69: ldc 183
    //   71: iconst_0
    //   72: anewarray 4	java/lang/Object
    //   75: invokestatic 187	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: goto -32 -> 46
    //   81: astore_2
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 174	java/io/InputStream:close	()V
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: ldc 115
    //   97: aload_1
    //   98: ldc 183
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokestatic 187	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: goto -15 -> 92
    //   110: astore_2
    //   111: goto -27 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInt	int
    //   1	47	1	localObject1	Object
    //   65	4	1	localIOException1	java.io.IOException
    //   83	6	1	localObject2	Object
    //   94	4	1	localIOException2	java.io.IOException
    //   15	40	2	localObject3	Object
    //   81	12	2	localObject4	Object
    //   110	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   42	46	65	java/io/IOException
    //   20	31	81	finally
    //   88	92	94	java/io/IOException
    //   31	38	110	finally
  }
  
  public static Bitmap lk(String paramString)
  {
    boolean bool = false;
    if ((bk.bl(paramString)) || (!g.DP().isSDCardAvailable()) || (!g.DN().Dc())) {
      return null;
    }
    m.a locala = z.MI();
    String str = String.format("%s%f", new Object[] { paramString, Float.valueOf(1.5F) });
    Bitmap localBitmap1;
    if (locala.egG.containsKey(str))
    {
      Bitmap localBitmap2 = (Bitmap)((WeakReference)locala.egG.get(str)).get();
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BackwardSupportUtil.b.e(paramString, 1.5F);
        locala.egG.remove(str);
        locala.egG.put(str, new WeakReference(localBitmap1));
      }
    }
    for (;;)
    {
      if (localBitmap1 == null) {
        bool = true;
      }
      y.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", new Object[] { paramString, String.valueOf(bool) });
      return localBitmap1;
      localBitmap1 = BackwardSupportUtil.b.e(paramString, 1.5F);
      locala.egG.put(str, new WeakReference(localBitmap1));
    }
  }
  
  public static abstract interface a$a
  {
    public abstract void lm(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.m
 * JD-Core Version:    0.7.0.1
 */