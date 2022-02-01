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

public class app_brand_relieved_buy_icon
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
      ((Paint)localObject).setColor(16777215);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(419938656);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.732051F, 1.463633F);
      localPath.lineTo(20.26795F, 5.23333F);
      localPath.cubicTo(21.339746F, 5.851508F, 22.0F, 6.993948F, 22.0F, 8.230304F);
      localPath.lineTo(22.0F, 15.769696F);
      localPath.cubicTo(22.0F, 17.006052F, 21.339746F, 18.148493F, 20.26795F, 18.76667F);
      localPath.lineTo(13.732051F, 22.536367F);
      localPath.cubicTo(12.660254F, 23.154545F, 11.339746F, 23.154545F, 10.267949F, 22.536367F);
      localPath.lineTo(3.732051F, 18.76667F);
      localPath.cubicTo(2.660254F, 18.148493F, 2.0F, 17.006052F, 2.0F, 15.769696F);
      localPath.lineTo(2.0F, 8.230304F);
      localPath.cubicTo(2.0F, 6.993948F, 2.660254F, 5.851508F, 3.732051F, 5.23333F);
      localPath.lineTo(10.267949F, 1.463633F);
      localPath.cubicTo(11.339746F, 0.8454555F, 12.660254F, 0.8454555F, 13.732051F, 1.463633F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16268960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.732051F, 1.463633F);
      localPath.lineTo(20.26795F, 5.23333F);
      localPath.cubicTo(21.339746F, 5.851508F, 22.0F, 6.993948F, 22.0F, 8.230304F);
      localPath.lineTo(22.0F, 15.769696F);
      localPath.cubicTo(22.0F, 17.006052F, 21.339746F, 18.148493F, 20.26795F, 18.76667F);
      localPath.lineTo(13.732051F, 22.536367F);
      localPath.cubicTo(12.660254F, 23.154545F, 11.339746F, 23.154545F, 10.267949F, 22.536367F);
      localPath.lineTo(3.732051F, 18.76667F);
      localPath.cubicTo(2.660254F, 18.148493F, 2.0F, 17.006052F, 2.0F, 15.769696F);
      localPath.lineTo(2.0F, 8.230304F);
      localPath.cubicTo(2.0F, 6.993948F, 2.660254F, 5.851508F, 3.732051F, 5.23333F);
      localPath.lineTo(10.267949F, 1.463633F);
      localPath.cubicTo(11.339746F, 0.8454555F, 12.660254F, 0.8454555F, 13.732051F, 1.463633F);
      localPath.close();
      localPath.moveTo(13.132504F, 2.503126F);
      localPath.cubicTo(12.431759F, 2.098958F, 11.568241F, 2.098958F, 10.867496F, 2.503126F);
      localPath.lineTo(4.331597F, 6.272822F);
      localPath.cubicTo(3.63125F, 6.67676F, 3.2F, 7.422954F, 3.2F, 8.230304F);
      localPath.lineTo(3.2F, 15.769696F);
      localPath.cubicTo(3.2F, 16.577045F, 3.63125F, 17.32324F, 4.331597F, 17.727179F);
      localPath.lineTo(10.867496F, 21.496874F);
      localPath.cubicTo(11.568241F, 21.901043F, 12.431759F, 21.901043F, 13.132504F, 21.496874F);
      localPath.lineTo(19.668404F, 17.727179F);
      localPath.cubicTo(20.36875F, 17.32324F, 20.799999F, 16.577045F, 20.799999F, 15.769696F);
      localPath.lineTo(20.799999F, 8.230304F);
      localPath.cubicTo(20.799999F, 7.422954F, 20.36875F, 6.67676F, 19.668404F, 6.272822F);
      localPath.lineTo(13.132504F, 2.503126F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.1745F, 7.206F);
      ((Path)localObject).lineTo(16.212F, 7.206F);
      ((Path)localObject).lineTo(16.212F, 11.047F);
      ((Path)localObject).lineTo(10.1745F, 11.047F);
      ((Path)localObject).lineTo(10.1745F, 7.206F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.6355F, 17.015499F);
      ((Path)localObject).lineTo(12.6355F, 13.9335F);
      ((Path)localObject).cubicTo(11.8995F, 14.9685F, 11.014F, 15.739F, 9.5995F, 16.636F);
      ((Path)localObject).lineTo(8.9325F, 15.601F);
      ((Path)localObject).cubicTo(10.508F, 14.8305F, 11.3935F, 14.106F, 12.1295F, 13.094F);
      ((Path)localObject).lineTo(9.5535F, 13.094F);
      ((Path)localObject).lineTo(9.5535F, 12.0475F);
      ((Path)localObject).lineTo(12.6355F, 12.0475F);
      ((Path)localObject).lineTo(12.6355F, 11.2195F);
      ((Path)localObject).lineTo(13.751F, 11.2195F);
      ((Path)localObject).lineTo(13.751F, 12.0475F);
      ((Path)localObject).lineTo(16.856001F, 12.0475F);
      ((Path)localObject).lineTo(16.856001F, 13.094F);
      ((Path)localObject).lineTo(14.096F, 13.094F);
      ((Path)localObject).cubicTo(14.8435F, 14.037F, 15.8555F, 14.796F, 17.2355F, 15.463F);
      ((Path)localObject).lineTo(16.603001F, 16.544001F);
      ((Path)localObject).cubicTo(15.5105F, 15.8425F, 14.5215F, 14.9455F, 13.751F, 13.9565F);
      ((Path)localObject).lineTo(13.751F, 17.015499F);
      ((Path)localObject).lineTo(12.6355F, 17.015499F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.7595F, 17.049999F);
      ((Path)localObject).lineTo(7.7595F, 11.622F);
      ((Path)localObject).cubicTo(7.5065F, 12.013F, 7.219F, 12.3925F, 6.92F, 12.772F);
      ((Path)localObject).lineTo(6.2185F, 11.737F);
      ((Path)localObject).cubicTo(7.012F, 10.6445F, 8.1505F, 8.494F, 8.6105F, 6.7805F);
      ((Path)localObject).lineTo(9.8065F, 7.068F);
      ((Path)localObject).cubicTo(9.519F, 7.9535F, 9.22F, 8.7815F, 8.875F, 9.552F);
      ((Path)localObject).lineTo(8.875F, 17.049999F);
      ((Path)localObject).lineTo(7.7595F, 17.049999F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.359F, 8.31F);
      ((Path)localObject).lineTo(11.359F, 9.943F);
      ((Path)localObject).lineTo(15.0275F, 9.943F);
      ((Path)localObject).lineTo(15.0275F, 8.31F);
      ((Path)localObject).lineTo(11.359F, 8.31F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_relieved_buy_icon
 * JD-Core Version:    0.7.0.1
 */