package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"getDefaultAppCardBg", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getDefaultCardContentImgBg", "plugin-appbrand-integration_release"})
public final class b
{
  public static final Drawable a(a parama)
  {
    AppMethodBeat.i(135182);
    j.q(parama, "receiver$0");
    parama = parama.activity.getResources().getDrawable(2130837764);
    AppMethodBeat.o(135182);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.b
 * JD-Core Version:    0.7.0.1
 */