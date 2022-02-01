package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class icons_wecoin_entrance
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
      localPaint = c.instancePaint((Paint)localObject, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(1.2F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.0884F, 10.7079F);
      ((Path)localObject).cubicTo(10.0884F, 10.7079F, 13.0574F, 8.9209F, 13.3214F, 5.4159F);
      ((Path)localObject).cubicTo(13.3924F, 4.4879F, 13.0904F, 3.0409F, 12.6794F, 2.6249F);
      ((Path)localObject).cubicTo(12.4344F, 2.3759F, 12.0134F, 2.5209F, 11.9804F, 2.8689F);
      ((Path)localObject).cubicTo(11.9244F, 3.4389F, 11.7124F, 4.5189F, 11.1574F, 5.2589F);
      ((Path)localObject).cubicTo(10.7114F, 5.8529F, 9.7674F, 6.5379F, 9.4294F, 6.7719F);
      ((Path)localObject).cubicTo(8.6154F, 7.2499F, 7.8304F, 7.8489F, 7.1104F, 8.5689F);
      ((Path)localObject).cubicTo(3.5844F, 12.0949F, 2.9154F, 17.141899F, 5.6154F, 19.842899F);
      ((Path)localObject).cubicTo(8.3164F, 22.5429F, 13.3634F, 21.873899F, 16.8894F, 18.3479F);
      ((Path)localObject).cubicTo(20.4154F, 14.8219F, 21.0844F, 9.7739F, 18.384399F, 7.0739F);
      ((Path)localObject).cubicTo(17.4384F, 6.1279F, 16.0394F, 5.5629F, 14.9954F, 5.4459F);
      ((Path)localObject).cubicTo(13.9514F, 5.3299F, 13.3554F, 5.4159F, 13.3554F, 5.4159F);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_wecoin_entrance
 * JD-Core Version:    0.7.0.1
 */