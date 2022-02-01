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

public class icons_outlined_cards_offers
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.6F, 12.738222F);
      ((Path)localObject2).lineTo(3.6F, 42.976162F);
      ((Path)localObject2).lineTo(53.400002F, 49.528793F);
      ((Path)localObject2).lineTo(53.400002F, 19.290854F);
      ((Path)localObject2).lineTo(3.6F, 12.738222F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 11.568503F);
      ((Path)localObject2).cubicTo(0.0F, 10.149958F, 1.127867F, 8.843351F, 2.532104F, 8.648319F);
      ((Path)localObject2).lineTo(51.467896F, 1.851681F);
      ((Path)localObject2).cubicTo(52.866337F, 1.657453F, 54.0F, 2.636986F, 54.0F, 4.068503F);
      ((Path)localObject2).lineTo(54.0F, 15.738771F);
      ((Path)localObject2).lineTo(54.477234F, 15.801565F);
      ((Path)localObject2).cubicTo(55.870518F, 15.984893F, 57.0F, 17.29693F, 57.0F, 18.711035F);
      ((Path)localObject2).lineTo(57.0F, 50.628117F);
      ((Path)localObject2).cubicTo(57.0F, 52.287949F, 55.647224F, 53.455513F, 54.015686F, 53.240837F);
      ((Path)localObject2).lineTo(2.522766F, 46.46545F);
      ((Path)localObject2).cubicTo(1.129481F, 46.282124F, 0.0F, 44.970085F, 0.0F, 43.555981F);
      ((Path)localObject2).lineTo(0.0F, 11.638901F);
      ((Path)localObject2).cubicTo(0.0F, 11.615377F, 0.0002716947F, 11.591954F, 0.000812027F, 11.568631F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.793063F, 10.579965F);
      ((Path)localObject2).lineTo(50.400002F, 15.265087F);
      ((Path)localObject2).lineTo(50.400002F, 5.634556F);
      ((Path)localObject2).lineTo(14.793063F, 10.579965F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_cards_offers
 * JD-Core Version:    0.7.0.1
 */