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

public class live_user_level_10_19
  extends c
{
  private final int height = 24;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
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
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.6F, 4.8F);
      localPath.cubicTo(5.594112F, 4.8F, 6.4F, 5.605887F, 6.4F, 6.6F);
      localPath.cubicTo(6.4F, 7.594112F, 5.594112F, 8.4F, 4.6F, 8.4F);
      localPath.cubicTo(3.605887F, 8.4F, 2.8F, 7.594112F, 2.8F, 6.6F);
      localPath.cubicTo(2.8F, 5.605887F, 3.605887F, 4.8F, 4.6F, 4.8F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.4F, 15.599999F);
      localPath.cubicTo(16.394112F, 15.599999F, 17.199999F, 16.405888F, 17.199999F, 17.4F);
      localPath.cubicTo(17.199999F, 18.394112F, 16.394112F, 19.199999F, 15.4F, 19.199999F);
      localPath.cubicTo(14.405887F, 19.199999F, 13.599999F, 18.394112F, 13.599999F, 17.4F);
      localPath.cubicTo(13.599999F, 16.405888F, 14.405887F, 15.599999F, 15.4F, 15.599999F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 11.414213F, 0.7071068F, 0.7071068F, -3.556349F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.0F, 14.4F);
      ((Path)localObject).lineTo(6.687624F, 15.838614F);
      ((Path)localObject).cubicTo(6.484995F, 15.926618F, 6.249391F, 15.833697F, 6.161387F, 15.631068F);
      ((Path)localObject).cubicTo(6.117241F, 15.529425F, 6.117241F, 15.414021F, 6.161387F, 15.312377F);
      ((Path)localObject).lineTo(7.6F, 12.0F);
      ((Path)localObject).lineTo(7.6F, 12.0F);
      ((Path)localObject).lineTo(6.161387F, 8.687623F);
      ((Path)localObject).cubicTo(6.073382F, 8.484995F, 6.166303F, 8.249391F, 6.368931F, 8.161387F);
      ((Path)localObject).cubicTo(6.470576F, 8.117241F, 6.585979F, 8.117241F, 6.687624F, 8.161387F);
      ((Path)localObject).lineTo(10.0F, 9.6F);
      ((Path)localObject).lineTo(10.0F, 9.6F);
      ((Path)localObject).lineTo(13.312377F, 8.161387F);
      ((Path)localObject).cubicTo(13.515005F, 8.073382F, 13.750609F, 8.166303F, 13.838614F, 8.368932F);
      ((Path)localObject).cubicTo(13.882759F, 8.470575F, 13.882759F, 8.58598F, 13.838614F, 8.687623F);
      ((Path)localObject).lineTo(12.4F, 12.0F);
      ((Path)localObject).lineTo(12.4F, 12.0F);
      ((Path)localObject).lineTo(13.838614F, 15.312377F);
      ((Path)localObject).cubicTo(13.926618F, 15.515005F, 13.833697F, 15.750609F, 13.631068F, 15.838614F);
      ((Path)localObject).cubicTo(13.529425F, 15.882759F, 13.414021F, 15.882759F, 13.312377F, 15.838614F);
      ((Path)localObject).lineTo(10.0F, 14.4F);
      ((Path)localObject).lineTo(10.0F, 14.4F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-2565928);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(20.0F, 0.0F);
      ((Path)localObject).lineTo(20.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject, c.instancePaint(localPaint1, paramVarArgs));
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.live_user_level_10_19
 * JD-Core Version:    0.7.0.1
 */