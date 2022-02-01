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

public class float_ball_icon_topstory_default
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.333333F, 0.0F, 1.0F, 5.333333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.393916F, 15.901952F);
      ((Path)localObject2).lineTo(6.260816F, 18.81208F);
      ((Path)localObject2).lineTo(4.538635F, 12.446175F);
      ((Path)localObject2).cubicTo(4.254392F, 11.387946F, 4.88976F, 10.296648F, 5.959852F, 10.015556F);
      ((Path)localObject2).lineTo(12.380408F, 8.31247F);
      ((Path)localObject2).lineTo(12.397128F, 14.165795F);
      ((Path)localObject2).cubicTo(12.397128F, 14.876793F, 12.012564F, 15.538185F, 11.393916F, 15.901952F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.397128F, 23.44183F);
      ((Path)localObject2).lineTo(12.380408F, 29.295155F);
      ((Path)localObject2).lineTo(5.959852F, 27.592068F);
      ((Path)localObject2).cubicTo(4.88976F, 27.310976F, 4.254392F, 26.219679F, 4.538635F, 25.161449F);
      ((Path)localObject2).lineTo(6.260816F, 18.81208F);
      ((Path)localObject2).lineTo(11.393916F, 21.722208F);
      ((Path)localObject2).cubicTo(12.012564F, 22.069439F, 12.397128F, 22.730831F, 12.397128F, 23.44183F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(19.519934F, 26.351957F);
      ((Path)localObject2).lineTo(24.636312F, 29.295155F);
      ((Path)localObject2).lineTo(19.921217F, 33.941437F);
      ((Path)localObject2).cubicTo(19.135368F, 34.718575F, 17.864634F, 34.718575F, 17.078783F, 33.941437F);
      ((Path)localObject2).lineTo(12.380408F, 29.295155F);
      ((Path)localObject2).lineTo(17.496788F, 26.351957F);
      ((Path)localObject2).cubicTo(18.115437F, 25.988192F, 18.884565F, 25.988192F, 19.519934F, 26.351957F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.606085F, 21.705673F);
      ((Path)localObject2).lineTo(30.739185F, 18.795546F);
      ((Path)localObject2).lineTo(32.461365F, 25.144915F);
      ((Path)localObject2).cubicTo(32.745609F, 26.203144F, 32.110241F, 27.294441F, 31.04015F, 27.575533F);
      ((Path)localObject2).lineTo(24.619593F, 29.27862F);
      ((Path)localObject2).lineTo(24.602873F, 23.425295F);
      ((Path)localObject2).cubicTo(24.602873F, 22.730831F, 24.987438F, 22.069439F, 25.606085F, 21.705673F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.602873F, 14.165795F);
      ((Path)localObject2).lineTo(24.619593F, 8.31247F);
      ((Path)localObject2).lineTo(31.04015F, 10.015556F);
      ((Path)localObject2).cubicTo(32.110241F, 10.296648F, 32.745609F, 11.387946F, 32.461365F, 12.446175F);
      ((Path)localObject2).lineTo(30.739185F, 18.795546F);
      ((Path)localObject2).lineTo(25.606085F, 15.885417F);
      ((Path)localObject2).cubicTo(24.987438F, 15.538185F, 24.602873F, 14.876793F, 24.602873F, 14.165795F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.496788F, 11.255668F);
      ((Path)localObject2).lineTo(12.380408F, 8.31247F);
      ((Path)localObject2).lineTo(17.078783F, 3.666186F);
      ((Path)localObject2).cubicTo(17.864634F, 2.889049F, 19.135368F, 2.889049F, 19.921217F, 3.666186F);
      ((Path)localObject2).lineTo(24.619593F, 8.31247F);
      ((Path)localObject2).lineTo(19.503212F, 11.255668F);
      ((Path)localObject2).cubicTo(18.884565F, 11.619433F, 18.115437F, 11.619433F, 17.496788F, 11.255668F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.float_ball_icon_topstory_default
 * JD-Core Version:    0.7.0.1
 */