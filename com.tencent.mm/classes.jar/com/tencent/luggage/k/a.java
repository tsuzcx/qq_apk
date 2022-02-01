package com.tencent.luggage.k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends ContextThemeWrapper
{
  private static final b ewO;
  private Resources ewM;
  private LayoutInflater ewN;
  private final b ewP;
  
  static
  {
    AppMethodBeat.i(169479);
    ewO = new b()
    {
      public final DisplayMetrics applyScreenAdaptiveDensity(DisplayMetrics paramAnonymousDisplayMetrics, Configuration paramAnonymousConfiguration)
      {
        AppMethodBeat.i(169462);
        paramAnonymousConfiguration = new DisplayMetrics();
        paramAnonymousConfiguration.setTo(paramAnonymousDisplayMetrics);
        AppMethodBeat.o(169462);
        return paramAnonymousConfiguration;
      }
    };
    AppMethodBeat.o(169479);
  }
  
  public a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(169474);
    super.attachBaseContext(paramContext);
    paramContext = paramb;
    if (paramb == null) {
      paramContext = ewO;
    }
    this.ewP = paramContext;
    AppMethodBeat.o(169474);
  }
  
  private DisplayMetrics applyScreenAdaptiveDensity(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    AppMethodBeat.i(169477);
    paramDisplayMetrics = this.ewP.applyScreenAdaptiveDensity(paramDisplayMetrics, paramConfiguration);
    AppMethodBeat.o(169477);
    return paramDisplayMetrics;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(169476);
    if (getAssets() != null)
    {
      if (this.ewM == null)
      {
        localResources = super.getResources();
        this.ewM = new a(localResources, applyScreenAdaptiveDensity(localResources.getDisplayMetrics(), localResources.getConfiguration()));
      }
      localResources = this.ewM;
      AppMethodBeat.o(169476);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(169476);
    return localResources;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(169475);
    if ("layout_inflater".equals(paramString))
    {
      if (this.ewN != null)
      {
        paramString = this.ewN;
        AppMethodBeat.o(169475);
        return paramString;
      }
      paramString = (LayoutInflater)super.getSystemService("layout_inflater");
      this.ewN = paramString;
      AppMethodBeat.o(169475);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(169475);
    return paramString;
  }
  
  final class a
    extends com.tencent.mm.plugin.appbrand.widget.a
  {
    private final Resources ewQ;
    private DisplayMetrics ewR;
    private Configuration kJ;
    
    a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
    {
      super();
      AppMethodBeat.i(169463);
      this.ewQ = paramResources;
      this.ewR = paramDisplayMetrics;
      this$1 = new Configuration(this.ewQ.getConfiguration());
      paramResources = new DisplayMetrics();
      paramResources.setTo(this.ewQ.getDisplayMetrics());
      updateConfiguration(a.this, paramResources);
      AppMethodBeat.o(169463);
    }
    
    private Drawable K(Drawable paramDrawable)
    {
      AppMethodBeat.i(169466);
      if (((paramDrawable instanceof BitmapDrawable)) && (this.ewR != null)) {
        ((BitmapDrawable)paramDrawable).setTargetDensity(this.ewR.densityDpi);
      }
      AppMethodBeat.o(169466);
      return paramDrawable;
    }
    
    public final Configuration getConfiguration()
    {
      AppMethodBeat.i(169465);
      if (this.kJ != null)
      {
        localConfiguration = this.kJ;
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
      paramInt = DQ(paramInt);
      AppMethodBeat.o(169471);
      return paramInt;
    }
    
    public final int getDimensionPixelSize(int paramInt)
    {
      AppMethodBeat.i(169472);
      paramInt = DR(paramInt);
      AppMethodBeat.o(169472);
      return paramInt;
    }
    
    public final DisplayMetrics getDisplayMetrics()
    {
      AppMethodBeat.i(169464);
      if (this.ewR != null)
      {
        localDisplayMetrics = this.ewR;
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
      if (this.ewR != null)
      {
        localDrawable = getDrawableForDensity(paramInt, this.ewR.densityDpi);
        AppMethodBeat.o(169467);
        return localDrawable;
      }
      Drawable localDrawable = K(this.ewQ.getDrawable(paramInt));
      AppMethodBeat.o(169467);
      return localDrawable;
    }
    
    public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(169468);
      if (this.ewR != null)
      {
        paramTheme = getDrawableForDensity(paramInt, this.ewR.densityDpi, paramTheme);
        AppMethodBeat.o(169468);
        return paramTheme;
      }
      paramTheme = K(this.ewQ.getDrawable(paramInt, paramTheme));
      AppMethodBeat.o(169468);
      return paramTheme;
    }
    
    public final Drawable getDrawableForDensity(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(169469);
      int i = paramInt2;
      if (paramInt2 == 0)
      {
        i = paramInt2;
        if (this.ewR != null) {
          i = this.ewR.densityDpi;
        }
      }
      Drawable localDrawable = this.ewQ.getDrawableForDensity(paramInt1, i);
      AppMethodBeat.o(169469);
      return localDrawable;
    }
    
    public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(169470);
      int i = paramInt2;
      if (paramInt2 == 0)
      {
        i = paramInt2;
        if (this.ewR != null) {
          i = this.ewR.densityDpi;
        }
      }
      paramTheme = this.ewQ.getDrawableForDensity(paramInt1, i, paramTheme);
      AppMethodBeat.o(169470);
      return paramTheme;
    }
    
    public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(169473);
      if (this.ewR != null)
      {
        this.ewR = a.a(a.this, paramDisplayMetrics, paramConfiguration);
        this.kJ = new Configuration(paramConfiguration);
        this.kJ.densityDpi = this.ewR.densityDpi;
        super.updateConfiguration(this.kJ, this.ewR);
        this.ewQ.updateConfiguration(paramConfiguration, paramDisplayMetrics);
        AppMethodBeat.o(169473);
        return;
      }
      super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(169473);
    }
  }
  
  public static abstract interface b
  {
    public abstract DisplayMetrics applyScreenAdaptiveDensity(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.k.a
 * JD-Core Version:    0.7.0.1
 */