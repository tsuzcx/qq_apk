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

public class app_attach_file_icon_music
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-10197008);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(68.0F, 87.0F);
      ((Path)localObject2).cubicTo(68.0F, 88.656853F, 66.656853F, 90.0F, 65.0F, 90.0F);
      ((Path)localObject2).lineTo(3.0F, 90.0F);
      ((Path)localObject2).cubicTo(1.343146F, 90.0F, 2.029061E-016F, 88.656853F, 0.0F, 87.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(68.0F, 22.0F);
      ((Path)localObject1).lineTo(49.0F, 22.0F);
      ((Path)localObject1).cubicTo(47.343147F, 22.0F, 46.0F, 20.656855F, 46.0F, 19.0F);
      ((Path)localObject1).lineTo(46.0F, 0.0F);
      ((Path)localObject1).lineTo(68.0F, 22.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(46.252487F, 44.839684F);
      ((Path)localObject1).lineTo(26.667143F, 48.85265F);
      ((Path)localObject1).lineTo(26.667143F, 66.858986F);
      ((Path)localObject1).lineTo(26.667143F, 68.571503F);
      ((Path)localObject1).cubicTo(26.667143F, 70.166306F, 25.580133F, 71.721336F, 24.118086F, 72.391304F);
      ((Path)localObject1).cubicTo(23.846298F, 72.515846F, 22.129362F, 72.892891F, 21.905174F, 72.937202F);
      ((Path)localObject1).cubicTo(19.751049F, 73.362991F, 18.095936F, 71.55011F, 18.004787F, 69.716888F);
      ((Path)localObject1).cubicTo(17.913637F, 67.883667F, 19.137239F, 66.355026F, 20.556929F, 66.074409F);
      ((Path)localObject1).lineTo(22.858772F, 65.619423F);
      ((Path)localObject1).cubicTo(24.065191F, 65.380959F, 24.934671F, 64.322792F, 24.934671F, 63.093029F);
      ((Path)localObject1).lineTo(24.934671F, 46.618843F);
      ((Path)localObject1).cubicTo(24.935736F, 46.618027F, 24.936798F, 46.617214F, 24.93786F, 46.616402F);
      ((Path)localObject1).lineTo(24.93786F, 45.481544F);
      ((Path)localObject1).cubicTo(24.93786F, 44.873074F, 25.365826F, 44.34853F, 25.961914F, 44.226395F);
      ((Path)localObject1).lineTo(46.461594F, 40.026085F);
      ((Path)localObject1).cubicTo(47.154797F, 39.884048F, 47.83189F, 40.330856F, 47.973923F, 41.024059F);
      ((Path)localObject1).cubicTo(47.991264F, 41.108688F, 48.0F, 41.194851F, 48.0F, 41.281239F);
      ((Path)localObject1).lineTo(48.0F, 44.020729F);
      ((Path)localObject1).lineTo(48.0F, 62.217106F);
      ((Path)localObject1).lineTo(48.0F, 63.929623F);
      ((Path)localObject1).cubicTo(48.0F, 65.524422F, 46.903553F, 67.07946F, 45.42881F, 67.74942F);
      ((Path)localObject1).cubicTo(45.154659F, 67.873962F, 43.422817F, 68.251015F, 43.196682F, 68.295326F);
      ((Path)localObject1).cubicTo(41.023853F, 68.721115F, 39.35437F, 66.908226F, 39.262428F, 65.075005F);
      ((Path)localObject1).cubicTo(39.170486F, 63.241783F, 40.404713F, 61.713146F, 41.836727F, 61.432526F);
      ((Path)localObject1).lineTo(44.172447F, 60.974819F);
      ((Path)localObject1).cubicTo(45.380814F, 60.738026F, 46.252487F, 59.678959F, 46.252487F, 58.447613F);
      ((Path)localObject1).lineTo(46.252487F, 44.839684F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_music
 * JD-Core Version:    0.7.0.1
 */