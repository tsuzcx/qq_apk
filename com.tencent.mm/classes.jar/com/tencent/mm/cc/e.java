package com.tencent.mm.cc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.a.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.svg.b.b;

public final class e
{
  com.tencent.mm.svg.a.a nPb;
  
  static
  {
    AppMethodBeat.i(141247);
    com.tencent.mm.compatible.e.a.a(new a());
    b.xb(ak.getContext().getSharedPreferences("wechat_svg_debug", g.abv()).getBoolean("open_tag", false));
    AppMethodBeat.o(141247);
  }
  
  public e()
  {
    AppMethodBeat.i(141244);
    this.nPb = new com.tencent.mm.svg.a.a();
    AppMethodBeat.o(141244);
  }
  
  public static void wv(boolean paramBoolean)
  {
    AppMethodBeat.i(141246);
    ak.getContext().getSharedPreferences("wechat_svg_debug", g.abv()).edit().putBoolean("open_tag", paramBoolean).commit();
    b.xb(paramBoolean);
    AppMethodBeat.o(141246);
  }
  
  public final Drawable g(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(141245);
    Drawable localDrawable = null;
    if (this.nPb.i(paramResources, paramInt)) {
      localDrawable = com.tencent.mm.svg.a.a.g(paramResources, paramInt);
    }
    AppMethodBeat.o(141245);
    return localDrawable;
  }
  
  public static final class a
    implements a.a
  {
    com.tencent.mm.svg.a.a nPb;
    
    public a()
    {
      AppMethodBeat.i(141242);
      this.nPb = new com.tencent.mm.svg.a.a();
      AppMethodBeat.o(141242);
    }
    
    public final Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
    {
      AppMethodBeat.i(141243);
      if (this.nPb.i(paramResources, paramInt))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.e
 * JD-Core Version:    0.7.0.1
 */