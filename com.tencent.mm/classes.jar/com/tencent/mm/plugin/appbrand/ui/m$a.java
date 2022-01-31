package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class m$a
  extends com.tencent.mm.plugin.appbrand.widget.a
{
  private Configuration TE;
  private final Resources iPC;
  private DisplayMetrics iPD;
  
  m$a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
  {
    super(paramResources);
    AppMethodBeat.i(133164);
    this.iPC = paramResources;
    this.iPD = paramDisplayMetrics;
    paramResources = new Configuration(this.iPC.getConfiguration());
    paramDisplayMetrics = new DisplayMetrics();
    paramDisplayMetrics.setTo(this.iPC.getDisplayMetrics());
    updateConfiguration(paramResources, paramDisplayMetrics);
    AppMethodBeat.o(133164);
  }
  
  private Drawable q(Drawable paramDrawable)
  {
    AppMethodBeat.i(138144);
    if (((paramDrawable instanceof BitmapDrawable)) && (this.iPD != null)) {
      ((BitmapDrawable)paramDrawable).setTargetDensity(this.iPD.densityDpi);
    }
    AppMethodBeat.o(138144);
    return paramDrawable;
  }
  
  public final Configuration getConfiguration()
  {
    AppMethodBeat.i(133166);
    if (this.TE != null)
    {
      localConfiguration = this.TE;
      AppMethodBeat.o(133166);
      return localConfiguration;
    }
    Configuration localConfiguration = super.getConfiguration();
    AppMethodBeat.o(133166);
    return localConfiguration;
  }
  
  public final int getDimensionPixelOffset(int paramInt)
  {
    AppMethodBeat.i(143616);
    paramInt = pS(paramInt);
    AppMethodBeat.o(143616);
    return paramInt;
  }
  
  public final int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(143615);
    paramInt = pT(paramInt);
    AppMethodBeat.o(143615);
    return paramInt;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(133165);
    if (this.iPD != null)
    {
      localDisplayMetrics = this.iPD;
      AppMethodBeat.o(133165);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = super.getDisplayMetrics();
    AppMethodBeat.o(133165);
    return localDisplayMetrics;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(138145);
    if (this.iPD != null)
    {
      localDrawable = getDrawableForDensity(paramInt, this.iPD.densityDpi);
      AppMethodBeat.o(138145);
      return localDrawable;
    }
    Drawable localDrawable = q(this.iPC.getDrawable(paramInt));
    AppMethodBeat.o(138145);
    return localDrawable;
  }
  
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(138146);
    try
    {
      if (this.iPD != null)
      {
        Drawable localDrawable = getDrawableForDensity(paramInt, this.iPD.densityDpi, paramTheme);
        AppMethodBeat.o(138146);
        return localDrawable;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", localNoSuchMethodError, "getDrawable(id, theme)", new Object[0]);
      if (paramTheme == null)
      {
        paramTheme = getDrawableForDensity(paramInt, this.iPD.densityDpi);
        AppMethodBeat.o(138146);
        return paramTheme;
      }
      paramTheme = q(this.iPC.getDrawable(paramInt, paramTheme));
      AppMethodBeat.o(138146);
    }
    return paramTheme;
  }
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138147);
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      i = paramInt2;
      if (this.iPD != null) {
        i = this.iPD.densityDpi;
      }
    }
    Drawable localDrawable = this.iPC.getDrawableForDensity(paramInt1, i);
    AppMethodBeat.o(138147);
    return localDrawable;
  }
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(138148);
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      i = paramInt2;
      if (this.iPD != null) {
        i = this.iPD.densityDpi;
      }
    }
    paramTheme = this.iPC.getDrawableForDensity(paramInt1, i, paramTheme);
    AppMethodBeat.o(138148);
    return paramTheme;
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(133167);
    if (this.iPD != null)
    {
      this.iPD = com.tencent.mm.cc.a.d(paramDisplayMetrics);
      this.TE = new Configuration(paramConfiguration);
      this.TE.densityDpi = this.iPD.densityDpi;
      super.updateConfiguration(this.TE, this.iPD);
      this.iPC.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(133167);
      return;
    }
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    AppMethodBeat.o(133167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m.a
 * JD-Core Version:    0.7.0.1
 */