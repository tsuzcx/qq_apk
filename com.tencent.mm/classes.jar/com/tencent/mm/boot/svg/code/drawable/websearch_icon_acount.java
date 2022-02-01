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

public class websearch_icon_acount
  extends c
{
  private final int height = 14;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 14;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-5066062);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, -265.0F, 0.0F, 1.0F, -604.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 198.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(15.225F, 14.85F);
      ((Path)localObject3).lineTo(15.225F, 14.486597F);
      ((Path)localObject3).cubicTo(15.225F, 14.314545F, 15.04851F, 14.032515F, 14.894857F, 13.957565F);
      ((Path)localObject3).lineTo(10.649592F, 11.88678F);
      ((Path)localObject3).cubicTo(9.504656F, 11.328295F, 9.22168F, 9.977185F, 10.042003F, 9.004776F);
      ((Path)localObject3).lineTo(10.313152F, 8.683356F);
      ((Path)localObject3).cubicTo(10.726646F, 8.193201F, 11.1F, 7.173293F, 11.1F, 6.532639F);
      ((Path)localObject3).lineTo(11.1F, 5.250155F);
      ((Path)localObject3).cubicTo(11.1F, 4.091186F, 10.159192F, 3.15F, 9.0F, 3.15F);
      ((Path)localObject3).cubicTo(7.842232F, 3.15F, 6.9F, 4.091402F, 6.9F, 5.249685F);
      ((Path)localObject3).lineTo(6.9F, 6.531968F);
      ((Path)localObject3).cubicTo(6.9F, 7.174248F, 7.27181F, 8.190363F, 7.686809F, 8.682234F);
      ((Path)localObject3).lineTo(7.957958F, 9.00361F);
      ((Path)localObject3).cubicTo(8.779977F, 9.977895F, 8.493911F, 11.327738F, 7.35054F, 11.88569F);
      ((Path)localObject3).lineTo(3.105275F, 13.957333F);
      ((Path)localObject3).cubicTo(2.952763F, 14.031756F, 2.775F, 14.316507F, 2.775F, 14.486597F);
      ((Path)localObject3).lineTo(2.775F, 14.85F);
      ((Path)localObject3).lineTo(15.225F, 14.85F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(1.875F, 15.0F);
      ((Path)localObject3).lineTo(1.875F, 14.486597F);
      ((Path)localObject3).cubicTo(1.875F, 13.972781F, 2.248613F, 13.373931F, 2.710573F, 13.148499F);
      ((Path)localObject3).lineTo(6.955838F, 11.076858F);
      ((Path)localObject3).cubicTo(7.571533F, 10.776405F, 7.714695F, 10.110947F, 7.270084F, 9.58398F);
      ((Path)localObject3).lineTo(6.998935F, 9.262604F);
      ((Path)localObject3).cubicTo(6.447238F, 8.608714F, 6.0F, 7.387122F, 6.0F, 6.531968F);
      ((Path)localObject3).lineTo(6.0F, 5.249685F);
      ((Path)localObject3).cubicTo(6.0F, 3.593005F, 7.346517F, 2.25F, 9.0F, 2.25F);
      ((Path)localObject3).cubicTo(10.656855F, 2.25F, 12.0F, 3.594735F, 12.0F, 5.250155F);
      ((Path)localObject3).lineTo(12.0F, 6.532639F);
      ((Path)localObject3).cubicTo(12.0F, 7.386972F, 11.550699F, 8.612145F, 11.001065F, 9.26368F);
      ((Path)localObject3).lineTo(10.729916F, 9.585099F);
      ((Path)localObject3).cubicTo(10.287774F, 10.109213F, 10.425891F, 10.776299F, 11.044162F, 11.077883F);
      ((Path)localObject3).lineTo(15.289427F, 13.148668F);
      ((Path)localObject3).cubicTo(15.750901F, 13.37377F, 16.125F, 13.968878F, 16.125F, 14.486597F);
      ((Path)localObject3).lineTo(16.125F, 15.0F);
      ((Path)localObject3).cubicTo(16.125F, 15.414213F, 15.789213F, 15.75F, 15.375F, 15.75F);
      ((Path)localObject3).lineTo(2.625F, 15.75F);
      ((Path)localObject3).cubicTo(2.210786F, 15.75F, 1.875F, 15.414213F, 1.875F, 15.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.25F, 13.5F);
      ((Path)localObject2).lineTo(9.0F, 11.25F);
      ((Path)localObject2).lineTo(9.75F, 13.5F);
      ((Path)localObject2).lineTo(9.0F, 14.25F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.websearch_icon_acount
 * JD-Core Version:    0.7.0.1
 */