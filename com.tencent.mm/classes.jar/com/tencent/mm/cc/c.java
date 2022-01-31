package com.tencent.mm.cc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.svg.b.b;

public final class c
{
  com.tencent.mm.svg.a.a uba = new com.tencent.mm.svg.a.a();
  
  static
  {
    com.tencent.mm.compatible.g.a.a(new c.a());
    b.mE(ae.getContext().getSharedPreferences("wechat_svg_debug", 4).getBoolean("open_tag", false));
  }
  
  public static void ml(boolean paramBoolean)
  {
    ae.getContext().getSharedPreferences("wechat_svg_debug", 4).edit().putBoolean("open_tag", paramBoolean).commit();
    b.mE(paramBoolean);
  }
  
  public final Drawable e(Resources paramResources, int paramInt)
  {
    Drawable localDrawable = null;
    if (this.uba.f(paramResources, paramInt)) {
      localDrawable = com.tencent.mm.svg.a.a.e(paramResources, paramInt);
    }
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cc.c
 * JD-Core Version:    0.7.0.1
 */