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

public class fts_websearch_icon
  extends c
{
  private final int height = 41;
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
      return 41;
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
      localPaint1.setColor(-372399);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.772556F, 3.575995F);
      ((Path)localObject2).cubicTo(19.052969F, 2.936532F, 19.074936F, 2.243481F, 18.83378F, 1.624942F);
      ((Path)localObject2).cubicTo(18.592627F, 1.005382F, 18.119196F, 0.541477F, 17.500887F, 0.3179456F);
      ((Path)localObject2).lineTo(16.979788F, 0.1301383F);
      ((Path)localObject2).cubicTo(16.740969F, 0.04337942F, 16.497009F, 0.0F, 16.254454F, 0.0F);
      ((Path)localObject2).cubicTo(15.232818F, 0.0F, 14.37569F, 0.7864434F, 14.170522F, 1.913288F);
      ((Path)localObject2).lineTo(13.081587F, 7.893013F);
      ((Path)localObject2).cubicTo(12.819402F, 9.330658F, 13.208707F, 10.672358F, 13.968625F, 10.946924F);
      ((Path)localObject2).cubicTo(14.066302F, 10.982138F, 14.170522F, 11.0F, 14.278948F, 11.0F);
      ((Path)localObject2).cubicTo(15.006151F, 11.0F, 15.860941F, 10.209984F, 16.357271F, 9.078036F);
      ((Path)localObject2).lineTo(18.772556F, 3.575995F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.995767F, 14.805049F);
      ((Path)localObject2).cubicTo(9.072482F, 13.81314F, 8.097905F, 12.72122F, 6.777158F, 12.321181F);
      ((Path)localObject2).lineTo(2.713576F, 11.086558F);
      ((Path)localObject2).cubicTo(2.526048F, 11.029243F, 2.336153F, 11.0F, 2.149571F, 11.0F);
      ((Path)localObject2).cubicTo(1.043819F, 11.0F, 0.1630053F, 12.014133F, 0.05408751F, 13.410761F);
      ((Path)localObject2).lineTo(0.0001021547F, 14.119018F);
      ((Path)localObject2).cubicTo(-0.005580514F, 14.971732F, 0.2259882F, 15.734964F, 0.653609F, 16.266596F);
      ((Path)localObject2).cubicTo(1.03861F, 16.746174F, 1.548156F, 17.0F, 2.127788F, 17.0F);
      ((Path)localObject2).cubicTo(2.169461F, 17.0F, 2.212081F, 16.998245F, 2.254701F, 16.995907F);
      ((Path)localObject2).lineTo(6.436198F, 16.728628F);
      ((Path)localObject2).cubicTo(7.793882F, 16.641485F, 8.918103F, 15.796959F, 8.995767F, 14.805049F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.986993F, 19.054195F);
      ((Path)localObject2).cubicTo(11.155705F, 18.762688F, 10.011075F, 19.676445F, 9.425617F, 21.090944F);
      ((Path)localObject2).lineTo(5.217128F, 31.25997F);
      ((Path)localObject2).cubicTo(4.931099F, 31.951962F, 4.927492F, 32.699532F, 5.207336F, 33.365372F);
      ((Path)localObject2).cubicTo(5.487696F, 34.032299F, 6.016463F, 34.531952F, 6.696748F, 34.771698F);
      ((Path)localObject2).lineTo(7.270351F, 34.973846F);
      ((Path)localObject2).lineTo(7.327557F, 34.986378F);
      ((Path)localObject2).cubicTo(7.420839F, 34.995094F, 7.519789F, 35.0F, 7.622863F, 35.0F);
      ((Path)localObject2).cubicTo(8.819546F, 35.0F, 10.157954F, 34.413712F, 10.452229F, 33.103832F);
      ((Path)localObject2).lineTo(12.876001F, 22.307108F);
      ((Path)localObject2).cubicTo(13.21872F, 20.779274F, 12.828073F, 19.350063F, 11.986993F, 19.054195F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(19.488386F, 20.241226F);
      ((Path)localObject2).cubicTo(18.801319F, 19.475615F, 17.931036F, 19.0F, 17.215666F, 19.0F);
      ((Path)localObject2).cubicTo(16.912018F, 19.0F, 16.645426F, 19.089312F, 16.44471F, 19.259329F);
      ((Path)localObject2).cubicTo(15.754558F, 19.842548F, 15.880648F, 21.296293F, 16.732918F, 22.569801F);
      ((Path)localObject2).lineTo(24.960207F, 34.870148F);
      ((Path)localObject2).cubicTo(25.44038F, 35.587872F, 26.186117F, 36.0F, 27.004419F, 36.0F);
      ((Path)localObject2).cubicTo(27.580835F, 36.0F, 28.128429F, 35.794476F, 28.58956F, 35.405483F);
      ((Path)localObject2).lineTo(29.058413F, 35.008419F);
      ((Path)localObject2).cubicTo(29.614241F, 34.539799F, 29.946194F, 33.882332F, 29.994057F, 33.158688F);
      ((Path)localObject2).cubicTo(30.04192F, 32.43504F, 29.799517F, 31.736685F, 29.310593F, 31.192202F);
      ((Path)localObject2).lineTo(19.488386F, 20.241226F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(33.181255F, 15.722694F);
      ((Path)localObject1).lineTo(33.181255F, 15.722694F);
      ((Path)localObject1).lineTo(33.181255F, 15.724368F);
      ((Path)localObject1).lineTo(33.181255F, 15.722694F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(35.962078F, 12.519454F);
      ((Path)localObject1).cubicTo(35.87719F, 10.947126F, 34.595921F, 9.797732F, 33.074745F, 10.029843F);
      ((Path)localObject1).lineTo(20.595829F, 11.953684F);
      ((Path)localObject1).cubicTo(19.089943F, 12.186353F, 17.95051F, 13.118144F, 18.001656F, 14.074485F);
      ((Path)localObject1).cubicTo(18.052275F, 15.033616F, 19.286615F, 15.804714F, 20.81201F, 15.829265F);
      ((Path)localObject1).lineTo(33.137489F, 15.999442F);
      ((Path)localObject1).lineTo(33.181255F, 16.0F);
      ((Path)localObject1).cubicTo(33.982704F, 16.0F, 34.78574F, 15.636211F, 35.329353F, 15.026362F);
      ((Path)localObject1).cubicTo(35.79599F, 14.504113F, 36.032734F, 13.845722F, 35.996353F, 13.172824F);
      ((Path)localObject1).lineTo(35.962078F, 12.519454F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fts_websearch_icon
 * JD-Core Version:    0.7.0.1
 */