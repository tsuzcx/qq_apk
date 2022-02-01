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
import com.tencent.mm.ui.aa;

public final class w
  extends ContextThemeWrapper
{
  private Resources cDb;
  private LayoutInflater cDc;
  
  public w(Context paramContext)
  {
    AppMethodBeat.i(48882);
    super.attachBaseContext(paramContext);
    ep(paramContext);
    AppMethodBeat.o(48882);
  }
  
  public w(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(177764);
    ep(paramContext);
    AppMethodBeat.o(177764);
  }
  
  private void ep(Context paramContext)
  {
    AppMethodBeat.i(48884);
    DisplayMetrics localDisplayMetrics = a.b(paramContext.getResources().getDisplayMetrics());
    this.cDb = new w.a(paramContext.getResources(), localDisplayMetrics);
    if (Build.VERSION.SDK_INT >= 21) {
      getTheme().getResources().getDisplayMetrics().setTo(this.cDb.getDisplayMetrics());
    }
    AppMethodBeat.o(48884);
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(48886);
    if ((getAssets() != null) && (this.cDb != null))
    {
      localResources = this.cDb;
      AppMethodBeat.o(48886);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(48886);
    return localResources;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(48885);
    if ("layout_inflater".equals(paramString))
    {
      if (this.cDc != null)
      {
        paramString = this.cDc;
        AppMethodBeat.o(48885);
        return paramString;
      }
      paramString = aa.b((LayoutInflater)super.getSystemService("layout_inflater"));
      this.cDc = paramString;
      AppMethodBeat.o(48885);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(48885);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.w
 * JD-Core Version:    0.7.0.1
 */