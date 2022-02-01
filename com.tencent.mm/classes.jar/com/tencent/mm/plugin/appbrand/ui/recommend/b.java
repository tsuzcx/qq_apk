package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"getDefaultAppCardBg", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getDefaultCardContentImgBg", "plugin-appbrand-integration_release"})
public final class b
{
  public static final Drawable a(a parama)
  {
    AppMethodBeat.i(51348);
    p.h(parama, "$this$getDefaultAppCardBg");
    parama = parama.activity.getResources().getDrawable(2131231042);
    AppMethodBeat.o(51348);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.b
 * JD-Core Version:    0.7.0.1
 */