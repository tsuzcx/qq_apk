package com.tencent.mm.boot.svg.code.drawable;

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

public class icons_filled_red_envelope_big
  extends c
{
  private final int height = 50;
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
      return 50;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -133.0F, 0.0F, 1.0F, -587.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 123.0F, 0.0F, 1.0F, 582.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 60.0F);
      ((Path)localObject2).lineTo(0.0F, 60.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject2, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-372399);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(50.0F, 32.683998F);
      ((Path)localObject1).lineTo(44.658642F, 32.683998F);
      ((Path)localObject1).cubicTo(45.036823F, 31.943644F, 45.25F, 31.106264F, 45.25F, 30.218826F);
      ((Path)localObject1).cubicTo(45.25F, 27.193747F, 42.77113F, 24.75F, 39.723942F, 24.75F);
      ((Path)localObject1).cubicTo(38.214706F, 24.75F, 36.797352F, 25.354279F, 35.763958F, 26.404575F);
      ((Path)localObject1).cubicTo(32.63958F, 29.485071F, 31.235376F, 30.869555F, 29.999891F, 32.087711F);
      ((Path)localObject1).lineTo(24.111284F, 26.281933F);
      ((Path)localObject1).cubicTo(23.06764F, 25.296791F, 21.712925F, 24.75F, 20.276669F, 24.75F);
      ((Path)localObject1).cubicTo(17.229433F, 24.75F, 14.75F, 27.19379F, 14.75F, 30.218826F);
      ((Path)localObject1).cubicTo(14.75F, 31.106258F, 14.963227F, 31.94364F, 15.341485F, 32.683998F);
      ((Path)localObject1).lineTo(10.0F, 32.683998F);
      ((Path)localObject1).lineTo(10.0F, 12.022304F);
      ((Path)localObject1).cubicTo(10.0F, 10.638088F, 10.980515F, 9.010373F, 12.234455F, 8.397089F);
      ((Path)localObject1).cubicTo(12.234455F, 8.397089F, 11.723122F, 8.606557F, 12.674759F, 8.199476F);
      ((Path)localObject1).cubicTo(17.338657F, 6.204406F, 23.388803F, 5.0F, 30.0F, 5.0F);
      ((Path)localObject1).cubicTo(36.602695F, 5.0F, 42.645782F, 6.201311F, 47.307243F, 8.191784F);
      ((Path)localObject1).cubicTo(48.26561F, 8.601013F, 47.75061F, 8.390479F, 47.75061F, 8.390479F);
      ((Path)localObject1).cubicTo(48.992912F, 9.012065F, 50.0F, 10.638559F, 50.0F, 12.022304F);
      ((Path)localObject1).lineTo(50.0F, 32.683998F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(50.0F, 35.683998F);
      ((Path)localObject1).lineTo(50.0F, 52.423656F);
      ((Path)localObject1).cubicTo(50.0F, 53.807873F, 48.888424F, 54.93F, 47.497822F, 54.93F);
      ((Path)localObject1).lineTo(12.502179F, 54.93F);
      ((Path)localObject1).cubicTo(11.120264F, 54.93F, 10.0F, 53.8074F, 10.0F, 52.423656F);
      ((Path)localObject1).lineTo(10.0F, 35.683998F);
      ((Path)localObject1).lineTo(20.041737F, 35.683998F);
      ((Path)localObject1).cubicTo(20.119646F, 35.687229F, 20.197968F, 35.688858F, 20.276669F, 35.688858F);
      ((Path)localObject1).lineTo(26.347048F, 35.688858F);
      ((Path)localObject1).cubicTo(24.230742F, 37.757069F, 20.974974F, 40.46769F, 16.591118F, 43.806713F);
      ((Path)localObject1).lineTo(18.408882F, 46.193287F);
      ((Path)localObject1).cubicTo(22.969538F, 42.719604F, 26.353868F, 39.895702F, 28.57391F, 37.706745F);
      ((Path)localObject1).lineTo(29.999949F, 36.300674F);
      ((Path)localObject1).cubicTo(30.422581F, 36.717365F, 30.897173F, 37.18528F, 31.457039F, 37.737274F);
      ((Path)localObject1).cubicTo(33.670509F, 39.919609F, 37.044682F, 42.733448F, 41.591618F, 46.193668F);
      ((Path)localObject1).lineTo(43.408382F, 43.806332F);
      ((Path)localObject1).cubicTo(39.017014F, 40.4645F, 35.761269F, 37.753922F, 33.65271F, 35.688858F);
      ((Path)localObject1).lineTo(39.723942F, 35.688858F);
      ((Path)localObject1).cubicTo(39.802643F, 35.688858F, 39.880962F, 35.687229F, 39.95887F, 35.683998F);
      ((Path)localObject1).lineTo(50.0F, 35.683998F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(39.883869F, 32.683998F);
      ((Path)localObject1).lineTo(33.667984F, 32.683998F);
      ((Path)localObject1).lineTo(37.886345F, 28.524708F);
      ((Path)localObject1).cubicTo(38.376534F, 28.026745F, 39.02565F, 27.75F, 39.723942F, 27.75F);
      ((Path)localObject1).cubicTo(41.123783F, 27.75F, 42.25F, 28.860258F, 42.25F, 30.218826F);
      ((Path)localObject1).cubicTo(42.25F, 31.526302F, 41.208679F, 32.60326F, 39.883869F, 32.683998F);
      ((Path)localObject1).lineTo(39.883869F, 32.683998F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(20.116732F, 32.683998F);
      ((Path)localObject1).cubicTo(18.791719F, 32.603256F, 17.75F, 31.526127F, 17.75F, 30.218826F);
      ((Path)localObject1).cubicTo(17.75F, 28.860445F, 18.87664F, 27.75F, 20.276669F, 27.75F);
      ((Path)localObject1).cubicTo(20.941519F, 27.75F, 21.561464F, 28.000223F, 22.028793F, 28.441132F);
      ((Path)localObject1).cubicTo(24.024054F, 30.408504F, 25.327253F, 31.693487F, 26.33182F, 32.683998F);
      ((Path)localObject1).lineTo(20.116732F, 32.683998F);
      ((Path)localObject1).lineTo(20.116732F, 32.683998F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_red_envelope_big
 * JD-Core Version:    0.7.0.1
 */