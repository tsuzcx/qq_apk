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

public class wechat_icon
  extends c
{
  private final int height = 40;
  private final int width = 50;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 50;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -5.0F, 0.0F, 1.0F, -10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.5F, 0.0F, 1.0F, 10.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.125F, 14.726563F);
      ((Path)localObject2).cubicTo(0.125F, 19.091627F, 2.491685F, 23.05406F, 6.21875F, 25.742188F);
      ((Path)localObject2).cubicTo(6.493276F, 25.944246F, 6.640173F, 26.175379F, 6.640064F, 26.563416F);
      ((Path)localObject2).cubicTo(6.640152F, 26.670708F, 6.6251F, 26.784443F, 6.595362F, 26.922688F);
      ((Path)localObject2).lineTo(5.867188F, 29.960938F);
      ((Path)localObject2).cubicTo(5.817892F, 30.156403F, 5.740183F, 30.286613F, 5.75F, 30.429688F);
      ((Path)localObject2).cubicTo(5.740183F, 30.754131F, 6.001802F, 31.015625F, 6.335938F, 31.015625F);
      ((Path)localObject2).cubicTo(6.452738F, 31.015625F, 6.5568F, 30.968081F, 6.6875F, 30.898438F);
      ((Path)localObject2).lineTo(10.554688F, 28.671875F);
      ((Path)localObject2).cubicTo(10.799532F, 28.523726F, 11.074364F, 28.447371F, 11.259872F, 28.447371F);
      ((Path)localObject2).cubicTo(11.445381F, 28.447371F, 11.755001F, 28.504963F, 11.960938F, 28.554688F);
      ((Path)localObject2).cubicTo(13.753814F, 29.01293F, 15.689622F, 29.299446F, 17.703125F, 29.257813F);
      ((Path)localObject2).cubicTo(18.018276F, 29.299446F, 18.339657F, 29.291105F, 18.640625F, 29.257813F);
      ((Path)localObject2).cubicTo(18.277805F, 28.1367F, 18.069263F, 26.936419F, 18.054688F, 25.742188F);
      ((Path)localObject2).cubicTo(18.069263F, 18.33676F, 25.242872F, 12.370381F, 34.109375F, 12.382813F);
      ((Path)localObject2).cubicTo(34.413307F, 12.370381F, 34.730511F, 12.380391F, 35.046875F, 12.382813F);
      ((Path)localObject2).cubicTo(33.72374F, 5.416002F, 26.45944F, 0.078125F, 17.703125F, 0.078125F);
      ((Path)localObject2).cubicTo(7.991104F, 0.078125F, 0.125F, 6.620038F, 0.125F, 14.726563F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.726563F, 12.382813F);
      ((Path)localObject2).cubicTo(10.431959F, 12.382813F, 9.382813F, 11.333759F, 9.382813F, 10.039063F);
      ((Path)localObject2).cubicTo(9.382813F, 8.744784F, 10.431959F, 7.695313F, 11.726563F, 7.695313F);
      ((Path)localObject2).cubicTo(13.021166F, 7.695313F, 14.070313F, 8.744784F, 14.070313F, 10.039063F);
      ((Path)localObject2).cubicTo(14.070313F, 11.333759F, 13.021166F, 12.382813F, 11.726563F, 12.382813F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(34.109375F, 13.554688F);
      ((Path)localObject2).cubicTo(42.198986F, 13.554688F, 48.757813F, 19.00563F, 48.757813F, 25.742188F);
      ((Path)localObject2).cubicTo(48.757813F, 29.398289F, 46.784225F, 32.70097F, 43.71875F, 34.882813F);
      ((Path)localObject2).cubicTo(43.447948F, 35.109894F, 43.32267F, 35.369644F, 43.32267F, 35.611515F);
      ((Path)localObject2).cubicTo(43.32267F, 35.853386F, 43.338406F, 35.926929F, 43.367188F, 36.054688F);
      ((Path)localObject2).lineTo(43.43837F, 36.3606F);
      ((Path)localObject2).cubicTo(43.650475F, 37.248222F, 43.966751F, 38.399002F, 43.997406F, 38.502602F);
      ((Path)localObject2).lineTo(44.039536F, 38.641174F);
      ((Path)localObject2).cubicTo(44.059147F, 38.711235F, 44.073715F, 38.784096F, 44.070313F, 38.867188F);
      ((Path)localObject2).cubicTo(44.075981F, 39.117817F, 43.858135F, 39.335938F, 43.601563F, 39.335938F);
      ((Path)localObject2).cubicTo(43.501774F, 39.335938F, 43.425327F, 39.308712F, 43.31831F, 39.254509F);
      ((Path)localObject2).lineTo(43.25F, 39.21875F);
      ((Path)localObject2).lineTo(40.085938F, 37.34375F);
      ((Path)localObject2).lineTo(39.948334F, 37.272003F);
      ((Path)localObject2).cubicTo(39.759338F, 37.176872F, 39.548042F, 37.093678F, 39.312202F, 37.139946F);
      ((Path)localObject2).lineTo(39.022133F, 37.198738F);
      ((Path)localObject2).cubicTo(38.986717F, 37.206921F, 38.96096F, 37.214008F, 38.914063F, 37.226563F);
      ((Path)localObject2).cubicTo(37.394642F, 37.66729F, 35.780651F, 37.90543F, 34.109375F, 37.929688F);
      ((Path)localObject2).cubicTo(26.019346F, 37.90543F, 19.460938F, 32.454487F, 19.460938F, 25.742188F);
      ((Path)localObject2).cubicTo(19.460938F, 19.00563F, 26.019346F, 13.554688F, 34.109375F, 13.554688F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(29.130682F, 19.882813F);
      ((Path)localObject2).cubicTo(28.152256F, 19.882813F, 27.3125F, 20.722479F, 27.3125F, 21.700994F);
      ((Path)localObject2).cubicTo(27.3125F, 22.793549F, 28.152256F, 23.632813F, 29.130682F, 23.632813F);
      ((Path)localObject2).cubicTo(30.223547F, 23.632813F, 31.0625F, 22.793549F, 31.0625F, 21.700994F);
      ((Path)localObject2).cubicTo(31.0625F, 20.722479F, 30.223547F, 19.882813F, 29.130682F, 19.882813F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(38.857243F, 19.882813F);
      ((Path)localObject2).cubicTo(37.878819F, 19.882813F, 37.039063F, 20.722479F, 37.039063F, 21.700994F);
      ((Path)localObject2).cubicTo(37.039063F, 22.793549F, 37.878819F, 23.632813F, 38.857243F, 23.632813F);
      ((Path)localObject2).cubicTo(39.950108F, 23.632813F, 40.789063F, 22.793549F, 40.789063F, 21.700994F);
      ((Path)localObject2).cubicTo(40.789063F, 20.722479F, 39.950108F, 19.882813F, 38.857243F, 19.882813F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.445313F, 7.695313F);
      ((Path)localObject2).cubicTo(24.739592F, 7.695313F, 25.789063F, 8.744784F, 25.789063F, 10.039063F);
      ((Path)localObject2).cubicTo(25.789063F, 11.333759F, 24.739592F, 12.382813F, 23.445313F, 12.382813F);
      ((Path)localObject2).cubicTo(22.150616F, 12.382813F, 21.101563F, 11.333759F, 21.101563F, 10.039063F);
      ((Path)localObject2).cubicTo(21.101563F, 8.744784F, 22.150616F, 7.695313F, 23.445313F, 7.695313F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wechat_icon
 * JD-Core Version:    0.7.0.1
 */