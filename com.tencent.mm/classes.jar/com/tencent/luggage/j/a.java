package com.tencent.luggage.j;

import android.annotation.TargetApi;
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
  private static final b cDK;
  private Resources cDI;
  private LayoutInflater cDJ;
  private final b cDL;
  
  static
  {
    AppMethodBeat.i(169479);
    cDK = new b()
    {
      public final DisplayMetrics a(DisplayMetrics paramAnonymousDisplayMetrics, Configuration paramAnonymousConfiguration)
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
      paramContext = cDK;
    }
    this.cDL = paramContext;
    AppMethodBeat.o(169474);
  }
  
  private DisplayMetrics a(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    AppMethodBeat.i(169477);
    paramDisplayMetrics = this.cDL.a(paramDisplayMetrics, paramConfiguration);
    AppMethodBeat.o(169477);
    return paramDisplayMetrics;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(169476);
    if (getAssets() != null)
    {
      if (this.cDI == null)
      {
        localResources = super.getResources();
        this.cDI = new a(localResources, a(localResources.getDisplayMetrics(), localResources.getConfiguration()));
      }
      localResources = this.cDI;
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
      if (this.cDJ != null)
      {
        paramString = this.cDJ;
        AppMethodBeat.o(169475);
        return paramString;
      }
      paramString = (LayoutInflater)super.getSystemService("layout_inflater");
      this.cDJ = paramString;
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
    private final Resources cDM;
    private DisplayMetrics cDN;
    private Configuration jN;
    
    a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
    {
      super();
      AppMethodBeat.i(169463);
      this.cDM = paramResources;
      this.cDN = paramDisplayMetrics;
      this$1 = new Configuration(this.cDM.getConfiguration());
      paramResources = new DisplayMetrics();
      paramResources.setTo(this.cDM.getDisplayMetrics());
      updateConfiguration(a.this, paramResources);
      AppMethodBeat.o(169463);
    }
    
    private Drawable A(Drawable paramDrawable)
    {
      AppMethodBeat.i(169466);
      if (((paramDrawable instanceof BitmapDrawable)) && (this.cDN != null)) {
        ((BitmapDrawable)paramDrawable).setTargetDensity(this.cDN.densityDpi);
      }
      AppMethodBeat.o(169466);
      return paramDrawable;
    }
    
    public final Configuration getConfiguration()
    {
      AppMethodBeat.i(169465);
      if (this.jN != null)
      {
        localConfiguration = this.jN;
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
      paramInt = Dr(paramInt);
      AppMethodBeat.o(169471);
      return paramInt;
    }
    
    public final int getDimensionPixelSize(int paramInt)
    {
      AppMethodBeat.i(169472);
      paramInt = Ds(paramInt);
      AppMethodBeat.o(169472);
      return paramInt;
    }
    
    public final DisplayMetrics getDisplayMetrics()
    {
      AppMethodBeat.i(169464);
      if (this.cDN != null)
      {
        localDisplayMetrics = this.cDN;
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
      if (this.cDN != null)
      {
        localDrawable = getDrawableForDensity(paramInt, this.cDN.densityDpi);
        AppMethodBeat.o(169467);
        return localDrawable;
      }
      Drawable localDrawable = A(this.cDM.getDrawable(paramInt));
      AppMethodBeat.o(169467);
      return localDrawable;
    }
    
    @TargetApi(21)
    public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(169468);
      if (this.cDN != null)
      {
        paramTheme = getDrawableForDensity(paramInt, this.cDN.densityDpi, paramTheme);
        AppMethodBeat.o(169468);
        return paramTheme;
      }
      paramTheme = A(this.cDM.getDrawable(paramInt, paramTheme));
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
        if (this.cDN != null) {
          i = this.cDN.densityDpi;
        }
      }
      Drawable localDrawable = this.cDM.getDrawableForDensity(paramInt1, i);
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
        if (this.cDN != null) {
          i = this.cDN.densityDpi;
        }
      }
      paramTheme = this.cDM.getDrawableForDensity(paramInt1, i, paramTheme);
      AppMethodBeat.o(169470);
      return paramTheme;
    }
    
    public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(169473);
      if (this.cDN != null)
      {
        this.cDN = a.a(a.this, paramDisplayMetrics, paramConfiguration);
        this.jN = new Configuration(paramConfiguration);
        this.jN.densityDpi = this.cDN.densityDpi;
        super.updateConfiguration(this.jN, this.cDN);
        this.cDM.updateConfiguration(paramConfiguration, paramDisplayMetrics);
        AppMethodBeat.o(169473);
        return;
      }
      super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(169473);
    }
  }
  
  public static abstract interface b
  {
    public abstract DisplayMetrics a(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.j.a
 * JD-Core Version:    0.7.0.1
 */