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

public class icons_filled_channels_enterprise_wechat
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
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.614719F, 15.085323F);
      ((Path)localObject2).cubicTo(14.621364F, 15.093493F, 14.628443F, 15.101442F, 14.636066F, 15.109066F);
      ((Path)localObject2).cubicTo(14.649244F, 15.122245F, 14.663403F, 15.13368F, 14.678215F, 15.143918F);
      ((Path)localObject2).cubicTo(14.707621F, 15.171581F, 14.736917F, 15.19968F, 14.765671F, 15.228433F);
      ((Path)localObject2).cubicTo(15.331244F, 15.794007F, 15.686729F, 16.490057F, 15.832561F, 17.21965F);
      ((Path)localObject2).cubicTo(15.835066F, 17.26071F, 15.839532F, 17.301661F, 15.846066F, 17.342394F);
      ((Path)localObject2).cubicTo(15.853254F, 17.387264F, 15.862839F, 17.4317F, 15.874819F, 17.4757F);
      ((Path)localObject2).cubicTo(15.930799F, 17.680887F, 16.038948F, 17.874641F, 16.200027F, 18.03583F);
      ((Path)localObject2).cubicTo(16.693611F, 18.529305F, 17.49378F, 18.529305F, 17.987364F, 18.03583F);
      ((Path)localObject2).cubicTo(18.480839F, 17.542244F, 18.480839F, 16.742077F, 17.987364F, 16.248491F);
      ((Path)localObject2).cubicTo(17.813324F, 16.074562F, 17.601274F, 15.962165F, 17.378006F, 15.910869F);
      ((Path)localObject2).cubicTo(17.352957F, 15.905096F, 17.327799F, 15.900195F, 17.302641F, 15.895947F);
      ((Path)localObject2).cubicTo(17.277155F, 15.8917F, 17.25178F, 15.888106F, 17.226185F, 15.885492F);
      ((Path)localObject2).cubicTo(16.478403F, 15.746086F, 15.763512F, 15.387443F, 15.185086F, 14.809017F);
      ((Path)localObject2).cubicTo(15.143373F, 14.767304F, 15.102967F, 14.72472F, 15.063541F, 14.681591F);
      ((Path)localObject2).lineTo(15.063324F, 14.6817F);
      ((Path)localObject2).cubicTo(14.945374F, 14.563749F, 14.754017F, 14.563749F, 14.636066F, 14.6817F);
      ((Path)localObject2).cubicTo(14.525631F, 14.792135F, 14.518552F, 14.966611F, 14.614719F, 15.085323F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.610617F, 16.056318F);
      ((Path)localObject2).cubicTo(18.618786F, 16.049675F, 18.626736F, 16.042597F, 18.634359F, 16.034973F);
      ((Path)localObject2).cubicTo(18.647537F, 16.021793F, 18.658974F, 16.007635F, 18.66921F, 15.992824F);
      ((Path)localObject2).cubicTo(18.696875F, 15.963418F, 18.724974F, 15.934121F, 18.753725F, 15.905368F);
      ((Path)localObject2).cubicTo(19.3193F, 15.339794F, 20.01535F, 14.984309F, 20.744944F, 14.838477F);
      ((Path)localObject2).cubicTo(20.786003F, 14.835972F, 20.826954F, 14.831507F, 20.867685F, 14.824972F);
      ((Path)localObject2).cubicTo(20.912558F, 14.817784F, 20.956993F, 14.8082F, 21.000994F, 14.79622F);
      ((Path)localObject2).cubicTo(21.206181F, 14.740239F, 21.399933F, 14.632092F, 21.561121F, 14.471012F);
      ((Path)localObject2).cubicTo(22.054598F, 13.977427F, 22.054598F, 13.177259F, 21.561121F, 12.683675F);
      ((Path)localObject2).cubicTo(21.067537F, 12.1902F, 20.26737F, 12.1902F, 19.773785F, 12.683675F);
      ((Path)localObject2).cubicTo(19.599855F, 12.857715F, 19.487459F, 13.069764F, 19.436161F, 13.293032F);
      ((Path)localObject2).cubicTo(19.430389F, 13.318081F, 19.425488F, 13.34324F, 19.42124F, 13.368398F);
      ((Path)localObject2).cubicTo(19.416992F, 13.393883F, 19.413399F, 13.419259F, 19.410786F, 13.444854F);
      ((Path)localObject2).cubicTo(19.271379F, 14.192636F, 18.912735F, 14.907527F, 18.334311F, 15.485952F);
      ((Path)localObject2).cubicTo(18.292597F, 15.527665F, 18.250013F, 15.568071F, 18.206884F, 15.607497F);
      ((Path)localObject2).lineTo(18.206993F, 15.607715F);
      ((Path)localObject2).cubicTo(18.089043F, 15.725665F, 18.089043F, 15.917022F, 18.206993F, 16.034973F);
      ((Path)localObject2).cubicTo(18.317429F, 16.145409F, 18.491903F, 16.152487F, 18.610617F, 16.056318F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(19.581612F, 12.060422F);
      ((Path)localObject2).cubicTo(19.574968F, 12.052254F, 19.567888F, 12.044303F, 19.560265F, 12.036679F);
      ((Path)localObject2).cubicTo(19.547087F, 12.023501F, 19.532928F, 12.012065F, 19.518116F, 12.001827F);
      ((Path)localObject2).cubicTo(19.48871F, 11.974164F, 19.459414F, 11.946065F, 19.430662F, 11.917313F);
      ((Path)localObject2).cubicTo(18.865088F, 11.351739F, 18.509602F, 10.655689F, 18.36377F, 9.926095F);
      ((Path)localObject2).cubicTo(18.361265F, 9.885036F, 18.3568F, 9.844085F, 18.350266F, 9.803352F);
      ((Path)localObject2).cubicTo(18.343077F, 9.758481F, 18.333492F, 9.714046F, 18.321512F, 9.670046F);
      ((Path)localObject2).cubicTo(18.265533F, 9.464857F, 18.157385F, 9.271105F, 17.996305F, 9.109917F);
      ((Path)localObject2).cubicTo(17.50272F, 8.616442F, 16.702553F, 8.616442F, 16.208969F, 9.109917F);
      ((Path)localObject2).cubicTo(15.715493F, 9.603501F, 15.715493F, 10.403669F, 16.208969F, 10.897253F);
      ((Path)localObject2).cubicTo(16.383007F, 11.071184F, 16.595057F, 11.18358F, 16.818325F, 11.234878F);
      ((Path)localObject2).cubicTo(16.843374F, 11.240649F, 16.868532F, 11.24555F, 16.893692F, 11.249798F);
      ((Path)localObject2).cubicTo(16.919176F, 11.254045F, 16.944553F, 11.25764F, 16.970146F, 11.260254F);
      ((Path)localObject2).cubicTo(17.717928F, 11.399659F, 18.432819F, 11.758303F, 19.011246F, 12.336729F);
      ((Path)localObject2).cubicTo(19.052958F, 12.378442F, 19.093365F, 12.421025F, 19.13279F, 12.464154F);
      ((Path)localObject2).lineTo(19.133007F, 12.464046F);
      ((Path)localObject2).cubicTo(19.250957F, 12.581996F, 19.442314F, 12.581996F, 19.560265F, 12.464046F);
      ((Path)localObject2).cubicTo(19.6707F, 12.35361F, 19.67778F, 12.179134F, 19.581612F, 12.060422F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.585704F, 11.089427F);
      ((Path)localObject2).cubicTo(15.577536F, 11.09607F, 15.569585F, 11.103149F, 15.561961F, 11.110773F);
      ((Path)localObject2).cubicTo(15.548783F, 11.123952F, 15.537348F, 11.13811F, 15.52711F, 11.152922F);
      ((Path)localObject2).cubicTo(15.499447F, 11.182327F, 15.471348F, 11.211625F, 15.442595F, 11.240377F);
      ((Path)localObject2).cubicTo(14.877021F, 11.805951F, 14.180971F, 12.161437F, 13.451377F, 12.307268F);
      ((Path)localObject2).cubicTo(13.410317F, 12.309773F, 13.369368F, 12.314239F, 13.328634F, 12.320773F);
      ((Path)localObject2).cubicTo(13.283763F, 12.327961F, 13.239327F, 12.337545F, 13.195328F, 12.349525F);
      ((Path)localObject2).cubicTo(12.99014F, 12.405506F, 12.796387F, 12.513655F, 12.635199F, 12.674734F);
      ((Path)localObject2).cubicTo(12.141724F, 13.168318F, 12.141724F, 13.968486F, 12.635199F, 14.46207F);
      ((Path)localObject2).cubicTo(13.128783F, 14.955545F, 13.928951F, 14.955545F, 14.422536F, 14.46207F);
      ((Path)localObject2).cubicTo(14.596466F, 14.288031F, 14.708862F, 14.075981F, 14.760159F, 13.852714F);
      ((Path)localObject2).cubicTo(14.765932F, 13.827664F, 14.770833F, 13.802505F, 14.77508F, 13.777348F);
      ((Path)localObject2).cubicTo(14.779327F, 13.751863F, 14.782922F, 13.726486F, 14.785536F, 13.700892F);
      ((Path)localObject2).cubicTo(14.924942F, 12.95311F, 15.283586F, 12.238219F, 15.862011F, 11.659793F);
      ((Path)localObject2).cubicTo(15.903724F, 11.61808F, 15.946308F, 11.577674F, 15.989436F, 11.538248F);
      ((Path)localObject2).lineTo(15.989327F, 11.538031F);
      ((Path)localObject2).cubicTo(16.107279F, 11.42008F, 16.107279F, 11.228724F, 15.989327F, 11.110773F);
      ((Path)localObject2).cubicTo(15.878892F, 11.000338F, 15.704417F, 10.993258F, 15.585704F, 11.089427F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(17.464895F, 4.914288F);
      ((Path)localObject1).cubicTo(17.113441F, 4.191991F, 16.641094F, 3.521536F, 16.061144F, 2.921437F);
      ((Path)localObject1).cubicTo(14.595638F, 1.405724F, 12.543866F, 0.4294466F, 10.283965F, 0.1725258F);
      ((Path)localObject1).cubicTo(9.878272F, 0.1264564F, 9.476173F, 0.10315F, 9.088778F, 0.10315F);
      ((Path)localObject1).cubicTo(8.719569F, 0.10315F, 8.334569F, 0.124605F, 7.94445F, 0.1670802F);
      ((Path)localObject1).cubicTo(5.674421F, 0.4138723F, 3.611322F, 1.385031F, 2.135035F, 2.901724F);
      ((Path)localObject1).cubicTo(1.552361F, 3.500407F, 1.077619F, 4.169338F, 0.7236584F, 4.889674F);
      ((Path)localObject1).cubicTo(0.24347F, 5.867259F, 5.445545E-005F, 6.904962F, 5.445545E-005F, 7.973922F);
      ((Path)localObject1).cubicTo(5.445545E-005F, 9.350228F, 0.4188168F, 10.707258F, 1.211144F, 11.898525F);
      ((Path)localObject1).cubicTo(1.659203F, 12.572248F, 2.425391F, 13.442991F, 3.081253F, 13.976545F);
      ((Path)localObject1).lineTo(3.081253F, 13.976545F);
      ((Path)localObject1).lineTo(2.718035F, 15.478971F);
      ((Path)localObject1).lineTo(2.613371F, 15.90209F);
      ((Path)localObject1).cubicTo(2.594966F, 15.943694F, 2.580698F, 15.987258F, 2.570678F, 16.032675F);
      ((Path)localObject1).cubicTo(2.56447F, 16.060337F, 2.562619F, 16.089417F, 2.559896F, 16.118279F);
      ((Path)localObject1).cubicTo(2.557827F, 16.140169F, 2.553253F, 16.161299F, 2.553253F, 16.183842F);
      ((Path)localObject1).cubicTo(2.553253F, 16.57015F, 2.866371F, 16.883268F, 3.252787F, 16.883268F);
      ((Path)localObject1).cubicTo(3.379015F, 16.883268F, 3.495876F, 16.847219F, 3.598144F, 16.788734F);
      ((Path)localObject1).cubicTo(3.601302F, 16.786882F, 3.604787F, 16.785248F, 3.607837F, 16.783398F);
      ((Path)localObject1).cubicTo(3.622866F, 16.774574F, 3.638114F, 16.766733F, 3.652381F, 16.756931F);
      ((Path)localObject1).lineTo(6.246639F, 15.454793F);
      ((Path)localObject1).cubicTo(6.805025F, 15.615001F, 7.359055F, 15.717486F, 7.943253F, 15.781744F);
      ((Path)localObject1).cubicTo(8.322916F, 15.823565F, 8.708351F, 15.844694F, 9.088778F, 15.844694F);
      ((Path)localObject1).cubicTo(9.476718F, 15.844694F, 9.878817F, 15.821279F, 10.283965F, 15.775208F);
      ((Path)localObject1).cubicTo(11.080648F, 15.684704F, 11.846946F, 15.501081F, 12.574362F, 15.239912F);
      ((Path)localObject1).cubicTo(12.495728F, 15.213882F, 12.418509F, 15.179793F, 12.343797F, 15.136992F);
      ((Path)localObject1).cubicTo(11.898787F, 14.882466F, 11.668332F, 14.398249F, 11.714074F, 13.919041F);
      ((Path)localObject1).cubicTo(11.194242F, 14.084149F, 10.651431F, 14.202536F, 10.090213F, 14.266249F);
      ((Path)localObject1).cubicTo(9.749758F, 14.30502F, 9.412678F, 14.324625F, 9.088778F, 14.324625F);
      ((Path)localObject1).cubicTo(8.770431F, 14.324625F, 8.447837F, 14.306872F, 8.130034F, 14.271912F);
      ((Path)localObject1).cubicTo(8.063708F, 14.264615F, 7.997708F, 14.254486F, 7.931599F, 14.245665F);
      ((Path)localObject1).cubicTo(7.494975F, 14.187506F, 7.063361F, 14.098526F, 6.646451F, 13.976328F);
      ((Path)localObject1).cubicTo(6.5615F, 13.949209F, 6.47154F, 13.935486F, 6.379292F, 13.935486F);
      ((Path)localObject1).cubicTo(6.23553F, 13.935486F, 6.096015F, 13.973496F, 5.95454F, 14.046902F);
      ((Path)localObject1).cubicTo(5.936243F, 14.056377F, 5.918055F, 14.064219F, 5.899649F, 14.075001F);
      ((Path)localObject1).lineTo(4.235055F, 15.055962F);
      ((Path)localObject1).lineTo(4.233312F, 15.056942F);
      ((Path)localObject1).cubicTo(4.198787F, 15.07709F, 4.179292F, 15.084605F, 4.161431F, 15.084605F);
      ((Path)localObject1).cubicTo(4.102945F, 15.084605F, 4.055461F, 15.035159F, 4.055461F, 14.974387F);
      ((Path)localObject1).lineTo(4.116995F, 14.725743F);
      ((Path)localObject1).cubicTo(4.134203F, 14.660179F, 4.15849F, 14.567822F, 4.187896F, 14.455536F);
      ((Path)localObject1).cubicTo(4.260649F, 14.178466F, 4.360084F, 13.799457F, 4.433926F, 13.51814F);
      ((Path)localObject1).cubicTo(4.449935F, 13.460634F, 4.466272F, 13.391585F, 4.466272F, 13.31404F);
      ((Path)localObject1).cubicTo(4.466272F, 13.099813F, 4.363787F, 12.897347F, 4.193015F, 12.772971F);
      ((Path)localObject1).cubicTo(4.106104F, 12.708714F, 4.019302F, 12.641298F, 3.928035F, 12.56702F);
      ((Path)localObject1).cubicTo(3.788302F, 12.453318F, 3.654668F, 12.334823F, 3.526045F, 12.212843F);
      ((Path)localObject1).cubicTo(3.164678F, 11.8701F, 2.847421F, 11.495991F, 2.580916F, 11.095199F);
      ((Path)localObject1).cubicTo(1.953371F, 10.151813F, 1.621738F, 9.081327F, 1.621738F, 7.999298F);
      ((Path)localObject1).cubicTo(1.621738F, 7.159595F, 1.813748F, 6.342981F, 2.192322F, 5.572328F);
      ((Path)localObject1).cubicTo(2.475164F, 4.996625F, 2.856134F, 4.460566F, 3.324777F, 3.978962F);
      ((Path)localObject1).cubicTo(4.538262F, 2.73215F, 6.244787F, 1.932744F, 8.129817F, 1.727773F);
      ((Path)localObject1).cubicTo(8.457965F, 1.692051F, 8.78056F, 1.673971F, 9.088778F, 1.673971F);
      ((Path)localObject1).cubicTo(9.412352F, 1.673971F, 9.749322F, 1.693575F, 10.090213F, 1.732348F);
      ((Path)localObject1).cubicTo(11.96653F, 1.945704F, 13.663143F, 2.74914F, 14.867589F, 3.994862F);
      ((Path)localObject1).cubicTo(15.334055F, 4.477447F, 15.712955F, 5.014704F, 15.993836F, 5.591823F);
      ((Path)localObject1).cubicTo(16.366312F, 6.357575F, 16.555273F, 7.167545F, 16.555273F, 7.999298F);
      ((Path)localObject1).cubicTo(16.555273F, 8.085774F, 16.549828F, 8.171922F, 16.54558F, 8.25818F);
      ((Path)localObject1).cubicTo(17.032303F, 7.960308F, 17.675529F, 8.018793F, 18.096798F, 8.440061F);
      ((Path)localObject1).cubicTo(18.118143F, 8.461298F, 18.136005F, 8.484605F, 18.155392F, 8.507041F);
      ((Path)localObject1).cubicTo(18.169333F, 8.329843F, 18.177065F, 8.1521F, 18.177065F, 7.973922F);
      ((Path)localObject1).cubicTo(18.177065F, 6.914872F, 17.93746F, 5.885447F, 17.464895F, 4.914288F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_channels_enterprise_wechat
 * JD-Core Version:    0.7.0.1
 */