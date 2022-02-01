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

public class nearby_live_person_sns_flag
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0075F, 0.0F, 1.0F, 6.0075F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-35310);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.115198F, 3.548153F);
      ((Path)localObject2).cubicTo(9.992102F, 6.809542F, 5.117682F, 12.105915F, 2.394064F, 18.534681F);
      ((Path)localObject2).lineTo(2.39406F, 18.534681F);
      ((Path)localObject2).lineTo(30.072395F, 18.534681F);
      ((Path)localObject2).cubicTo(30.268282F, 18.525818F, 30.465553F, 18.521341F, 30.664114F, 18.521341F);
      ((Path)localObject2).cubicTo(30.808889F, 18.521341F, 30.953159F, 18.524183F, 31.096865F, 18.529818F);
      ((Path)localObject2).lineTo(16.115198F, 3.548153F);
      ((Path)localObject2).lineTo(16.115198F, 3.548153F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-371630);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.971075F, 2.213128F);
      ((Path)localObject2).cubicTo(22.492136F, 0.785987F, 26.341696F, 0.0F, 30.375F, 0.0F);
      ((Path)localObject2).cubicTo(33.468155F, 0.0F, 36.453354F, 0.4623826F, 39.265244F, 1.321798F);
      ((Path)localObject2).lineTo(39.265244F, 1.321798F);
      ((Path)localObject2).lineTo(39.265244F, 22.547537F);
      ((Path)localObject2).cubicTo(38.989044F, 22.22621F, 38.696899F, 21.920715F, 38.39027F, 21.632324F);
      ((Path)localObject2).lineTo(18.971075F, 2.213128F);
      ((Path)localObject2).lineTo(18.971075F, 2.213128F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-14313);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.31755F, 21.498095F);
      ((Path)localObject2).cubicTo(0.4608516F, 24.306078F, 0.0F, 27.286724F, 0.0F, 30.375F);
      ((Path)localObject2).cubicTo(0.0F, 34.415264F, 0.7887666F, 38.27132F, 2.220745F, 41.797535F);
      ((Path)localObject2).lineTo(2.220745F, 41.797535F);
      ((Path)localObject2).lineTo(22.015423F, 22.002855F);
      ((Path)localObject2).lineTo(22.035555F, 22.022987F);
      ((Path)localObject2).cubicTo(22.216772F, 21.842041F, 22.403875F, 21.666986F, 22.596596F, 21.498095F);
      ((Path)localObject2).lineTo(1.31755F, 21.498095F);
      ((Path)localObject2).lineTo(1.31755F, 21.498095F);
      ((Path)localObject2).lineTo(1.31755F, 21.498095F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-6631134);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.557318F, 44.651863F);
      ((Path)localObject2).cubicTo(6.821535F, 50.770866F, 12.118754F, 55.641357F, 18.547567F, 58.361462F);
      ((Path)localObject2).lineTo(18.547567F, 58.361462F);
      ((Path)localObject2).lineTo(18.547567F, 31.424805F);
      ((Path)localObject2).cubicTo(18.530169F, 31.173021F, 18.521341F, 30.919359F, 18.521341F, 30.664114F);
      ((Path)localObject2).cubicTo(18.521341F, 30.32152F, 18.534672F, 29.982765F, 18.560856F, 29.648325F);
      ((Path)localObject2).lineTo(3.557318F, 44.651863F);
      ((Path)localObject2).lineTo(3.557318F, 44.651863F);
      ((Path)localObject2).lineTo(3.557318F, 44.651863F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-10039264);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(21.510983F, 59.436432F);
      ((Path)localObject2).cubicTo(24.315125F, 60.290569F, 27.291361F, 60.75F, 30.375F, 60.75F);
      ((Path)localObject2).cubicTo(34.415047F, 60.75F, 38.270927F, 59.961193F, 41.797016F, 58.52919F);
      ((Path)localObject2).lineTo(41.797016F, 58.52919F);
      ((Path)localObject2).lineTo(22.440626F, 39.172798F);
      ((Path)localObject2).cubicTo(22.113337F, 38.884712F, 21.802992F, 38.579884F, 21.510983F, 38.259911F);
      ((Path)localObject2).lineTo(21.510983F, 59.436432F);
      ((Path)localObject2).lineTo(21.510983F, 59.436432F);
      ((Path)localObject2).lineTo(21.510983F, 59.436432F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16731650);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(44.651302F, 57.192574F);
      ((Path)localObject2).cubicTo(50.766045F, 53.9305F, 55.634102F, 48.638245F, 58.355457F, 42.215771F);
      ((Path)localObject2).lineTo(58.355465F, 42.215771F);
      ((Path)localObject2).lineTo(31.197884F, 42.215771F);
      ((Path)localObject2).cubicTo(31.020803F, 42.224331F, 30.842846F, 42.228657F, 30.664114F, 42.228657F);
      ((Path)localObject2).cubicTo(30.321379F, 42.228657F, 29.982491F, 42.215321F, 29.647923F, 42.189194F);
      ((Path)localObject2).lineTo(44.651302F, 57.192574F);
      ((Path)localObject2).lineTo(44.651302F, 57.192574F);
      ((Path)localObject2).lineTo(44.651302F, 57.192574F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-11369488);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(59.432144F, 39.252357F);
      ((Path)localObject2).cubicTo(60.289032F, 36.444244F, 60.75F, 33.46344F, 60.75F, 30.375F);
      ((Path)localObject2).cubicTo(60.75F, 26.342056F, 59.96397F, 22.492655F, 58.536766F, 18.971634F);
      ((Path)localObject2).lineTo(58.536766F, 18.971634F);
      ((Path)localObject2).lineTo(39.56673F, 37.941669F);
      ((Path)localObject2).cubicTo(39.180679F, 38.409534F, 38.759396F, 38.847954F, 38.307461F, 39.252357F);
      ((Path)localObject2).lineTo(59.432144F, 39.252357F);
      ((Path)localObject2).lineTo(59.432144F, 39.252357F);
      ((Path)localObject2).lineTo(59.432144F, 39.252357F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-10197008);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(57.201698F, 16.115799F);
      ((Path)localObject1).cubicTo(53.942539F, 9.997103F, 48.651283F, 5.124949F, 42.228657F, 2.400013F);
      ((Path)localObject1).lineTo(42.228657F, 30.375F);
      ((Path)localObject1).lineTo(42.225487F, 30.375F);
      ((Path)localObject1).cubicTo(42.227596F, 30.471058F, 42.228657F, 30.567432F, 42.228657F, 30.664114F);
      ((Path)localObject1).cubicTo(42.228657F, 30.809046F, 42.225811F, 30.953468F, 42.220173F, 31.097324F);
      ((Path)localObject1).lineTo(57.201698F, 16.115799F);
      ((Path)localObject1).lineTo(57.201698F, 16.115799F);
      ((Path)localObject1).lineTo(57.201698F, 16.115799F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.nearby_live_person_sns_flag
 * JD-Core Version:    0.7.0.1
 */