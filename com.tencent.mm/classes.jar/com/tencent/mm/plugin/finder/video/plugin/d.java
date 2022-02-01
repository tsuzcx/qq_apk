package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.u;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "setView", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;)V", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class d
  implements View.OnClickListener, t
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  private SubRecordFinishView tbX;
  
  public d(SubRecordFinishView paramSubRecordFinishView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(205563);
    this.tbX = paramSubRecordFinishView;
    this.tbP = paramd;
    this.tbX.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(205563);
  }
  
  public final boolean aoQ()
  {
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
    AppMethodBeat.i(205561);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = u.sCl;
    u.wY(190L);
    d.b.a(this.tbP, d.c.xTY);
    a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205561);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(205564);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(205564);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(205562);
    this.tbX.setVisibility(paramInt);
    AppMethodBeat.o(205562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.d
 * JD-Core Version:    0.7.0.1
 */