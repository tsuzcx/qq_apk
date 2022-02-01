package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.ui.widget.a.e;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getDialog", "()Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "dialog$delegate", "Lkotlin/Lazy;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onBackPress", "", "onClick", "", "v", "setVisibility", "visibility", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements View.OnClickListener, v
{
  private final j FiH;
  com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private final Context context;
  private View view;
  
  public d(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(335453);
    this.view = paramView;
    this.GrC = parama;
    this.context = this.view.getContext();
    this.FiH = k.cm((kotlin.g.a.a)new d.a(this));
    this.view.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(335453);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335499);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(335499);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(335523);
    s.u(this, "this");
    AppMethodBeat.o(335523);
  }
  
  public final String name()
  {
    AppMethodBeat.i(335505);
    String str = v.a.b(this);
    AppMethodBeat.o(335505);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(335514);
    s.u(this, "this");
    AppMethodBeat.o(335514);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(335470);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    a.b.a(this.GrC, a.c.NNP);
    ((e)this.FiH.getValue()).show();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(335470);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(335553);
    s.u(this, "this");
    AppMethodBeat.o(335553);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(335561);
    s.u(this, "this");
    AppMethodBeat.o(335561);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(335567);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(335567);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(335578);
    s.u(this, "this");
    AppMethodBeat.o(335578);
  }
  
  public final void release()
  {
    AppMethodBeat.i(335583);
    s.u(this, "this");
    AppMethodBeat.o(335583);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(335591);
    s.u(this, "this");
    AppMethodBeat.o(335591);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(335478);
    s.u((v)this, "this");
    this.view.setVisibility(paramInt);
    AppMethodBeat.o(335478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.d
 * JD-Core Version:    0.7.0.1
 */