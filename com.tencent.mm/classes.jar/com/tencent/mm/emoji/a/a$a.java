package com.tencent.mm.emoji.a;

import android.graphics.RectF;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/ChattingViewProvider$Companion;", "", "()V", "getEmojiCenter", "Landroid/graphics/PointF;", "textView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getEmojiRect", "Landroid/graphics/RectF;", "plugin-emojisdk_release"})
public final class a$a
{
  static
  {
    AppMethodBeat.i(225554);
    jFK = new a();
    AppMethodBeat.o(225554);
  }
  
  public static RectF a(MMNeat7extView paramMMNeat7extView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(225552);
    p.k(paramMMNeat7extView, "textView");
    a locala = paramMMNeat7extView.getLayout();
    Object localObject2 = paramMMNeat7extView.ikC();
    paramMMNeat7extView = (MMNeat7extView)localObject2;
    if (!(localObject2 instanceof Spannable)) {
      paramMMNeat7extView = null;
    }
    paramMMNeat7extView = (Spannable)paramMMNeat7extView;
    if ((locala != null) && (paramMMNeat7extView != null))
    {
      paramMMNeat7extView = paramMMNeat7extView.getSpans(0, paramMMNeat7extView.length(), e.class);
      p.j(paramMMNeat7extView, "ss.getSpans(0, ss.length, EmojiSpan::class.java)");
      localObject2 = (e[])paramMMNeat7extView;
      int j = localObject2.length;
      int i = 0;
      for (;;)
      {
        paramMMNeat7extView = localObject1;
        if (i < j)
        {
          paramMMNeat7extView = localObject2[i];
          if (!paramMMNeat7extView.UYu) {}
        }
        else
        {
          if (paramMMNeat7extView == null) {
            break;
          }
          paramMMNeat7extView = paramMMNeat7extView.HXh;
          AppMethodBeat.o(225552);
          return paramMMNeat7extView;
        }
        i += 1;
      }
    }
    paramMMNeat7extView = new RectF();
    AppMethodBeat.o(225552);
    return paramMMNeat7extView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */