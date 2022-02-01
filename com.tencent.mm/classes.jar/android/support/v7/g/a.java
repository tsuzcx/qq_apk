package android.support.v7.g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public final class a
  implements TransformationMethod
{
  private Locale Qs;
  
  public a(Context paramContext)
  {
    this.Qs = paramContext.getResources().getConfiguration().locale;
  }
  
  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (paramCharSequence != null) {
      return paramCharSequence.toString().toUpperCase(this.Qs);
    }
    return null;
  }
  
  public final void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.g.a
 * JD-Core Version:    0.7.0.1
 */