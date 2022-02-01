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

public class app_attach_file_icon_hongbao
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3130053);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.640368F, 0.0F);
      ((Path)localObject2).lineTo(3.359632F, 0.0F);
      ((Path)localObject2).cubicTo(1.507137F, 0.0F, 0.0F, 1.546539F, 0.0F, 3.447466F);
      ((Path)localObject2).lineTo(0.0F, 28.552534F);
      ((Path)localObject2).cubicTo(0.0F, 30.453461F, 1.507137F, 32.0F, 3.359632F, 32.0F);
      ((Path)localObject2).lineTo(20.640368F, 32.0F);
      ((Path)localObject2).cubicTo(22.492863F, 32.0F, 24.0F, 30.453461F, 24.0F, 28.552534F);
      ((Path)localObject2).lineTo(24.0F, 3.447466F);
      ((Path)localObject2).cubicTo(24.0F, 1.546539F, 22.492863F, 0.0F, 20.640368F, 0.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3130053);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.349695F, 0.8540089F);
      ((Path)localObject2).cubicTo(21.890169F, 0.8540089F, 23.150509F, 2.147928F, 23.150509F, 3.729447F);
      ((Path)localObject2).lineTo(23.150509F, 27.97871F);
      ((Path)localObject2).cubicTo(23.150509F, 29.560089F, 21.890169F, 30.85401F, 20.349695F, 30.85401F);
      ((Path)localObject2).lineTo(3.666169F, 30.85401F);
      ((Path)localObject2).cubicTo(2.125695F, 30.85401F, 0.8653559F, 29.560089F, 0.8653559F, 27.97871F);
      ((Path)localObject2).lineTo(0.8653559F, 3.729447F);
      ((Path)localObject2).cubicTo(0.8653559F, 2.147928F, 2.125695F, 0.8540089F, 3.666169F, 0.8540089F);
      ((Path)localObject2).lineTo(20.349695F, 0.8540089F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3787210);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.623322F, 14.219947F);
      ((Path)localObject2).cubicTo(15.623322F, 16.315601F, 13.943865F, 18.014566F, 11.872272F, 18.014566F);
      ((Path)localObject2).cubicTo(9.800678F, 18.014566F, 8.121221F, 16.315601F, 8.121221F, 14.219947F);
      ((Path)localObject2).cubicTo(8.121221F, 12.124292F, 9.800678F, 10.425327F, 11.872272F, 10.425327F);
      ((Path)localObject2).cubicTo(13.943865F, 10.425327F, 15.623322F, 12.124292F, 15.623322F, 14.219947F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3787210);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.349695F, 2.001832F);
      ((Path)localObject2).lineTo(3.666169F, 2.001832F);
      ((Path)localObject2).cubicTo(1.999729F, 2.001832F, 0.6439322F, 3.373239F, 0.6439322F, 5.059173F);
      ((Path)localObject2).lineTo(0.6439322F, 10.650695F);
      ((Path)localObject2).cubicTo(1.897085F, 11.316235F, 4.20678F, 13.519567F, 7.911593F, 14.286336F);
      ((Path)localObject2).cubicTo(10.613695F, 14.845571F, 13.402169F, 14.845571F, 16.104271F, 14.286336F);
      ((Path)localObject2).cubicTo(19.809084F, 13.519567F, 22.11878F, 11.316235F, 23.371933F, 10.650695F);
      ((Path)localObject2).lineTo(23.371933F, 5.059173F);
      ((Path)localObject2).cubicTo(23.371933F, 3.373239F, 22.016136F, 2.001832F, 20.349695F, 2.001832F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1618869);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.349695F, 0.6301504F);
      ((Path)localObject2).lineTo(3.666169F, 0.6301504F);
      ((Path)localObject2).cubicTo(1.999729F, 0.6301504F, 0.6439322F, 2.001558F, 0.6439322F, 3.687491F);
      ((Path)localObject2).lineTo(0.6439322F, 10.494185F);
      ((Path)localObject2).cubicTo(1.897085F, 11.159726F, 4.20678F, 12.147748F, 7.911593F, 12.914655F);
      ((Path)localObject2).cubicTo(10.613695F, 13.473889F, 13.402169F, 13.473889F, 16.104271F, 12.914655F);
      ((Path)localObject2).cubicTo(19.809084F, 12.147748F, 22.11878F, 11.159726F, 23.371933F, 10.494185F);
      ((Path)localObject2).lineTo(23.371933F, 3.687491F);
      ((Path)localObject2).cubicTo(23.371933F, 2.001558F, 22.016136F, 0.6301504F, 20.349695F, 0.6301504F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3130053);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.885831F, 13.054018F);
      ((Path)localObject2).cubicTo(15.885831F, 15.296306F, 14.088949F, 17.114195F, 11.872272F, 17.114195F);
      ((Path)localObject2).cubicTo(9.655728F, 17.114195F, 7.858848F, 15.296306F, 7.858848F, 13.054018F);
      ((Path)localObject2).cubicTo(7.858848F, 10.81173F, 9.655728F, 8.993841F, 11.872272F, 8.993841F);
      ((Path)localObject2).cubicTo(14.088949F, 8.993841F, 15.885831F, 10.81173F, 15.885831F, 13.054018F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-338636);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.474034F, 13.054018F);
      ((Path)localObject2).cubicTo(15.474034F, 15.066275F, 13.861559F, 16.697477F, 11.872407F, 16.697477F);
      ((Path)localObject2).cubicTo(9.883119F, 16.697477F, 8.270644F, 15.066275F, 8.270644F, 13.054018F);
      ((Path)localObject2).cubicTo(8.270644F, 11.041761F, 9.883119F, 9.410558F, 11.872407F, 9.410558F);
      ((Path)localObject2).cubicTo(13.861559F, 9.410558F, 15.474034F, 11.041761F, 15.474034F, 13.054018F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-23767);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(13.78861F, 11.023107F);
      ((Path)localObject1).cubicTo(13.894508F, 10.915977F, 13.894508F, 10.742323F, 13.78861F, 10.635195F);
      ((Path)localObject1).cubicTo(13.682848F, 10.528067F, 13.510916F, 10.528067F, 13.405152F, 10.635195F);
      ((Path)localObject1).lineTo(11.872272F, 12.185881F);
      ((Path)localObject1).lineTo(10.339525F, 10.635195F);
      ((Path)localObject1).cubicTo(10.233627F, 10.528067F, 10.061831F, 10.528067F, 9.955933F, 10.635195F);
      ((Path)localObject1).cubicTo(9.850034F, 10.742323F, 9.850034F, 10.915977F, 9.955933F, 11.023107F);
      ((Path)localObject1).lineTo(11.601085F, 12.687367F);
      ((Path)localObject1).lineTo(11.601085F, 12.786951F);
      ((Path)localObject1).lineTo(10.279051F, 12.786951F);
      ((Path)localObject1).cubicTo(10.129355F, 12.786951F, 10.007864F, 12.909854F, 10.007864F, 13.061288F);
      ((Path)localObject1).cubicTo(10.007864F, 13.212858F, 10.129355F, 13.335624F, 10.279051F, 13.335624F);
      ((Path)localObject1).lineTo(11.601085F, 13.335624F);
      ((Path)localObject1).lineTo(11.601085F, 14.107195F);
      ((Path)localObject1).lineTo(10.279051F, 14.107195F);
      ((Path)localObject1).cubicTo(10.129355F, 14.107195F, 10.007864F, 14.230098F, 10.007864F, 14.381531F);
      ((Path)localObject1).cubicTo(10.007864F, 14.533102F, 10.129355F, 14.655868F, 10.279051F, 14.655868F);
      ((Path)localObject1).lineTo(11.601085F, 14.655868F);
      ((Path)localObject1).lineTo(11.601085F, 15.838943F);
      ((Path)localObject1).cubicTo(11.601085F, 15.990513F, 11.722576F, 16.113279F, 11.872272F, 16.113279F);
      ((Path)localObject1).cubicTo(12.022101F, 16.113279F, 12.143457F, 15.990513F, 12.143457F, 15.838943F);
      ((Path)localObject1).lineTo(12.143457F, 14.655868F);
      ((Path)localObject1).lineTo(13.465491F, 14.655868F);
      ((Path)localObject1).cubicTo(13.615322F, 14.655868F, 13.736678F, 14.533102F, 13.736678F, 14.381531F);
      ((Path)localObject1).cubicTo(13.736678F, 14.230098F, 13.615322F, 14.107195F, 13.465491F, 14.107195F);
      ((Path)localObject1).lineTo(12.143457F, 14.107195F);
      ((Path)localObject1).lineTo(12.143457F, 13.335624F);
      ((Path)localObject1).lineTo(13.465491F, 13.335624F);
      ((Path)localObject1).cubicTo(13.615322F, 13.335624F, 13.736678F, 13.212858F, 13.736678F, 13.061288F);
      ((Path)localObject1).cubicTo(13.736678F, 12.909854F, 13.615322F, 12.786951F, 13.465491F, 12.786951F);
      ((Path)localObject1).lineTo(12.143457F, 12.786951F);
      ((Path)localObject1).lineTo(12.143457F, 12.687367F);
      ((Path)localObject1).lineTo(13.78861F, 11.023107F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_hongbao
 * JD-Core Version:    0.7.0.1
 */