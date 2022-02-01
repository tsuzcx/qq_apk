package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.z;

public final class r
  extends ContextThemeWrapper
{
  private Resources cqJ;
  private LayoutInflater cqK;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(48882);
    super.attachBaseContext(paramContext);
    dS(paramContext);
    AppMethodBeat.o(48882);
  }
  
  public r(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(177764);
    dS(paramContext);
    AppMethodBeat.o(177764);
  }
  
  private void dS(Context paramContext)
  {
    AppMethodBeat.i(48884);
    DisplayMetrics localDisplayMetrics = com.tencent.mm.cc.a.c(paramContext.getResources().getDisplayMetrics());
    this.cqJ = new a(paramContext.getResources(), localDisplayMetrics);
    if (Build.VERSION.SDK_INT >= 21) {
      getTheme().getResources().getDisplayMetrics().setTo(this.cqJ.getDisplayMetrics());
    }
    AppMethodBeat.o(48884);
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(48886);
    if ((getAssets() != null) && (this.cqJ != null))
    {
      localResources = this.cqJ;
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
      if (this.cqK != null)
      {
        paramString = this.cqK;
        AppMethodBeat.o(48885);
        return paramString;
      }
      paramString = z.b((LayoutInflater)super.getSystemService("layout_inflater"));
      this.cqK = paramString;
      AppMethodBeat.o(48885);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(48885);
    return paramString;
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.widget.a
  {
    private Configuration adt;
    private final Resources cqN;
    private DisplayMetrics cqO;
    
    a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
    {
      super();
      AppMethodBeat.i(48871);
      this.cqN = paramResources;
      this.cqO = paramDisplayMetrics;
      paramResources = new Configuration(this.cqN.getConfiguration());
      paramDisplayMetrics = new DisplayMetrics();
      paramDisplayMetrics.setTo(this.cqN.getDisplayMetrics());
      updateConfiguration(paramResources, paramDisplayMetrics);
      AppMethodBeat.o(48871);
    }
    
    private Drawable v(Drawable paramDrawable)
    {
      AppMethodBeat.i(48874);
      if (((paramDrawable instanceof BitmapDrawable)) && (this.cqO != null)) {
        ((BitmapDrawable)paramDrawable).setTargetDensity(this.cqO.densityDpi);
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
      paramInt = vT(paramInt);
      AppMethodBeat.o(48880);
      return paramInt;
    }
    
    public final int getDimensionPixelSize(int paramInt)
    {
      AppMethodBeat.i(48879);
      paramInt = vU(paramInt);
      AppMethodBeat.o(48879);
      return paramInt;
    }
    
    public final DisplayMetrics getDisplayMetrics()
    {
      AppMethodBeat.i(48872);
      if (this.cqO != null)
      {
        localDisplayMetrics = this.cqO;
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
      if (this.cqO != null)
      {
        localDrawable = getDrawableForDensity(paramInt, this.cqO.densityDpi);
        AppMethodBeat.o(48875);
        return localDrawable;
      }
      Drawable localDrawable = v(this.cqN.getDrawable(paramInt));
      AppMethodBeat.o(48875);
      return localDrawable;
    }
    
    public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(48876);
      try
      {
        if (this.cqO != null)
        {
          Drawable localDrawable = getDrawableForDensity(paramInt, this.cqO.densityDpi, paramTheme);
          AppMethodBeat.o(48876);
          return localDrawable;
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", localNoSuchMethodError, "getDrawable(id, theme)", new Object[0]);
        if (paramTheme == null)
        {
          paramTheme = getDrawableForDensity(paramInt, this.cqO.densityDpi);
          AppMethodBeat.o(48876);
          return paramTheme;
        }
        paramTheme = v(this.cqN.getDrawable(paramInt, paramTheme));
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
        if (this.cqO != null) {
          i = this.cqO.densityDpi;
        }
      }
      Drawable localDrawable = this.cqN.getDrawableForDensity(paramInt1, i);
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
        if (this.cqO != null) {
          i = this.cqO.densityDpi;
        }
      }
      paramTheme = this.cqN.getDrawableForDensity(paramInt1, i, paramTheme);
      AppMethodBeat.o(48878);
      return paramTheme;
    }
    
    public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(48881);
      if (this.cqO != null)
      {
        this.cqO = com.tencent.mm.cc.a.c(paramDisplayMetrics);
        this.adt = new Configuration(paramConfiguration);
        this.adt.densityDpi = this.cqO.densityDpi;
        super.updateConfiguration(this.adt, this.cqO);
        this.cqN.updateConfiguration(paramConfiguration, paramDisplayMetrics);
        AppMethodBeat.o(48881);
        return;
      }
      super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(48881);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.r
 * JD-Core Version:    0.7.0.1
 */