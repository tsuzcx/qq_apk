package com.tencent.mm.plugin.finder.video.plugin.subvideo;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import d.g.a.b;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/subvideo/FinderRecordTypePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableSubRecord", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "setView", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "isSubVideoRecord", "setVisibility", "", "visibility", "", "plugin-finder_release"})
public final class a
  implements t
{
  private final Context context;
  d rTT;
  public boolean rUh;
  private RecordTypeSelectView rUi;
  
  public a(RecordTypeSelectView paramRecordTypeSelectView, d paramd)
  {
    AppMethodBeat.i(203992);
    this.rUi = paramRecordTypeSelectView;
    this.rTT = paramd;
    this.context = this.rUi.getContext();
    paramRecordTypeSelectView = new ArrayList();
    paramRecordTypeSelectView.add(com.tencent.mm.cc.a.aw(this.context, 2131766782));
    paramRecordTypeSelectView.add(com.tencent.mm.cc.a.aw(this.context, 2131766781));
    this.rUi.setData(paramRecordTypeSelectView);
    this.rUi.setSelectChangeListener((b)new a.1(this));
    AppMethodBeat.o(203992);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(203991);
    this.rUi.setVisibility(paramInt);
    AppMethodBeat.o(203991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.subvideo.a
 * JD-Core Version:    0.7.0.1
 */