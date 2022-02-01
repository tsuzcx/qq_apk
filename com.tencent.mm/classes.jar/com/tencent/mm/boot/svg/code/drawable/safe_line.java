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

public class safe_line
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localPaint.setColor(1275068416);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(40.0F, 18.72917F);
      ((Path)localObject).cubicTo(40.0F, 18.72917F, 40.0F, 18.72917F, 40.0F, 18.72917F);
      ((Path)localObject).lineTo(40.0F, 22.507578F);
      ((Path)localObject).cubicTo(40.0F, 32.200287F, 33.403309F, 40.649174F, 24.0F, 43.0F);
      ((Path)localObject).cubicTo(14.59669F, 40.649174F, 8.0F, 32.200287F, 8.0F, 22.507578F);
      ((Path)localObject).lineTo(8.0F, 11.0F);
      ((Path)localObject).lineTo(24.0F, 5.0F);
      ((Path)localObject).lineTo(40.0F, 11.0F);
      ((Path)localObject).lineTo(40.0F, 18.729168F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.599998F, 18.514235F);
      ((Path)localObject).lineTo(37.599998F, 12.873863F);
      ((Path)localObject).lineTo(24.0F, 7.473864F);
      ((Path)localObject).lineTo(10.4F, 12.873863F);
      ((Path)localObject).lineTo(10.4F, 22.507578F);
      ((Path)localObject).cubicTo(10.4F, 30.897581F, 15.976219F, 38.236172F, 24.0F, 40.516243F);
      ((Path)localObject).cubicTo(32.023781F, 38.236172F, 37.599998F, 30.897581F, 37.599998F, 22.507578F);
      ((Path)localObject).lineTo(37.599998F, 20.653854F);
      ((Path)localObject).lineTo(20.657824F, 29.824987F);
      ((Path)localObject).lineTo(20.538334F, 29.88998F);
      ((Path)localObject).cubicTo(20.390781F, 29.959221F, 20.224674F, 30.0F, 20.048609F, 30.0F);
      ((Path)localObject).cubicTo(19.6399F, 30.0F, 19.284599F, 29.788879F, 19.098124F, 29.477085F);
      ((Path)localObject).lineTo(19.027065F, 29.330957F);
      ((Path)localObject).lineTo(16.05205F, 23.204657F);
      ((Path)localObject).cubicTo(16.019915F, 23.137966F, 16.0F, 23.062353F, 16.0F, 22.988865F);
      ((Path)localObject).cubicTo(16.0F, 22.706804F, 16.243958F, 22.47827F, 16.544491F, 22.47827F);
      ((Path)localObject).cubicTo(16.667603F, 22.47827F, 16.779396F, 22.516075F, 16.870825F, 22.579794F);
      ((Path)localObject).lineTo(20.380825F, 24.925051F);
      ((Path)localObject).cubicTo(20.636551F, 25.082222F, 20.943872F, 25.174828F, 21.273375F, 25.174828F);
      ((Path)localObject).cubicTo(21.469355F, 25.174828F, 21.657188F, 25.140844F, 21.831444F, 25.080948F);
      ((Path)localObject).cubicTo(21.831444F, 25.080948F, 33.204021F, 20.342318F, 37.599998F, 18.514235F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.safe_line
 * JD-Core Version:    0.7.0.1
 */