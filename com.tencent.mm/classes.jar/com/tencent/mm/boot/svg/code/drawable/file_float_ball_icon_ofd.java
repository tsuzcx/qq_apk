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

public class file_float_ball_icon_ofd
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      ((Paint)localObject).setColor(-9132032);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(13.305084F, 30.0F);
      ((Path)localObject).cubicTo(16.864407F, 30.0F, 19.101694F, 27.698189F, 19.101694F, 24.004025F);
      ((Path)localObject).cubicTo(19.101694F, 20.309858F, 16.864407F, 18.0F, 13.305084F, 18.0F);
      ((Path)localObject).cubicTo(9.737289F, 18.0F, 7.5F, 20.309858F, 7.5F, 24.004025F);
      ((Path)localObject).cubicTo(7.5F, 27.698189F, 9.737289F, 30.0F, 13.305084F, 30.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.305084F, 28.229376F);
      ((Path)localObject).cubicTo(11.118644F, 28.229376F, 9.737289F, 26.587524F, 9.737289F, 24.004025F);
      ((Path)localObject).cubicTo(9.737289F, 21.412476F, 11.118644F, 19.770624F, 13.305084F, 19.770624F);
      ((Path)localObject).cubicTo(15.48305F, 19.770624F, 16.872881F, 21.412476F, 16.872881F, 24.004025F);
      ((Path)localObject).cubicTo(16.872881F, 26.587524F, 15.48305F, 28.229376F, 13.305084F, 28.229376F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(23.025423F, 29.806841F);
      ((Path)localObject).lineTo(23.025423F, 25.066399F);
      ((Path)localObject).lineTo(28.152542F, 25.066399F);
      ((Path)localObject).lineTo(28.152542F, 23.376257F);
      ((Path)localObject).lineTo(23.025423F, 23.376257F);
      ((Path)localObject).lineTo(23.025423F, 19.947685F);
      ((Path)localObject).lineTo(28.635593F, 19.947685F);
      ((Path)localObject).lineTo(28.635593F, 18.193159F);
      ((Path)localObject).lineTo(20.838984F, 18.193159F);
      ((Path)localObject).lineTo(20.838984F, 29.806841F);
      ((Path)localObject).lineTo(23.025423F, 29.806841F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.68644F, 29.806841F);
      ((Path)localObject).cubicTo(38.347458F, 29.806841F, 40.5F, 27.649899F, 40.5F, 23.97183F);
      ((Path)localObject).cubicTo(40.5F, 20.293762F, 38.338982F, 18.193159F, 34.68644F, 18.193159F);
      ((Path)localObject).lineTo(30.220339F, 18.193159F);
      ((Path)localObject).lineTo(30.220339F, 29.806841F);
      ((Path)localObject).lineTo(34.68644F, 29.806841F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.457626F, 28.052315F);
      ((Path)localObject).lineTo(32.40678F, 28.052315F);
      ((Path)localObject).lineTo(32.40678F, 19.947685F);
      ((Path)localObject).lineTo(34.457626F, 19.947685F);
      ((Path)localObject).cubicTo(36.898304F, 19.947685F, 38.271187F, 21.380281F, 38.271187F, 23.979879F);
      ((Path)localObject).cubicTo(38.271187F, 26.627766F, 36.915253F, 28.052315F, 34.457626F, 28.052315F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.file_float_ball_icon_ofd
 * JD-Core Version:    0.7.0.1
 */