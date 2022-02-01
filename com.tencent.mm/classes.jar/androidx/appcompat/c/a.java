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
  private Locale kG;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(199249);
    this.kG = paramContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(199249);
  }
  
  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    AppMethodBeat.i(199257);
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString().toUpperCase(this.kG);
      AppMethodBeat.o(199257);
      return paramCharSequence;
    }
    AppMethodBeat.o(199257);
    return null;
  }
  
  public final void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     androidx.appcompat.c.a
 * JD-Core Version:    0.7.0.1
 */