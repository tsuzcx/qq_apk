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

public class icons_filled_applause
  extends c
{
  private final int height = 28;
  private final int width = 27;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 27;
      return 28;
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
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -43.0F, 0.0F, 1.0F, -11.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 43.982487F, 0.0F, 1.0F, 11.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 3.20138F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9659258F, 0.258819F, -2.238376F, -0.258819F, 0.9659258F, 4.71438F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(11.000913F, 1.586482F);
      localPath.cubicTo(11.976548F, 0.8354841F, 12.51147F, 1.691327F, 13.122373F, 2.391292F);
      localPath.cubicTo(13.875669F, 3.254408F, 16.043228F, 5.727036F, 18.439968F, 8.469557F);
      localPath.cubicTo(18.597345F, 8.652442F, 18.669649F, 8.765429F, 18.846584F, 8.718611F);
      localPath.cubicTo(19.02352F, 8.671792F, 19.080996F, 8.556607F, 19.085987F, 8.320234F);
      localPath.cubicTo(19.094072F, 7.937272F, 19.126431F, 6.636805F, 19.157038F, 5.793418F);
      localPath.cubicTo(19.163061F, 5.627412F, 19.375607F, 4.846566F, 20.120472F, 4.803665F);
      localPath.cubicTo(20.865337F, 4.760763F, 21.153221F, 5.322877F, 21.256069F, 5.609222F);
      localPath.cubicTo(21.596594F, 6.5573F, 22.085665F, 8.118693F, 22.421053F, 9.536285F);
      localPath.cubicTo(22.861359F, 11.397349F, 23.471088F, 14.110101F, 22.619469F, 16.175373F);
      localPath.cubicTo(22.044395F, 17.569988F, 20.745834F, 19.292593F, 18.439968F, 20.063894F);
      localPath.cubicTo(15.800656F, 20.946733F, 13.331619F, 20.0562F, 11.887998F, 18.909969F);
      localPath.cubicTo(11.246492F, 18.400614F, 13.393876F, 13.963059F, 13.286715F, 9.920789F);
      localPath.cubicTo(13.258541F, 8.858034F, 13.035641F, 7.824014F, 12.731988F, 6.889834F);
      localPath.lineTo(14.107131F, 8.529021F);
      localPath.cubicTo(14.284632F, 8.740559F, 14.60001F, 8.76815F, 14.811547F, 8.59065F);
      localPath.cubicTo(15.023435F, 8.412854F, 15.051944F, 8.09731F, 14.875354F, 7.884416F);
      localPath.lineTo(14.875354F, 7.884416F);
      localPath.lineTo(10.782134F, 2.9497F);
      localPath.lineTo(10.782134F, 2.9497F);
      localPath.lineTo(10.735723F, 2.885148F);
      localPath.lineTo(10.735723F, 2.885148F);
      localPath.lineTo(10.723873F, 2.869419F);
      localPath.cubicTo(10.531643F, 2.624208F, 10.290219F, 2.13354F, 11.000913F, 1.586482F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 102, 31);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9659258F, 0.258819F, -2.776649F, -0.258819F, 0.9659258F, 3.43425F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(8.44453F, 2.56749F);
      localPath.cubicTo(9.464699F, 1.782212F, 10.024037F, 2.677121F, 10.662826F, 3.409036F);
      localPath.cubicTo(11.450505F, 4.31155F, 13.717006F, 6.897042F, 16.223146F, 9.764747F);
      localPath.cubicTo(16.387707F, 9.955979F, 16.46331F, 10.074124F, 16.648321F, 10.025168F);
      localPath.cubicTo(16.833332F, 9.976214F, 16.893433F, 9.855771F, 16.898651F, 9.608608F);
      localPath.cubicTo(16.907106F, 9.208165F, 16.940943F, 7.848338F, 16.972946F, 6.966454F);
      localPath.cubicTo(16.979246F, 6.792871F, 17.201492F, 5.976383F, 17.980356F, 5.931523F);
      localPath.cubicTo(18.759222F, 5.886663F, 19.060246F, 6.474435F, 19.167789F, 6.77385F);
      localPath.cubicTo(19.523859F, 7.765204F, 20.035254F, 9.397868F, 20.385948F, 10.880167F);
      localPath.cubicTo(20.846354F, 12.82618F, 21.483913F, 15.662757F, 20.593422F, 17.8223F);
      localPath.cubicTo(19.9921F, 19.280575F, 18.634264F, 21.081806F, 16.223146F, 21.888315F);
      localPath.cubicTo(13.463361F, 22.811451F, 10.881623F, 21.88027F, 9.372107F, 20.681717F);
      localPath.cubicTo(8.097986F, 19.670069F, 6.456904F, 17.830307F, 4.415775F, 15.473873F);
      localPath.cubicTo(3.75334F, 14.709108F, 2.837077F, 13.576573F, 2.420389F, 12.952849F);
      localPath.cubicTo(2.270876F, 12.729051F, 2.079137F, 12.152341F, 2.681353F, 11.657216F);
      localPath.cubicTo(3.283569F, 11.162092F, 3.793947F, 11.380169F, 4.132518F, 11.817024F);
      localPath.cubicTo(4.129866F, 11.807F, 4.127202F, 11.79696F, 4.124525F, 11.786905F);
      localPath.lineTo(6.548622F, 14.676658F);
      localPath.cubicTo(6.734225F, 14.897851F, 7.063998F, 14.926702F, 7.285191F, 14.741099F);
      localPath.cubicTo(7.506384F, 14.555496F, 7.535235F, 14.225723F, 7.349633F, 14.00453F);
      localPath.lineTo(7.349633F, 14.00453F);
      localPath.lineTo(3.092333F, 8.930577F);
      localPath.lineTo(3.049989F, 8.864483F);
      localPath.cubicTo(2.778128F, 8.491896F, 2.692618F, 7.91537F, 3.172049F, 7.440092F);
      localPath.lineTo(3.283569F, 7.339908F);
      localPath.cubicTo(3.885786F, 6.847847F, 4.488282F, 6.869943F, 4.812475F, 7.253837F);
      localPath.cubicTo(4.820311F, 7.263115F, 4.837682F, 7.281647F, 4.864591F, 7.309432F);
      localPath.lineTo(9.050083F, 12.29757F);
      localPath.cubicTo(9.235686F, 12.518763F, 9.565459F, 12.547614F, 9.786653F, 12.362011F);
      localPath.cubicTo(10.007846F, 12.176408F, 10.036697F, 11.846635F, 9.851094F, 11.625442F);
      localPath.lineTo(9.851094F, 11.625442F);
      localPath.lineTo(4.8532F, 5.669209F);
      localPath.lineTo(4.836399F, 5.644411F);
      localPath.cubicTo(4.582585F, 5.338712F, 4.313511F, 4.576503F, 4.912079F, 3.9905F);
      localPath.lineTo(5.034694F, 3.882844F);
      localPath.cubicTo(5.78957F, 3.286244F, 6.39248F, 3.493784F, 6.8453F, 4.048815F);
      localPath.lineTo(6.781371F, 3.974217F);
      localPath.lineTo(11.692533F, 9.826925F);
      localPath.cubicTo(11.857514F, 10.023541F, 12.136407F, 10.068184F, 12.351697F, 9.945322F);
      localPath.lineTo(12.429103F, 9.891367F);
      localPath.cubicTo(12.650662F, 9.705457F, 12.680473F, 9.375508F, 12.495823F, 9.152898F);
      localPath.lineTo(12.495823F, 9.152898F);
      localPath.lineTo(8.165806F, 3.933437F);
      localPath.lineTo(8.154845F, 3.908988F);
      localPath.cubicTo(7.965664F, 3.667666F, 7.730918F, 3.198992F, 8.32351F, 2.667784F);
      localPath.lineTo(8.44453F, 2.56749F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.186855F, 3.357199F);
      localPath.lineTo(15.630839F, 4.554249F);
      localPath.lineTo(13.066316F, 0.8316033F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9848077F, 0.1736482F, -0.1214165F, -0.1736482F, 0.9848077F, 3.074374F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.186855F, 4.263395F);
      ((Path)localObject).lineTo(18.831985F, 2.448163F);
      ((Path)localObject).lineTo(17.514778F, 0.1987858F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_applause
 * JD-Core Version:    0.7.0.1
 */