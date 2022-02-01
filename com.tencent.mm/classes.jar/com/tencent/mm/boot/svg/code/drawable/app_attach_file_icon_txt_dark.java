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

public class app_attach_file_icon_txt_dark
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      Object localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(105.0F, 116.0F);
      ((Path)localObject4).cubicTo(105.0F, 118.20914F, 103.20914F, 120.0F, 101.0F, 120.0F);
      ((Path)localObject4).lineTo(19.0F, 120.0F);
      ((Path)localObject4).cubicTo(16.790861F, 120.0F, 15.0F, 118.20914F, 15.0F, 116.0F);
      ((Path)localObject4).lineTo(15.0F, 4.0F);
      ((Path)localObject4).cubicTo(15.0F, 1.790861F, 16.790861F, 1.293991E-015F, 19.0F, 0.0F);
      ((Path)localObject4).lineTo(75.0F, 0.0F);
      ((Path)localObject4).lineTo(105.0F, 30.0F);
      ((Path)localObject4).lineTo(105.0F, 116.0F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject3);
      localCanvas.restore();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(218103807);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(105.0F, 116.0F);
      ((Path)localObject4).cubicTo(105.0F, 118.20914F, 103.20914F, 120.0F, 101.0F, 120.0F);
      ((Path)localObject4).lineTo(19.0F, 120.0F);
      ((Path)localObject4).cubicTo(16.790861F, 120.0F, 15.0F, 118.20914F, 15.0F, 116.0F);
      ((Path)localObject4).lineTo(15.0F, 4.0F);
      ((Path)localObject4).cubicTo(15.0F, 1.790861F, 16.790861F, 1.293991E-015F, 19.0F, 0.0F);
      ((Path)localObject4).lineTo(75.0F, 0.0F);
      ((Path)localObject4).lineTo(105.0F, 30.0F);
      ((Path)localObject4).lineTo(105.0F, 116.0F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject3);
      localCanvas.restore();
      localObject4 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject4).setColor(-1);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(105.0F, 30.0F);
      ((Path)localObject3).lineTo(79.0F, 30.0F);
      ((Path)localObject3).cubicTo(76.790863F, 30.0F, 75.0F, 28.209139F, 75.0F, 26.0F);
      ((Path)localObject3).lineTo(75.0F, 0.0F);
      ((Path)localObject3).lineTo(75.0F, 0.0F);
      ((Path)localObject3).lineTo(105.0F, 30.0F);
      ((Path)localObject3).close();
      localCanvas.saveLayerAlpha(null, 25, 31);
      localObject4 = c.instancePaint((Paint)localObject4, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 30.200001F, 0.0F, 1.0F, 56.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.799999F, 0.100001F);
      ((Path)localObject2).lineTo(58.399998F, 0.100001F);
      ((Path)localObject2).lineTo(58.399998F, 4.100001F);
      ((Path)localObject2).lineTo(0.799999F, 4.100001F);
      ((Path)localObject2).lineTo(0.799999F, 0.100001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.8F, 15.410001F);
      ((Path)localObject2).lineTo(58.399998F, 15.410001F);
      ((Path)localObject2).lineTo(58.399998F, 19.41F);
      ((Path)localObject2).lineTo(0.8F, 19.41F);
      ((Path)localObject2).lineTo(0.8F, 15.410001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.8F, 30.720001F);
      ((Path)localObject2).lineTo(32.799999F, 30.720001F);
      ((Path)localObject2).lineTo(32.799999F, 34.720001F);
      ((Path)localObject2).lineTo(0.8F, 34.720001F);
      ((Path)localObject2).lineTo(0.8F, 30.720001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_txt_dark
 * JD-Core Version:    0.7.0.1
 */