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

public class app_brand_profile_preview_video_play_btn
  extends c
{
  private final int height = 45;
  private final int width = 45;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 45;
      return 45;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      Paint localPaint2 = c.instancePaint((Paint)localObject, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject).setColor(1275068416);
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(2.3F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(22.5F, 1.15F);
      localPath.cubicTo(34.291279F, 1.15F, 43.849998F, 10.70872F, 43.849998F, 22.5F);
      localPath.cubicTo(43.849998F, 34.291279F, 34.291279F, 43.849998F, 22.5F, 43.849998F);
      localPath.cubicTo(10.70872F, 43.849998F, 1.15F, 34.291279F, 1.15F, 22.5F);
      localPath.cubicTo(1.15F, 10.70872F, 10.70872F, 1.15F, 22.5F, 1.15F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(29.748446F, 23.296038F);
      ((Path)localObject).lineTo(19.473919F, 30.033487F);
      ((Path)localObject).cubicTo(19.034281F, 30.321777F, 18.444176F, 30.199085F, 18.155884F, 29.759445F);
      ((Path)localObject).cubicTo(18.05418F, 29.604349F, 18.0F, 29.422918F, 18.0F, 29.23745F);
      ((Path)localObject).lineTo(18.0F, 15.762551F);
      ((Path)localObject).cubicTo(18.0F, 15.236818F, 18.426191F, 14.810628F, 18.951923F, 14.810628F);
      ((Path)localObject).cubicTo(19.137392F, 14.810628F, 19.318823F, 14.864809F, 19.473919F, 14.966513F);
      ((Path)localObject).lineTo(29.748446F, 21.703962F);
      ((Path)localObject).cubicTo(30.188086F, 21.992252F, 30.310778F, 22.582357F, 30.022488F, 23.021997F);
      ((Path)localObject).cubicTo(29.950897F, 23.131168F, 29.857618F, 23.224449F, 29.748446F, 23.296038F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_profile_preview_video_play_btn
 * JD-Core Version:    0.7.0.1
 */