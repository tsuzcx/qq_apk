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

public class text_status_edit_poi_selected
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
      ((Paint)localObject).setColor(-16268960);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(24.0F, 12.148149F);
      localPath.cubicTo(24.0F, 5.372445F, 18.627556F, 0.0F, 11.851851F, 0.0F);
      localPath.cubicTo(5.372445F, 0.0F, 0.0F, 5.372445F, 0.0F, 12.148149F);
      localPath.cubicTo(0.0F, 18.627556F, 5.372445F, 24.0F, 11.851851F, 24.0F);
      localPath.cubicTo(18.627556F, 24.0F, 24.0F, 18.627556F, 24.0F, 12.148149F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.363961F, 15.313708F);
      ((Path)localObject).lineTo(7.06066F, 12.010407F);
      ((Path)localObject).lineTo(6.0F, 13.071068F);
      ((Path)localObject).lineTo(9.656855F, 16.727922F);
      ((Path)localObject).cubicTo(10.047379F, 17.118446F, 10.680544F, 17.118446F, 11.071068F, 16.727922F);
      ((Path)localObject).lineTo(18.738329F, 9.06066F);
      ((Path)localObject).lineTo(18.738329F, 9.06066F);
      ((Path)localObject).lineTo(17.67767F, 8.0F);
      ((Path)localObject).lineTo(10.363961F, 15.313708F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.text_status_edit_poi_selected
 * JD-Core Version:    0.7.0.1
 */