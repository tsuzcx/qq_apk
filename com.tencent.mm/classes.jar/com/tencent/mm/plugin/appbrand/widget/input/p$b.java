package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;

final class p$b
  extends f
{
  private final int jmo;
  private final f.a jmp;
  
  p$b(p paramp, int paramInt, f.a parama)
  {
    super(paramInt, parama);
    this.jmo = paramInt;
    this.jmp = parama;
  }
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(123695);
    if (a(paramSpanned.subSequence(0, paramInt3).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), this.jmp) + a(paramCharSequence.subSequence(paramInt1, paramInt2).toString(), this.jmp) > this.jmo) {
      i = 1;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (i != 0) {
      localCharSequence = paramCharSequence.subSequence(paramInt1, Math.max(paramInt1, Math.min(this.jmo - (paramSpanned.length() - (paramInt4 - paramInt3)), paramInt2)));
    }
    if ((i != 0) && (bo.aa(localCharSequence))) {
      if (this.jmq.AyE != null) {
        break label207;
      }
    }
    label207:
    for (paramCharSequence = null;; paramCharSequence = (EditText)this.jmq.AyE.get())
    {
      paramSpanned = this.jmq.AyI;
      if ((paramCharSequence != null) && (paramSpanned != null)) {
        paramCharSequence.post(new p.b.1(this, paramSpanned));
      }
      AppMethodBeat.o(123695);
      return localCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.p.b
 * JD-Core Version:    0.7.0.1
 */