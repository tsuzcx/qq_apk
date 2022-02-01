package com.tencent.mm.emoji.a;

import android.graphics.RectF;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.smiley.k;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/ChattingViewProvider$Companion;", "", "()V", "getEmojiCenter", "Landroid/graphics/PointF;", "textView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getEmojiRect", "Landroid/graphics/RectF;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  static
  {
    AppMethodBeat.i(242330);
    mfx = new a();
    AppMethodBeat.o(242330);
  }
  
  public static RectF a(MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(242321);
    s.u(paramMMNeat7extView, "textView");
    Object localObject = paramMMNeat7extView.getLayout();
    paramMMNeat7extView = paramMMNeat7extView.jPy();
    int i;
    if ((paramMMNeat7extView instanceof Spannable))
    {
      paramMMNeat7extView = (Spannable)paramMMNeat7extView;
      if ((localObject == null) || (paramMMNeat7extView == null)) {
        break label122;
      }
      paramMMNeat7extView = paramMMNeat7extView.getSpans(0, paramMMNeat7extView.length(), k.class);
      s.s(paramMMNeat7extView, "ss.getSpans(0, ss.length, EmojiSpan::class.java)");
      localObject = (k[])paramMMNeat7extView;
      int j = localObject.length;
      i = 0;
      label73:
      if (i >= j) {
        break label117;
      }
      paramMMNeat7extView = localObject[i];
      if (!paramMMNeat7extView.acyj) {
        break label110;
      }
    }
    for (;;)
    {
      if (paramMMNeat7extView == null) {
        break label122;
      }
      paramMMNeat7extView = paramMMNeat7extView.NTS;
      AppMethodBeat.o(242321);
      return paramMMNeat7extView;
      paramMMNeat7extView = null;
      break;
      label110:
      i += 1;
      break label73;
      label117:
      paramMMNeat7extView = null;
    }
    label122:
    paramMMNeat7extView = new RectF();
    AppMethodBeat.o(242321);
    return paramMMNeat7extView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */