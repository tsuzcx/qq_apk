package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
final class FinderCommentDrawer$b$a
  implements View.OnLayoutChangeListener
{
  public static final a rWa;
  
  static
  {
    AppMethodBeat.i(204127);
    rWa = new a();
    AppMethodBeat.o(204127);
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(204126);
    ac.i("Finder.CommentDrawer", "[OnLayoutChange] bottom=" + paramInt4 + " oldBottom=" + paramInt8);
    AppMethodBeat.o(204126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentDrawer.b.a
 * JD-Core Version:    0.7.0.1
 */