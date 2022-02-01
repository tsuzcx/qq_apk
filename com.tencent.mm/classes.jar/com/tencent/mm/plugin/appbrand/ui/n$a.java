package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aa;

final class n$a
  extends ContextThemeWrapper
{
  private volatile LayoutInflater mInflater;
  
  public n$a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(177762);
    if ("layout_inflater".equals(paramString)) {
      try
      {
        if (this.mInflater == null)
        {
          this.mInflater = ((LayoutInflater)getApplicationContext().getSystemService(paramString)).cloneInContext(this);
          this.mInflater = aa.b(this.mInflater);
        }
        paramString = this.mInflater;
        return paramString;
      }
      finally
      {
        AppMethodBeat.o(177762);
      }
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(177762);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.n.a
 * JD-Core Version:    0.7.0.1
 */