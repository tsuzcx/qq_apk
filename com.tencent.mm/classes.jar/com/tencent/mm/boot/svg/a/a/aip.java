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

public final class aip
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(11.119819F, 10.335465F);
      ((Path)localObject).cubicTo(10.997457F, 10.294674F, 10.946472F, 10.315069F, 10.834308F, 10.376256F);
      ((Path)localObject).cubicTo(10.467222F, 10.580212F, 9.569902F, 11.069706F, 9.039668F, 11.345047F);
      ((Path)localObject).cubicTo(8.907109F, 11.416431F, 8.764354F, 11.457222F, 8.601205F, 11.457222F);
      ((Path)localObject).cubicTo(8.427859F, 11.457222F, 8.274907F, 11.406234F, 8.142348F, 11.324651F);
      ((Path)localObject).cubicTo(7.397981F, 10.886146F, 6.6944F, 10.376256F, 6.092788F, 9.764388F);
      ((Path)localObject).cubicTo(5.491176F, 9.162719F, 4.981335F, 8.459071F, 4.542872F, 7.714632F);
      ((Path)localObject).cubicTo(4.461298F, 7.58206F, 4.410313F, 7.418896F, 4.410313F, 7.255731F);
      ((Path)localObject).cubicTo(4.410313F, 7.102764F, 4.451101F, 6.949797F, 4.522478F, 6.817226F);
      ((Path)localObject).cubicTo(4.797792F, 6.276743F, 5.28724F, 5.379337F, 5.491176F, 5.022414F);
      ((Path)localObject).cubicTo(5.552357F, 4.910238F, 5.572751F, 4.849052F, 5.531963F, 4.736876F);
      ((Path)localObject).lineTo(4.665234F, 2.432174F);
      ((Path)localObject).cubicTo(4.553069F, 2.167031F, 4.298148F, 1.993669F, 3.992244F, 1.983471F);
      ((Path)localObject).cubicTo(3.869882F, 1.983471F, 3.727127F, 2.03446F, 3.696536F, 2.044658F);
      ((Path)localObject).cubicTo(2.697248F, 2.411779F, 1.983471F, 3.360174F, 1.983471F, 4.481931F);
      ((Path)localObject).cubicTo(1.983471F, 4.798062F, 2.065046F, 5.093799F, 2.075243F, 5.165183F);
      ((Path)localObject).cubicTo(2.56469F, 7.30672F, 3.655749F, 9.213708F, 5.154681F, 10.712784F);
      ((Path)localObject).cubicTo(6.653613F, 12.211859F, 8.560417F, 13.303023F, 10.701749F, 13.792518F);
      ((Path)localObject).cubicTo(10.773127F, 13.812913F, 11.068834F, 13.884297F, 11.384935F, 13.884297F);
      ((Path)localObject).cubicTo(12.506585F, 13.884297F, 13.454889F, 13.170452F, 13.821975F, 12.171068F);
      ((Path)localObject).cubicTo(13.832171F, 12.140474F, 13.893353F, 11.997705F, 13.883156F, 11.875332F);
      ((Path)localObject).cubicTo(13.862762F, 11.569398F, 13.689416F, 11.314453F, 13.424299F, 11.202277F);
      ((Path)localObject).lineTo(11.119819F, 10.335465F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aip
 * JD-Core Version:    0.7.0.1
 */