package com.tencent.mm.plugin.finder.video.plugin.subvideo;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/subvideo/FinderRecordTypePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableSubRecord", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "setView", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "isSubVideoRecord", "setVisibility", "", "visibility", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements v
{
  com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private RecordTypeSelectView Gtj;
  public boolean Gtk;
  private final Context context;
  
  public a(RecordTypeSelectView paramRecordTypeSelectView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(335658);
    this.Gtj = paramRecordTypeSelectView;
    this.GrC = parama;
    this.context = this.Gtj.getContext();
    paramRecordTypeSelectView = new ArrayList();
    paramRecordTypeSelectView.add(com.tencent.mm.cd.a.bt(this.context, l.i.record_type_normal));
    paramRecordTypeSelectView.add(com.tencent.mm.cd.a.bt(this.context, l.i.record_type_multiple));
    this.Gtj.setData(paramRecordTypeSelectView);
    this.Gtj.setSelectChangeListener((b)new a.1(this));
    AppMethodBeat.o(335658);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335676);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(335676);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(335696);
    s.u(this, "this");
    AppMethodBeat.o(335696);
  }
  
  public final String name()
  {
    AppMethodBeat.i(335684);
    String str = v.a.b(this);
    AppMethodBeat.o(335684);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(335692);
    s.u(this, "this");
    AppMethodBeat.o(335692);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(335702);
    s.u(this, "this");
    AppMethodBeat.o(335702);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(335711);
    s.u(this, "this");
    AppMethodBeat.o(335711);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(335721);
    s.u(this, "this");
    AppMethodBeat.o(335721);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(335729);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(335729);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(335735);
    s.u(this, "this");
    AppMethodBeat.o(335735);
  }
  
  public final void release()
  {
    AppMethodBeat.i(335741);
    s.u(this, "this");
    AppMethodBeat.o(335741);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(335747);
    s.u(this, "this");
    AppMethodBeat.o(335747);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(335671);
    s.u((v)this, "this");
    if (paramInt == 0)
    {
      com.tencent.mm.ui.anim.d.a.kZ((View)this.Gtj);
      AppMethodBeat.o(335671);
      return;
    }
    com.tencent.mm.ui.anim.d.a.la((View)this.Gtj);
    AppMethodBeat.o(335671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.subvideo.a
 * JD-Core Version:    0.7.0.1
 */