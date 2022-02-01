package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class q$a
  extends com.tencent.mm.plugin.appbrand.widget.a
{
  private Configuration adt;
  private final Resources cqk;
  private DisplayMetrics cql;
  
  q$a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
  {
    super(paramResources);
    AppMethodBeat.i(48871);
    this.cqk = paramResources;
    this.cql = paramDisplayMetrics;
    paramResources = new Configuration(this.cqk.getConfiguration());
    paramDisplayMetrics = new DisplayMetrics();
    paramDisplayMetrics.setTo(this.cqk.getDisplayMetrics());
    updateConfiguration(paramResources, paramDisplayMetrics);
    AppMethodBeat.o(48871);
  }
  
  private Drawable v(Drawable paramDrawable)
  {
    AppMethodBeat.i(48874);
    if (((paramDrawable instanceof BitmapDrawable)) && (this.cql != null)) {
      ((BitmapDrawable)paramDrawable).setTargetDensity(this.cql.densityDpi);
    }
    AppMethodBeat.o(48874);
    return paramDrawable;
  }
  
  public final Configuration getConfiguration()
  {
    AppMethodBeat.i(48873);
    if (this.adt != null)
    {
      localConfiguration = this.adt;
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
    paramInt = vO(paramInt);
    AppMethodBeat.o(48880);
    return paramInt;
  }
  
  public final int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(48879);
    paramInt = vP(paramInt);
    AppMethodBeat.o(48879);
    return paramInt;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(48872);
    if (this.cql != null)
    {
      localDisplayMetrics = this.cql;
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
    if (this.cql != null)
    {
      localDrawable = getDrawableForDensity(paramInt, this.cql.densityDpi);
      AppMethodBeat.o(48875);
      return localDrawable;
    }
    Drawable localDrawable = v(this.cqk.getDrawable(paramInt));
    AppMethodBeat.o(48875);
    return localDrawable;
  }
  
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(48876);
    try
    {
      if (this.cql != null)
      {
        Drawable localDrawable = getDrawableForDensity(paramInt, this.cql.densityDpi, paramTheme);
        AppMethodBeat.o(48876);
        return localDrawable;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", localNoSuchMethodError, "getDrawable(id, theme)", new Object[0]);
      if (paramTheme == null)
      {
        paramTheme = getDrawableForDensity(paramInt, this.cql.densityDpi);
        AppMethodBeat.o(48876);
        return paramTheme;
      }
      paramTheme = v(this.cqk.getDrawable(paramInt, paramTheme));
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
      if (this.cql != null) {
        i = this.cql.densityDpi;
      }
    }
    Drawable localDrawable = this.cqk.getDrawableForDensity(paramInt1, i);
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
      if (this.cql != null) {
        i = this.cql.densityDpi;
      }
    }
    paramTheme = this.cqk.getDrawableForDensity(paramInt1, i, paramTheme);
    AppMethodBeat.o(48878);
    return paramTheme;
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(48881);
    if (this.cql != null)
    {
      this.cql = com.tencent.mm.cd.a.c(paramDisplayMetrics);
      this.adt = new Configuration(paramConfiguration);
      this.adt.densityDpi = this.cql.densityDpi;
      super.updateConfiguration(this.adt, this.cql);
      this.cqk.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(48881);
      return;
    }
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    AppMethodBeat.o(48881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.q.a
 * JD-Core Version:    0.7.0.1
 */