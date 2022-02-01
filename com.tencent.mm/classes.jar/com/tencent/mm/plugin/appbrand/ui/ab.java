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
import com.tencent.mm.ce.c;
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;

public final class ab
  extends ContextThemeWrapper
{
  private Resources ewM;
  private LayoutInflater ewN;
  
  public ab(Context paramContext)
  {
    AppMethodBeat.i(48882);
    super.attachBaseContext(paramContext);
    fl(paramContext);
    AppMethodBeat.o(48882);
  }
  
  public ab(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(177764);
    fl(paramContext);
    AppMethodBeat.o(177764);
  }
  
  private static Resources fk(Context paramContext)
  {
    AppMethodBeat.i(322030);
    Object localObject = AndroidContextUtil.castActivityOrNull(paramContext);
    if ((localObject instanceof MMFragmentActivity))
    {
      paramContext = ((MMFragmentActivity)localObject).getOriginalResources();
      if (paramContext.getConfiguration().orientation == 1)
      {
        AppMethodBeat.o(322030);
        return paramContext;
      }
      if (aw.ato())
      {
        AppMethodBeat.o(322030);
        return paramContext;
      }
      paramContext = new Resources(paramContext.getAssets(), paramContext.getDisplayMetrics(), paramContext.getConfiguration());
      localObject = aw.bf((Context)localObject);
      int i = Math.min(((Point)localObject).x, ((Point)localObject).y);
      if (i >= paramContext.getDisplayMetrics().heightPixels) {
        paramContext.getDisplayMetrics().heightPixels = i;
      }
      AppMethodBeat.o(322030);
      return paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      paramContext = ((ContextWrapper)paramContext).getBaseContext().getResources();
      AppMethodBeat.o(322030);
      return paramContext;
    }
    paramContext = paramContext.getResources();
    AppMethodBeat.o(322030);
    return paramContext;
  }
  
  private void fl(Context paramContext)
  {
    AppMethodBeat.i(48884);
    paramContext = fk(paramContext);
    this.ewM = new a(paramContext, c.d(paramContext.getDisplayMetrics()));
    if (Build.VERSION.SDK_INT >= 21) {
      getTheme().getResources().getDisplayMetrics().setTo(this.ewM.getDisplayMetrics());
    }
    AppMethodBeat.o(48884);
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(48886);
    if ((getAssets() != null) && (this.ewM != null))
    {
      localResources = this.ewM;
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
      if (this.ewN != null)
      {
        paramString = this.ewN;
        AppMethodBeat.o(48885);
        return paramString;
      }
      paramString = af.b((LayoutInflater)super.getSystemService("layout_inflater"));
      this.ewN = paramString;
      AppMethodBeat.o(48885);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(48885);
    return paramString;
  }
  
  static final class a
    extends a
  {
    private final Resources ewQ;
    private DisplayMetrics ewR;
    private Configuration kJ;
    
    a(Resources paramResources, DisplayMetrics paramDisplayMetrics)
    {
      super();
      AppMethodBeat.i(48871);
      this.ewQ = paramResources;
      this.ewR = paramDisplayMetrics;
      this.kJ = new Configuration(this.ewQ.getConfiguration());
      this.kJ.densityDpi = this.ewR.densityDpi;
      paramResources = new Configuration(this.ewQ.getConfiguration());
      paramDisplayMetrics = new DisplayMetrics();
      paramDisplayMetrics.setTo(this.ewQ.getDisplayMetrics());
      a(paramResources, paramDisplayMetrics, false);
      AppMethodBeat.o(48871);
    }
    
    private Drawable K(Drawable paramDrawable)
    {
      AppMethodBeat.i(48874);
      if (((paramDrawable instanceof BitmapDrawable)) && (this.ewR != null)) {
        ((BitmapDrawable)paramDrawable).setTargetDensity(this.ewR.densityDpi);
      }
      AppMethodBeat.o(48874);
      return paramDrawable;
    }
    
    private void a(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics, boolean paramBoolean)
    {
      AppMethodBeat.i(322058);
      if ((this.ewR == null) || (paramBoolean))
      {
        this.ewR = c.d(paramDisplayMetrics);
        this.kJ = new Configuration(paramConfiguration);
        this.kJ.densityDpi = this.ewR.densityDpi;
      }
      super.updateConfiguration(this.kJ, this.ewR);
      this.ewQ.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(322058);
    }
    
    public final Configuration getConfiguration()
    {
      AppMethodBeat.i(48873);
      if (this.kJ != null)
      {
        localConfiguration = this.kJ;
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
      paramInt = DQ(paramInt);
      AppMethodBeat.o(48880);
      return paramInt;
    }
    
    public final int getDimensionPixelSize(int paramInt)
    {
      AppMethodBeat.i(48879);
      paramInt = DR(paramInt);
      AppMethodBeat.o(48879);
      return paramInt;
    }
    
    public final DisplayMetrics getDisplayMetrics()
    {
      AppMethodBeat.i(48872);
      if (this.ewR != null)
      {
        localDisplayMetrics = this.ewR;
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
      if (this.ewR != null)
      {
        localDrawable = getDrawableForDensity(paramInt, this.ewR.densityDpi);
        AppMethodBeat.o(48875);
        return localDrawable;
      }
      Drawable localDrawable = K(this.ewQ.getDrawable(paramInt));
      AppMethodBeat.o(48875);
      return localDrawable;
    }
    
    public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(48876);
      try
      {
        if (this.ewR != null)
        {
          Drawable localDrawable = getDrawableForDensity(paramInt, this.ewR.densityDpi, paramTheme);
          AppMethodBeat.o(48876);
          return localDrawable;
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", localNoSuchMethodError, "getDrawable(id, theme)", new Object[0]);
        if (paramTheme == null)
        {
          paramTheme = getDrawableForDensity(paramInt, this.ewR.densityDpi);
          AppMethodBeat.o(48876);
          return paramTheme;
        }
        paramTheme = K(this.ewQ.getDrawable(paramInt, paramTheme));
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
        if (this.ewR != null) {
          i = this.ewR.densityDpi;
        }
      }
      Drawable localDrawable = this.ewQ.getDrawableForDensity(paramInt1, i);
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
        if (this.ewR != null) {
          i = this.ewR.densityDpi;
        }
      }
      paramTheme = this.ewQ.getDrawableForDensity(paramInt1, i, paramTheme);
      AppMethodBeat.o(48878);
      return paramTheme;
    }
    
    public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(48881);
      if (this.ewR != null)
      {
        a(paramConfiguration, paramDisplayMetrics, true);
        AppMethodBeat.o(48881);
        return;
      }
      super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      AppMethodBeat.o(48881);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ab
 * JD-Core Version:    0.7.0.1
 */