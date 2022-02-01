package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends j
{
  private final View mkI;
  private final View mkJ;
  private final View mkK;
  
  public b(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105630);
    paramn = paramView.findViewById(a.g.emoji_capture_status_layout);
    s.s(paramn, "itemView.findViewById(R.…ji_capture_status_layout)");
    this.mkI = paramn;
    paramn = paramView.findViewById(a.g.emoji_capture_loading_view);
    s.s(paramn, "itemView.findViewById(R.…oji_capture_loading_view)");
    this.mkJ = paramn;
    paramView = paramView.findViewById(a.g.emoji_capture_failure_view);
    s.s(paramView, "itemView.findViewById(R.…oji_capture_failure_view)");
    this.mkK = paramView;
    AppMethodBeat.o(105630);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105629);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = (h)aVT();
    int i;
    if (paramae != null)
    {
      paramae = paramae.mgK.kMj();
      if (paramae != null) {
        break label90;
      }
      i = -1;
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(105629);
      return;
      label90:
      i = a.$EnumSwitchMapping$0[paramae.ordinal()];
      break;
      this.mkI.setVisibility(8);
      AppMethodBeat.o(105629);
      return;
      this.mkI.setVisibility(0);
      this.mkJ.setVisibility(0);
      this.mkK.setVisibility(8);
      AppMethodBeat.o(105629);
      return;
      this.mkI.setVisibility(0);
      this.mkJ.setVisibility(8);
      this.mkK.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.b
 * JD-Core Version:    0.7.0.1
 */