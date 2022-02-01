package com.tencent.mm.boot.svg.a.a;

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

public final class pn
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 19.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-3487030);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 63.0F, 0.0F, 1.0F, 33.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject3 = c.a(localPaint2, paramVarArgs);
      localObject2 = c.a((float[])localObject2, -1.0F, 0.0F, 14.043456F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0618892F, 1.0F);
      localPath.lineTo(0.0618892F, 24.0F);
      localPath.lineTo(13.981567F, 24.0F);
      localPath.lineTo(13.981567F, 1.0F);
      localPath.lineTo(0.0618892F, 1.0F);
      localPath.close();
      localPath.moveTo(1.043457F, 2.0F);
      localPath.lineTo(1.043457F, 21.0F);
      localPath.lineTo(13.018799F, 21.0F);
      localPath.lineTo(13.018799F, 2.0F);
      localPath.lineTo(1.043457F, 2.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(13.917834F, 1.0F);
      ((Path)localObject3).cubicTo(12.682228F, 0.4226382F, 10.33483F, 0.07387923F, 7.523809F, 0.0F);
      ((Path)localObject3).cubicTo(7.617364F, 0.003899288F, 7.318418F, 0.0F, 7.523809F, 0.0F);
      ((Path)localObject3).cubicTo(4.272239F, 0.0F, 1.495362F, 0.3603625F, 0.1017094F, 1.0F);
      ((Path)localObject3).lineTo(13.917834F, 1.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(13.917834F, 24.0F);
      ((Path)localObject3).cubicTo(12.682228F, 24.577362F, 10.33483F, 24.926121F, 7.523809F, 25.0F);
      ((Path)localObject3).cubicTo(7.617364F, 24.996101F, 7.318418F, 25.0F, 7.523809F, 25.0F);
      ((Path)localObject3).cubicTo(4.272239F, 25.0F, 1.495362F, 24.639637F, 0.1017094F, 24.0F);
      ((Path)localObject3).lineTo(13.917834F, 24.0F);
      ((Path)localObject3).lineTo(13.917834F, 24.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-12337128);
      localObject2 = c.a((float[])localObject2, 0.7071068F, 0.7071068F, -3.061947F, -0.7071068F, 0.7071068F, 31.718912F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(24.9F, 28.444445F);
      ((Path)localObject1).lineTo(50.985714F, 28.444445F);
      ((Path)localObject1).lineTo(50.985714F, 23.703705F);
      ((Path)localObject1).lineTo(27.271429F, 23.703705F);
      ((Path)localObject1).lineTo(27.271429F, 10.666667F);
      ((Path)localObject1).lineTo(22.52857F, 10.666667F);
      ((Path)localObject1).lineTo(22.52857F, 28.444445F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3487030);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(26.0F, 52.0F);
      ((Path)localObject2).lineTo(44.0F, 52.0F);
      ((Path)localObject2).lineTo(44.0F, 56.0F);
      ((Path)localObject2).lineTo(26.0F, 56.0F);
      ((Path)localObject2).lineTo(26.0F, 52.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-2105377);
      localObject1 = c.n(paramVarArgs);
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
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pn
 * JD-Core Version:    0.7.0.1
 */