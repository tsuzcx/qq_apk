package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class gv
{
  protected static Paint a;
  public static gv.a b;
  private static final int c = 2048;
  private static final String d = "BitmapUtil";
  private static byte[] e;
  
  static
  {
    AppMethodBeat.i(226013);
    b = null;
    Paint localPaint = new Paint();
    a = localPaint;
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(226013);
  }
  
  private static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(225925);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      paramConfig = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      }
      catch (OutOfMemoryError paramConfig)
      {
        AppMethodBeat.o(225925);
      }
    }
    AppMethodBeat.o(225925);
    return paramConfig;
    return null;
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(225994);
    Object localObject = null;
    try
    {
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      AppMethodBeat.o(225994);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  /* Error */
  public static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 73
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_1
    //   12: invokevirtual 79	java/lang/String:trim	()Ljava/lang/String;
    //   15: invokevirtual 83	java/lang/String:length	()I
    //   18: istore_2
    //   19: iload_2
    //   20: ifne +10 -> 30
    //   23: ldc 73
    //   25: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: aload_1
    //   31: invokevirtual 79	java/lang/String:trim	()Ljava/lang/String;
    //   34: iconst_0
    //   35: invokevirtual 87	java/lang/String:charAt	(I)C
    //   38: bipush 47
    //   40: if_icmpeq +55 -> 95
    //   43: new 89	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   50: aload_0
    //   51: invokevirtual 94	android/content/Context:getFilesDir	()Ljava/io/File;
    //   54: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc 100
    //   59: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_0
    //   70: new 108	java/io/FileInputStream
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   83: astore_1
    //   84: aload_0
    //   85: invokevirtual 120	java/io/InputStream:close	()V
    //   88: ldc 73
    //   90: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: areturn
    //   95: new 89	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   102: aload_0
    //   103: invokevirtual 94	android/content/Context:getFilesDir	()Ljava/io/File;
    //   106: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_0
    //   117: goto -47 -> 70
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_3
    //   124: astore_1
    //   125: aload_0
    //   126: ifnull -38 -> 88
    //   129: aload_0
    //   130: invokevirtual 120	java/io/InputStream:close	()V
    //   133: aload_3
    //   134: astore_1
    //   135: goto -47 -> 88
    //   138: astore_0
    //   139: aload_3
    //   140: astore_1
    //   141: goto -53 -> 88
    //   144: astore_0
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 120	java/io/InputStream:close	()V
    //   155: ldc 73
    //   157: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -75 -> 88
    //   166: astore_1
    //   167: goto -12 -> 155
    //   170: astore_1
    //   171: aload_0
    //   172: astore_3
    //   173: aload_1
    //   174: astore_0
    //   175: aload_3
    //   176: astore_1
    //   177: goto -30 -> 147
    //   180: astore_1
    //   181: goto -58 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   0	184	1	paramString	String
    //   18	2	2	i	int
    //   1	175	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   11	19	120	java/lang/Exception
    //   30	70	120	java/lang/Exception
    //   70	79	120	java/lang/Exception
    //   95	117	120	java/lang/Exception
    //   129	133	138	java/lang/Exception
    //   11	19	144	finally
    //   30	70	144	finally
    //   70	79	144	finally
    //   95	117	144	finally
    //   84	88	162	java/lang/Exception
    //   151	155	166	java/lang/Exception
    //   79	84	170	finally
    //   79	84	180	java/lang/Exception
  }
  
  private static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(225933);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(225933);
      return paramBitmap;
    }
    if (paramFloat == 1.0F)
    {
      AppMethodBeat.o(225933);
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
    AppMethodBeat.o(225933);
    return paramBitmap;
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225836);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(225836);
      return null;
    }
    Bitmap localBitmap = a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localBitmap == null)
    {
      AppMethodBeat.o(225836);
      return null;
    }
    localBitmap.setDensity(paramBitmap.getDensity());
    Canvas localCanvas = new Canvas(localBitmap);
    localBitmap.eraseColor(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, a);
    AppMethodBeat.o(225836);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225846);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(225846);
      return null;
    }
    paramInt1 = Math.min(paramInt1, 2048);
    paramInt2 = Math.min(paramInt2, 2048);
    Bitmap localBitmap = a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localBitmap == null)
    {
      AppMethodBeat.o(225846);
      return null;
    }
    localBitmap.eraseColor(0);
    Canvas localCanvas = new Canvas(localBitmap);
    paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
    paramBitmap.setBounds(0, 0, paramInt1, paramInt2);
    paramBitmap.draw(localCanvas);
    AppMethodBeat.o(225846);
    return localBitmap;
  }
  
  private static Bitmap a(Drawable paramDrawable)
  {
    AppMethodBeat.i(225918);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(225918);
      return paramDrawable;
    }
    if ((paramDrawable instanceof NinePatchDrawable))
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (paramDrawable.getOpacity() != -1) {}
      for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
      {
        localObject = a(i, j, (Bitmap.Config)localObject);
        if (localObject != null) {
          break;
        }
        AppMethodBeat.o(225918);
        return null;
      }
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      AppMethodBeat.o(225918);
      return localObject;
    }
    AppMethodBeat.o(225918);
    return null;
  }
  
  public static Bitmap a(View paramView)
  {
    AppMethodBeat.i(225822);
    if (paramView != null) {}
    for (;;)
    {
      try
      {
        try
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
          paramView.setDrawingCacheEnabled(true);
          paramView.buildDrawingCache();
          Bitmap localBitmap2 = paramView.getDrawingCache();
          if (localBitmap2 == null) {
            break label211;
          }
          if (localBitmap2.isRecycled())
          {
            break label211;
            paramView.destroyDrawingCache();
            return localBitmap1;
          }
          int i = localBitmap2.getWidth();
          int j = localBitmap2.getHeight();
          if ((localBitmap2 == null) || (localBitmap2.isRecycled()) || (i <= 0) || (j <= 0)) {
            break label216;
          }
          Bitmap localBitmap1 = a(i, j, Bitmap.Config.ARGB_8888);
          if (localBitmap1 == null)
          {
            localBitmap1 = null;
            continue;
          }
          localBitmap1.setDensity(localBitmap2.getDensity());
          Canvas localCanvas = new Canvas(localBitmap1);
          localBitmap1.eraseColor(0);
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, a);
          continue;
          paramView = finally;
        }
        finally
        {
          AppMethodBeat.o(225822);
        }
        AppMethodBeat.o(225822);
      }
      finally {}
      return null;
      label211:
      Object localObject2 = null;
      continue;
      label216:
      localObject2 = null;
    }
  }
  
  public static final Bitmap a(String paramString)
  {
    AppMethodBeat.i(225974);
    Object localObject = null;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      AppMethodBeat.o(225974);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  private static Bitmap a(String paramString, int paramInt)
  {
    AppMethodBeat.i(225861);
    Object localObject1 = new Rect();
    Object localObject2 = new TextPaint(65);
    ((TextPaint)localObject2).setStyle(Paint.Style.FILL);
    ((TextPaint)localObject2).setColor(-2147483648);
    ((TextPaint)localObject2).setTextSize(paramInt);
    ((TextPaint)localObject2).clearShadowLayer();
    ((TextPaint)localObject2).getTextBounds(paramString, 0, paramString.length(), (Rect)localObject1);
    paramString = new StaticLayout(paramString, (TextPaint)localObject2, Math.round(((Rect)localObject1).width()), Layout.Alignment.ALIGN_CENTER, 0.0F, 0.0F, false);
    localObject1 = a(paramString.getWidth(), paramString.getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject1 == null)
    {
      AppMethodBeat.o(225861);
      return null;
    }
    localObject2 = new Canvas((Bitmap)localObject1);
    ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, 0.0F);
    paramString.draw((Canvas)localObject2);
    ((Canvas)localObject2).restore();
    AppMethodBeat.o(225861);
    return localObject1;
  }
  
  private static Bitmap a(int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(225802);
    paramArrayOfInt = Bitmap.createBitmap(paramArrayOfInt, paramInt1, paramInt2, paramConfig);
    AppMethodBeat.o(225802);
    return paramArrayOfInt;
  }
  
  public static String a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(225855);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(225855);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (Build.VERSION.SDK_INT >= 19) {}
    for (ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getAllocationByteCount());; localByteBuffer = ByteBuffer.allocate(paramBitmap.getByteCount()))
    {
      paramBitmap.copyPixelsToBuffer(localByteBuffer);
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localStringBuilder.append("@");
      localStringBuilder.append(i);
      localStringBuilder.append("x");
      localStringBuilder.append(j);
      localStringBuilder.append("@");
      localStringBuilder.append(Util.getMD5String(localByteBuffer.array()));
      localByteBuffer.clear();
      paramBitmap = localStringBuilder.toString();
      AppMethodBeat.o(225855);
      return paramBitmap;
    }
  }
  
  private static boolean a(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(225893);
    boolean bool = a(paramBitmap, paramString, Bitmap.CompressFormat.PNG);
    AppMethodBeat.o(225893);
    return bool;
  }
  
  /* Error */
  private static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: ldc_w 388
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +17 -> 24
    //   10: aload_0
    //   11: invokevirtual 144	android/graphics/Bitmap:isRecycled	()Z
    //   14: ifne +10 -> 24
    //   17: aload_1
    //   18: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +11 -> 32
    //   24: ldc_w 388
    //   27: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_0
    //   31: ireturn
    //   32: aconst_null
    //   33: astore_3
    //   34: new 396	java/io/FileOutputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 397	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload_0
    //   44: aload_2
    //   45: bipush 100
    //   47: aload_1
    //   48: invokevirtual 401	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   51: pop
    //   52: aload_1
    //   53: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   56: ldc_w 388
    //   59: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   71: ldc_w 388
    //   74: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_0
    //   80: aload_3
    //   81: astore_1
    //   82: aload_1
    //   83: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   86: ldc_w 388
    //   89: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: athrow
    //   94: astore_0
    //   95: goto -13 -> 82
    //   98: astore_0
    //   99: goto -32 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramBitmap	Bitmap
    //   0	102	1	paramString	String
    //   0	102	2	paramCompressFormat	Bitmap.CompressFormat
    //   33	48	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	43	64	java/lang/Exception
    //   34	43	79	finally
    //   43	52	94	finally
    //   43	52	98	java/lang/Exception
  }
  
  public static byte[] a()
  {
    AppMethodBeat.i(225811);
    if (e == null)
    {
      localObject = a(256, 256, Bitmap.Config.ARGB_8888);
      if (localObject != null)
      {
        new Canvas((Bitmap)localObject).drawARGB(0, 255, 255, 255);
        e = c((Bitmap)localObject);
      }
    }
    Object localObject = e;
    AppMethodBeat.o(225811);
    return localObject;
  }
  
  private static byte[] a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(225942);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(225942);
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(paramCompressFormat, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(225942);
    return paramBitmap;
  }
  
  /* Error */
  public static Bitmap b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 424
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 89	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: aconst_null
    //   18: invokestatic 429	com/tencent/mapsdk/internal/mf:a	(Landroid/content/Context;Lcom/tencent/tencentmap/mapsdk/maps/TencentMapOptions;)Lcom/tencent/mapsdk/internal/mf;
    //   21: invokevirtual 431	com/tencent/mapsdk/internal/mf:e	()Ljava/lang/String;
    //   24: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 434	com/tencent/mapsdk/internal/kb:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: ifnonnull +52 -> 93
    //   44: aload_3
    //   45: astore 4
    //   47: aload_3
    //   48: astore 5
    //   50: aload_3
    //   51: astore 6
    //   53: invokestatic 438	com/tencent/mapsdk/internal/mc:a	()Ljava/lang/String;
    //   56: ifnull +93 -> 149
    //   59: aload_3
    //   60: astore 4
    //   62: aload_3
    //   63: astore 5
    //   65: aload_3
    //   66: astore 6
    //   68: aload_0
    //   69: new 89	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   76: invokestatic 438	com/tencent/mapsdk/internal/mc:a	()Ljava/lang/String;
    //   79: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 441	com/tencent/mapsdk/internal/mc:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   92: astore_2
    //   93: aload_2
    //   94: astore_3
    //   95: aload_2
    //   96: ifnonnull +27 -> 123
    //   99: aload_2
    //   100: astore 4
    //   102: aload_2
    //   103: astore 5
    //   105: aload_2
    //   106: astore 6
    //   108: aload_0
    //   109: ldc_w 443
    //   112: aload_1
    //   113: invokestatic 447	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 451	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokestatic 441	com/tencent/mapsdk/internal/mc:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   122: astore_3
    //   123: aload_3
    //   124: astore 4
    //   126: aload_3
    //   127: astore 5
    //   129: aload_3
    //   130: astore 6
    //   132: aload_3
    //   133: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   136: astore_0
    //   137: aload_3
    //   138: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   141: ldc_w 424
    //   144: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_0
    //   148: areturn
    //   149: aload_3
    //   150: astore_2
    //   151: aload_3
    //   152: astore 4
    //   154: aload_3
    //   155: astore 5
    //   157: aload_3
    //   158: astore 6
    //   160: invokestatic 453	com/tencent/mapsdk/internal/mc:b	()Ljava/lang/String;
    //   163: ifnull -70 -> 93
    //   166: aload_3
    //   167: astore 4
    //   169: aload_3
    //   170: astore 5
    //   172: aload_3
    //   173: astore 6
    //   175: new 89	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   182: invokestatic 453	com/tencent/mapsdk/internal/mc:b	()Ljava/lang/String;
    //   185: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 434	com/tencent/mapsdk/internal/kb:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   198: astore_2
    //   199: goto -106 -> 93
    //   202: astore_0
    //   203: aconst_null
    //   204: astore 6
    //   206: aload 6
    //   208: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   211: aload 7
    //   213: astore_0
    //   214: goto -73 -> 141
    //   217: astore_0
    //   218: aconst_null
    //   219: astore 5
    //   221: aload 5
    //   223: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   226: aload 7
    //   228: astore_0
    //   229: goto -88 -> 141
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   239: ldc_w 424
    //   242: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_0
    //   246: athrow
    //   247: astore_0
    //   248: aload 4
    //   250: astore_1
    //   251: goto -16 -> 235
    //   254: astore_0
    //   255: goto -34 -> 221
    //   258: astore_0
    //   259: goto -53 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramContext	Context
    //   0	262	1	paramString	String
    //   39	160	2	localObject1	Object
    //   37	136	3	localObject2	Object
    //   45	204	4	localObject3	Object
    //   48	174	5	localObject4	Object
    //   51	156	6	localObject5	Object
    //   1	226	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   9	38	202	java/lang/Exception
    //   9	38	217	java/lang/OutOfMemoryError
    //   9	38	232	finally
    //   53	59	247	finally
    //   68	93	247	finally
    //   108	123	247	finally
    //   132	137	247	finally
    //   160	166	247	finally
    //   175	199	247	finally
    //   53	59	254	java/lang/OutOfMemoryError
    //   68	93	254	java/lang/OutOfMemoryError
    //   108	123	254	java/lang/OutOfMemoryError
    //   132	137	254	java/lang/OutOfMemoryError
    //   160	166	254	java/lang/OutOfMemoryError
    //   175	199	254	java/lang/OutOfMemoryError
    //   53	59	258	java/lang/Exception
    //   68	93	258	java/lang/Exception
    //   108	123	258	java/lang/Exception
    //   132	137	258	java/lang/Exception
    //   160	166	258	java/lang/Exception
    //   175	199	258	java/lang/Exception
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(226002);
    Bitmap localBitmap = paramBitmap;
    int i;
    int j;
    if (paramBitmap != null)
    {
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      i = (int)(f1 / gw.b());
      j = (int)(f2 / gw.b());
    }
    try
    {
      localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      AppMethodBeat.o(226002);
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      AppMethodBeat.o(226002);
    }
    return null;
  }
  
  private static Bitmap b(String paramString, int paramInt)
  {
    AppMethodBeat.i(225870);
    Object localObject1 = new Rect();
    Object localObject2 = new TextPaint(65);
    ((TextPaint)localObject2).setStyle(Paint.Style.FILL);
    ((TextPaint)localObject2).setColor(-2147483648);
    ((TextPaint)localObject2).setTextSize(paramInt);
    ((TextPaint)localObject2).clearShadowLayer();
    ((TextPaint)localObject2).getTextBounds(paramString, 0, paramString.length(), (Rect)localObject1);
    paramString = new StaticLayout(paramString, (TextPaint)localObject2, Math.round(((Rect)localObject1).width()), Layout.Alignment.ALIGN_CENTER, 0.0F, 0.0F, false);
    localObject1 = a(paramString.getWidth(), paramString.getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject1 == null)
    {
      AppMethodBeat.o(225870);
      return null;
    }
    localObject2 = new Canvas((Bitmap)localObject1);
    ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, 0.0F);
    paramString.draw((Canvas)localObject2);
    ((Canvas)localObject2).restore();
    AppMethodBeat.o(225870);
    return localObject1;
  }
  
  /* Error */
  public static Bitmap c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 466
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 470	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_0
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 475	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_0
    //   19: aload_0
    //   20: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   23: astore_1
    //   24: aload_0
    //   25: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   28: ldc_w 466
    //   31: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_1
    //   35: areturn
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_0
    //   39: aload_0
    //   40: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   43: ldc_w 466
    //   46: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_0
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   58: aload_2
    //   59: astore_1
    //   60: goto -32 -> 28
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: invokestatic 406	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   70: ldc_w 466
    //   73: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: astore_1
    //   85: goto -19 -> 66
    //   88: astore_1
    //   89: goto -35 -> 54
    //   92: astore_1
    //   93: goto -54 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramString	String
    //   1	83	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   13	19	36	java/lang/Exception
    //   13	19	51	java/lang/OutOfMemoryError
    //   13	19	63	finally
    //   19	24	78	finally
    //   19	24	88	java/lang/OutOfMemoryError
    //   19	24	92	java/lang/Exception
  }
  
  private static Bitmap c(String paramString, int paramInt)
  {
    AppMethodBeat.i(225876);
    Object localObject1 = new Rect();
    Object localObject2 = new TextPaint(65);
    ((TextPaint)localObject2).setStyle(Paint.Style.FILL);
    ((TextPaint)localObject2).setColor(-2147483648);
    ((TextPaint)localObject2).setTextSize(paramInt);
    ((TextPaint)localObject2).clearShadowLayer();
    ((TextPaint)localObject2).getTextBounds(paramString, 0, paramString.length(), (Rect)localObject1);
    paramString = new StaticLayout(paramString, (TextPaint)localObject2, Math.round(((Rect)localObject1).width()), Layout.Alignment.ALIGN_CENTER, 0.0F, 0.0F, false);
    localObject1 = a(paramString.getWidth(), paramString.getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject1 == null)
    {
      AppMethodBeat.o(225876);
      return null;
    }
    localObject2 = new Canvas((Bitmap)localObject1);
    ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, 0.0F);
    paramString.draw((Canvas)localObject2);
    ((Canvas)localObject2).restore();
    AppMethodBeat.o(225876);
    return localObject1;
  }
  
  private static byte[] c(Bitmap paramBitmap)
  {
    AppMethodBeat.i(225792);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(225792);
      return new byte[0];
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      kb.a(localByteArrayOutputStream);
    }
    finally
    {
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        paramBitmap = localByteArrayOutputStream.toByteArray();
        kb.a(localByteArrayOutputStream);
        AppMethodBeat.o(225792);
        return paramBitmap;
      }
      finally {}
      paramBitmap = finally;
      localByteArrayOutputStream = null;
    }
    AppMethodBeat.o(225792);
    throw paramBitmap;
  }
  
  private static Bitmap d(Bitmap paramBitmap)
  {
    AppMethodBeat.i(225829);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(225829);
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(225829);
      return null;
    }
    Bitmap localBitmap = a(i, j, Bitmap.Config.ARGB_8888);
    if (localBitmap == null)
    {
      AppMethodBeat.o(225829);
      return null;
    }
    localBitmap.setDensity(paramBitmap.getDensity());
    Canvas localCanvas = new Canvas(localBitmap);
    localBitmap.eraseColor(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, a);
    AppMethodBeat.o(225829);
    return localBitmap;
  }
  
  private static Bitmap e(Bitmap paramBitmap)
  {
    AppMethodBeat.i(225904);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(225904);
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(90.0F, i / 2.0F, j / 2.0F);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      AppMethodBeat.o(225904);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        AppMethodBeat.o(225904);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        AppMethodBeat.o(225904);
      }
    }
    return null;
  }
  
  private static Drawable f(Bitmap paramBitmap)
  {
    AppMethodBeat.i(225911);
    paramBitmap = new BitmapDrawable(paramBitmap);
    AppMethodBeat.o(225911);
    return paramBitmap;
  }
  
  private static Bitmap g(Bitmap paramBitmap)
  {
    AppMethodBeat.i(225966);
    Object localObject = null;
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      AppMethodBeat.o(225966);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        paramBitmap = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gv
 * JD-Core Version:    0.7.0.1
 */