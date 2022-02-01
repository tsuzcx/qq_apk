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

public class icon_filled_switch_camera
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(14.732409F, 4.0F);
      ((Path)localObject).cubicTo(14.899585F, 4.0F, 15.0557F, 4.083551F, 15.148434F, 4.22265F);
      ((Path)localObject).lineTo(17.0F, 7.0F);
      ((Path)localObject).lineTo(21.0F, 7.0F);
      ((Path)localObject).cubicTo(21.552284F, 7.0F, 22.0F, 7.447715F, 22.0F, 8.0F);
      ((Path)localObject).lineTo(22.0F, 19.0F);
      ((Path)localObject).cubicTo(22.0F, 19.552284F, 21.552284F, 20.0F, 21.0F, 20.0F);
      ((Path)localObject).lineTo(3.0F, 20.0F);
      ((Path)localObject).cubicTo(2.447715F, 20.0F, 2.0F, 19.552284F, 2.0F, 19.0F);
      ((Path)localObject).lineTo(2.0F, 8.0F);
      ((Path)localObject).cubicTo(2.0F, 7.447715F, 2.447715F, 7.0F, 3.0F, 7.0F);
      ((Path)localObject).lineTo(7.0F, 7.0F);
      ((Path)localObject).lineTo(8.851566F, 4.22265F);
      ((Path)localObject).cubicTo(8.9443F, 4.083551F, 9.100415F, 4.0F, 9.267592F, 4.0F);
      ((Path)localObject).lineTo(14.732409F, 4.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.0F, 12.0F);
      ((Path)localObject).lineTo(6.0F, 14.0F);
      ((Path)localObject).lineTo(7.409008F, 14.000028F);
      ((Path)localObject).cubicTo(7.865604F, 16.059689F, 9.702923F, 17.6F, 11.9F, 17.6F);
      ((Path)localObject).cubicTo(13.146032F, 17.6F, 14.312778F, 17.101137F, 15.168172F, 16.237185F);
      ((Path)localObject).lineTo(15.335031F, 16.059566F);
      ((Path)localObject).lineTo(14.439188F, 15.261151F);
      ((Path)localObject).lineTo(14.297587F, 15.410781F);
      ((Path)localObject).cubicTo(13.666547F, 16.038834F, 12.813014F, 16.4F, 11.9F, 16.4F);
      ((Path)localObject).cubicTo(10.43684F, 16.4F, 9.189546F, 15.475769F, 8.710076F, 14.179267F);
      ((Path)localObject).lineTo(8.649506F, 14.000216F);
      ((Path)localObject).lineTo(10.0F, 14.0F);
      ((Path)localObject).lineTo(8.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 8.4F);
      ((Path)localObject).cubicTo(10.753968F, 8.4F, 9.587222F, 8.898863F, 8.731828F, 9.762816F);
      ((Path)localObject).lineTo(8.56497F, 9.940434F);
      ((Path)localObject).lineTo(9.460812F, 10.738849F);
      ((Path)localObject).lineTo(9.602413F, 10.589219F);
      ((Path)localObject).cubicTo(10.233454F, 9.961165F, 11.086987F, 9.6F, 12.0F, 9.6F);
      ((Path)localObject).cubicTo(13.46281F, 9.6F, 14.709857F, 10.523788F, 15.189579F, 11.819803F);
      ((Path)localObject).lineTo(15.250188F, 11.998787F);
      ((Path)localObject).lineTo(14.0F, 12.0F);
      ((Path)localObject).lineTo(16.0F, 14.0F);
      ((Path)localObject).lineTo(18.0F, 12.0F);
      ((Path)localObject).lineTo(16.49077F, 11.998976F);
      ((Path)localObject).cubicTo(16.033802F, 9.939815F, 14.196723F, 8.4F, 12.0F, 8.4F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_switch_camera
 * JD-Core Version:    0.7.0.1
 */