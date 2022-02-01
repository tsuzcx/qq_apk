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

public class icon_volume_off
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(32.0F, 0.0F);
      ((Path)localObject3).lineTo(32.0F, 32.0F);
      ((Path)localObject3).lineTo(0.0F, 32.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.53033F, 7.46967F);
      localPath.lineTo(14.029F, 10.96867F);
      localPath.lineTo(16.292892F, 8.707107F);
      localPath.cubicTo(16.683418F, 8.316583F, 17.316582F, 8.316583F, 17.707108F, 8.707107F);
      localPath.cubicTo(17.894644F, 8.894643F, 18.0F, 9.148997F, 18.0F, 9.414213F);
      localPath.lineTo(18.0F, 14.93967F);
      localPath.lineTo(26.086679F, 23.02602F);
      localPath.lineTo(25.02602F, 24.086679F);
      localPath.lineTo(9.46967F, 8.53033F);
      localPath.lineTo(10.53033F, 7.46967F);
      localPath.close();
      localPath.moveTo(10.939F, 11.999213F);
      localPath.lineTo(18.0F, 19.060213F);
      localPath.lineTo(18.0F, 22.585787F);
      localPath.cubicTo(18.0F, 23.138071F, 17.552284F, 23.585787F, 17.0F, 23.585787F);
      localPath.cubicTo(16.734783F, 23.585787F, 16.480429F, 23.480429F, 16.292892F, 23.292892F);
      localPath.lineTo(13.0F, 19.999214F);
      localPath.lineTo(9.0F, 20.0F);
      localPath.cubicTo(8.447715F, 20.0F, 8.0F, 19.552284F, 8.0F, 19.0F);
      localPath.lineTo(8.0F, 13.0F);
      localPath.cubicTo(8.0F, 12.447716F, 8.447715F, 12.0F, 9.0F, 12.0F);
      localPath.lineTo(10.939F, 11.999213F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.066365F, 2.934637F);
      ((Path)localObject2).cubicTo(2.106616F, 3.975143F, 2.75F, 5.412436F, 2.75F, 7.0F);
      ((Path)localObject2).cubicTo(2.75F, 8.587819F, 2.106409F, 10.025319F, 1.065864F, 11.065864F);
      ((Path)localObject2).lineTo(0.00520382F, 10.005204F);
      ((Path)localObject2).cubicTo(0.7743025F, 9.236105F, 1.25F, 8.173605F, 1.25F, 7.0F);
      ((Path)localObject2).cubicTo(1.25F, 5.826395F, 0.7743025F, 4.763895F, 0.00520382F, 3.994796F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.188176F, 0.8138079F);
      ((Path)localObject2).cubicTo(4.771032F, 2.397168F, 5.75F, 4.584259F, 5.75F, 7.0F);
      ((Path)localObject2).cubicTo(5.75F, 9.416246F, 4.770623F, 11.603745F, 3.187184F, 13.187184F);
      ((Path)localObject2).lineTo(2.126524F, 12.126524F);
      ((Path)localObject2).cubicTo(3.438516F, 10.814532F, 4.25F, 9.002032F, 4.25F, 7.0F);
      ((Path)localObject2).cubicTo(4.25F, 4.998468F, 3.438922F, 3.186374F, 2.127508F, 1.87446F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_volume_off
 * JD-Core Version:    0.7.0.1
 */