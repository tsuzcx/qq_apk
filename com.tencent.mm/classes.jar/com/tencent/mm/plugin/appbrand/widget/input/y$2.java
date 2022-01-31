package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.TextUtils;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class y$2
  extends InputConnectionWrapper
{
  y$2(y paramy, InputConnection paramInputConnection1, InputConnection paramInputConnection2)
  {
    super(paramInputConnection1, false);
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(123818);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.jnJ.jnI = paramCharSequence.charAt(paramCharSequence.length() - 1);
    }
    boolean bool = super.commitText(paramCharSequence, paramInt);
    AppMethodBeat.o(123818);
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123819);
    this.jnJ.jnI = '\b';
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    AppMethodBeat.o(123819);
    return bool;
  }
  
  public final boolean finishComposingText()
  {
    AppMethodBeat.i(123820);
    if ((this.jnK instanceof BaseInputConnection)) {}
    for (Object localObject = ((BaseInputConnection)this.jnK).getEditable();; localObject = this.jnJ.getEditableText())
    {
      boolean bool1 = aj.B((CharSequence)localObject);
      boolean bool2 = super.finishComposingText();
      if ((bool2) && (y.b(this.jnJ) == this) && (bool1))
      {
        localObject = y.c(this.jnJ);
        ((z)localObject).iMP.removeCallbacks(((z)localObject).jnT);
        if (((z)localObject).jnR) {
          ((z)localObject).jnT.run();
        }
      }
      AppMethodBeat.o(123820);
      return bool2;
    }
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(123817);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.jnJ.jnI = paramCharSequence.charAt(paramCharSequence.length() - 1);
    }
    boolean bool = super.setComposingText(paramCharSequence, paramInt);
    AppMethodBeat.o(123817);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y.2
 * JD-Core Version:    0.7.0.1
 */