package com.tencent.mm.boot.svg.a.a;

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

public final class axt
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 4.5F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(46.228859F, 39.752171F);
      localPath.lineTo(57.012539F, 43.802109F);
      localPath.cubicTo(58.980694F, 44.633541F, 60.261246F, 46.510239F, 60.404591F, 48.661503F);
      localPath.cubicTo(60.420963F, 48.857704F, 60.420868F, 49.053158F, 60.407009F, 49.248974F);
      localPath.cubicTo(60.37849F, 49.651924F, 60.295635F, 50.034782F, 60.175026F, 50.421837F);
      localPath.cubicTo(60.113873F, 50.61808F, 60.043068F, 50.811737F, 60.000515F, 50.923168F);
      localPath.cubicTo(57.96777F, 56.448444F, 52.743507F, 60.187923F, 46.788559F, 60.187923F);
      localPath.cubicTo(45.420162F, 60.187923F, 43.992168F, 59.950283F, 43.170025F, 59.712608F);
      localPath.cubicTo(33.073021F, 57.408188F, 23.884508F, 52.274864F, 16.567039F, 44.968384F);
      localPath.cubicTo(9.249243F, 37.661575F, 4.107736F, 28.486031F, 1.767779F, 18.231745F);
      localPath.cubicTo(1.770988F, 18.254175F, 1.636847F, 17.626104F, 1.572165F, 17.275263F);
      localPath.cubicTo(1.414704F, 16.421171F, 1.323305F, 15.608054F, 1.323305F, 14.787783F);
      localPath.cubicTo(1.323305F, 8.838872F, 5.069203F, 3.621347F, 10.661819F, 1.571025F);
      localPath.cubicTo(10.815471F, 1.517915F, 10.99734F, 1.459445F, 11.215516F, 1.400176F);
      localPath.cubicTo(11.543273F, 1.311137F, 11.868964F, 1.244495F, 12.199514F, 1.208951F);
      localPath.cubicTo(12.363703F, 1.191295F, 12.526502F, 1.18178F, 12.75884F, 1.182942F);
      localPath.cubicTo(14.968856F, 1.256499F, 16.883158F, 2.537786F, 17.758429F, 4.607925F);
      localPath.lineTo(21.76432F, 15.243251F);
      localPath.cubicTo(22.174992F, 16.370901F, 22.02397F, 17.225407F, 21.425602F, 18.319908F);
      localPath.cubicTo(20.350695F, 20.19817F, 18.13567F, 24.281309F, 16.98311F, 26.539143F);
      localPath.cubicTo(16.811522F, 26.857328F, 16.717373F, 27.220823F, 16.717373F, 27.561794F);
      localPath.cubicTo(16.717373F, 27.893484F, 16.827755F, 28.266993F, 17.037537F, 28.608128F);
      localPath.cubicTo(19.116108F, 32.131565F, 21.373028F, 35.143711F, 23.874208F, 37.641243F);
      localPath.cubicTo(26.34383F, 40.148949F, 29.340273F, 42.398449F, 32.931187F, 44.510921F);
      localPath.cubicTo(33.258274F, 44.711906F, 33.587967F, 44.810665F, 33.948303F, 44.810665F);
      localPath.cubicTo(34.317825F, 44.810665F, 34.637329F, 44.726711F, 35.004196F, 44.529732F);
      localPath.cubicTo(37.080528F, 43.453255F, 40.988239F, 41.339756F, 43.244305F, 40.088341F);
      localPath.cubicTo(44.298836F, 39.514008F, 45.08466F, 39.371342F, 46.228859F, 39.752171F);
      localPath.close();
      localPath.moveTo(36.681084F, 47.715221F);
      localPath.cubicTo(35.828789F, 48.173462F, 34.92606F, 48.410664F, 33.948303F, 48.410664F);
      localPath.cubicTo(32.90218F, 48.410664F, 31.924953F, 48.117935F, 31.071325F, 47.593086F);
      localPath.cubicTo(27.2605F, 45.351727F, 24.016785F, 42.916592F, 21.318104F, 40.176216F);
      localPath.cubicTo(18.59831F, 37.460506F, 16.161366F, 34.208096F, 13.951854F, 30.462145F);
      localPath.cubicTo(13.420091F, 29.599327F, 13.117373F, 28.574989F, 13.117373F, 27.561794F);
      localPath.cubicTo(13.117373F, 26.616503F, 13.363279F, 25.667091F, 13.798601F, 24.860672F);
      localPath.cubicTo(14.955836F, 22.59247F, 17.198269F, 18.458813F, 18.286577F, 16.557726F);
      localPath.cubicTo(18.313852F, 16.507795F, 17.022354F, 12.966344F, 14.412085F, 5.933369F);
      localPath.cubicTo(14.122012F, 5.248772F, 13.464088F, 4.808408F, 12.688983F, 4.78178F);
      localPath.cubicTo(12.464445F, 4.801216F, 12.31752F, 4.831279F, 12.159285F, 4.874266F);
      localPath.cubicTo(12.034602F, 4.908136F, 11.937806F, 4.939256F, 11.841541F, 4.971815F);
      localPath.cubicTo(7.70942F, 6.487458F, 4.923305F, 10.368135F, 4.923305F, 14.787783F);
      localPath.cubicTo(4.923305F, 15.359447F, 4.991529F, 15.966388F, 5.112502F, 16.622562F);
      localPath.cubicTo(5.157455F, 16.866392F, 5.313883F, 17.598818F, 5.308789F, 17.599607F);
      localPath.cubicTo(7.464259F, 27.015633F, 12.268067F, 35.58852F, 19.11071F, 42.420887F);
      localPath.cubicTo(25.953588F, 49.25349F, 34.539959F, 54.050415F, 44.048798F, 56.222805F);
      localPath.cubicTo(44.681938F, 56.403431F, 45.790562F, 56.587925F, 46.788559F, 56.587925F);
      localPath.cubicTo(51.216927F, 56.587925F, 55.104233F, 53.805424F, 56.60685F, 49.72311F);
      localPath.cubicTo(56.676903F, 49.531948F, 56.70863F, 49.445171F, 56.738026F, 49.350834F);
      localPath.cubicTo(56.782673F, 49.207561F, 56.809811F, 49.082161F, 56.815994F, 48.994804F);
      localPath.cubicTo(56.758045F, 48.080116F, 56.300301F, 47.409275F, 55.667988F, 47.140827F);
      localPath.lineTo(45.092609F, 43.169331F);
      localPath.cubicTo(42.707432F, 44.502876F, 38.771847F, 46.631451F, 36.681084F, 47.715221F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 25.107143F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(6.213008F, 15.805954F);
      ((Path)localObject2).cubicTo(5.760861F, 11.796948F, 6.943125F, 7.941129F, 9.672789F, 5.16775F);
      ((Path)localObject2).cubicTo(14.930721F, -0.1916638F, 24.014297F, 0.3555171F, 30.002613F, 6.229036F);
      ((Path)localObject2).cubicTo(35.939026F, 12.103612F, 36.636139F, 21.169064F, 31.394089F, 26.512226F);
      ((Path)localObject2).cubicTo(28.639668F, 29.359013F, 24.681374F, 30.622126F, 20.587873F, 30.150829F);
      ((Path)localObject2).cubicTo(20.28228F, 30.6213F, 19.929993F, 31.055887F, 19.519777F, 31.465485F);
      ((Path)localObject2).cubicTo(15.909817F, 35.1292F, 9.687203F, 34.754261F, 5.706035F, 30.77882F);
      ((Path)localObject2).cubicTo(1.647747F, 26.839188F, 1.164935F, 20.62562F, 4.794327F, 16.942354F);
      ((Path)localObject2).cubicTo(5.228859F, 16.508474F, 5.702417F, 16.129234F, 6.213008F, 15.805954F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.365063F, 25.962624F);
      ((Path)localObject2).cubicTo(18.590746F, 24.030882F, 17.812334F, 21.84523F, 16.140818F, 20.205503F);
      ((Path)localObject2).cubicTo(14.487469F, 18.583599F, 12.348417F, 17.838194F, 10.404866F, 18.042467F);
      ((Path)localObject2).cubicTo(11.0512F, 19.815674F, 12.129596F, 21.491978F, 13.579116F, 22.939444F);
      ((Path)localObject2).cubicTo(14.986223F, 24.313217F, 16.642477F, 25.348162F, 18.365063F, 25.962624F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.661846F, 17.635597F);
      ((Path)localObject2).cubicTo(21.186472F, 20.112207F, 22.363724F, 23.519043F, 21.906799F, 26.641684F);
      ((Path)localObject2).cubicTo(24.586773F, 26.728634F, 27.063313F, 25.811007F, 28.815586F, 24.000025F);
      ((Path)localObject2).cubicTo(32.594299F, 20.148378F, 32.070782F, 13.340383F, 27.476088F, 8.793527F);
      ((Path)localObject2).cubicTo(22.839022F, 4.245372F, 16.023672F, 3.834826F, 12.240551F, 7.69096F);
      ((Path)localObject2).cubicTo(10.504562F, 9.454752F, 9.639986F, 11.871755F, 9.724495F, 14.498878F);
      ((Path)localObject2).cubicTo(12.827285F, 14.0714F, 16.165052F, 15.186291F, 18.661846F, 17.635597F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.049835F, 25.50115F);
      ((Path)localObject2).cubicTo(9.326564F, 23.780466F, 8.011593F, 21.793489F, 7.172034F, 19.668589F);
      ((Path)localObject2).cubicTo(5.232044F, 21.869429F, 5.595444F, 25.654177F, 8.231642F, 28.213539F);
      ((Path)localObject2).cubicTo(10.777556F, 30.755632F, 14.50742F, 31.077387F, 16.696297F, 29.181122F);
      ((Path)localObject2).cubicTo(14.649492F, 28.37767F, 12.712568F, 27.124603F, 11.049835F, 25.50115F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.axt
 * JD-Core Version:    0.7.0.1
 */