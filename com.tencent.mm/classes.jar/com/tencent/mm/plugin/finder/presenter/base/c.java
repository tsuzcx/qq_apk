package com.tencent.mm.plugin.finder.presenter.base;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "T", "", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "()Ljava/lang/Object;", "getResources", "Landroid/content/res/Resources;", "plugin-finder_release"})
public abstract interface c<T>
{
  public abstract MMFragmentActivity dcl();
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static <T> Resources a(c<T> paramc)
    {
      AppMethodBeat.i(166483);
      paramc = paramc.dcl().getResources();
      if (paramc == null) {
        p.hyc();
      }
      AppMethodBeat.o(166483);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.base.c
 * JD-Core Version:    0.7.0.1
 */