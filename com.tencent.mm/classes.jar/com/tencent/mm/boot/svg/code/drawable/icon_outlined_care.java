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

public class icon_outlined_care
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-2565928);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint(localPaint2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.4F, 0.0F, 1.0F, 6.9F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(44.802773F, 0.0F);
      ((Path)localObject2).cubicTo(47.131119F, 0.172962F, 49.341248F, 1.129053F, 51.11628F, 2.686675F);
      ((Path)localObject2).lineTo(51.635418F, 3.173096F);
      ((Path)localObject2).lineTo(57.999378F, 9.537057F);
      ((Path)localObject2).cubicTo(62.080986F, 13.618666F, 62.21265F, 20.154455F, 58.394371F, 24.394398F);
      ((Path)localObject2).lineTo(57.999378F, 24.810564F);
      ((Path)localObject2).lineTo(25.960642F, 56.8493F);
      ((Path)localObject2).cubicTo(25.262299F, 57.547642F, 24.13006F, 57.547642F, 23.431717F, 56.8493F);
      ((Path)localObject2).cubicTo(22.733271F, 56.150852F, 22.732986F, 55.018536F, 23.431084F, 54.31974F);
      ((Path)localObject2).lineTo(55.453793F, 22.264978F);
      ((Path)localObject2).cubicTo(58.148411F, 19.570362F, 58.260689F, 15.271282F, 55.790619F, 12.442959F);
      ((Path)localObject2).lineTo(55.453793F, 12.082641F);
      ((Path)localObject2).lineTo(49.089832F, 5.71868F);
      ((Path)localObject2).cubicTo(47.989796F, 4.618643F, 46.59758F, 3.92404F, 45.101578F, 3.694107F);
      ((Path)localObject2).cubicTo(44.803566F, 3.632227F, 44.503429F, 3.600776F, 44.201172F, 3.599752F);
      ((Path)localObject2).lineTo(17.249218F, 3.599752F);
      ((Path)localObject2).cubicTo(15.513844F, 3.579361F, 13.835773F, 4.176886F, 12.503632F, 5.310476F);
      ((Path)localObject2).lineTo(12.072792F, 5.708082F);
      ((Path)localObject2).lineTo(5.708831F, 12.072042F);
      ((Path)localObject2).cubicTo(3.014214F, 14.766661F, 2.901938F, 19.065739F, 5.372004F, 21.894062F);
      ((Path)localObject2).lineTo(5.708831F, 22.254381F);
      ((Path)localObject2).lineTo(14.791006F, 31.330961F);
      ((Path)localObject2).lineTo(28.173F, 17.790001F);
      ((Path)localObject2).lineTo(20.522829F, 10.161573F);
      ((Path)localObject2).cubicTo(19.801056F, 9.477979F, 19.770105F, 8.338702F, 20.453701F, 7.616928F);
      ((Path)localObject2).cubicTo(21.068937F, 6.967332F, 22.053274F, 6.877303F, 22.770163F, 7.364134F);
      ((Path)localObject2).lineTo(22.998346F, 7.5478F);
      ((Path)localObject2).lineTo(30.716999F, 15.243F);
      ((Path)localObject2).lineTo(34.776432F, 11.18119F);
      ((Path)localObject2).cubicTo(35.473995F, 10.482847F, 36.605602F, 10.482214F, 37.303944F, 11.179776F);
      ((Path)localObject2).cubicTo(38.003109F, 11.878942F, 38.003426F, 13.011268F, 37.305359F, 13.710116F);
      ((Path)localObject2).lineTo(10.078652F, 40.967312F);
      ((Path)localObject2).cubicTo(9.458597F, 41.588058F, 8.495595F, 41.657532F, 7.79878F, 41.175388F);
      ((Path)localObject2).lineTo(7.550435F, 40.968018F);
      ((Path)localObject2).cubicTo(6.851977F, 40.269558F, 6.85166F, 39.137234F, 7.549727F, 38.438385F);
      ((Path)localObject2).lineTo(12.174F, 33.804001F);
      ((Path)localObject2).lineTo(3.163247F, 24.799965F);
      ((Path)localObject2).lineTo(3.163247F, 24.799965F);
      ((Path)localObject2).cubicTo(-0.918362F, 20.718357F, -1.050027F, 14.182567F, 2.768252F, 9.942624F);
      ((Path)localObject2).lineTo(3.163247F, 9.526459F);
      ((Path)localObject2).lineTo(9.527207F, 3.162498F);
      ((Path)localObject2).cubicTo(11.450338F, 1.239367F, 13.978135F, 0.1430462F, 16.627043F, 0.01244954F);
      ((Path)localObject2).lineTo(44.802773F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.956161F, 40.726151F);
      ((Path)localObject2).cubicTo(29.58881F, 41.358799F, 29.652075F, 42.345219F, 29.145956F, 43.048622F);
      ((Path)localObject2).lineTo(28.956161F, 43.271732F);
      ((Path)localObject2).lineTo(20.677948F, 51.549946F);
      ((Path)localObject2).cubicTo(19.975004F, 52.252892F, 18.835308F, 52.252892F, 18.132364F, 51.549946F);
      ((Path)localObject2).cubicTo(17.499714F, 50.917297F, 17.436449F, 49.930878F, 17.942568F, 49.227474F);
      ((Path)localObject2).lineTo(18.132364F, 49.00436F);
      ((Path)localObject2).lineTo(26.410576F, 40.726151F);
      ((Path)localObject2).cubicTo(27.11352F, 40.023205F, 28.253218F, 40.023205F, 28.956161F, 40.726151F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.661032F, 35.431019F);
      ((Path)localObject2).cubicTo(24.293682F, 36.063667F, 24.356947F, 37.050087F, 23.850826F, 37.75349F);
      ((Path)localObject2).lineTo(23.661032F, 37.976604F);
      ((Path)localObject2).lineTo(15.382819F, 46.254818F);
      ((Path)localObject2).cubicTo(14.679875F, 46.95776F, 13.540178F, 46.95776F, 12.837234F, 46.254818F);
      ((Path)localObject2).cubicTo(12.204585F, 45.622169F, 12.14132F, 44.63575F, 12.64744F, 43.932346F);
      ((Path)localObject2).lineTo(12.837234F, 43.709232F);
      ((Path)localObject2).lineTo(21.115448F, 35.431019F);
      ((Path)localObject2).cubicTo(21.818392F, 34.728077F, 22.958088F, 34.728077F, 23.661032F, 35.431019F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_outlined_care
 * JD-Core Version:    0.7.0.1
 */