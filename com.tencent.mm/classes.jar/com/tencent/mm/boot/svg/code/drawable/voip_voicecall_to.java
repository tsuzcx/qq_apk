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

public class voip_voicecall_to
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 72.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.642428F, 43.893478F);
      ((Path)localObject2).lineTo(20.489038F, 40.334248F);
      ((Path)localObject2).cubicTo(20.498533F, 40.297424F, 20.519745F, 40.240364F, 20.555573F, 40.156624F);
      ((Path)localObject2).cubicTo(20.592392F, 40.070564F, 21.546556F, 37.84544F, 21.804857F, 37.238869F);
      ((Path)localObject2).cubicTo(21.861208F, 37.106487F, 21.861208F, 37.106487F, 21.917463F, 36.974121F);
      ((Path)localObject2).cubicTo(22.179684F, 36.35685F, 22.417952F, 35.790356F, 22.656128F, 35.217007F);
      ((Path)localObject2).cubicTo(23.005909F, 34.374996F, 23.252663F, 33.922047F, 23.866634F, 33.308075F);
      ((Path)localObject2).cubicTo(24.54784F, 32.626869F, 25.380478F, 32.174458F, 26.242174F, 31.969364F);
      ((Path)localObject2).cubicTo(29.761038F, 31.057201F, 32.951683F, 30.612867F, 35.958176F, 30.636295F);
      ((Path)localObject2).cubicTo(39.025455F, 30.612823F, 42.247021F, 31.05929F, 45.690666F, 31.952644F);
      ((Path)localObject2).cubicTo(46.619522F, 32.174458F, 47.45216F, 32.626869F, 48.133366F, 33.308075F);
      ((Path)localObject2).cubicTo(48.747337F, 33.922047F, 48.994091F, 34.374996F, 49.343872F, 35.217007F);
      ((Path)localObject2).cubicTo(49.582047F, 35.790356F, 49.820316F, 36.35685F, 50.082539F, 36.974121F);
      ((Path)localObject2).cubicTo(50.13879F, 37.106487F, 50.13879F, 37.106487F, 50.195145F, 37.238869F);
      ((Path)localObject2).cubicTo(50.453445F, 37.84544F, 51.407608F, 40.070564F, 51.444427F, 40.156624F);
      ((Path)localObject2).cubicTo(51.479324F, 40.23819F, 51.500355F, 40.294441F, 51.509403F, 40.330959F);
      ((Path)localObject2).lineTo(59.223831F, 43.835999F);
      ((Path)localObject2).cubicTo(59.479588F, 43.939846F, 59.781784F, 43.893364F, 60.086578F, 43.649986F);
      ((Path)localObject2).cubicTo(60.095524F, 43.635265F, 60.109268F, 43.611115F, 60.129086F, 43.573357F);
      ((Path)localObject2).cubicTo(60.154179F, 43.525543F, 60.188065F, 43.454689F, 60.230755F, 43.359913F);
      ((Path)localObject2).cubicTo(61.520054F, 40.569801F, 60.914253F, 37.246555F, 58.653526F, 34.79361F);
      ((Path)localObject2).cubicTo(54.747036F, 30.554979F, 44.741158F, 27.606579F, 35.988426F, 27.599998F);
      ((Path)localObject2).cubicTo(27.237808F, 27.606573F, 17.255089F, 30.552673F, 13.346475F, 34.79361F);
      ((Path)localObject2).cubicTo(11.085747F, 37.246555F, 10.479947F, 40.569801F, 11.787497F, 43.400051F);
      ((Path)localObject2).cubicTo(11.811936F, 43.454689F, 11.84582F, 43.525543F, 11.870915F, 43.573357F);
      ((Path)localObject2).cubicTo(11.892082F, 43.613686F, 11.906316F, 43.638485F, 11.915182F, 43.652859F);
      ((Path)localObject2).cubicTo(12.190037F, 43.888729F, 12.507125F, 43.945274F, 12.642428F, 43.893478F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(61.300713F, 32.353859F);
      ((Path)localObject2).cubicTo(64.473015F, 35.795876F, 65.443535F, 40.661335F, 63.498714F, 44.870022F);
      ((Path)localObject2).cubicTo(63.460358F, 44.955769F, 63.391949F, 45.103035F, 63.316723F, 45.246365F);
      ((Path)localObject2).cubicTo(63.168354F, 45.529057F, 63.001297F, 45.788391F, 62.792793F, 46.028656F);
      ((Path)localObject2).cubicTo(62.691471F, 46.145412F, 62.582687F, 46.254303F, 62.464314F, 46.354443F);
      ((Path)localObject2).cubicTo(61.186558F, 47.472553F, 59.428444F, 47.804516F, 57.869495F, 47.171532F);
      ((Path)localObject2).lineTo(49.609386F, 43.421844F);
      ((Path)localObject2).cubicTo(48.760178F, 42.996761F, 48.53418F, 42.506554F, 48.134636F, 41.572697F);
      ((Path)localObject2).cubicTo(47.354313F, 39.748856F, 46.731472F, 38.312405F, 46.019318F, 36.598068F);
      ((Path)localObject2).cubicTo(45.885525F, 36.276001F, 45.793549F, 36.059425F, 45.58778F, 35.853657F);
      ((Path)localObject2).cubicTo(45.387127F, 35.653004F, 45.148544F, 35.524406F, 44.854485F, 35.454185F);
      ((Path)localObject2).cubicTo(41.678555F, 34.630917F, 38.757351F, 34.214981F, 35.985722F, 34.236191F);
      ((Path)localObject2).cubicTo(33.214092F, 34.214981F, 30.321447F, 34.630917F, 27.145515F, 35.454185F);
      ((Path)localObject2).cubicTo(26.851458F, 35.524406F, 26.612873F, 35.653004F, 26.412218F, 35.853657F);
      ((Path)localObject2).cubicTo(26.206453F, 36.059425F, 26.114475F, 36.276001F, 25.980682F, 36.598068F);
      ((Path)localObject2).cubicTo(25.268526F, 38.312405F, 24.645685F, 39.748856F, 23.865366F, 41.572697F);
      ((Path)localObject2).cubicTo(23.46582F, 42.506554F, 23.239822F, 42.996761F, 22.390614F, 43.421844F);
      ((Path)localObject2).lineTo(14.130505F, 47.171532F);
      ((Path)localObject2).cubicTo(12.571555F, 47.804516F, 10.813441F, 47.472553F, 9.535687F, 46.354443F);
      ((Path)localObject2).cubicTo(9.417313F, 46.254303F, 9.308528F, 46.145412F, 9.207205F, 46.028656F);
      ((Path)localObject2).cubicTo(8.998705F, 45.788391F, 8.831646F, 45.529057F, 8.683277F, 45.246365F);
      ((Path)localObject2).cubicTo(8.608051F, 45.103035F, 8.539641F, 44.955769F, 8.501286F, 44.870022F);
      ((Path)localObject2).cubicTo(6.556469F, 40.661335F, 7.526989F, 35.795876F, 10.699286F, 32.353859F);
      ((Path)localObject2).cubicTo(15.990823F, 26.612415F, 27.842369F, 24.006119F, 35.985722F, 24.0F);
      ((Path)localObject2).cubicTo(44.129074F, 24.006119F, 56.009178F, 26.612415F, 61.300713F, 32.353859F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voip_voicecall_to
 * JD-Core Version:    0.7.0.1
 */