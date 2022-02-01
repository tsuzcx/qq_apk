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

public class error_offline_info
  extends c
{
  private final int height = 53;
  private final int width = 53;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 53;
      return 53;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.434783F, 0.0F, 1.0F, 0.391304F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16896);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(52.173912F, 26.27763F);
      ((Path)localObject2).cubicTo(52.173912F, 11.621121F, 40.494686F, 0.0F, 25.764894F, 0.0F);
      ((Path)localObject2).cubicTo(11.679227F, 0.0F, 0.0F, 11.621121F, 0.0F, 26.27763F);
      ((Path)localObject2).cubicTo(0.0F, 40.293221F, 11.679227F, 51.914341F, 25.764894F, 51.914341F);
      ((Path)localObject2).cubicTo(40.494686F, 51.914341F, 52.173912F, 40.293221F, 52.173912F, 26.27763F);
      ((Path)localObject2).lineTo(52.173912F, 26.27763F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(23.805798F, 13.323138F);
      ((Path)localObject1).lineTo(23.805798F, 13.323138F);
      ((Path)localObject1).cubicTo(23.804459F, 13.294402F, 23.803789F, 13.265638F, 23.803789F, 13.23687F);
      ((Path)localObject1).cubicTo(23.803789F, 12.213226F, 24.633615F, 11.383399F, 25.657259F, 11.383399F);
      ((Path)localObject1).lineTo(25.657259F, 11.383399F);
      ((Path)localObject1).lineTo(27.465271F, 11.383399F);
      ((Path)localObject1).cubicTo(27.494038F, 11.383399F, 27.522802F, 11.384069F, 27.551538F, 11.385408F);
      ((Path)localObject1).cubicTo(28.574074F, 11.433053F, 29.364378F, 12.300605F, 29.316732F, 13.323138F);
      ((Path)localObject1).lineTo(29.316732F, 13.323138F);
      ((Path)localObject1).lineTo(28.500492F, 30.840899F);
      ((Path)localObject1).cubicTo(28.47699F, 31.345303F, 28.061199F, 31.74217F, 27.556248F, 31.74217F);
      ((Path)localObject1).lineTo(27.556248F, 31.74217F);
      ((Path)localObject1).lineTo(25.566282F, 31.74217F);
      ((Path)localObject1).cubicTo(25.061331F, 31.74217F, 24.64554F, 31.345303F, 24.622036F, 30.840899F);
      ((Path)localObject1).lineTo(23.805798F, 13.323138F);
      ((Path)localObject1).lineTo(23.805798F, 13.323138F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(26.561264F, 40.790512F);
      ((Path)localObject1).cubicTo(24.989546F, 40.790512F, 23.715414F, 39.524551F, 23.715414F, 37.962906F);
      ((Path)localObject1).cubicTo(23.715414F, 36.401264F, 24.989546F, 35.1353F, 26.561264F, 35.1353F);
      ((Path)localObject1).cubicTo(28.132984F, 35.1353F, 29.407114F, 36.401264F, 29.407114F, 37.962906F);
      ((Path)localObject1).cubicTo(29.407114F, 39.524551F, 28.132984F, 40.790512F, 26.561264F, 40.790512F);
      ((Path)localObject1).lineTo(26.561264F, 40.790512F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.error_offline_info
 * JD-Core Version:    0.7.0.1
 */