package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.w;

public final class m
  extends ContextThemeWrapper
{
  private Resources iPA;
  private LayoutInflater iPB;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(133168);
    super.attachBaseContext(paramContext);
    if ((a.dqW()) && (!a.dqX()))
    {
      DisplayMetrics localDisplayMetrics = a.d(paramContext.getResources().getDisplayMetrics());
      this.iPA = new m.a(paramContext.getResources(), localDisplayMetrics);
      if (Build.VERSION.SDK_INT >= 21) {
        getTheme().getResources().getDisplayMetrics().setTo(this.iPA.getDisplayMetrics());
      }
    }
    AppMethodBeat.o(133168);
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(133169);
    if ((getAssets() != null) && (this.iPA != null))
    {
      localResources = this.iPA;
      AppMethodBeat.o(133169);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(133169);
    return localResources;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(138149);
    if ("layout_inflater".equals(paramString))
    {
      if (this.iPB != null)
      {
        paramString = this.iPB;
        AppMethodBeat.o(138149);
        return paramString;
      }
      paramString = w.b((LayoutInflater)super.getSystemService("layout_inflater"));
      this.iPB = paramString;
      AppMethodBeat.o(138149);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(138149);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */