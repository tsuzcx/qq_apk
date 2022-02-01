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

public class finder_filled_activity
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1.setColor(-16268960);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.8987941F, -0.4383712F, 6.718276F, 0.4383712F, 0.8987941F, -2.884415F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(8.847653F, 21.693031F);
      ((Path)localObject).lineTo(1.653587F, 6.839659F);
      ((Path)localObject).cubicTo(1.539361F, 6.593355F, 1.637476F, 6.300771F, 1.877145F, 6.172997F);
      ((Path)localObject).cubicTo(1.900391F, 6.142013F, 1.929869F, 6.116235F, 1.963684F, 6.097321F);
      ((Path)localObject).cubicTo(2.677745F, 5.588069F, 3.467421F, 5.19408F, 4.303834F, 4.92976F);
      ((Path)localObject).cubicTo(5.152813F, 4.660108F, 6.034893F, 4.508536F, 6.925235F, 4.479312F);
      ((Path)localObject).lineTo(7.285813F, 4.479312F);
      ((Path)localObject).cubicTo(8.293078F, 4.481297F, 9.294437F, 4.63311F, 10.256975F, 4.92976F);
      ((Path)localObject).cubicTo(11.380366F, 5.325626F, 12.554385F, 5.559802F, 13.743763F, 5.625252F);
      ((Path)localObject).cubicTo(14.93367F, 5.625252F, 15.456508F, 5.1712F, 16.116365F, 4.594627F);
      ((Path)localObject).lineTo(16.275021F, 4.457691F);
      ((Path)localObject).cubicTo(16.440296F, 4.302206F, 16.657457F, 4.213596F, 16.884396F, 4.209044F);
      ((Path)localObject).cubicTo(17.011053F, 4.209268F, 17.135416F, 4.242826F, 17.244974F, 4.30634F);
      ((Path)localObject).cubicTo(17.638004F, 4.540573F, 17.627188F, 5.027057F, 17.587523F, 5.354983F);
      ((Path)localObject).cubicTo(17.523689F, 5.769555F, 17.41363F, 6.175684F, 17.259398F, 6.565787F);
      ((Path)localObject).cubicTo(16.820477F, 7.741183F, 16.139988F, 8.811624F, 15.261796F, 9.708112F);
      ((Path)localObject).cubicTo(14.769872F, 10.205898F, 14.190518F, 10.609F, 13.552657F, 10.897294F);
      ((Path)localObject).lineTo(13.43006F, 10.947744F);
      ((Path)localObject).cubicTo(12.888613F, 11.168726F, 12.309384F, 11.282542F, 11.724527F, 11.282878F);
      ((Path)localObject).lineTo(11.345921F, 11.282878F);
      ((Path)localObject).cubicTo(10.963708F, 11.250445F, 10.599524F, 11.236032F, 10.264187F, 11.236032F);
      ((Path)localObject).cubicTo(7.379563F, 11.236032F, 6.7161F, 12.389178F, 6.131964F, 13.398181F);
      ((Path)localObject).lineTo(6.103118F, 13.452235F);
      ((Path)localObject).lineTo(9.889724F, 21.267807F);
      ((Path)localObject).cubicTo(9.94452F, 21.393011F, 9.94452F, 21.535395F, 9.889724F, 21.660599F);
      ((Path)localObject).cubicTo(9.833282F, 21.802046F, 9.72116F, 21.914099F, 9.579626F, 21.970507F);
      ((Path)localObject).cubicTo(9.512542F, 21.994579F, 9.44177F, 22.006773F, 9.370491F, 22.006588F);
      ((Path)localObject).cubicTo(9.150907F, 22.009279F, 8.948571F, 21.887951F, 8.847653F, 21.693031F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_filled_activity
 * JD-Core Version:    0.7.0.1
 */