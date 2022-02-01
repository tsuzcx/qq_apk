package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaViewLayoutFactory
  implements LayoutInflater.Factory
{
  private static YogaViewLayoutFactory sYogaViewLayoutFactory;
  
  public static YogaViewLayoutFactory getInstance()
  {
    AppMethodBeat.i(18259);
    if (sYogaViewLayoutFactory == null) {
      sYogaViewLayoutFactory = new YogaViewLayoutFactory();
    }
    YogaViewLayoutFactory localYogaViewLayoutFactory = sYogaViewLayoutFactory;
    AppMethodBeat.o(18259);
    return localYogaViewLayoutFactory;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(18260);
    if (YogaLayout.class.getSimpleName().equals(paramString))
    {
      paramString = new YogaLayout(paramContext, paramAttributeSet);
      AppMethodBeat.o(18260);
      return paramString;
    }
    if (VirtualYogaLayout.class.getSimpleName().equals(paramString))
    {
      paramString = new VirtualYogaLayout(paramContext, paramAttributeSet);
      AppMethodBeat.o(18260);
      return paramString;
    }
    AppMethodBeat.o(18260);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.facebook.yoga.android.YogaViewLayoutFactory
 * JD-Core Version:    0.7.0.1
 */