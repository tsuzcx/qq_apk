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

public class bottomsheet_icon_qq
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      ((Path)localObject3).lineTo(96.0F, 0.0F);
      ((Path)localObject3).lineTo(96.0F, 96.0F);
      ((Path)localObject3).lineTo(0.0F, 96.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 11.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-414200);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(30.601503F, 73.165123F);
      localPath.cubicTo(24.273214F, 73.165123F, 18.464798F, 71.0457F, 14.724731F, 67.8797F);
      localPath.cubicTo(12.825571F, 68.447357F, 10.396095F, 69.36132F, 8.862702F, 70.494537F);
      localPath.cubicTo(7.551185F, 71.463783F, 7.714573F, 72.452065F, 7.951069F, 72.851097F);
      localPath.cubicTo(8.988957F, 74.604004F, 25.759726F, 73.970383F, 30.601503F, 73.424561F);
      localPath.lineTo(30.601503F, 73.165123F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-414200);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(31.157894F, 73.165123F);
      localPath.cubicTo(37.486187F, 73.165123F, 43.294605F, 71.0457F, 47.034443F, 67.8797F);
      localPath.cubicTo(48.933834F, 68.447357F, 51.363312F, 69.36132F, 52.896473F, 70.494537F);
      localPath.cubicTo(54.208225F, 71.463783F, 54.044838F, 72.452065F, 53.808342F, 72.851097F);
      localPath.cubicTo(52.770218F, 74.604004F, 35.999443F, 73.970383F, 31.157894F, 73.424561F);
      localPath.lineTo(31.157894F, 73.165123F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 7.789474F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(23.155979F, 34.493752F);
      ((Path)localObject2).cubicTo(33.711143F, 34.421944F, 42.170605F, 32.377045F, 45.036606F, 31.592314F);
      ((Path)localObject2).cubicTo(45.719936F, 31.405048F, 46.085396F, 31.069942F, 46.085396F, 31.069942F);
      ((Path)localObject2).cubicTo(46.087975F, 30.973728F, 46.128998F, 29.349823F, 46.128998F, 28.512058F);
      ((Path)localObject2).cubicTo(46.128998F, 14.405208F, 39.476433F, 0.230069F, 23.117067F, 0.2291301F);
      ((Path)localObject2).cubicTo(6.7577F, 0.230069F, 0.104902F, 14.405208F, 0.104902F, 28.512058F);
      ((Path)localObject2).cubicTo(0.104902F, 29.349823F, 0.14616F, 30.973728F, 0.1487386F, 31.069942F);
      ((Path)localObject2).cubicTo(0.1487386F, 31.069942F, 0.4462157F, 31.383694F, 0.9910044F, 31.535524F);
      ((Path)localObject2).cubicTo(3.637355F, 32.272617F, 12.255518F, 34.420303F, 23.078154F, 34.493752F);
      ((Path)localObject2).lineTo(23.155979F, 34.493752F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(59.626438F, 46.482483F);
      ((Path)localObject2).cubicTo(58.971607F, 44.366421F, 58.077461F, 41.898899F, 57.17252F, 39.529133F);
      ((Path)localObject2).cubicTo(57.17252F, 39.529133F, 56.651661F, 39.464588F, 56.388412F, 39.541382F);
      ((Path)localObject2).cubicTo(48.266018F, 41.910206F, 38.421024F, 43.41993F, 30.918505F, 43.328766F);
      ((Path)localObject2).lineTo(30.840843F, 43.328766F);
      ((Path)localObject2).cubicTo(23.380554F, 43.418987F, 13.602194F, 41.92646F, 5.506782F, 39.580959F);
      ((Path)localObject2).cubicTo(5.197784F, 39.491207F, 4.586827F, 39.529133F, 4.586827F, 39.529133F);
      ((Path)localObject2).cubicTo(3.681654F, 41.898899F, 2.787742F, 44.366421F, 2.132911F, 46.482483F);
      ((Path)localObject2).cubicTo(-0.9896795F, 56.572353F, 0.02177792F, 60.74794F, 0.7920434F, 60.841461F);
      ((Path)localObject2).cubicTo(2.445428F, 61.04216F, 7.226799F, 53.245968F, 7.226799F, 53.245968F);
      ((Path)localObject2).cubicTo(7.226799F, 61.16795F, 14.350406F, 73.331718F, 30.663235F, 73.443611F);
      ((Path)localObject2).cubicTo(30.735968F, 73.442902F, 31.02338F, 73.442902F, 31.096113F, 73.443611F);
      ((Path)localObject2).cubicTo(47.408707F, 73.331718F, 54.532551F, 61.16795F, 54.532551F, 53.245968F);
      ((Path)localObject2).cubicTo(54.532551F, 53.245968F, 59.313919F, 61.04216F, 60.967072F, 60.841461F);
      ((Path)localObject2).cubicTo(61.737572F, 60.74794F, 62.749264F, 56.572353F, 59.626438F, 46.482483F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.249262F, 21.13999F);
      ((Path)localObject2).cubicTo(23.100363F, 21.240128F, 21.263834F, 18.705181F, 21.148739F, 15.482667F);
      ((Path)localObject2).cubicTo(21.031601F, 12.257802F, 22.67812F, 9.562541F, 24.8277F, 9.461462F);
      ((Path)localObject2).cubicTo(26.974554F, 9.362265F, 28.809721F, 11.896272F, 28.926405F, 15.120431F);
      ((Path)localObject2).cubicTo(29.043997F, 18.345295F, 27.397251F, 21.039852F, 25.249262F, 21.13999F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(40.61068F, 15.482667F);
      ((Path)localObject2).cubicTo(40.49559F, 18.705181F, 38.658875F, 21.240128F, 36.510029F, 21.13999F);
      ((Path)localObject2).cubicTo(34.362091F, 21.039852F, 32.715611F, 18.345295F, 32.832973F, 15.120195F);
      ((Path)localObject2).cubicTo(32.949654F, 11.896272F, 34.784779F, 9.362265F, 36.931808F, 9.461462F);
      ((Path)localObject2).cubicTo(39.081108F, 9.562306F, 40.727589F, 12.257802F, 40.61068F, 15.482667F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-414200);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(44.468323F, 25.679302F);
      ((Path)localObject2).cubicTo(43.880867F, 24.322979F, 37.964764F, 22.812031F, 30.640629F, 22.812031F);
      ((Path)localObject2).lineTo(30.562147F, 22.812031F);
      ((Path)localObject2).cubicTo(23.23801F, 22.812031F, 17.321907F, 24.322979F, 16.734453F, 25.679302F);
      ((Path)localObject2).cubicTo(16.70775F, 25.737862F, 16.691729F, 25.803198F, 16.691729F, 25.872164F);
      ((Path)localObject2).cubicTo(16.691729F, 25.969925F, 16.723076F, 26.058249F, 16.772301F, 26.133022F);
      ((Path)localObject2).cubicTo(17.267342F, 26.885109F, 23.836842F, 30.601503F, 30.562147F, 30.601503F);
      ((Path)localObject2).lineTo(30.640629F, 30.601503F);
      ((Path)localObject2).cubicTo(37.366165F, 30.601503F, 43.935432F, 26.885351F, 44.430473F, 26.133022F);
      ((Path)localObject2).cubicTo(44.479698F, 26.058491F, 44.51128F, 25.96944F, 44.51128F, 25.871679F);
      ((Path)localObject2).cubicTo(44.51128F, 25.802713F, 44.495026F, 25.737862F, 44.468323F, 25.679302F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(27.810122F, 15.364501F);
      ((Path)localObject2).cubicTo(27.907309F, 16.588139F, 27.242004F, 17.675112F, 26.326344F, 17.79393F);
      ((Path)localObject2).cubicTo(25.40934F, 17.912746F, 24.588181F, 17.017326F, 24.490322F, 15.793012F);
      ((Path)localObject2).cubicTo(24.394926F, 14.568923F, 25.058886F, 13.481948F, 25.973202F, 13.364035F);
      ((Path)localObject2).cubicTo(26.89155F, 13.244765F, 27.714054F, 14.140864F, 27.810122F, 15.364501F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(33.996277F, 15.975608F);
      ((Path)localObject2).cubicTo(34.191402F, 15.658472F, 35.523407F, 13.990917F, 38.280418F, 14.598108F);
      ((Path)localObject2).cubicTo(39.004608F, 14.757628F, 39.339478F, 14.992254F, 39.410049F, 15.084708F);
      ((Path)localObject2).cubicTo(39.514275F, 15.220956F, 39.543015F, 15.414961F, 39.437157F, 15.676455F);
      ((Path)localObject2).cubicTo(39.227543F, 16.194366F, 38.794991F, 16.180191F, 38.554996F, 16.078852F);
      ((Path)localObject2).cubicTo(38.400299F, 16.013477F, 36.479877F, 14.855371F, 34.711586F, 16.583433F);
      ((Path)localObject2).cubicTo(34.589603F, 16.702757F, 34.371807F, 16.743376F, 34.165699F, 16.602051F);
      ((Path)localObject2).cubicTo(33.959354F, 16.460938F, 33.874058F, 16.174479F, 33.996277F, 15.975608F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.638107F, 42.963177F);
      ((Path)localObject2).lineTo(30.561182F, 42.963177F);
      ((Path)localObject2).cubicTo(25.507059F, 43.024456F, 19.379223F, 42.350601F, 13.444983F, 41.173634F);
      ((Path)localObject2).cubicTo(12.936711F, 44.13406F, 12.629936F, 47.854885F, 12.893484F, 52.292603F);
      ((Path)localObject2).cubicTo(13.559093F, 63.509102F, 20.177769F, 70.558975F, 30.39385F, 70.661652F);
      ((Path)localObject2).lineTo(30.60162F, 70.661652F);
      ((Path)localObject2).lineTo(30.809158F, 70.661652F);
      ((Path)localObject2).cubicTo(41.025238F, 70.558975F, 47.643913F, 63.509102F, 48.309525F, 52.292603F);
      ((Path)localObject2).cubicTo(48.573071F, 47.854652F, 48.266296F, 44.133595F, 47.758026F, 41.172932F);
      ((Path)localObject2).cubicTo(41.82262F, 42.350601F, 35.693394F, 43.024689F, 30.638107F, 42.963177F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1434585);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.135338F, 41.729324F);
      ((Path)localObject2).lineTo(16.135338F, 52.846371F);
      ((Path)localObject2).cubicTo(16.135338F, 52.846371F, 21.138113F, 53.873997F, 26.150375F, 53.162762F);
      ((Path)localObject2).lineTo(26.150375F, 42.907959F);
      ((Path)localObject2).cubicTo(22.975018F, 42.725143F, 19.550665F, 42.317345F, 16.135338F, 41.729324F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1434585);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(53.46558F, 31.157894F);
      ((Path)localObject1).cubicTo(53.46558F, 31.157894F, 43.653122F, 34.268398F, 30.640474F, 34.357208F);
      ((Path)localObject1).lineTo(30.563002F, 34.357208F);
      ((Path)localObject1).cubicTo(17.571587F, 34.268867F, 7.771029F, 31.16844F, 7.73766F, 31.157894F);
      ((Path)localObject1).lineTo(4.451128F, 39.395317F);
      ((Path)localObject1).cubicTo(12.671424F, 41.883907F, 22.859579F, 43.4879F, 30.563002F, 43.394634F);
      ((Path)localObject1).lineTo(30.64024F, 43.394402F);
      ((Path)localObject1).cubicTo(38.343895F, 43.488132F, 48.530884F, 41.88414F, 56.751881F, 39.395317F);
      ((Path)localObject1).lineTo(53.46558F, 31.157894F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_qq
 * JD-Core Version:    0.7.0.1
 */