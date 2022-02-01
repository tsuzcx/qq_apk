package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.ac;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "closeImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCloseImg", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseImg", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "showExitDialog", "plugin-finder_release"})
public final class c
  extends y
  implements View.OnClickListener
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  WeImageView AQI;
  private final Context context;
  
  public c(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramWeImageView, paramd);
    AppMethodBeat.i(291032);
    this.AQI = paramWeImageView;
    this.APl = paramd;
    this.context = this.AQI.getContext();
    this.AQI.setIconColor(com.tencent.mm.ci.a.w(this.context, b.c.video_editor_white_color));
    this.AQI.setContentDescription((CharSequence)com.tencent.mm.ci.a.ba(this.context, b.j.app_alert_exit));
    AppMethodBeat.o(291032);
  }
  
  public final void ehJ()
  {
    AppMethodBeat.i(291029);
    d.a locala = new d.a(this.context).ayg(b.j.finder_exit_sub_video_tip).ayj(b.j.finder_exit_yes_tip);
    Context localContext = this.context;
    p.j(localContext, "context");
    locala = locala.ayl(localContext.getResources().getColor(b.c.Red_100));
    localContext = this.context;
    p.j(localContext, "context");
    locala.aym(localContext.getResources().getColor(b.c.brand_text_color)).ayk(b.j.finder_exit_no_tip).d((DialogInterface.OnClickListener)a.AQJ).c((DialogInterface.OnClickListener)new b(this)).icu().show();
    AppMethodBeat.o(291029);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(291027);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.acr(3);
    paramView = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.acq(3);
    paramView = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.act(getScene());
    d.b.a(this.APl, d.c.HTK);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291027);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    public static final a AQJ;
    
    static
    {
      AppMethodBeat.i(285753);
      AQJ = new a();
      AppMethodBeat.o(285753);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(285752);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(285752);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(291271);
      paramDialogInterface = ac.zZo;
      ac.My(195L);
      paramDialogInterface = this.AQK.AQI.getContext();
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(291271);
        throw paramDialogInterface;
      }
      ((MMRecordUI)paramDialogInterface).fuK();
      AppMethodBeat.o(291271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.c
 * JD-Core Version:    0.7.0.1
 */