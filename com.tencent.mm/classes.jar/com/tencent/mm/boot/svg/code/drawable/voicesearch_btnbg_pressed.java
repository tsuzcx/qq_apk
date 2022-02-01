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

public class voicesearch_btnbg_pressed
  extends c
{
  private final int height = 268;
  private final int width = 268;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 268;
      return 268;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2763307);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(18.457394F, 1.681452F);
      localPath.cubicTo(20.597382F, 1.171502F, 22.807369F, 1.051513F, 24.997356F, 1.021516F);
      localPath.lineTo(217.01625F, 1.021516F);
      localPath.cubicTo(222.21622F, 1.051513F, 227.63618F, 0.6115558F, 232.57616F, 2.611362F);
      localPath.cubicTo(241.65611F, 5.981036F, 248.11607F, 15.270136F, 247.98607F, 24.979197F);
      localPath.cubicTo(247.99606F, 91.65274F, 248.01607F, 158.32628F, 247.97607F, 224.99982F);
      localPath.cubicTo(248.32607F, 237.78859F, 236.85614F, 249.29747F, 224.05621F, 248.97751F);
      localPath.cubicTo(157.36659F, 249.00749F, 90.686974F, 249.00749F, 23.997362F, 248.97751F);
      localPath.cubicTo(11.187435F, 249.32747F, -0.2924983F, 237.84859F, 0.00749996F, 225.04982F);
      localPath.cubicTo(-0.002499986F, 158.36627F, -0.002499986F, 91.672737F, 0.00749996F, 24.989195F);
      localPath.cubicTo(-0.182499F, 14.170242F, 7.917454F, 4.011227F, 18.457394F, 1.681452F);
      localPath.lineTo(18.457394F, 1.681452F);
      localPath.close();
      localPath.moveTo(19.43778F, 4.559776F);
      localPath.cubicTo(10.841597F, 6.329068F, 3.814715F, 14.165934F, 3.214982F, 22.952419F);
      localPath.cubicTo(2.83515F, 27.650539F, 3.085039F, 32.368652F, 3.055053F, 37.066772F);
      localPath.cubicTo(3.055053F, 96.023193F, 3.055053F, 154.96962F, 3.045057F, 213.91603F);
      localPath.cubicTo(3.085039F, 218.58417F, 2.795168F, 223.28229F, 3.314937F, 227.94043F);
      localPath.cubicTo(4.0746F, 234.84767F, 8.882466F, 240.93523F, 15.039733F, 243.95403F);
      localPath.cubicTo(20.627253F, 246.66293F, 27.014418F, 245.86327F, 33.021751F, 245.96323F);
      localPath.cubicTo(93.674828F, 245.93323F, 154.33791F, 245.93323F, 214.99098F, 245.96323F);
      localPath.cubicTo(220.98833F, 245.86327F, 227.37549F, 246.64294F, 232.96301F, 243.95403F);
      localPath.cubicTo(240.10983F, 240.52539F, 245.09763F, 232.94843F, 244.9277F, 224.94164F);
      localPath.cubicTo(244.99767F, 160.97722F, 244.89771F, 97.012794F, 244.97768F, 33.048382F);
      localPath.cubicTo(244.9077F, 27.570572F, 245.50745F, 21.792883F, 243.22845F, 16.634947F);
      localPath.cubicTo(239.9599F, 9.177929F, 232.16336F, 3.890044F, 223.94701F, 4.059976F);
      localPath.cubicTo(157.98628F, 3.980008F, 92.025566F, 4.09996F, 26.06484F, 4.0F);
      localPath.cubicTo(23.845825F, 4.039984F, 21.616814F, 4.129948F, 19.43778F, 4.559776F);
      localPath.lineTo(19.43778F, 4.559776F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1842205);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.43778F, 1.559776F);
      ((Path)localObject2).cubicTo(19.616814F, 1.129948F, 21.845825F, 1.039984F, 24.06484F, 1.0F);
      ((Path)localObject2).cubicTo(90.025566F, 1.09996F, 155.98628F, 0.980008F, 221.94701F, 1.059976F);
      ((Path)localObject2).cubicTo(230.16336F, 0.890044F, 237.9599F, 6.177929F, 241.22845F, 13.634946F);
      ((Path)localObject2).cubicTo(243.50745F, 18.792883F, 242.9077F, 24.570572F, 242.97768F, 30.048382F);
      ((Path)localObject2).cubicTo(242.89771F, 94.012794F, 242.99767F, 157.97722F, 242.9277F, 221.94164F);
      ((Path)localObject2).cubicTo(243.09763F, 229.94843F, 238.10983F, 237.52539F, 230.96301F, 240.95403F);
      ((Path)localObject2).cubicTo(225.37549F, 243.64294F, 218.98833F, 242.86327F, 212.99098F, 242.96323F);
      ((Path)localObject2).cubicTo(152.33791F, 242.93323F, 91.674828F, 242.93323F, 31.021751F, 242.96323F);
      ((Path)localObject2).cubicTo(25.014418F, 242.86327F, 18.627253F, 243.66293F, 13.039733F, 240.95403F);
      ((Path)localObject2).cubicTo(6.882466F, 237.93523F, 2.0746F, 231.84767F, 1.314937F, 224.94043F);
      ((Path)localObject2).cubicTo(0.795168F, 220.28229F, 1.085039F, 215.58417F, 1.045057F, 210.91603F);
      ((Path)localObject2).cubicTo(1.055052F, 151.96962F, 1.055052F, 93.023193F, 1.055052F, 34.066772F);
      ((Path)localObject2).cubicTo(1.085039F, 29.368652F, 0.8351501F, 24.650539F, 1.214981F, 19.952419F);
      ((Path)localObject2).cubicTo(1.814715F, 11.165934F, 8.841597F, 3.329068F, 17.43778F, 1.559776F);
      ((Path)localObject2).lineTo(17.43778F, 1.559776F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voicesearch_btnbg_pressed
 * JD-Core Version:    0.7.0.1
 */