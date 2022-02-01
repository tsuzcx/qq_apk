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

public class connect_kidwatch
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.307692F, 0.0F, 1.0F, 0.384615F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(11.523337F, 4.15F);
      localPath.lineTo(4.076662F, 4.15F);
      localPath.cubicTo(3.063541F, 4.15F, 2.59554F, 4.240375F, 2.109886F, 4.500106F);
      localPath.cubicTo(1.675207F, 4.732575F, 1.332574F, 5.075207F, 1.100106F, 5.509885F);
      localPath.cubicTo(0.8603545F, 5.958181F, 0.764906F, 6.391437F, 0.7516403F, 7.252286F);
      localPath.lineTo(0.75F, 15.723338F);
      localPath.cubicTo(0.75F, 16.73646F, 0.8403752F, 17.20446F, 1.100106F, 17.690115F);
      localPath.cubicTo(1.332574F, 18.124792F, 1.675207F, 18.467426F, 2.109886F, 18.699894F);
      localPath.cubicTo(2.558182F, 18.939646F, 2.991437F, 19.035093F, 3.852286F, 19.048359F);
      localPath.lineTo(11.523337F, 19.049999F);
      localPath.cubicTo(12.536459F, 19.049999F, 13.00446F, 18.959625F, 13.490114F, 18.699894F);
      localPath.cubicTo(13.924793F, 18.467426F, 14.267426F, 18.124792F, 14.499894F, 17.690115F);
      localPath.cubicTo(14.759624F, 17.20446F, 14.85F, 16.73646F, 14.85F, 15.723338F);
      localPath.lineTo(14.85F, 7.476662F);
      localPath.cubicTo(14.85F, 6.463541F, 14.759624F, 5.99554F, 14.499894F, 5.509885F);
      localPath.cubicTo(14.267426F, 5.075207F, 13.924793F, 4.732575F, 13.490114F, 4.500106F);
      localPath.cubicTo(13.00446F, 4.240375F, 12.536459F, 4.15F, 11.523337F, 4.15F);
      localPath.close();
      localPath.moveTo(3.86975F, 4.651367F);
      localPath.lineTo(11.523337F, 4.65F);
      localPath.lineTo(11.919252F, 4.655585F);
      localPath.cubicTo(12.581298F, 4.676497F, 12.913048F, 4.758501F, 13.254315F, 4.941012F);
      localPath.cubicTo(13.601859F, 5.126881F, 13.873119F, 5.398141F, 14.058988F, 5.745685F);
      localPath.cubicTo(14.274683F, 6.149001F, 14.35F, 6.539023F, 14.35F, 7.476662F);
      localPath.lineTo(14.35F, 15.723338F);
      localPath.lineTo(14.344415F, 16.119253F);
      localPath.cubicTo(14.323503F, 16.781298F, 14.241499F, 17.113049F, 14.058988F, 17.454315F);
      localPath.cubicTo(13.873119F, 17.801859F, 13.601859F, 18.073118F, 13.254315F, 18.258987F);
      localPath.cubicTo(12.850999F, 18.474684F, 12.460977F, 18.549999F, 11.523337F, 18.549999F);
      localPath.lineTo(4.076662F, 18.549999F);
      localPath.cubicTo(3.139024F, 18.549999F, 2.749001F, 18.474684F, 2.345685F, 18.258987F);
      localPath.cubicTo(1.998141F, 18.073118F, 1.726881F, 17.801859F, 1.541013F, 17.454315F);
      localPath.cubicTo(1.325317F, 17.050999F, 1.25F, 16.660976F, 1.25F, 15.723338F);
      localPath.lineTo(1.25F, 7.476662F);
      localPath.cubicTo(1.25F, 6.539023F, 1.325317F, 6.149001F, 1.541013F, 5.745685F);
      localPath.cubicTo(1.726881F, 5.398141F, 1.998141F, 5.126881F, 2.345685F, 4.941012F);
      localPath.cubicTo(2.717976F, 4.741909F, 3.078941F, 4.662418F, 3.86975F, 4.651367F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(14.815385F, 7.673077F);
      localPath.cubicTo(14.566856F, 7.673077F, 14.365385F, 7.874549F, 14.365385F, 8.123077F);
      localPath.lineTo(14.365385F, 10.123076F);
      localPath.cubicTo(14.365385F, 10.371605F, 14.566856F, 10.573077F, 14.815385F, 10.573077F);
      localPath.cubicTo(15.063912F, 10.573077F, 15.265385F, 10.371605F, 15.265385F, 10.123076F);
      localPath.lineTo(15.265385F, 8.123077F);
      localPath.cubicTo(15.265385F, 7.874549F, 15.063912F, 7.673077F, 14.815385F, 7.673077F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.267123F, 0.75F);
      localPath.cubicTo(10.640266F, 0.75F, 10.822594F, 0.7802979F, 11.017315F, 0.8699034F);
      localPath.cubicTo(11.197705F, 0.952914F, 11.346914F, 1.078097F, 11.460011F, 1.241316F);
      localPath.cubicTo(11.564652F, 1.392333F, 11.624802F, 1.541955F, 11.681228F, 1.816288F);
      localPath.lineTo(11.709319F, 1.964431F);
      localPath.lineTo(12.090221F, 4.423267F);
      localPath.lineTo(11.596114F, 4.49981F);
      localPath.lineTo(11.21607F, 2.046149F);
      localPath.lineTo(11.172755F, 1.82977F);
      localPath.cubicTo(11.13768F, 1.681387F, 11.102668F, 1.603497F, 11.049031F, 1.526089F);
      localPath.cubicTo(10.986885F, 1.436401F, 10.907421F, 1.369733F, 10.808298F, 1.324119F);
      localPath.cubicTo(10.705636F, 1.276877F, 10.606953F, 1.256167F, 10.387494F, 1.251213F);
      localPath.lineTo(5.611207F, 1.25F);
      localPath.cubicTo(5.304162F, 1.25F, 5.189804F, 1.269003F, 5.070032F, 1.324119F);
      localPath.cubicTo(4.970908F, 1.369733F, 4.891445F, 1.436401F, 4.829299F, 1.526089F);
      localPath.cubicTo(4.764935F, 1.618979F, 4.727389F, 1.712562F, 4.684373F, 1.92782F);
      localPath.lineTo(4.316532F, 4.014841F);
      localPath.lineTo(4.25F, 4.461538F);
      localPath.lineTo(3.75F, 4.461538F);
      localPath.lineTo(3.787691F, 4.162201F);
      localPath.lineTo(3.845712F, 3.796136F);
      localPath.lineTo(4.169868F, 1.959256F);
      localPath.cubicTo(4.234715F, 1.591791F, 4.296237F, 1.417503F, 4.418319F, 1.241316F);
      localPath.cubicTo(4.531416F, 1.078097F, 4.680624F, 0.952914F, 4.861014F, 0.8699034F);
      localPath.cubicTo(5.027918F, 0.7930987F, 5.185717F, 0.7598669F, 5.462378F, 0.7519395F);
      localPath.lineTo(5.611207F, 0.75F);
      localPath.lineTo(10.267123F, 0.75F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 40.788273F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(10.267123F, 18.51923F);
      ((Path)localObject1).cubicTo(10.640266F, 18.51923F, 10.822594F, 18.549528F, 11.017315F, 18.639133F);
      ((Path)localObject1).cubicTo(11.197705F, 18.722145F, 11.346914F, 18.847328F, 11.460011F, 19.010548F);
      ((Path)localObject1).cubicTo(11.564652F, 19.161564F, 11.624802F, 19.311186F, 11.681228F, 19.58552F);
      ((Path)localObject1).lineTo(11.709319F, 19.733662F);
      ((Path)localObject1).lineTo(12.090221F, 22.192497F);
      ((Path)localObject1).lineTo(11.596114F, 22.269041F);
      ((Path)localObject1).lineTo(11.21607F, 19.81538F);
      ((Path)localObject1).lineTo(11.172755F, 19.599001F);
      ((Path)localObject1).cubicTo(11.13768F, 19.450617F, 11.102668F, 19.372728F, 11.049031F, 19.295321F);
      ((Path)localObject1).cubicTo(10.986885F, 19.205631F, 10.907421F, 19.138964F, 10.808298F, 19.093349F);
      ((Path)localObject1).cubicTo(10.705636F, 19.046108F, 10.606953F, 19.025396F, 10.387494F, 19.020445F);
      ((Path)localObject1).lineTo(5.611207F, 19.01923F);
      ((Path)localObject1).cubicTo(5.304162F, 19.01923F, 5.189804F, 19.038235F, 5.070032F, 19.093349F);
      ((Path)localObject1).cubicTo(4.970908F, 19.138964F, 4.891445F, 19.205631F, 4.829299F, 19.295321F);
      ((Path)localObject1).cubicTo(4.764935F, 19.38821F, 4.727389F, 19.481792F, 4.684373F, 19.69705F);
      ((Path)localObject1).lineTo(4.316532F, 21.784071F);
      ((Path)localObject1).lineTo(4.25F, 22.23077F);
      ((Path)localObject1).lineTo(3.75F, 22.23077F);
      ((Path)localObject1).lineTo(3.787691F, 21.931431F);
      ((Path)localObject1).lineTo(3.845712F, 21.565367F);
      ((Path)localObject1).lineTo(4.169868F, 19.728487F);
      ((Path)localObject1).cubicTo(4.234715F, 19.361021F, 4.296237F, 19.186733F, 4.418319F, 19.010548F);
      ((Path)localObject1).cubicTo(4.531416F, 18.847328F, 4.680624F, 18.722145F, 4.861014F, 18.639133F);
      ((Path)localObject1).cubicTo(5.027918F, 18.56233F, 5.185717F, 18.529099F, 5.462378F, 18.52117F);
      ((Path)localObject1).lineTo(5.611207F, 18.51923F);
      ((Path)localObject1).lineTo(10.267123F, 18.51923F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.616669F, 5.95F);
      ((Path)localObject2).lineTo(3.983332F, 5.95F);
      ((Path)localObject2).cubicTo(3.570444F, 5.95F, 3.36645F, 5.989393F, 3.154325F, 6.102839F);
      ((Path)localObject2).cubicTo(2.960331F, 6.206588F, 2.806588F, 6.360331F, 2.702839F, 6.554326F);
      ((Path)localObject2).cubicTo(2.589393F, 6.76645F, 2.55F, 6.970444F, 2.55F, 7.383332F);
      ((Path)localObject2).lineTo(2.55F, 15.816669F);
      ((Path)localObject2).cubicTo(2.55F, 16.229555F, 2.589393F, 16.43355F, 2.702839F, 16.645674F);
      ((Path)localObject2).cubicTo(2.806588F, 16.839668F, 2.960331F, 16.993412F, 3.154325F, 17.097162F);
      ((Path)localObject2).cubicTo(3.36645F, 17.210608F, 3.570444F, 17.25F, 3.983332F, 17.25F);
      ((Path)localObject2).lineTo(11.616669F, 17.25F);
      ((Path)localObject2).cubicTo(12.029555F, 17.25F, 12.23355F, 17.210608F, 12.445675F, 17.097162F);
      ((Path)localObject2).cubicTo(12.639669F, 16.993412F, 12.793412F, 16.839668F, 12.897161F, 16.645674F);
      ((Path)localObject2).cubicTo(13.010607F, 16.43355F, 13.05F, 16.229555F, 13.05F, 15.816669F);
      ((Path)localObject2).lineTo(13.05F, 7.383332F);
      ((Path)localObject2).cubicTo(13.05F, 6.970444F, 13.010607F, 6.76645F, 12.897161F, 6.554326F);
      ((Path)localObject2).cubicTo(12.793412F, 6.360331F, 12.639669F, 6.206588F, 12.445675F, 6.102839F);
      ((Path)localObject2).cubicTo(12.23355F, 5.989393F, 12.029555F, 5.95F, 11.616669F, 5.95F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.851044F, 6.451551F);
      ((Path)localObject2).lineTo(11.616669F, 6.45F);
      ((Path)localObject2).cubicTo(11.954073F, 6.45F, 12.080089F, 6.474335F, 12.209875F, 6.543746F);
      ((Path)localObject2).cubicTo(12.316735F, 6.600895F, 12.399105F, 6.683265F, 12.456255F, 6.790125F);
      ((Path)localObject2).cubicTo(12.525665F, 6.919911F, 12.55F, 7.045927F, 12.55F, 7.383332F);
      ((Path)localObject2).lineTo(12.55F, 15.816669F);
      ((Path)localObject2).cubicTo(12.55F, 16.154074F, 12.525665F, 16.280088F, 12.456255F, 16.409876F);
      ((Path)localObject2).cubicTo(12.399105F, 16.516735F, 12.316735F, 16.599106F, 12.209875F, 16.656254F);
      ((Path)localObject2).cubicTo(12.080089F, 16.725666F, 11.954073F, 16.75F, 11.616669F, 16.75F);
      ((Path)localObject2).lineTo(3.983332F, 16.75F);
      ((Path)localObject2).cubicTo(3.645927F, 16.75F, 3.519911F, 16.725666F, 3.390125F, 16.656254F);
      ((Path)localObject2).cubicTo(3.283265F, 16.599106F, 3.200895F, 16.516735F, 3.143745F, 16.409876F);
      ((Path)localObject2).cubicTo(3.084251F, 16.29863F, 3.057873F, 16.190155F, 3.05155F, 15.948956F);
      ((Path)localObject2).lineTo(3.05F, 7.383332F);
      ((Path)localObject2).cubicTo(3.05F, 7.045927F, 3.074335F, 6.919911F, 3.143745F, 6.790125F);
      ((Path)localObject2).cubicTo(3.200895F, 6.683265F, 3.283265F, 6.600895F, 3.390125F, 6.543746F);
      ((Path)localObject2).cubicTo(3.50137F, 6.484251F, 3.609845F, 6.457873F, 3.851044F, 6.451551F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_kidwatch
 * JD-Core Version:    0.7.0.1
 */