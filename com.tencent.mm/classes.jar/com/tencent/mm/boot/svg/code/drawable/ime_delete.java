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

public class ime_delete
  extends c
{
  private final int height = 31;
  private final int width = 43;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 43;
      return 31;
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
      localPaint1.setColor(-13158600);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -667.0F, 0.0F, 1.0F, -1089.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 667.0F, 0.0F, 1.0F, 1089.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(40.213036F, 3.403134F);
      ((Path)localObject2).cubicTo(40.213036F, 3.405221F, 40.213036F, 11.479917F, 40.213036F, 27.627222F);
      ((Path)localObject2).cubicTo(40.219101F, 27.999975F, 39.913609F, 28.307013F, 39.530605F, 28.313091F);
      ((Path)localObject2).cubicTo(39.528461F, 28.313091F, 31.80698F, 28.313091F, 16.366159F, 28.313091F);
      ((Path)localObject2).cubicTo(16.187557F, 28.312082F, 16.016304F, 28.243748F, 15.888379F, 28.122444F);
      ((Path)localObject2).lineTo(2.966016F, 16.257282F);
      ((Path)localObject2).cubicTo(2.822465F, 16.134617F, 2.7408F, 15.957273F, 2.742255F, 15.771359F);
      ((Path)localObject2).cubicTo(2.733963F, 15.573833F, 2.807724F, 15.381376F, 2.946905F, 15.237387F);
      ((Path)localObject2).lineTo(15.615229F, 2.897144F);
      ((Path)localObject2).cubicTo(15.742661F, 2.768322F, 15.918831F, 2.696042F, 16.102564F, 2.697182F);
      ((Path)localObject2).lineTo(39.520954F, 2.697182F);
      ((Path)localObject2).cubicTo(39.904011F, 2.727461F, 40.21386F, 3.030332F, 40.213036F, 3.403134F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.063559F, 1.345143E-009F);
      ((Path)localObject2).cubicTo(15.153437F, -0.009855253F, 14.276648F, 0.3331509F, 13.626881F, 0.9534599F);
      ((Path)localObject2).lineTo(1.007113F, 13.37971F);
      ((Path)localObject2).cubicTo(-0.3402331F, 14.697259F, -0.335026F, 16.828369F, 1.018742F, 18.139664F);
      ((Path)localObject2).cubicTo(1.035374F, 18.155773F, 5.367351F, 22.124798F, 14.014675F, 30.046738F);
      ((Path)localObject2).cubicTo(14.643038F, 30.645569F, 15.483623F, 30.98679F, 16.362963F, 31.0F);
      ((Path)localObject2).lineTo(39.520966F, 31.0F);
      ((Path)localObject2).cubicTo(41.436214F, 31.005974F, 42.993824F, 29.499758F, 43.0F, 27.635756F);
      ((Path)localObject2).cubicTo(43.0F, 27.633684F, 43.0F, 19.559011F, 43.0F, 3.411738F);
      ((Path)localObject2).cubicTo(42.99934F, 1.555602F, 41.45826F, 0.04818133F, 39.550781F, 0.0381911F);
      ((Path)localObject2).lineTo(16.063559F, 1.345143E-009F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.988106F, 23.098309F);
      ((Path)localObject2).cubicTo(32.621147F, 23.103546F, 32.267673F, 22.963701F, 32.008656F, 22.710661F);
      ((Path)localObject2).lineTo(19.2798F, 10.274329F);
      ((Path)localObject2).cubicTo(18.747774F, 9.739628F, 18.761858F, 8.886411F, 19.311262F, 8.368619F);
      ((Path)localObject2).cubicTo(19.848223F, 7.862553F, 20.700939F, 7.862553F, 21.237902F, 8.368619F);
      ((Path)localObject2).lineTo(34.016121F, 20.756907F);
      ((Path)localObject2).cubicTo(34.556835F, 21.280258F, 34.55925F, 22.13113F, 34.021507F, 22.657377F);
      ((Path)localObject2).cubicTo(33.760056F, 22.92136F, 33.405773F, 23.066008F, 33.036671F, 23.062515F);
      ((Path)localObject2).lineTo(32.988106F, 23.098309F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.837708F, 21.653801F);
      ((Path)localObject2).cubicTo(18.84227F, 21.30739F, 18.983072F, 20.975836F, 19.231213F, 20.727448F);
      ((Path)localObject2).lineTo(32.008656F, 8.338374F);
      ((Path)localObject2).cubicTo(32.54068F, 7.803672F, 33.417355F, 7.789961F, 33.966755F, 8.307755F);
      ((Path)localObject2).cubicTo(34.516155F, 8.825545F, 34.530243F, 9.678763F, 33.998215F, 10.213465F);
      ((Path)localObject2).cubicTo(33.991337F, 10.220378F, 29.718262F, 14.360276F, 21.178986F, 22.633158F);
      ((Path)localObject2).cubicTo(20.918852F, 22.884556F, 20.566116F, 23.024107F, 20.199535F, 23.020655F);
      ((Path)localObject2).cubicTo(19.44286F, 23.014412F, 18.828217F, 22.40106F, 18.837708F, 21.653801F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_delete
 * JD-Core Version:    0.7.0.1
 */