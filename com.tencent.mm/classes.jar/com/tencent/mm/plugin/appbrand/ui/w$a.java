package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class w$a
  extends com.tencent.mm.plugin.appbrand.widget.a
{
  private Configuration adG;
  private final Resources cDf;
  private DisplayMetrics cDg;
  
  w$a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
  {
    super(paramResources);
    AppMethodBeat.i(48871);
    this.cDf = paramResources;
    this.cDg = paramDisplayMetrics;
    paramResources = new Configuration(this.cDf.getConfiguration());
    paramDisplayMetrics = new DisplayMetrics();
    paramDisplayMetrics.setTo(this.cDf.getDisplayMetrics());
    updateConfiguration(paramResources, paramDisplayMetrics);
    AppMethodBeat.o(48871);
  }
  
  private Drawable v(Drawable paramDrawable)
  {
    AppMethodBeat.i(48874);
    if (((paramDrawable instanceof BitmapDrawable)) && (this.cDg != null)) {
      ((BitmapDrawable)paramDrawable).setTargetDensity(this.cDg.densityDpi);
    }
    AppMethodBeat.o(48874);
    return paramDrawable;
  }
  
  public final Configuration getConfiguration()
  {
    AppMethodBeat.i(48873);
    if (this.adG != null)
    {
      localConfiguration = this.adG;
      AppMethodBeat.o(48873);
      return localConfiguration;
    }
    Configuration localConfiguration = super.getConfiguration();
    AppMethodBeat.o(48873);
    return localConfiguration;
  }
  
  public final int getDimensionPixelOffset(int paramInt)
  {
    AppMethodBeat.i(48880);
    paramInt = zI(paramInt);
    AppMethodBeat.o(48880);
    return paramInt;
  }
  
  public final int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(48879);
    paramInt = zJ(paramInt);
    AppMethodBeat.o(48879);
    return paramInt;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(48872);
    if (this.cDg != null)
    {
      localDisplayMetrics = this.cDg;
      AppMethodBeat.o(48872);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = super.getDisplayMetrics();
    AppMethodBeat.o(48872);
    return localDisplayMetrics;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(48875);
    if (this.cDg != null)
    {
      localDrawable = getDrawableForDensity(paramInt, this.cDg.densityDpi);
      AppMethodBeat.o(48875);
      return localDrawable;
    }
    Drawable localDrawable = v(this.cDf.getDrawable(paramInt));
    AppMethodBeat.o(48875);
    return localDrawable;
  }
  
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(48876);
    try
    {
      if (this.cDg != null)
      {
        Drawable localDrawable = getDrawableForDensity(paramInt, this.cDg.densityDpi, paramTheme);
        AppMethodBeat.o(48876);
        return localDrawable;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", localNoSuchMethodError, "getDrawable(id, theme)", new Object[0]);
      if (paramTheme == null)
      {
        paramTheme = getDrawableForDensity(paramInt, this.cDg.densityDpi);
        AppMethodBeat.o(48876);
        return paramTheme;
      }
      paramTheme = v(this.cDf.getDrawable(paramInt, paramTheme));
      AppMethodBeat.o(48876);
    }
    return paramTheme;
  }
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48877);
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      i = paramInt2;
      if (this.cDg != null) {
        i = this.cDg.densityDpi;
      }
    }
    Drawable localDrawable = this.cDf.getDrawableForDensity(paramInt1, i);
    AppMethodBeat.o(48877);
    return localDrawable;
  }
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(48878);
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      i = paramInt2;
      if (this.cDg != null) {
        i = this.cDg.densityDpi;
      }
    }
    paramTheme = this.cDf.getDrawableForDensity(paramInt1, i, paramTheme);
    AppMethodBeat.o(48878);
    return paramTheme;
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(48881);
    if (this.cDg != null)
    {
      this.cDg = com.tencent.mm.cc.a.b(paramDisplayMetrics);
      this.adG = new Configuration(paramConfiguration);
      this.adG.densityDpi = this.cDg.densityDpi;
      super.updateConfiguration(this.adG, this.cDg);
      this.cDf.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(48881);
      return;
    }
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    AppMethodBeat.o(48881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.w.a
 * JD-Core Version:    0.7.0.1
 */