package com.tencent.mm.live.b;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import kotlin.Metadata;
import kotlin.k.k;

@Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o$c
  extends g
{
  o$c(g.a parama)
  {
    super(120, parama);
  }
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(247052);
    Object localObject;
    if (paramSpanned == null)
    {
      paramInt2 = 0;
      if (paramInt2 <= paramInt3) {
        break label189;
      }
      if (paramSpanned != null) {
        break label174;
      }
      localObject = null;
      label26:
      paramInt2 = g.a(String.valueOf(localObject), g.a.afII);
      label38:
      if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
        break label204;
      }
    }
    label174:
    label189:
    label204:
    for (paramInt3 = g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.afII);; paramInt3 = 0)
    {
      paramInt4 = g.a(String.valueOf(paramCharSequence), g.a.afII);
      int i = g.bCA(String.valueOf(paramCharSequence));
      if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
        break label228;
      }
      paramInt2 = k.qu(120 - paramInt2 - paramInt3 - i, 0);
      if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
        break label210;
      }
      paramCharSequence = (CharSequence)"";
      AppMethodBeat.o(247052);
      return paramCharSequence;
      paramInt2 = paramSpanned.length();
      break;
      localObject = paramSpanned.subSequence(0, paramInt3);
      break label26;
      paramInt2 = g.a(String.valueOf(paramSpanned), g.a.afII);
      break label38;
    }
    label210:
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
    AppMethodBeat.o(247052);
    return paramCharSequence;
    label228:
    if (paramCharSequence == null)
    {
      paramCharSequence = (CharSequence)"";
      AppMethodBeat.o(247052);
      return paramCharSequence;
    }
    AppMethodBeat.o(247052);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.b.o.c
 * JD-Core Version:    0.7.0.1
 */