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

public class remark_address_icon
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.475F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.821428F, -2.806644E-013F);
      ((Path)localObject2).cubicTo(10.872772F, -2.806644E-013F, 12.535714F, 1.66491F, 12.535714F, 3.714478F);
      ((Path)localObject2).lineTo(12.535714F, 5.302315F);
      ((Path)localObject2).cubicTo(12.535714F, 6.360061F, 11.979437F, 7.876942F, 11.298938F, 8.683603F);
      ((Path)localObject2).lineTo(10.963229F, 9.081552F);
      ((Path)localObject2).cubicTo(10.415815F, 9.730454F, 10.586817F, 10.556369F, 11.352296F, 10.92976F);
      ((Path)localObject2).lineTo(11.639345F, 11.069016F);
      ((Path)localObject2).lineTo(11.685672F, 10.90935F);
      ((Path)localObject2).cubicTo(12.168272F, 9.375524F, 13.615174F, 8.264286F, 15.321473F, 8.264286F);
      ((Path)localObject2).cubicTo(17.357584F, 8.264286F, 19.021702F, 9.845643F, 19.123524F, 11.855011F);
      ((Path)localObject2).lineTo(19.12846F, 12.050763F);
      ((Path)localObject2).lineTo(19.126072F, 12.165845F);
      ((Path)localObject2).cubicTo(19.083433F, 13.287305F, 18.522762F, 14.497547F, 17.505699F, 15.755382F);
      ((Path)localObject2).cubicTo(17.259657F, 16.059669F, 16.993097F, 16.358654F, 16.708067F, 16.650352F);
      ((Path)localObject2).lineTo(16.416954F, 16.939548F);
      ((Path)localObject2).lineTo(16.23398F, 17.112408F);
      ((Path)localObject2).lineTo(16.058262F, 17.271526F);
      ((Path)localObject2).lineTo(15.308785F, 17.922142F);
      ((Path)localObject2).lineTo(14.396643F, 17.100958F);
      ((Path)localObject2).lineTo(14.218511F, 16.932402F);
      ((Path)localObject2).lineTo(13.970293F, 16.686676F);
      ((Path)localObject2).cubicTo(13.979374F, 16.695902F, 13.988471F, 16.705114F, 13.997583F, 16.714319F);
      ((Path)localObject2).lineTo(0.928571F, 16.714285F);
      ((Path)localObject2).cubicTo(0.415736F, 16.714285F, -2.842171E-014F, 16.29855F, -2.842171E-014F, 15.785714F);
      ((Path)localObject2).lineTo(-2.842171E-014F, 15.150073F);
      ((Path)localObject2).cubicTo(-2.842171E-014F, 14.513919F, 0.462569F, 13.772486F, 1.034519F, 13.493381F);
      ((Path)localObject2).lineTo(6.290561F, 10.92849F);
      ((Path)localObject2).cubicTo(7.05285F, 10.556501F, 7.230098F, 9.732601F, 6.679628F, 9.080165F);
      ((Path)localObject2).lineTo(6.343919F, 8.682271F);
      ((Path)localObject2).cubicTo(5.660866F, 7.872694F, 5.107143F, 6.360247F, 5.107143F, 5.301484F);
      ((Path)localObject2).lineTo(5.107143F, 3.713896F);
      ((Path)localObject2).cubicTo(5.107143F, 1.662768F, 6.774259F, -2.806644E-013F, 8.821428F, -2.806644E-013F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.321473F, 9.378572F);
      ((Path)localObject2).cubicTo(13.890573F, 9.378572F, 12.721664F, 10.476894F, 12.633782F, 11.853606F);
      ((Path)localObject2).lineTo(12.628478F, 12.020096F);
      ((Path)localObject2).lineTo(12.630095F, 12.114333F);
      ((Path)localObject2).cubicTo(12.662513F, 12.96894F, 13.123709F, 13.966431F, 14.003718F, 15.054769F);
      ((Path)localObject2).cubicTo(14.227498F, 15.331523F, 14.471002F, 15.604672F, 14.727571F, 15.867538F);
      ((Path)localObject2).lineTo(14.98825F, 16.126732F);
      ((Path)localObject2).lineTo(15.152246F, 16.282116F);
      ((Path)localObject2).lineTo(15.321428F, 16.434786F);
      ((Path)localObject2).lineTo(15.47698F, 16.294821F);
      ((Path)localObject2).lineTo(15.647317F, 16.133781F);
      ((Path)localObject2).cubicTo(16.006985F, 15.786787F, 16.340488F, 15.424231F, 16.639229F, 15.054769F);
      ((Path)localObject2).cubicTo(17.455357F, 14.045436F, 17.912245F, 13.112954F, 17.998884F, 12.315228F);
      ((Path)localObject2).lineTo(18.0123F, 12.133555F);
      ((Path)localObject2).lineTo(18.014286F, 12.039613F);
      ((Path)localObject2).cubicTo(18.01436F, 10.567713F, 16.810833F, 9.378572F, 15.321473F, 9.378572F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.516302F, 12.145638F);
      ((Path)localObject2).lineTo(11.523F, 12.253F);
      ((Path)localObject2).lineTo(10.863781F, 11.931252F);
      ((Path)localObject2).cubicTo(9.44624F, 11.239794F, 9.095889F, 9.566991F, 10.111526F, 8.363056F);
      ((Path)localObject2).lineTo(10.447236F, 7.965108F);
      ((Path)localObject2).cubicTo(10.959181F, 7.35825F, 11.421429F, 6.095506F, 11.421429F, 5.302315F);
      ((Path)localObject2).lineTo(11.421429F, 3.714478F);
      ((Path)localObject2).cubicTo(11.421429F, 2.279563F, 10.256619F, 1.114286F, 8.821428F, 1.114286F);
      ((Path)localObject2).cubicTo(7.388001F, 1.114286F, 6.221428F, 2.279831F, 6.221428F, 3.713896F);
      ((Path)localObject2).lineTo(6.221428F, 5.301484F);
      ((Path)localObject2).cubicTo(6.221428F, 6.096688F, 6.681765F, 7.354735F, 7.195573F, 7.963718F);
      ((Path)localObject2).lineTo(7.531282F, 8.361611F);
      ((Path)localObject2).cubicTo(8.54902F, 9.56787F, 8.194841F, 11.239104F, 6.77924F, 11.929902F);
      ((Path)localObject2).lineTo(1.523197F, 14.494793F);
      ((Path)localObject2).cubicTo(1.334373F, 14.586937F, 1.114286F, 14.939486F, 1.114286F, 15.150073F);
      ((Path)localObject2).lineTo(1.114286F, 15.6F);
      ((Path)localObject2).lineTo(13.013824F, 15.600101F);
      ((Path)localObject2).lineTo(13.074951F, 15.677679F);
      ((Path)localObject2).lineTo(13.074951F, 15.677679F);
      ((Path)localObject2).lineTo(13.137247F, 15.755382F);
      ((Path)localObject2).lineTo(13.137247F, 15.755382F);
      ((Path)localObject2).cubicTo(12.186885F, 14.580038F, 11.636093F, 13.447442F, 11.531799F, 12.37461F);
      ((Path)localObject2).lineTo(11.516302F, 12.145638F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.321428F, 10.678572F);
      ((Path)localObject2).cubicTo(15.962474F, 10.678572F, 16.482143F, 11.198241F, 16.482143F, 11.839286F);
      ((Path)localObject2).cubicTo(16.482143F, 12.48033F, 15.962474F, 13.0F, 15.321428F, 13.0F);
      ((Path)localObject2).cubicTo(14.680384F, 13.0F, 14.160714F, 12.48033F, 14.160714F, 11.839286F);
      ((Path)localObject2).cubicTo(14.160714F, 11.198241F, 14.680384F, 10.678572F, 15.321428F, 10.678572F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.remark_address_icon
 * JD-Core Version:    0.7.0.1
 */