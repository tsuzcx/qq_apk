package com.tencent.mm.plugin.finder.video.plugin.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ap;
import com.tencent.mm.view.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/util/FinderLayoutUtil;", "", "()V", "TAG", "", "needScale", "", "needScaleLayout", "context", "Landroid/content/Context;", "ratio", "", "(Landroid/content/Context;Ljava/lang/Float;)Z", "plugin-finder_release"})
public final class a
{
  private final String TAG = "MicroMsg.FinderLayoutUtil";
  private boolean mvD;
  
  public final boolean a(Context paramContext, Float paramFloat)
  {
    AppMethodBeat.i(203993);
    if ((paramFloat == null) || (paramContext == null))
    {
      bool = this.mvD;
      AppMethodBeat.o(203993);
      return bool;
    }
    Object localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "MMApplicationContext.getContext().resources");
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int j = ap.cl(paramContext).y - ap.ej(paramContext);
    float f = j;
    ac.i(this.TAG, "screen width:" + i + " height:" + j + " ratio:" + paramFloat + " preview height" + i / paramFloat.floatValue());
    f -= i / paramFloat.floatValue();
    ac.i(this.TAG, "screen - video height,left: ".concat(String.valueOf(f)));
    i = b.e(ai.getContext(), 320.0F);
    f -= i;
    ac.i(this.TAG, "screen - operationHeight,left: " + f + " operationHeight:" + i);
    if (f < 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.mvD = bool;
      bool = this.mvD;
      AppMethodBeat.o(203993);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.util.a
 * JD-Core Version:    0.7.0.1
 */