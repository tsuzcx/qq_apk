package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ak
  extends c
{
  private static final int ovy;
  private e ovx = null;
  
  static
  {
    AppMethodBeat.i(49920);
    ovy = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131165535);
    AppMethodBeat.o(49920);
  }
  
  public final e cbY()
  {
    AppMethodBeat.i(49919);
    if (this.ovx == null) {
      this.ovx = new a();
    }
    e locale = this.ovx;
    AppMethodBeat.o(49919);
    return locale;
  }
  
  static final class a
    extends e
  {
    private String[] ovz;
    
    static
    {
      AppMethodBeat.i(49910);
      j.UJ("com.tencent.mm.plugin.emoji.PluginEmoji");
      AppMethodBeat.o(49910);
    }
    
    a()
    {
      super();
      AppMethodBeat.i(49905);
      this.ovz = null;
      this.ovz = MMApplicationContext.getContext().getResources().getStringArray(2130903071);
      AppMethodBeat.o(49905);
    }
    
    public final Drawable Al(int paramInt)
    {
      AppMethodBeat.i(49906);
      f.cbc();
      ak.b localb = new ak.b(Am(paramInt), ak.ovy, (byte)0);
      AppMethodBeat.o(49906);
      return localb;
    }
    
    public final String Am(int paramInt)
    {
      AppMethodBeat.i(49907);
      if ((this.ovz == null) || (paramInt < 0) || (paramInt > this.ovz.length - 1))
      {
        AppMethodBeat.o(49907);
        return "";
      }
      Object localObject2 = this.ovz[paramInt].split(" ");
      Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
      localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
      localObject1 = (char[])localObject1 + (char[])localObject2;
      AppMethodBeat.o(49907);
      return localObject1;
    }
    
    public final String An(int paramInt)
    {
      AppMethodBeat.i(49909);
      String str = Am(paramInt);
      AppMethodBeat.o(49909);
      return str;
    }
    
    public final int cbZ()
    {
      return 0;
    }
    
    public final int cca()
    {
      if (this.ovz != null) {
        return this.ovz.length;
      }
      return 0;
    }
  }
  
  static final class c
    extends ContextWrapper
  {
    private Resources mResources;
    
    public c(Context paramContext)
    {
      super();
    }
    
    public final Resources getResources()
    {
      AppMethodBeat.i(49917);
      if ((this.mResources != null) && ((this.mResources instanceof ak.d)))
      {
        localResources = this.mResources;
        AppMethodBeat.o(49917);
        return localResources;
      }
      Resources localResources = super.getResources();
      this.mResources = new ak.d(localResources.getAssets(), localResources.getDisplayMetrics(), localResources.getConfiguration());
      localResources = this.mResources;
      AppMethodBeat.o(49917);
      return localResources;
    }
  }
  
  static final class d
    extends Resources
  {
    d(AssetManager paramAssetManager, DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
    {
      super(paramDisplayMetrics, paramConfiguration);
    }
    
    public final String[] getStringArray(int paramInt)
    {
      AppMethodBeat.i(49918);
      if (2130903069 == paramInt)
      {
        AppMethodBeat.o(49918);
        return new String[0];
      }
      if (2130903070 == paramInt)
      {
        AppMethodBeat.o(49918);
        return new String[0];
      }
      String[] arrayOfString = super.getStringArray(paramInt);
      AppMethodBeat.o(49918);
      return arrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak
 * JD-Core Version:    0.7.0.1
 */