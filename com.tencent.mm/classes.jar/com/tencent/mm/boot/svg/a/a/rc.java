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

public final class rc
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
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16384);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 7.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(22.179684F, 20.160744F);
      localPath.cubicTo(25.258177F, 13.424428F, 28.385149F, 6.712214F, 31.487881F, 0.0F);
      localPath.cubicTo(34.699692F, 6.688113F, 37.729702F, 13.472631F, 40.893036F, 20.196896F);
      localPath.cubicTo(48.262024F, 20.678921F, 55.631012F, 21.160948F, 63.0F, 21.655024F);
      localPath.cubicTo(57.630821F, 26.53554F, 52.188919F, 31.34375F, 46.843979F, 36.248367F);
      localPath.cubicTo(48.552906F, 43.828228F, 50.24971F, 51.408089F, 51.946518F, 58.987949F);
      localPath.cubicTo(45.135052F, 55.228146F, 38.335705F, 51.444241F, 31.512119F, 47.708538F);
      localPath.cubicTo(24.688534F, 51.456291F, 17.889189F, 55.228146F, 11.077723F, 59.0F);
      localPath.cubicTo(12.774529F, 51.408089F, 14.483455F, 43.828228F, 16.180262F, 36.248367F);
      localPath.cubicTo(11.041362F, 31.596813F, 5.963063F, 26.897058F, 0.702963F, 22.390114F);
      localPath.cubicTo(0.533282F, 22.390114F, 0.1818007F, 22.378063F, 0.0F, 22.366013F);
      localPath.lineTo(0.0F, 22.064747F);
      localPath.cubicTo(7.308388F, 20.739176F, 14.798576F, 20.895834F, 22.179684F, 20.160744F);
      localPath.lineTo(22.179684F, 20.160744F);
      localPath.lineTo(22.179684F, 20.160744F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 29.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(6.06F, 1.52F);
      ((Path)localObject2).cubicTo(13.81F, 1.24F, 21.540001F, 0.83F, 29.280001F, 0.5F);
      ((Path)localObject2).cubicTo(22.799999F, 6.15F, 16.290001F, 11.75F, 9.81F, 17.4F);
      ((Path)localObject2).lineTo(28.01F, 17.4F);
      ((Path)localObject2).cubicTo(28.01F, 17.719999F, 28.0F, 18.379999F, 28.0F, 18.709999F);
      ((Path)localObject2).cubicTo(19.33F, 19.120001F, 10.67F, 19.57F, 2.0F, 19.99F);
      ((Path)localObject2).cubicTo(8.51F, 14.35F, 15.02F, 8.71F, 21.530001F, 3.07F);
      ((Path)localObject2).cubicTo(14.37F, 2.95F, 7.21F, 3.31F, 0.07F, 2.85F);
      ((Path)localObject2).cubicTo(1.78F, 1.46F, 4.0F, 1.65F, 6.06F, 1.52F);
      ((Path)localObject2).lineTo(6.06F, 1.52F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.rc
 * JD-Core Version:    0.7.0.1
 */