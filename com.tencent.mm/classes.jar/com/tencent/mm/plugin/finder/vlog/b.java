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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/EditImageVLogSelectPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "isMultiImage", "", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;ZLcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "currentType", "", "getCurrentType", "()I", "setCurrentType", "(I)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "()Z", "setMultiImage", "(Z)V", "isToEffectVideo", "setToEffectVideo", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "firstSelect", "", "isPreviewImageNow", "isPreviewVLogEffectNow", "isPreviewVLogNormalNow", "onClick", "v", "Landroid/view/View;", "select", "isToVideo", "setVisibility", "visibility", "Companion", "plugin-finder_release"})
public final class b
  implements View.OnClickListener, t
{
  public static final a sgk;
  private final ImageView dhf;
  private ViewGroup fWU;
  int oae;
  private d rTT;
  boolean sgi;
  boolean sgj;
  private final TextView tr;
  
  static
  {
    AppMethodBeat.i(204780);
    sgk = new a((byte)0);
    AppMethodBeat.o(204780);
  }
  
  public b(ViewGroup paramViewGroup, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(204779);
    this.fWU = paramViewGroup;
    this.sgj = paramBoolean;
    this.rTT = paramd;
    paramViewGroup = this.fWU.findViewById(2131307322);
    k.g(paramViewGroup, "parent.findViewById(R.id…_select_content_textview)");
    this.tr = ((TextView)paramViewGroup);
    paramViewGroup = this.fWU.findViewById(2131307320);
    k.g(paramViewGroup, "parent.findViewById(R.id…log_select_content_image)");
    this.dhf = ((ImageView)paramViewGroup);
    this.fWU.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(204779);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final void mg(boolean paramBoolean)
  {
    AppMethodBeat.i(204777);
    this.sgi = paramBoolean;
    int i;
    if (paramBoolean) {
      if (this.sgj)
      {
        this.tr.setText(2131766784);
        this.dhf.setImageDrawable(am.k(this.fWU.getContext(), 2131690458, -1));
        i = 3;
      }
    }
    for (;;)
    {
      this.oae = i;
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_SELECT_IMAGE_VLOG_SWITCH", this.oae);
      this.rTT.a(d.c.wxr, localBundle);
      AppMethodBeat.o(204777);
      return;
      this.tr.setText(2131766785);
      this.dhf.setImageDrawable(am.k(this.fWU.getContext(), 2131690494, -1));
      break;
      this.tr.setText(2131766786);
      this.dhf.setImageDrawable(am.k(this.fWU.getContext(), 2131690494, -1));
      if (this.sgj) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204778);
    if (!this.sgi) {}
    for (boolean bool = true;; bool = false)
    {
      mg(bool);
      AppMethodBeat.o(204778);
      return;
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/EditImageVLogSelectPlugin$Companion;", "", "()V", "TYPE_ALL_IMAGE", "", "TYPE_EFFECT_VIDEO", "TYPE_NORMAL_VIDEO", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.b
 * JD-Core Version:    0.7.0.1
 */