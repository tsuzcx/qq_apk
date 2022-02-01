package com.tencent.mm.live.c;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import d.k.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-logic_release"})
public final class z$c
  extends f
{
  z$c(f.a parama)
  {
    super(120, parama);
  }
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190180);
    CharSequence localCharSequence;
    if (paramSpanned != null)
    {
      paramInt2 = paramSpanned.length();
      if (paramInt2 <= paramInt3) {
        break label189;
      }
      if (paramSpanned == null) {
        break label183;
      }
      localCharSequence = paramSpanned.subSequence(0, paramInt3);
      label41:
      paramInt2 = f.a(String.valueOf(localCharSequence), f.a.IRJ);
      label53:
      if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
        break label204;
      }
    }
    label183:
    label189:
    label204:
    for (paramInt3 = f.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), f.a.IRJ);; paramInt3 = 0)
    {
      paramInt4 = f.a(String.valueOf(paramCharSequence), f.a.IRJ);
      int i = f.aRn(String.valueOf(paramCharSequence));
      if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
        break label228;
      }
      paramInt2 = h.la(120 - paramInt2 - paramInt3 - i, 0);
      if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
        break label210;
      }
      paramCharSequence = (CharSequence)"";
      AppMethodBeat.o(190180);
      return paramCharSequence;
      paramInt2 = 0;
      break;
      localCharSequence = null;
      break label41;
      paramInt2 = f.a(String.valueOf(paramSpanned), f.a.IRJ);
      break label53;
    }
    label210:
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
    AppMethodBeat.o(190180);
    return paramCharSequence;
    label228:
    if (paramCharSequence == null) {
      paramCharSequence = (CharSequence)"";
    }
    for (;;)
    {
      AppMethodBeat.o(190180);
      return paramCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.z.c
 * JD-Core Version:    0.7.0.1
 */