package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;

final class o$b
  extends f
{
  private final int hui;
  private final f.a huj;
  
  o$b(o paramo, int paramInt, f.a parama)
  {
    super(paramInt, parama);
    this.hui = paramInt;
    this.huj = parama;
  }
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int i = 0;
    if (a(paramSpanned.subSequence(0, paramInt3).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), this.huj) + a(paramCharSequence.subSequence(paramInt1, paramInt2).toString(), this.huj) > this.hui) {
      i = 1;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (i != 0) {
      localCharSequence = paramCharSequence.subSequence(paramInt1, Math.max(paramInt1, Math.min(this.hui - (paramSpanned.length() - (paramInt4 - paramInt3)), paramInt2)));
    }
    if ((i != 0) && (bk.L(localCharSequence))) {
      if (this.huk.wfN != null) {
        break label197;
      }
    }
    label197:
    for (paramCharSequence = null;; paramCharSequence = (EditText)this.huk.wfN.get())
    {
      paramSpanned = this.huk.wfR;
      if ((paramCharSequence != null) && (paramSpanned != null)) {
        paramCharSequence.post(new o.b.1(this, paramSpanned));
      }
      return localCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.o.b
 * JD-Core Version:    0.7.0.1
 */