package android.support.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

final class PagerTitleStrip$b
  extends SingleLineTransformationMethod
{
  private Locale OB;
  
  PagerTitleStrip$b(Context paramContext)
  {
    this.OB = paramContext.getResources().getConfiguration().locale;
  }
  
  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    paramCharSequence = super.getTransformation(paramCharSequence, paramView);
    if (paramCharSequence != null) {
      return paramCharSequence.toString().toUpperCase(this.OB);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip.b
 * JD-Core Version:    0.7.0.1
 */