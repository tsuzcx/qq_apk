package com.facebook.internal;

import android.content.Context;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WebDialog$3
  extends WebView
{
  WebDialog$3(WebDialog paramWebDialog, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(7681);
    try
    {
      super.onWindowFocusChanged(paramBoolean);
      AppMethodBeat.o(7681);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(7681);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.WebDialog.3
 * JD-Core Version:    0.7.0.1
 */