package com.tencent.mm.ao;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o
{
  public static Bitmap US(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(124113);
    if ((Util.isNullOrNil(paramString)) || (!h.aHG().isSDCardAvailable()) || (!h.aHE().aGM()))
    {
      AppMethodBeat.o(124113);
      return null;
    }
    Bitmap localBitmap = af.bjG().UT(paramString);
    if (localBitmap == null) {
      bool = true;
    }
    Log.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", new Object[] { paramString, String.valueOf(bool) });
    AppMethodBeat.o(124113);
    return localBitmap;
  }
  
  static String bl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124116);
    if ((paramString1 == null) || (!h.aHE().aGM()))
    {
      AppMethodBeat.o(124116);
      return null;
    }
    paramString1 = af.bjv().Uo(paramString1);
    if (paramString1.field_brandIconURL != null)
    {
      paramString1 = paramString1.field_brandIconURL;
      AppMethodBeat.o(124116);
      return paramString1;
    }
    AppMethodBeat.o(124116);
    return paramString2;
  }
  
  public static Bitmap k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(205291);
    if (!h.aHG().isSDCardAvailable())
    {
      paramString1 = vN(paramInt);
      AppMethodBeat.o(205291);
      return paramString1;
    }
    if ((paramString1 == null) || (!h.aHE().aGM()))
    {
      AppMethodBeat.o(205291);
      return null;
    }
    final String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = bl(paramString1, null);
      str = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(205291);
        return null;
      }
    }
    paramString2 = af.bjG();
    Object localObject;
    if (paramString2.lFa.containsKey(paramString1))
    {
      localObject = (Bitmap)((WeakReference)paramString2.lFa.get(paramString1)).get();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        localObject = bl(paramString1, str);
        localObject = BitmapUtil.getBitmapNative(a.UU(paramString1 + (String)localObject));
        if (localObject == null)
        {
          Log.i("MicroMsg.BrandLogic", "not found brand icon local");
          paramString2 = null;
          label170:
          if (paramString2 == null) {
            break label276;
          }
          AppMethodBeat.o(205291);
          return paramString2;
        }
        paramString2.f(paramString1, (Bitmap)localObject);
      }
    }
    for (;;)
    {
      paramString2 = (WeakReference)paramString2.lFa.get(paramString1);
      if (paramString2 == null) {
        break;
      }
      paramString2 = (Bitmap)paramString2.get();
      break label170;
      localObject = bl(paramString1, str);
      localObject = BitmapUtil.getBitmapNative(a.UU(paramString1 + (String)localObject));
      if (localObject == null)
      {
        Log.i("MicroMsg.BrandLogic", "not found brand icon local");
        break;
      }
      paramString2.f(paramString1, (Bitmap)localObject);
    }
    label276:
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124105);
        o.a locala = af.bjG();
        String str1 = this.lEW;
        String str2 = str;
        if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
        {
          Log.e("MicroMsg.BrandLogic", "pushing for brand " + str1 + ", url " + str2);
          AppMethodBeat.o(124105);
          return;
        }
        if (Util.secondsToNow(Util.nullAsNil((Integer)locala.lEZ.get(str1))) < 300L)
        {
          Log.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for ".concat(String.valueOf(str1)));
          AppMethodBeat.o(124105);
          return;
        }
        locala.lEZ.put(str1, Integer.valueOf((int)Util.nowSecond()));
        if ((locala.lFb == null) || (locala.lFb.isDead())) {
          locala.lFb = new QueueWorkerThread(1, "brand-logic");
        }
        str2 = o.bl(str1, str2);
        locala.lFb.add(new o.b(str1, str2));
        AppMethodBeat.o(124105);
      }
    });
    AppMethodBeat.o(205291);
    return null;
  }
  
  /* Error */
  private static Bitmap vN(int paramInt)
  {
    // Byte code:
    //   0: ldc 171
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_0
    //   6: ifgt +10 -> 16
    //   9: ldc 171
    //   11: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 173	android/graphics/BitmapFactory$Options
    //   19: dup
    //   20: invokespecial 174	android/graphics/BitmapFactory$Options:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: invokestatic 178	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   28: invokestatic 184	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   31: invokevirtual 190	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   34: iload_0
    //   35: invokevirtual 196	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   38: astore_1
    //   39: aload_1
    //   40: aconst_null
    //   41: aload_2
    //   42: invokestatic 202	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +7 -> 54
    //   50: aload_1
    //   51: invokevirtual 207	java/io/InputStream:close	()V
    //   54: aload_2
    //   55: astore_1
    //   56: aload_2
    //   57: ifnull +16 -> 73
    //   60: aload_2
    //   61: iconst_0
    //   62: aload_2
    //   63: invokevirtual 211	android/graphics/Bitmap:getWidth	()I
    //   66: iconst_1
    //   67: ishr
    //   68: i2f
    //   69: invokestatic 215	com/tencent/mm/sdk/platformtools/BitmapUtil:getRoundedCornerBitmap	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   72: astore_1
    //   73: ldc 171
    //   75: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_1
    //   79: areturn
    //   80: astore_1
    //   81: ldc 62
    //   83: aload_1
    //   84: ldc 217
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: goto -39 -> 54
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 207	java/io/InputStream:close	()V
    //   107: ldc 171
    //   109: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_2
    //   113: athrow
    //   114: astore_1
    //   115: ldc 62
    //   117: aload_1
    //   118: ldc 217
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: goto -20 -> 107
    //   130: astore_2
    //   131: goto -32 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramInt	int
    //   38	41	1	localObject1	Object
    //   80	4	1	localIOException1	java.io.IOException
    //   98	6	1	localObject2	Object
    //   114	4	1	localIOException2	java.io.IOException
    //   23	40	2	localObject3	Object
    //   96	17	2	localObject4	Object
    //   130	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   50	54	80	java/io/IOException
    //   28	39	96	finally
    //   103	107	114	java/io/IOException
    //   39	46	130	finally
  }
  
  public static final class a
  {
    List<Object> lEY;
    Map<String, Integer> lEZ;
    Map<String, WeakReference<Bitmap>> lFa;
    QueueWorkerThread lFb;
    
    public a()
    {
      AppMethodBeat.i(124106);
      this.lEY = new ArrayList();
      this.lEZ = new HashMap();
      this.lFa = new HashMap();
      this.lFb = null;
      AppMethodBeat.o(124106);
    }
    
    public static String UU(String paramString)
    {
      AppMethodBeat.i(124109);
      if (h.aHE().aGM())
      {
        paramString = ((q)h.ae(q.class)).bcf() + "/brand_" + g.getMessageDigest(paramString.getBytes());
        AppMethodBeat.o(124109);
        return paramString;
      }
      AppMethodBeat.o(124109);
      return "";
    }
    
    final Bitmap UT(String paramString)
    {
      AppMethodBeat.i(124108);
      String str = String.format("%s%f", new Object[] { paramString, Float.valueOf(1.5F) });
      Bitmap localBitmap1;
      if (this.lFa.containsKey(str))
      {
        Bitmap localBitmap2 = (Bitmap)((WeakReference)this.lFa.get(str)).get();
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap2.isRecycled()) {}
        }
        else
        {
          localBitmap1 = BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.5F);
          this.lFa.remove(str);
          this.lFa.put(str, new WeakReference(localBitmap1));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(124108);
        return localBitmap1;
        localBitmap1 = BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.5F);
        this.lFa.put(str, new WeakReference(localBitmap1));
      }
    }
    
    public final void bjm()
    {
      AppMethodBeat.i(124107);
      this.lEY.clear();
      AppMethodBeat.o(124107);
    }
    
    final void f(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(124110);
      Bitmap localBitmap1;
      if (this.lFa.containsKey(paramString)) {
        localBitmap1 = (Bitmap)((WeakReference)this.lFa.get(paramString)).get();
      }
      for (;;)
      {
        Bitmap localBitmap3;
        if (localBitmap1 != null)
        {
          localBitmap3 = localBitmap1;
          if (!localBitmap1.isRecycled()) {
            break label110;
          }
        }
        try
        {
          localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, 128, 128, true);
          localBitmap1 = BitmapUtil.getRoundedCornerBitmap(localBitmap1, true, localBitmap1.getWidth() >> 1);
          this.lFa.remove(paramString);
          this.lFa.put(paramString, new WeakReference(localBitmap1));
          localBitmap3 = localBitmap1;
          label110:
          if (localBitmap3 == paramBitmap)
          {
            AppMethodBeat.o(124110);
            return;
            localBitmap1 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Bitmap localBitmap2 = paramBitmap;
          }
          Log.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          AppMethodBeat.o(124110);
        }
      }
    }
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    private final String brand;
    public byte[] lAw = null;
    private final String url;
    
    public b(String paramString1, String paramString2)
    {
      this.brand = paramString1;
      this.url = paramString2;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(124111);
      if ((Util.isNullOrNil(this.brand)) || (Util.isNullOrNil(this.url)))
      {
        AppMethodBeat.o(124111);
        return false;
      }
      Object localObject1;
      Object localObject2;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject1 = d.x(this.url, 3000, 5000);
        if (localObject1 == null)
        {
          AppMethodBeat.o(124111);
          return false;
        }
        localObject2 = new byte[1024];
        for (;;)
        {
          int i = ((InputStream)localObject1).read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write((byte[])localObject2, 0, i);
        }
        ((InputStream)localObject1).close();
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { Util.stackTraceToString(localException1) });
        Log.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
        this.lAw = null;
        AppMethodBeat.o(124111);
        return false;
      }
      this.lAw = localException1.toByteArray();
      localException1.close();
      if (Util.isNullOrNil(this.lAw))
      {
        Log.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.brand);
        AppMethodBeat.o(124111);
        return false;
      }
      o.a locala;
      String str;
      if (h.aHE().aGM())
      {
        az.a.lts.dH(this.lAw.length, 0);
        locala = af.bjG();
        localObject1 = this.brand;
        str = this.url;
        localObject2 = this.lAw;
      }
      try
      {
        str = (String)localObject1 + str;
        localObject2 = BitmapUtil.decodeByteArray((byte[])localObject2);
        BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 100, Bitmap.CompressFormat.PNG, o.a.UU(str), false);
        locala.f((String)localObject1, (Bitmap)localObject2);
        Log.i("MicroMsg.BrandLogic", "update brand icon for  " + (String)localObject1 + ", done");
        locala.lEZ.remove(localObject1);
        AppMethodBeat.o(124111);
        return true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { Util.stackTraceToString(localException2) });
        }
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(124112);
      o.a locala = af.bjG();
      int i = 0;
      try
      {
        while (i < locala.lEY.size())
        {
          locala.lEY.get(i);
          i += 1;
        }
        return false;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(124112);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.o
 * JD-Core Version:    0.7.0.1
 */