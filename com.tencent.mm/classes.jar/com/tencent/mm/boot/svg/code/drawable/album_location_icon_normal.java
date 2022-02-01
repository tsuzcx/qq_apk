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

public class album_location_icon_normal
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.06519F, 21.243166F);
      localPath.cubicTo(12.06301F, 21.241201F, 12.060856F, 21.239325F, 12.058728F, 21.237535F);
      localPath.lineTo(12.06519F, 21.243166F);
      localPath.close();
      localPath.moveTo(12.246837F, 20.968607F);
      localPath.cubicTo(12.482933F, 20.755777F, 12.747323F, 20.507811F, 13.032845F, 20.227892F);
      localPath.cubicTo(13.850634F, 19.426147F, 14.668892F, 18.533524F, 15.430166F, 17.57688F);
      localPath.cubicTo(17.469343F, 15.014377F, 18.711391F, 12.487102F, 18.795486F, 10.239681F);
      localPath.cubicTo(18.798492F, 10.159331F, 18.799999F, 10.079436F, 18.799999F, 10.0F);
      localPath.cubicTo(18.799999F, 6.244464F, 15.755536F, 3.2F, 12.0F, 3.2F);
      localPath.cubicTo(8.244464F, 3.2F, 5.2F, 6.244464F, 5.2F, 10.0F);
      localPath.cubicTo(5.2F, 10.079436F, 5.201507F, 10.159331F, 5.204514F, 10.239681F);
      localPath.cubicTo(5.288608F, 12.487102F, 6.530657F, 15.014377F, 8.569834F, 17.57688F);
      localPath.cubicTo(9.331108F, 18.533524F, 10.149366F, 19.426147F, 10.967155F, 20.227892F);
      localPath.cubicTo(11.252677F, 20.507811F, 11.517067F, 20.755777F, 11.753163F, 20.968607F);
      localPath.cubicTo(11.863493F, 21.068064F, 11.946972F, 21.141392F, 12.0F, 21.187016F);
      localPath.cubicTo(12.053028F, 21.141392F, 12.136507F, 21.068064F, 12.246837F, 20.968607F);
      localPath.close();
      localPath.moveTo(12.03476F, 21.21665F);
      localPath.cubicTo(12.025222F, 21.208614F, 12.013615F, 21.198729F, 12.0F, 21.187016F);
      localPath.cubicTo(11.986385F, 21.198729F, 11.974778F, 21.208614F, 11.96524F, 21.21665F);
      localPath.cubicTo(11.981144F, 21.20063F, 12.014057F, 21.199963F, 12.058728F, 21.237535F);
      localPath.lineTo(12.03476F, 21.21665F);
      localPath.close();
      localPath.moveTo(11.261719F, 22.134476F);
      localPath.cubicTo(11.261719F, 22.134476F, 4.0F, 16.018278F, 4.0F, 10.0F);
      localPath.cubicTo(4.0F, 5.581722F, 7.581722F, 2.0F, 12.0F, 2.0F);
      localPath.cubicTo(16.418278F, 2.0F, 20.0F, 5.581722F, 20.0F, 10.0F);
      localPath.cubicTo(20.0F, 16.018278F, 12.738281F, 22.134476F, 12.738281F, 22.134476F);
      localPath.cubicTo(12.333565F, 22.50602F, 11.66946F, 22.502035F, 11.261719F, 22.134476F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 12.0F);
      ((Path)localObject).cubicTo(13.104569F, 12.0F, 14.0F, 11.104569F, 14.0F, 10.0F);
      ((Path)localObject).cubicTo(14.0F, 8.895431F, 13.104569F, 8.0F, 12.0F, 8.0F);
      ((Path)localObject).cubicTo(10.895431F, 8.0F, 10.0F, 8.895431F, 10.0F, 10.0F);
      ((Path)localObject).cubicTo(10.0F, 11.104569F, 10.895431F, 12.0F, 12.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 13.2F);
      ((Path)localObject).cubicTo(10.232689F, 13.2F, 8.8F, 11.767311F, 8.8F, 10.0F);
      ((Path)localObject).cubicTo(8.8F, 8.232689F, 10.232689F, 6.8F, 12.0F, 6.8F);
      ((Path)localObject).cubicTo(13.767311F, 6.8F, 15.2F, 8.232689F, 15.2F, 10.0F);
      ((Path)localObject).cubicTo(15.2F, 11.767311F, 13.767311F, 13.2F, 12.0F, 13.2F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_location_icon_normal
 * JD-Core Version:    0.7.0.1
 */