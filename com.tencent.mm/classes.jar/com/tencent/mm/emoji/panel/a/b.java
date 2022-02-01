package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.storage.emotion.EmojiInfo;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class b
  extends l
{
  private final View jLA;
  private final View jLB;
  private final View jLC;
  
  public b(View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(105630);
    paramp = paramView.findViewById(a.g.emoji_capture_status_layout);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.…ji_capture_status_layout)");
    this.jLA = paramp;
    paramp = paramView.findViewById(a.g.emoji_capture_loading_view);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.…oji_capture_loading_view)");
    this.jLB = paramp;
    paramView = paramView.findViewById(a.g.emoji_capture_failure_view);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.…oji_capture_failure_view)");
    this.jLC = paramView;
    AppMethodBeat.o(105630);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105629);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = (h)this.jMr;
    if (paramae != null)
    {
      paramae = paramae.jHh.hBB();
      if (paramae == null)
      {
        this.jLA.setVisibility(8);
        AppMethodBeat.o(105629);
        return;
      }
      switch (c.$EnumSwitchMapping$0[paramae.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105629);
        return;
        this.jLA.setVisibility(0);
        this.jLB.setVisibility(0);
        this.jLC.setVisibility(8);
        AppMethodBeat.o(105629);
        return;
        this.jLA.setVisibility(0);
        this.jLB.setVisibility(8);
        this.jLC.setVisibility(0);
      }
    }
    AppMethodBeat.o(105629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.b
 * JD-Core Version:    0.7.0.1
 */