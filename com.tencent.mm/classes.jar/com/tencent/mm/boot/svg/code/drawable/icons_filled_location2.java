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

public class icons_filled_location2
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(22.31251F, 19.1514F);
      ((Path)localObject).cubicTo(23.089306F, 19.490896F, 23.772816F, 19.896404F, 24.333279F, 20.359447F);
      ((Path)localObject).cubicTo(25.393064F, 21.23502F, 26.0F, 22.306877F, 26.0F, 23.479452F);
      ((Path)localObject).cubicTo(26.0F, 26.7297F, 21.446926F, 29.0F, 16.0F, 29.0F);
      ((Path)localObject).cubicTo(10.553075F, 29.0F, 6.0F, 26.7297F, 6.0F, 23.479452F);
      ((Path)localObject).cubicTo(6.0F, 22.243387F, 6.672846F, 21.12244F, 7.837757F, 20.222858F);
      ((Path)localObject).cubicTo(8.364407F, 19.816162F, 8.9883F, 19.45694F, 9.68767F, 19.151297F);
      ((Path)localObject).cubicTo(10.149241F, 19.766218F, 10.624209F, 20.348862F, 11.093813F, 20.891275F);
      ((Path)localObject).cubicTo(10.323599F, 21.170473F, 9.662527F, 21.516493F, 9.149726F, 21.912493F);
      ((Path)localObject).cubicTo(8.467443F, 22.439375F, 8.142858F, 22.980127F, 8.142858F, 23.479452F);
      ((Path)localObject).cubicTo(8.142858F, 25.146809F, 11.584698F, 26.863014F, 16.0F, 26.863014F);
      ((Path)localObject).cubicTo(20.415302F, 26.863014F, 23.857143F, 25.146809F, 23.857143F, 23.479452F);
      ((Path)localObject).cubicTo(23.857143F, 23.009869F, 23.571207F, 22.5049F, 22.966217F, 22.005072F);
      ((Path)localObject).cubicTo(22.440994F, 21.571142F, 21.738085F, 21.192823F, 20.908646F, 20.889942F);
      ((Path)localObject).cubicTo(21.376186F, 20.349566F, 21.849049F, 19.769594F, 22.307224F, 19.158033F);
      ((Path)localObject).lineTo(22.31251F, 19.1514F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.0F, 3.0F);
      ((Path)localObject).cubicTo(20.438002F, 3.0F, 24.035715F, 6.587072F, 24.035715F, 11.01195F);
      ((Path)localObject).cubicTo(24.035715F, 16.83831F, 17.154078F, 22.817316F, 16.695301F, 23.209444F);
      ((Path)localObject).lineTo(16.671299F, 23.229843F);
      ((Path)localObject).cubicTo(16.335705F, 23.535618F, 15.803898F, 23.564592F, 15.437853F, 23.316931F);
      ((Path)localObject).lineTo(15.342403F, 23.242529F);
      ((Path)localObject).lineTo(15.318357F, 23.222088F);
      ((Path)localObject).cubicTo(14.858727F, 22.82917F, 7.964286F, 16.83831F, 7.964286F, 11.01195F);
      ((Path)localObject).cubicTo(7.964286F, 6.587072F, 11.561997F, 3.0F, 16.0F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.0F, 7.80717F);
      ((Path)localObject).cubicTo(14.224799F, 7.80717F, 12.785714F, 9.242F, 12.785714F, 11.01195F);
      ((Path)localObject).cubicTo(12.785714F, 12.781901F, 14.224799F, 14.216731F, 16.0F, 14.216731F);
      ((Path)localObject).cubicTo(17.775202F, 14.216731F, 19.214285F, 12.781901F, 19.214285F, 11.01195F);
      ((Path)localObject).cubicTo(19.214285F, 9.242F, 17.775202F, 7.80717F, 16.0F, 7.80717F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.saveLayerAlpha(null, 179, 31);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_location2
 * JD-Core Version:    0.7.0.1
 */