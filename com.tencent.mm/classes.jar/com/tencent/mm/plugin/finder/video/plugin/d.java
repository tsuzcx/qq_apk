package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "setView", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;)V", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class d
  implements View.OnClickListener, t
{
  private SubRecordFinishView Ldl;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  
  public d(SubRecordFinishView paramSubRecordFinishView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(199911);
    this.Ldl = paramSubRecordFinishView;
    this.vjo = paramd;
    this.Ldl.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(199911);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199909);
    paramView = q.KVK;
    q.BP(190L);
    d.b.a(this.vjo, d.c.Loo);
    AppMethodBeat.o(199909);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(199910);
    this.Ldl.setVisibility(paramInt);
    AppMethodBeat.o(199910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.d
 * JD-Core Version:    0.7.0.1
 */