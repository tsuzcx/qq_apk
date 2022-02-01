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

public class icons_filled_tickle
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      float[] arrayOfFloat = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.648135F, 0.0F, 1.0F, 0.796048F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(0.2F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -0.258819F, 0.9659258F, 3.181476F, 0.9659258F, 0.258819F, -2.441233F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(7.267887F, 1.918454F);
      ((Path)localObject1).cubicTo(7.658009F, 1.610858F, 7.983115F, 1.550988F, 8.26461F, 1.620556F);
      ((Path)localObject1).cubicTo(8.631314F, 1.711183F, 8.930167F, 2.037372F, 9.207238F, 2.378762F);
      ((Path)localObject1).cubicTo(9.483531F, 2.719192F, 10.213058F, 3.636268F, 10.986025F, 4.609131F);
      ((Path)localObject1).lineTo(10.986025F, 4.609131F);
      ((Path)localObject1).lineTo(11.37409F, 5.097623F);
      ((Path)localObject1).cubicTo(12.114731F, 6.030028F, 12.716657F, 6.787804F, 13.06365F, 7.221742F);
      ((Path)localObject1).cubicTo(13.479692F, 6.806905F, 13.496778F, 5.944505F, 13.518507F, 5.362219F);
      ((Path)localObject1).cubicTo(13.523652F, 5.225452F, 13.597683F, 4.929757F, 13.816747F, 4.713214F);
      ((Path)localObject1).cubicTo(13.948171F, 4.583304F, 14.130461F, 4.480995F, 14.37908F, 4.467217F);
      ((Path)localObject1).cubicTo(14.642406F, 4.452623F, 14.840497F, 4.52178F, 14.989788F, 4.62368F);
      ((Path)localObject1).cubicTo(15.211697F, 4.775145F, 15.325442F, 5.002425F, 15.381221F, 5.152258F);
      ((Path)localObject1).cubicTo(15.860614F, 6.681273F, 16.035353F, 7.360799F, 16.356272F, 8.614959F);
      ((Path)localObject1).cubicTo(16.808304F, 10.461771F, 16.821827F, 11.790473F, 16.567856F, 12.807107F);
      ((Path)localObject1).cubicTo(16.239771F, 14.120408F, 15.466261F, 14.918465F, 14.594111F, 15.635124F);
      ((Path)localObject1).cubicTo(13.698805F, 16.370811F, 12.309019F, 17.006075F, 10.654477F, 16.729761F);
      ((Path)localObject1).cubicTo(9.443818F, 16.527578F, 8.088407F, 15.836718F, 6.681593F, 14.326919F);
      ((Path)localObject1).cubicTo(6.080267F, 13.670538F, 5.58038F, 13.125887F, 5.160717F, 12.668645F);
      ((Path)localObject1).cubicTo(3.861619F, 11.253216F, 3.330357F, 10.674306F, 2.939263F, 10.212481F);
      ((Path)localObject1).cubicTo(2.645708F, 9.867623F, 2.48444F, 9.591958F, 2.446189F, 9.355245F);
      ((Path)localObject1).cubicTo(2.401969F, 9.081596F, 2.508222F, 8.849785F, 2.784681F, 8.620109F);
      ((Path)localObject1).lineTo(2.784681F, 8.620109F);
      ((Path)localObject1).lineTo(5.585034F, 10.728801F);
      ((Path)localObject1).lineTo(3.032838F, 7.066932F);
      ((Path)localObject1).cubicTo(2.855664F, 6.846936F, 2.779014F, 6.5552F, 2.803341F, 6.269509F);
      ((Path)localObject1).cubicTo(2.827301F, 5.988134F, 2.949016F, 5.713903F, 3.163891F, 5.521109F);
      ((Path)localObject1).cubicTo(3.350439F, 5.353731F, 3.58284F, 5.291946F, 3.81084F, 5.301842F);
      ((Path)localObject1).cubicTo(4.079513F, 5.313503F, 4.340359F, 5.425868F, 4.512097F, 5.579068F);
      ((Path)localObject1).lineTo(4.512097F, 5.579068F);
      ((Path)localObject1).lineTo(7.139786F, 8.33946F);
      ((Path)localObject1).lineTo(4.38087F, 4.470975F);
      ((Path)localObject1).cubicTo(4.22682F, 4.286445F, 4.097825F, 3.997969F, 4.121239F, 3.691406F);
      ((Path)localObject1).cubicTo(4.139039F, 3.458359F, 4.242985F, 3.213367F, 4.494135F, 2.995474F);
      ((Path)localObject1).cubicTo(4.764283F, 2.761099F, 5.029779F, 2.681103F, 5.273104F, 2.702564F);
      ((Path)localObject1).cubicTo(5.552708F, 2.727226F, 5.807451F, 2.888562F, 6.008364F, 3.125571F);
      ((Path)localObject1).lineTo(6.008364F, 3.125571F);
      ((Path)localObject1).lineTo(9.336555F, 6.849395F);
      ((Path)localObject1).lineTo(7.196945F, 3.279377F);
      ((Path)localObject1).cubicTo(7.034696F, 3.05566F, 6.949817F, 2.807917F, 6.960029F, 2.567167F);
      ((Path)localObject1).cubicTo(6.969656F, 2.340226F, 7.062666F, 2.117879F, 7.267887F, 1.918454F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.625F, 7.090982F);
      ((Path)localObject2).cubicTo(4.24632F, 7.090982F, 4.75F, 6.587302F, 4.75F, 5.965982F);
      ((Path)localObject2).cubicTo(4.75F, 5.344661F, 4.24632F, 4.840982F, 3.625F, 4.840982F);
      ((Path)localObject2).cubicTo(3.00368F, 4.840982F, 2.5F, 5.344661F, 2.5F, 5.965982F);
      ((Path)localObject2).cubicTo(2.5F, 6.587302F, 3.00368F, 7.090982F, 3.625F, 7.090982F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.466354F, 4.627742F);
      ((Path)localObject2).cubicTo(6.087675F, 4.627742F, 6.591354F, 4.124063F, 6.591354F, 3.502742F);
      ((Path)localObject2).cubicTo(6.591354F, 2.881422F, 6.087675F, 2.377742F, 5.466354F, 2.377742F);
      ((Path)localObject2).cubicTo(4.845034F, 2.377742F, 4.341354F, 2.881422F, 4.341354F, 3.502742F);
      ((Path)localObject2).cubicTo(4.341354F, 4.124063F, 4.845034F, 4.627742F, 5.466354F, 4.627742F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.329526F, 4.011798F);
      ((Path)localObject2).cubicTo(8.950847F, 4.011798F, 9.454526F, 3.508119F, 9.454526F, 2.886798F);
      ((Path)localObject2).cubicTo(9.454526F, 2.265478F, 8.950847F, 1.761799F, 8.329526F, 1.761799F);
      ((Path)localObject2).cubicTo(7.708206F, 1.761799F, 7.204526F, 2.265478F, 7.204526F, 2.886798F);
      ((Path)localObject2).cubicTo(7.204526F, 3.508119F, 7.708206F, 4.011798F, 8.329526F, 4.011798F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.354693F, 3.447371F);
      ((Path)localObject2).lineTo(8.480321F, 5.25733F);
      ((Path)localObject2).lineTo(8.559311F, 3.195728F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.290126F, 3.828408F);
      ((Path)localObject2).cubicTo(11.750362F, 3.828408F, 12.123459F, 3.455312F, 12.123459F, 2.995075F);
      ((Path)localObject2).cubicTo(12.123459F, 2.534838F, 11.750362F, 2.161742F, 11.290126F, 2.161742F);
      ((Path)localObject2).cubicTo(10.829888F, 2.161742F, 10.456792F, 2.534838F, 10.456792F, 2.995075F);
      ((Path)localObject2).cubicTo(10.456792F, 3.455312F, 10.829888F, 3.828408F, 11.290126F, 3.828408F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(4.506208F, 4.089206F);
      ((Path)localObject1).lineTo(6.093478F, 6.496942F);
      ((Path)localObject1).lineTo(5.663663F, 2.777383F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_tickle
 * JD-Core Version:    0.7.0.1
 */