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

public class finder_icons_choose_orange
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-352965);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 24.0F);
      localPath.cubicTo(5.372583F, 24.0F, 0.0F, 18.627417F, 0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372583F, 5.372583F, 0.0F, 12.0F, 0.0F);
      localPath.cubicTo(18.627417F, 0.0F, 24.0F, 5.372583F, 24.0F, 12.0F);
      localPath.cubicTo(24.0F, 18.627417F, 18.627417F, 24.0F, 12.0F, 24.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.588125F, 14.56718F);
      ((Path)localObject).lineTo(17.307304F, 7.848F);
      ((Path)localObject).lineTo(18.582338F, 9.123033F);
      ((Path)localObject).lineTo(11.439497F, 16.262907F);
      ((Path)localObject).cubicTo(10.970901F, 16.731569F, 10.211102F, 16.731411F, 9.742571F, 16.262684F);
      ((Path)localObject).cubicTo(9.742527F, 16.26264F, 9.742484F, 16.262598F, 9.742571F, 16.262423F);
      ((Path)localObject).lineTo(6.0F, 12.517145F);
      ((Path)localObject).lineTo(6.0F, 12.517145F);
      ((Path)localObject).lineTo(7.269045F, 11.2481F);
      ((Path)localObject).lineTo(10.588125F, 14.56718F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icons_choose_orange
 * JD-Core Version:    0.7.0.1
 */