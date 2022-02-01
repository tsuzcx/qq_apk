package com.tencent.mm.plugin.cast.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ut;
import com.tencent.mm.plugin.cast.b.d;
import com.tencent.mm.plugin.cast.b.e;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/banner/ScreenCastBanner;", "Lcom/tencent/mm/pluginsdk/ui/banner/BaseBanner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "banner", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "setContext", "screenCastEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ScreenCastEvent;", "destroy", "", "getLayoutId", "", "getOrder", "initialize", "setVisibility", "visibility", "Companion", "plugin-cast_release"})
public final class a
  extends b
{
  public static final a.a tIJ;
  private Context context;
  private View rSI;
  private IListener<ut> tII;
  
  static
  {
    AppMethodBeat.i(190555);
    tIJ = new a.a((byte)0);
    AppMethodBeat.o(190555);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(190553);
    this.context = paramContext;
    if (this.view != null)
    {
      this.rSI = this.view.findViewById(b.d.tIk);
      this.view.setOnClickListener((View.OnClickListener)a.b.tIK);
    }
    setVisibility(8);
    this.tII = ((IListener)new c(this));
    EventCenter.instance.add(this.tII);
    AppMethodBeat.o(190553);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(190543);
    EventCenter.instance.removeListener(this.tII);
    AppMethodBeat.o(190543);
  }
  
  public final int getLayoutId()
  {
    return b.e.tIr;
  }
  
  public final int getOrder()
  {
    return 5;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(190540);
    super.setVisibility(paramInt);
    View localView = this.view.findViewById(b.d.tIk);
    p.j(localView, "layout");
    localView.setVisibility(paramInt);
    AppMethodBeat.o(190540);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/cast/banner/ScreenCastBanner$initialize$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ScreenCastEvent;", "callback", "", "event", "plugin-cast_release"})
  public static final class c
    extends IListener<ut>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.a.a
 * JD-Core Version:    0.7.0.1
 */