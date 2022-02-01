package com.tencent.mm.plugin.forcenotify.c;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyEmptyItem;", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "()V", "getItemId", "", "getItemType", "", "needSound", "", "needVibrate", "onFullScreenClick", "", "view", "Landroid/view/View;", "onItemClick", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "Companion", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  public static final g.a Hoq;
  private static final g Hor;
  
  static
  {
    AppMethodBeat.i(274851);
    Hoq = new g.a((byte)0);
    Hor = new g();
    AppMethodBeat.o(274851);
  }
  
  public g()
  {
    super("empty");
  }
  
  public final void a(j paramj, View paramView)
  {
    AppMethodBeat.i(274855);
    s.u(paramj, "holder");
    s.u(paramView, "view");
    AppMethodBeat.o(274855);
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    return -1;
  }
  
  public final boolean dWY()
  {
    return false;
  }
  
  public final boolean dWZ()
  {
    return false;
  }
  
  public final void hp(View paramView)
  {
    AppMethodBeat.i(274857);
    s.u(paramView, "view");
    AppMethodBeat.o(274857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.g
 * JD-Core Version:    0.7.0.1
 */