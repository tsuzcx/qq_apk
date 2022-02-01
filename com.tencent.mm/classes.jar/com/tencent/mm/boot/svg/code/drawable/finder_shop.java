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

public class finder_shop
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-40634);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(22.300501F, -1.136868E-013F);
      ((Path)localObject3).cubicTo(27.31221F, -1.136868E-013F, 31.6005F, 4.371098F, 31.6005F, 9.21F);
      ((Path)localObject3).lineTo(31.6005F, 9.21F);
      ((Path)localObject3).lineTo(31.6F, 14.997F);
      ((Path)localObject3).lineTo(39.111F, 14.997F);
      ((Path)localObject3).cubicTo(40.633446F, 14.997F, 41.905518F, 16.137575F, 42.088737F, 17.633821F);
      ((Path)localObject3).lineTo(42.105F, 17.808001F);
      ((Path)localObject3).lineTo(42.863998F, 29.707001F);
      ((Path)localObject3).lineTo(42.855F, 29.697599F);
      ((Path)localObject3).cubicTo(26.95956F, 32.109241F, 14.824763F, 43.750481F, 14.583657F, 57.769073F);
      ((Path)localObject3).lineTo(14.58F, 58.194599F);
      ((Path)localObject3).cubicTo(14.58F, 58.641243F, 14.598532F, 59.110126F, 14.631631F, 59.613136F);
      ((Path)localObject3).lineTo(14.659125F, 59.996983F);
      ((Path)localObject3).lineTo(15.648098F, 59.997887F);
      ((Path)localObject3).lineTo(3.0F, 59.997002F);
      ((Path)localObject3).cubicTo(1.341F, 59.997002F, -5.513812E-012F, 58.655998F, -5.513812E-012F, 56.997002F);
      ((Path)localObject3).lineTo(0.00075F, 56.9025F);
      ((Path)localObject3).lineTo(0.00075F, 56.9025F);
      ((Path)localObject3).lineTo(0.006F, 56.807999F);
      ((Path)localObject3).lineTo(2.496F, 17.808001F);
      ((Path)localObject3).cubicTo(2.594222F, 16.285555F, 3.813547F, 15.088593F, 5.315492F, 15.002017F);
      ((Path)localObject3).lineTo(5.49F, 14.997F);
      ((Path)localObject3).lineTo(13.0F, 14.997F);
      ((Path)localObject3).lineTo(13.0005F, 9.21F);
      ((Path)localObject3).cubicTo(13.0005F, 4.455991F, 17.139643F, 0.1535159F, 22.037413F, 0.004015025F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(43.206158F, 35.067459F);
      ((Path)localObject3).lineTo(44.595001F, 56.807999F);
      ((Path)localObject3).cubicTo(44.700001F, 58.458F, 43.445999F, 59.886002F, 41.796001F, 59.991001F);
      ((Path)localObject3).lineTo(41.698502F, 59.99625F);
      ((Path)localObject3).lineTo(41.698502F, 59.99625F);
      ((Path)localObject3).lineTo(41.601002F, 59.997002F);
      ((Path)localObject3).lineTo(15.648098F, 59.997887F);
      ((Path)localObject3).cubicTo(17.094872F, 47.371365F, 28.654066F, 37.223835F, 43.206158F, 35.067459F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(22.300501F, 3.6F);
      ((Path)localObject3).cubicTo(19.292589F, 3.6F, 16.6005F, 6.344074F, 16.6005F, 9.21F);
      ((Path)localObject3).lineTo(16.6005F, 9.21F);
      ((Path)localObject3).lineTo(16.6F, 14.997F);
      ((Path)localObject3).lineTo(28.0F, 14.997F);
      ((Path)localObject3).lineTo(28.0005F, 9.21F);
      ((Path)localObject3).cubicTo(28.0005F, 6.410724F, 25.432169F, 3.727697F, 22.509811F, 3.604419F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(58.186501F, 28.569901F);
      ((Path)localObject2).lineTo(58.273499F, 28.5429F);
      ((Path)localObject2).cubicTo(59.0145F, 28.3209F, 59.497501F, 27.714899F, 59.497501F, 26.9979F);
      ((Path)localObject2).cubicTo(59.497501F, 26.2749F, 59.0145F, 25.6689F, 58.282501F, 25.4529F);
      ((Path)localObject2).lineTo(58.186501F, 25.422899F);
      ((Path)localObject2).cubicTo(54.070499F, 24.297899F, 53.671501F, 20.343901F, 53.629501F, 19.5189F);
      ((Path)localObject2).cubicTo(53.5755F, 18.651899F, 52.873501F, 17.9979F, 51.997501F, 17.9979F);
      ((Path)localObject2).cubicTo(51.121498F, 17.9979F, 50.419498F, 18.651899F, 50.362499F, 19.5609F);
      ((Path)localObject2).cubicTo(50.3265F, 20.343901F, 49.927502F, 24.297899F, 45.8325F, 25.416901F);
      ((Path)localObject2).lineTo(45.727501F, 25.446899F);
      ((Path)localObject2).cubicTo(44.980499F, 25.6689F, 44.5005F, 26.2749F, 44.5005F, 26.9979F);
      ((Path)localObject2).cubicTo(44.5005F, 27.714899F, 44.980499F, 28.3209F, 45.7425F, 28.548901F);
      ((Path)localObject2).lineTo(45.808498F, 28.569901F);
      ((Path)localObject2).cubicTo(49.927502F, 29.694901F, 50.3265F, 33.648899F, 50.365501F, 34.470901F);
      ((Path)localObject2).cubicTo(50.419498F, 35.3409F, 51.121498F, 35.997898F, 51.997501F, 35.997898F);
      ((Path)localObject2).cubicTo(52.873501F, 35.997898F, 53.5755F, 35.3409F, 53.6325F, 34.4319F);
      ((Path)localObject2).cubicTo(53.671501F, 33.648899F, 54.070499F, 29.694901F, 58.186501F, 28.569901F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_shop
 * JD-Core Version:    0.7.0.1
 */