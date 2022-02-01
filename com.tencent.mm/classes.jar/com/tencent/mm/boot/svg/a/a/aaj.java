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

public final class aaj
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-14776843);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(5.454546F, 18.595238F);
      ((Path)localObject2).cubicTo(5.454546F, 18.319096F, 5.678403F, 18.095238F, 5.954546F, 18.095238F);
      ((Path)localObject2).lineTo(14.045454F, 18.095238F);
      ((Path)localObject2).cubicTo(14.321596F, 18.095238F, 14.545454F, 18.319096F, 14.545454F, 18.595238F);
      ((Path)localObject2).lineTo(14.545454F, 18.595238F);
      ((Path)localObject2).cubicTo(14.545454F, 18.87138F, 14.321596F, 19.095238F, 14.045454F, 19.095238F);
      ((Path)localObject2).lineTo(5.954546F, 19.095238F);
      ((Path)localObject2).cubicTo(5.678403F, 19.095238F, 5.454546F, 18.87138F, 5.454546F, 18.595238F);
      ((Path)localObject2).lineTo(5.454546F, 18.595238F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 9.047619F);
      ((Path)localObject2).lineTo(20.0F, 9.047619F);
      ((Path)localObject2).lineTo(20.0F, 9.047619F);
      ((Path)localObject2).cubicTo(20.0F, 10.046991F, 19.189848F, 10.857142F, 18.190475F, 10.857142F);
      ((Path)localObject2).lineTo(1.809524F, 10.857142F);
      ((Path)localObject2).cubicTo(0.810151F, 10.857142F, 1.223878E-016F, 10.046991F, 0.0F, 9.047619F);
      ((Path)localObject2).lineTo(0.0F, 9.047619F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(9.545455F, 10.0F);
      ((Path)localObject2).cubicTo(9.545455F, 9.723858F, 9.769313F, 9.5F, 10.045455F, 9.5F);
      ((Path)localObject2).lineTo(10.045455F, 9.5F);
      ((Path)localObject2).cubicTo(10.321597F, 9.5F, 10.545455F, 9.723858F, 10.545455F, 10.0F);
      ((Path)localObject2).lineTo(10.545455F, 18.047619F);
      ((Path)localObject2).cubicTo(10.545455F, 18.323761F, 10.321597F, 18.547619F, 10.045455F, 18.547619F);
      ((Path)localObject2).lineTo(10.045455F, 18.547619F);
      ((Path)localObject2).cubicTo(9.769313F, 18.547619F, 9.545455F, 18.323761F, 9.545455F, 18.047619F);
      ((Path)localObject2).lineTo(9.545455F, 10.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(3.285227F, 0.0F);
      ((Path)localObject1).lineTo(16.449621F, 4.440892E-016F);
      ((Path)localObject1).cubicTo(16.883898F, -4.071179E-016F, 17.257532F, 0.3071576F, 17.341541F, 0.733232F);
      ((Path)localObject1).lineTo(18.825758F, 8.26087F);
      ((Path)localObject1).lineTo(0.9090909F, 8.26087F);
      ((Path)localObject1).lineTo(2.393308F, 0.733232F);
      ((Path)localObject1).cubicTo(2.477317F, 0.3071576F, 2.85095F, -5.863584E-016F, 3.285227F, -6.661338E-016F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(6.248911F, 6.273419F);
      ((Path)localObject1).lineTo(8.430138F, 4.238125F);
      ((Path)localObject1).lineTo(10.421082F, 5.569347F);
      ((Path)localObject1).cubicTo(10.574615F, 5.668606F, 10.776917F, 5.649011F, 10.903219F, 5.522523F);
      ((Path)localObject1).lineTo(13.67641F, 2.520652F);
      ((Path)localObject1).lineTo(13.129231F, 1.989439F);
      ((Path)localObject1).lineTo(10.571503F, 4.773793F);
      ((Path)localObject1).lineTo(8.613288F, 3.442511F);
      ((Path)localObject1).cubicTo(8.47233F, 3.343225F, 8.279788F, 3.362861F, 8.151994F, 3.489426F);
      ((Path)localObject1).lineTo(5.749195F, 5.742391F);
      ((Path)localObject1).lineTo(6.248911F, 6.273419F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aaj
 * JD-Core Version:    0.7.0.1
 */