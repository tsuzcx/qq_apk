package androidx.core.g.c;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  
  public static void a(EditorInfo paramEditorInfo, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195782);
    if (Build.VERSION.SDK_INT >= 30)
    {
      paramEditorInfo.setInitialSurroundingSubText(paramCharSequence, 0);
      AppMethodBeat.o(195782);
      return;
    }
    f.checkNotNull(paramCharSequence);
    if (Build.VERSION.SDK_INT >= 30)
    {
      paramEditorInfo.setInitialSurroundingSubText(paramCharSequence, 0);
      AppMethodBeat.o(195782);
      return;
    }
    if (paramEditorInfo.initialSelStart > paramEditorInfo.initialSelEnd)
    {
      j = paramEditorInfo.initialSelEnd + 0;
      if (paramEditorInfo.initialSelStart <= paramEditorInfo.initialSelEnd) {
        break label127;
      }
    }
    int m;
    label127:
    for (int i = paramEditorInfo.initialSelStart + 0;; i = paramEditorInfo.initialSelEnd + 0)
    {
      m = paramCharSequence.length();
      if ((j >= 0) && (i <= m)) {
        break label137;
      }
      a(paramEditorInfo, null, 0, 0);
      AppMethodBeat.o(195782);
      return;
      j = paramEditorInfo.initialSelStart + 0;
      break;
    }
    label137:
    int k = paramEditorInfo.inputType & 0xFFF;
    if ((k == 129) || (k == 225) || (k == 18)) {}
    for (k = 1; k != 0; k = 0)
    {
      a(paramEditorInfo, null, 0, 0);
      AppMethodBeat.o(195782);
      return;
    }
    if (m <= 2048)
    {
      a(paramEditorInfo, paramCharSequence, j, i);
      AppMethodBeat.o(195782);
      return;
    }
    int i1 = i - j;
    int n;
    int i2;
    if (i1 > 1024)
    {
      k = 0;
      n = paramCharSequence.length();
      m = 2048 - k;
      n = Math.min(n - i, m - Math.min(j, (int)(0.8D * m)));
      i2 = Math.min(j, m - n);
      m = j - i2;
      if (!a(paramCharSequence, j - i2, 0)) {
        break label430;
      }
      m += 1;
    }
    label430:
    for (int j = i2 - 1;; j = i2)
    {
      if (a(paramCharSequence, i + n - 1, 1)) {
        n -= 1;
      }
      for (;;)
      {
        if (k != i1) {}
        for (paramCharSequence = TextUtils.concat(new CharSequence[] { paramCharSequence.subSequence(m, m + j), paramCharSequence.subSequence(i, n + i) });; paramCharSequence = paramCharSequence.subSequence(m, m + (j + k + n)))
        {
          i = j + 0;
          a(paramEditorInfo, paramCharSequence, i, k + i);
          AppMethodBeat.o(195782);
          return;
          k = i1;
          break;
        }
      }
    }
  }
  
  private static void a(EditorInfo paramEditorInfo, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195810);
    if (paramEditorInfo.extras == null) {
      paramEditorInfo.extras = new Bundle();
    }
    if (paramCharSequence != null) {}
    for (paramCharSequence = new SpannableStringBuilder(paramCharSequence);; paramCharSequence = null)
    {
      paramEditorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", paramCharSequence);
      paramEditorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", paramInt1);
      paramEditorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", paramInt2);
      AppMethodBeat.o(195810);
      return;
    }
  }
  
  private static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195796);
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(195796);
      return false;
    case 0: 
      bool = Character.isLowSurrogate(paramCharSequence.charAt(paramInt1));
      AppMethodBeat.o(195796);
      return bool;
    }
    boolean bool = Character.isHighSurrogate(paramCharSequence.charAt(paramInt1));
    AppMethodBeat.o(195796);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.c.a
 * JD-Core Version:    0.7.0.1
 */