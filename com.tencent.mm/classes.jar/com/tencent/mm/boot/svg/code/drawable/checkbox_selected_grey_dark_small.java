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

public class checkbox_selected_grey_dark_small
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16631268);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(60.0F, 30.370371F);
      localPath.cubicTo(60.0F, 13.431111F, 46.56889F, 0.0F, 29.629629F, 0.0F);
      localPath.cubicTo(13.431111F, 0.0F, 0.0F, 13.431111F, 0.0F, 30.370371F);
      localPath.cubicTo(0.0F, 46.56889F, 13.431111F, 60.0F, 29.629629F, 60.0F);
      localPath.cubicTo(46.56889F, 60.0F, 60.0F, 46.56889F, 60.0F, 30.370371F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(25.909903F, 38.284271F);
      ((Path)localObject).lineTo(17.651649F, 30.02602F);
      ((Path)localObject).lineTo(15.0F, 32.67767F);
      ((Path)localObject).lineTo(24.142136F, 41.819805F);
      ((Path)localObject).cubicTo(25.118446F, 42.796116F, 26.701359F, 42.796116F, 27.67767F, 41.819805F);
      ((Path)localObject).lineTo(46.845825F, 22.651649F);
      ((Path)localObject).lineTo(46.845825F, 22.651649F);
      ((Path)localObject).lineTo(44.194172F, 20.0F);
      ((Path)localObject).lineTo(25.909903F, 38.284271F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.checkbox_selected_grey_dark_small
 * JD-Core Version:    0.7.0.1
 */