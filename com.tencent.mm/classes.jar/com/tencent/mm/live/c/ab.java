package com.tencent.mm.live.c;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "updateBgByUsername", "", "username", "plugin-logic_release"})
public final class ab
  extends a
{
  private final String TAG;
  final b gVv;
  private final View gYh;
  
  public ab(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216113);
    this.gVv = paramb;
    this.TAG = "MicroMsg.LiveKickedPlugin";
    this.gYh = paramViewGroup.findViewById(2131307645);
    this.gYh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216111);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveKickedPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.b.a(this.gYi.gVv, b.c.gUe);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveKickedPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216111);
      }
    });
    AppMethodBeat.o(216113);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  public static final class a
    extends q
    implements d.g.a.b<Bitmap, z>
  {
    public a(ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.ab
 * JD-Core Version:    0.7.0.1
 */