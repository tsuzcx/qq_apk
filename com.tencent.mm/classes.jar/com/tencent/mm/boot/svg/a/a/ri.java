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

public final class ri
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -6.0F, 0.0F, 1.0F, -6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16268960);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(30.0F, 60.0F);
      ((Path)localObject2).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject2).cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(32.485283F, 43.674976F);
      ((Path)localObject1).lineTo(49.910259F, 26.25F);
      ((Path)localObject1).lineTo(52.455845F, 28.795584F);
      ((Path)localObject1).lineTo(34.606602F, 46.644829F);
      ((Path)localObject1).cubicTo(33.435028F, 47.816399F, 31.535534F, 47.816399F, 30.363962F, 46.644829F);
      ((Path)localObject1).lineTo(21.0F, 37.280865F);
      ((Path)localObject1).lineTo(21.0F, 37.280865F);
      ((Path)localObject1).lineTo(23.545584F, 34.735279F);
      ((Path)localObject1).lineTo(32.485283F, 43.674976F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ri
 * JD-Core Version:    0.7.0.1
 */