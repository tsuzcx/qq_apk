package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.g;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "showId", "", "word", "showSearchMore", "", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;IIZ)V", "searchMore", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getSearchMore", "()Landroid/widget/LinearLayout;", "getShowId", "()I", "setShowId", "(I)V", "getShowSearchMore", "()Z", "setShowSearchMore", "(Z)V", "tips", "Landroid/widget/TextView;", "getTips", "()Landroid/widget/TextView;", "getWord", "setWord", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends q<m>
{
  private final TextView mlA;
  private final LinearLayout mlB;
  private int mlx;
  private int mly;
  private boolean mlz;
  
  public v(View paramView, n paramn, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramn);
    AppMethodBeat.i(242437);
    this.mlx = paramInt1;
    this.mly = paramInt2;
    this.mlz = paramBoolean;
    this.mlA = ((TextView)paramView.findViewById(this.mlx));
    this.mlB = ((LinearLayout)paramView.findViewById(a.g.search_more));
    paramView.setOnClickListener(null);
    AppMethodBeat.o(242437);
  }
  
  private static final void a(v paramv, View paramView)
  {
    AppMethodBeat.i(242442);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramv);
    ((b)localObject2).cH(paramView);
    a.c("com/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramv, "this$0");
    localObject1 = paramv.aVS();
    if (localObject1 != null)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "it.context");
      ((n)localObject1).a(paramView, (Context)localObject2, paramv.KJ(), paramv.aVT());
    }
    a.a(new Object(), "com/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242442);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(242455);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = ((Iterable)k.qt(0, ((ViewGroup)this.caK).getChildCount())).iterator();
    while (paramae.hasNext())
    {
      int i = ((ah)paramae).Zo();
      ((ViewGroup)this.caK).getChildAt(i).setVisibility(8);
    }
    this.mlA.setText((CharSequence)this.mlA.getContext().getString(this.mly));
    this.mlA.setVisibility(0);
    if (this.mlz)
    {
      this.mlB.setVisibility(0);
      this.mlB.setOnClickListener(new v..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(242455);
      return;
    }
    this.mlB.setVisibility(8);
    AppMethodBeat.o(242455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.v
 * JD-Core Version:    0.7.0.1
 */