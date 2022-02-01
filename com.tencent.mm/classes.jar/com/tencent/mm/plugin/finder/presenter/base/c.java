package com.tencent.mm.plugin.finder.presenter.base;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "T", "", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "()Ljava/lang/Object;", "getResources", "Landroid/content/res/Resources;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c<T>
{
  public abstract MMFragmentActivity dUP();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T> Resources a(c<T> paramc)
    {
      AppMethodBeat.i(166483);
      s.u(paramc, "this");
      paramc = paramc.dUP().getResources();
      s.checkNotNull(paramc);
      AppMethodBeat.o(166483);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.base.c
 * JD-Core Version:    0.7.0.1
 */