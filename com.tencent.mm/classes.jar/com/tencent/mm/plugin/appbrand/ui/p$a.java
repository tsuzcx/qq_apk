package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class p$a
  extends com.tencent.mm.plugin.appbrand.widget.a
{
  private Configuration abC;
  private final Resources cfU;
  private DisplayMetrics cfV;
  
  p$a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
  {
    super(paramResources);
    AppMethodBeat.i(48871);
    this.cfU = paramResources;
    this.cfV = paramDisplayMetrics;
    paramResources = new Configuration(this.cfU.getConfiguration());
    paramDisplayMetrics = new DisplayMetrics();
    paramDisplayMetrics.setTo(this.cfU.getDisplayMetrics());
    updateConfiguration(paramResources, paramDisplayMetrics);
    AppMethodBeat.o(48871);
  }
  
  private Drawable v(Drawable paramDrawable)
  {
    AppMethodBeat.i(48874);
    if (((paramDrawable instanceof BitmapDrawable)) && (this.cfV != null)) {
      ((BitmapDrawable)paramDrawable).setTargetDensity(this.cfV.densityDpi);
    }
    AppMethodBeat.o(48874);
    return paramDrawable;
  }
  
  public final Configuration getConfiguration()
  {
    AppMethodBeat.i(48873);
    if (this.abC != null)
    {
      localConfiguration = this.abC;
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
    paramInt = vi(paramInt);
    AppMethodBeat.o(48880);
    return paramInt;
  }
  
  public final int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(48879);
    paramInt = vj(paramInt);
    AppMethodBeat.o(48879);
    return paramInt;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(48872);
    if (this.cfV != null)
    {
      localDisplayMetrics = this.cfV;
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
    if (this.cfV != null)
    {
      localDrawable = getDrawableForDensity(paramInt, this.cfV.densityDpi);
      AppMethodBeat.o(48875);
      return localDrawable;
    }
    Drawable localDrawable = v(this.cfU.getDrawable(paramInt));
    AppMethodBeat.o(48875);
    return localDrawable;
  }
  
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(48876);
    try
    {
      if (this.cfV != null)
      {
        Drawable localDrawable = getDrawableForDensity(paramInt, this.cfV.densityDpi, paramTheme);
        AppMethodBeat.o(48876);
        return localDrawable;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", localNoSuchMethodError, "getDrawable(id, theme)", new Object[0]);
      if (paramTheme == null)
      {
        paramTheme = getDrawableForDensity(paramInt, this.cfV.densityDpi);
        AppMethodBeat.o(48876);
        return paramTheme;
      }
      paramTheme = v(this.cfU.getDrawable(paramInt, paramTheme));
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
      if (this.cfV != null) {
        i = this.cfV.densityDpi;
      }
    }
    Drawable localDrawable = this.cfU.getDrawableForDensity(paramInt1, i);
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
      if (this.cfV != null) {
        i = this.cfV.densityDpi;
      }
    }
    paramTheme = this.cfU.getDrawableForDensity(paramInt1, i, paramTheme);
    AppMethodBeat.o(48878);
    return paramTheme;
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(48881);
    if (this.cfV != null)
    {
      this.cfV = com.tencent.mm.cd.a.c(paramDisplayMetrics);
      this.abC = new Configuration(paramConfiguration);
      this.abC.densityDpi = this.cfV.densityDpi;
      super.updateConfiguration(this.abC, this.cfV);
      this.cfU.updateConfiguration(paramConfiguration, paramDisplayMetrics);
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