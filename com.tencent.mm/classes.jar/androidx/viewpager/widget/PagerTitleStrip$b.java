package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

final class PagerTitleStrip$b
  extends SingleLineTransformationMethod
{
  private Locale kG;
  
  PagerTitleStrip$b(Context paramContext)
  {
    AppMethodBeat.i(193296);
    this.kG = paramContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(193296);
  }
  
  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    AppMethodBeat.i(193305);
    paramCharSequence = super.getTransformation(paramCharSequence, paramView);
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString().toUpperCase(this.kG);
      AppMethodBeat.o(193305);
      return paramCharSequence;
    }
    AppMethodBeat.o(193305);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip.b
 * JD-Core Version:    0.7.0.1
 */