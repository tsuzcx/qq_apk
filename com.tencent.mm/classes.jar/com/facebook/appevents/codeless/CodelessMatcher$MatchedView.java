package com.facebook.appevents.codeless;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class CodelessMatcher$MatchedView
{
  private WeakReference<View> view;
  private String viewMapKey;
  
  public CodelessMatcher$MatchedView(View paramView, String paramString)
  {
    AppMethodBeat.i(72048);
    this.view = new WeakReference(paramView);
    this.viewMapKey = paramString;
    AppMethodBeat.o(72048);
  }
  
  public View getView()
  {
    AppMethodBeat.i(72049);
    if (this.view == null)
    {
      AppMethodBeat.o(72049);
      return null;
    }
    View localView = (View)this.view.get();
    AppMethodBeat.o(72049);
    return localView;
  }
  
  public String getViewMapKey()
  {
    return this.viewMapKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.codeless.CodelessMatcher.MatchedView
 * JD-Core Version:    0.7.0.1
 */