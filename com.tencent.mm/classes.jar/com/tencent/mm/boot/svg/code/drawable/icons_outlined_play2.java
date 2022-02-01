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

public class icons_outlined_play2
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 0.0F);
      ((Path)localObject).cubicTo(18.627417F, 0.0F, 24.0F, 5.372583F, 24.0F, 12.0F);
      ((Path)localObject).cubicTo(24.0F, 18.627417F, 18.627417F, 24.0F, 12.0F, 24.0F);
      ((Path)localObject).cubicTo(5.372583F, 24.0F, 0.0F, 18.627417F, 0.0F, 12.0F);
      ((Path)localObject).cubicTo(0.0F, 5.372583F, 5.372583F, 0.0F, 12.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 0.72F);
      ((Path)localObject).cubicTo(5.770228F, 0.72F, 0.72F, 5.770228F, 0.72F, 12.0F);
      ((Path)localObject).cubicTo(0.72F, 18.229773F, 5.770228F, 23.280001F, 12.0F, 23.280001F);
      ((Path)localObject).cubicTo(18.229773F, 23.280001F, 23.280001F, 18.229773F, 23.280001F, 12.0F);
      ((Path)localObject).cubicTo(23.280001F, 5.770228F, 18.229773F, 0.72F, 12.0F, 0.72F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.6F, 7.633908F);
      ((Path)localObject).cubicTo(9.704416F, 7.633908F, 9.807025F, 7.661157F, 9.897683F, 7.712962F);
      ((Path)localObject).lineTo(16.488344F, 11.479054F);
      ((Path)localObject).cubicTo(16.776054F, 11.64346F, 16.876013F, 12.009973F, 16.711607F, 12.297684F);
      ((Path)localObject).cubicTo(16.658453F, 12.390702F, 16.581364F, 12.467793F, 16.488344F, 12.520946F);
      ((Path)localObject).lineTo(9.897683F, 16.287039F);
      ((Path)localObject).cubicTo(9.609973F, 16.451445F, 9.24346F, 16.351486F, 9.079054F, 16.063776F);
      ((Path)localObject).cubicTo(9.027249F, 15.973117F, 9.0F, 15.870508F, 9.0F, 15.766092F);
      ((Path)localObject).lineTo(9.0F, 8.233908F);
      ((Path)localObject).cubicTo(9.0F, 7.902537F, 9.268629F, 7.633908F, 9.6F, 7.633908F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_play2
 * JD-Core Version:    0.7.0.1
 */