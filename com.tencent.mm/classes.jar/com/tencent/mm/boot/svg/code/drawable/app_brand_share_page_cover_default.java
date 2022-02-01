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

public class app_brand_share_page_cover_default
  extends c
{
  private final int height = 81;
  private final int width = 90;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 81;
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
      localPaint1.setColor(-2565928);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -1531.0F, 0.0F, 1.0F, -1102.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1582.0F, 1105.561F);
      ((Path)localObject2).cubicTo(1574.8075F, 1109.677F, 1570.0F, 1116.952F, 1570.0F, 1125.25F);
      ((Path)localObject2).lineTo(1570.0F, 1159.75F);
      ((Path)localObject2).cubicTo(1570.0F, 1165.963F, 1563.955F, 1171.0F, 1556.5F, 1171.0F);
      ((Path)localObject2).cubicTo(1549.0435F, 1171.0F, 1543.0F, 1165.963F, 1543.0F, 1159.75F);
      ((Path)localObject2).cubicTo(1543.0F, 1155.328F, 1546.069F, 1151.5135F, 1550.5225F, 1149.6746F);
      ((Path)localObject2).cubicTo(1550.8435F, 1149.5425F, 1551.1689F, 1149.4165F, 1551.5035F, 1149.3055F);
      ((Path)localObject2).cubicTo(1554.307F, 1148.1805F, 1556.7115F, 1146.0685F, 1557.604F, 1143.616F);
      ((Path)localObject2).cubicTo(1558.9225F, 1139.995F, 1556.4685F, 1137.061F, 1552.1245F, 1137.061F);
      ((Path)localObject2).cubicTo(1551.0415F, 1137.061F, 1549.9435F, 1137.244F, 1548.8845F, 1137.574F);
      ((Path)localObject2).cubicTo(1542.589F, 1139.3815F, 1537.3466F, 1143.3354F, 1534.1995F, 1148.5F);
      ((Path)localObject2).cubicTo(1532.167F, 1151.8375F, 1531.0F, 1155.67F, 1531.0F, 1159.75F);
      ((Path)localObject2).cubicTo(1531.0F, 1172.5706F, 1542.439F, 1183.0F, 1556.5F, 1183.0F);
      ((Path)localObject2).cubicTo(1561.4604F, 1183.0F, 1566.079F, 1181.6815F, 1570.0F, 1179.439F);
      ((Path)localObject2).cubicTo(1577.1925F, 1175.323F, 1582.0F, 1168.048F, 1582.0F, 1159.75F);
      ((Path)localObject2).lineTo(1582.0F, 1125.25F);
      ((Path)localObject2).cubicTo(1582.0F, 1119.037F, 1588.0435F, 1114.0F, 1595.5F, 1114.0F);
      ((Path)localObject2).cubicTo(1602.955F, 1114.0F, 1609.0F, 1119.037F, 1609.0F, 1125.25F);
      ((Path)localObject2).cubicTo(1609.0F, 1129.861F, 1605.6715F, 1133.824F, 1600.906F, 1135.561F);
      ((Path)localObject2).cubicTo(1597.8325F, 1136.5916F, 1595.314F, 1138.816F, 1594.354F, 1141.4515F);
      ((Path)localObject2).cubicTo(1593.043F, 1145.0544F, 1595.485F, 1147.9764F, 1599.8094F, 1147.9764F);
      ((Path)localObject2).cubicTo(1600.7889F, 1147.9764F, 1601.7791F, 1147.8085F, 1602.7435F, 1147.5355F);
      ((Path)localObject2).cubicTo(1602.901F, 1147.4919F, 1603.057F, 1147.444F, 1603.213F, 1147.3975F);
      ((Path)localObject2).cubicTo(1609.4561F, 1145.584F, 1614.667F, 1141.642F, 1617.799F, 1136.5F);
      ((Path)localObject2).cubicTo(1619.833F, 1133.1639F, 1621.0F, 1129.33F, 1621.0F, 1125.25F);
      ((Path)localObject2).cubicTo(1621.0F, 1112.4294F, 1609.561F, 1102.0F, 1595.5F, 1102.0F);
      ((Path)localObject2).cubicTo(1590.5396F, 1102.0F, 1585.921F, 1103.3185F, 1582.0F, 1105.561F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_share_page_cover_default
 * JD-Core Version:    0.7.0.1
 */