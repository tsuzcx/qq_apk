package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "closeImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCloseImg", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseImg", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "showExitDialog", "plugin-finder_release"})
public final class c
  extends x
  implements View.OnClickListener
{
  private final Context context;
  public final com.tencent.mm.ui.widget.a.d kvo;
  WeImageView wgU;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  
  public c(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramWeImageView, paramd);
    AppMethodBeat.i(254471);
    this.wgU = paramWeImageView;
    this.wgr = paramd;
    this.context = this.wgU.getContext();
    paramWeImageView = new d.a(this.context).aoS(2131759685).aoV(2131759686);
    paramd = this.context;
    p.g(paramd, "context");
    paramWeImageView = paramWeImageView.aoX(paramd.getResources().getColor(2131099819));
    paramd = this.context;
    p.g(paramd, "context");
    this.kvo = paramWeImageView.aoY(paramd.getResources().getColor(2131100063)).aoW(2131759684).d((DialogInterface.OnClickListener)c.a.wgV).c((DialogInterface.OnClickListener)new b(this)).hbn();
    this.wgU.setIconColor(com.tencent.mm.cb.a.n(this.context, 2131101307));
    AppMethodBeat.o(254471);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(254470);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.VI(3);
    paramView = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.VH(3);
    paramView = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.VK(this.scene);
    d.b.a(this.wgr, d.c.BWW);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(254470);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(254469);
      paramDialogInterface = y.vih;
      y.Fp(195L);
      paramDialogInterface = this.wgW.wgU.getContext();
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(254469);
        throw paramDialogInterface;
      }
      ((MMRecordUI)paramDialogInterface).eIF();
      AppMethodBeat.o(254469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.c
 * JD-Core Version:    0.7.0.1
 */