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

public class icons_outlined_accounts
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      Paint localPaint2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      Paint localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setStrokeWidth(0.6F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(36.0F, 61.650002F);
      localPath.cubicTo(50.166103F, 61.650002F, 61.650002F, 50.166103F, 61.650002F, 36.0F);
      localPath.cubicTo(61.650002F, 21.833897F, 50.166103F, 10.35F, 36.0F, 10.35F);
      localPath.cubicTo(21.833897F, 10.35F, 10.35F, 21.833897F, 10.35F, 36.0F);
      localPath.cubicTo(10.35F, 50.166103F, 21.833897F, 61.650002F, 36.0F, 61.650002F);
      localPath.close();
      localPath.moveTo(36.0F, 66.0F);
      localPath.cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      localPath.cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      localPath.cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      localPath.cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.2F);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 19.0F, 0.0F, 1.0F, 22.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.125F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(32.509991F, 16.8125F);
      ((Path)localObject3).cubicTo(33.027756F, 16.8125F, 33.447491F, 17.232233F, 33.447491F, 17.75F);
      ((Path)localObject3).cubicTo(33.447491F, 18.04381F, 33.30975F, 18.320625F, 33.075386F, 18.49782F);
      ((Path)localObject3).lineTo(21.601154F, 27.173014F);
      ((Path)localObject3).cubicTo(21.270746F, 27.422821F, 20.80039F, 27.357483F, 20.550583F, 27.027075F);
      ((Path)localObject3).cubicTo(20.404402F, 26.833731F, 20.360674F, 26.581659F, 20.433189F, 26.350376F);
      ((Path)localObject3).lineTo(22.2479F, 20.5625F);
      ((Path)localObject3).lineTo(0.9375F, 20.5625F);
      ((Path)localObject3).lineTo(0.9375F, 16.8125F);
      ((Path)localObject3).lineTo(32.509991F, 16.8125F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(13.197369F, 0.9729251F);
      ((Path)localObject3).cubicTo(13.343549F, 1.16627F, 13.387278F, 1.41834F, 13.314762F, 1.649624F);
      ((Path)localObject3).lineTo(11.500051F, 7.4375F);
      ((Path)localObject3).lineTo(32.8125F, 7.4375F);
      ((Path)localObject3).lineTo(32.8125F, 11.1875F);
      ((Path)localObject3).lineTo(1.237962F, 11.1875F);
      ((Path)localObject3).cubicTo(0.7201953F, 11.1875F, 0.3004623F, 10.767767F, 0.3004623F, 10.25F);
      ((Path)localObject3).cubicTo(0.3004623F, 9.95619F, 0.4382023F, 9.679374F, 0.6725667F, 9.50218F);
      ((Path)localObject3).lineTo(12.146797F, 0.826986F);
      ((Path)localObject3).cubicTo(12.477204F, 0.5771785F, 12.947561F, 0.6425176F, 13.197369F, 0.9729251F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_accounts
 * JD-Core Version:    0.7.0.1
 */