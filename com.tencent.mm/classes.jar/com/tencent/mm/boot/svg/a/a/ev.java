package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class ev
  extends c
{
  private final int height = 16;
  private final int width = 28;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 28;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-824064);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 1.6F);
      localPath.cubicTo(0.0F, 0.7163444F, 0.7163444F, 0.0F, 1.6F, 0.0F);
      localPath.lineTo(26.4F, 0.0F);
      localPath.cubicTo(27.283655F, 0.0F, 28.0F, 0.7163444F, 28.0F, 1.6F);
      localPath.lineTo(28.0F, 14.4F);
      localPath.cubicTo(28.0F, 15.283655F, 27.283655F, 16.0F, 26.4F, 16.0F);
      localPath.lineTo(1.6F, 16.0F);
      localPath.cubicTo(0.7163444F, 16.0F, 0.0F, 15.283655F, 0.0F, 14.4F);
      localPath.lineTo(0.0F, 1.6F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(7.8575F, 7.267167F);
      ((Path)localObject).lineTo(5.9045F, 7.267167F);
      ((Path)localObject).lineTo(5.9045F, 11.267667F);
      ((Path)localObject).cubicTo(5.9045F, 11.519667F, 6.041F, 11.656167F, 6.3245F, 11.656167F);
      ((Path)localObject).lineTo(8.1515F, 11.656167F);
      ((Path)localObject).cubicTo(8.4665F, 11.656167F, 8.666F, 11.572166F, 8.7395F, 11.414667F);
      ((Path)localObject).cubicTo(8.8235F, 11.246667F, 8.8865F, 10.889667F, 8.9285F, 10.354167F);
      ((Path)localObject).lineTo(9.863F, 10.669167F);
      ((Path)localObject).cubicTo(9.779F, 11.582666F, 9.653F, 12.139167F, 9.464F, 12.328167F);
      ((Path)localObject).cubicTo(9.296F, 12.496166F, 8.9495F, 12.580167F, 8.4455F, 12.580167F);
      ((Path)localObject).lineTo(5.894F, 12.580167F);
      ((Path)localObject).cubicTo(5.2325F, 12.580167F, 4.907F, 12.265166F, 4.907F, 11.635167F);
      ((Path)localObject).lineTo(4.907F, 6.647667F);
      ((Path)localObject).lineTo(4.403F, 7.151667F);
      ((Path)localObject).lineTo(3.815F, 6.343167F);
      ((Path)localObject).cubicTo(4.8125F, 5.429667F, 5.726F, 4.348167F, 6.5555F, 3.109167F);
      ((Path)localObject).lineTo(7.2905F, 3.109167F);
      ((Path)localObject).cubicTo(8.2145F, 4.075167F, 9.0965F, 5.083167F, 9.9155F, 6.133167F);
      ((Path)localObject).lineTo(9.2645F, 6.815667F);
      ((Path)localObject).cubicTo(8.3615F, 5.618667F, 7.616F, 4.694667F, 7.007F, 4.054167F);
      ((Path)localObject).cubicTo(6.461F, 4.862667F, 5.852F, 5.639667F, 5.159F, 6.385167F);
      ((Path)localObject).lineTo(8.834F, 6.385167F);
      ((Path)localObject).lineTo(8.834F, 9.283167F);
      ((Path)localObject).cubicTo(8.8235F, 9.860666F, 8.5085F, 10.165167F, 7.8785F, 10.207167F);
      ((Path)localObject).cubicTo(7.469F, 10.207167F, 7.0805F, 10.196667F, 6.713F, 10.175667F);
      ((Path)localObject).lineTo(6.4715F, 9.241167F);
      ((Path)localObject).cubicTo(6.86F, 9.283167F, 7.196F, 9.304167F, 7.49F, 9.304167F);
      ((Path)localObject).cubicTo(7.7315F, 9.304167F, 7.8575F, 9.178166F, 7.8575F, 8.947166F);
      ((Path)localObject).lineTo(7.8575F, 7.267167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.388F, 3.980667F);
      ((Path)localObject).lineTo(11.3645F, 3.980667F);
      ((Path)localObject).lineTo(11.3645F, 10.459167F);
      ((Path)localObject).lineTo(10.388F, 10.459167F);
      ((Path)localObject).lineTo(10.388F, 3.980667F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.2045F, 12.653666F);
      ((Path)localObject).lineTo(10.619F, 12.653666F);
      ((Path)localObject).lineTo(10.388F, 11.698167F);
      ((Path)localObject).cubicTo(10.9025F, 11.740167F, 11.396F, 11.761167F, 11.858F, 11.761167F);
      ((Path)localObject).cubicTo(12.11F, 11.761167F, 12.236F, 11.603666F, 12.236F, 11.299167F);
      ((Path)localObject).lineTo(12.236F, 3.088167F);
      ((Path)localObject).lineTo(13.2335F, 3.088167F);
      ((Path)localObject).lineTo(13.2335F, 11.551167F);
      ((Path)localObject).cubicTo(13.2335F, 12.286167F, 12.887F, 12.653666F, 12.2045F, 12.653666F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.792999F, 4.474167F);
      ((Path)localObject).lineTo(15.155F, 4.474167F);
      ((Path)localObject).lineTo(15.155F, 3.634167F);
      ((Path)localObject).lineTo(18.620001F, 3.634167F);
      ((Path)localObject).cubicTo(18.535999F, 3.455667F, 18.452F, 3.287667F, 18.368F, 3.140667F);
      ((Path)localObject).lineTo(19.449499F, 2.972667F);
      ((Path)localObject).cubicTo(19.533501F, 3.172167F, 19.628F, 3.392667F, 19.712F, 3.634167F);
      ((Path)localObject).lineTo(23.344999F, 3.634167F);
      ((Path)localObject).lineTo(23.344999F, 4.474167F);
      ((Path)localObject).lineTo(21.675501F, 4.474167F);
      ((Path)localObject).lineTo(21.371F, 5.104167F);
      ((Path)localObject).lineTo(23.838499F, 5.104167F);
      ((Path)localObject).lineTo(23.838499F, 5.965167F);
      ((Path)localObject).lineTo(14.6615F, 5.965167F);
      ((Path)localObject).lineTo(14.6615F, 5.104167F);
      ((Path)localObject).lineTo(17.045F, 5.104167F);
      ((Path)localObject).lineTo(16.792999F, 4.474167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.084499F, 5.104167F);
      ((Path)localObject).lineTo(20.331499F, 5.104167F);
      ((Path)localObject).lineTo(20.636F, 4.474167F);
      ((Path)localObject).lineTo(17.8325F, 4.474167F);
      ((Path)localObject).lineTo(18.084499F, 5.104167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.7535F, 6.406167F);
      ((Path)localObject).lineTo(22.7465F, 6.406167F);
      ((Path)localObject).lineTo(22.7465F, 9.682167F);
      ((Path)localObject).lineTo(15.7535F, 9.682167F);
      ((Path)localObject).lineTo(15.7535F, 6.406167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.77F, 8.926167F);
      ((Path)localObject).lineTo(21.77F, 8.401167F);
      ((Path)localObject).lineTo(16.73F, 8.401167F);
      ((Path)localObject).lineTo(16.73F, 8.926167F);
      ((Path)localObject).lineTo(21.77F, 8.926167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.73F, 7.687167F);
      ((Path)localObject).lineTo(21.77F, 7.687167F);
      ((Path)localObject).lineTo(21.77F, 7.172667F);
      ((Path)localObject).lineTo(16.73F, 7.172667F);
      ((Path)localObject).lineTo(16.73F, 7.687167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.3545F, 10.091667F);
      ((Path)localObject).lineTo(16.320499F, 10.291166F);
      ((Path)localObject).cubicTo(16.079F, 11.120667F, 15.743F, 11.834666F, 15.3125F, 12.443666F);
      ((Path)localObject).lineTo(14.4515F, 11.908167F);
      ((Path)localObject).cubicTo(14.8715F, 11.341166F, 15.1655F, 10.742666F, 15.3545F, 10.091667F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.719999F, 12.580167F);
      ((Path)localObject).lineTo(18.158001F, 12.580167F);
      ((Path)localObject).cubicTo(17.349501F, 12.580167F, 16.9505F, 12.212667F, 16.9505F, 11.498667F);
      ((Path)localObject).lineTo(16.9505F, 10.154667F);
      ((Path)localObject).lineTo(17.9585F, 10.154667F);
      ((Path)localObject).lineTo(17.9585F, 11.288667F);
      ((Path)localObject).cubicTo(17.9585F, 11.551167F, 18.115999F, 11.687667F, 18.4415F, 11.687667F);
      ((Path)localObject).lineTo(20.531F, 11.687667F);
      ((Path)localObject).cubicTo(20.719999F, 11.687667F, 20.856501F, 11.645667F, 20.93F, 11.572166F);
      ((Path)localObject).cubicTo(21.035F, 11.477667F, 21.1085F, 11.204667F, 21.150499F, 10.742666F);
      ((Path)localObject).lineTo(22.095501F, 11.047167F);
      ((Path)localObject).cubicTo(22.011499F, 11.782166F, 21.8645F, 12.233666F, 21.633499F, 12.380667F);
      ((Path)localObject).cubicTo(21.434F, 12.506667F, 21.129499F, 12.580167F, 20.719999F, 12.580167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.502001F, 9.724167F);
      ((Path)localObject).cubicTo(19.922001F, 10.144167F, 20.237F, 10.511666F, 20.4575F, 10.837167F);
      ((Path)localObject).lineTo(19.628F, 11.414667F);
      ((Path)localObject).cubicTo(19.386499F, 11.068167F, 19.061001F, 10.679667F, 18.651501F, 10.259666F);
      ((Path)localObject).lineTo(19.502001F, 9.724167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.778F, 9.944667F);
      ((Path)localObject).cubicTo(23.355499F, 10.627167F, 23.796499F, 11.225667F, 24.101F, 11.729667F);
      ((Path)localObject).lineTo(23.2715F, 12.307167F);
      ((Path)localObject).cubicTo(22.945999F, 11.740167F, 22.515499F, 11.120667F, 21.9695F, 10.448667F);
      ((Path)localObject).lineTo(22.778F, 9.944667F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ev
 * JD-Core Version:    0.7.0.1
 */