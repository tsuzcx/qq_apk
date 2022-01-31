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

public final class aim
  extends c
{
  private final int height = 42;
  private final int width = 42;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localPaint2.setColor(-6710887);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(19.74F, 0.0F);
      localPath.lineTo(22.040001F, 0.0F);
      localPath.cubicTo(32.380001F, 0.39F, 41.32F, 9.17F, 42.0F, 19.469999F);
      localPath.lineTo(42.0F, 22.200001F);
      localPath.cubicTo(41.540001F, 32.57F, 32.610001F, 41.470001F, 22.26F, 42.0F);
      localPath.lineTo(19.950001F, 42.0F);
      localPath.cubicTo(9.62F, 41.599998F, 0.68F, 32.830002F, 0.0F, 22.530001F);
      localPath.lineTo(0.0F, 19.799999F);
      localPath.cubicTo(0.47F, 9.43F, 9.4F, 0.53F, 19.74F, 0.0F);
      localPath.lineTo(19.74F, 0.0F);
      localPath.close();
      localPath.moveTo(20.87298F, 6.540901F);
      localPath.cubicTo(18.624437F, 7.68438F, 18.225163F, 11.434167F, 20.641821F, 12.587948F);
      localPath.cubicTo(23.153044F, 14.081682F, 26.683468F, 11.238437F, 25.884918F, 8.477604F);
      localPath.cubicTo(25.58021F, 6.262757F, 22.638191F, 5.315009F, 20.87298F, 6.540901F);
      localPath.lineTo(20.87298F, 6.540901F);
      localPath.close();
      localPath.moveTo(19.27931F, 14.632621F);
      localPath.cubicTo(15.97931F, 16.242502F, 13.227586F, 19.382271F, 13.0F, 23.052F);
      localPath.cubicTo(14.52069F, 20.922155F, 16.051723F, 18.732317F, 18.327587F, 17.262426F);
      localPath.cubicTo(17.903448F, 22.822016F, 15.637931F, 28.161621F, 15.875862F, 33.761208F);
      localPath.cubicTo(15.875862F, 35.551075F, 17.955172F, 36.421013F, 19.517241F, 35.80106F);
      localPath.cubicTo(23.799999F, 34.391163F, 27.048275F, 30.541447F, 28.0F, 26.30176F);
      localPath.cubicTo(26.272413F, 28.121624F, 24.451725F, 29.891495F, 23.044828F, 31.97134F);
      localPath.cubicTo(22.082758F, 26.471746F, 25.268965F, 21.192137F, 24.524137F, 15.702541F);
      localPath.cubicTo(23.799999F, 13.502704F, 20.975863F, 13.772684F, 19.27931F, 14.632621F);
      localPath.lineTo(19.27931F, 14.632621F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(8.87298F, 1.540901F);
      ((Path)localObject2).cubicTo(10.638191F, 0.3150088F, 13.58021F, 1.262757F, 13.884919F, 3.477604F);
      ((Path)localObject2).cubicTo(14.683467F, 6.238437F, 11.153045F, 9.081682F, 8.641821F, 7.587948F);
      ((Path)localObject2).cubicTo(6.225163F, 6.434167F, 6.624437F, 2.68438F, 8.87298F, 1.540901F);
      ((Path)localObject2).lineTo(8.87298F, 1.540901F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(7.27931F, 9.632621F);
      ((Path)localObject2).cubicTo(8.975863F, 8.772684F, 11.8F, 8.502704F, 12.524137F, 10.702541F);
      ((Path)localObject2).cubicTo(13.268966F, 16.192137F, 10.082759F, 21.471746F, 11.044827F, 26.97134F);
      ((Path)localObject2).cubicTo(12.451724F, 24.891495F, 14.272414F, 23.121624F, 16.0F, 21.30176F);
      ((Path)localObject2).cubicTo(15.048276F, 25.541447F, 11.8F, 29.391163F, 7.517242F, 30.801058F);
      ((Path)localObject2).cubicTo(5.955173F, 31.421013F, 3.875862F, 30.551077F, 3.875862F, 28.761209F);
      ((Path)localObject2).cubicTo(3.637931F, 23.161621F, 5.903448F, 17.822016F, 6.327586F, 12.262426F);
      ((Path)localObject2).cubicTo(4.051724F, 13.732318F, 2.52069F, 15.922156F, 1.0F, 18.052F);
      ((Path)localObject2).cubicTo(1.227586F, 14.38227F, 3.97931F, 11.242501F, 7.27931F, 9.632621F);
      ((Path)localObject2).lineTo(7.27931F, 9.632621F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aim
 * JD-Core Version:    0.7.0.1
 */