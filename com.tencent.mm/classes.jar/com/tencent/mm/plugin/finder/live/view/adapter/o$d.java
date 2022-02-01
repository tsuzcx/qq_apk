package com.tencent.mm.plugin.finder.live.view.adapter;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter$setETInputFilter$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o$d
  extends g
{
  o$d(int paramInt, g.a parama)
  {
    super(paramInt, parama);
  }
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(359086);
    Object localObject;
    if (paramSpanned == null)
    {
      paramInt1 = 0;
      if (paramInt1 <= paramInt3) {
        break label159;
      }
      if (paramSpanned != null) {
        break label144;
      }
      localObject = null;
      label26:
      paramInt1 = g.a(String.valueOf(localObject), g.a.afII);
      label38:
      if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
        break label174;
      }
    }
    label144:
    label159:
    label174:
    for (paramInt2 = g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.afII);; paramInt2 = 0)
    {
      paramInt3 = g.a(String.valueOf(paramCharSequence), g.a.afII);
      paramInt1 = this.DKa - paramInt1 - paramInt2;
      if (paramInt3 <= paramInt1) {
        break label179;
      }
      paramSpanned = a.DJT;
      paramCharSequence = (CharSequence)a.u(String.valueOf(paramCharSequence), paramInt1, false);
      AppMethodBeat.o(359086);
      return paramCharSequence;
      paramInt1 = paramSpanned.length();
      break;
      localObject = paramSpanned.subSequence(0, paramInt3);
      break label26;
      paramInt1 = g.a(String.valueOf(paramSpanned), g.a.afII);
      break label38;
    }
    label179:
    if (paramCharSequence == null)
    {
      paramCharSequence = (CharSequence)"";
      AppMethodBeat.o(359086);
      return paramCharSequence;
    }
    AppMethodBeat.o(359086);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.o.d
 * JD-Core Version:    0.7.0.1
 */