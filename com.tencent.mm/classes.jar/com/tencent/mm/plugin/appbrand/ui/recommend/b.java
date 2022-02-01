package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getDefaultAppCardBg", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getDefaultCardContentImgBg", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final Drawable a(a parama)
  {
    AppMethodBeat.i(51348);
    s.u(parama, "<this>");
    parama = parama.activity.getResources().getDrawable(ba.e.app_brand_recommend_card_app_type_icon_default_bg);
    AppMethodBeat.o(51348);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.b
 * JD-Core Version:    0.7.0.1
 */