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

public class icon_filled_hangup
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(40.0F, 0.0F);
      ((Path)localObject).lineTo(40.0F, 40.0F);
      ((Path)localObject).lineTo(0.0F, 40.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.15568F, 25.258675F);
      ((Path)localObject).lineTo(4.472039F, 27.775742F);
      ((Path)localObject).cubicTo(3.797533F, 28.04357F, 3.055605F, 27.901602F, 2.511095F, 27.403084F);
      ((Path)localObject).cubicTo(2.289532F, 27.207245F, 2.165729F, 26.85095F, 2.133831F, 26.779697F);
      ((Path)localObject).cubicTo(1.154452F, 24.392651F, 1.719437F, 21.48761F, 3.786735F, 19.525818F);
      ((Path)localObject).cubicTo(4.369338F, 18.972948F, 5.032634F, 18.580393F, 5.197985F, 18.491163F);
      ((Path)localObject).cubicTo(9.955722F, 15.600619F, 15.278155F, 14.170835F, 20.524742F, 14.166676F);
      ((Path)localObject).cubicTo(25.771328F, 14.162518F, 30.942066F, 15.583985F, 35.392624F, 18.46723F);
      ((Path)localObject).cubicTo(35.529701F, 18.574039F, 36.170074F, 18.947742F, 36.693893F, 19.499735F);
      ((Path)localObject).cubicTo(38.552612F, 21.458416F, 38.808521F, 24.362804F, 37.575058F, 26.751606F);
      ((Path)localObject).cubicTo(37.535572F, 26.822916F, 37.356949F, 27.161631F, 37.131428F, 27.375645F);
      ((Path)localObject).cubicTo(36.55072F, 27.892872F, 35.793621F, 28.036028F, 35.14756F, 27.769247F);
      ((Path)localObject).lineTo(29.731279F, 25.260979F);
      ((Path)localObject).cubicTo(29.470234F, 25.136448F, 29.406435F, 24.993942F, 29.333326F, 24.691067F);
      ((Path)localObject).cubicTo(29.117788F, 23.711161F, 28.532906F, 21.288162F, 28.14477F, 19.862904F);
      ((Path)localObject).cubicTo(28.056658F, 19.50658F, 27.87837F, 19.16815F, 27.624908F, 18.901056F);
      ((Path)localObject).cubicTo(27.354549F, 18.616158F, 26.990223F, 18.420431F, 26.620207F, 18.331627F);
      ((Path)localObject).cubicTo(24.578568F, 17.798658F, 22.472963F, 17.461754F, 20.367191F, 17.463423F);
      ((Path)localObject).cubicTo(18.24452F, 17.447287F, 16.102888F, 17.787556F, 14.004365F, 18.323807F);
      ((Path)localObject).cubicTo(13.624867F, 18.413206F, 13.258476F, 18.591692F, 12.938985F, 18.894878F);
      ((Path)localObject).cubicTo(12.638287F, 19.180229F, 12.442766F, 19.501137F, 12.316731F, 19.857628F);
      ((Path)localObject).cubicTo(11.795694F, 21.265789F, 10.952932F, 23.68992F, 10.614311F, 24.688086F);
      ((Path)localObject).cubicTo(10.508966F, 24.991102F, 10.448792F, 25.115887F, 10.15568F, 25.258675F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_hangup
 * JD-Core Version:    0.7.0.1
 */