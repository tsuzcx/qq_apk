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

public class media_player_pause_btn
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
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      ((Canvas)localObject1).save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.0F, 15.150418F);
      localPath.lineTo(25.5F, 15.150418F);
      localPath.lineTo(25.5F, 56.832439F);
      localPath.lineTo(21.0F, 56.832439F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      ((Canvas)localObject1).drawPath(localPath, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(45.0F, 15.150418F);
      ((Path)localObject2).lineTo(49.5F, 15.150418F);
      ((Path)localObject2).lineTo(49.5F, 56.832439F);
      ((Path)localObject2).lineTo(45.0F, 56.832439F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      ((Canvas)localObject1).drawPath((Path)localObject2, localPaint);
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(72.0F, 0.0F);
      ((Path)localObject1).lineTo(72.0F, 72.0F);
      ((Path)localObject1).lineTo(0.0F, 72.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.media_player_pause_btn
 * JD-Core Version:    0.7.0.1
 */