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

public class sos_logo_icon
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      ((Paint)localObject2).setColor(-372399);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -129.0F, 0.0F, 1.0F, -93.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -271.0F, 0.0F, 1.0F, 88.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 395.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.014925F, 8.014925F);
      ((Path)localObject2).lineTo(16.343283F, 3.179105F);
      ((Path)localObject2).cubicTo(16.61194F, 2.597015F, 16.61194F, 2.014926F, 16.38806F, 1.477612F);
      ((Path)localObject2).cubicTo(16.164179F, 0.940299F, 15.716418F, 0.5373135F, 15.089552F, 0.3134328F);
      ((Path)localObject2).lineTo(14.597014F, 0.1343284F);
      ((Path)localObject2).cubicTo(14.373135F, 0.04477612F, 14.149254F, 0.0F, 13.925373F, 0.0F);
      ((Path)localObject2).cubicTo(12.940298F, 0.0F, 12.134329F, 0.6716418F, 11.910448F, 1.656717F);
      ((Path)localObject2).lineTo(10.880597F, 6.895523F);
      ((Path)localObject2).cubicTo(10.61194F, 8.149254F, 11.014925F, 9.313433F, 11.731343F, 9.582089F);
      ((Path)localObject2).cubicTo(11.820895F, 9.626865F, 11.910448F, 9.626865F, 12.044776F, 9.626865F);
      ((Path)localObject2).cubicTo(12.716418F, 9.671641F, 13.522388F, 9.0F, 14.014925F, 8.014925F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.507463F, 11.417911F);
      ((Path)localObject2).cubicTo(8.597015F, 10.656716F, 7.656716F, 9.850746F, 6.402985F, 9.582089F);
      ((Path)localObject2).lineTo(2.552239F, 8.641791F);
      ((Path)localObject2).cubicTo(2.373134F, 8.597015F, 2.19403F, 8.597015F, 2.014926F, 8.597015F);
      ((Path)localObject2).cubicTo(0.9850746F, 8.597015F, 0.1343284F, 9.358209F, 0.04477612F, 10.38806F);
      ((Path)localObject2).lineTo(0.0F, 10.925373F);
      ((Path)localObject2).cubicTo(0.0F, 11.552238F, 0.223881F, 12.134329F, 0.6268657F, 12.537313F);
      ((Path)localObject2).cubicTo(0.9850746F, 12.895522F, 1.477612F, 13.074627F, 2.014926F, 13.074627F);
      ((Path)localObject2).cubicTo(2.059701F, 13.074627F, 2.104478F, 13.074627F, 2.149254F, 13.074627F);
      ((Path)localObject2).lineTo(6.089552F, 12.895522F);
      ((Path)localObject2).cubicTo(7.38806F, 12.761194F, 8.417911F, 12.134329F, 8.507463F, 11.417911F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.402985F, 15.313433F);
      ((Path)localObject2).cubicTo(8.641791F, 15.089552F, 7.61194F, 15.80597F, 7.119403F, 16.97015F);
      ((Path)localObject2).lineTo(3.358209F, 25.208956F);
      ((Path)localObject2).cubicTo(3.089552F, 25.791044F, 3.089552F, 26.373135F, 3.358209F, 26.910448F);
      ((Path)localObject2).cubicTo(3.626866F, 27.447762F, 4.074627F, 27.850746F, 4.701492F, 28.02985F);
      ((Path)localObject2).lineTo(5.19403F, 28.208956F);
      ((Path)localObject2).lineTo(5.238806F, 28.208956F);
      ((Path)localObject2).cubicTo(5.328358F, 28.208956F, 5.417911F, 28.208956F, 5.507463F, 28.208956F);
      ((Path)localObject2).cubicTo(6.582089F, 28.208956F, 7.791045F, 27.716417F, 8.059702F, 26.686567F);
      ((Path)localObject2).lineTo(10.253732F, 17.910448F);
      ((Path)localObject2).cubicTo(10.477612F, 16.701492F, 10.164179F, 15.537313F, 9.402985F, 15.313433F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.985075F, 16.298508F);
      ((Path)localObject2).cubicTo(15.402986F, 15.671641F, 14.641791F, 15.268657F, 14.014925F, 15.268657F);
      ((Path)localObject2).cubicTo(13.746268F, 15.268657F, 13.522388F, 15.358209F, 13.343284F, 15.492537F);
      ((Path)localObject2).cubicTo(12.761194F, 15.985075F, 12.850746F, 17.194031F, 13.61194F, 18.268656F);
      ((Path)localObject2).lineTo(20.731344F, 28.656717F);
      ((Path)localObject2).cubicTo(21.134329F, 29.283583F, 21.805969F, 29.597015F, 22.477612F, 29.597015F);
      ((Path)localObject2).cubicTo(22.97015F, 29.597015F, 23.462687F, 29.41791F, 23.865671F, 29.104477F);
      ((Path)localObject2).lineTo(24.268656F, 28.791044F);
      ((Path)localObject2).cubicTo(24.761194F, 28.38806F, 25.02985F, 27.850746F, 25.074627F, 27.223881F);
      ((Path)localObject2).cubicTo(25.119404F, 26.597015F, 24.895523F, 26.014925F, 24.492537F, 25.567163F);
      ((Path)localObject2).lineTo(15.985075F, 16.298508F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(29.955223F, 11.059702F);
      ((Path)localObject2).cubicTo(29.865671F, 9.761194F, 28.791044F, 8.820895F, 27.492537F, 9.0F);
      ((Path)localObject2).lineTo(16.925373F, 10.567164F);
      ((Path)localObject2).cubicTo(15.671641F, 10.746268F, 14.686567F, 11.507463F, 14.731343F, 12.313433F);
      ((Path)localObject2).cubicTo(14.776119F, 13.119403F, 15.80597F, 13.746268F, 17.104477F, 13.746268F);
      ((Path)localObject2).lineTo(27.537313F, 13.880597F);
      ((Path)localObject2).lineTo(27.58209F, 13.880597F);
      ((Path)localObject2).cubicTo(28.253731F, 13.880597F, 28.925373F, 13.567164F, 29.41791F, 13.074627F);
      ((Path)localObject2).cubicTo(29.820896F, 12.626865F, 30.0F, 12.089552F, 30.0F, 11.552238F);
      ((Path)localObject2).lineTo(29.955223F, 11.059702F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sos_logo_icon
 * JD-Core Version:    0.7.0.1
 */