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

public final class bct
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
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -194.0F, 0.0F, 1.0F, -155.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 194.0F, 0.0F, 1.0F, 155.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 84.0F);
      ((Path)localObject).lineTo(0.0F, 84.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-15028967);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(26.948999F, 16.841825F);
      ((Path)localObject).cubicTo(33.648998F, 12.678541F, 41.638F, 10.73867F, 49.502998F, 11.028203F);
      ((Path)localObject).cubicTo(57.467999F, 11.295772F, 65.407997F, 13.88859F, 71.778F, 18.713806F);
      ((Path)localObject).cubicTo(74.780998F, 20.984144F, 77.422997F, 23.748686F, 79.470001F, 26.910585F);
      ((Path)localObject).cubicTo(81.411003F, 29.898766F, 82.805F, 33.248363F, 83.490997F, 36.746723F);
      ((Path)localObject).cubicTo(84.316002F, 40.921986F, 84.130997F, 45.291939F, 82.953003F, 49.382343F);
      ((Path)localObject).cubicTo(81.293999F, 55.208942F, 77.655998F, 60.369621F, 73.003998F, 64.214417F);
      ((Path)localObject).cubicTo(67.824997F, 68.514481F, 61.43F, 71.263046F, 54.799F, 72.346306F);
      ((Path)localObject).cubicTo(45.675999F, 73.844887F, 36.001999F, 72.303375F, 27.968F, 67.669846F);
      ((Path)localObject).cubicTo(22.646F, 69.412033F, 17.323F, 71.156219F, 12.0F, 72.899414F);
      ((Path)localObject).cubicTo(14.104F, 68.41964F, 16.209999F, 63.94186F, 18.312F, 59.461086F);
      ((Path)localObject).cubicTo(15.922F, 56.467915F, 14.079F, 53.024467F, 13.034F, 49.336414F);
      ((Path)localObject).cubicTo(11.356F, 43.516804F, 11.74F, 37.141087F, 14.082F, 31.557093F);
      ((Path)localObject).cubicTo(16.618F, 25.418991F, 21.327F, 20.318218F, 26.948999F, 16.841825F);
      ((Path)localObject).lineTo(26.948999F, 16.841825F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.728001F, 15.903339F);
      ((Path)localObject).cubicTo(33.562F, 17.28511F, 27.702F, 20.305241F, 23.271F, 24.840925F);
      ((Path)localObject).cubicTo(20.666F, 27.504627F, 18.584F, 30.699474F, 17.337999F, 34.215805F);
      ((Path)localObject).cubicTo(15.605F, 39.044018F, 15.557F, 44.450294F, 17.208F, 49.307461F);
      ((Path)localObject).cubicTo(18.375999F, 52.793839F, 20.372F, 55.975708F, 22.882F, 58.655384F);
      ((Path)localObject).cubicTo(21.586F, 61.405949F, 20.294001F, 64.157509F, 19.000999F, 66.909073F);
      ((Path)localObject).cubicTo(22.312F, 65.806847F, 25.624001F, 64.705627F, 28.934999F, 63.602406F);
      ((Path)localObject).cubicTo(31.917F, 65.463402F, 35.193001F, 66.843178F, 38.596001F, 67.722763F);
      ((Path)localObject).cubicTo(46.703999F, 69.803406F, 55.537998F, 69.152451F, 63.175999F, 65.687042F);
      ((Path)localObject).cubicTo(68.380997F, 63.324852F, 73.040001F, 59.607849F, 76.146004F, 54.782631F);
      ((Path)localObject).cubicTo(78.168999F, 51.652679F, 79.491997F, 48.059475F, 79.873001F, 44.348461F);
      ((Path)localObject).cubicTo(80.255997F, 40.747269F, 79.764F, 37.061214F, 78.464996F, 33.680668F);
      ((Path)localObject).cubicTo(77.237F, 30.463856F, 75.307999F, 27.531584F, 72.929001F, 25.04759F);
      ((Path)localObject).cubicTo(70.650002F, 22.666431F, 67.964996F, 20.684628F, 65.056F, 19.138123F);
      ((Path)localObject).cubicTo(57.368999F, 15.054708F, 48.196999F, 14.01239F, 39.728001F, 15.903339F);
      ((Path)localObject).lineTo(39.728001F, 15.903339F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bct
 * JD-Core Version:    0.7.0.1
 */