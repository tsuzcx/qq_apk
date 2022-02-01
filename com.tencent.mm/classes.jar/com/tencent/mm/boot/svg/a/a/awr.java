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

public final class awr
  extends c
{
  private final int height = 204;
  private final int width = 1126;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 1126;
      return 204;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      c.a(localPaint1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.5F, 24.0F);
      localPath.cubicTo(0.5F, 37.390865F, 10.107852F, 53.318604F, 21.959738F, 59.561539F);
      localPath.cubicTo(21.959738F, 59.561539F, 49.279743F, 74.451309F, 76.233803F, 86.166946F);
      localPath.cubicTo(207.33737F, 143.15135F, 377.29916F, 177.54317F, 563.0F, 177.54317F);
      localPath.cubicTo(748.93994F, 177.54317F, 919.10028F, 143.06273F, 1050.2725F, 85.946724F);
      localPath.cubicTo(1077.0372F, 74.29258F, 1104.0334F, 59.570366F, 1104.0334F, 59.570366F);
      localPath.cubicTo(1115.9077F, 53.35358F, 1125.5F, 37.397163F, 1125.5F, 24.0F);
      localPath.lineTo(1125.5F, 204.0F);
      localPath.lineTo(0.5F, 204.0F);
      localPath.lineTo(0.5F, 24.0F);
      localPath.close();
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint3 = c.m(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 1125.5F, 0.0F, 0.5F, 0.0F, 204.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { -1, -1, 16777215 }, new float[] { 0.0F, 0.8750361F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-2511000);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.4906926F, 24.0F);
      ((Path)localObject2).cubicTo(0.4906926F, 36.109203F, 10.398101F, 51.332298F, 21.907948F, 57.824688F);
      ((Path)localObject2).lineTo(25.902914F, 59.97636F);
      ((Path)localObject2).lineTo(30.66614F, 62.490044F);
      ((Path)localObject2).cubicTo(31.933975F, 63.153477F, 33.257462F, 63.841785F, 34.631824F, 64.551857F);
      ((Path)localObject2).cubicTo(43.794273F, 69.285667F, 53.338009F, 74.019409F, 62.776997F, 78.436409F);
      ((Path)localObject2).cubicTo(66.345848F, 80.106468F, 69.837036F, 81.701187F, 73.235214F, 83.210625F);
      ((Path)localObject2).lineTo(76.831741F, 84.791275F);
      ((Path)localObject2).cubicTo(211.5285F, 143.33746F, 382.30917F, 176.04317F, 563.0F, 176.04317F);
      ((Path)localObject2).cubicTo(742.11249F, 176.04317F, 911.48438F, 143.90594F, 1045.6196F, 86.324127F);
      ((Path)localObject2).lineTo(1050.354F, 84.274544F);
      ((Path)localObject2).cubicTo(1054.549F, 82.440079F, 1058.8961F, 80.467369F, 1063.365F, 78.376083F);
      ((Path)localObject2).cubicTo(1072.7715F, 73.974243F, 1082.2803F, 69.256744F, 1091.4077F, 64.539177F);
      ((Path)localObject2).lineTo(1095.3582F, 62.484444F);
      ((Path)localObject2).lineTo(1103.3378F, 58.241474F);
      ((Path)localObject2).cubicTo(1114.8965F, 52.189884F, 1125.0494F, 37.078308F, 1125.4855F, 24.813318F);
      ((Path)localObject2).lineTo(1125.5F, 24.0F);
      ((Path)localObject2).cubicTo(1125.5F, 30.0F, 1125.5F, 34.454426F, 1125.5F, 37.363277F);
      ((Path)localObject2).cubicTo(1125.5F, 37.387295F, 1125.4795F, 37.411308F, 1125.4692F, 37.435318F);
      ((Path)localObject2).cubicTo(1121.4637F, 46.836327F, 1113.928F, 55.771271F, 1105.5458F, 60.457401F);
      ((Path)localObject2).lineTo(1101.5134F, 62.627083F);
      ((Path)localObject2).cubicTo(1099.2911F, 63.811024F, 1096.8214F, 65.110733F, 1094.1421F, 66.501434F);
      ((Path)localObject2).lineTo(1092.7852F, 67.204254F);
      ((Path)localObject2).cubicTo(1083.625F, 71.938713F, 1074.0819F, 76.673233F, 1064.6366F, 81.093285F);
      ((Path)localObject2).cubicTo(1061.0437F, 82.77462F, 1057.5282F, 84.380112F, 1054.1055F, 85.89975F);
      ((Path)localObject2).lineTo(1050.8712F, 87.322006F);
      ((Path)localObject2).cubicTo(915.70892F, 146.17545F, 744.31891F, 179.04317F, 563.0F, 179.04317F);
      ((Path)localObject2).cubicTo(383.72339F, 179.04317F, 214.15054F, 146.91209F, 79.699364F, 89.296341F);
      ((Path)localObject2).lineTo(74.563553F, 87.074959F);
      ((Path)localObject2).cubicTo(70.351036F, 85.231697F, 65.988525F, 83.25148F, 61.50547F, 81.153618F);
      ((Path)localObject2).cubicTo(53.607338F, 77.457664F, 45.639652F, 73.54258F, 37.881966F, 69.591003F);
      ((Path)localObject2).lineTo(33.254791F, 67.217148F);
      ((Path)localObject2).cubicTo(30.956034F, 66.029488F, 28.79884F, 64.902351F, 26.805254F, 63.850128F);
      ((Path)localObject2).lineTo(21.26067F, 60.88868F);
      ((Path)localObject2).cubicTo(12.543673F, 56.297035F, 4.649197F, 47.085819F, 0.5206121F, 37.392197F);
      ((Path)localObject2).cubicTo(0.5106168F, 37.368729F, 0.4906926F, 37.345261F, 0.4906926F, 37.321785F);
      ((Path)localObject2).cubicTo(0.4906926F, 33.440594F, 0.4906926F, 29.0F, 0.4906926F, 24.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awr
 * JD-Core Version:    0.7.0.1
 */