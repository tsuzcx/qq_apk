package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class c
  implements View.OnClickListener, t
{
  private final Context context;
  private final com.tencent.mm.ui.widget.a.d jaW;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d rTT;
  private WeImageView rTZ;
  
  public c(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(203976);
    this.rTZ = paramWeImageView;
    this.rTT = paramd;
    this.context = this.rTZ.getContext();
    this.jaW = new d.a(this.context).acJ(2131766237).acM(2131755939).acN(2131755831).c((DialogInterface.OnClickListener)new a(this)).b((DialogInterface.OnClickListener)new b(this)).fvp();
    this.rTZ.setOnClickListener((View.OnClickListener)this);
    this.jaW.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(203970);
        d.b.a(this.rUa.rTT, d.c.wvX);
        AppMethodBeat.o(203970);
      }
    });
    AppMethodBeat.o(203976);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(203975);
    com.tencent.mm.ui.widget.a.d locald = this.jaW;
    k.g(locald, "dialog");
    if (locald.isShowing())
    {
      this.jaW.dismiss();
      AppMethodBeat.o(203975);
      return true;
    }
    AppMethodBeat.o(203975);
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203973);
    d.b.a(this.rTT, d.c.wvW);
    this.jaW.show();
    AppMethodBeat.o(203973);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(203974);
    this.rTZ.setVisibility(paramInt);
    AppMethodBeat.o(203974);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(203971);
      paramDialogInterface.dismiss();
      d.b.a(this.rUa.rTT, d.c.wvX);
      AppMethodBeat.o(203971);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(203972);
      d.b.a(this.rUa.rTT, d.c.wvY);
      AppMethodBeat.o(203972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.c
 * JD-Core Version:    0.7.0.1
 */