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

public class hld_icon
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      ((Paint)localObject).setColor(-16268960);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 192.0F);
      localPath.lineTo(192.0F, 192.0F);
      localPath.lineTo(192.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(95.839996F, 43.200001F);
      ((Path)localObject).cubicTo(124.91184F, 43.200001F, 148.48F, 64.844002F, 148.48F, 91.542557F);
      ((Path)localObject).cubicTo(148.48F, 118.24112F, 124.91184F, 139.884F, 95.839996F, 139.884F);
      ((Path)localObject).cubicTo(92.924637F, 139.884F, 90.070877F, 139.65776F, 87.285439F, 139.23776F);
      ((Path)localObject).cubicTo(86.418556F, 139.10672F, 85.534882F, 139.25232F, 84.768799F, 139.68016F);
      ((Path)localObject).lineTo(84.768799F, 139.68016F);
      ((Path)localObject).lineTo(67.870239F, 149.10497F);
      ((Path)localObject).cubicTo(65.391678F, 150.48705F, 62.22768F, 148.81039F, 62.292641F, 146.14703F);
      ((Path)localObject).lineTo(62.292641F, 146.14703F);
      ((Path)localObject).lineTo(62.649921F, 131.34848F);
      ((Path)localObject).cubicTo(62.683521F, 129.97871F, 62.096642F, 128.66048F, 61.032639F, 127.79808F);
      ((Path)localObject).cubicTo(50.100319F, 118.94F, 43.200001F, 105.98384F, 43.200001F, 91.542557F);
      ((Path)localObject).cubicTo(43.200001F, 64.844002F, 66.768158F, 43.200001F, 95.839996F, 43.200001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(110.66914F, 69.80056F);
      ((Path)localObject).lineTo(104.16081F, 69.80056F);
      ((Path)localObject).lineTo(104.9045F, 71.128883F);
      ((Path)localObject).cubicTo(107.66081F, 76.04792F, 110.44514F, 83.926003F, 110.44514F, 90.438797F);
      ((Path)localObject).cubicTo(110.44514F, 97.279762F, 107.64513F, 105.68872F, 104.87202F, 110.4588F);
      ((Path)localObject).lineTo(104.09586F, 111.80056F);
      ((Path)localObject).lineTo(110.63106F, 111.80056F);
      ((Path)localObject).lineTo(110.86066F, 111.44216F);
      ((Path)localObject).cubicTo(114.91842F, 105.0828F, 117.01842F, 98.021202F, 117.11697F, 90.451118F);
      ((Path)localObject).cubicTo(117.23682F, 81.028557F, 113.62257F, 74.354477F, 110.89874F, 70.152237F);
      ((Path)localObject).lineTo(110.66914F, 69.80056F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(87.440002F, 99.200447F);
      ((Path)localObject).lineTo(79.040001F, 99.200447F);
      ((Path)localObject).lineTo(79.040001F, 107.60045F);
      ((Path)localObject).lineTo(87.440002F, 107.60045F);
      ((Path)localObject).lineTo(87.440002F, 99.200447F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(87.440002F, 74.00045F);
      ((Path)localObject).lineTo(79.040001F, 74.00045F);
      ((Path)localObject).lineTo(79.040001F, 82.400452F);
      ((Path)localObject).lineTo(87.440002F, 82.400452F);
      ((Path)localObject).lineTo(87.440002F, 74.00045F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.hld_icon
 * JD-Core Version:    0.7.0.1
 */