package androidx.appcompat.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class a
  implements TransformationMethod
{
  private Locale jK;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(238895);
    this.jK = paramContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(238895);
  }
  
  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    AppMethodBeat.i(238896);
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString().toUpperCase(this.jK);
      AppMethodBeat.o(238896);
      return paramCharSequence;
    }
    AppMethodBeat.o(238896);
    return null;
  }
  
  public final void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.c.a
 * JD-Core Version:    0.7.0.1
 */