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

public class icons_filled_red_envelope
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      ((Path)localObject).lineTo(60.0F, 0.0F);
      ((Path)localObject).lineTo(60.0F, 60.0F);
      ((Path)localObject).lineTo(0.0F, 60.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(60.0F, 0.0F);
      localPath.lineTo(60.0F, 60.0F);
      localPath.lineTo(0.0F, 60.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint((Paint)localObject, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-372399);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(50.0F, 32.683998F);
      ((Path)localObject).lineTo(44.658642F, 32.683998F);
      ((Path)localObject).cubicTo(45.036823F, 31.943644F, 45.25F, 31.106264F, 45.25F, 30.218826F);
      ((Path)localObject).cubicTo(45.25F, 27.193747F, 42.77113F, 24.75F, 39.723942F, 24.75F);
      ((Path)localObject).cubicTo(38.214706F, 24.75F, 36.797352F, 25.354279F, 35.763958F, 26.404575F);
      ((Path)localObject).cubicTo(32.63958F, 29.485071F, 31.235376F, 30.869555F, 29.999891F, 32.087711F);
      ((Path)localObject).lineTo(24.111284F, 26.281933F);
      ((Path)localObject).cubicTo(23.06764F, 25.296791F, 21.712925F, 24.75F, 20.276669F, 24.75F);
      ((Path)localObject).cubicTo(17.229433F, 24.75F, 14.75F, 27.19379F, 14.75F, 30.218826F);
      ((Path)localObject).cubicTo(14.75F, 31.106258F, 14.963227F, 31.94364F, 15.341485F, 32.683998F);
      ((Path)localObject).lineTo(10.0F, 32.683998F);
      ((Path)localObject).lineTo(10.0F, 12.022304F);
      ((Path)localObject).cubicTo(10.0F, 10.638088F, 10.980515F, 9.010373F, 12.234455F, 8.397089F);
      ((Path)localObject).cubicTo(12.234455F, 8.397089F, 11.723122F, 8.606557F, 12.674759F, 8.199476F);
      ((Path)localObject).cubicTo(17.338657F, 6.204406F, 23.388803F, 5.0F, 30.0F, 5.0F);
      ((Path)localObject).cubicTo(36.602695F, 5.0F, 42.645782F, 6.201311F, 47.307243F, 8.191784F);
      ((Path)localObject).cubicTo(48.26561F, 8.601013F, 47.75061F, 8.390479F, 47.75061F, 8.390479F);
      ((Path)localObject).cubicTo(48.992912F, 9.012065F, 50.0F, 10.638559F, 50.0F, 12.022304F);
      ((Path)localObject).lineTo(50.0F, 32.683998F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(50.0F, 35.683998F);
      ((Path)localObject).lineTo(50.0F, 52.423656F);
      ((Path)localObject).cubicTo(50.0F, 53.807873F, 48.888424F, 54.93F, 47.497822F, 54.93F);
      ((Path)localObject).lineTo(12.502179F, 54.93F);
      ((Path)localObject).cubicTo(11.120264F, 54.93F, 10.0F, 53.8074F, 10.0F, 52.423656F);
      ((Path)localObject).lineTo(10.0F, 35.683998F);
      ((Path)localObject).lineTo(20.041737F, 35.683998F);
      ((Path)localObject).cubicTo(20.119646F, 35.687229F, 20.197968F, 35.688858F, 20.276669F, 35.688858F);
      ((Path)localObject).lineTo(26.347048F, 35.688858F);
      ((Path)localObject).cubicTo(24.230742F, 37.757069F, 20.974974F, 40.46769F, 16.591118F, 43.806713F);
      ((Path)localObject).lineTo(18.408882F, 46.193287F);
      ((Path)localObject).cubicTo(22.969538F, 42.719604F, 26.353868F, 39.895702F, 28.57391F, 37.706745F);
      ((Path)localObject).lineTo(29.999949F, 36.300674F);
      ((Path)localObject).cubicTo(30.422581F, 36.717365F, 30.897173F, 37.18528F, 31.457039F, 37.737274F);
      ((Path)localObject).cubicTo(33.670509F, 39.919609F, 37.044682F, 42.733448F, 41.591618F, 46.193668F);
      ((Path)localObject).lineTo(43.408382F, 43.806332F);
      ((Path)localObject).cubicTo(39.017014F, 40.4645F, 35.761269F, 37.753922F, 33.65271F, 35.688858F);
      ((Path)localObject).lineTo(39.723942F, 35.688858F);
      ((Path)localObject).cubicTo(39.802643F, 35.688858F, 39.880962F, 35.687229F, 39.95887F, 35.683998F);
      ((Path)localObject).lineTo(50.0F, 35.683998F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.883869F, 32.683998F);
      ((Path)localObject).lineTo(33.667984F, 32.683998F);
      ((Path)localObject).lineTo(37.886345F, 28.524708F);
      ((Path)localObject).cubicTo(38.376534F, 28.026745F, 39.02565F, 27.75F, 39.723942F, 27.75F);
      ((Path)localObject).cubicTo(41.123783F, 27.75F, 42.25F, 28.860258F, 42.25F, 30.218826F);
      ((Path)localObject).cubicTo(42.25F, 31.526302F, 41.208679F, 32.60326F, 39.883869F, 32.683998F);
      ((Path)localObject).lineTo(39.883869F, 32.683998F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.116732F, 32.683998F);
      ((Path)localObject).cubicTo(18.791719F, 32.603256F, 17.75F, 31.526127F, 17.75F, 30.218826F);
      ((Path)localObject).cubicTo(17.75F, 28.860445F, 18.87664F, 27.75F, 20.276669F, 27.75F);
      ((Path)localObject).cubicTo(20.941519F, 27.75F, 21.561464F, 28.000223F, 22.028793F, 28.441132F);
      ((Path)localObject).cubicTo(24.024054F, 30.408504F, 25.327253F, 31.693487F, 26.33182F, 32.683998F);
      ((Path)localObject).lineTo(20.116732F, 32.683998F);
      ((Path)localObject).lineTo(20.116732F, 32.683998F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_red_envelope
 * JD-Core Version:    0.7.0.1
 */