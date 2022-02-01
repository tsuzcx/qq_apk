package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
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
  
  protected final Drawable getDefaultImageDrawable()
  {
    AppMethodBeat.i(135459);
    Drawable localDrawable = b.l(getContext(), 2131230946);
    AppMethodBeat.o(135459);
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton
 * JD-Core Version:    0.7.0.1
 */