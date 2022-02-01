package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "showId", "", "word", "showSearchMore", "", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;IIZ)V", "searchMore", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getSearchMore", "()Landroid/widget/LinearLayout;", "getShowId", "()I", "setShowId", "(I)V", "getShowSearchMore", "()Z", "setShowSearchMore", "(Z)V", "tips", "Landroid/widget/TextView;", "getTips", "()Landroid/widget/TextView;", "getWord", "setWord", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class v
  extends q<m>
{
  private final TextView hbm;
  private final LinearLayout hbn;
  private int hbo;
  private int hbp;
  private boolean hbq;
  
  public v(View paramView, n paramn, int paramInt, boolean paramBoolean)
  {
    super(paramView, paramn);
    AppMethodBeat.i(199979);
    this.hbo = 2131307040;
    this.hbp = paramInt;
    this.hbq = paramBoolean;
    this.hbm = ((TextView)paramView.findViewById(this.hbo));
    this.hbn = ((LinearLayout)paramView.findViewById(2131307408));
    paramView.setOnClickListener(null);
    AppMethodBeat.o(199979);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(199978);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = this.aus;
    if (paramac == null)
    {
      paramac = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(199978);
      throw paramac;
    }
    paramac = ((Iterable)j.mY(0, ((ViewGroup)paramac).getChildCount())).iterator();
    while (paramac.hasNext())
    {
      int i = ((ab)paramac).nextInt();
      localObject = ((ViewGroup)this.aus).getChildAt(i);
      p.g(localObject, "itemView.getChildAt(it)");
      ((View)localObject).setVisibility(8);
    }
    paramac = this.hbm;
    p.g(paramac, "tips");
    Object localObject = this.hbm;
    p.g(localObject, "tips");
    paramac.setText((CharSequence)((TextView)localObject).getContext().getString(this.hbp));
    paramac = this.hbm;
    p.g(paramac, "tips");
    paramac.setVisibility(0);
    if (this.hbq)
    {
      paramac = this.hbn;
      p.g(paramac, "searchMore");
      paramac.setVisibility(0);
      this.hbn.setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(199978);
      return;
    }
    paramac = this.hbn;
    p.g(paramac, "searchMore");
    paramac.setVisibility(8);
    AppMethodBeat.o(199978);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199977);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = this.hbr.hbi;
      if (localObject != null)
      {
        p.g(paramView, "it");
        Context localContext = paramView.getContext();
        p.g(localContext, "it.context");
        ((n)localObject).a(paramView, localContext, this.hbr.lR(), this.hbr.hbh);
      }
      a.a(this, "com/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.v
 * JD-Core Version:    0.7.0.1
 */