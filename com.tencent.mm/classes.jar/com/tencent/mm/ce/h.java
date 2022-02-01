package com.tencent.mm.ce;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.a.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.svg.b.b;

public final class h
{
  com.tencent.mm.svg.a.a vnn;
  
  static
  {
    AppMethodBeat.i(141247);
    com.tencent.mm.compatible.f.a.a(new a());
    b.KG(MMApplicationContext.getContext().getSharedPreferences("wechat_svg_debug", g.aQe()).getBoolean("open_tag", false));
    AppMethodBeat.o(141247);
  }
  
  public h()
  {
    AppMethodBeat.i(141244);
    this.vnn = new com.tencent.mm.svg.a.a();
    AppMethodBeat.o(141244);
  }
  
  public static void Ko(boolean paramBoolean)
  {
    AppMethodBeat.i(141246);
    MMApplicationContext.getContext().getSharedPreferences("wechat_svg_debug", g.aQe()).edit().putBoolean("open_tag", paramBoolean).commit();
    b.KG(paramBoolean);
    AppMethodBeat.o(141246);
  }
  
  public final Drawable i(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(141245);
    Drawable localDrawable = null;
    if (this.vnn.k(paramResources, paramInt)) {
      localDrawable = com.tencent.mm.svg.a.a.i(paramResources, paramInt);
    }
    AppMethodBeat.o(141245);
    return localDrawable;
  }
  
  public static final class a
    implements a.a
  {
    com.tencent.mm.svg.a.a vnn;
    
    public a()
    {
      AppMethodBeat.i(141242);
      this.vnn = new com.tencent.mm.svg.a.a();
      AppMethodBeat.o(141242);
    }
    
    public final Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
    {
      AppMethodBeat.i(141243);
      if (this.vnn.k(paramResources, paramInt))
      {
        float f = 0.0F;
        if (paramOptions != null) {
          f = paramOptions.inDensity / 160.0F;
        }
        paramResources = com.tencent.mm.svg.a.a.b(paramResources, paramInt, f);
        AppMethodBeat.o(141243);
        return paramResources;
      }
      AppMethodBeat.o(141243);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ce.h
 * JD-Core Version:    0.7.0.1
 */