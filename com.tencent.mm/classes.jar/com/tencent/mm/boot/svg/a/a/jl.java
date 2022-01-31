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

public final class jl
  extends c
{
  private final int height = 44;
  private final int width = 44;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 44;
      return 44;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-16339370);
      ((Paint)localObject).setStrokeWidth(1.2F);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(22.594595F, 43.400002F);
      localPath.cubicTo(33.818893F, 43.400002F, 43.400002F, 33.818893F, 43.400002F, 22.594595F);
      localPath.cubicTo(43.400002F, 10.363577F, 33.994289F, 0.6F, 22.594595F, 0.6F);
      localPath.cubicTo(10.181107F, 0.6F, 0.6F, 10.181107F, 0.6F, 22.594595F);
      localPath.cubicTo(0.6F, 33.994289F, 10.363577F, 43.400002F, 22.594595F, 43.400002F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16268960);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      localPath = c.l(paramVarArgs);
      localPath.moveTo(23.815264F, 31.186165F);
      localPath.cubicTo(26.139557F, 28.861872F, 27.466667F, 25.724232F, 27.466667F, 22.370899F);
      localPath.cubicTo(27.466667F, 19.017567F, 26.139557F, 15.879927F, 23.815264F, 13.555634F);
      localPath.lineTo(25.370899F, 12.0F);
      localPath.cubicTo(28.025043F, 14.654144F, 29.666666F, 18.320812F, 29.666666F, 22.370899F);
      localPath.cubicTo(29.666666F, 26.420988F, 28.025043F, 30.087654F, 25.370899F, 32.741798F);
      localPath.lineTo(23.815264F, 31.186165F);
      localPath.close();
      localPath.moveTo(20.18545F, 27.556349F);
      localPath.cubicTo(21.553268F, 26.18853F, 22.333334F, 24.34425F, 22.333334F, 22.370899F);
      localPath.cubicTo(22.333334F, 20.397549F, 21.553268F, 18.553268F, 20.18545F, 17.18545F);
      localPath.lineTo(21.741085F, 15.629815F);
      localPath.cubicTo(23.466278F, 17.355009F, 24.533333F, 19.738342F, 24.533333F, 22.370899F);
      localPath.cubicTo(24.533333F, 25.003456F, 23.466278F, 27.386789F, 21.741085F, 29.111984F);
      localPath.lineTo(20.18545F, 27.556349F);
      localPath.close();
      localPath.moveTo(18.111269F, 25.48217F);
      localPath.lineTo(15.0F, 22.370899F);
      localPath.lineTo(18.111269F, 19.25963F);
      localPath.cubicTo(18.907513F, 20.055874F, 19.4F, 21.155872F, 19.4F, 22.370899F);
      localPath.cubicTo(19.4F, 23.585926F, 18.907513F, 24.685926F, 18.111269F, 25.48217F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(419430400);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(23.815264F, 31.186165F);
      ((Path)localObject).cubicTo(26.139557F, 28.861872F, 27.466667F, 25.724232F, 27.466667F, 22.370899F);
      ((Path)localObject).cubicTo(27.466667F, 19.017567F, 26.139557F, 15.879927F, 23.815264F, 13.555634F);
      ((Path)localObject).lineTo(25.370899F, 12.0F);
      ((Path)localObject).cubicTo(28.025043F, 14.654144F, 29.666666F, 18.320812F, 29.666666F, 22.370899F);
      ((Path)localObject).cubicTo(29.666666F, 26.420988F, 28.025043F, 30.087654F, 25.370899F, 32.741798F);
      ((Path)localObject).lineTo(23.815264F, 31.186165F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.18545F, 27.556349F);
      ((Path)localObject).cubicTo(21.553268F, 26.18853F, 22.333334F, 24.34425F, 22.333334F, 22.370899F);
      ((Path)localObject).cubicTo(22.333334F, 20.397549F, 21.553268F, 18.553268F, 20.18545F, 17.18545F);
      ((Path)localObject).lineTo(21.741085F, 15.629815F);
      ((Path)localObject).cubicTo(23.466278F, 17.355009F, 24.533333F, 19.738342F, 24.533333F, 22.370899F);
      ((Path)localObject).cubicTo(24.533333F, 25.003456F, 23.466278F, 27.386789F, 21.741085F, 29.111984F);
      ((Path)localObject).lineTo(20.18545F, 27.556349F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.111269F, 25.48217F);
      ((Path)localObject).lineTo(15.0F, 22.370899F);
      ((Path)localObject).lineTo(18.111269F, 19.25963F);
      ((Path)localObject).cubicTo(18.907513F, 20.055874F, 19.4F, 21.155872F, 19.4F, 22.370899F);
      ((Path)localObject).cubicTo(19.4F, 23.585926F, 18.907513F, 24.685926F, 18.111269F, 25.48217F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.jl
 * JD-Core Version:    0.7.0.1
 */