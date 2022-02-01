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

public class new_voice2txt_voice
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
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localCanvas.saveLayerAlpha(null, 231, 31);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(19.333334F, 12.0F);
      ((Path)localObject).cubicTo(19.333334F, 16.165592F, 17.691711F, 19.936829F, 15.037566F, 22.666666F);
      ((Path)localObject).lineTo(13.481931F, 21.066668F);
      ((Path)localObject).cubicTo(15.737954F, 18.746304F, 17.133333F, 15.540753F, 17.133333F, 12.0F);
      ((Path)localObject).cubicTo(17.133333F, 8.459247F, 15.737954F, 5.253696F, 13.481931F, 2.933333F);
      ((Path)localObject).lineTo(15.037566F, 1.333333F);
      ((Path)localObject).cubicTo(17.691711F, 4.063171F, 19.333334F, 7.834407F, 19.333334F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.2F, 12.0F);
      ((Path)localObject).cubicTo(14.2F, 14.707635F, 13.132945F, 17.158939F, 11.407751F, 18.933332F);
      ((Path)localObject).lineTo(9.852117F, 17.333334F);
      ((Path)localObject).cubicTo(11.179189F, 15.968414F, 12.0F, 14.082796F, 12.0F, 12.0F);
      ((Path)localObject).cubicTo(12.0F, 9.917204F, 11.179189F, 8.031586F, 9.852117F, 6.666667F);
      ((Path)localObject).lineTo(11.407751F, 5.066667F);
      ((Path)localObject).cubicTo(13.132945F, 6.841062F, 14.2F, 9.292365F, 14.2F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.777937F, 8.8F);
      ((Path)localObject).cubicTo(8.57418F, 9.618952F, 9.066667F, 10.750322F, 9.066667F, 12.0F);
      ((Path)localObject).cubicTo(9.066667F, 13.249425F, 8.57438F, 14.38059F, 7.77842F, 15.199502F);
      ((Path)localObject).lineTo(4.666667F, 12.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.new_voice2txt_voice
 * JD-Core Version:    0.7.0.1
 */