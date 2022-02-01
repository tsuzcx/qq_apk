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

public class fav_capacity_foot_arrow
  extends c
{
  private final int height = 30;
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
      return 30;
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(22.0F, 14.999688F);
      ((Path)localObject2).lineTo(7.130435F, 29.999374F);
      ((Path)localObject2).lineTo(3.826087F, 26.666111F);
      ((Path)localObject2).lineTo(15.391304F, 14.999688F);
      ((Path)localObject2).lineTo(3.0F, 3.333264F);
      ((Path)localObject2).lineTo(6.304348F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      ((Canvas)localObject1).saveLayerAlpha(null, 51, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      ((Canvas)localObject1).drawPath((Path)localObject2, localPaint);
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 30.0F);
      ((Path)localObject1).lineTo(0.0F, 30.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fav_capacity_foot_arrow
 * JD-Core Version:    0.7.0.1
 */