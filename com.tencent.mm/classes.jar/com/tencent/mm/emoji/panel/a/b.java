package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class b
  extends k
{
  private final View haA;
  private final View haB;
  private final View haz;
  
  public b(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105630);
    paramn = paramView.findViewById(2131299959);
    p.g(paramn, "itemView.findViewById(R.…ji_capture_status_layout)");
    this.haz = paramn;
    paramn = paramView.findViewById(2131299957);
    p.g(paramn, "itemView.findViewById(R.…oji_capture_loading_view)");
    this.haA = paramn;
    paramView = paramView.findViewById(2131299953);
    p.g(paramView, "itemView.findViewById(R.…oji_capture_failure_view)");
    this.haB = paramView;
    AppMethodBeat.o(105630);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105629);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (h)this.hbh;
    if (paramac != null)
    {
      paramac = paramac.gWm.hRH();
      if (paramac == null)
      {
        this.haz.setVisibility(8);
        AppMethodBeat.o(105629);
        return;
      }
      switch (c.$EnumSwitchMapping$0[paramac.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105629);
        return;
        this.haz.setVisibility(0);
        this.haA.setVisibility(0);
        this.haB.setVisibility(8);
        AppMethodBeat.o(105629);
        return;
        this.haz.setVisibility(0);
        this.haA.setVisibility(8);
        this.haB.setVisibility(0);
      }
    }
    AppMethodBeat.o(105629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.b
 * JD-Core Version:    0.7.0.1
 */