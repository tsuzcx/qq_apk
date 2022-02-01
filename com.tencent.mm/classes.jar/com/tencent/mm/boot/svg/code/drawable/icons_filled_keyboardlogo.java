package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_filled_keyboardlogo
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 2.0F);
      ((Path)localObject).cubicTo(17.246628F, 2.0F, 21.5F, 5.864983F, 21.5F, 10.632561F);
      ((Path)localObject).cubicTo(21.5F, 15.40014F, 17.246628F, 19.264923F, 12.0F, 19.264923F);
      ((Path)localObject).cubicTo(11.473862F, 19.264923F, 10.95884F, 19.224524F, 10.456149F, 19.149523F);
      ((Path)localObject).cubicTo(10.299702F, 19.126123F, 10.140224F, 19.152122F, 10.001968F, 19.228523F);
      ((Path)localObject).lineTo(10.001968F, 19.228523F);
      ((Path)localObject).lineTo(6.952266F, 20.911514F);
      ((Path)localObject).cubicTo(6.504958F, 21.158314F, 5.933947F, 20.858915F, 5.94567F, 20.383318F);
      ((Path)localObject).lineTo(5.94567F, 20.383318F);
      ((Path)localObject).lineTo(6.010149F, 17.740728F);
      ((Path)localObject).cubicTo(6.016213F, 17.49613F, 5.910298F, 17.260731F, 5.718277F, 17.106731F);
      ((Path)localObject).cubicTo(3.745308F, 15.52494F, 2.5F, 13.211349F, 2.5F, 10.632561F);
      ((Path)localObject).cubicTo(2.5F, 5.864983F, 6.753372F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.67623F, 6.750079F);
      ((Path)localObject).lineTo(13.501667F, 6.750079F);
      ((Path)localObject).lineTo(13.63588F, 6.987278F);
      ((Path)localObject).cubicTo(14.133316F, 7.865674F, 14.635805F, 9.272468F, 14.635805F, 10.435462F);
      ((Path)localObject).cubicTo(14.635805F, 11.657057F, 14.130486F, 13.158649F, 13.630018F, 14.010446F);
      ((Path)localObject).lineTo(13.489944F, 14.250045F);
      ((Path)localObject).lineTo(14.669358F, 14.250045F);
      ((Path)localObject).lineTo(14.710794F, 14.186046F);
      ((Path)localObject).cubicTo(15.443103F, 13.05045F, 15.822093F, 11.789456F, 15.83988F, 10.437662F);
      ((Path)localObject).cubicTo(15.861507F, 8.75507F, 15.209242F, 7.563275F, 14.717667F, 6.812878F);
      ((Path)localObject).lineTo(14.67623F, 6.750079F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.484042F, 12.000035F);
      ((Path)localObject).lineTo(8.968085F, 12.000035F);
      ((Path)localObject).lineTo(8.968085F, 13.500035F);
      ((Path)localObject).lineTo(10.484042F, 13.500035F);
      ((Path)localObject).lineTo(10.484042F, 12.000035F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.484042F, 7.500055F);
      ((Path)localObject).lineTo(8.968085F, 7.500055F);
      ((Path)localObject).lineTo(8.968085F, 9.000055F);
      ((Path)localObject).lineTo(10.484042F, 9.000055F);
      ((Path)localObject).lineTo(10.484042F, 7.500055F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_keyboardlogo
 * JD-Core Version:    0.7.0.1
 */