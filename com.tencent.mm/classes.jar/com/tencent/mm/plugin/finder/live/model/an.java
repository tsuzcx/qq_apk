package com.tencent.mm.plugin.finder.live.model;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.span.l;
import com.tencent.mm.plugin.finder.view.drawable.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveUserGameRankLevelConfig;", "Lcom/tencent/mm/plugin/finder/live/view/span/IFinderLiveSpanConfig;", "", "view", "Landroid/view/View;", "sizeMode", "id", "(Landroid/view/View;II)V", "getId", "()I", "viewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getBgColor", "userLevel", "getBgDrawableId", "level", "getBgHeight", "params", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "url", "", "getIconResourceId", "getIconSize", "", "getTextBold", "getTextColor", "getTextSize", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  implements l<Integer>
{
  private final int CId;
  private final int id;
  private final WeakReference<View> viewRef;
  
  public an(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(360075);
    this.CId = paramInt1;
    this.id = paramInt2;
    this.viewRef = new WeakReference(paramView);
    AppMethodBeat.o(360075);
  }
  
  public final Drawable awB(String paramString)
  {
    AppMethodBeat.i(360084);
    s.u(paramString, "url");
    paramString = (Drawable)new a(paramString, this.id, (View)this.viewRef.get());
    AppMethodBeat.o(360084);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.an
 * JD-Core Version:    0.7.0.1
 */