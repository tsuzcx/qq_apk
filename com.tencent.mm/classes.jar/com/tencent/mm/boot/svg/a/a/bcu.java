package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bcu
  extends c
{
  private final int height = 150;
  private final int width = 150;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 150;
      return 150;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-921103);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(150.0F, 0.0F);
      localPath.lineTo(150.0F, 150.0F);
      localPath.lineTo(0.0F, 150.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-3552823);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(88.629036F, 47.177418F);
      ((Path)localObject).cubicTo(85.162018F, 47.177418F, 81.934029F, 48.098953F, 79.19355F, 49.66629F);
      ((Path)localObject).cubicTo(74.166534F, 52.543064F, 70.80645F, 57.627743F, 70.80645F, 63.427418F);
      ((Path)localObject).lineTo(70.80645F, 87.540321F);
      ((Path)localObject).cubicTo(70.80645F, 91.882744F, 66.581451F, 95.403229F, 61.370968F, 95.403229F);
      ((Path)localObject).cubicTo(56.159435F, 95.403229F, 51.935482F, 91.882744F, 51.935482F, 87.540321F);
      ((Path)localObject).cubicTo(51.935482F, 84.449677F, 54.080482F, 81.78363F, 57.193146F, 80.498306F);
      ((Path)localObject).cubicTo(57.4175F, 80.406052F, 57.645F, 80.317986F, 57.878792F, 80.240402F);
      ((Path)localObject).cubicTo(59.838226F, 79.454109F, 61.518791F, 77.977982F, 62.142582F, 76.26387F);
      ((Path)localObject).cubicTo(63.064114F, 73.733063F, 61.348953F, 71.682419F, 58.312824F, 71.682419F);
      ((Path)localObject).cubicTo(57.555885F, 71.682419F, 56.788467F, 71.810326F, 56.048306F, 72.04097F);
      ((Path)localObject).cubicTo(56.045162F, 72.042015F, 56.042015F, 72.043068F, 56.037823F, 72.044113F);
      ((Path)localObject).cubicTo(51.648228F, 73.304276F, 47.984112F, 76.067825F, 45.784595F, 79.677422F);
      ((Path)localObject).cubicTo(44.364033F, 82.010078F, 43.548386F, 84.688713F, 43.548386F, 87.540321F);
      ((Path)localObject).cubicTo(43.548386F, 96.500885F, 51.543388F, 103.79032F, 61.370968F, 103.79032F);
      ((Path)localObject).cubicTo(64.837982F, 103.79032F, 68.065971F, 102.86879F, 70.80645F, 101.30145F);
      ((Path)localObject).cubicTo(75.833466F, 98.424675F, 79.19355F, 93.339996F, 79.19355F, 87.540321F);
      ((Path)localObject).lineTo(79.19355F, 63.427418F);
      ((Path)localObject).cubicTo(79.19355F, 59.084999F, 83.417503F, 55.564518F, 88.629036F, 55.564518F);
      ((Path)localObject).cubicTo(93.839516F, 55.564518F, 98.064514F, 59.084999F, 98.064514F, 63.427418F);
      ((Path)localObject).cubicTo(98.064514F, 66.650162F, 95.738144F, 69.419998F, 92.407417F, 70.634033F);
      ((Path)localObject).cubicTo(90.259277F, 71.354271F, 88.499031F, 72.909035F, 87.828064F, 74.751045F);
      ((Path)localObject).cubicTo(86.911774F, 77.269272F, 88.618546F, 79.311531F, 91.641045F, 79.311531F);
      ((Path)localObject).cubicTo(92.325645F, 79.311531F, 93.017578F, 79.194115F, 93.691696F, 79.003304F);
      ((Path)localObject).cubicTo(93.801773F, 78.9729F, 93.910805F, 78.939354F, 94.019836F, 78.906853F);
      ((Path)localObject).cubicTo(98.383224F, 77.639359F, 102.02532F, 74.884193F, 104.21436F, 71.290321F);
      ((Path)localObject).cubicTo(105.63597F, 68.95871F, 106.45161F, 66.27903F, 106.45161F, 63.427418F);
      ((Path)localObject).cubicTo(106.45161F, 54.466854F, 98.456612F, 47.177418F, 88.629036F, 47.177418F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bcu
 * JD-Core Version:    0.7.0.1
 */