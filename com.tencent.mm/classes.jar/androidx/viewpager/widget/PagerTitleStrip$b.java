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
  private Locale jK;
  
  PagerTitleStrip$b(Context paramContext)
  {
    AppMethodBeat.i(235149);
    this.jK = paramContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(235149);
  }
  
  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    AppMethodBeat.i(235151);
    paramCharSequence = super.getTransformation(paramCharSequence, paramView);
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString().toUpperCase(this.jK);
      AppMethodBeat.o(235151);
      return paramCharSequence;
    }
    AppMethodBeat.o(235151);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip.b
 * JD-Core Version:    0.7.0.1
 */