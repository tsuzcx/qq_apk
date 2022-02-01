package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.aq;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "setView", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;)V", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private SubRecordFinishView GsV;
  
  public e(SubRecordFinishView paramSubRecordFinishView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(335477);
    this.GsV = paramSubRecordFinishView;
    this.GrC = parama;
    this.GsV.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(335477);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335529);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(335529);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(335586);
    s.u(this, "this");
    AppMethodBeat.o(335586);
  }
  
  public final String name()
  {
    AppMethodBeat.i(335542);
    String str = v.a.b(this);
    AppMethodBeat.o(335542);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(335572);
    s.u(this, "this");
    AppMethodBeat.o(335572);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(335594);
    s.u(this, "this");
    AppMethodBeat.o(335594);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(335497);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = aq.Fuh;
    aq.pR(190L);
    a.b.a(this.GrC, a.c.NNO);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(335497);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(335610);
    s.u(this, "this");
    AppMethodBeat.o(335610);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(335622);
    s.u(this, "this");
    AppMethodBeat.o(335622);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(335641);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(335641);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(335653);
    s.u(this, "this");
    AppMethodBeat.o(335653);
  }
  
  public final void release()
  {
    AppMethodBeat.i(335667);
    s.u(this, "this");
    AppMethodBeat.o(335667);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(335679);
    s.u(this, "this");
    AppMethodBeat.o(335679);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(335512);
    s.u((v)this, "this");
    this.GsV.setVisibility(paramInt);
    AppMethodBeat.o(335512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.e
 * JD-Core Version:    0.7.0.1
 */