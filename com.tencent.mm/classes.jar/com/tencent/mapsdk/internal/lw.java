package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

public final class lw
{
  public static final int a = 1;
  public static final int b = 2;
  
  private static float a(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  private static float a(TencentMapContext paramTencentMapContext, String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(222904);
    paramTencentMapContext = new mg(paramTencentMapContext);
    paramTencentMapContext.setTextSize(a(paramInt, paramFloat));
    paramTencentMapContext.setTypeface(Typeface.DEFAULT_BOLD);
    paramFloat = paramTencentMapContext.measureText(paramString);
    AppMethodBeat.o(222904);
    return paramFloat;
  }
  
  private static int a(GL10 paramGL10)
  {
    AppMethodBeat.i(222931);
    int[] arrayOfInt = new int[1];
    paramGL10.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    AppMethodBeat.o(222931);
    return i;
  }
  
  private static int a(GL10 paramGL10, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IntBuffer paramIntBuffer)
  {
    AppMethodBeat.i(222863);
    int i = b(paramGL10);
    paramGL10.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    paramGL10.glTexSubImage2D(3553, 0, 0, 0, paramInt3, paramInt4, 6408, 5121, paramIntBuffer);
    AppMethodBeat.o(222863);
    return i;
  }
  
  private static int a(GL10 paramGL10, Bitmap paramBitmap)
  {
    AppMethodBeat.i(222846);
    int i = b(paramGL10);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    AppMethodBeat.o(222846);
    return i;
  }
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    int k = 2;
    AppMethodBeat.i(222784);
    int n = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int i = 2;
    int j;
    for (;;)
    {
      j = k;
      if (i >= n) {
        break;
      }
      i <<= 1;
    }
    while (j < m) {
      j <<= 1;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(false);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(0);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.setDensity(0);
      localBitmap.eraseColor(0);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      AppMethodBeat.o(222784);
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      AppMethodBeat.o(222784);
    }
    return null;
  }
  
  private static Bitmap a(TencentMapContext paramTencentMapContext, Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222872);
    float f3 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    paramTencentMapContext = new mg(paramTencentMapContext);
    paramTencentMapContext.setColor(paramInt1);
    paramTencentMapContext.setTextSize(a(paramInt2, 2.0F));
    paramTencentMapContext.setTypeface(Typeface.DEFAULT_BOLD);
    float f1 = paramTencentMapContext.getFontMetrics().bottom - paramTencentMapContext.getFontMetrics().top;
    f3 = Math.max(f3, paramTencentMapContext.measureText(paramString));
    f2 = Math.max(f2, f1);
    paramInt1 = (int)Math.ceil(f3 + 0.0F);
    paramInt2 = (int)Math.ceil(f2 + 0.0F);
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.setDensity(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
    f2 = (float)(paramInt1 / 2L);
    f3 = paramInt2;
    f1 = (paramInt2 - f1) / 2.0F;
    float f4 = paramTencentMapContext.getFontMetrics().bottom;
    paramTencentMapContext.setTextAlign(Paint.Align.CENTER);
    localCanvas.drawText(paramString, f2, f3 - f1 - f4, paramTencentMapContext);
    AppMethodBeat.o(222872);
    return localBitmap;
  }
  
  private static Bitmap a(InputStream paramInputStream)
  {
    AppMethodBeat.i(222791);
    paramInputStream = BitmapFactory.decodeStream(paramInputStream, null, a());
    AppMethodBeat.o(222791);
    return paramInputStream;
  }
  
  private static Bitmap a(String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3, Typeface paramTypeface)
  {
    AppMethodBeat.i(222924);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(paramFloat);
    if (paramTypeface != null) {
      localPaint.setTypeface(paramTypeface);
    }
    paramTypeface = new Paint(localPaint);
    paramTypeface.setColor(paramInt2);
    paramTypeface.setStrokeWidth(localPaint.getStrokeWidth() + 2.0F);
    Object localObject = paramTypeface.getFontMetrics();
    float f = ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top;
    switch (paramInt3)
    {
    default: 
      AppMethodBeat.o(222924);
      return null;
    case 2: 
      paramInt1 = (int)Math.ceil(paramTypeface.measureText(paramString) + 4.0F);
      paramInt2 = (int)Math.ceil(f);
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas((Bitmap)localObject);
      paramFloat = (float)(paramInt1 / 2L);
      f = (float)(paramInt2 / 2L + 1L);
      paramTypeface.setTextAlign(Paint.Align.CENTER);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localCanvas.drawText(paramString, paramFloat, f, paramTypeface);
      localCanvas.drawText(paramString, paramFloat, f, localPaint);
      AppMethodBeat.o(222924);
      return localObject;
    }
    paramInt1 = (int)Math.ceil((2.0F + f) * paramString.length() + 4.0F);
    paramInt2 = (int)Math.ceil(paramTypeface.measureText(paramString.substring(0, 1)) + 4.0F);
    paramFloat = 0.0F - ((Paint.FontMetrics)localObject).top;
    localObject = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramInt1 = 0;
    while (paramInt1 < paramString.length())
    {
      char c = paramString.charAt(paramInt1);
      localCanvas.drawText(String.valueOf(c), 2.0F, paramFloat, paramTypeface);
      localCanvas.drawText(String.valueOf(c), 2.0F, paramFloat, localPaint);
      paramFloat += f;
      paramInt1 += 1;
    }
    AppMethodBeat.o(222924);
    return localObject;
  }
  
  private static Bitmap a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222799);
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, a());
    AppMethodBeat.o(222799);
    return paramArrayOfByte;
  }
  
  private static BitmapFactory.Options a()
  {
    AppMethodBeat.i(222834);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    AppMethodBeat.o(222834);
    return localOptions;
  }
  
  private static void a(GL10 paramGL10, int paramInt)
  {
    AppMethodBeat.i(222855);
    Object localObject = ByteBuffer.allocateDirect(4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asIntBuffer();
    ((IntBuffer)localObject).put(paramInt);
    ((IntBuffer)localObject).position(0);
    paramGL10.glDeleteTextures(1, (IntBuffer)localObject);
    AppMethodBeat.o(222855);
  }
  
  private static int b(GL10 paramGL10)
  {
    AppMethodBeat.i(222942);
    int i = a(paramGL10);
    paramGL10.glBindTexture(3553, i);
    paramGL10.glTexParameterf(3553, 10241, 9729.0F);
    paramGL10.glTexParameterf(3553, 10240, 9729.0F);
    paramGL10.glTexParameterf(3553, 10242, 33071.0F);
    paramGL10.glTexParameterf(3553, 10243, 33071.0F);
    AppMethodBeat.o(222942);
    return i;
  }
  
  private static Bitmap b(Bitmap paramBitmap)
  {
    int k = 2;
    AppMethodBeat.i(222826);
    int n = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int i = 2;
    int j;
    for (;;)
    {
      j = k;
      if (i >= n) {
        break;
      }
      i <<= 1;
    }
    while (j < m) {
      j <<= 1;
    }
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, false);
    if (localBitmap != paramBitmap) {
      paramBitmap.recycle();
    }
    AppMethodBeat.o(222826);
    return localBitmap;
  }
  
  private static Bitmap b(TencentMapContext paramTencentMapContext, Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222882);
    float f3 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    paramTencentMapContext = new mg(paramTencentMapContext);
    paramTencentMapContext.setColor(paramInt1);
    paramTencentMapContext.setTextSize(a(paramInt2, 2.0F));
    paramTencentMapContext.setTypeface(Typeface.DEFAULT_BOLD);
    float f1 = paramTencentMapContext.getFontMetrics().bottom - paramTencentMapContext.getFontMetrics().top;
    f3 = Math.max(f3, paramTencentMapContext.measureText(paramString));
    f2 = Math.max(f2, f1);
    paramInt1 = (int)Math.ceil(f3 + 0.0F);
    paramInt2 = (int)Math.ceil(f2 + 0.0F);
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.setDensity(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
    f2 = (float)(paramInt1 / 2L);
    f3 = paramInt2;
    f1 = (paramInt2 - f1) / 2.0F;
    float f4 = paramTencentMapContext.getFontMetrics().bottom;
    paramTencentMapContext.setTextAlign(Paint.Align.CENTER);
    localCanvas.drawText(paramString, f2, f3 - f1 - f4, paramTencentMapContext);
    AppMethodBeat.o(222882);
    return localBitmap;
  }
  
  private static Bitmap b(InputStream paramInputStream)
  {
    AppMethodBeat.i(222813);
    paramInputStream = b(BitmapFactory.decodeStream(paramInputStream, null, a()));
    AppMethodBeat.o(222813);
    return paramInputStream;
  }
  
  private static Bitmap b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222806);
    paramArrayOfByte = b(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, a()));
    AppMethodBeat.o(222806);
    return paramArrayOfByte;
  }
  
  private static Bitmap c(TencentMapContext paramTencentMapContext, Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222894);
    float f3 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    paramTencentMapContext = new mg(paramTencentMapContext);
    paramTencentMapContext.setColor(paramInt1);
    paramTencentMapContext.setTextSize(a(paramInt2, 2.0F));
    paramTencentMapContext.setTypeface(Typeface.DEFAULT_BOLD);
    float f1 = paramTencentMapContext.getFontMetrics().bottom - paramTencentMapContext.getFontMetrics().top;
    f3 = Math.max(f3, paramTencentMapContext.measureText(paramString));
    f2 = Math.max(f2, f1);
    paramInt1 = (int)Math.ceil(f3 + 0.0F);
    paramInt2 = (int)Math.ceil(f2 + 0.0F);
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.setDensity(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
    f2 = (float)(paramInt1 / 2L);
    f3 = paramInt2;
    f1 = (paramInt2 - f1) / 2.0F;
    float f4 = paramTencentMapContext.getFontMetrics().bottom;
    paramTencentMapContext.setTextAlign(Paint.Align.CENTER);
    localCanvas.drawText(paramString, f2, f3 - f1 - f4, paramTencentMapContext);
    AppMethodBeat.o(222894);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lw
 * JD-Core Version:    0.7.0.1
 */