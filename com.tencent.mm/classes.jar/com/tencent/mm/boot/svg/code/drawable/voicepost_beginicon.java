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

public class voicepost_beginicon
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
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-15028967);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(29.278912F, 21.516287F);
      localPath.lineTo(52.241261F, 35.468605F);
      localPath.cubicTo(52.949238F, 35.898785F, 53.174438F, 36.821449F, 52.744259F, 37.52943F);
      localPath.cubicTo(52.61935F, 37.735001F, 52.446831F, 37.90752F, 52.241261F, 38.032429F);
      localPath.lineTo(29.278912F, 51.984749F);
      localPath.cubicTo(28.57093F, 52.414928F, 27.64827F, 52.189728F, 27.218088F, 51.481747F);
      localPath.cubicTo(27.075439F, 51.246979F, 27.0F, 50.977547F, 27.0F, 50.702835F);
      localPath.lineTo(27.0F, 22.798197F);
      localPath.cubicTo(27.0F, 21.96977F, 27.671574F, 21.298197F, 28.5F, 21.298197F);
      localPath.cubicTo(28.77471F, 21.298197F, 29.044144F, 21.373636F, 29.278912F, 21.516287F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localPaint.setStrokeWidth(3.6F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 1.799999F);
      ((Path)localObject).cubicTo(54.888138F, 1.799999F, 70.199997F, 17.11186F, 70.199997F, 36.0F);
      ((Path)localObject).cubicTo(70.199997F, 54.888138F, 54.888138F, 70.199997F, 36.0F, 70.199997F);
      ((Path)localObject).cubicTo(17.11186F, 70.199997F, 1.799999F, 54.888138F, 1.799999F, 36.0F);
      ((Path)localObject).cubicTo(1.799999F, 17.11186F, 17.11186F, 1.799999F, 36.0F, 1.799999F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voicepost_beginicon
 * JD-Core Version:    0.7.0.1
 */