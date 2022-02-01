package com.tencent.luggage.g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends ContextThemeWrapper
{
  private static final b cDd;
  private Resources cDb;
  private LayoutInflater cDc;
  private final b cDe;
  
  static
  {
    AppMethodBeat.i(169479);
    cDd = new b()
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
      paramContext = cDd;
    }
    this.cDe = paramContext;
    AppMethodBeat.o(169474);
  }
  
  private DisplayMetrics a(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    AppMethodBeat.i(169477);
    paramDisplayMetrics = this.cDe.a(paramDisplayMetrics, paramConfiguration);
    AppMethodBeat.o(169477);
    return paramDisplayMetrics;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(169476);
    if (getAssets() != null)
    {
      if (this.cDb == null)
      {
        localResources = super.getResources();
        this.cDb = new a.a(this, localResources, a(localResources.getDisplayMetrics(), localResources.getConfiguration()));
      }
      localResources = this.cDb;
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
      if (this.cDc != null)
      {
        paramString = this.cDc;
        AppMethodBeat.o(169475);
        return paramString;
      }
      paramString = (LayoutInflater)super.getSystemService("layout_inflater");
      this.cDc = paramString;
      AppMethodBeat.o(169475);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(169475);
    return paramString;
  }
  
  public static abstract interface b
  {
    public abstract DisplayMetrics a(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.g.a
 * JD-Core Version:    0.7.0.1
 */