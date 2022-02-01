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

public class voice2txt_hint_trans_eng
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
      localPaint.setColor(-2130706433);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(4.0F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 3.0F);
      ((Path)localObject).cubicTo(20.552284F, 3.0F, 21.0F, 3.447715F, 21.0F, 4.0F);
      ((Path)localObject).lineTo(21.0F, 20.0F);
      ((Path)localObject).cubicTo(21.0F, 20.552284F, 20.552284F, 21.0F, 20.0F, 21.0F);
      ((Path)localObject).lineTo(4.0F, 21.0F);
      ((Path)localObject).cubicTo(3.447715F, 21.0F, 3.0F, 20.552284F, 3.0F, 20.0F);
      ((Path)localObject).lineTo(3.0F, 4.0F);
      ((Path)localObject).cubicTo(3.0F, 3.447715F, 3.447715F, 3.0F, 4.0F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.0F, 8.0F);
      ((Path)localObject).lineTo(6.0F, 16.0F);
      ((Path)localObject).lineTo(11.856354F, 16.0F);
      ((Path)localObject).lineTo(11.856354F, 14.957983F);
      ((Path)localObject).lineTo(7.20442F, 14.957983F);
      ((Path)localObject).lineTo(7.20442F, 12.414566F);
      ((Path)localObject).lineTo(11.403315F, 12.414566F);
      ((Path)localObject).lineTo(11.403315F, 11.372549F);
      ((Path)localObject).lineTo(7.20442F, 11.372549F);
      ((Path)localObject).lineTo(7.20442F, 9.042017F);
      ((Path)localObject).lineTo(11.668509F, 9.042017F);
      ((Path)localObject).lineTo(11.668509F, 8.0F);
      ((Path)localObject).lineTo(6.0F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.867403F, 10.05042F);
      ((Path)localObject).cubicTo(15.513812F, 10.05042F, 15.19337F, 10.117647F, 14.906077F, 10.274509F);
      ((Path)localObject).cubicTo(14.618785F, 10.420168F, 14.364641F, 10.633053F, 14.143646F, 10.92437F);
      ((Path)localObject).lineTo(14.143646F, 10.207283F);
      ((Path)localObject).lineTo(12.972376F, 10.207283F);
      ((Path)localObject).lineTo(12.972376F, 16.0F);
      ((Path)localObject).lineTo(14.143646F, 16.0F);
      ((Path)localObject).lineTo(14.143646F, 12.515407F);
      ((Path)localObject).cubicTo(14.187845F, 12.044818F, 14.353591F, 11.67507F, 14.618785F, 11.406162F);
      ((Path)localObject).cubicTo(14.861878F, 11.159664F, 15.160221F, 11.047619F, 15.491713F, 11.047619F);
      ((Path)localObject).cubicTo(16.37569F, 11.047619F, 16.82873F, 11.540616F, 16.82873F, 12.52661F);
      ((Path)localObject).lineTo(16.82873F, 16.0F);
      ((Path)localObject).lineTo(18.0F, 16.0F);
      ((Path)localObject).lineTo(18.0F, 12.425771F);
      ((Path)localObject).cubicTo(18.0F, 10.834734F, 17.281769F, 10.05042F, 15.867403F, 10.05042F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voice2txt_hint_trans_eng
 * JD-Core Version:    0.7.0.1
 */