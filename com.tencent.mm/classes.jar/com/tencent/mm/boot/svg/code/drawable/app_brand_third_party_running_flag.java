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

public class app_brand_third_party_running_flag
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(16777215);
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(1.2F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(14.72445F, 3.0F);
      localPath.cubicTo(16.5315F, 3.0F, 17.434799F, 3.0F, 18.407551F, 3.3075F);
      localPath.cubicTo(19.469549F, 3.69405F, 20.30595F, 4.53045F, 20.692499F, 5.59245F);
      localPath.cubicTo(21.0F, 6.56505F, 21.0F, 7.46865F, 21.0F, 9.27555F);
      localPath.lineTo(21.0F, 14.72445F);
      localPath.cubicTo(21.0F, 16.5315F, 21.0F, 17.434799F, 20.692499F, 18.407551F);
      localPath.cubicTo(20.30595F, 19.469549F, 19.469549F, 20.30595F, 18.407551F, 20.69235F);
      localPath.cubicTo(17.434799F, 21.0F, 16.5315F, 21.0F, 14.72445F, 21.0F);
      localPath.lineTo(9.27555F, 21.0F);
      localPath.cubicTo(7.4685F, 21.0F, 6.56505F, 21.0F, 5.59245F, 20.69235F);
      localPath.cubicTo(4.53045F, 20.30595F, 3.69405F, 19.469549F, 3.3075F, 18.407551F);
      localPath.cubicTo(3.0F, 17.434799F, 3.0F, 16.5315F, 3.0F, 14.72445F);
      localPath.lineTo(3.0F, 9.27555F);
      localPath.cubicTo(3.0F, 7.46865F, 3.0F, 6.56505F, 3.3075F, 5.59245F);
      localPath.cubicTo(3.69405F, 4.53045F, 4.53045F, 3.69405F, 5.59245F, 3.3075F);
      localPath.cubicTo(6.56505F, 3.0F, 7.4685F, 3.0F, 9.27555F, 3.0F);
      localPath.lineTo(14.72445F, 3.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_third_party_running_flag
 * JD-Core Version:    0.7.0.1
 */