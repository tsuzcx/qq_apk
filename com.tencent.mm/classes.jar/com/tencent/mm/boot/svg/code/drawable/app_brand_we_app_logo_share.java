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

public class app_brand_we_app_logo_share
  extends c
{
  private final int height = 34;
  private final int width = 34;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 34;
      return 34;
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
      localPaint1.setColor(-9074981);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -1316.0F, 0.0F, 1.0F, -1235.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1336.0F, 1238.0F);
      ((Path)localObject2).cubicTo(1333.0627F, 1239.8434F, 1331.3F, 1242.5377F, 1331.0F, 1246.0F);
      ((Path)localObject2).lineTo(1331.0F, 1258.0F);
      ((Path)localObject2).cubicTo(1331.3F, 1260.6899F, 1329.0835F, 1262.5555F, 1326.0F, 1263.0F);
      ((Path)localObject2).cubicTo(1323.616F, 1262.5555F, 1321.4F, 1260.6899F, 1321.0F, 1258.0F);
      ((Path)localObject2).cubicTo(1321.4F, 1256.7511F, 1322.0F, 1256.0F, 1324.0F, 1255.0F);
      ((Path)localObject2).cubicTo(1326.0F, 1254.0F, 1326.4275F, 1253.3217F, 1327.0F, 1252.0F);
      ((Path)localObject2).cubicTo(1327.2383F, 1251.0723F, 1326.3385F, 1249.9856F, 1325.0F, 1250.0F);
      ((Path)localObject2).cubicTo(1324.3485F, 1249.9856F, 1323.9459F, 1250.0533F, 1324.0F, 1250.0F);
      ((Path)localObject2).cubicTo(1321.2493F, 1250.845F, 1319.327F, 1252.3094F, 1318.0F, 1254.0F);
      ((Path)localObject2).cubicTo(1317.4279F, 1255.4584F, 1317.0F, 1256.8778F, 1317.0F, 1258.0F);
      ((Path)localObject2).cubicTo(1317.0F, 1263.1372F, 1321.1943F, 1267.0F, 1326.0F, 1267.0F);
      ((Path)localObject2).cubicTo(1328.1688F, 1267.0F, 1329.8623F, 1266.5117F, 1331.0F, 1266.0F);
      ((Path)localObject2).cubicTo(1333.9373F, 1264.1566F, 1335.7F, 1261.4623F, 1336.0F, 1258.0F);
      ((Path)localObject2).lineTo(1336.0F, 1246.0F);
      ((Path)localObject2).cubicTo(1335.7F, 1243.3101F, 1337.9159F, 1241.4445F, 1341.0F, 1241.0F);
      ((Path)localObject2).cubicTo(1343.3835F, 1241.4445F, 1345.6F, 1243.3101F, 1346.0F, 1246.0F);
      ((Path)localObject2).cubicTo(1345.6F, 1247.3188F, 1344.3795F, 1248.7866F, 1343.0F, 1249.0F);
      ((Path)localObject2).cubicTo(1341.5052F, 1249.8116F, 1340.5818F, 1250.6356F, 1340.0F, 1252.0F);
      ((Path)localObject2).cubicTo(1339.7491F, 1252.9462F, 1340.6445F, 1254.0283F, 1342.0F, 1254.0F);
      ((Path)localObject2).cubicTo(1342.5894F, 1254.0283F, 1342.9523F, 1253.9661F, 1343.0F, 1254.0F);
      ((Path)localObject2).cubicTo(1345.7672F, 1253.1422F, 1347.6779F, 1251.6823F, 1349.0F, 1250.0F);
      ((Path)localObject2).cubicTo(1349.5721F, 1248.5422F, 1350.0F, 1247.1222F, 1350.0F, 1246.0F);
      ((Path)localObject2).cubicTo(1350.0F, 1240.8628F, 1345.8057F, 1237.0F, 1341.0F, 1237.0F);
      ((Path)localObject2).cubicTo(1338.8312F, 1237.0F, 1337.1377F, 1237.4883F, 1336.0F, 1238.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_we_app_logo_share
 * JD-Core Version:    0.7.0.1
 */