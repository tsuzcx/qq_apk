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

public class mall_index_offline_icon_normal
  extends c
{
  private final int height = 93;
  private final int width = 93;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 93;
      return 93;
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 11.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(5.217392F, 0.0F);
      ((Path)localObject3).cubicTo(2.270083F, 0.0F, -7.105427E-015F, 2.426357F, -7.105427E-015F, 5.217392F);
      ((Path)localObject3).lineTo(-7.105427E-015F, 65.217392F);
      ((Path)localObject3).cubicTo(-7.105427E-015F, 68.008423F, 2.270083F, 70.434784F, 5.217392F, 70.434784F);
      ((Path)localObject3).lineTo(86.08696F, 70.434784F);
      ((Path)localObject3).cubicTo(89.033127F, 70.434784F, 91.304344F, 68.008423F, 91.304344F, 65.217392F);
      ((Path)localObject3).lineTo(91.304344F, 5.217392F);
      ((Path)localObject3).cubicTo(91.304344F, 2.426357F, 89.033127F, 0.0F, 86.08696F, 0.0F);
      ((Path)localObject3).lineTo(5.217392F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(67.826088F, 6.521739F);
      ((Path)localObject3).lineTo(80.933716F, 6.521739F);
      ((Path)localObject3).cubicTo(82.835846F, 6.521739F, 84.782608F, 8.498771F, 84.782608F, 11.73913F);
      ((Path)localObject3).lineTo(84.782608F, 24.782608F);
      ((Path)localObject3).lineTo(91.304344F, 24.782608F);
      ((Path)localObject3).lineTo(91.304344F, 44.347828F);
      ((Path)localObject3).lineTo(84.782608F, 44.347828F);
      ((Path)localObject3).lineTo(84.782608F, 58.695652F);
      ((Path)localObject3).cubicTo(84.782608F, 61.936012F, 82.835846F, 63.913044F, 80.933716F, 63.913044F);
      ((Path)localObject3).lineTo(67.826088F, 63.913044F);
      ((Path)localObject3).lineTo(67.826088F, 70.434784F);
      ((Path)localObject3).lineTo(24.782608F, 70.434784F);
      ((Path)localObject3).lineTo(24.782608F, 63.913044F);
      ((Path)localObject3).lineTo(10.370634F, 63.913044F);
      ((Path)localObject3).cubicTo(8.467525F, 63.913044F, 6.521739F, 61.936012F, 6.521739F, 58.695652F);
      ((Path)localObject3).lineTo(6.521739F, 44.347828F);
      ((Path)localObject3).lineTo(7.105427E-015F, 44.347828F);
      ((Path)localObject3).lineTo(8.303451E-015F, 24.782608F);
      ((Path)localObject3).lineTo(6.521739F, 24.782608F);
      ((Path)localObject3).lineTo(6.521739F, 11.73913F);
      ((Path)localObject3).cubicTo(6.521739F, 8.498771F, 8.467525F, 6.521739F, 10.370634F, 6.521739F);
      ((Path)localObject3).lineTo(24.782608F, 6.521739F);
      ((Path)localObject3).lineTo(24.782608F, 0.0F);
      ((Path)localObject3).lineTo(67.826088F, 0.0F);
      ((Path)localObject3).lineTo(67.826088F, 6.521739F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(29.608696F, 34.347828F);
      ((Path)localObject2).lineTo(27.0F, 39.565216F);
      ((Path)localObject2).lineTo(38.739132F, 53.913044F);
      ((Path)localObject2).lineTo(64.826088F, 22.608696F);
      ((Path)localObject2).lineTo(62.217392F, 20.0F);
      ((Path)localObject2).lineTo(38.739132F, 42.173912F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.mall_index_offline_icon_normal
 * JD-Core Version:    0.7.0.1
 */