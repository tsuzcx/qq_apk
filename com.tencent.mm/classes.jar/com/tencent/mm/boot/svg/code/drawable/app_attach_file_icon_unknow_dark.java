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
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(24.0F, 30.933332F);
      ((Path)localObject3).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject3).lineTo(1.066667F, 32.0F);
      ((Path)localObject3).cubicTo(0.4775629F, 32.0F, 2.165061E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject3).lineTo(0.0F, 1.066667F);
      ((Path)localObject3).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 1.082166E-016F, 1.066667F, 0.0F);
      ((Path)localObject3).lineTo(16.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 8.0F);
      ((Path)localObject3).lineTo(24.0F, 30.933332F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(218103807);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(24.0F, 30.933332F);
      ((Path)localObject3).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject3).lineTo(1.066667F, 32.0F);
      ((Path)localObject3).cubicTo(0.4775629F, 32.0F, 2.165061E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject3).lineTo(0.0F, 1.066667F);
      ((Path)localObject3).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 1.082166E-016F, 1.066667F, 0.0F);
      ((Path)localObject3).lineTo(16.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 8.0F);
      ((Path)localObject3).lineTo(24.0F, 30.933332F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject3 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.431628F, 21.560656F);
      ((Path)localObject2).lineTo(12.431628F, 21.098907F);
      ((Path)localObject2).cubicTo(12.431628F, 20.353006F, 12.699535F, 19.955191F, 13.644651F, 19.422405F);
      ((Path)localObject2).cubicTo(14.597209F, 18.87541F, 15.2F, 18.086885F, 15.2F, 16.971584F);
      ((Path)localObject2).cubicTo(15.2F, 15.508197F, 13.92F, 14.4F, 12.044651F, 14.4F);
      ((Path)localObject2).cubicTo(9.953488F, 14.4F, 8.881861F, 15.621858F, 8.8F, 17.156284F);
      ((Path)localObject2).lineTo(10.072558F, 17.156284F);
      ((Path)localObject2).cubicTo(10.154419F, 16.140438F, 10.868837F, 15.508197F, 11.992558F, 15.508197F);
      ((Path)localObject2).cubicTo(13.101396F, 15.508197F, 13.815814F, 16.154644F, 13.815814F, 17.035519F);
      ((Path)localObject2).cubicTo(13.815814F, 17.795628F, 13.48093F, 18.24317F, 12.617675F, 18.747541F);
      ((Path)localObject2).cubicTo(11.59814F, 19.330055F, 11.121861F, 19.969398F, 11.129302F, 20.907104F);
      ((Path)localObject2).lineTo(11.129302F, 21.560656F);
      ((Path)localObject2).lineTo(12.431628F, 21.560656F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.784186F, 24.799999F);
      ((Path)localObject2).cubicTo(12.267907F, 24.799999F, 12.632558F, 24.444809F, 12.632558F, 23.990164F);
      ((Path)localObject2).cubicTo(12.632558F, 23.528416F, 12.267907F, 23.180328F, 11.784186F, 23.180328F);
      ((Path)localObject2).cubicTo(11.307907F, 23.180328F, 10.935814F, 23.528416F, 10.935814F, 23.990164F);
      ((Path)localObject2).cubicTo(10.935814F, 24.444809F, 11.307907F, 24.799999F, 11.784186F, 24.799999F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 8.0F);
      ((Path)localObject1).lineTo(17.066668F, 8.0F);
      ((Path)localObject1).cubicTo(16.477562F, 8.0F, 16.0F, 7.522437F, 16.0F, 6.933333F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 8.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_unknow_dark
 * JD-Core Version:    0.7.0.1
 */