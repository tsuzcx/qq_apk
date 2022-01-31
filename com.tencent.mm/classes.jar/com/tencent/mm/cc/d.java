package com.tencent.mm.cc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.g.a.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.svg.b.b;

public final class d
{
  com.tencent.mm.svg.a.a yjq;
  
  static
  {
    AppMethodBeat.i(105917);
    com.tencent.mm.compatible.g.a.a(new a());
    b.pW(ah.getContext().getSharedPreferences("wechat_svg_debug", h.Mp()).getBoolean("open_tag", false));
    AppMethodBeat.o(105917);
  }
  
  public d()
  {
    AppMethodBeat.i(105914);
    this.yjq = new com.tencent.mm.svg.a.a();
    AppMethodBeat.o(105914);
  }
  
  public static void pA(boolean paramBoolean)
  {
    AppMethodBeat.i(105916);
    ah.getContext().getSharedPreferences("wechat_svg_debug", h.Mp()).edit().putBoolean("open_tag", paramBoolean).commit();
    b.pW(paramBoolean);
    AppMethodBeat.o(105916);
  }
  
  public final Drawable g(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(105915);
    Drawable localDrawable = null;
    if (this.yjq.h(paramResources, paramInt)) {
      localDrawable = com.tencent.mm.svg.a.a.g(paramResources, paramInt);
    }
    AppMethodBeat.o(105915);
    return localDrawable;
  }
  
  public static final class a
    implements a.a
  {
    com.tencent.mm.svg.a.a yjq;
    
    public a()
    {
      AppMethodBeat.i(105912);
      this.yjq = new com.tencent.mm.svg.a.a();
      AppMethodBeat.o(105912);
    }
    
    public final Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
    {
      AppMethodBeat.i(105913);
      if (this.yjq.h(paramResources, paramInt))
      {
        float f = 0.0F;
        if (paramOptions != null) {
          f = paramOptions.inDensity / 160.0F;
        }
        paramResources = com.tencent.mm.svg.a.a.b(paramResources, paramInt, f);
        AppMethodBeat.o(105913);
        return paramResources;
      }
      AppMethodBeat.o(105913);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.d
 * JD-Core Version:    0.7.0.1
 */