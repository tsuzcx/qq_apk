package com.tencent.mm.boot.svg.code.drawable;

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

public class icons_outlined_exchange
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      ((Canvas)localObject1).save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      localPaint = c.instancePaint((Paint)localObject3, paramVarArgs);
      localPaint.setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(9.5F, 0.0F);
      localPath.cubicTo(11.709139F, 0.0F, 13.5F, 1.79298F, 13.5F, 4.000207F);
      localPath.lineTo(13.5F, 5.710186F);
      localPath.cubicTo(13.5F, 6.849296F, 12.900932F, 8.482861F, 12.168087F, 9.351573F);
      localPath.lineTo(11.806555F, 9.780132F);
      localPath.cubicTo(11.217032F, 10.478951F, 11.401188F, 11.368398F, 12.225549F, 11.770511F);
      localPath.lineTo(12.298645F, 11.806463F);
      localPath.cubicTo(12.120915F, 12.164769F, 11.986195F, 12.54712F, 11.899969F, 12.947231F);
      localPath.lineTo(11.699456F, 12.84904F);
      localPath.cubicTo(10.172874F, 12.104393F, 9.795573F, 10.302913F, 10.889337F, 9.006369F);
      localPath.lineTo(11.250869F, 8.577808F);
      localPath.cubicTo(11.802195F, 7.924269F, 12.3F, 6.564391F, 12.3F, 5.710186F);
      localPath.lineTo(12.3F, 4.000207F);
      localPath.cubicTo(12.3F, 2.454914F, 11.045589F, 1.2F, 9.5F, 1.2F);
      localPath.cubicTo(7.956309F, 1.2F, 6.7F, 2.455203F, 6.7F, 3.99958F);
      localPath.lineTo(6.7F, 5.709291F);
      localPath.cubicTo(6.7F, 6.565664F, 7.195747F, 7.920484F, 7.749078F, 8.576312F);
      localPath.lineTo(8.110611F, 9.004812F);
      localPath.cubicTo(9.206636F, 10.30386F, 8.825214F, 12.10365F, 7.300719F, 12.847587F);
      localPath.lineTo(1.640366F, 15.609776F);
      localPath.cubicTo(1.437017F, 15.709009F, 1.2F, 16.088676F, 1.2F, 16.315464F);
      localPath.lineTo(1.2F, 16.799999F);
      localPath.lineTo(12.078F, 16.799999F);
      localPath.lineTo(12.078F, 18.0F);
      localPath.lineTo(1.00143F, 18.0F);
      localPath.cubicTo(0.4483553F, 18.0F, 0.0F, 17.555756F, 0.0F, 17.001562F);
      localPath.lineTo(0.0F, 16.315464F);
      localPath.cubicTo(0.0F, 15.630374F, 0.4981509F, 14.831908F, 1.114098F, 14.531333F);
      localPath.lineTo(6.774451F, 11.769143F);
      localPath.cubicTo(7.595377F, 11.36854F, 7.786259F, 10.481262F, 7.193445F, 9.778639F);
      localPath.lineTo(6.831913F, 9.350138F);
      localPath.cubicTo(6.096318F, 8.478285F, 5.5F, 6.849496F, 5.5F, 5.709291F);
      localPath.lineTo(5.5F, 3.99958F);
      localPath.cubicTo(5.5F, 1.790673F, 7.295356F, 0.0F, 9.5F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      ((Canvas)localObject1).drawPath(localPath, localPaint);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 13.0F, 0.0F, 1.0F, 10.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      localPaint = c.instancePaint((Paint)localObject3, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.0F, 4.174439E-014F);
      localPath.cubicTo(5.400294F, 4.174439E-014F, 6.673539F, 0.7345721F, 7.384049F, 1.911514F);
      localPath.lineTo(6.373698F, 2.46305F);
      localPath.cubicTo(5.925334F, 1.6236F, 5.00398F, 1.1F, 4.0F, 1.1F);
      localPath.cubicTo(2.446185F, 1.1F, 1.182794F, 2.353894F, 1.150628F, 3.9F);
      localPath.cubicTo(1.150628F, 3.9F, 0.7670854F, 3.9F, 5.284662E-014F, 3.9F);
      localPath.cubicTo(0.05F, 1.768475F, 1.818475F, 4.174439E-014F, 4.0F, 4.174439E-014F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      ((Canvas)localObject1).drawPath(localPath, localPaint);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).save();
      localPaint = c.instancePaint((Paint)localObject3, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(7.949F, 3.998F);
      localPath.lineTo(7.95F, 3.95F);
      localPath.cubicTo(7.95F, 6.131525F, 6.181525F, 7.9F, 4.0F, 7.9F);
      localPath.cubicTo(2.666726F, 7.9F, 1.446397F, 7.234477F, 0.7173638F, 6.147746F);
      localPath.lineTo(1.700229F, 5.5486F);
      localPath.cubicTo(2.161545F, 6.326009F, 3.0441F, 6.8F, 4.0F, 6.8F);
      localPath.cubicTo(5.559237F, 6.8F, 6.82602F, 5.55161F, 6.849664F, 3.998F);
      localPath.cubicTo(6.849664F, 4.000505F, 7.216109F, 4.000505F, 7.949F, 3.998F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      ((Canvas)localObject1).drawPath(localPath, localPaint);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).save();
      localPaint = c.instancePaint((Paint)localObject3, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -6.123234E-017F, -1.0F, 7.730032F, -1.0F, 6.123234E-017F, 7.730032F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.629344F, 0.0753438F);
      ((Path)localObject2).lineTo(7.629344F, 0.9753438F);
      ((Path)localObject2).lineTo(5.980031F, 0.9753438F);
      ((Path)localObject2).lineTo(5.844676F, 1.089988F);
      ((Path)localObject2).lineTo(5.844676F, 2.825344F);
      ((Path)localObject2).lineTo(4.930031F, 2.825344F);
      ((Path)localObject2).lineTo(4.930031F, 0.4253438F);
      ((Path)localObject2).lineTo(4.937906F, 0.349745F);
      ((Path)localObject2).cubicTo(4.970197F, 0.1932207F, 5.113031F, 0.0753438F, 5.280031F, 0.0753438F);
      ((Path)localObject2).lineTo(7.629344F, 0.0753438F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      ((Canvas)localObject1).drawPath((Path)localObject2, localPaint);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(3.051F, 5.099F);
      ((Path)localObject3).lineTo(3.051611F, 6.05F);
      ((Path)localObject3).lineTo(1.401611F, 6.05F);
      ((Path)localObject3).lineTo(1.266256F, 6.114645F);
      ((Path)localObject3).lineTo(1.266256F, 7.85F);
      ((Path)localObject3).lineTo(0.3516113F, 7.85F);
      ((Path)localObject3).lineTo(0.3516113F, 5.450021F);
      ((Path)localObject3).lineTo(0.3594858F, 5.374401F);
      ((Path)localObject3).cubicTo(0.3917773F, 5.217877F, 0.5346111F, 5.099F, 0.7016113F, 5.099F);
      ((Path)localObject3).lineTo(3.051F, 5.099F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      ((Canvas)localObject1).drawPath((Path)localObject3, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 24.0F);
      ((Path)localObject1).lineTo(0.0F, 24.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_exchange
 * JD-Core Version:    0.7.0.1
 */