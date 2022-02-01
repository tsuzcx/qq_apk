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

public final class apu
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(41.938095F, 43.703377F);
      ((Path)localObject).lineTo(36.0F, 45.682739F);
      ((Path)localObject).lineTo(34.256554F, 56.14341F);
      ((Path)localObject).cubicTo(33.711784F, 59.412033F, 30.620419F, 61.620152F, 27.351797F, 61.075378F);
      ((Path)localObject).cubicTo(26.878267F, 60.99646F, 26.415922F, 60.860992F, 25.974676F, 60.671886F);
      ((Path)localObject).lineTo(13.818242F, 55.461987F);
      ((Path)localObject).cubicTo(12.715191F, 54.98925F, 12.0F, 53.904636F, 12.0F, 52.704552F);
      ((Path)localObject).lineTo(12.0F, 17.536842F);
      ((Path)localObject).cubicTo(12.0F, 16.400526F, 12.642007F, 15.361736F, 13.65836F, 14.85356F);
      ((Path)localObject).lineTo(24.250582F, 9.557449F);
      ((Path)localObject).cubicTo(27.214453F, 8.075514F, 30.818491F, 9.27686F, 32.300426F, 12.240731F);
      ((Path)localObject).cubicTo(32.362019F, 12.363917F, 32.419353F, 12.489188F, 32.472324F, 12.616321F);
      ((Path)localObject).lineTo(43.75864F, 39.70348F);
      ((Path)localObject).cubicTo(44.395893F, 41.232883F, 43.672661F, 42.989304F, 42.143257F, 43.626556F);
      ((Path)localObject).cubicTo(42.075829F, 43.654652F, 42.007393F, 43.680275F, 41.938095F, 43.703377F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(53.000713F, 53.000713F);
      ((Path)localObject).cubicTo(56.720272F, 49.281158F, 58.799999F, 44.287937F, 58.799999F, 39.0F);
      ((Path)localObject).cubicTo(58.799999F, 33.712063F, 56.720272F, 28.718843F, 53.000713F, 24.999287F);
      ((Path)localObject).lineTo(52.57645F, 24.575022F);
      ((Path)localObject).lineTo(55.970562F, 21.180908F);
      ((Path)localObject).lineTo(56.394825F, 21.605173F);
      ((Path)localObject).cubicTo(60.978058F, 26.188404F, 63.599998F, 32.387371F, 63.599998F, 39.0F);
      ((Path)localObject).cubicTo(63.599998F, 45.612629F, 60.978058F, 51.811596F, 56.394825F, 56.394825F);
      ((Path)localObject).lineTo(55.970562F, 56.819092F);
      ((Path)localObject).lineTo(52.57645F, 53.42498F);
      ((Path)localObject).lineTo(53.000713F, 53.000713F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(47.061016F, 47.061016F);
      ((Path)localObject).cubicTo(49.203735F, 44.918301F, 50.400002F, 42.046177F, 50.400002F, 39.0F);
      ((Path)localObject).cubicTo(50.400002F, 35.953823F, 49.203735F, 33.081699F, 47.061016F, 30.938982F);
      ((Path)localObject).lineTo(46.636753F, 30.514719F);
      ((Path)localObject).lineTo(50.030865F, 27.120605F);
      ((Path)localObject).lineTo(50.455132F, 27.54487F);
      ((Path)localObject).cubicTo(53.473221F, 30.562963F, 55.200001F, 34.645523F, 55.200001F, 39.0F);
      ((Path)localObject).cubicTo(55.200001F, 43.354477F, 53.473221F, 47.437038F, 50.455132F, 50.455132F);
      ((Path)localObject).lineTo(50.030865F, 50.879395F);
      ((Path)localObject).lineTo(46.636753F, 47.485283F);
      ((Path)localObject).lineTo(47.061016F, 47.061016F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apu
 * JD-Core Version:    0.7.0.1
 */