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

public class ime_fault_deletion
  extends c
{
  private final int height = 47;
  private final int width = 34;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 34;
      return 47;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -75.0F, 0.0F, 1.0F, -911.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 76.912262F, 0.0F, 1.0F, 912.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.258819F, 0.9659258F, 0.08786637F, -0.9659258F, 0.258819F, 40.064678F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      Paint localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-372399);
      localPaint2.setColor(-372399);
      localPaint2.setStrokeWidth(0.5F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.765022F, 1.436282F);
      localPath.cubicTo(8.911966F, 1.402862F, 7.174727F, 1.503123F, 5.524348F, 2.539151F);
      localPath.cubicTo(3.87397F, 3.57518F, 1.921841F, 6.771721F, 1.197991F, 8.710097F);
      localPath.cubicTo(0.5381795F, 10.476987F, 0.9744355F, 13.073086F, 1.613791F, 14.934812F);
      localPath.cubicTo(2.253147F, 16.796537F, 5.152505F, 18.446913F, 6.660464F, 18.917105F);
      localPath.cubicTo(10.681495F, 20.170893F, 13.886724F, 20.183645F, 17.477051F, 18.87188F);
      localPath.cubicTo(19.707422F, 18.056988F, 22.775385F, 16.576925F, 24.523315F, 15.037091F);
      localPath.cubicTo(25.972044F, 13.76084F, 27.554419F, 12.177319F, 28.047028F, 9.885087F);
      localPath.cubicTo(28.539637F, 7.592856F, 28.143923F, 4.919647F, 27.122267F, 3.705599F);
      localPath.cubicTo(25.656158F, 1.963402F, 23.041519F, 0.567355F, 21.072647F, 0.06605065F);
      localPath.cubicTo(20.232981F, -0.134471F, 19.972395F, 0.7344562F, 20.841015F, 0.9683981F);
      localPath.cubicTo(22.867796F, 1.469702F, 25.761429F, 2.803251F, 26.687956F, 5.309772F);
      localPath.cubicTo(27.643438F, 7.883133F, 26.783728F, 11.340192F, 25.362982F, 12.764512F);
      localPath.cubicTo(22.276987F, 15.858273F, 17.894617F, 16.878468F, 13.985826F, 18.014757F);
      localPath.cubicTo(11.901138F, 18.616323F, 9.960062F, 19.093458F, 7.558038F, 18.31554F);
      localPath.cubicTo(6.482954F, 17.967363F, 4.025628F, 16.634392F, 3.148353F, 15.369275F);
      localPath.cubicTo(2.271079F, 14.104158F, 1.57616F, 11.921705F, 1.749884F, 10.751996F);
      localPath.cubicTo(2.068378F, 8.546258F, 3.865111F, 6.198245F, 5.263763F, 4.611208F);
      localPath.cubicTo(6.972048F, 2.672832F, 8.998829F, 2.40547F, 11.286195F, 2.43889F);
      localPath.cubicTo(12.241676F, 2.43889F, 11.344103F, 1.436282F, 10.765022F, 1.436282F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-372399);
      localPaint1.setStrokeWidth(1.5F);
      localPaint1.setStrokeCap(Paint.Cap.ROUND);
      localObject2 = c.setMatrixFloatArray(arrayOfFloat, 0.9702957F, -0.241922F, 2.923944F, 0.241922F, 0.9702957F, -4.840049F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(13.087735F, 16.973562F);
      ((Path)localObject1).cubicTo(14.415409F, 14.366261F, 14.920828F, 11.136235F, 17.070757F, 9.15166F);
      ((Path)localObject1).cubicTo(18.348331F, 7.972344F, 22.535595F, 10.526691F, 21.838129F, 12.472845F);
      ((Path)localObject1).cubicTo(21.52219F, 13.354415F, 19.109297F, 14.634107F, 19.321714F, 13.722043F);
      ((Path)localObject1).lineTo(18.312748F, 12.083672F);
      ((Path)localObject1).cubicTo(19.012842F, 9.077656F, 21.479582F, 3.856205F, 26.058977F, 5.45091F);
      ((Path)localObject1).cubicTo(28.983322F, 6.469268F, 25.878895F, 11.890565F, 23.531754F, 8.94386F);
      ((Path)localObject1).cubicTo(20.09399F, 4.627943F, 26.899046F, 2.270186F, 29.255243F, 2.0F);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_fault_deletion
 * JD-Core Version:    0.7.0.1
 */