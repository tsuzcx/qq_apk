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

public class new_biz_info_message_music_icon
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
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, -276.0F, 0.0F, 1.0F, -265.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 276.0F, 0.0F, 1.0F, 265.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(838860800);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(45.0F, 0.0F);
      ((Path)localObject3).cubicTo(69.852814F, 0.0F, 90.0F, 20.147184F, 90.0F, 45.0F);
      ((Path)localObject3).cubicTo(90.0F, 69.852814F, 69.852814F, 90.0F, 45.0F, 90.0F);
      ((Path)localObject3).cubicTo(20.147184F, 90.0F, 0.0F, 69.852814F, 0.0F, 45.0F);
      ((Path)localObject3).cubicTo(0.0F, 20.147184F, 20.147184F, 0.0F, 45.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(45.0F, 3.0F);
      ((Path)localObject2).cubicTo(68.195961F, 3.0F, 87.0F, 21.804039F, 87.0F, 45.0F);
      ((Path)localObject2).cubicTo(87.0F, 68.195961F, 68.195961F, 87.0F, 45.0F, 87.0F);
      ((Path)localObject2).cubicTo(21.804039F, 87.0F, 3.0F, 68.195961F, 3.0F, 45.0F);
      ((Path)localObject2).cubicTo(3.0F, 21.804039F, 21.804039F, 3.0F, 45.0F, 3.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(59.248722F, 48.12048F);
      ((Path)localObject1).lineTo(39.167625F, 62.609314F);
      ((Path)localObject1).cubicTo(38.27261F, 63.255081F, 37.023556F, 63.053024F, 36.377789F, 62.158009F);
      ((Path)localObject1).cubicTo(36.132179F, 61.817604F, 36.0F, 61.408504F, 36.0F, 60.988743F);
      ((Path)localObject1).lineTo(36.0F, 32.011078F);
      ((Path)localObject1).cubicTo(36.0F, 30.907413F, 36.894695F, 30.012718F, 37.998356F, 30.012718F);
      ((Path)localObject1).cubicTo(38.418118F, 30.012718F, 38.827221F, 30.144899F, 39.167625F, 30.390507F);
      ((Path)localObject1).lineTo(59.248722F, 44.879341F);
      ((Path)localObject1).cubicTo(60.143742F, 45.525108F, 60.345795F, 46.774162F, 59.700027F, 47.669178F);
      ((Path)localObject1).cubicTo(59.574741F, 47.842819F, 59.422363F, 47.995193F, 59.248722F, 48.12048F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.new_biz_info_message_music_icon
 * JD-Core Version:    0.7.0.1
 */