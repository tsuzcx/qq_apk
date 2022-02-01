package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "setView", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;)V", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class e
  implements View.OnClickListener, t
{
  private SubRecordFinishView wgZ;
  private d wgr;
  
  public e(SubRecordFinishView paramSubRecordFinishView, d paramd)
  {
    AppMethodBeat.i(254482);
    this.wgZ = paramSubRecordFinishView;
    this.wgr = paramd;
    this.wgZ.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(254482);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(254480);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = y.vih;
    y.Fp(190L);
    d.b.a(this.wgr, d.c.BUx);
    a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(254480);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(254483);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(254483);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(254481);
    this.wgZ.setVisibility(paramInt);
    AppMethodBeat.o(254481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.e
 * JD-Core Version:    0.7.0.1
 */