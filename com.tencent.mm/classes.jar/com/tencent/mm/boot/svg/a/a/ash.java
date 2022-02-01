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

public final class ash
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      ((Paint)localObject).setColor(-15365900);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(62.108814F, 34.199982F);
      localPath.lineTo(37.799999F, 9.891169F);
      localPath.lineTo(37.799999F, 23.527599F);
      localPath.cubicTo(43.318237F, 24.316921F, 47.683064F, 28.681744F, 48.472397F, 34.199978F);
      localPath.lineTo(44.819965F, 34.199982F);
      localPath.cubicTo(43.986069F, 30.091959F, 40.354118F, 27.0F, 36.0F, 27.0F);
      localPath.cubicTo(35.38356F, 27.0F, 34.781597F, 27.061974F, 34.200001F, 27.180033F);
      localPath.lineTo(34.200001F, 5.766326F);
      localPath.cubicTo(36.269375F, 5.1218F, 38.620529F, 5.620529F, 40.246616F, 7.246615F);
      localPath.lineTo(64.753387F, 31.753386F);
      localPath.cubicTo(65.461761F, 32.461758F, 65.954758F, 33.304485F, 66.233673F, 34.199982F);
      localPath.lineTo(62.108814F, 34.199982F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16726153);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(37.800018F, 62.108814F);
      localPath.lineTo(62.108829F, 37.799999F);
      localPath.lineTo(48.472401F, 37.799999F);
      localPath.cubicTo(47.683079F, 43.318237F, 43.318256F, 47.683064F, 37.800022F, 48.472397F);
      localPath.lineTo(37.800018F, 44.819965F);
      localPath.cubicTo(41.908043F, 43.986069F, 45.0F, 40.354118F, 45.0F, 36.0F);
      localPath.cubicTo(45.0F, 35.38356F, 44.938026F, 34.781597F, 44.819965F, 34.200001F);
      localPath.lineTo(66.233673F, 34.200001F);
      localPath.cubicTo(66.878197F, 36.269375F, 66.379471F, 38.620529F, 64.753387F, 40.246616F);
      localPath.lineTo(40.246616F, 64.753387F);
      localPath.cubicTo(39.538242F, 65.461761F, 38.695515F, 65.954758F, 37.800018F, 66.233673F);
      localPath.lineTo(37.800018F, 62.108814F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-372399);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(9.891187F, 37.800018F);
      localPath.lineTo(34.200001F, 62.108829F);
      localPath.lineTo(34.200001F, 48.472401F);
      localPath.cubicTo(28.681765F, 47.683079F, 24.316935F, 43.318256F, 23.527603F, 37.800022F);
      localPath.lineTo(27.180037F, 37.800018F);
      localPath.cubicTo(28.013929F, 41.908043F, 31.645882F, 45.0F, 36.0F, 45.0F);
      localPath.cubicTo(36.61644F, 45.0F, 37.218403F, 44.938026F, 37.799999F, 44.819965F);
      localPath.lineTo(37.799999F, 66.233673F);
      localPath.cubicTo(35.730625F, 66.878197F, 33.379471F, 66.379471F, 31.753386F, 64.753387F);
      localPath.lineTo(7.246615F, 40.246616F);
      localPath.cubicTo(6.538241F, 39.538242F, 6.045243F, 38.695515F, 5.766331F, 37.800018F);
      localPath.lineTo(9.891187F, 37.800018F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-352965);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(34.199982F, 9.891187F);
      ((Path)localObject).lineTo(9.891169F, 34.200001F);
      ((Path)localObject).lineTo(23.527599F, 34.200001F);
      ((Path)localObject).cubicTo(24.316921F, 28.681765F, 28.681744F, 24.316935F, 34.199978F, 23.527603F);
      ((Path)localObject).lineTo(34.199982F, 27.180037F);
      ((Path)localObject).cubicTo(30.091959F, 28.013929F, 27.0F, 31.645882F, 27.0F, 36.0F);
      ((Path)localObject).cubicTo(27.0F, 36.61644F, 27.061974F, 37.218403F, 27.180033F, 37.799999F);
      ((Path)localObject).lineTo(5.766326F, 37.799999F);
      ((Path)localObject).cubicTo(5.1218F, 35.730625F, 5.620529F, 33.379471F, 7.246615F, 31.753386F);
      ((Path)localObject).lineTo(31.753386F, 7.246615F);
      ((Path)localObject).cubicTo(32.461758F, 6.538241F, 33.304485F, 6.045243F, 34.199982F, 5.766331F);
      ((Path)localObject).lineTo(34.199982F, 9.891187F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ash
 * JD-Core Version:    0.7.0.1
 */