package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "closeImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCloseImg", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseImg", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "showExitDialog", "plugin-finder_release"})
public final class b
  extends x
  implements View.OnClickListener
{
  WeImageView Ldh;
  private final Context context;
  public final com.tencent.mm.ui.widget.a.d iAV;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  
  public b(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramWeImageView, paramd);
    AppMethodBeat.i(199901);
    this.Ldh = paramWeImageView;
    this.vjo = paramd;
    this.context = this.Ldh.getContext();
    paramWeImageView = new d.a(this.context).aay(2131765451).aaB(2131765453);
    paramd = this.context;
    k.g(paramd, "context");
    paramWeImageView = paramWeImageView.aaD(paramd.getResources().getColor(2131099804));
    paramd = this.context;
    k.g(paramd, "context");
    this.iAV = paramWeImageView.aaE(paramd.getResources().getColor(2131100035)).aaC(2131765450).c((DialogInterface.OnClickListener)a.Ldi).b((DialogInterface.OnClickListener)new b(this)).fft();
    this.Ldh.setIconColor(-1);
    AppMethodBeat.o(199901);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199900);
    ad.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.Kp(3);
    paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.Ko(3);
    paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.Kr(this.scene);
    d.b.a(this.vjo, d.c.LoF);
    AppMethodBeat.o(199900);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    public static final a Ldi;
    
    static
    {
      AppMethodBeat.i(199898);
      Ldi = new a();
      AppMethodBeat.o(199898);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(199897);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(199897);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(199899);
      paramDialogInterface = q.KVK;
      q.BP(195L);
      paramDialogInterface = this.Ldj.Ldh.getContext();
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(199899);
        throw paramDialogInterface;
      }
      ((MMRecordUI)paramDialogInterface).fXY();
      AppMethodBeat.o(199899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.b
 * JD-Core Version:    0.7.0.1
 */