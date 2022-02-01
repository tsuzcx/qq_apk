package com.tencent.mm.emoji.a;

import android.graphics.Paint.FontMetricsInt;
import android.graphics.PointF;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "", "getItemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "itemView", "Landroid/view/View;", "getParentView", "getViewByMsgId", "msgId", "", "Companion", "plugin-emojisdk_release"})
public abstract interface a
{
  public static final a gUT = a.gUU;
  
  public abstract MMNeat7extView ck(View paramView);
  
  public abstract View zh(long paramLong);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/ChattingViewProvider$Companion;", "", "()V", "getEmojiCenter", "Landroid/graphics/PointF;", "textView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-emojisdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(199869);
      gUU = new a();
      AppMethodBeat.o(199869);
    }
    
    public static PointF a(MMNeat7extView paramMMNeat7extView)
    {
      AppMethodBeat.i(199868);
      p.h(paramMMNeat7extView, "textView");
      Object localObject = paramMMNeat7extView.getLayout();
      if (localObject != null)
      {
        float f1 = ((com.tencent.neattextview.textview.layout.a)localObject).getLineRight(0);
        float f2 = ((com.tencent.neattextview.textview.layout.a)localObject).getLineWidth(0);
        int i = ((com.tencent.neattextview.textview.layout.a)localObject).getLineBaseline(0);
        f2 /= 2.0F;
        float f3 = paramMMNeat7extView.getPaddingStart();
        localObject = paramMMNeat7extView.getPaint();
        p.g(localObject, "textView.paint");
        localObject = ((TextPaint)localObject).getFontMetricsInt();
        int j = ((Paint.FontMetricsInt)localObject).descent;
        float f4 = (((Paint.FontMetricsInt)localObject).ascent + j) / 2.0F;
        float f5 = i;
        paramMMNeat7extView = new PointF(f1 - f2 + f3, paramMMNeat7extView.getPaddingTop() + (f5 + f4));
        AppMethodBeat.o(199868);
        return paramMMNeat7extView;
      }
      paramMMNeat7extView = new PointF(0.0F, 0.0F);
      AppMethodBeat.o(199868);
      return paramMMNeat7extView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */