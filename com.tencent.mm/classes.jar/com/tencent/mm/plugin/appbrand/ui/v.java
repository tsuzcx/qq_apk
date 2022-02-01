package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;

public final class v
  extends ContextThemeWrapper
{
  private Resources cDI;
  private LayoutInflater cDJ;
  
  public v(Context paramContext)
  {
    AppMethodBeat.i(48882);
    super.attachBaseContext(paramContext);
    ep(paramContext);
    AppMethodBeat.o(48882);
  }
  
  public v(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(177764);
    ep(paramContext);
    AppMethodBeat.o(177764);
  }
  
  private static Resources eo(Context paramContext)
  {
    AppMethodBeat.i(278666);
    Object localObject = AndroidContextUtil.castActivityOrNull(paramContext);
    if ((localObject instanceof MMFragmentActivity))
    {
      paramContext = ((MMFragmentActivity)localObject).getOriginalResources();
      if (paramContext.getConfiguration().orientation == 1)
      {
        AppMethodBeat.o(278666);
        return paramContext;
      }
      paramContext = new Resources(paramContext.getAssets(), paramContext.getDisplayMetrics(), paramContext.getConfiguration());
      localObject = ar.au((Context)localObject);
      if (((Point)localObject).y >= paramContext.getDisplayMetrics().heightPixels) {
        paramContext.getDisplayMetrics().heightPixels = ((Point)localObject).y;
      }
      AppMethodBeat.o(278666);
      return paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      paramContext = ((ContextWrapper)paramContext).getBaseContext().getResources();
      AppMethodBeat.o(278666);
      return paramContext;
    }
    paramContext = paramContext.getResources();
    AppMethodBeat.o(278666);
    return paramContext;
  }
  
  private void ep(Context paramContext)
  {
    AppMethodBeat.i(48884);
    paramContext = eo(paramContext);
    this.cDI = new a(paramContext, com.tencent.mm.cj.a.b(paramContext.getDisplayMetrics()));
    if (Build.VERSION.SDK_INT >= 21) {
      getTheme().getResources().getDisplayMetrics().setTo(this.cDI.getDisplayMetrics());
    }
    AppMethodBeat.o(48884);
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(48886);
    if ((getAssets() != null) && (this.cDI != null))
    {
      localResources = this.cDI;
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
      if (this.cDJ != null)
      {
        paramString = this.cDJ;
        AppMethodBeat.o(48885);
        return paramString;
      }
      paramString = ad.b((LayoutInflater)super.getSystemService("layout_inflater"));
      this.cDJ = paramString;
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
    private final Resources cDM;
    private DisplayMetrics cDN;
    private Configuration jN;
    
    a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
    {
      super();
      AppMethodBeat.i(48871);
      this.cDM = paramResources;
      this.cDN = paramDisplayMetrics;
      paramResources = new Configuration(this.cDM.getConfiguration());
      paramDisplayMetrics = new DisplayMetrics();
      paramDisplayMetrics.setTo(this.cDM.getDisplayMetrics());
      updateConfiguration(paramResources, paramDisplayMetrics);
      AppMethodBeat.o(48871);
    }
    
    private Drawable A(Drawable paramDrawable)
    {
      AppMethodBeat.i(48874);
      if (((paramDrawable instanceof BitmapDrawable)) && (this.cDN != null)) {
        ((BitmapDrawable)paramDrawable).setTargetDensity(this.cDN.densityDpi);
      }
      AppMethodBeat.o(48874);
      return paramDrawable;
    }
    
    public final Configuration getConfiguration()
    {
      AppMethodBeat.i(48873);
      if (this.jN != null)
      {
        localConfiguration = this.jN;
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
      paramInt = Dr(paramInt);
      AppMethodBeat.o(48880);
      return paramInt;
    }
    
    public final int getDimensionPixelSize(int paramInt)
    {
      AppMethodBeat.i(48879);
      paramInt = Ds(paramInt);
      AppMethodBeat.o(48879);
      return paramInt;
    }
    
    public final DisplayMetrics getDisplayMetrics()
    {
      AppMethodBeat.i(48872);
      if (this.cDN != null)
      {
        localDisplayMetrics = this.cDN;
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
      if (this.cDN != null)
      {
        localDrawable = getDrawableForDensity(paramInt, this.cDN.densityDpi);
        AppMethodBeat.o(48875);
        return localDrawable;
      }
      Drawable localDrawable = A(this.cDM.getDrawable(paramInt));
      AppMethodBeat.o(48875);
      return localDrawable;
    }
    
    public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(48876);
      try
      {
        if (this.cDN != null)
        {
          Drawable localDrawable = getDrawableForDensity(paramInt, this.cDN.densityDpi, paramTheme);
          AppMethodBeat.o(48876);
          return localDrawable;
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", localNoSuchMethodError, "getDrawable(id, theme)", new Object[0]);
        if (paramTheme == null)
        {
          paramTheme = getDrawableForDensity(paramInt, this.cDN.densityDpi);
          AppMethodBeat.o(48876);
          return paramTheme;
        }
        paramTheme = A(this.cDM.getDrawable(paramInt, paramTheme));
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
        if (this.cDN != null) {
          i = this.cDN.densityDpi;
        }
      }
      Drawable localDrawable = this.cDM.getDrawableForDensity(paramInt1, i);
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
        if (this.cDN != null) {
          i = this.cDN.densityDpi;
        }
      }
      paramTheme = this.cDM.getDrawableForDensity(paramInt1, i, paramTheme);
      AppMethodBeat.o(48878);
      return paramTheme;
    }
    
    public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(48881);
      if (this.cDN != null)
      {
        this.cDN = com.tencent.mm.cj.a.b(paramDisplayMetrics);
        this.jN = new Configuration(paramConfiguration);
        this.jN.densityDpi = this.cDN.densityDpi;
        super.updateConfiguration(this.jN, this.cDN);
        this.cDM.updateConfiguration(paramConfiguration, paramDisplayMetrics);
        AppMethodBeat.o(48881);
        return;
      }
      super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(48881);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.v
 * JD-Core Version:    0.7.0.1
 */