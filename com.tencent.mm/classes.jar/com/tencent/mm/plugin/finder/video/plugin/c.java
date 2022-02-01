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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class c
  implements View.OnClickListener, t
{
  private final Context context;
  private final com.tencent.mm.ui.widget.a.d iAV;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  private WeImageView vkX;
  
  public c(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(199908);
    this.vkX = paramWeImageView;
    this.vjo = paramd;
    this.context = this.vkX.getContext();
    this.iAV = new d.a(this.context).aay(2131765438).aaB(2131755939).aaC(2131755831).c((DialogInterface.OnClickListener)new a(this)).b((DialogInterface.OnClickListener)new b(this)).fft();
    this.vkX.setOnClickListener((View.OnClickListener)this);
    this.iAV.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(199902);
        d.b.a(this.Ldk.vjo, d.c.Loq);
        AppMethodBeat.o(199902);
      }
    });
    AppMethodBeat.o(199908);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    AppMethodBeat.i(199907);
    com.tencent.mm.ui.widget.a.d locald = this.iAV;
    k.g(locald, "dialog");
    if (locald.isShowing())
    {
      this.iAV.dismiss();
      AppMethodBeat.o(199907);
      return true;
    }
    AppMethodBeat.o(199907);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199905);
    d.b.a(this.vjo, d.c.Lop);
    this.iAV.show();
    AppMethodBeat.o(199905);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(199906);
    this.vkX.setVisibility(paramInt);
    AppMethodBeat.o(199906);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(199903);
      paramDialogInterface.dismiss();
      d.b.a(this.Ldk.vjo, d.c.Loq);
      AppMethodBeat.o(199903);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(199904);
      d.b.a(this.Ldk.vjo, d.c.Lor);
      AppMethodBeat.o(199904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.c
 * JD-Core Version:    0.7.0.1
 */