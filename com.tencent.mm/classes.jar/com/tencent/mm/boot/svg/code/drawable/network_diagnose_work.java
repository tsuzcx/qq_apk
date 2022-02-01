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

public class network_diagnose_work
  extends c
{
  private final int height = 271;
  private final int width = 152;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 152;
      return 271;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 1.333333F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject4 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject4).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(4.0F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(2.0F, 16.0F);
      localPath.cubicTo(2.0F, 8.268013F, 8.268013F, 2.0F, 16.0F, 2.0F);
      localPath.lineTo(133.33333F, 2.0F);
      localPath.cubicTo(141.06531F, 2.0F, 147.33333F, 8.268013F, 147.33333F, 16.0F);
      localPath.lineTo(147.33333F, 250.66666F);
      localPath.cubicTo(147.33333F, 258.39865F, 141.06531F, 264.66666F, 133.33333F, 264.66666F);
      localPath.lineTo(16.0F, 264.66666F);
      localPath.cubicTo(8.268013F, 264.66666F, 2.0F, 258.39865F, 2.0F, 250.66666F);
      localPath.lineTo(2.0F, 16.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(2.0F);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(11.666667F, 29.0F);
      ((Path)localObject4).lineTo(11.666667F, 232.33333F);
      ((Path)localObject4).lineTo(137.66667F, 232.33333F);
      ((Path)localObject4).lineTo(137.66667F, 29.0F);
      ((Path)localObject4).lineTo(11.666667F, 29.0F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(65.333336F, 13.333333F);
      ((Path)localObject4).lineTo(85.333336F, 13.333333F);
      ((Path)localObject4).lineTo(85.333336F, 17.333332F);
      ((Path)localObject4).lineTo(65.333336F, 17.333332F);
      ((Path)localObject4).lineTo(65.333336F, 13.333333F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-15028967);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 38.0F, 0.0F, 1.0F, 90.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(74.558861F, 18.441139F);
      ((Path)localObject3).lineTo(73.350342F, 19.649662F);
      ((Path)localObject3).lineTo(38.0F, 55.0F);
      ((Path)localObject3).lineTo(2.649662F, 19.649662F);
      ((Path)localObject3).lineTo(1.441139F, 18.441139F);
      ((Path)localObject3).lineTo(0.2326156F, 17.232616F);
      ((Path)localObject3).cubicTo(9.399959F, 6.675522F, 22.920404F, 0.0F, 38.0F, 0.0F);
      ((Path)localObject3).cubicTo(53.079597F, 0.0F, 66.600044F, 6.675522F, 75.767387F, 17.232616F);
      ((Path)localObject3).lineTo(74.558861F, 18.441139F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(73.350342F, 19.649662F);
      ((Path)localObject3).cubicTo(64.805794F, 9.706631F, 52.138332F, 3.409091F, 38.0F, 3.409091F);
      ((Path)localObject3).cubicTo(23.861668F, 3.409091F, 11.194205F, 9.706631F, 2.649662F, 19.649662F);
      ((Path)localObject3).lineTo(38.0F, 55.0F);
      ((Path)localObject3).lineTo(73.350342F, 19.649662F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(64.412086F, 28.587917F);
      ((Path)localObject3).lineTo(38.0F, 55.0F);
      ((Path)localObject3).lineTo(11.587917F, 28.587917F);
      ((Path)localObject3).cubicTo(17.821682F, 20.907948F, 27.337685F, 16.0F, 38.0F, 16.0F);
      ((Path)localObject3).cubicTo(48.662315F, 16.0F, 58.178318F, 20.907948F, 64.412086F, 28.587917F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(61.952404F, 31.047596F);
      ((Path)localObject3).cubicTo(56.358055F, 23.986908F, 47.707962F, 19.457626F, 38.0F, 19.457626F);
      ((Path)localObject3).cubicTo(28.292036F, 19.457626F, 19.641943F, 23.986908F, 14.047595F, 31.047596F);
      ((Path)localObject3).lineTo(38.0F, 55.0F);
      ((Path)localObject3).lineTo(61.952404F, 31.047596F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(24.464458F, 41.464458F);
      ((Path)localObject3).cubicTo(27.298983F, 36.978931F, 32.301609F, 34.0F, 38.0F, 34.0F);
      ((Path)localObject3).cubicTo(43.698391F, 34.0F, 48.701015F, 36.978931F, 51.535542F, 41.464458F);
      ((Path)localObject3).lineTo(38.0F, 55.0F);
      ((Path)localObject3).lineTo(24.464458F, 41.464458F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(26.967703F, 43.967701F);
      ((Path)localObject3).lineTo(38.0F, 55.0F);
      ((Path)localObject3).lineTo(49.032299F, 43.967701F);
      ((Path)localObject3).cubicTo(46.896992F, 40.070786F, 42.757057F, 37.42857F, 38.0F, 37.42857F);
      ((Path)localObject3).cubicTo(33.242943F, 37.42857F, 29.103008F, 40.070786F, 26.967703F, 43.967701F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(41.284134F, 51.715866F);
      ((Path)localObject2).lineTo(38.0F, 55.0F);
      ((Path)localObject2).lineTo(34.715866F, 51.715866F);
      ((Path)localObject2).cubicTo(35.438572F, 50.678699F, 36.640026F, 50.0F, 38.0F, 50.0F);
      ((Path)localObject2).cubicTo(39.359974F, 50.0F, 40.561428F, 50.678699F, 41.284134F, 51.715866F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.network_diagnose_work
 * JD-Core Version:    0.7.0.1
 */