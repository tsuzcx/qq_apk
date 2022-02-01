package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class b
  extends k
{
  private final View fPL;
  private final View fPM;
  private final View fPN;
  
  public b(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105630);
    paramn = paramView.findViewById(2131299347);
    d.g.b.k.g(paramn, "itemView.findViewById(R.…ji_capture_status_layout)");
    this.fPL = paramn;
    paramn = paramView.findViewById(2131299345);
    d.g.b.k.g(paramn, "itemView.findViewById(R.…oji_capture_loading_view)");
    this.fPM = paramn;
    paramView = paramView.findViewById(2131299341);
    d.g.b.k.g(paramView, "itemView.findViewById(R.…oji_capture_failure_view)");
    this.fPN = paramView;
    AppMethodBeat.o(105630);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(105629);
    d.g.b.k.h(paramy, "item");
    super.a(paramy);
    paramy = (h)this.fQv;
    if (paramy != null)
    {
      paramy = paramy.fLP.fZV();
      if (paramy == null)
      {
        this.fPL.setVisibility(8);
        AppMethodBeat.o(105629);
        return;
      }
      switch (c.ciE[paramy.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105629);
        return;
        this.fPL.setVisibility(0);
        this.fPM.setVisibility(0);
        this.fPN.setVisibility(8);
        AppMethodBeat.o(105629);
        return;
        this.fPL.setVisibility(0);
        this.fPM.setVisibility(8);
        this.fPN.setVisibility(0);
      }
    }
    AppMethodBeat.o(105629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.b
 * JD-Core Version:    0.7.0.1
 */