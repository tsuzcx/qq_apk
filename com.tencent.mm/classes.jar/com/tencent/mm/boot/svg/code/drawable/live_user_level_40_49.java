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

public class live_user_level_40_49
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 6.123234E-017F, -1.0F, 21.200001F, 1.0F, 6.123234E-017F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(1.8F, 7.4F);
      localPath.cubicTo(2.794112F, 7.4F, 3.6F, 8.205887F, 3.6F, 9.2F);
      localPath.cubicTo(3.6F, 10.194113F, 2.794112F, 11.0F, 1.8F, 11.0F);
      localPath.cubicTo(0.805887F, 11.0F, 0.0F, 10.194113F, 0.0F, 9.2F);
      localPath.cubicTo(0.0F, 8.205887F, 0.805887F, 7.4F, 1.8F, 7.4F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.8F, 14.8F);
      localPath.cubicTo(14.794113F, 14.8F, 15.6F, 15.605887F, 15.6F, 16.6F);
      localPath.cubicTo(15.6F, 17.594112F, 14.794113F, 18.4F, 13.8F, 18.4F);
      localPath.cubicTo(12.805887F, 18.4F, 12.0F, 17.594112F, 12.0F, 16.6F);
      localPath.cubicTo(12.0F, 15.605887F, 12.805887F, 14.8F, 13.8F, 14.8F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.2F, 0.0F);
      localPath.cubicTo(7.194112F, 0.0F, 8.0F, 0.805887F, 8.0F, 1.8F);
      localPath.cubicTo(8.0F, 2.794112F, 7.194112F, 3.6F, 6.2F, 3.6F);
      localPath.cubicTo(5.205887F, 3.6F, 4.4F, 2.794112F, 4.4F, 1.8F);
      localPath.cubicTo(4.4F, 0.805887F, 5.205887F, 0.0F, 6.2F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.8F, 0.0F);
      localPath.cubicTo(14.794113F, 0.0F, 15.6F, 0.805887F, 15.6F, 1.8F);
      localPath.cubicTo(15.6F, 2.794112F, 14.794113F, 3.6F, 13.8F, 3.6F);
      localPath.cubicTo(12.805887F, 3.6F, 12.0F, 2.794112F, 12.0F, 1.8F);
      localPath.cubicTo(12.0F, 0.805887F, 12.805887F, 0.0F, 13.8F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.2F, 14.8F);
      localPath.cubicTo(7.194112F, 14.8F, 8.0F, 15.605887F, 8.0F, 16.6F);
      localPath.cubicTo(8.0F, 17.594112F, 7.194112F, 18.4F, 6.2F, 18.4F);
      localPath.cubicTo(5.205887F, 18.4F, 4.4F, 17.594112F, 4.4F, 16.6F);
      localPath.cubicTo(4.4F, 15.605887F, 5.205887F, 14.8F, 6.2F, 14.8F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.200001F, 7.4F);
      ((Path)localObject2).cubicTo(19.194113F, 7.4F, 20.0F, 8.205887F, 20.0F, 9.2F);
      ((Path)localObject2).cubicTo(20.0F, 10.194113F, 19.194113F, 11.0F, 18.200001F, 11.0F);
      ((Path)localObject2).cubicTo(17.205889F, 11.0F, 16.400002F, 10.194113F, 16.400002F, 9.2F);
      ((Path)localObject2).cubicTo(16.400002F, 8.205887F, 17.205889F, 7.4F, 18.200001F, 7.4F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 12.0F, 0.7071068F, 0.7071068F, -4.970562F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(12.0F, 14.4F);
      ((Path)localObject1).lineTo(8.687623F, 15.838614F);
      ((Path)localObject1).cubicTo(8.484995F, 15.926618F, 8.249391F, 15.833697F, 8.161387F, 15.631068F);
      ((Path)localObject1).cubicTo(8.117241F, 15.529425F, 8.117241F, 15.414021F, 8.161387F, 15.312377F);
      ((Path)localObject1).lineTo(9.6F, 12.0F);
      ((Path)localObject1).lineTo(9.6F, 12.0F);
      ((Path)localObject1).lineTo(8.161387F, 8.687623F);
      ((Path)localObject1).cubicTo(8.073382F, 8.484995F, 8.166303F, 8.249391F, 8.368932F, 8.161387F);
      ((Path)localObject1).cubicTo(8.470575F, 8.117241F, 8.58598F, 8.117241F, 8.687623F, 8.161387F);
      ((Path)localObject1).lineTo(12.0F, 9.6F);
      ((Path)localObject1).lineTo(12.0F, 9.6F);
      ((Path)localObject1).lineTo(15.312377F, 8.161387F);
      ((Path)localObject1).cubicTo(15.515005F, 8.073382F, 15.750609F, 8.166303F, 15.838614F, 8.368932F);
      ((Path)localObject1).cubicTo(15.882759F, 8.470575F, 15.882759F, 8.58598F, 15.838614F, 8.687623F);
      ((Path)localObject1).lineTo(14.4F, 12.0F);
      ((Path)localObject1).lineTo(14.4F, 12.0F);
      ((Path)localObject1).lineTo(15.838614F, 15.312377F);
      ((Path)localObject1).cubicTo(15.926618F, 15.515005F, 15.833697F, 15.750609F, 15.631068F, 15.838614F);
      ((Path)localObject1).cubicTo(15.529425F, 15.882759F, 15.414021F, 15.882759F, 15.312377F, 15.838614F);
      ((Path)localObject1).lineTo(12.0F, 14.4F);
      ((Path)localObject1).lineTo(12.0F, 14.4F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.live_user_level_40_49
 * JD-Core Version:    0.7.0.1
 */