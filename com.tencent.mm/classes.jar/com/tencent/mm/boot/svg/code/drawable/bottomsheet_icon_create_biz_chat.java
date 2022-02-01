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

public class bottomsheet_icon_create_biz_chat
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint.setColor(-8617851);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(81.0F, 60.0F);
      ((Path)localObject).lineTo(72.0F, 60.0F);
      ((Path)localObject).lineTo(72.0F, 68.0F);
      ((Path)localObject).lineTo(64.0F, 68.0F);
      ((Path)localObject).lineTo(64.0F, 77.0F);
      ((Path)localObject).lineTo(72.0F, 77.0F);
      ((Path)localObject).lineTo(72.0F, 85.0F);
      ((Path)localObject).lineTo(81.0F, 85.0F);
      ((Path)localObject).lineTo(81.0F, 77.0F);
      ((Path)localObject).lineTo(89.0F, 77.0F);
      ((Path)localObject).lineTo(89.0F, 68.0F);
      ((Path)localObject).lineTo(81.0F, 68.0F);
      ((Path)localObject).lineTo(81.0F, 60.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.0F, 66.0F);
      ((Path)localObject).lineTo(27.0F, 69.0F);
      ((Path)localObject).lineTo(28.0F, 64.0F);
      ((Path)localObject).cubicTo(20.127745F, 59.652744F, 15.2F, 52.282616F, 15.0F, 44.0F);
      ((Path)localObject).cubicTo(15.2F, 30.296667F, 28.315445F, 19.235294F, 48.0F, 19.0F);
      ((Path)localObject).cubicTo(67.684555F, 19.235294F, 80.800003F, 30.296667F, 81.0F, 44.0F);
      ((Path)localObject).cubicTo(80.800003F, 46.829475F, 80.203674F, 49.600197F, 79.0F, 52.0F);
      ((Path)localObject).lineTo(88.0F, 52.0F);
      ((Path)localObject).cubicTo(88.597748F, 49.54438F, 89.0F, 46.784641F, 89.0F, 44.0F);
      ((Path)localObject).cubicTo(89.0F, 25.748039F, 72.605919F, 11.0F, 48.0F, 11.0F);
      ((Path)localObject).cubicTo(23.394077F, 11.0F, 7.0F, 25.748039F, 7.0F, 44.0F);
      ((Path)localObject).cubicTo(7.0F, 53.683987F, 11.725022F, 62.435818F, 20.0F, 68.0F);
      ((Path)localObject).lineTo(15.0F, 81.0F);
      ((Path)localObject).lineTo(31.0F, 74.0F);
      ((Path)localObject).cubicTo(36.047134F, 75.924774F, 41.760712F, 76.882355F, 48.0F, 77.0F);
      ((Path)localObject).cubicTo(50.683678F, 76.882355F, 53.264854F, 76.696144F, 56.0F, 76.0F);
      ((Path)localObject).lineTo(56.0F, 68.0F);
      ((Path)localObject).cubicTo(53.296288F, 68.428825F, 50.712379F, 68.647057F, 48.0F, 69.0F);
      ((Path)localObject).cubicTo(42.516022F, 68.647057F, 37.537712F, 67.782356F, 33.0F, 66.0F);
      ((Path)localObject).lineTo(33.0F, 66.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_create_biz_chat
 * JD-Core Version:    0.7.0.1
 */