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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class c
  implements View.OnClickListener, t
{
  private final Context context;
  private final com.tencent.mm.ui.widget.a.d jxa;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  private WeImageView tbV;
  
  public c(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(205559);
    this.tbV = paramWeImageView;
    this.tbP = paramd;
    this.context = this.tbV.getContext();
    this.jxa = new d.a(this.context).afR(2131766237).afU(2131755939).afV(2131755831).d((DialogInterface.OnClickListener)new a(this)).c((DialogInterface.OnClickListener)new b(this)).fQv();
    this.tbV.setOnClickListener((View.OnClickListener)this);
    this.jxa.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(205553);
        d.b.a(this.tbW.tbP, d.c.xUa);
        AppMethodBeat.o(205553);
      }
    });
    AppMethodBeat.o(205559);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(205558);
    com.tencent.mm.ui.widget.a.d locald = this.jxa;
    p.g(locald, "dialog");
    if (locald.isShowing())
    {
      this.jxa.dismiss();
      AppMethodBeat.o(205558);
      return true;
    }
    AppMethodBeat.o(205558);
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205556);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    d.b.a(this.tbP, d.c.xTZ);
    this.jxa.show();
    a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205556);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(205560);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(205560);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(205557);
    this.tbV.setVisibility(paramInt);
    AppMethodBeat.o(205557);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(205554);
      paramDialogInterface.dismiss();
      d.b.a(this.tbW.tbP, d.c.xUa);
      AppMethodBeat.o(205554);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(205555);
      d.b.a(this.tbW.tbP, d.c.xUb);
      AppMethodBeat.o(205555);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.c
 * JD-Core Version:    0.7.0.1
 */