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

public class float_ball_icon_appbrand_default
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-855310);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.004295F, 12.990751F);
      ((Path)localObject2).lineTo(16.76837F, 12.994569F);
      ((Path)localObject2).cubicTo(16.055016F, 12.994569F, 15.639927F, 12.471272F, 15.908092F, 11.86796F);
      ((Path)localObject2).cubicTo(16.091732F, 11.439467F, 16.506041F, 11.108546F, 16.995338F, 10.999859F);
      ((Path)localObject2).cubicTo(18.304462F, 10.683864F, 19.19393F, 9.660716F, 19.19393F, 8.471246F);
      ((Path)localObject2).cubicTo(19.19393F, 7.029172F, 17.81712F, 5.853993F, 16.097445F, 5.853993F);
      ((Path)localObject2).cubicTo(14.377769F, 5.853993F, 13.000958F, 7.029172F, 13.000958F, 8.471246F);
      ((Path)localObject2).lineTo(13.000958F, 15.659744F);
      ((Path)localObject2).cubicTo(13.000958F, 18.191664F, 10.737898F, 20.230989F, 7.950479F, 20.230989F);
      ((Path)localObject2).cubicTo(5.163061F, 20.230989F, 2.9F, 18.191664F, 2.9F, 15.659744F);
      ((Path)localObject2).cubicTo(2.9F, 13.439664F, 4.652343F, 11.544662F, 7.039936F, 11.184345F);
      ((Path)localObject2).lineTo(7.231629F, 11.184345F);
      ((Path)localObject2).cubicTo(7.771693F, 11.184345F, 8.160703F, 11.507646F, 8.160703F, 11.969357F);
      ((Path)localObject2).cubicTo(8.160933F, 12.048471F, 8.159011F, 12.08503F, 8.1512F, 12.131896F);
      ((Path)localObject2).cubicTo(8.140671F, 12.195074F, 8.120168F, 12.255544F, 8.091908F, 12.310954F);
      ((Path)localObject2).cubicTo(7.919784F, 12.712574F, 7.479771F, 13.060287F, 7.004661F, 13.179055F);
      ((Path)localObject2).cubicTo(5.704997F, 13.492767F, 4.80607F, 14.509667F, 4.80607F, 15.659744F);
      ((Path)localObject2).cubicTo(4.80607F, 17.101818F, 6.182881F, 18.276997F, 7.902556F, 18.276997F);
      ((Path)localObject2).cubicTo(9.622231F, 18.276997F, 10.999042F, 17.101818F, 10.999042F, 15.659744F);
      ((Path)localObject2).lineTo(10.999042F, 8.471246F);
      ((Path)localObject2).cubicTo(10.999042F, 5.939327F, 13.262102F, 3.9F, 16.04952F, 3.9F);
      ((Path)localObject2).cubicTo(18.836939F, 3.9F, 21.1F, 5.939327F, 21.1F, 8.471246F);
      ((Path)localObject2).cubicTo(21.1F, 10.703113F, 19.388876F, 12.576041F, 17.004295F, 12.990751F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.float_ball_icon_appbrand_default
 * JD-Core Version:    0.7.0.1
 */