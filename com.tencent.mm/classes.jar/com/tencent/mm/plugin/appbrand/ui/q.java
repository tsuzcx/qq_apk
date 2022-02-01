package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.z;

public final class q
  extends ContextThemeWrapper
{
  private Resources cqg;
  private LayoutInflater cqh;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(48882);
    super.attachBaseContext(paramContext);
    dO(paramContext);
    AppMethodBeat.o(48882);
  }
  
  public q(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(177764);
    dO(paramContext);
    AppMethodBeat.o(177764);
  }
  
  private void dO(Context paramContext)
  {
    AppMethodBeat.i(48884);
    DisplayMetrics localDisplayMetrics = a.c(paramContext.getResources().getDisplayMetrics());
    this.cqg = new q.a(paramContext.getResources(), localDisplayMetrics);
    if (Build.VERSION.SDK_INT >= 21) {
      getTheme().getResources().getDisplayMetrics().setTo(this.cqg.getDisplayMetrics());
    }
    AppMethodBeat.o(48884);
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(48886);
    if ((getAssets() != null) && (this.cqg != null))
    {
      localResources = this.cqg;
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
      if (this.cqh != null)
      {
        paramString = this.cqh;
        AppMethodBeat.o(48885);
        return paramString;
      }
      paramString = z.b((LayoutInflater)super.getSystemService("layout_inflater"));
      this.cqh = paramString;
      AppMethodBeat.o(48885);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(48885);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.q
 * JD-Core Version:    0.7.0.1
 */