package com.tencent.luggage.g;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends com.tencent.mm.plugin.appbrand.widget.a
{
  private Configuration aaH;
  private final Resources ciY;
  private DisplayMetrics ciZ;
  
  a$a(a parama, Resources paramResources, DisplayMetrics paramDisplayMetrics)
  {
    super(paramResources);
    AppMethodBeat.i(169463);
    this.ciY = paramResources;
    this.ciZ = paramDisplayMetrics;
    parama = new Configuration(this.ciY.getConfiguration());
    paramResources = new DisplayMetrics();
    paramResources.setTo(this.ciY.getDisplayMetrics());
    updateConfiguration(parama, paramResources);
    AppMethodBeat.o(169463);
  }
  
  private Drawable v(Drawable paramDrawable)
  {
    AppMethodBeat.i(169466);
    if (((paramDrawable instanceof BitmapDrawable)) && (this.ciZ != null)) {
      ((BitmapDrawable)paramDrawable).setTargetDensity(this.ciZ.densityDpi);
    }
    AppMethodBeat.o(169466);
    return paramDrawable;
  }
  
  public final Configuration getConfiguration()
  {
    AppMethodBeat.i(169465);
    if (this.aaH != null)
    {
      localConfiguration = this.aaH;
      AppMethodBeat.o(169465);
      return localConfiguration;
    }
    Configuration localConfiguration = super.getConfiguration();
    AppMethodBeat.o(169465);
    return localConfiguration;
  }
  
  public final int getDimensionPixelOffset(int paramInt)
  {
    AppMethodBeat.i(169471);
    paramInt = uq(paramInt);
    AppMethodBeat.o(169471);
    return paramInt;
  }
  
  public final int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(169472);
    paramInt = ur(paramInt);
    AppMethodBeat.o(169472);
    return paramInt;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(169464);
    if (this.ciZ != null)
    {
      localDisplayMetrics = this.ciZ;
      AppMethodBeat.o(169464);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = super.getDisplayMetrics();
    AppMethodBeat.o(169464);
    return localDisplayMetrics;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(169467);
    if (this.ciZ != null)
    {
      localDrawable = getDrawableForDensity(paramInt, this.ciZ.densityDpi);
      AppMethodBeat.o(169467);
      return localDrawable;
    }
    Drawable localDrawable = v(this.ciY.getDrawable(paramInt));
    AppMethodBeat.o(169467);
    return localDrawable;
  }
  
  @TargetApi(21)
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(169468);
    if (this.ciZ != null)
    {
      paramTheme = getDrawableForDensity(paramInt, this.ciZ.densityDpi, paramTheme);
      AppMethodBeat.o(169468);
      return paramTheme;
    }
    paramTheme = v(this.ciY.getDrawable(paramInt, paramTheme));
    AppMethodBeat.o(169468);
    return paramTheme;
  }
  
  @TargetApi(21)
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169469);
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      i = paramInt2;
      if (this.ciZ != null) {
        i = this.ciZ.densityDpi;
      }
    }
    Drawable localDrawable = this.ciY.getDrawableForDensity(paramInt1, i);
    AppMethodBeat.o(169469);
    return localDrawable;
  }
  
  @TargetApi(21)
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(169470);
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      i = paramInt2;
      if (this.ciZ != null) {
        i = this.ciZ.densityDpi;
      }
    }
    paramTheme = this.ciY.getDrawableForDensity(paramInt1, i, paramTheme);
    AppMethodBeat.o(169470);
    return paramTheme;
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(169473);
    if (this.ciZ != null)
    {
      this.ciZ = a.a(this.cja, paramDisplayMetrics, paramConfiguration);
      this.aaH = new Configuration(paramConfiguration);
      this.aaH.densityDpi = this.ciZ.densityDpi;
      super.updateConfiguration(this.aaH, this.ciZ);
      this.ciY.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(169473);
      return;
    }
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    AppMethodBeat.o(169473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.g.a.a
 * JD-Core Version:    0.7.0.1
 */