package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.report.t;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "closeImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCloseImg", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseImg", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "showExitDialog", "plugin-finder_release"})
public final class b
  extends x
  implements View.OnClickListener
{
  private final Context context;
  public final com.tencent.mm.ui.widget.a.d juf;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  WeImageView sQH;
  
  public b(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramWeImageView, paramd);
    AppMethodBeat.i(204927);
    this.sQH = paramWeImageView;
    this.sQE = paramd;
    this.context = this.sQH.getContext();
    paramWeImageView = new d.a(this.context).afi(2131766378).afl(2131766380);
    paramd = this.context;
    p.g(paramd, "context");
    paramWeImageView = paramWeImageView.afn(paramd.getResources().getColor(2131099804));
    paramd = this.context;
    p.g(paramd, "context");
    this.juf = paramWeImageView.afo(paramd.getResources().getColor(2131100035)).afm(2131766377).d((DialogInterface.OnClickListener)b.a.sQI).c((DialogInterface.OnClickListener)new b(this)).fMb();
    this.sQH.setIconColor(-1);
    AppMethodBeat.o(204927);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204926);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = c.xHa;
    c.NN(3);
    paramView = c.xHa;
    c.NM(3);
    paramView = c.xHa;
    c.NP(this.scene);
    d.b.a(this.sQE, d.c.xGq);
    a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(204926);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(204925);
      paramDialogInterface = t.ssb;
      t.wH(195L);
      paramDialogInterface = this.sQJ.sQH.getContext();
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(204925);
        throw paramDialogInterface;
      }
      ((MMRecordUI)paramDialogInterface).dEB();
      AppMethodBeat.o(204925);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.b
 * JD-Core Version:    0.7.0.1
 */