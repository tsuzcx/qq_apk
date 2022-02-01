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

public class icon_filled_switch
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(5.0F, 11.0F);
      ((Path)localObject).lineTo(5.0F, 16.0F);
      ((Path)localObject).lineTo(15.414F, 15.999359F);
      ((Path)localObject).lineTo(13.585787F, 14.171573F);
      ((Path)localObject).lineTo(15.0F, 12.75736F);
      ((Path)localObject).lineTo(18.535534F, 16.292892F);
      ((Path)localObject).cubicTo(18.926058F, 16.683418F, 18.926058F, 17.316582F, 18.535534F, 17.707108F);
      ((Path)localObject).lineTo(15.0F, 21.242641F);
      ((Path)localObject).lineTo(13.585787F, 19.828426F);
      ((Path)localObject).lineTo(15.413F, 17.999359F);
      ((Path)localObject).lineTo(5.0F, 18.0F);
      ((Path)localObject).cubicTo(3.945638F, 18.0F, 3.081835F, 17.184122F, 3.005486F, 16.149261F);
      ((Path)localObject).lineTo(3.0F, 16.0F);
      ((Path)localObject).lineTo(3.0F, 11.0F);
      ((Path)localObject).lineTo(5.0F, 11.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.0F, 2.757359F);
      ((Path)localObject).lineTo(10.414213F, 4.171573F);
      ((Path)localObject).lineTo(8.585F, 5.999359F);
      ((Path)localObject).lineTo(19.0F, 6.0F);
      ((Path)localObject).cubicTo(20.054361F, 6.0F, 20.918165F, 6.815878F, 20.994514F, 7.850738F);
      ((Path)localObject).lineTo(21.0F, 8.0F);
      ((Path)localObject).lineTo(21.0F, 13.0F);
      ((Path)localObject).lineTo(19.0F, 13.0F);
      ((Path)localObject).lineTo(19.0F, 8.0F);
      ((Path)localObject).lineTo(8.586F, 7.999359F);
      ((Path)localObject).lineTo(10.414213F, 9.828427F);
      ((Path)localObject).lineTo(9.0F, 11.24264F);
      ((Path)localObject).lineTo(5.464466F, 7.707107F);
      ((Path)localObject).cubicTo(5.073942F, 7.316583F, 5.073942F, 6.683417F, 5.464466F, 6.292893F);
      ((Path)localObject).lineTo(5.464466F, 6.292893F);
      ((Path)localObject).lineTo(9.0F, 2.757359F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_switch
 * JD-Core Version:    0.7.0.1
 */