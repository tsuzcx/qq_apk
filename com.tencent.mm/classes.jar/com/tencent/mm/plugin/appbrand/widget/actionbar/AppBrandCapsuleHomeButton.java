package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.a;
import com.tencent.luggage.wxa.a.c;
import com.tencent.luggage.wxa.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandCapsuleHomeButton
  extends AppBrandOptionButton
{
  public AppBrandCapsuleHomeButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandCapsuleHomeButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final String getDefaultAccessibilityLabel()
  {
    AppMethodBeat.i(324159);
    String str = getContext().getString(a.g.app_brand_accessibility_close_button);
    AppMethodBeat.o(324159);
    return str;
  }
  
  protected final Drawable getDefaultImageDrawable()
  {
    AppMethodBeat.i(135459);
    Drawable localDrawable = a.m(getContext(), a.c.app_brand_actionbar_capsule_home_dark);
    AppMethodBeat.o(135459);
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton
 * JD-Core Version:    0.7.0.1
 */