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

public class ime_chinese_qwerty_selected
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-12799119);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -102.0F, 0.0F, 1.0F, -1119.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 102.0F, 0.0F, 1.0F, 1119.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.5F, 0.0F);
      ((Path)localObject2).cubicTo(39.58326F, 0.0F, 51.0F, 11.416739F, 51.0F, 25.5F);
      ((Path)localObject2).cubicTo(51.0F, 39.58326F, 39.58326F, 51.0F, 25.5F, 51.0F);
      ((Path)localObject2).cubicTo(11.416739F, 51.0F, 0.0F, 39.58326F, 0.0F, 25.5F);
      ((Path)localObject2).cubicTo(0.0F, 11.416739F, 11.416739F, 0.0F, 25.5F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.517464F, 34.832485F);
      ((Path)localObject2).lineTo(17.613981F, 34.832485F);
      ((Path)localObject2).cubicTo(16.887747F, 34.832485F, 16.29896F, 35.421215F, 16.29896F, 36.147507F);
      ((Path)localObject2).lineTo(16.29896F, 38.117985F);
      ((Path)localObject2).cubicTo(16.29896F, 38.844219F, 16.887747F, 39.433006F, 17.613981F, 39.433006F);
      ((Path)localObject2).lineTo(33.517464F, 39.433006F);
      ((Path)localObject2).cubicTo(34.243698F, 39.433006F, 34.832485F, 38.844219F, 34.832485F, 38.117985F);
      ((Path)localObject2).lineTo(34.832485F, 36.147507F);
      ((Path)localObject2).cubicTo(34.832485F, 35.421215F, 34.243698F, 34.832485F, 33.517464F, 34.832485F);
      ((Path)localObject2).lineTo(33.517464F, 34.832485F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.870527F, 24.908525F);
      ((Path)localObject2).lineTo(19.05982F, 24.908525F);
      ((Path)localObject2).cubicTo(18.333586F, 24.908525F, 17.744799F, 25.497255F, 17.744799F, 26.223549F);
      ((Path)localObject2).lineTo(17.744799F, 29.902752F);
      ((Path)localObject2).cubicTo(17.744799F, 30.629045F, 18.333586F, 31.217775F, 19.05982F, 31.217775F);
      ((Path)localObject2).lineTo(22.870527F, 31.217775F);
      ((Path)localObject2).cubicTo(23.596819F, 31.217775F, 24.185549F, 30.629045F, 24.185549F, 29.902752F);
      ((Path)localObject2).lineTo(24.185549F, 26.223549F);
      ((Path)localObject2).cubicTo(24.185549F, 25.497255F, 23.596819F, 24.908525F, 22.870527F, 24.908525F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.071568F, 24.908525F);
      ((Path)localObject2).lineTo(28.26086F, 24.908525F);
      ((Path)localObject2).cubicTo(27.534626F, 24.908525F, 26.945839F, 25.497255F, 26.945839F, 26.223549F);
      ((Path)localObject2).lineTo(26.945839F, 29.902752F);
      ((Path)localObject2).cubicTo(26.945839F, 30.629045F, 27.534626F, 31.217775F, 28.26086F, 31.217775F);
      ((Path)localObject2).lineTo(32.071568F, 31.217775F);
      ((Path)localObject2).cubicTo(32.797859F, 31.217775F, 33.386589F, 30.629045F, 33.386589F, 29.902752F);
      ((Path)localObject2).lineTo(33.386589F, 26.223549F);
      ((Path)localObject2).cubicTo(33.386589F, 25.497255F, 32.797859F, 24.908525F, 32.071568F, 24.908525F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.538098F, 24.842775F);
      ((Path)localObject2).lineTo(9.727392F, 24.842775F);
      ((Path)localObject2).cubicTo(9.0011F, 24.842775F, 8.41237F, 25.431562F, 8.41237F, 26.157797F);
      ((Path)localObject2).lineTo(8.41237F, 29.837002F);
      ((Path)localObject2).cubicTo(8.41237F, 30.563293F, 9.0011F, 31.152023F, 9.727392F, 31.152023F);
      ((Path)localObject2).lineTo(13.538098F, 31.152023F);
      ((Path)localObject2).cubicTo(14.264334F, 31.152023F, 14.853121F, 30.563293F, 14.853121F, 29.837002F);
      ((Path)localObject2).lineTo(14.853121F, 26.157797F);
      ((Path)localObject2).cubicTo(14.853121F, 25.431562F, 14.264334F, 24.842775F, 13.538098F, 24.842775F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.403996F, 24.842775F);
      ((Path)localObject2).lineTo(37.593346F, 24.842775F);
      ((Path)localObject2).cubicTo(36.867111F, 24.842775F, 36.278324F, 25.431562F, 36.278324F, 26.157797F);
      ((Path)localObject2).lineTo(36.278324F, 29.837002F);
      ((Path)localObject2).cubicTo(36.278324F, 30.563293F, 36.867111F, 31.152023F, 37.593346F, 31.152023F);
      ((Path)localObject2).lineTo(41.404053F, 31.152023F);
      ((Path)localObject2).cubicTo(42.130287F, 31.152023F, 42.719074F, 30.563293F, 42.719074F, 29.837002F);
      ((Path)localObject2).lineTo(42.719074F, 26.157797F);
      ((Path)localObject2).cubicTo(42.719074F, 25.431562F, 42.130287F, 24.842775F, 41.404053F, 24.842775F);
      ((Path)localObject2).lineTo(41.403996F, 24.842775F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.870527F, 15.707485F);
      ((Path)localObject2).lineTo(19.05982F, 15.707485F);
      ((Path)localObject2).cubicTo(18.333586F, 15.707485F, 17.744799F, 16.296215F, 17.744799F, 17.022509F);
      ((Path)localObject2).lineTo(17.744799F, 20.701712F);
      ((Path)localObject2).cubicTo(17.744799F, 21.428005F, 18.333586F, 22.016735F, 19.05982F, 22.016735F);
      ((Path)localObject2).lineTo(22.870527F, 22.016735F);
      ((Path)localObject2).cubicTo(23.596819F, 22.016735F, 24.185549F, 21.428005F, 24.185549F, 20.701712F);
      ((Path)localObject2).lineTo(24.185549F, 17.022509F);
      ((Path)localObject2).cubicTo(24.185549F, 16.296215F, 23.596819F, 15.707485F, 22.870527F, 15.707485F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.071568F, 15.707485F);
      ((Path)localObject2).lineTo(28.26086F, 15.707485F);
      ((Path)localObject2).cubicTo(27.534626F, 15.707485F, 26.945839F, 16.296215F, 26.945839F, 17.022509F);
      ((Path)localObject2).lineTo(26.945839F, 20.701712F);
      ((Path)localObject2).cubicTo(26.945839F, 21.428005F, 27.534626F, 22.016735F, 28.26086F, 22.016735F);
      ((Path)localObject2).lineTo(32.071568F, 22.016735F);
      ((Path)localObject2).cubicTo(32.797859F, 22.016735F, 33.386589F, 21.428005F, 33.386589F, 20.701712F);
      ((Path)localObject2).lineTo(33.386589F, 17.022509F);
      ((Path)localObject2).cubicTo(33.386589F, 16.296215F, 32.797859F, 15.707485F, 32.071568F, 15.707485F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.538098F, 15.641734F);
      ((Path)localObject2).lineTo(9.727392F, 15.641734F);
      ((Path)localObject2).cubicTo(9.0011F, 15.641734F, 8.41237F, 16.230522F, 8.41237F, 16.956757F);
      ((Path)localObject2).lineTo(8.41237F, 20.635962F);
      ((Path)localObject2).cubicTo(8.41237F, 21.362253F, 9.0011F, 21.950983F, 9.727392F, 21.950983F);
      ((Path)localObject2).lineTo(13.538098F, 21.950983F);
      ((Path)localObject2).cubicTo(14.264334F, 21.950983F, 14.853121F, 21.362253F, 14.853121F, 20.635962F);
      ((Path)localObject2).lineTo(14.853121F, 16.956757F);
      ((Path)localObject2).cubicTo(14.853121F, 16.230522F, 14.264334F, 15.641734F, 13.538098F, 15.641734F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.403996F, 15.641734F);
      ((Path)localObject2).lineTo(37.593346F, 15.641734F);
      ((Path)localObject2).cubicTo(36.867111F, 15.641734F, 36.278324F, 16.230522F, 36.278324F, 16.956757F);
      ((Path)localObject2).lineTo(36.278324F, 20.635962F);
      ((Path)localObject2).cubicTo(36.278324F, 21.362253F, 36.867111F, 21.950983F, 37.593346F, 21.950983F);
      ((Path)localObject2).lineTo(41.404053F, 21.950983F);
      ((Path)localObject2).cubicTo(42.130287F, 21.950983F, 42.719074F, 21.362253F, 42.719074F, 20.635962F);
      ((Path)localObject2).lineTo(42.719074F, 16.956757F);
      ((Path)localObject2).cubicTo(42.719074F, 16.230522F, 42.130287F, 15.641734F, 41.404053F, 15.641734F);
      ((Path)localObject2).lineTo(41.403996F, 15.641734F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_chinese_qwerty_selected
 * JD-Core Version:    0.7.0.1
 */