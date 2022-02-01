package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.y;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "closeImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCloseImg", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseImg", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "showExitDialog", "plugin-finder_release"})
public final class b
  extends y
  implements View.OnClickListener
{
  private final Context context;
  public final com.tencent.mm.ui.widget.a.d jaW;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d rTT;
  WeImageView rTW;
  
  public b(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramWeImageView, paramd);
    AppMethodBeat.i(203969);
    this.rTW = paramWeImageView;
    this.rTT = paramd;
    this.context = this.rTW.getContext();
    paramWeImageView = new d.a(this.context).acJ(2131766378).acM(2131766380);
    paramd = this.context;
    k.g(paramd, "context");
    paramWeImageView = paramWeImageView.acO(paramd.getResources().getColor(2131099804));
    paramd = this.context;
    k.g(paramd, "context");
    this.jaW = paramWeImageView.acP(paramd.getResources().getColor(2131100035)).acN(2131766377).c((DialogInterface.OnClickListener)b.a.rTX).b((DialogInterface.OnClickListener)new b(this)).fvp();
    this.rTW.setIconColor(-1);
    AppMethodBeat.o(203969);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203968);
    ac.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = c.wyg;
    c.Mo(3);
    paramView = c.wyg;
    c.Mn(3);
    paramView = c.wyg;
    c.Mq(this.scene);
    d.b.a(this.rTT, d.c.wxw);
    AppMethodBeat.o(203968);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(203967);
      paramDialogInterface = o.rAq;
      o.uG(195L);
      paramDialogInterface = this.rTY.rTW.getContext();
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(203967);
        throw paramDialogInterface;
      }
      ((MMRecordUI)paramDialogInterface).due();
      AppMethodBeat.o(203967);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.b
 * JD-Core Version:    0.7.0.1
 */