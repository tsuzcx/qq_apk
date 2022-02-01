package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
final class FinderCommentDrawer$b$a
  implements View.OnLayoutChangeListener
{
  public static final a tdW;
  
  static
  {
    AppMethodBeat.i(205716);
    tdW = new a();
    AppMethodBeat.o(205716);
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(205715);
    ae.i("Finder.CommentDrawer", "[OnLayoutChange] bottom=" + paramInt4 + " oldBottom=" + paramInt8);
    AppMethodBeat.o(205715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentDrawer.b.a
 * JD-Core Version:    0.7.0.1
 */