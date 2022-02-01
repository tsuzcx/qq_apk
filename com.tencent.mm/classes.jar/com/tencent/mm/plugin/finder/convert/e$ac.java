package com.tencent.mm.plugin.finder.convert;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.v.e;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
final class e$ac
  implements Runnable
{
  e$ac(e parame, v.e parame1, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(197395);
    int i = a.ap(this.nGG.getContext(), 2131165303);
    Object localObject = new Rect();
    ((View)this.KKB.Jhw).getHitRect((Rect)localObject);
    ((Rect)localObject).inset(-i, -i);
    ViewParent localViewParent = ((View)this.KKB.Jhw).getParent();
    if (localViewParent == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(197395);
      throw ((Throwable)localObject);
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, (View)this.KKz));
    AppMethodBeat.o(197395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.ac
 * JD-Core Version:    0.7.0.1
 */