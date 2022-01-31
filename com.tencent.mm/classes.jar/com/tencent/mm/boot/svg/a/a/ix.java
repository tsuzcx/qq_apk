package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class ix
  extends c
{
  private final int height = 102;
  private final int width = 102;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 102;
      return 102;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -1.0F, 0.0F, 1.0F, -2.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(64.103157F, 2.0F);
      localPath.lineTo(103.0F, 40.826099F);
      localPath.lineTo(102.95464F, 104.0F);
      localPath.lineTo(1.0F, 2.0F);
      localPath.lineTo(64.103157F, 2.0F);
      localPath.close();
      localPath.moveTo(42.299107F, 26.234137F);
      localPath.lineTo(51.097515F, 17.435728F);
      localPath.lineTo(51.180771F, 17.518986F);
      localPath.lineTo(48.626644F, 32.561672F);
      localPath.lineTo(50.939339F, 34.874371F);
      localPath.lineTo(64.374367F, 21.439341F);
      localPath.lineTo(61.700893F, 18.765863F);
      localPath.lineTo(52.949036F, 27.517719F);
      localPath.lineTo(52.875031F, 27.443712F);
      localPath.lineTo(55.391857F, 12.456829F);
      localPath.lineTo(53.060661F, 10.125631F);
      localPath.lineTo(39.625629F, 23.560659F);
      localPath.lineTo(42.299107F, 26.234137F);
      localPath.close();
      localPath.moveTo(64.706299F, 43.486088F);
      localPath.lineTo(58.417786F, 37.197571F);
      localPath.lineTo(61.806801F, 33.808556F);
      localPath.lineTo(67.739548F, 39.741299F);
      localPath.lineTo(69.899574F, 37.581264F);
      localPath.lineTo(63.966831F, 31.648521F);
      localPath.lineTo(67.206879F, 28.408474F);
      localPath.lineTo(73.495399F, 34.696991F);
      localPath.lineTo(75.813705F, 32.378681F);
      localPath.lineTo(66.621323F, 23.186291F);
      localPath.lineTo(53.186291F, 36.621319F);
      localPath.lineTo(62.378681F, 45.813709F);
      localPath.lineTo(64.706299F, 43.486088F);
      localPath.close();
      localPath.moveTo(81.915909F, 46.990662F);
      localPath.lineTo(82.0F, 47.074749F);
      localPath.lineTo(75.379944F, 58.814972F);
      localPath.lineTo(78.042809F, 61.477837F);
      localPath.lineTo(95.056351F, 51.621319F);
      localPath.lineTo(92.131874F, 48.696842F);
      localPath.lineTo(80.272125F, 56.296009F);
      localPath.lineTo(80.19738F, 56.221264F);
      localPath.lineTo(87.404121F, 43.969093F);
      localPath.lineTo(85.021561F, 41.586533F);
      localPath.lineTo(72.769394F, 48.793278F);
      localPath.lineTo(72.694649F, 48.718529F);
      localPath.lineTo(80.303154F, 36.86813F);
      localPath.lineTo(77.378677F, 33.943649F);
      localPath.lineTo(67.512817F, 50.947849F);
      localPath.lineTo(70.175682F, 53.610714F);
      localPath.lineTo(81.915909F, 46.990662F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 46.286797F, 0.7071068F, 0.7071068F, -36.746208F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(41.780869F, 47.0F);
      ((Path)localObject).lineTo(41.780869F, 34.557171F);
      ((Path)localObject).lineTo(41.898609F, 34.557171F);
      ((Path)localObject).lineTo(50.729355F, 47.0F);
      ((Path)localObject).lineTo(54.0F, 47.0F);
      ((Path)localObject).lineTo(54.0F, 28.0F);
      ((Path)localObject).lineTo(50.219131F, 28.0F);
      ((Path)localObject).lineTo(50.219131F, 40.376991F);
      ((Path)localObject).lineTo(50.114471F, 40.376991F);
      ((Path)localObject).lineTo(41.29681F, 28.0F);
      ((Path)localObject).lineTo(38.0F, 28.0F);
      ((Path)localObject).lineTo(38.0F, 47.0F);
      ((Path)localObject).lineTo(41.780869F, 47.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(70.0F, 43.708248F);
      ((Path)localObject).lineTo(61.106693F, 43.708248F);
      ((Path)localObject).lineTo(61.106693F, 38.915455F);
      ((Path)localObject).lineTo(69.496864F, 38.915455F);
      ((Path)localObject).lineTo(69.496864F, 35.860706F);
      ((Path)localObject).lineTo(61.106693F, 35.860706F);
      ((Path)localObject).lineTo(61.106693F, 31.278585F);
      ((Path)localObject).lineTo(70.0F, 31.278585F);
      ((Path)localObject).lineTo(70.0F, 28.0F);
      ((Path)localObject).lineTo(57.0F, 28.0F);
      ((Path)localObject).lineTo(57.0F, 47.0F);
      ((Path)localObject).lineTo(70.0F, 47.0F);
      ((Path)localObject).lineTo(70.0F, 43.708248F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(84.433929F, 34.017326F);
      ((Path)localObject).lineTo(84.552856F, 34.017326F);
      ((Path)localObject).lineTo(88.173363F, 47.0F);
      ((Path)localObject).lineTo(91.939217F, 47.0F);
      ((Path)localObject).lineTo(97.0F, 28.0F);
      ((Path)localObject).lineTo(92.864166F, 28.0F);
      ((Path)localObject).lineTo(89.851479F, 41.759529F);
      ((Path)localObject).lineTo(89.745773F, 41.759529F);
      ((Path)localObject).lineTo(86.178116F, 28.0F);
      ((Path)localObject).lineTo(82.80867F, 28.0F);
      ((Path)localObject).lineTo(79.241013F, 41.759529F);
      ((Path)localObject).lineTo(79.135307F, 41.759529F);
      ((Path)localObject).lineTo(76.135834F, 28.0F);
      ((Path)localObject).lineTo(72.0F, 28.0F);
      ((Path)localObject).lineTo(77.047569F, 47.0F);
      ((Path)localObject).lineTo(80.813423F, 47.0F);
      ((Path)localObject).lineTo(84.433929F, 34.017326F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 51, 4);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ix
 * JD-Core Version:    0.7.0.1
 */