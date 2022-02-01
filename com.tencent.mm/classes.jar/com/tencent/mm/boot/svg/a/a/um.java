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

public final class um
  extends c
{
  private final int height = 140;
  private final int width = 140;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 140;
      return 140;
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1118482);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(140.0F, 0.0F);
      localPath.lineTo(140.0F, 140.0F);
      localPath.lineTo(0.0F, 140.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localPath.moveTo(57.016972F, 36.707909F);
      localPath.cubicTo(52.477718F, 42.007774F, 52.327744F, 49.611931F, 53.287586F, 56.18417F);
      localPath.cubicTo(54.177437F, 62.365677F, 58.826675F, 66.904129F, 61.326267F, 72.384331F);
      localPath.cubicTo(62.965996F, 75.590302F, 60.956326F, 79.227066F, 58.146786F, 80.930237F);
      localPath.cubicTo(50.348068F, 85.889473F, 41.699486F, 89.496185F, 34.320694F, 95.106636F);
      localPath.cubicTo(29.991405F, 98.262512F, 30.801273F, 104.32379F, 31.761116F, 108.90232F);
      localPath.cubicTo(56.976978F, 109.04258F, 82.212837F, 109.01252F, 107.4287F, 108.93237F);
      localPath.cubicTo(111.00812F, 109.02254F, 109.66833F, 104.48409F, 109.95829F, 102.1798F);
      localPath.cubicTo(110.32823F, 98.77346F, 108.18858F, 95.898109F, 105.47903F, 94.134827F);
      localPath.cubicTo(98.660141F, 89.416039F, 91.111382F, 85.89949F, 84.002548F, 81.661598F);
      localPath.cubicTo(81.183006F, 79.998505F, 78.073517F, 76.832611F, 79.433296F, 73.255951F);
      localPath.cubicTo(81.552948F, 67.455154F, 86.572128F, 63.016888F, 87.641953F, 56.75523F);
      localPath.cubicTo(88.63179F, 50.182995F, 88.711777F, 42.598877F, 84.292496F, 37.168766F);
      localPath.cubicTo(77.663589F, 29.10375F, 63.935837F, 28.943453F, 57.016972F, 36.707909F);
      localPath.lineTo(57.016972F, 36.707909F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-4934220);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 30.0F, 0.0F, 1.0F, 30.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(27.016973F, 6.707908F);
      ((Path)localObject2).cubicTo(33.935837F, -1.056548F, 47.663586F, -0.8962496F, 54.2925F, 7.168766F);
      ((Path)localObject2).cubicTo(58.711773F, 12.598875F, 58.631786F, 20.182995F, 57.641949F, 26.755232F);
      ((Path)localObject2).cubicTo(56.572124F, 33.016888F, 51.552948F, 37.455151F, 49.433296F, 43.255951F);
      ((Path)localObject2).cubicTo(48.073517F, 46.832611F, 51.18301F, 49.998505F, 54.002544F, 51.661602F);
      ((Path)localObject2).cubicTo(61.111382F, 55.89949F, 68.660141F, 59.416039F, 75.479027F, 64.134827F);
      ((Path)localObject2).cubicTo(78.188576F, 65.898109F, 80.328224F, 68.77346F, 79.95829F, 72.179802F);
      ((Path)localObject2).cubicTo(79.668335F, 74.484093F, 81.008118F, 79.022545F, 77.428703F, 78.932373F);
      ((Path)localObject2).cubicTo(52.212841F, 79.01252F, 26.976978F, 79.04258F, 1.761115F, 78.902321F);
      ((Path)localObject2).cubicTo(0.8012729F, 74.323792F, -0.008594216F, 68.262512F, 4.320695F, 65.106636F);
      ((Path)localObject2).cubicTo(11.699485F, 59.496189F, 20.348066F, 55.889473F, 28.146788F, 50.930241F);
      ((Path)localObject2).cubicTo(30.956327F, 49.22707F, 32.965996F, 45.590298F, 31.326265F, 42.384331F);
      ((Path)localObject2).cubicTo(28.826675F, 36.904125F, 24.177439F, 32.365677F, 23.287584F, 26.184168F);
      ((Path)localObject2).cubicTo(22.327742F, 19.611933F, 22.477716F, 12.007775F, 27.016973F, 6.707908F);
      ((Path)localObject2).lineTo(27.016973F, 6.707908F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.um
 * JD-Core Version:    0.7.0.1
 */