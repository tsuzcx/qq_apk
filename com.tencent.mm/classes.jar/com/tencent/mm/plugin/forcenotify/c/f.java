package com.tencent.mm.plugin.forcenotify.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyCommonItem;", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "id", "", "title", "desc", "_windowTitle", "_windowIcon", "Landroid/graphics/drawable/Drawable;", "onClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lkotlin/jvm/functions/Function1;)V", "getDesc", "()Ljava/lang/String;", "getTitle", "getIconDrawable", "getItemId", "", "getItemType", "", "getWindowTitle", "needSound", "", "needVibrate", "onFullScreenClick", "view", "onItemClick", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onRemoveFromList", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  private final String Hon;
  private final Drawable Hoo;
  private final kotlin.g.a.b<View, ah> Hop;
  public final String desc;
  public final String title;
  
  private f(String paramString1, String paramString2, String paramString3, String paramString4, kotlin.g.a.b<? super View, ah> paramb)
  {
    super(paramString1);
    AppMethodBeat.i(274863);
    this.title = paramString2;
    this.desc = paramString3;
    this.Hon = paramString4;
    this.Hoo = null;
    this.Hop = paramb;
    AppMethodBeat.o(274863);
  }
  
  public final void a(j paramj, View paramView)
  {
    AppMethodBeat.i(274896);
    s.u(paramj, "holder");
    s.u(paramView, "view");
    paramj = this.Hop;
    if (paramj != null) {
      paramj.invoke(paramView);
    }
    AppMethodBeat.o(274896);
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    return 3;
  }
  
  public final boolean dWY()
  {
    return true;
  }
  
  public final boolean dWZ()
  {
    return true;
  }
  
  public final String dXa()
  {
    AppMethodBeat.i(274906);
    String str = this.Hon;
    if (str == null)
    {
      str = super.dXa();
      AppMethodBeat.o(274906);
      return str;
    }
    AppMethodBeat.o(274906);
    return str;
  }
  
  public final Drawable dXb()
  {
    AppMethodBeat.i(274893);
    Drawable localDrawable = this.Hoo;
    if (localDrawable == null)
    {
      localDrawable = super.dXb();
      AppMethodBeat.o(274893);
      return localDrawable;
    }
    AppMethodBeat.o(274893);
    return localDrawable;
  }
  
  public final void fwG()
  {
    AppMethodBeat.i(274880);
    super.fwG();
    i.a locala = i.Hos;
    i.a.fwN().aDR(this.id);
    com.tencent.mm.plugin.forcenotify.d.b.Hoz.iP(this.id);
    AppMethodBeat.o(274880);
  }
  
  public final void hp(View paramView)
  {
    AppMethodBeat.i(274902);
    s.u(paramView, "view");
    kotlin.g.a.b localb = this.Hop;
    if (localb != null) {
      localb.invoke(paramView);
    }
    AppMethodBeat.o(274902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.f
 * JD-Core Version:    0.7.0.1
 */