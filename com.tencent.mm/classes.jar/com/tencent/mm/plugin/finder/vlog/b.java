package com.tencent.mm.plugin.finder.vlog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/EditImageVLogSelectPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "isMultiImage", "", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;ZLcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "currentType", "", "getCurrentType", "()I", "setCurrentType", "(I)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "()Z", "setMultiImage", "(Z)V", "isToEffectVideo", "setToEffectVideo", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "firstSelect", "", "isPreviewImageNow", "isPreviewVLogEffectNow", "isPreviewVLogNormalNow", "onClick", "v", "Landroid/view/View;", "select", "isToVideo", "setVisibility", "visibility", "Companion", "plugin-finder_release"})
public final class b
  implements View.OnClickListener, t
{
  public static final a LkD;
  boolean LkB;
  boolean LkC;
  private final ImageView djK;
  private ViewGroup fSZ;
  int nxe;
  private final TextView ss;
  private d vjo;
  
  static
  {
    AppMethodBeat.i(200649);
    LkD = new a((byte)0);
    AppMethodBeat.o(200649);
  }
  
  public b(ViewGroup paramViewGroup, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(200648);
    this.fSZ = paramViewGroup;
    this.LkC = paramBoolean;
    this.vjo = paramd;
    paramViewGroup = this.fSZ.findViewById(2131307291);
    k.g(paramViewGroup, "parent.findViewById(R.id…_select_content_textview)");
    this.ss = ((TextView)paramViewGroup);
    paramViewGroup = this.fSZ.findViewById(2131307289);
    k.g(paramViewGroup, "parent.findViewById(R.id…log_select_content_image)");
    this.djK = ((ImageView)paramViewGroup);
    this.fSZ.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(200648);
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
    AppMethodBeat.i(200647);
    if (!this.LkB) {}
    for (boolean bool = true;; bool = false)
    {
      yU(bool);
      AppMethodBeat.o(200647);
      return;
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  public final void yU(boolean paramBoolean)
  {
    AppMethodBeat.i(200646);
    this.LkB = paramBoolean;
    int i;
    if (paramBoolean) {
      if (this.LkC)
      {
        this.ss.setText(2131766746);
        this.djK.setImageDrawable(am.i(this.fSZ.getContext(), 2131690458, -1));
        i = 3;
      }
    }
    for (;;)
    {
      this.nxe = i;
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_SELECT_IMAGE_VLOG_SWITCH", this.nxe);
      this.vjo.a(d.c.LoA, localBundle);
      AppMethodBeat.o(200646);
      return;
      this.ss.setText(2131766747);
      this.djK.setImageDrawable(am.i(this.fSZ.getContext(), 2131690494, -1));
      break;
      this.ss.setText(2131766748);
      this.djK.setImageDrawable(am.i(this.fSZ.getContext(), 2131690494, -1));
      if (this.LkC) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/EditImageVLogSelectPlugin$Companion;", "", "()V", "TYPE_ALL_IMAGE", "", "TYPE_EFFECT_VIDEO", "TYPE_NORMAL_VIDEO", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.b
 * JD-Core Version:    0.7.0.1
 */