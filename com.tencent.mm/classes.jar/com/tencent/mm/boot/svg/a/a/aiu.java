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

public final class aiu
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.24F, 0.0F, 1.0F, 2.24F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(11.76F, 23.52F);
      ((Path)localObject2).cubicTo(5.265132F, 23.52F, 0.0F, 18.254869F, 0.0F, 11.76F);
      ((Path)localObject2).cubicTo(0.0F, 5.265132F, 5.265132F, 0.0F, 11.76F, 0.0F);
      ((Path)localObject2).cubicTo(18.254869F, 0.0F, 23.52F, 5.265132F, 23.52F, 11.76F);
      ((Path)localObject2).cubicTo(23.52F, 18.254869F, 18.254869F, 23.52F, 11.76F, 23.52F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.76F, 18.816F);
      ((Path)localObject2).cubicTo(15.133969F, 18.816F, 17.904558F, 16.232622F, 18.201632F, 12.936F);
      ((Path)localObject2).lineTo(5.318368F, 12.936F);
      ((Path)localObject2).cubicTo(5.615442F, 16.232622F, 8.386031F, 18.816F, 11.76F, 18.816F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(7.644F, 9.996F);
      ((Path)localObject2).cubicTo(8.61823F, 9.996F, 9.408F, 9.20623F, 9.408F, 8.232F);
      ((Path)localObject2).cubicTo(9.408F, 7.25777F, 8.61823F, 6.468F, 7.644F, 6.468F);
      ((Path)localObject2).cubicTo(6.66977F, 6.468F, 5.88F, 7.25777F, 5.88F, 8.232F);
      ((Path)localObject2).cubicTo(5.88F, 9.20623F, 6.66977F, 9.996F, 7.644F, 9.996F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.876F, 9.996F);
      ((Path)localObject2).cubicTo(16.850231F, 9.996F, 17.639999F, 9.20623F, 17.639999F, 8.232F);
      ((Path)localObject2).cubicTo(17.639999F, 7.25777F, 16.850231F, 6.468F, 15.876F, 6.468F);
      ((Path)localObject2).cubicTo(14.90177F, 6.468F, 14.112F, 7.25777F, 14.112F, 8.232F);
      ((Path)localObject2).cubicTo(14.112F, 9.20623F, 14.90177F, 9.996F, 15.876F, 9.996F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aiu
 * JD-Core Version:    0.7.0.1
 */