package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"getDefaultAppCardBg", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getDefaultCardContentImgBg", "plugin-appbrand-integration_release"})
public final class b
{
  public static final Drawable a(a parama)
  {
    AppMethodBeat.i(51348);
    p.h(parama, "$this$getDefaultAppCardBg");
    parama = parama.activity.getResources().getDrawable(2131231010);
    AppMethodBeat.o(51348);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.b
 * JD-Core Version:    0.7.0.1
 */