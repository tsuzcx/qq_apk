package com.tencent.mm.plugin.finder.vlog;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/MultiHintTextPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "textView", "Landroid/widget/TextView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/TextView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "setVisibility", "", "visibility", "", "plugin-finder_release"})
public final class c
  implements t
{
  private d rTT;
  private TextView tr;
  
  public c(TextView paramTextView, d paramd)
  {
    AppMethodBeat.i(204782);
    this.tr = paramTextView;
    this.rTT = paramd;
    AppMethodBeat.o(204782);
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
    AppMethodBeat.i(204781);
    this.tr.setVisibility(paramInt);
    AppMethodBeat.o(204781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.c
 * JD-Core Version:    0.7.0.1
 */