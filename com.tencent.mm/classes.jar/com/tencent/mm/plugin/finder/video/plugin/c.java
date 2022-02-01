package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class c
  implements View.OnClickListener, t
{
  private final Context context;
  private final com.tencent.mm.ui.widget.a.d juf;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  private WeImageView sQK;
  
  public c(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(204934);
    this.sQK = paramWeImageView;
    this.sQE = paramd;
    this.context = this.sQK.getContext();
    this.juf = new d.a(this.context).afi(2131766237).afl(2131755939).afm(2131755831).d((DialogInterface.OnClickListener)new a(this)).c((DialogInterface.OnClickListener)new b(this)).fMb();
    this.sQK.setOnClickListener((View.OnClickListener)this);
    this.juf.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(204928);
        d.b.a(this.sQL.sQE, d.c.xEf);
        AppMethodBeat.o(204928);
      }
    });
    AppMethodBeat.o(204934);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(204933);
    com.tencent.mm.ui.widget.a.d locald = this.juf;
    p.g(locald, "dialog");
    if (locald.isShowing())
    {
      this.juf.dismiss();
      AppMethodBeat.o(204933);
      return true;
    }
    AppMethodBeat.o(204933);
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204931);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    d.b.a(this.sQE, d.c.xEe);
    this.juf.show();
    a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(204931);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(204935);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(204935);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(204932);
    this.sQK.setVisibility(paramInt);
    AppMethodBeat.o(204932);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(204929);
      paramDialogInterface.dismiss();
      d.b.a(this.sQL.sQE, d.c.xEf);
      AppMethodBeat.o(204929);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(204930);
      d.b.a(this.sQL.sQE, d.c.xEg);
      AppMethodBeat.o(204930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.c
 * JD-Core Version:    0.7.0.1
 */