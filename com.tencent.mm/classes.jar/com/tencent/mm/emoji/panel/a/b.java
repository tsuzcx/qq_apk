package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class b
  extends k
{
  private final View gnk;
  private final View gnl;
  private final View gnm;
  
  public b(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105630);
    paramn = paramView.findViewById(2131299347);
    p.g(paramn, "itemView.findViewById(R.…ji_capture_status_layout)");
    this.gnk = paramn;
    paramn = paramView.findViewById(2131299345);
    p.g(paramn, "itemView.findViewById(R.…oji_capture_loading_view)");
    this.gnl = paramn;
    paramView = paramView.findViewById(2131299341);
    p.g(paramView, "itemView.findViewById(R.…oji_capture_failure_view)");
    this.gnm = paramView;
    AppMethodBeat.o(105630);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105629);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (h)this.gnS;
    if (paramac != null)
    {
      paramac = paramac.gjb.gzL();
      if (paramac == null)
      {
        this.gnk.setVisibility(8);
        AppMethodBeat.o(105629);
        return;
      }
      switch (c.cpQ[paramac.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105629);
        return;
        this.gnk.setVisibility(0);
        this.gnl.setVisibility(0);
        this.gnm.setVisibility(8);
        AppMethodBeat.o(105629);
        return;
        this.gnk.setVisibility(0);
        this.gnl.setVisibility(8);
        this.gnm.setVisibility(0);
      }
    }
    AppMethodBeat.o(105629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.b
 * JD-Core Version:    0.7.0.1
 */