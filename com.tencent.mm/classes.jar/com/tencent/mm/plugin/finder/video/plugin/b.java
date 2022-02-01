package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.report.u;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "closeImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCloseImg", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseImg", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "showExitDialog", "plugin-finder_release"})
public final class b
  extends x
  implements View.OnClickListener
{
  private final Context context;
  public final com.tencent.mm.ui.widget.a.d jxa;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  WeImageView tbS;
  
  public b(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramWeImageView, paramd);
    AppMethodBeat.i(205552);
    this.tbS = paramWeImageView;
    this.tbP = paramd;
    this.context = this.tbS.getContext();
    paramWeImageView = new d.a(this.context).afR(2131766378).afU(2131766380);
    paramd = this.context;
    p.g(paramd, "context");
    paramWeImageView = paramWeImageView.afW(paramd.getResources().getColor(2131099804));
    paramd = this.context;
    p.g(paramd, "context");
    this.jxa = paramWeImageView.afX(paramd.getResources().getColor(2131100035)).afV(2131766377).d((DialogInterface.OnClickListener)b.a.tbT).c((DialogInterface.OnClickListener)new b(this)).fQv();
    this.tbS.setIconColor(-1);
    AppMethodBeat.o(205552);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205551);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = c.xWV;
    c.Ot(3);
    paramView = c.xWV;
    c.Os(3);
    paramView = c.xWV;
    c.Ov(this.scene);
    d.b.a(this.tbP, d.c.xWl);
    a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205551);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(205550);
      paramDialogInterface = u.sCl;
      u.wY(195L);
      paramDialogInterface = this.tbU.tbS.getContext();
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(205550);
        throw paramDialogInterface;
      }
      ((MMRecordUI)paramDialogInterface).dHS();
      AppMethodBeat.o(205550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.b
 * JD-Core Version:    0.7.0.1
 */