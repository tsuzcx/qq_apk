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

public class honey_pay_child_card_icon
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -293.0F, 0.0F, 1.0F, -215.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 303.19998F, 0.0F, 1.0F, 220.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 24.644575F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(11.508657F, 0.4408429F);
      localPath.lineTo(11.479648F, 0.6462817F);
      localPath.lineTo(11.479648F, 0.6462817F);
      localPath.cubicTo(11.36745F, 1.371254F, 11.206317F, 1.974454F, 10.96552F, 2.442488F);
      localPath.cubicTo(11.932671F, 2.827633F, 12.893431F, 3.018502F, 13.850246F, 3.018502F);
      localPath.cubicTo(14.776219F, 3.018502F, 15.705886F, 2.83974F, 16.642611F, 2.479116F);
      localPath.cubicTo(16.391024F, 2.005092F, 16.224495F, 1.389715F, 16.109432F, 0.6462933F);
      localPath.lineTo(16.098797F, 0.5708966F);
      localPath.cubicTo(16.654797F, 0.5172117F, 17.180828F, 0.4262411F, 17.676817F, 0.2983071F);
      localPath.cubicTo(17.680021F, 0.3320973F, 17.685226F, 0.3668233F, 17.690605F, 0.4015653F);
      localPath.cubicTo(17.799803F, 1.107086F, 17.965223F, 1.636409F, 18.143034F, 1.867279F);
      localPath.cubicTo(18.170641F, 1.903124F, 18.234476F, 1.948799F, 18.333895F, 2.002626F);
      localPath.lineTo(18.415121F, 2.044498F);
      localPath.lineTo(18.617365F, 2.136783F);
      localPath.lineTo(18.73826F, 2.186881F);
      localPath.lineTo(18.73826F, 2.186881F);
      localPath.lineTo(18.872259F, 2.239407F);
      localPath.lineTo(19.179321F, 2.351111F);
      localPath.lineTo(19.538067F, 2.470636F);
      localPath.lineTo(21.245394F, 2.988276F);
      localPath.lineTo(21.753624F, 3.146965F);
      localPath.cubicTo(23.324688F, 3.653235F, 24.316851F, 4.118065F, 24.998936F, 4.782281F);
      localPath.cubicTo(26.270208F, 6.020251F, 27.101254F, 8.49441F, 27.582541F, 12.244688F);
      localPath.cubicTo(27.638781F, 12.682921F, 27.329113F, 13.083772F, 26.890881F, 13.140012F);
      localPath.cubicTo(26.452646F, 13.196252F, 26.051796F, 12.886585F, 25.995556F, 12.448352F);
      localPath.cubicTo(25.556906F, 9.030297F, 24.822456F, 6.843726F, 23.882679F, 5.928567F);
      localPath.cubicTo(23.494389F, 5.550448F, 22.828026F, 5.212371F, 21.798307F, 4.850141F);
      localPath.lineTo(21.533258F, 4.759042F);
      localPath.lineTo(20.956556F, 4.572936F);
      localPath.lineTo(19.05043F, 3.994516F);
      localPath.lineTo(18.580647F, 3.83799F);
      localPath.cubicTo(18.442617F, 3.789758F, 18.313656F, 3.74228F, 18.193089F, 3.694906F);
      localPath.lineTo(18.02F, 3.624F);
      localPath.lineTo(17.847391F, 3.706777F);
      localPath.cubicTo(16.524078F, 4.312838F, 15.189793F, 4.618502F, 13.850246F, 4.618502F);
      localPath.cubicTo(12.5107F, 4.618502F, 11.176414F, 4.312838F, 9.853103F, 3.706777F);
      localPath.lineTo(9.629631F, 3.598646F);
      localPath.cubicTo(9.446014F, 3.678345F, 9.240075F, 3.757104F, 9.008646F, 3.837981F);
      localPath.lineTo(8.5389F, 3.99451F);
      localPath.lineTo(6.632959F, 4.572929F);
      localPath.cubicTo(5.112212F, 5.045824F, 4.192463F, 5.455902F, 3.707158F, 5.92854F);
      localPath.cubicTo(2.27841F, 7.319995F, 1.74367F, 8.969028F, 1.599298F, 12.379262F);
      localPath.cubicTo(1.580609F, 12.820694F, 1.207608F, 13.163396F, 0.7661757F, 13.144708F);
      localPath.cubicTo(0.3247433F, 13.12602F, -0.01795869F, 12.753018F, 0.0007294001F, 12.311586F);
      localPath.cubicTo(0.1607326F, 8.532144F, 0.8162841F, 6.51055F, 2.590845F, 4.782308F);
      localPath.cubicTo(3.272874F, 4.118083F, 4.264953F, 3.653247F, 5.835877F, 3.146972F);
      localPath.lineTo(6.344062F, 2.988282F);
      localPath.lineTo(8.051221F, 2.470643F);
      localPath.lineTo(8.409926F, 2.351121F);
      localPath.lineTo(8.716951F, 2.239419F);
      localPath.cubicTo(8.810626F, 2.203629F, 8.895607F, 2.169352F, 8.971814F, 2.136798F);
      localPath.lineTo(9.174031F, 2.044517F);
      localPath.cubicTo(9.320476F, 1.972273F, 9.411578F, 1.912111F, 9.44608F, 1.867309F);
      localPath.cubicTo(9.623876F, 1.636435F, 9.789283F, 1.107105F, 9.898471F, 0.4015769F);
      localPath.cubicTo(9.91922F, 0.2675086F, 9.93742F, 0.1336781F, 9.953316F, 0.001007602F);
      localPath.cubicTo(10.440354F, 0.1906173F, 10.959245F, 0.337662F, 11.508657F, 0.4408429F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 3.396918F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.403095F, 0.0F);
      ((Path)localObject2).cubicTo(17.349241F, 0.0F, 19.903095F, 4.0F, 20.903095F, 7.0F);
      ((Path)localObject2).cubicTo(21.269762F, 8.1F, 21.305433F, 10.141111F, 21.154245F, 11.989518F);
      ((Path)localObject2).lineTo(21.124731F, 12.323216F);
      ((Path)localObject2).cubicTo(20.971918F, 13.928772F, 20.68062F, 15.331079F, 20.349648F, 15.752873F);
      ((Path)localObject2).cubicTo(20.011801F, 22.298628F, 16.764383F, 25.564749F, 10.677546F, 25.252918F);
      ((Path)localObject2).cubicTo(6.538687F, 25.42742F, 3.70634F, 23.648806F, 2.079014F, 20.40283F);
      ((Path)localObject2).cubicTo(1.398886F, 19.0462F, 0.9581257F, 17.517353F, 0.7044137F, 15.848712F);
      ((Path)localObject2).cubicTo(0.047248F, 15.356162F, -0.3362326F, 9.23518F, 0.4030954F, 7.0F);
      ((Path)localObject2).cubicTo(1.395402F, 4.0F, 3.456949F, 0.0F, 10.403095F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.744595F, 8.000831F);
      ((Path)localObject2).lineTo(10.062186F, 8.000831F);
      ((Path)localObject2).cubicTo(8.096122F, 8.014057F, 3.753352F, 8.238005F, 2.026707F, 12.029608F);
      ((Path)localObject2).cubicTo(2.034924F, 13.172156F, 2.097425F, 14.242786F, 2.221829F, 15.240163F);
      ((Path)localObject2).lineTo(2.221829F, 15.240163F);
      ((Path)localObject2).lineTo(2.303953F, 15.829731F);
      ((Path)localObject2).cubicTo(3.080975F, 20.861963F, 5.56729F, 23.867601F, 10.684419F, 23.654657F);
      ((Path)localObject2).cubicTo(16.438965F, 23.946882F, 19.116028F, 20.682047F, 18.76103F, 13.456037F);
      ((Path)localObject2).lineTo(18.76103F, 13.456037F);
      ((Path)localObject2).lineTo(18.718054F, 12.755856F);
      ((Path)localObject2).cubicTo(18.689436F, 12.364964F, 18.652538F, 11.963215F, 18.607365F, 11.550549F);
      ((Path)localObject2).cubicTo(16.729448F, 8.218679F, 12.629914F, 8.013475F, 10.744595F, 8.000831F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.honey_pay_child_card_icon
 * JD-Core Version:    0.7.0.1
 */