package com.tencent.mm.plugin.finder.post;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/post/PostEditUIC$initDescText$1", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
  implements InputFilter
{
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(349529);
    if (paramCharSequence != null)
    {
      paramSpanned = paramCharSequence.toString();
      if (n.a((CharSequence)paramSpanned, (CharSequence)"\n", false))
      {
        paramCharSequence = (CharSequence)n.m(paramSpanned, "\n", "", false);
        AppMethodBeat.o(349529);
        return paramCharSequence;
      }
    }
    AppMethodBeat.o(349529);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.b.a
 * JD-Core Version:    0.7.0.1
 */