package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/AppBrandActionBarCustomImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandActionBarCustomImageView
  extends ImageView
{
  public AppBrandActionBarCustomImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135613);
    if (paramMotionEvent != null) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(135613);
      return bool;
      setAlpha(0.5F);
      continue;
      setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView
 * JD-Core Version:    0.7.0.1
 */