package com.tencent.mapsdk.raster.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mapsdk.rastercore.core.MapContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class BitmapDescriptorFactory
{
  public static BitmapDescriptor defaultMarker()
  {
    AppMethodBeat.i(87529);
    BitmapDescriptor localBitmapDescriptor = fromAsset("marker.png");
    AppMethodBeat.o(87529);
    return localBitmapDescriptor;
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    AppMethodBeat.i(87527);
    try
    {
      paramString = BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(String.valueOf(paramString)));
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      paramString.close();
      paramString = fromBitmap(localBitmap);
      AppMethodBeat.o(87527);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(87527);
    }
    return null;
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(87530);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(87530);
      return null;
    }
    paramBitmap = new BitmapDescriptor(paramBitmap);
    AppMethodBeat.o(87530);
    return paramBitmap;
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    AppMethodBeat.i(87528);
    try
    {
      paramString = new FileInputStream(new File(paramString));
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      paramString.close();
      paramString = fromBitmap(localBitmap);
      AppMethodBeat.o(87528);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(87528);
    }
    return null;
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    AppMethodBeat.i(87526);
    try
    {
      paramString = fromBitmap(BitmapFactory.decodeFile(paramString));
      AppMethodBeat.o(87526);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(87526);
    }
    return null;
  }
  
  /* Error */
  public static BitmapDescriptor fromResource(int paramInt)
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 97	com/tencent/mapsdk/rastercore/core/MapContext:getContext	()Landroid/content/Context;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +31 -> 41
    //   13: aload_1
    //   14: invokevirtual 103	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   17: iload_0
    //   18: invokevirtual 109	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 54	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   26: invokestatic 63	com/tencent/mapsdk/raster/model/BitmapDescriptorFactory:fromBitmap	(Landroid/graphics/Bitmap;)Lcom/tencent/mapsdk/raster/model/BitmapDescriptor;
    //   29: astore_2
    //   30: aload_1
    //   31: invokestatic 115	com/tencent/mapsdk/rastercore/tools/IO:safeClose	(Ljava/io/Closeable;)V
    //   34: ldc 91
    //   36: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_2
    //   40: areturn
    //   41: aconst_null
    //   42: invokestatic 115	com/tencent/mapsdk/rastercore/tools/IO:safeClose	(Ljava/io/Closeable;)V
    //   45: ldc 91
    //   47: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aconst_null
    //   51: areturn
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: invokestatic 115	com/tencent/mapsdk/rastercore/tools/IO:safeClose	(Ljava/io/Closeable;)V
    //   59: ldc 91
    //   61: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_2
    //   70: invokestatic 115	com/tencent/mapsdk/rastercore/tools/IO:safeClose	(Ljava/io/Closeable;)V
    //   73: ldc 91
    //   75: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_1
    //   79: athrow
    //   80: astore_2
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: astore_2
    //   87: goto -18 -> 69
    //   90: astore_2
    //   91: goto -36 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramInt	int
    //   8	23	1	localObject1	Object
    //   52	1	1	localException1	Exception
    //   54	2	1	localCloseable	java.io.Closeable
    //   66	16	1	localObject2	Object
    //   84	1	1	localObject3	Object
    //   29	41	2	localBitmapDescriptor	BitmapDescriptor
    //   80	4	2	localObject4	Object
    //   86	1	2	localObject5	Object
    //   90	1	2	localException2	Exception
    //   82	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	52	java/lang/Exception
    //   13	22	52	java/lang/Exception
    //   5	9	66	finally
    //   13	22	66	finally
    //   22	30	80	finally
    //   22	30	90	java/lang/Exception
  }
  
  public static BitmapDescriptor fromView(View paramView)
  {
    AppMethodBeat.i(87524);
    try
    {
      Object localObject = MapContext.getContext();
      if (localObject != null)
      {
        localObject = new FrameLayout((Context)localObject);
        ((FrameLayout)localObject).addView(paramView);
        ((FrameLayout)localObject).destroyDrawingCache();
        paramView = fromBitmap(getViewBitmap((View)localObject));
        AppMethodBeat.o(87524);
        return paramView;
      }
      AppMethodBeat.o(87524);
      return null;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(87524);
    }
    return null;
  }
  
  private static Bitmap getViewBitmap(View paramView)
  {
    AppMethodBeat.i(87525);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    paramView.buildDrawingCache();
    paramView = paramView.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
    AppMethodBeat.o(87525);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.BitmapDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */