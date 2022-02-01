package com.tencent.mm.plugin.finder.presenter.base;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "T", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getPresenter", "()Ljava/lang/Object;", "getResources", "Landroid/content/res/Resources;", "plugin-finder_release"})
public abstract interface b<T>
{
  public abstract MMActivity getActivity();
  
  @l(fvt={1, 1, 16})
  public static final class a
  {
    public static <T> Resources a(b<T> paramb)
    {
      AppMethodBeat.i(166483);
      paramb = paramb.getActivity().getResources();
      if (paramb == null) {
        k.fvU();
      }
      AppMethodBeat.o(166483);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.base.b
 * JD-Core Version:    0.7.0.1
 */