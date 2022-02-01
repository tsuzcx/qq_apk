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

public class icons_filled_call_good
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.810811F, 1.0F);
      ((Path)localObject).cubicTo(13.969112F, 1.0F, 14.818533F, 1.85504F, 15.050193F, 2.923077F);
      ((Path)localObject).cubicTo(15.204633F, 3.538461F, 15.281854F, 4.230769F, 15.281854F, 4.923077F);
      ((Path)localObject).cubicTo(15.281854F, 6.0F, 15.127413F, 7.0F, 14.818533F, 7.923077F);
      ((Path)localObject).lineTo(14.818533F, 7.923077F);
      ((Path)localObject).lineTo(19.606178F, 7.923077F);
      ((Path)localObject).cubicTo(20.378378F, 8.0F, 21.150579F, 8.384615F, 21.613899F, 9.153846F);
      ((Path)localObject).cubicTo(21.922779F, 9.615385F, 22.0F, 10.153846F, 22.0F, 10.692307F);
      ((Path)localObject).cubicTo(21.95989F, 11.085051F, 21.92981F, 11.328325F, 21.909754F, 11.422132F);
      ((Path)localObject).cubicTo(21.421392F, 13.706489F, 20.455297F, 18.07333F, 20.168217F, 19.284653F);
      ((Path)localObject).cubicTo(20.152573F, 19.350664F, 20.135468F, 19.419725F, 20.124044F, 19.466146F);
      ((Path)localObject).cubicTo(20.103884F, 19.548065F, 20.074547F, 19.602066F, 20.069498F, 19.615385F);
      ((Path)localObject).cubicTo(19.915058F, 20.0F, 19.606178F, 20.384615F, 19.220078F, 20.615385F);
      ((Path)localObject).cubicTo(18.833977F, 20.846153F, 18.370657F, 21.0F, 17.907335F, 21.0F);
      ((Path)localObject).lineTo(17.907335F, 21.0F);
      ((Path)localObject).lineTo(8.019305F, 21.0F);
      ((Path)localObject).cubicTo(7.46702F, 21.0F, 7.019305F, 20.552284F, 7.019305F, 20.0F);
      ((Path)localObject).lineTo(7.019305F, 20.0F);
      ((Path)localObject).lineTo(7.019305F, 8.538462F);
      ((Path)localObject).cubicTo(8.075794F, 8.143802F, 8.981717F, 7.374173F, 9.579713F, 6.37208F);
      ((Path)localObject).cubicTo(10.030715F, 5.616313F, 10.306569F, 4.728319F, 10.339768F, 3.769231F);
      ((Path)localObject).lineTo(10.339768F, 3.769231F);
      ((Path)localObject).lineTo(10.339768F, 3.538461F);
      ((Path)localObject).cubicTo(10.339768F, 2.153846F, 11.280368F, 1.0F, 12.810811F, 1.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(4.397684F, 8.846154F);
      ((Path)localObject).cubicTo(4.949968F, 8.846154F, 5.397684F, 9.293869F, 5.397684F, 9.846154F);
      ((Path)localObject).lineTo(5.397684F, 9.846154F);
      ((Path)localObject).lineTo(5.397684F, 20.0F);
      ((Path)localObject).cubicTo(5.397684F, 20.552284F, 4.949968F, 21.0F, 4.397684F, 21.0F);
      ((Path)localObject).lineTo(4.397684F, 21.0F);
      ((Path)localObject).lineTo(2.849421F, 21.0F);
      ((Path)localObject).cubicTo(2.3861F, 21.0F, 2.0F, 20.615385F, 2.0F, 20.153847F);
      ((Path)localObject).lineTo(2.0F, 20.153847F);
      ((Path)localObject).lineTo(2.0F, 9.692308F);
      ((Path)localObject).cubicTo(2.0F, 9.230769F, 2.3861F, 8.846154F, 2.849421F, 8.846154F);
      ((Path)localObject).lineTo(2.849421F, 8.846154F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_call_good
 * JD-Core Version:    0.7.0.1
 */