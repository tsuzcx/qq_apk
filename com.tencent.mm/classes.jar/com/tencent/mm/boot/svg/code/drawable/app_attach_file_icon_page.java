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

public class app_attach_file_icon_page
  extends c
{
  private final int height = 90;
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
      return 90;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-28160);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(68.0F, 87.0F);
      ((Path)localObject2).cubicTo(68.0F, 88.656853F, 66.656853F, 90.0F, 65.0F, 90.0F);
      ((Path)localObject2).lineTo(3.0F, 90.0F);
      ((Path)localObject2).cubicTo(1.343146F, 90.0F, 2.029061E-016F, 88.656853F, 0.0F, 87.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3378176);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(49.0F, 22.0F);
      ((Path)localObject2).cubicTo(47.343147F, 22.0F, 46.0F, 20.656855F, 46.0F, 19.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(37.106209F, 52.971058F);
      ((Path)localObject1).cubicTo(34.776943F, 55.213036F, 30.973436F, 58.624981F, 25.695686F, 63.206902F);
      ((Path)localObject1).lineTo(24.528019F, 62.039234F);
      ((Path)localObject1).cubicTo(29.109938F, 56.761486F, 32.521885F, 52.957977F, 34.763863F, 50.628712F);
      ((Path)localObject1).lineTo(37.106209F, 52.971058F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(38.017532F, 52.078514F);
      ((Path)localObject1).lineTo(35.656406F, 49.717388F);
      ((Path)localObject1).cubicTo(37.835155F, 47.538635F, 40.33514F, 45.187698F, 43.156349F, 42.66457F);
      ((Path)localObject1).lineTo(43.15633F, 42.664551F);
      ((Path)localObject1).cubicTo(43.654514F, 42.219006F, 44.41396F, 42.240166F, 44.886559F, 42.712765F);
      ((Path)localObject1).lineTo(45.022152F, 42.848412F);
      ((Path)localObject1).cubicTo(45.494728F, 43.320988F, 45.515888F, 44.080395F, 45.070366F, 44.578552F);
      ((Path)localObject1).cubicTo(42.547234F, 47.399769F, 40.196289F, 49.899757F, 38.017532F, 52.078514F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(24.729465F, 64.044548F);
      ((Path)localObject1).cubicTo(24.411987F, 64.319397F, 24.089516F, 64.598213F, 23.762051F, 64.880997F);
      ((Path)localObject1).lineTo(21.824629F, 66.261612F);
      ((Path)localObject1).cubicTo(21.711334F, 66.342346F, 21.554043F, 66.315948F, 21.473309F, 66.20266F);
      ((Path)localObject1).cubicTo(21.410967F, 66.115173F, 21.410967F, 65.997772F, 21.473309F, 65.910294F);
      ((Path)localObject1).lineTo(22.853926F, 63.97287F);
      ((Path)localObject1).cubicTo(23.136705F, 63.645405F, 23.415522F, 63.322933F, 23.690374F, 63.005455F);
      ((Path)localObject1).lineTo(24.729465F, 64.044548F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(21.076923F, 67.446152F);
      ((Path)localObject1).lineTo(47.661537F, 67.446152F);
      ((Path)localObject1).cubicTo(48.069378F, 67.446152F, 48.400002F, 67.776772F, 48.400002F, 68.184616F);
      ((Path)localObject1).cubicTo(48.400002F, 68.592453F, 48.069378F, 68.92308F, 47.661537F, 68.92308F);
      ((Path)localObject1).lineTo(21.076923F, 68.92308F);
      ((Path)localObject1).cubicTo(20.669083F, 68.92308F, 20.338461F, 68.592453F, 20.338461F, 68.184616F);
      ((Path)localObject1).cubicTo(20.338461F, 67.776772F, 20.669083F, 67.446152F, 21.076923F, 67.446152F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_page
 * JD-Core Version:    0.7.0.1
 */