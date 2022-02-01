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

public class voip_videocall_to
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 0.0F, 72.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 66.650795F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.814285F, 31.066668F);
      localPath.lineTo(50.83651F, 31.066668F);
      localPath.lineTo(50.83651F, 3.6F);
      localPath.lineTo(15.814285F, 3.6F);
      localPath.lineTo(15.814285F, 31.066668F);
      localPath.close();
      localPath.moveTo(14.401286F, 2.220446E-016F);
      localPath.lineTo(52.249508F, -1.110223E-016F);
      localPath.cubicTo(53.457355F, -3.329002E-016F, 54.436508F, 0.9791533F, 54.436508F, 2.187F);
      localPath.lineTo(54.436508F, 32.479668F);
      localPath.cubicTo(54.436508F, 33.687515F, 53.457355F, 34.666668F, 52.249508F, 34.666668F);
      localPath.lineTo(14.401286F, 34.666668F);
      localPath.cubicTo(13.193439F, 34.666668F, 12.214286F, 33.687515F, 12.214286F, 32.479668F);
      localPath.lineTo(12.214286F, 2.187F);
      localPath.cubicTo(12.214286F, 0.9791533F, 13.193439F, 1.110056E-015F, 14.401286F, 2.220446E-016F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 15.079366F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(3.6F, 19.946148F);
      ((Path)localObject1).lineTo(11.479365F, 27.687836F);
      ((Path)localObject1).lineTo(11.479365F, 6.757824F);
      ((Path)localObject1).lineTo(3.6F, 14.499511F);
      ((Path)localObject1).lineTo(3.6F, 19.946148F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(0.0F, 12.989721F);
      ((Path)localObject1).lineTo(11.359612F, 1.8286F);
      ((Path)localObject1).cubicTo(12.221183F, 0.9820839F, 13.605861F, 0.994288F, 14.452377F, 1.855859F);
      ((Path)localObject1).cubicTo(14.854209F, 2.264837F, 15.079365F, 2.81526F, 15.079365F, 3.388612F);
      ((Path)localObject1).lineTo(15.079365F, 31.057047F);
      ((Path)localObject1).cubicTo(15.079365F, 32.264893F, 14.100212F, 33.244049F, 12.892365F, 33.244049F);
      ((Path)localObject1).cubicTo(12.319013F, 33.244049F, 11.768591F, 33.01889F, 11.359612F, 32.617058F);
      ((Path)localObject1).lineTo(0.0F, 21.455938F);
      ((Path)localObject1).lineTo(0.0F, 12.989721F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voip_videocall_to
 * JD-Core Version:    0.7.0.1
 */