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

public class ad_living_description_icon
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-40634);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(36.0F, 71.0F);
      localPath.cubicTo(55.330002F, 71.0F, 71.0F, 55.330002F, 71.0F, 36.0F);
      localPath.cubicTo(71.0F, 16.67F, 55.330002F, 1.0F, 36.0F, 1.0F);
      localPath.cubicTo(16.67F, 1.0F, 1.0F, 16.67F, 1.0F, 36.0F);
      localPath.cubicTo(1.0F, 55.330002F, 16.67F, 71.0F, 36.0F, 71.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.416599F, 27.493099F);
      ((Path)localObject).lineTo(27.493F, 27.493099F);
      ((Path)localObject).lineTo(27.493F, 44.507F);
      ((Path)localObject).lineTo(21.416599F, 44.507F);
      ((Path)localObject).cubicTo(20.074301F, 44.507F, 18.986099F, 43.4188F, 18.986099F, 42.076401F);
      ((Path)localObject).lineTo(18.986099F, 29.9237F);
      ((Path)localObject).cubicTo(18.986099F, 28.581301F, 20.074301F, 27.493099F, 21.416599F, 27.493099F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(29.923599F, 27.493099F);
      ((Path)localObject).lineTo(47.665699F, 19.731001F);
      ((Path)localObject).cubicTo(48.280602F, 19.462F, 48.997101F, 19.742399F, 49.266102F, 20.357201F);
      ((Path)localObject).cubicTo(49.333302F, 20.510799F, 49.368F, 20.676701F, 49.368F, 20.8444F);
      ((Path)localObject).lineTo(49.368F, 51.155701F);
      ((Path)localObject).cubicTo(49.368F, 51.827F, 48.824001F, 52.370998F, 48.152802F, 52.370998F);
      ((Path)localObject).cubicTo(47.9851F, 52.370998F, 47.819302F, 52.3363F, 47.665699F, 52.2691F);
      ((Path)localObject).lineTo(29.923599F, 44.507F);
      ((Path)localObject).lineTo(29.923599F, 27.493099F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ad_living_description_icon
 * JD-Core Version:    0.7.0.1
 */