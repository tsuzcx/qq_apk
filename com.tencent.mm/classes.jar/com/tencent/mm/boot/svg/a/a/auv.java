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

public final class auv
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
      localPaint.setColor(-15683841);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(53.062035F, 26.549711F);
      ((Path)localObject).cubicTo(52.459232F, 25.463072F, 52.85146F, 24.09351F, 53.938095F, 23.490705F);
      ((Path)localObject).cubicTo(55.024734F, 22.887901F, 56.394299F, 23.280127F, 56.997105F, 24.366766F);
      ((Path)localObject).cubicTo(62.150024F, 33.655628F, 60.592953F, 45.350697F, 52.970562F, 52.973091F);
      ((Path)localObject).cubicTo(43.59798F, 62.345673F, 28.40202F, 62.345673F, 19.029438F, 52.973091F);
      ((Path)localObject).cubicTo(9.656855F, 43.600506F, 9.656855F, 28.404547F, 19.029438F, 19.031963F);
      ((Path)localObject).cubicTo(26.651829F, 11.409573F, 38.346897F, 9.852504F, 47.635761F, 15.005424F);
      ((Path)localObject).cubicTo(48.722401F, 15.608228F, 49.114624F, 16.977791F, 48.511822F, 18.06443F);
      ((Path)localObject).cubicTo(47.909019F, 19.151068F, 46.539455F, 19.543295F, 45.452816F, 18.940491F);
      ((Path)localObject).cubicTo(37.908688F, 14.755447F, 28.404543F, 16.020821F, 22.211418F, 22.213943F);
      ((Path)localObject).cubicTo(14.596194F, 29.829168F, 14.596194F, 42.175884F, 22.211418F, 49.791107F);
      ((Path)localObject).cubicTo(29.826641F, 57.406334F, 42.173359F, 57.406334F, 49.788582F, 49.791107F);
      ((Path)localObject).cubicTo(55.981709F, 43.597984F, 57.247078F, 34.093838F, 53.062035F, 26.549711F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.auv
 * JD-Core Version:    0.7.0.1
 */