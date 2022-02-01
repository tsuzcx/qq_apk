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

public final class aqz
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 62.400002F);
      ((Path)localObject).cubicTo(50.580318F, 62.400002F, 62.400002F, 50.580318F, 62.400002F, 36.0F);
      ((Path)localObject).cubicTo(62.400002F, 21.419683F, 50.580318F, 9.6F, 36.0F, 9.6F);
      ((Path)localObject).cubicTo(21.419683F, 9.6F, 9.6F, 21.419683F, 9.6F, 36.0F);
      ((Path)localObject).cubicTo(9.6F, 50.580318F, 21.419683F, 62.400002F, 36.0F, 62.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.370068F, 33.370068F);
      ((Path)localObject).lineTo(27.802084F, 44.197914F);
      ((Path)localObject).lineTo(38.629932F, 38.629932F);
      ((Path)localObject).lineTo(44.197914F, 27.802084F);
      ((Path)localObject).lineTo(33.370068F, 33.370068F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.696699F, 30.696699F);
      ((Path)localObject).lineTo(48.373051F, 21.607025F);
      ((Path)localObject).cubicTo(48.803566F, 21.385643F, 49.314457F, 21.385643F, 49.744972F, 21.607025F);
      ((Path)localObject).cubicTo(50.481701F, 21.985872F, 50.77182F, 22.890223F, 50.392975F, 23.626949F);
      ((Path)localObject).lineTo(41.303303F, 41.303303F);
      ((Path)localObject).lineTo(23.626949F, 50.392975F);
      ((Path)localObject).cubicTo(23.196436F, 50.614357F, 22.685541F, 50.614357F, 22.255028F, 50.392975F);
      ((Path)localObject).cubicTo(21.518301F, 50.01413F, 21.22818F, 49.109779F, 21.607025F, 48.373051F);
      ((Path)localObject).lineTo(30.696699F, 30.696699F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqz
 * JD-Core Version:    0.7.0.1
 */