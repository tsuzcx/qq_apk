package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.report.aq;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "closeImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "accessibilityAnchor", "Landroid/view/View;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/view/View;)V", "getAccessibilityAnchor", "()Landroid/view/View;", "setAccessibilityAnchor", "(Landroid/view/View;)V", "getCloseImg", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseImg", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "setVisibility", "visibility", "", "showExitDialog", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends z
  implements View.OnClickListener
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private WeImageView GsS;
  private View GsT;
  private final Context context;
  
  public c(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, View paramView)
  {
    super(paramWeImageView, parama);
    AppMethodBeat.i(335455);
    this.GsS = paramWeImageView;
    this.GrC = parama;
    this.GsT = paramView;
    this.context = this.GsS.getContext();
    this.GsS.setContentDescription((CharSequence)com.tencent.mm.cd.a.bt(this.context, l.i.app_alert_exit));
    AppMethodBeat.o(335455);
  }
  
  private static final void C(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(335467);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(335467);
  }
  
  private static final void a(c paramc, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(335474);
    s.u(paramc, "this$0");
    paramDialogInterface = aq.Fuh;
    aq.pR(195L);
    paramc = paramc.GsS.getContext();
    if (paramc == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
      AppMethodBeat.o(335474);
      throw paramc;
    }
    ((MMRecordUI)paramc).gGB();
    AppMethodBeat.o(335474);
  }
  
  public final void fjO()
  {
    AppMethodBeat.i(335528);
    new e.a(this.context).aEO(l.i.finder_exit_sub_video_tip).aER(l.i.finder_exit_yes_tip).aET(this.context.getResources().getColor(l.b.Red_100)).aEU(this.context.getResources().getColor(l.b.brand_text_color)).aES(l.i.finder_exit_no_tip).d(c..ExternalSyntheticLambda1.INSTANCE).c(new c..ExternalSyntheticLambda0(this)).jHH().show();
    AppMethodBeat.o(335528);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(335504);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agH(3);
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agG(3);
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agJ(getScene());
    a.b.a(this.GrC, a.c.NQu);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(335504);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(335516);
    super.setVisibility(paramInt);
    View localView = this.GsT;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
    this.GsS.setVisibility(paramInt);
    AppMethodBeat.o(335516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.c
 * JD-Core Version:    0.7.0.1
 */