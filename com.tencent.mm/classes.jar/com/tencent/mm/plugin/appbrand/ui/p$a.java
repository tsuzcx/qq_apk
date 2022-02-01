package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class p$a
  extends com.tencent.mm.plugin.appbrand.widget.a
{
  private Configuration aaH;
  private final Resources ciY;
  private DisplayMetrics ciZ;
  
  p$a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
  {
    super(paramResources);
    AppMethodBeat.i(48871);
    this.ciY = paramResources;
    this.ciZ = paramDisplayMetrics;
    paramResources = new Configuration(this.ciY.getConfiguration());
    paramDisplayMetrics = new DisplayMetrics();
    paramDisplayMetrics.setTo(this.ciY.getDisplayMetrics());
    updateConfiguration(paramResources, paramDisplayMetrics);
    AppMethodBeat.o(48871);
  }
  
  private Drawable v(Drawable paramDrawable)
  {
    AppMethodBeat.i(48874);
    if (((paramDrawable instanceof BitmapDrawable)) && (this.ciZ != null)) {
      ((BitmapDrawable)paramDrawable).setTargetDensity(this.ciZ.densityDpi);
    }
    AppMethodBeat.o(48874);
    return paramDrawable;
  }
  
  public final Configuration getConfiguration()
  {
    AppMethodBeat.i(48873);
    if (this.aaH != null)
    {
      localConfiguration = this.aaH;
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
    paramInt = uq(paramInt);
    AppMethodBeat.o(48880);
    return paramInt;
  }
  
  public final int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(48879);
    paramInt = ur(paramInt);
    AppMethodBeat.o(48879);
    return paramInt;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(48872);
    if (this.ciZ != null)
    {
      localDisplayMetrics = this.ciZ;
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
    if (this.ciZ != null)
    {
      localDrawable = getDrawableForDensity(paramInt, this.ciZ.densityDpi);
      AppMethodBeat.o(48875);
      return localDrawable;
    }
    Drawable localDrawable = v(this.ciY.getDrawable(paramInt));
    AppMethodBeat.o(48875);
    return localDrawable;
  }
  
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(48876);
    try
    {
      if (this.ciZ != null)
      {
        Drawable localDrawable = getDrawableForDensity(paramInt, this.ciZ.densityDpi, paramTheme);
        AppMethodBeat.o(48876);
        return localDrawable;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", localNoSuchMethodError, "getDrawable(id, theme)", new Object[0]);
      if (paramTheme == null)
      {
        paramTheme = getDrawableForDensity(paramInt, this.ciZ.densityDpi);
        AppMethodBeat.o(48876);
        return paramTheme;
      }
      paramTheme = v(this.ciY.getDrawable(paramInt, paramTheme));
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
      if (this.ciZ != null) {
        i = this.ciZ.densityDpi;
      }
    }
    Drawable localDrawable = this.ciY.getDrawableForDensity(paramInt1, i);
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
      if (this.ciZ != null) {
        i = this.ciZ.densityDpi;
      }
    }
    paramTheme = this.ciY.getDrawableForDensity(paramInt1, i, paramTheme);
    AppMethodBeat.o(48878);
    return paramTheme;
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(48881);
    if (this.ciZ != null)
    {
      this.ciZ = com.tencent.mm.ce.a.c(paramDisplayMetrics);
      this.aaH = new Configuration(paramConfiguration);
      this.aaH.densityDpi = this.ciZ.densityDpi;
      super.updateConfiguration(this.aaH, this.ciZ);
      this.ciY.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(48881);
      return;
    }
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    AppMethodBeat.o(48881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p.a
 * JD-Core Version:    0.7.0.1
 */