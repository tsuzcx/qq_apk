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

public class sos_history
  extends c
{
  private final int height = 42;
  private final int width = 42;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 42;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-4210753);
      localPaint2.setColor(-4210753);
      localPaint2.setStrokeWidth(1.2F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(20.065081F, 39.519398F);
      localPath.cubicTo(9.131414F, 39.519398F, 0.3604506F, 30.628284F, 0.3604506F, 19.814768F);
      localPath.cubicTo(0.3604506F, 8.881102F, 9.251564F, 0.1101377F, 20.065081F, 0.1101377F);
      localPath.cubicTo(30.998749F, 0.1101377F, 39.769711F, 9.001251F, 39.769711F, 19.814768F);
      localPath.cubicTo(39.769711F, 30.628284F, 30.998749F, 39.519398F, 20.065081F, 39.519398F);
      localPath.close();
      localPath.moveTo(20.065081F, 1.191489F);
      localPath.cubicTo(9.852315F, 1.191489F, 1.561953F, 9.481853F, 1.561953F, 19.694618F);
      localPath.cubicTo(1.561953F, 29.907385F, 9.852315F, 38.197746F, 20.065081F, 38.197746F);
      localPath.cubicTo(30.277847F, 38.197746F, 38.568211F, 29.907385F, 38.568211F, 19.694618F);
      localPath.cubicTo(38.568211F, 9.481853F, 30.277847F, 1.191489F, 20.065081F, 1.191489F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(25.832291F, 27.26408F);
      ((Path)localObject1).cubicTo(25.712141F, 27.26408F, 25.47184F, 27.14393F, 25.35169F, 27.023779F);
      ((Path)localObject1).lineTo(19.58448F, 20.055069F);
      ((Path)localObject1).cubicTo(19.464331F, 19.934919F, 19.464331F, 19.814768F, 19.464331F, 19.694618F);
      ((Path)localObject1).lineTo(19.464331F, 8.1602F);
      ((Path)localObject1).cubicTo(19.464331F, 7.79975F, 19.70463F, 7.559449F, 20.065081F, 7.559449F);
      ((Path)localObject1).cubicTo(20.425531F, 7.559449F, 20.665833F, 7.79975F, 20.665833F, 8.1602F);
      ((Path)localObject1).lineTo(20.665833F, 19.454317F);
      ((Path)localObject1).lineTo(26.312891F, 26.182728F);
      ((Path)localObject1).cubicTo(26.553192F, 26.423029F, 26.433041F, 26.78348F, 26.192741F, 27.023779F);
      ((Path)localObject1).cubicTo(26.07259F, 27.26408F, 25.95244F, 27.26408F, 25.832291F, 27.26408F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sos_history
 * JD-Core Version:    0.7.0.1
 */