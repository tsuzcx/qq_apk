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

public class icons_filled_mini_program
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(17.004295F, 12.990751F);
      ((Path)localObject).lineTo(16.76837F, 12.994569F);
      ((Path)localObject).cubicTo(16.055016F, 12.994569F, 15.639927F, 12.471272F, 15.908092F, 11.86796F);
      ((Path)localObject).cubicTo(16.091732F, 11.439467F, 16.506041F, 11.108546F, 16.995338F, 10.999859F);
      ((Path)localObject).cubicTo(18.304462F, 10.683864F, 19.19393F, 9.660716F, 19.19393F, 8.471246F);
      ((Path)localObject).cubicTo(19.19393F, 7.029172F, 17.81712F, 5.853993F, 16.097445F, 5.853993F);
      ((Path)localObject).cubicTo(14.377769F, 5.853993F, 13.000958F, 7.029172F, 13.000958F, 8.471246F);
      ((Path)localObject).lineTo(13.000958F, 15.659744F);
      ((Path)localObject).cubicTo(13.000958F, 18.191664F, 10.737898F, 20.230989F, 7.950479F, 20.230989F);
      ((Path)localObject).cubicTo(5.163061F, 20.230989F, 2.9F, 18.191664F, 2.9F, 15.659744F);
      ((Path)localObject).cubicTo(2.9F, 13.439664F, 4.652343F, 11.544662F, 7.039936F, 11.184345F);
      ((Path)localObject).lineTo(7.231629F, 11.184345F);
      ((Path)localObject).cubicTo(7.771693F, 11.184345F, 8.160703F, 11.507646F, 8.160703F, 11.969357F);
      ((Path)localObject).cubicTo(8.160933F, 12.048471F, 8.159011F, 12.08503F, 8.1512F, 12.131896F);
      ((Path)localObject).cubicTo(8.140671F, 12.195074F, 8.120168F, 12.255544F, 8.091908F, 12.310954F);
      ((Path)localObject).cubicTo(7.919784F, 12.712574F, 7.479771F, 13.060287F, 7.004661F, 13.179055F);
      ((Path)localObject).cubicTo(5.704997F, 13.492767F, 4.80607F, 14.509667F, 4.80607F, 15.659744F);
      ((Path)localObject).cubicTo(4.80607F, 17.101818F, 6.182881F, 18.276997F, 7.902556F, 18.276997F);
      ((Path)localObject).cubicTo(9.622231F, 18.276997F, 10.999042F, 17.101818F, 10.999042F, 15.659744F);
      ((Path)localObject).lineTo(10.999042F, 8.471246F);
      ((Path)localObject).cubicTo(10.999042F, 5.939327F, 13.262102F, 3.9F, 16.04952F, 3.9F);
      ((Path)localObject).cubicTo(18.836939F, 3.9F, 21.1F, 5.939327F, 21.1F, 8.471246F);
      ((Path)localObject).cubicTo(21.1F, 10.703113F, 19.388876F, 12.576041F, 17.004295F, 12.990751F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_mini_program
 * JD-Core Version:    0.7.0.1
 */