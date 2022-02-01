package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ListMoreBottomHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmotionListLoadMoreTypeItem;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;)V", "TAG", "", "bgShape", "Landroid/graphics/drawable/Drawable;", "normBgColor", "", "pressBgColor", "radius", "", "getRadius", "()F", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "onBind", "", "dataItem", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "item", "payloads", "", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends e<q>
{
  private final String TAG;
  private final float radius;
  private final TextView titleTv;
  private final int ybv;
  private final int ybw;
  private final Drawable yby;
  
  public m(Context paramContext, View paramView, v paramv)
  {
    super(paramView, (u)paramv);
    AppMethodBeat.i(270683);
    this.TAG = "MicroMsg.EmojiStoreV3ListMoreBottomHolder";
    paramView = paramView.findViewById(h.e.emoji_store_load_bottom_tv);
    s.s(paramView, "itemView.findViewById(R.…oji_store_load_bottom_tv)");
    this.titleTv = ((TextView)paramView);
    this.ybv = com.tencent.mm.cd.a.w(paramContext, h.b.BW_100);
    this.ybw = com.tencent.mm.cd.a.w(paramContext, h.b.BW_0_Alpha_0_0_5);
    this.radius = d.e(paramContext, 8.0F);
    paramContext = com.tencent.mm.plugin.emoji.g.a.ydF;
    this.yby = com.tencent.mm.plugin.emoji.g.a.a(this.ybv, this.ybw, 0.0F, 0.0F, this.radius, this.radius);
    AppMethodBeat.o(270683);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(270690);
    s.u(paramt, "dataItem");
    super.a(paramt);
    a(paramt, (List)new ArrayList());
    AppMethodBeat.o(270690);
  }
  
  public final void a(t paramt, List<Object> paramList)
  {
    Object localObject = null;
    AppMethodBeat.i(270699);
    s.u(paramt, "item");
    s.u(paramList, "payloads");
    super.a(paramt, paramList);
    paramList = this.titleTv;
    paramt = (q)dDb();
    if (paramt == null)
    {
      paramt = null;
      paramList.setText((CharSequence)paramt);
      paramList = this.TAG;
      paramt = (q)dDb();
      if (paramt != null) {
        break label106;
      }
    }
    label106:
    for (paramt = localObject;; paramt = paramt.text)
    {
      Log.d(paramList, s.X("content: ", paramt));
      this.caK.setBackground(this.yby);
      AppMethodBeat.o(270699);
      return;
      paramt = paramt.text;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.m
 * JD-Core Version:    0.7.0.1
 */