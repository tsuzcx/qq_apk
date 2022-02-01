package com.tencent.luggage.g;

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
  private static final b cqL;
  private Resources cqJ;
  private LayoutInflater cqK;
  private final b cqM;
  
  static
  {
    AppMethodBeat.i(169479);
    cqL = new b()
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
      paramContext = cqL;
    }
    this.cqM = paramContext;
    AppMethodBeat.o(169474);
  }
  
  private DisplayMetrics a(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    AppMethodBeat.i(169477);
    paramDisplayMetrics = this.cqM.a(paramDisplayMetrics, paramConfiguration);
    AppMethodBeat.o(169477);
    return paramDisplayMetrics;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(169476);
    if (getAssets() != null)
    {
      if (this.cqJ == null)
      {
        localResources = super.getResources();
        this.cqJ = new a(localResources, a(localResources.getDisplayMetrics(), localResources.getConfiguration()));
      }
      localResources = this.cqJ;
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
      if (this.cqK != null)
      {
        paramString = this.cqK;
        AppMethodBeat.o(169475);
        return paramString;
      }
      paramString = (LayoutInflater)super.getSystemService("layout_inflater");
      this.cqK = paramString;
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
    private Configuration adt;
    private final Resources cqN;
    private DisplayMetrics cqO;
    
    a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
    {
      super();
      AppMethodBeat.i(169463);
      this.cqN = paramResources;
      this.cqO = paramDisplayMetrics;
      this$1 = new Configuration(this.cqN.getConfiguration());
      paramResources = new DisplayMetrics();
      paramResources.setTo(this.cqN.getDisplayMetrics());
      updateConfiguration(a.this, paramResources);
      AppMethodBeat.o(169463);
    }
    
    private Drawable v(Drawable paramDrawable)
    {
      AppMethodBeat.i(169466);
      if (((paramDrawable instanceof BitmapDrawable)) && (this.cqO != null)) {
        ((BitmapDrawable)paramDrawable).setTargetDensity(this.cqO.densityDpi);
      }
      AppMethodBeat.o(169466);
      return paramDrawable;
    }
    
    public final Configuration getConfiguration()
    {
      AppMethodBeat.i(169465);
      if (this.adt != null)
      {
        localConfiguration = this.adt;
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
      paramInt = vT(paramInt);
      AppMethodBeat.o(169471);
      return paramInt;
    }
    
    public final int getDimensionPixelSize(int paramInt)
    {
      AppMethodBeat.i(169472);
      paramInt = vU(paramInt);
      AppMethodBeat.o(169472);
      return paramInt;
    }
    
    public final DisplayMetrics getDisplayMetrics()
    {
      AppMethodBeat.i(169464);
      if (this.cqO != null)
      {
        localDisplayMetrics = this.cqO;
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
      if (this.cqO != null)
      {
        localDrawable = getDrawableForDensity(paramInt, this.cqO.densityDpi);
        AppMethodBeat.o(169467);
        return localDrawable;
      }
      Drawable localDrawable = v(this.cqN.getDrawable(paramInt));
      AppMethodBeat.o(169467);
      return localDrawable;
    }
    
    @TargetApi(21)
    public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(169468);
      if (this.cqO != null)
      {
        paramTheme = getDrawableForDensity(paramInt, this.cqO.densityDpi, paramTheme);
        AppMethodBeat.o(169468);
        return paramTheme;
      }
      paramTheme = v(this.cqN.getDrawable(paramInt, paramTheme));
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
        if (this.cqO != null) {
          i = this.cqO.densityDpi;
        }
      }
      Drawable localDrawable = this.cqN.getDrawableForDensity(paramInt1, i);
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
        if (this.cqO != null) {
          i = this.cqO.densityDpi;
        }
      }
      paramTheme = this.cqN.getDrawableForDensity(paramInt1, i, paramTheme);
      AppMethodBeat.o(169470);
      return paramTheme;
    }
    
    public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(169473);
      if (this.cqO != null)
      {
        this.cqO = a.a(a.this, paramDisplayMetrics, paramConfiguration);
        this.adt = new Configuration(paramConfiguration);
        this.adt.densityDpi = this.cqO.densityDpi;
        super.updateConfiguration(this.adt, this.cqO);
        this.cqN.updateConfiguration(paramConfiguration, paramDisplayMetrics);
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
 * Qualified Name:     com.tencent.luggage.g.a
 * JD-Core Version:    0.7.0.1
 */