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

public class live_user_level_30_39
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.8F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(1.8F, 9.3F);
      localPath.cubicTo(2.794112F, 9.3F, 3.6F, 10.105887F, 3.6F, 11.1F);
      localPath.cubicTo(3.6F, 12.094113F, 2.794112F, 12.900001F, 1.8F, 12.900001F);
      localPath.cubicTo(0.805887F, 12.900001F, 0.0F, 12.094113F, 0.0F, 11.1F);
      localPath.cubicTo(0.0F, 10.105887F, 0.805887F, 9.3F, 1.8F, 9.3F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.8F, 0.0F);
      localPath.cubicTo(5.794113F, 0.0F, 6.6F, 0.805887F, 6.6F, 1.8F);
      localPath.cubicTo(6.6F, 2.794112F, 5.794113F, 3.6F, 4.8F, 3.6F);
      localPath.cubicTo(3.805888F, 3.6F, 3.F, 2.794112F, 3.F, 1.8F);
      localPath.cubicTo(3.F, 0.805887F, 3.805888F, 0.0F, 4.8F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(9.2F, 15.099999F);
      localPath.cubicTo(10.194113F, 15.099999F, 11.0F, 15.905887F, 11.0F, 16.9F);
      localPath.cubicTo(11.0F, 17.894112F, 10.194113F, 18.699999F, 9.2F, 18.699999F);
      localPath.cubicTo(8.205887F, 18.699999F, 7.4F, 17.894112F, 7.4F, 16.9F);
      localPath.cubicTo(7.4F, 15.905887F, 8.205887F, 15.099999F, 9.2F, 15.099999F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.6F, 0.0F);
      localPath.cubicTo(14.594113F, 0.0F, 15.400001F, 0.805887F, 15.400001F, 1.8F);
      localPath.cubicTo(15.400001F, 2.794112F, 14.594113F, 3.6F, 13.6F, 3.6F);
      localPath.cubicTo(12.605887F, 3.6F, 11.8F, 2.794112F, 11.8F, 1.8F);
      localPath.cubicTo(11.8F, 0.805887F, 12.605887F, 0.0F, 13.6F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.6F, 9.3F);
      ((Path)localObject2).cubicTo(17.594112F, 9.3F, 18.4F, 10.105887F, 18.4F, 11.1F);
      ((Path)localObject2).cubicTo(18.4F, 12.094113F, 17.594112F, 12.900001F, 16.6F, 12.900001F);
      ((Path)localObject2).cubicTo(15.605887F, 12.900001F, 14.8F, 12.094113F, 14.8F, 11.1F);
      ((Path)localObject2).cubicTo(14.8F, 10.105887F, 15.605887F, 9.3F, 16.6F, 9.3F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 11.292893F, 0.7071068F, 0.7071068F, -5.263455F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(12.0F, 13.4F);
      ((Path)localObject1).lineTo(8.687623F, 14.838614F);
      ((Path)localObject1).cubicTo(8.484995F, 14.926618F, 8.249391F, 14.833697F, 8.161387F, 14.631068F);
      ((Path)localObject1).cubicTo(8.117241F, 14.529425F, 8.117241F, 14.414021F, 8.161387F, 14.312377F);
      ((Path)localObject1).lineTo(9.6F, 11.0F);
      ((Path)localObject1).lineTo(9.6F, 11.0F);
      ((Path)localObject1).lineTo(8.161387F, 7.687624F);
      ((Path)localObject1).cubicTo(8.073382F, 7.484995F, 8.166303F, 7.249391F, 8.368932F, 7.161387F);
      ((Path)localObject1).cubicTo(8.470575F, 7.117241F, 8.58598F, 7.117241F, 8.687623F, 7.161387F);
      ((Path)localObject1).lineTo(12.0F, 8.6F);
      ((Path)localObject1).lineTo(12.0F, 8.6F);
      ((Path)localObject1).lineTo(15.312377F, 7.161387F);
      ((Path)localObject1).cubicTo(15.515005F, 7.073382F, 15.750609F, 7.166303F, 15.838614F, 7.368931F);
      ((Path)localObject1).cubicTo(15.882759F, 7.470576F, 15.882759F, 7.585979F, 15.838614F, 7.687624F);
      ((Path)localObject1).lineTo(14.4F, 11.0F);
      ((Path)localObject1).lineTo(14.4F, 11.0F);
      ((Path)localObject1).lineTo(15.838614F, 14.312377F);
      ((Path)localObject1).cubicTo(15.926618F, 14.515005F, 15.833697F, 14.750609F, 15.631068F, 14.838614F);
      ((Path)localObject1).cubicTo(15.529425F, 14.882759F, 15.414021F, 14.882759F, 15.312377F, 14.838614F);
      ((Path)localObject1).lineTo(12.0F, 13.4F);
      ((Path)localObject1).lineTo(12.0F, 13.4F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.live_user_level_30_39
 * JD-Core Version:    0.7.0.1
 */