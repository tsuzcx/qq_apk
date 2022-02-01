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

public class panel_icon_aa
  extends c
{
  private final int height = 80;
  private final int width = 66;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 66;
      return 80;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -416.0F, 0.0F, 1.0F, -1269.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(482.0F, 1311.7202F);
      ((Path)localObject2).lineTo(482.0F, 1271.9901F);
      ((Path)localObject2).cubicTo(482.0F, 1270.3384F, 480.65353F, 1269.0F, 478.99261F, 1269.0F);
      ((Path)localObject2).lineTo(419.00739F, 1269.0F);
      ((Path)localObject2).cubicTo(417.3483F, 1269.0F, 416.0F, 1270.3387F, 416.0F, 1271.9901F);
      ((Path)localObject2).lineTo(416.0F, 1346.0099F);
      ((Path)localObject2).cubicTo(416.0F, 1347.6616F, 417.34647F, 1349.0F, 419.00739F, 1349.0F);
      ((Path)localObject2).lineTo(478.99261F, 1349.0F);
      ((Path)localObject2).cubicTo(480.6517F, 1349.0F, 482.0F, 1347.6613F, 482.0F, 1346.0099F);
      ((Path)localObject2).lineTo(482.0F, 1316.9371F);
      ((Path)localObject2).lineTo(449.52548F, 1336.6007F);
      ((Path)localObject2).lineTo(449.28159F, 1336.748F);
      ((Path)localObject2).cubicTo(448.97964F, 1336.9077F, 448.63965F, 1337.0F, 448.27881F, 1337.0F);
      ((Path)localObject2).cubicTo(447.44376F, 1337.0F, 446.71753F, 1336.517F, 446.33582F, 1335.8048F);
      ((Path)localObject2).lineTo(446.18982F, 1335.4691F);
      ((Path)localObject2).lineTo(440.10699F, 1321.4709F);
      ((Path)localObject2).cubicTo(440.0408F, 1321.3179F, 440.0F, 1321.1458F, 440.0F, 1320.9784F);
      ((Path)localObject2).cubicTo(440.0F, 1320.3337F, 440.49866F, 1319.8098F, 441.11429F, 1319.8098F);
      ((Path)localObject2).cubicTo(441.36453F, 1319.8098F, 441.59482F, 1319.8964F, 441.7807F, 1320.0417F);
      ((Path)localObject2).lineTo(448.9588F, 1325.4017F);
      ((Path)localObject2).cubicTo(449.48376F, 1325.7621F, 450.11026F, 1325.9731F, 450.78394F, 1325.9731F);
      ((Path)localObject2).cubicTo(451.18558F, 1325.9731F, 451.56909F, 1325.8942F, 451.92633F, 1325.7583F);
      ((Path)localObject2).lineTo(482.0F, 1311.7202F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(428.0F, 1294.5F);
      ((Path)localObject2).lineTo(452.0F, 1294.5F);
      ((Path)localObject2).lineTo(452.0F, 1299.0F);
      ((Path)localObject2).lineTo(428.0F, 1299.0F);
      ((Path)localObject2).lineTo(428.0F, 1294.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(428.0F, 1281.0F);
      ((Path)localObject2).lineTo(452.0F, 1281.0F);
      ((Path)localObject2).lineTo(452.0F, 1285.5F);
      ((Path)localObject2).lineTo(428.0F, 1285.5F);
      ((Path)localObject2).lineTo(428.0F, 1281.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.panel_icon_aa
 * JD-Core Version:    0.7.0.1
 */