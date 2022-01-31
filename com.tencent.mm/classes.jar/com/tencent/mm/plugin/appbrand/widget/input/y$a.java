package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.AlignmentSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.Set;

final class y$a
  implements TextWatcher
{
  final Map<TextWatcher, Object> jnL;
  
  private y$a(y paramy)
  {
    AppMethodBeat.i(123823);
    this.jnL = new a();
    AppMethodBeat.o(123823);
  }
  
  private static <T> void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, Class<T> paramClass)
  {
    AppMethodBeat.i(123824);
    try
    {
      if ((paramCharSequence instanceof SpannableStringBuilder))
      {
        paramCharSequence = (SpannableStringBuilder)paramCharSequence;
        paramClass = paramCharSequence.getSpans(paramInt1, paramInt1 + paramInt2, paramClass);
        if ((paramClass != null) && (paramClass.length > 0))
        {
          paramInt2 = paramClass.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramCharSequence.removeSpan(paramClass[paramInt1]);
            paramInt1 += 1;
          }
        }
      }
      AppMethodBeat.o(123824);
      return;
    }
    catch (Throwable paramCharSequence)
    {
      AppMethodBeat.o(123824);
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(123827);
    f.aQD();
    Object localObject;
    int i;
    int j;
    if (f.aQE())
    {
      localObject = new PBool();
      PInt localPInt = new PInt();
      String str = y.a(paramEditable, (PBool)localObject, localPInt);
      i = localPInt.value;
      if ((((PBool)localObject).value) && (!bo.isNullOrNil(str)))
      {
        j = Selection.getSelectionEnd(paramEditable);
        boolean bool = y.d(this.jnJ);
        this.jnJ.post(new y.a.1(this, bool, str, j, i));
        AppMethodBeat.o(123827);
        return;
      }
    }
    if (!y.d(this.jnJ))
    {
      y.e(this.jnJ);
      if (!this.jnL.isEmpty())
      {
        localObject = (TextWatcher[])this.jnL.keySet().toArray(new TextWatcher[this.jnL.size()]);
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          localObject[i].afterTextChanged(paramEditable);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(123827);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(123825);
    if ((!y.d(this.jnJ)) && (!this.jnL.isEmpty()))
    {
      TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.jnL.keySet().toArray(new TextWatcher[this.jnL.size()]);
      int j = arrayOfTextWatcher.length;
      int i = 0;
      while (i < j)
      {
        arrayOfTextWatcher[i].beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        i += 1;
      }
    }
    AppMethodBeat.o(123825);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(123826);
    if (!y.d(this.jnJ))
    {
      a(paramCharSequence, paramInt1, paramInt3, StyleSpan.class);
      a(paramCharSequence, paramInt1, paramInt3, RelativeSizeSpan.class);
      a(paramCharSequence, paramInt1, paramInt3, AlignmentSpan.class);
      if (!this.jnL.isEmpty())
      {
        TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.jnL.keySet().toArray(new TextWatcher[this.jnL.size()]);
        int j = arrayOfTextWatcher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfTextWatcher[i].onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(123826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y.a
 * JD-Core Version:    0.7.0.1
 */