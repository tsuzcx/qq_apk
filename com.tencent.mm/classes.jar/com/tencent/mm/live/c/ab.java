package com.tencent.mm.live.c;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "updateBgByUsername", "", "username", "plugin-logic_release"})
public final class ab
  extends a
{
  final b IIs;
  private final String TAG;
  private final View qWw;
  
  public ab(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202975);
    this.IIs = paramb;
    this.TAG = "MicroMsg.LiveKickedPlugin";
    this.qWw = paramViewGroup.findViewById(2131307563);
    this.qWw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202973);
        b.b.a(this.KvJ.IIs, b.c.FAX);
        AppMethodBeat.o(202973);
      }
    });
    AppMethodBeat.o(202975);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  public static final class a
    extends d.g.b.l
    implements d.g.a.b<Bitmap, y>
  {
    public a(ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.ab
 * JD-Core Version:    0.7.0.1
 */