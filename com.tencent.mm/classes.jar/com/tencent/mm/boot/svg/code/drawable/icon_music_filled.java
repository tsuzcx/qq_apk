package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icon_music_filled
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(22.278984F, 3.990273F);
      ((Path)localObject).cubicTo(22.285133F, 4.020719F, 22.28688F, 4.05189F, 22.284174F, 4.082832F);
      ((Path)localObject).lineTo(21.078268F, 17.866407F);
      ((Path)localObject).cubicTo(20.928942F, 19.573206F, 19.399317F, 20.833605F, 17.661755F, 20.681587F);
      ((Path)localObject).cubicTo(15.924193F, 20.52957F, 14.636673F, 19.022703F, 14.785998F, 17.315907F);
      ((Path)localObject).cubicTo(14.930175F, 15.667963F, 16.361099F, 14.436164F, 18.023552F, 14.489999F);
      ((Path)localObject).lineTo(18.202511F, 14.500727F);
      ((Path)localObject).cubicTo(18.550022F, 14.53113F, 18.855947F, 14.27905F, 18.885813F, 13.937691F);
      ((Path)localObject).lineTo(19.468996F, 7.261887F);
      ((Path)localObject).lineTo(11.724218F, 8.825836F);
      ((Path)localObject).lineTo(10.794334F, 19.457949F);
      ((Path)localObject).cubicTo(10.650159F, 21.10589F, 9.219235F, 22.33769F, 7.556781F, 22.283855F);
      ((Path)localObject).lineTo(7.377822F, 22.273129F);
      ((Path)localObject).cubicTo(5.64026F, 22.121111F, 4.35274F, 20.614244F, 4.502066F, 18.907446F);
      ((Path)localObject).cubicTo(4.646242F, 17.259504F, 6.077166F, 16.027704F, 7.73962F, 16.081539F);
      ((Path)localObject).lineTo(7.918578F, 16.092268F);
      ((Path)localObject).cubicTo(8.26609F, 16.122671F, 8.572015F, 15.870591F, 8.60188F, 15.529231F);
      ((Path)localObject).lineTo(9.391856F, 6.499761F);
      ((Path)localObject).cubicTo(9.404401F, 6.356377F, 9.50987F, 6.238376F, 9.650952F, 6.209878F);
      ((Path)localObject).lineTo(21.896542F, 3.736368F);
      ((Path)localObject).cubicTo(22.072264F, 3.700874F, 22.243488F, 3.814551F, 22.278984F, 3.990273F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.060958F, 1.714286F);
      ((Path)localObject).lineTo(7.241216F, 3.567186F);
      ((Path)localObject).lineTo(5.480158F, 3.731642F);
      ((Path)localObject).lineTo(6.108594F, 8.117132F);
      ((Path)localObject).lineTo(6.102763F, 8.116983F);
      ((Path)localObject).lineTo(6.114465F, 8.180941F);
      ((Path)localObject).cubicTo(6.27589F, 9.309209F, 5.523709F, 10.356649F, 4.411471F, 10.60168F);
      ((Path)localObject).lineTo(4.232944F, 10.633595F);
      ((Path)localObject).cubicTo(3.023886F, 10.800508F, 1.906002F, 9.973038F, 1.736074F, 8.785389F);
      ((Path)localObject).cubicTo(1.566158F, 7.597737F, 2.408544F, 6.499646F, 3.617602F, 6.332733F);
      ((Path)localObject).cubicTo(3.728144F, 6.317473F, 3.837924F, 6.310524F, 3.946287F, 6.311403F);
      ((Path)localObject).lineTo(3.445158F, 2.701991F);
      ((Path)localObject).cubicTo(3.403295F, 2.400189F, 3.589872F, 2.11955F, 3.874608F, 2.028421F);
      ((Path)localObject).lineTo(4.01092F, 2.000593F);
      ((Path)localObject).lineTo(7.060958F, 1.714286F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_music_filled
 * JD-Core Version:    0.7.0.1
 */