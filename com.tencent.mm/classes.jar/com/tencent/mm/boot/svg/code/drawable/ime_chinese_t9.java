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

public class ime_chinese_t9
  extends c
{
  private final int height = 51;
  private final int width = 51;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 51;
      return 51;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -102.0F, 0.0F, 1.0F, -1120.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 102.0F, 0.0F, 1.0F, 1120.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-11842483);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.5F, 0.0F);
      ((Path)localObject2).cubicTo(39.58326F, 0.0F, 51.0F, 11.416739F, 51.0F, 25.5F);
      ((Path)localObject2).cubicTo(51.0F, 39.58326F, 39.58326F, 51.0F, 25.5F, 51.0F);
      ((Path)localObject2).cubicTo(11.416739F, 51.0F, 0.0F, 39.58326F, 0.0F, 25.5F);
      ((Path)localObject2).cubicTo(0.0F, 11.416739F, 11.416739F, 0.0F, 25.5F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-591880);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(15.999982F, 32.200005F);
      ((Path)localObject1).lineTo(15.999982F, 32.200005F);
      ((Path)localObject1).cubicTo(16.552265F, 32.200005F, 16.999981F, 32.737263F, 16.999981F, 33.400002F);
      ((Path)localObject1).cubicTo(16.999981F, 33.400002F, 16.999981F, 33.400002F, 16.999981F, 33.400002F);
      ((Path)localObject1).lineTo(16.999981F, 35.800003F);
      ((Path)localObject1).lineTo(16.999981F, 35.800003F);
      ((Path)localObject1).cubicTo(16.999981F, 36.462742F, 16.552265F, 37.0F, 15.999982F, 37.0F);
      ((Path)localObject1).lineTo(10.0F, 37.0F);
      ((Path)localObject1).lineTo(10.0F, 37.0F);
      ((Path)localObject1).cubicTo(9.447716F, 37.0F, 9.0F, 36.462742F, 9.0F, 35.800003F);
      ((Path)localObject1).lineTo(9.0F, 33.400002F);
      ((Path)localObject1).lineTo(9.0F, 33.400002F);
      ((Path)localObject1).cubicTo(9.0F, 32.737263F, 9.447716F, 32.200005F, 10.0F, 32.200005F);
      ((Path)localObject1).lineTo(15.999982F, 32.200005F);
      ((Path)localObject1).lineTo(15.999982F, 32.200005F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.999992F, 32.200005F);
      ((Path)localObject1).lineTo(27.999992F, 32.200005F);
      ((Path)localObject1).cubicTo(28.552275F, 32.200005F, 28.99999F, 32.737263F, 28.99999F, 33.400002F);
      ((Path)localObject1).lineTo(28.99999F, 35.800003F);
      ((Path)localObject1).lineTo(28.99999F, 35.800003F);
      ((Path)localObject1).cubicTo(28.99999F, 36.462742F, 28.552275F, 37.0F, 27.999992F, 37.0F);
      ((Path)localObject1).lineTo(22.00001F, 37.0F);
      ((Path)localObject1).lineTo(22.00001F, 37.0F);
      ((Path)localObject1).cubicTo(21.447725F, 37.0F, 21.00001F, 36.462742F, 21.00001F, 35.800003F);
      ((Path)localObject1).lineTo(21.00001F, 33.400002F);
      ((Path)localObject1).lineTo(21.00001F, 33.400002F);
      ((Path)localObject1).cubicTo(21.00001F, 32.737263F, 21.447725F, 32.200005F, 22.00001F, 32.200005F);
      ((Path)localObject1).lineTo(27.999992F, 32.200005F);
      ((Path)localObject1).lineTo(27.999992F, 32.200005F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(40.0F, 32.200005F);
      ((Path)localObject1).lineTo(40.0F, 32.200005F);
      ((Path)localObject1).cubicTo(40.552284F, 32.200005F, 41.0F, 32.737263F, 41.0F, 33.400002F);
      ((Path)localObject1).lineTo(41.0F, 35.800003F);
      ((Path)localObject1).lineTo(41.0F, 35.800003F);
      ((Path)localObject1).cubicTo(41.0F, 36.462742F, 40.552284F, 37.0F, 40.0F, 37.0F);
      ((Path)localObject1).lineTo(34.000019F, 37.0F);
      ((Path)localObject1).lineTo(34.000019F, 37.0F);
      ((Path)localObject1).cubicTo(33.447735F, 37.0F, 33.000019F, 36.462742F, 33.000019F, 35.800003F);
      ((Path)localObject1).lineTo(33.000019F, 33.400002F);
      ((Path)localObject1).lineTo(33.000019F, 33.400002F);
      ((Path)localObject1).cubicTo(33.000019F, 32.737263F, 33.447735F, 32.200005F, 34.000019F, 32.200005F);
      ((Path)localObject1).lineTo(40.0F, 32.200005F);
      ((Path)localObject1).lineTo(40.0F, 32.200005F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(15.999982F, 22.600002F);
      ((Path)localObject1).lineTo(15.999982F, 22.600002F);
      ((Path)localObject1).cubicTo(16.552265F, 22.600002F, 16.999981F, 23.13726F, 16.999981F, 23.799999F);
      ((Path)localObject1).lineTo(16.999981F, 26.200001F);
      ((Path)localObject1).lineTo(16.999981F, 26.200001F);
      ((Path)localObject1).cubicTo(16.999981F, 26.86274F, 16.552265F, 27.399998F, 15.999982F, 27.399998F);
      ((Path)localObject1).lineTo(10.0F, 27.399998F);
      ((Path)localObject1).lineTo(10.0F, 27.399998F);
      ((Path)localObject1).cubicTo(9.447716F, 27.399998F, 9.0F, 26.86274F, 9.0F, 26.200001F);
      ((Path)localObject1).lineTo(9.0F, 23.799999F);
      ((Path)localObject1).lineTo(9.0F, 23.799999F);
      ((Path)localObject1).cubicTo(9.0F, 23.13726F, 9.447716F, 22.600002F, 10.0F, 22.600002F);
      ((Path)localObject1).lineTo(15.999982F, 22.600002F);
      ((Path)localObject1).lineTo(15.999982F, 22.600002F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.999992F, 22.600002F);
      ((Path)localObject1).lineTo(27.999992F, 22.600002F);
      ((Path)localObject1).cubicTo(28.552275F, 22.600002F, 28.99999F, 23.13726F, 28.99999F, 23.799999F);
      ((Path)localObject1).lineTo(28.99999F, 26.200001F);
      ((Path)localObject1).lineTo(28.99999F, 26.200001F);
      ((Path)localObject1).cubicTo(28.99999F, 26.86274F, 28.552275F, 27.399998F, 27.999992F, 27.399998F);
      ((Path)localObject1).lineTo(22.00001F, 27.399998F);
      ((Path)localObject1).lineTo(22.00001F, 27.399998F);
      ((Path)localObject1).cubicTo(21.447725F, 27.399998F, 21.00001F, 26.86274F, 21.00001F, 26.200001F);
      ((Path)localObject1).lineTo(21.00001F, 23.799999F);
      ((Path)localObject1).lineTo(21.00001F, 23.799999F);
      ((Path)localObject1).cubicTo(21.00001F, 23.13726F, 21.447725F, 22.600002F, 22.00001F, 22.600002F);
      ((Path)localObject1).lineTo(27.999992F, 22.600002F);
      ((Path)localObject1).lineTo(27.999992F, 22.600002F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(40.0F, 22.600002F);
      ((Path)localObject1).lineTo(40.0F, 22.600002F);
      ((Path)localObject1).cubicTo(40.552284F, 22.600002F, 41.0F, 23.13726F, 41.0F, 23.799999F);
      ((Path)localObject1).lineTo(41.0F, 26.200001F);
      ((Path)localObject1).lineTo(41.0F, 26.200001F);
      ((Path)localObject1).cubicTo(41.0F, 26.86274F, 40.552284F, 27.399998F, 40.0F, 27.399998F);
      ((Path)localObject1).lineTo(34.000019F, 27.399998F);
      ((Path)localObject1).lineTo(34.000019F, 27.399998F);
      ((Path)localObject1).cubicTo(33.447735F, 27.399998F, 33.000019F, 26.86274F, 33.000019F, 26.200001F);
      ((Path)localObject1).lineTo(33.000019F, 23.799999F);
      ((Path)localObject1).lineTo(33.000019F, 23.799999F);
      ((Path)localObject1).cubicTo(33.000019F, 23.13726F, 33.447735F, 22.600002F, 34.000019F, 22.600002F);
      ((Path)localObject1).lineTo(40.0F, 22.600002F);
      ((Path)localObject1).lineTo(40.0F, 22.600002F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(15.999982F, 13.0F);
      ((Path)localObject1).lineTo(15.999982F, 13.0F);
      ((Path)localObject1).cubicTo(16.552265F, 13.0F, 16.999981F, 13.537258F, 16.999981F, 14.199998F);
      ((Path)localObject1).lineTo(16.999981F, 16.599998F);
      ((Path)localObject1).lineTo(16.999981F, 16.599998F);
      ((Path)localObject1).cubicTo(16.999981F, 17.262737F, 16.552265F, 17.799995F, 15.999982F, 17.799995F);
      ((Path)localObject1).lineTo(10.0F, 17.799995F);
      ((Path)localObject1).lineTo(10.0F, 17.799995F);
      ((Path)localObject1).cubicTo(9.447716F, 17.799995F, 9.0F, 17.262737F, 9.0F, 16.599998F);
      ((Path)localObject1).lineTo(9.0F, 14.199998F);
      ((Path)localObject1).lineTo(9.0F, 14.199998F);
      ((Path)localObject1).cubicTo(9.0F, 13.537258F, 9.447716F, 13.0F, 10.0F, 13.0F);
      ((Path)localObject1).lineTo(15.999982F, 13.0F);
      ((Path)localObject1).lineTo(15.999982F, 13.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.999992F, 13.0F);
      ((Path)localObject1).lineTo(27.999992F, 13.0F);
      ((Path)localObject1).cubicTo(28.552275F, 13.0F, 28.99999F, 13.537258F, 28.99999F, 14.199998F);
      ((Path)localObject1).lineTo(28.99999F, 16.599998F);
      ((Path)localObject1).lineTo(28.99999F, 16.599998F);
      ((Path)localObject1).cubicTo(28.99999F, 17.262737F, 28.552275F, 17.799995F, 27.999992F, 17.799995F);
      ((Path)localObject1).lineTo(22.00001F, 17.799995F);
      ((Path)localObject1).lineTo(22.00001F, 17.799995F);
      ((Path)localObject1).cubicTo(21.447725F, 17.799995F, 21.00001F, 17.262737F, 21.00001F, 16.599998F);
      ((Path)localObject1).lineTo(21.00001F, 14.199998F);
      ((Path)localObject1).lineTo(21.00001F, 14.199998F);
      ((Path)localObject1).cubicTo(21.00001F, 13.537258F, 21.447725F, 13.0F, 22.00001F, 13.0F);
      ((Path)localObject1).lineTo(27.999992F, 13.0F);
      ((Path)localObject1).lineTo(27.999992F, 13.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(40.0F, 13.0F);
      ((Path)localObject1).lineTo(40.0F, 13.0F);
      ((Path)localObject1).cubicTo(40.552284F, 13.0F, 41.0F, 13.537258F, 41.0F, 14.199998F);
      ((Path)localObject1).lineTo(41.0F, 16.599998F);
      ((Path)localObject1).lineTo(41.0F, 16.599998F);
      ((Path)localObject1).cubicTo(41.0F, 17.262737F, 40.552284F, 17.799995F, 40.0F, 17.799995F);
      ((Path)localObject1).lineTo(34.000019F, 17.799995F);
      ((Path)localObject1).lineTo(34.000019F, 17.799995F);
      ((Path)localObject1).cubicTo(33.447735F, 17.799995F, 33.000019F, 17.262737F, 33.000019F, 16.599998F);
      ((Path)localObject1).lineTo(33.000019F, 14.199998F);
      ((Path)localObject1).lineTo(33.000019F, 14.199998F);
      ((Path)localObject1).cubicTo(33.000019F, 13.537258F, 33.447735F, 13.0F, 34.000019F, 13.0F);
      ((Path)localObject1).lineTo(40.0F, 13.0F);
      ((Path)localObject1).lineTo(40.0F, 13.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_chinese_t9
 * JD-Core Version:    0.7.0.1
 */