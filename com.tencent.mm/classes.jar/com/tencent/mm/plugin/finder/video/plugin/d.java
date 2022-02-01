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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class d
  implements View.OnClickListener, t
{
  private final Context context;
  private final com.tencent.mm.ui.widget.a.d kvo;
  private WeImageView wgX;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  
  public d(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(254478);
    this.wgX = paramWeImageView;
    this.wgr = paramd;
    this.context = this.wgX.getContext();
    this.kvo = new com.tencent.mm.ui.widget.a.d.a(this.context).aoS(2131759664).aoV(2131756033).aoW(2131755917).d((DialogInterface.OnClickListener)new a(this)).c((DialogInterface.OnClickListener)new b(this)).hbn();
    this.wgX.setOnClickListener((View.OnClickListener)this);
    this.kvo.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(254472);
        com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.wgY.wgr, d.c.BUz);
        AppMethodBeat.o(254472);
      }
    });
    AppMethodBeat.o(254478);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(254477);
    com.tencent.mm.ui.widget.a.d locald = this.kvo;
    p.g(locald, "dialog");
    if (locald.isShowing())
    {
      this.kvo.dismiss();
      AppMethodBeat.o(254477);
      return true;
    }
    AppMethodBeat.o(254477);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(254475);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.wgr, d.c.BUy);
    this.kvo.show();
    a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(254475);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(254479);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(254479);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(254476);
    this.wgX.setVisibility(paramInt);
    AppMethodBeat.o(254476);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(d paramd) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(254473);
      paramDialogInterface.dismiss();
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.wgY.wgr, d.c.BUz);
      AppMethodBeat.o(254473);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(d paramd) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(254474);
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.wgY.wgr, d.c.BUA);
      AppMethodBeat.o(254474);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.d
 * JD-Core Version:    0.7.0.1
 */