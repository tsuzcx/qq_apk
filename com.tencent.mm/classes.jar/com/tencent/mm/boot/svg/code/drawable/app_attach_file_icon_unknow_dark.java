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

public class app_attach_file_icon_unknow_dark
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(90.0F, 116.0F);
      ((Path)localObject3).cubicTo(90.0F, 118.20914F, 88.209137F, 120.0F, 86.0F, 120.0F);
      ((Path)localObject3).lineTo(4.0F, 120.0F);
      ((Path)localObject3).cubicTo(1.790861F, 120.0F, 8.642385E-014F, 118.20914F, 8.526513E-014F, 116.0F);
      ((Path)localObject3).lineTo(8.526513E-014F, 4.0F);
      ((Path)localObject3).cubicTo(8.499459E-014F, 1.790861F, 1.790861F, 1.293991E-015F, 4.0F, 0.0F);
      ((Path)localObject3).lineTo(60.0F, 0.0F);
      ((Path)localObject3).lineTo(90.0F, 30.0F);
      ((Path)localObject3).lineTo(90.0F, 116.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(218103807);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(90.0F, 116.0F);
      ((Path)localObject3).cubicTo(90.0F, 118.20914F, 88.209137F, 120.0F, 86.0F, 120.0F);
      ((Path)localObject3).lineTo(4.0F, 120.0F);
      ((Path)localObject3).cubicTo(1.790861F, 120.0F, 8.642385E-014F, 118.20914F, 8.526513E-014F, 116.0F);
      ((Path)localObject3).lineTo(8.526513E-014F, 4.0F);
      ((Path)localObject3).cubicTo(8.499459E-014F, 1.790861F, 1.790861F, 1.293991E-015F, 4.0F, 0.0F);
      ((Path)localObject3).lineTo(60.0F, 0.0F);
      ((Path)localObject3).lineTo(90.0F, 30.0F);
      ((Path)localObject3).lineTo(90.0F, 116.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject3 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(46.618607F, 80.852463F);
      ((Path)localObject2).lineTo(46.618607F, 79.120903F);
      ((Path)localObject2).cubicTo(46.618607F, 76.323769F, 47.623257F, 74.83197F, 51.167442F, 72.834015F);
      ((Path)localObject2).cubicTo(54.739536F, 70.782784F, 57.0F, 67.825821F, 57.0F, 63.643444F);
      ((Path)localObject2).cubicTo(57.0F, 58.155739F, 52.200001F, 54.0F, 45.167442F, 54.0F);
      ((Path)localObject2).cubicTo(37.325581F, 54.0F, 33.306976F, 58.581966F, 33.0F, 64.336067F);
      ((Path)localObject2).lineTo(37.772095F, 64.336067F);
      ((Path)localObject2).cubicTo(38.079071F, 60.526638F, 40.758141F, 58.155739F, 44.972092F, 58.155739F);
      ((Path)localObject2).cubicTo(49.130234F, 58.155739F, 51.809303F, 60.579918F, 51.809303F, 63.883198F);
      ((Path)localObject2).cubicTo(51.809303F, 66.733604F, 50.55349F, 68.411888F, 47.31628F, 70.303276F);
      ((Path)localObject2).cubicTo(43.493023F, 72.487701F, 41.706978F, 74.885246F, 41.734882F, 78.401642F);
      ((Path)localObject2).lineTo(41.734882F, 80.852463F);
      ((Path)localObject2).lineTo(46.618607F, 80.852463F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(44.190697F, 93.0F);
      ((Path)localObject2).cubicTo(46.00465F, 93.0F, 47.372093F, 91.66803F, 47.372093F, 89.963112F);
      ((Path)localObject2).cubicTo(47.372093F, 88.23156F, 46.00465F, 86.926231F, 44.190697F, 86.926231F);
      ((Path)localObject2).cubicTo(42.404652F, 86.926231F, 41.009304F, 88.23156F, 41.009304F, 89.963112F);
      ((Path)localObject2).cubicTo(41.009304F, 91.66803F, 42.404652F, 93.0F, 44.190697F, 93.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(90.0F, 30.0F);
      ((Path)localObject1).lineTo(64.0F, 30.0F);
      ((Path)localObject1).cubicTo(61.790859F, 30.0F, 60.0F, 28.209139F, 60.0F, 26.0F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(90.0F, 30.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 25, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_unknow_dark
 * JD-Core Version:    0.7.0.1
 */