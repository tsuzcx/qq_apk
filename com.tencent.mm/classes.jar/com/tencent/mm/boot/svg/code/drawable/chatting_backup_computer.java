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

public class chatting_backup_computer
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 19.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-3487030);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 140.0274F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(63.00885F, 34.0F);
      ((Path)localObject1).lineTo(63.00885F, 57.0F);
      ((Path)localObject1).lineTo(77.018555F, 57.0F);
      ((Path)localObject1).lineTo(77.018555F, 34.0F);
      ((Path)localObject1).lineTo(63.00885F, 34.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(64.029297F, 35.0F);
      ((Path)localObject1).lineTo(64.029297F, 54.0F);
      ((Path)localObject1).lineTo(75.995789F, 53.908081F);
      ((Path)localObject1).lineTo(75.995789F, 35.0F);
      ((Path)localObject1).lineTo(64.029297F, 35.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-3487030);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(76.209976F, 34.0F);
      ((Path)localObject2).cubicTo(75.083252F, 33.443298F, 72.872185F, 33.079494F, 70.370979F, 33.011551F);
      ((Path)localObject2).cubicTo(70.089302F, 33.003899F, 69.803947F, 33.0F, 69.516045F, 33.0F);
      ((Path)localObject2).cubicTo(66.671654F, 33.0F, 64.059387F, 33.380604F, 62.796413F, 34.0F);
      ((Path)localObject2).lineTo(76.209976F, 34.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(75.825836F, 57.166668F);
      ((Path)localObject2).cubicTo(74.622093F, 57.628895F, 72.613113F, 57.927544F, 70.370979F, 57.988449F);
      ((Path)localObject2).cubicTo(70.089302F, 57.996101F, 69.803947F, 58.0F, 69.516045F, 58.0F);
      ((Path)localObject2).cubicTo(66.936455F, 58.0F, 64.547775F, 57.686962F, 63.183327F, 57.166668F);
      ((Path)localObject2).lineTo(75.825836F, 57.166668F);
      ((Path)localObject2).lineTo(75.825836F, 57.166668F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-12337128);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.011108F, 30.948933F);
      ((Path)localObject2).cubicTo(26.315693F, 34.585732F, 30.375906F, 37.0F, 35.0F, 37.0F);
      ((Path)localObject2).cubicTo(42.179703F, 37.0F, 48.0F, 31.179701F, 48.0F, 24.0F);
      ((Path)localObject2).cubicTo(48.0F, 16.820299F, 42.179703F, 11.0F, 35.0F, 11.0F);
      ((Path)localObject2).cubicTo(27.820299F, 11.0F, 22.0F, 16.820299F, 22.0F, 24.0F);
      ((Path)localObject2).lineTo(22.0F, 24.0F);
      ((Path)localObject2).lineTo(26.0F, 24.0F);
      ((Path)localObject2).cubicTo(26.0F, 19.029438F, 30.029438F, 15.0F, 35.0F, 15.0F);
      ((Path)localObject2).cubicTo(39.970562F, 15.0F, 44.0F, 19.029438F, 44.0F, 24.0F);
      ((Path)localObject2).cubicTo(44.0F, 28.970562F, 39.970562F, 33.0F, 35.0F, 33.0F);
      ((Path)localObject2).cubicTo(31.756393F, 33.0F, 28.913553F, 31.284109F, 27.329683F, 28.710527F);
      ((Path)localObject2).lineTo(27.0F, 28.932901F);
      ((Path)localObject2).lineTo(27.0F, 29.0F);
      ((Path)localObject2).lineTo(26.90052F, 29.0F);
      ((Path)localObject2).lineTo(24.011108F, 30.948933F);
      ((Path)localObject2).lineTo(24.011108F, 30.948933F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.0F, 24.0F);
      ((Path)localObject2).lineTo(24.571232F, 28.0F);
      ((Path)localObject2).lineTo(29.0F, 24.0F);
      ((Path)localObject2).lineTo(20.0F, 24.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-3487030);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(26.0F, 52.0F);
      ((Path)localObject2).lineTo(44.0F, 52.0F);
      ((Path)localObject2).lineTo(44.0F, 56.0F);
      ((Path)localObject2).lineTo(26.0F, 56.0F);
      ((Path)localObject2).lineTo(26.0F, 52.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2105377);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(60.0F, 53.0F);
      ((Path)localObject1).lineTo(1.991746F, 53.0F);
      ((Path)localObject1).cubicTo(0.8977023F, 53.0F, 0.0F, 52.105953F, 0.0F, 51.00309F);
      ((Path)localObject1).lineTo(0.0F, 1.99691F);
      ((Path)localObject1).cubicTo(0.0F, 0.8976762F, 0.891735F, 0.0F, 1.991746F, 0.0F);
      ((Path)localObject1).lineTo(69.008255F, 0.0F);
      ((Path)localObject1).cubicTo(70.102295F, 0.0F, 71.0F, 0.8940468F, 71.0F, 1.99691F);
      ((Path)localObject1).lineTo(71.0F, 32.0F);
      ((Path)localObject1).lineTo(68.0F, 32.0F);
      ((Path)localObject1).lineTo(68.0F, 4.993174F);
      ((Path)localObject1).cubicTo(68.0F, 4.444659F, 67.557137F, 4.0F, 66.994713F, 4.0F);
      ((Path)localObject1).lineTo(5.005287F, 4.0F);
      ((Path)localObject1).cubicTo(4.450082F, 4.0F, 4.0F, 4.446476F, 4.0F, 4.993174F);
      ((Path)localObject1).lineTo(4.0F, 44.006824F);
      ((Path)localObject1).cubicTo(4.0F, 44.55534F, 4.442863F, 45.0F, 5.005287F, 45.0F);
      ((Path)localObject1).lineTo(60.0F, 45.0F);
      ((Path)localObject1).lineTo(60.0F, 53.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(19.0F, 58.0F);
      ((Path)localObject1).lineTo(19.0F, 57.009369F);
      ((Path)localObject1).cubicTo(19.0F, 56.443352F, 19.444485F, 56.0F, 19.992786F, 56.0F);
      ((Path)localObject1).lineTo(50.007214F, 56.0F);
      ((Path)localObject1).cubicTo(50.547638F, 56.0F, 51.0F, 56.451908F, 51.0F, 57.009369F);
      ((Path)localObject1).lineTo(51.0F, 58.0F);
      ((Path)localObject1).lineTo(19.0F, 58.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chatting_backup_computer
 * JD-Core Version:    0.7.0.1
 */