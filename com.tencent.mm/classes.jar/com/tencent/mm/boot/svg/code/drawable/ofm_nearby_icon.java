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

public class ofm_nearby_icon
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 22.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.0F, 11.0F);
      ((Path)localObject2).cubicTo(9.951573F, 6.605F, 12.71513F, 1.556408F, 17.0F, 0.0F);
      ((Path)localObject2).cubicTo(21.716715F, -1.169027F, 27.1437F, 2.21011F, 28.0F, 7.0F);
      ((Path)localObject2).cubicTo(28.655645F, 10.929491F, 26.342669F, 14.70085F, 23.0F, 17.0F);
      ((Path)localObject2).cubicTo(22.998363F, 17.164803F, 22.988352F, 18.482265F, 23.0F, 19.0F);
      ((Path)localObject2).cubicTo(29.656933F, 19.135967F, 36.345543F, 19.135967F, 43.0F, 19.0F);
      ((Path)localObject2).cubicTo(43.014122F, 18.341467F, 42.994099F, 16.762526F, 43.0F, 16.0F);
      ((Path)localObject2).cubicTo(38.368145F, 12.920768F, 37.587139F, 5.57919F, 42.0F, 2.0F);
      ((Path)localObject2).cubicTo(46.198223F, -1.762388F, 53.617771F, 0.1484341F, 55.0F, 5.0F);
      ((Path)localObject2).cubicTo(57.172344F, 9.672371F, 54.939472F, 14.49971F, 51.0F, 17.0F);
      ((Path)localObject2).cubicTo(51.034447F, 17.154747F, 51.024433F, 18.472208F, 51.0F, 19.0F);
      ((Path)localObject2).cubicTo(55.329975F, 19.246593F, 59.665554F, 18.8946F, 64.0F, 19.0F);
      ((Path)localObject2).cubicTo(66.664558F, 20.041092F, 66.674576F, 24.214729F, 64.0F, 25.0F);
      ((Path)localObject2).cubicTo(59.685581F, 25.411507F, 55.329975F, 25.059513F, 51.0F, 25.0F);
      ((Path)localObject2).cubicTo(51.104538F, 26.909994F, 50.694008F, 28.840929F, 52.0F, 30.0F);
      ((Path)localObject2).cubicTo(55.269897F, 36.816093F, 59.144882F, 43.071522F, 63.0F, 50.0F);
      ((Path)localObject2).cubicTo(64.07122F, 52.494888F, 59.635513F, 55.491863F, 58.0F, 53.0F);
      ((Path)localObject2).cubicTo(53.777977F, 47.154644F, 50.623917F, 40.979675F, 47.0F, 35.0F);
      ((Path)localObject2).cubicTo(43.875233F, 40.617626F, 40.731186F, 46.229404F, 38.0F, 52.0F);
      ((Path)localObject2).cubicTo(36.195347F, 54.536453F, 31.709576F, 54.566624F, 30.0F, 53.0F);
      ((Path)localObject2).cubicTo(26.062307F, 46.973621F, 22.888222F, 40.909275F, 19.0F, 35.0F);
      ((Path)localObject2).cubicTo(15.989344F, 40.879105F, 12.835284F, 46.903221F, 9.0F, 53.0F);
      ((Path)localObject2).cubicTo(7.33821F, 55.753342F, 2.161548F, 52.525059F, 4.0F, 49.0F);
      ((Path)localObject2).cubicTo(7.588532F, 42.749699F, 11.543622F, 36.273018F, 15.0F, 30.0F);
      ((Path)localObject2).cubicTo(16.159563F, 28.348139F, 15.919253F, 26.68874F, 16.0F, 25.0F);
      ((Path)localObject2).cubicTo(11.383416F, 25.059513F, 6.677359F, 25.411507F, 2.0F, 25.0F);
      ((Path)localObject2).cubicTo(-0.652074F, 24.275072F, -0.692125F, 20.010921F, 2.0F, 19.0F);
      ((Path)localObject2).cubicTo(6.647321F, 18.824202F, 11.333351F, 19.276764F, 16.0F, 19.0F);
      ((Path)localObject2).cubicTo(15.979331F, 18.482265F, 15.969317F, 17.164803F, 16.0F, 17.0F);
      ((Path)localObject2).cubicTo(13.89665F, 15.19364F, 11.924111F, 13.433673F, 11.0F, 11.0F);
      ((Path)localObject2).lineTo(11.0F, 11.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.0F, 25.0F);
      ((Path)localObject2).cubicTo(23.149179F, 26.464657F, 22.830931F, 28.077757F, 24.0F, 29.0F);
      ((Path)localObject2).cubicTo(26.858776F, 34.935909F, 30.081055F, 40.458057F, 33.0F, 46.0F);
      ((Path)localObject2).cubicTo(36.276978F, 40.774742F, 39.32024F, 35.569275F, 42.0F, 30.0F);
      ((Path)localObject2).cubicTo(43.318249F, 28.74081F, 42.860767F, 26.771442F, 43.0F, 25.0F);
      ((Path)localObject2).lineTo(23.0F, 25.0F);
      ((Path)localObject2).lineTo(23.0F, 25.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ofm_nearby_icon
 * JD-Core Version:    0.7.0.1
 */