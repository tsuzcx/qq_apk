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

public final class bhm
  extends c
{
  private final int height = 84;
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
      return 84;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-6710887);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(32.825001F, 0.022F);
      ((Path)localObject3).cubicTo(37.638F, -0.146F, 42.487999F, 0.711F, 46.939999F, 2.551F);
      ((Path)localObject3).cubicTo(53.438999F, 5.215F, 59.056999F, 9.958F, 62.789001F, 15.907F);
      ((Path)localObject3).cubicTo(64.891998F, 19.242001F, 66.406998F, 22.948F, 67.235001F, 26.804001F);
      ((Path)localObject3).cubicTo(68.807999F, 34.061001F, 67.940002F, 41.831001F, 64.741997F, 48.539001F);
      ((Path)localObject3).cubicTo(61.981998F, 54.383999F, 57.512001F, 59.403999F, 52.029999F, 62.828999F);
      ((Path)localObject3).cubicTo(49.181F, 64.615997F, 46.063999F, 65.975998F, 42.814999F, 66.844002F);
      ((Path)localObject3).cubicTo(34.941002F, 68.967003F, 26.306999F, 68.146004F, 18.997999F, 64.517998F);
      ((Path)localObject3).cubicTo(12.084F, 61.132F, 6.397F, 55.320999F, 3.163F, 48.334999F);
      ((Path)localObject3).cubicTo(-0.307F, 40.938F, -0.941F, 32.272999F, 1.365F, 24.440001F);
      ((Path)localObject3).cubicTo(3.44F, 17.282F, 7.97F, 10.878F, 14.0F, 6.504F);
      ((Path)localObject3).cubicTo(19.438F, 2.522F, 26.087999F, 0.232F, 32.825001F, 0.022F);
      ((Path)localObject3).lineTo(32.825001F, 0.022F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(31.653F, 4.092F);
      ((Path)localObject3).cubicTo(27.312F, 4.422F, 23.049F, 5.72F, 19.261999F, 7.865F);
      ((Path)localObject3).cubicTo(13.874F, 10.9F, 9.467F, 15.64F, 6.843F, 21.24F);
      ((Path)localObject3).cubicTo(4.258F, 26.698F, 3.415F, 32.948002F, 4.4F, 38.902F);
      ((Path)localObject3).cubicTo(5.027F, 42.734001F, 6.416F, 46.438999F, 8.458F, 49.742001F);
      ((Path)localObject3).cubicTo(11.772F, 55.126999F, 16.829F, 59.418999F, 22.691F, 61.793999F);
      ((Path)localObject3).cubicTo(29.634001F, 64.642998F, 37.653999F, 64.732002F, 44.661999F, 62.049F);
      ((Path)localObject3).cubicTo(47.882999F, 60.825001F, 50.887001F, 59.035999F, 53.504002F, 56.793999F);
      ((Path)localObject3).cubicTo(58.196999F, 52.789001F, 61.612999F, 47.306F, 63.101002F, 41.314999F);
      ((Path)localObject3).cubicTo(64.164001F, 37.070999F, 64.282997F, 32.594002F, 63.457001F, 28.297001F);
      ((Path)localObject3).cubicTo(62.742001F, 24.559F, 61.294998F, 20.965F, 59.231998F, 17.768F);
      ((Path)localObject3).cubicTo(55.946999F, 12.656F, 51.076F, 8.58F, 45.456001F, 6.267F);
      ((Path)localObject3).cubicTo(41.112F, 4.463F, 36.339001F, 3.725F, 31.653F, 4.092F);
      ((Path)localObject3).lineTo(31.653F, 4.092F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(30.441F, 26.841999F);
      ((Path)localObject2).cubicTo(37.66F, 23.195999F, 44.880001F, 19.549999F, 52.099998F, 15.906F);
      ((Path)localObject2).cubicTo(48.438F, 23.169001F, 44.77F, 30.427999F, 41.103001F, 37.688999F);
      ((Path)localObject2).cubicTo(40.306999F, 39.233002F, 38.988998F, 40.497002F, 37.421001F, 41.240002F);
      ((Path)localObject2).cubicTo(30.25F, 44.862999F, 23.073F, 48.473999F, 15.907F, 52.104F);
      ((Path)localObject2).cubicTo(19.563999F, 44.858002F, 23.221001F, 37.612F, 26.878F, 30.367001F);
      ((Path)localObject2).cubicTo(27.648001F, 28.851F, 28.917999F, 27.597F, 30.441F, 26.841999F);
      ((Path)localObject2).lineTo(30.441F, 26.841999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.348999F, 31.077F);
      ((Path)localObject2).cubicTo(31.868F, 31.377001F, 30.790001F, 32.916F, 31.031F, 34.410999F);
      ((Path)localObject2).cubicTo(31.209F, 36.035999F, 32.891998F, 37.282001F, 34.499001F, 36.962002F);
      ((Path)localObject2).cubicTo(36.125999F, 36.734001F, 37.317001F, 35.000999F, 36.938999F, 33.400002F);
      ((Path)localObject2).cubicTo(36.653999F, 31.804001F, 34.922001F, 30.684F, 33.348999F, 31.077F);
      ((Path)localObject2).lineTo(33.348999F, 31.077F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bhm
 * JD-Core Version:    0.7.0.1
 */