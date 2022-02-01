package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ListHeaderHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmotionListTextHeaderTypeItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "onBind", "", "dataItem", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "item", "payloads", "", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends e<r>
{
  private final TextView titleTv;
  
  public l(View paramView, v paramv)
  {
    super(paramView, (u)paramv);
    AppMethodBeat.i(270686);
    paramView = paramView.findViewById(h.e.emoji_title);
    s.s(paramView, "itemView.findViewById(R.id.emoji_title)");
    this.titleTv = ((TextView)paramView);
    AppMethodBeat.o(270686);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(270700);
    s.u(paramt, "dataItem");
    super.a(paramt);
    a(paramt, (List)new ArrayList());
    AppMethodBeat.o(270700);
  }
  
  public final void a(t paramt, List<Object> paramList)
  {
    Object localObject = null;
    AppMethodBeat.i(270693);
    s.u(paramt, "item");
    s.u(paramList, "payloads");
    super.a(paramt);
    if ((paramt instanceof r))
    {
      paramt = (r)paramt;
      paramList = this.titleTv;
      if (paramt != null) {
        break label79;
      }
    }
    label79:
    for (paramt = localObject;; paramt = paramt.title)
    {
      paramList.setText((CharSequence)paramt);
      aw.d((Paint)this.titleTv.getPaint());
      AppMethodBeat.o(270693);
      return;
      paramt = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.l
 * JD-Core Version:    0.7.0.1
 */