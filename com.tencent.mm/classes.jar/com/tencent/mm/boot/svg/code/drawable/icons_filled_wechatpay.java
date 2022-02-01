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

public class icons_filled_wechatpay
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(21.820826F, 34.158489F);
      ((Path)localObject2).cubicTo(21.549904F, 34.296669F, 21.244909F, 34.378048F, 20.921633F, 34.378048F);
      ((Path)localObject2).cubicTo(20.171196F, 34.378048F, 19.518824F, 33.956734F, 19.176432F, 33.334515F);
      ((Path)localObject2).lineTo(19.045958F, 33.042904F);
      ((Path)localObject2).lineTo(13.583479F, 20.817225F);
      ((Path)localObject2).cubicTo(13.524474F, 20.684134F, 13.487908F, 20.533241F, 13.487908F, 20.386587F);
      ((Path)localObject2).cubicTo(13.487908F, 19.823708F, 13.935843F, 19.36764F, 14.487659F, 19.36764F);
      ((Path)localObject2).cubicTo(14.713704F, 19.36764F, 14.918973F, 19.443087F, 15.086844F, 19.570242F);
      ((Path)localObject2).lineTo(21.531622F, 24.250452F);
      ((Path)localObject2).cubicTo(22.001163F, 24.564104F, 22.565445F, 24.748905F, 23.170448F, 24.748905F);
      ((Path)localObject2).cubicTo(23.530293F, 24.748905F, 23.875177F, 24.681087F, 24.195129F, 24.561562F);
      ((Path)localObject2).lineTo(54.50428F, 10.802374F);
      ((Path)localObject2).cubicTo(49.07172F, 4.269918F, 40.123825F, 0.0F, 29.999168F, 0.0F);
      ((Path)localObject2).cubicTo(13.429735F, 0.0F, 0.0F, 11.417811F, 0.0F, 25.50252F);
      ((Path)localObject2).cubicTo(0.0F, 33.186165F, 4.039724F, 40.104332F, 10.36483F, 44.779453F);
      ((Path)localObject2).cubicTo(10.872601F, 45.148209F, 11.204188F, 45.754322F, 11.204188F, 46.440968F);
      ((Path)localObject2).cubicTo(11.204188F, 46.668152F, 11.158481F, 46.873299F, 11.098645F, 47.090313F);
      ((Path)localObject2).cubicTo(10.594199F, 49.01292F, 9.785589F, 52.090107F, 9.748193F, 52.235065F);
      ((Path)localObject2).cubicTo(9.685033F, 52.474968F, 9.586138F, 52.727585F, 9.586138F, 52.981052F);
      ((Path)localObject2).cubicTo(9.586138F, 53.543083F, 10.033242F, 54.0F, 10.587551F, 54.0F);
      ((Path)localObject2).cubicTo(10.803623F, 54.0F, 10.980637F, 53.91777F, 11.164298F, 53.810959F);
      ((Path)localObject2).lineTo(17.732071F, 49.942009F);
      ((Path)localObject2).cubicTo(18.225712F, 49.651245F, 18.748442F, 49.471531F, 19.32519F, 49.471531F);
      ((Path)localObject2).cubicTo(19.631845F, 49.471531F, 19.92853F, 49.519852F, 20.20693F, 49.607166F);
      ((Path)localObject2).cubicTo(23.271006F, 50.505737F, 26.576914F, 51.005039F, 29.999168F, 51.005039F);
      ((Path)localObject2).cubicTo(46.567772F, 51.005039F, 60.0F, 39.587227F, 60.0F, 25.50252F);
      ((Path)localObject2).cubicTo(60.0F, 21.237688F, 58.760906F, 17.219542F, 56.581902F, 13.686284F);
      ((Path)localObject2).lineTo(22.040222F, 34.02879F);
      ((Path)localObject2).lineTo(21.820826F, 34.158489F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_wechatpay
 * JD-Core Version:    0.7.0.1
 */