package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.bumptech.glide.c.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class p
{
  private static final Paint aIW;
  private static final Paint aIX;
  private static final Paint aIY;
  private static final Set<String> aIZ;
  private static final Lock aJa;
  
  static
  {
    AppMethodBeat.i(77436);
    aIW = new Paint(6);
    aIX = new Paint(7);
    Object localObject = new HashSet(Arrays.asList(new String[] { "XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079" }));
    aIZ = (Set)localObject;
    if (((Set)localObject).contains(Build.MODEL)) {}
    for (localObject = new ReentrantLock();; localObject = new p.a())
    {
      aJa = (Lock)localObject;
      localObject = new Paint(7);
      aIY = (Paint)localObject;
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      AppMethodBeat.o(77436);
      return;
    }
  }
  
  public static Bitmap a(e parame, Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(77435);
    if (!du(paramInt))
    {
      AppMethodBeat.o(77435);
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    RectF localRectF;
    int i;
    switch (paramInt)
    {
    default: 
      localRectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
      localMatrix.mapRect(localRectF);
      paramInt = Math.round(localRectF.width());
      i = Math.round(localRectF.height());
      if (paramBitmap.getConfig() == null) {
        break;
      }
    }
    for (Object localObject = paramBitmap.getConfig();; localObject = Bitmap.Config.ARGB_8888)
    {
      parame = parame.b(paramInt, i, (Bitmap.Config)localObject);
      localMatrix.postTranslate(-localRectF.left, -localRectF.top);
      aJa.lock();
      try
      {
        localObject = new Canvas(parame);
        ((Canvas)localObject).drawBitmap(paramBitmap, localMatrix, aIW);
        ((Canvas)localObject).setBitmap(null);
        return parame;
      }
      finally
      {
        aJa.unlock();
        AppMethodBeat.o(77435);
      }
      localMatrix.setScale(-1.0F, 1.0F);
      break;
      localMatrix.setRotate(180.0F);
      break;
      localMatrix.setRotate(180.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      break;
      localMatrix.setRotate(90.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      break;
      localMatrix.setRotate(90.0F);
      break;
      localMatrix.setRotate(-90.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      break;
      localMatrix.setRotate(-90.0F);
      break;
    }
  }
  
  public static int dt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 5: 
    case 6: 
      return 90;
    case 3: 
    case 4: 
      return 180;
    }
    return 270;
  }
  
  public static boolean du(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static Lock pb()
  {
    return aJa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.p
 * JD-Core Version:    0.7.0.1
 */